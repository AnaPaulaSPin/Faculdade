from pathlib import Path

import numpy as np
import ollama
from pypdf import PdfReader
import time


# ============================================================
# FUNÇÃO PARA FORMATAR O TEMPO
# ============================================================

def formatar_tempo(segundos):
    if segundos < 60:
        return f"{segundos:.2f} segundos"

    minutos = int(segundos // 60)
    segundos_restantes = segundos % 60

    if minutos == 1:
        return f"1 minuto e {segundos_restantes:.2f} segundos"

    return f"{minutos} minutos e {segundos_restantes:.2f} segundos"


# ============================================================
# 1. LEITURA DO DOCUMENTO
# ============================================================

caminho_pdf = (
    Path(__file__).parent
    / "documentos"
    / "manual-tecnico-para-o-diagnostico-da-sifilis.pdf"
)

leitor = PdfReader(caminho_pdf)

print("Quantidade de páginas:", len(leitor.pages))


# ============================================================
# 2. EXTRAÇÃO DO TEXTO
# ============================================================

texto = ""

for pagina in leitor.pages:
    texto += pagina.extract_text() or ""

print("Quantidade de caracteres:", len(texto))


# ============================================================
# 3. DIVISÃO DO TEXTO EM CHUNKS
# ============================================================

tamanho_chunk = 2000

chunks = []

for inicio_chunk in range(0, len(texto), tamanho_chunk):
    chunk = texto[inicio_chunk:inicio_chunk + tamanho_chunk]
    chunks.append(chunk)

print("Quantidade de chunks:", len(chunks))


# ============================================================
# 4. GERAÇÃO DOS EMBEDDINGS DOS CHUNKS
# ============================================================

MODELO_EMBEDDING = "nomic-embed-text"

chunks_com_embeddings = []

inicio_embeddings = time.time()

for chunk in chunks:

    resposta = ollama.embed(
        model=MODELO_EMBEDDING,
        input=chunk
    )

    vetor = resposta["embeddings"][0]

    chunks_com_embeddings.append({
        "texto": chunk,
        "embedding": vetor
    })

fim_embeddings = time.time()

tempo_embeddings = fim_embeddings - inicio_embeddings

print("Embeddings gerados:", len(chunks_com_embeddings))
print(
    "Tempo para gerar os embeddings:",
    formatar_tempo(tempo_embeddings)
)


# ============================================================
# 5. PERGUNTA DO USUÁRIO
# ============================================================

pergunta = input("\nVocê: ")


# ============================================================
# 6. EMBEDDING DA PERGUNTA
# ============================================================

inicio_embedding_pergunta = time.time()

resposta_pergunta = ollama.embed(
    model=MODELO_EMBEDDING,
    input=pergunta
)

vetor_pergunta = resposta_pergunta["embeddings"][0]

fim_embedding_pergunta = time.time()

tempo_embedding_pergunta = (
    fim_embedding_pergunta - inicio_embedding_pergunta
)

print(
    "Tempo para gerar o embedding da pergunta:",
    formatar_tempo(tempo_embedding_pergunta)
)


# ============================================================
# 7. COMPARAÇÃO DE SIMILARIDADE
# ============================================================

def calcular_similaridade(vetor_a, vetor_b):
    vetor_a = np.array(vetor_a)
    vetor_b = np.array(vetor_b)

    return np.dot(vetor_a, vetor_b) / (
        np.linalg.norm(vetor_a) * np.linalg.norm(vetor_b)
    )


resultados = []

for item in chunks_com_embeddings:

    similaridade = calcular_similaridade(
        vetor_pergunta,
        item["embedding"]
    )

    resultados.append({
        "texto": item["texto"],
        "similaridade": similaridade
    })


# ============================================================
# 8. SELEÇÃO DOS CHUNKS MAIS RELEVANTES
# ============================================================

resultados.sort(
    key=lambda resultado: resultado["similaridade"],
    reverse=True
)

quantidade_chunks = 3

chunks_relevantes = resultados[:quantidade_chunks]


# ============================================================
# 9. MONTAGEM DO CONTEXTO
# ============================================================

contexto = "\n\n".join(
    resultado["texto"]
    for resultado in chunks_relevantes
)


# ============================================================
# 10. ENVIO DA PERGUNTA + CONTEXTO PARA O DEEPSEEK
# ============================================================

SYSTEM_PROMPT = """
Você é um assistente especializado em informações sobre sífilis.

Utilize o contexto fornecido como fonte principal para responder às perguntas.

A partir das informações encontradas no contexto, explique o assunto
de forma clara, organizada e fácil de compreender, sem inventar
informações que não estejam presentes na fonte.

Você pode resumir, relacionar e reorganizar as informações do contexto
para construir uma explicação adequada à pergunta do usuário.

Se o contexto não possuir informações suficientes para responder,
informe claramente que não foi encontrada informação suficiente
no documento.
"""


inicio_resposta = time.time()

resposta_final = ollama.chat(
    model="deepseek-r1",
    messages=[
        {
            "role": "system",
            "content": SYSTEM_PROMPT
        },
        {
            "role": "user",
            "content": f"""
Contexto retirado do documento:

{contexto}

Pergunta:

{pergunta}
"""
        }
    ]
)

fim_resposta = time.time()

tempo_resposta = fim_resposta - inicio_resposta


# ============================================================
# 11. EXIBIÇÃO DA RESPOSTA
# ============================================================

print(
    "\nTempo para gerar a resposta:",
    formatar_tempo(tempo_resposta)
)

print("\nResposta:")
print(resposta_final["message"]["content"])