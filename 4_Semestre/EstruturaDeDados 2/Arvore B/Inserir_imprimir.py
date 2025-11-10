# ========================================
# CLASSE DO NÓ DA ÁRVORE B
# ========================================
class NoB:
    def __init__(self, eh_folha=True):
        self.chaves = []      # Lista de chaves armazenadas no nó (valores ordenados)
        self.filhos = []      # Lista de filhos (outros nós da árvore)
        self.eh_folha = eh_folha  # Indica se o nó é folha (sem filhos)

# ========================================
# CLASSE PRINCIPAL DA ÁRVORE B
# ========================================
class ArvoreB:
    def __init__(self, ordem):
        self.raiz = NoB(eh_folha=True)
        self.ordem = ordem   # número mínimo de chaves que define a capacidade do nó

    # ----------------------------------------
    # Função principal de inserção
    # ----------------------------------------
    def inserir(self, chave):
        no_raiz = self.raiz

        # Se o nó raiz estiver cheio, precisamos dividir antes de inserir
        if len(no_raiz.chaves) == (2 * self.ordem) - 1:
            novo_no_raiz = NoB(eh_folha=False)  # cria nova raiz
            novo_no_raiz.filhos.append(no_raiz)  # antiga raiz vira filha da nova
            self.dividir_no(novo_no_raiz, 0)     # divide o antigo nó cheio
            self.raiz = novo_no_raiz             # atualiza a nova raiz
            self.inserir_nao_cheio(self.raiz, chave)
        else:
            self.inserir_nao_cheio(no_raiz, chave)

    # ----------------------------------------
    # Inserir em nó que ainda NÃO está cheio
    # ----------------------------------------
    def inserir_nao_cheio(self, no, chave):
        i = len(no.chaves) - 1  # começa comparando do final (última chave)

        # Caso 1: nó é folha (não tem filhos)
        if no.eh_folha:
            # Cria espaço para inserir a nova chave no lugar certo
            no.chaves.append(None)
            while i >= 0 and chave < no.chaves[i]:
                no.chaves[i + 1] = no.chaves[i]
                i -= 1
            no.chaves[i + 1] = chave

        # Caso 2: nó interno (tem filhos)
        else:
            # Acha o filho correto para descer a chave
            while i >= 0 and chave < no.chaves[i]:
                i -= 1
            i += 1

            # Se o filho escolhido estiver cheio, divide ele primeiro
            if len(no.filhos[i].chaves) == (2 * self.ordem) - 1:
                self.dividir_no(no, i)
                if chave > no.chaves[i]:
                    i += 1  # a chave deve ir pro filho à direita
            self.inserir_nao_cheio(no.filhos[i], chave)

    # ----------------------------------------
    # Divide um nó cheio em dois
    # ----------------------------------------
    def dividir_no(self, no_pai, indice_filho):
        ordem = self.ordem
        no_cheio = no_pai.filhos[indice_filho]      # nó que vai ser dividido
        novo_no = NoB(eh_folha=no_cheio.eh_folha)   # novo nó à direita

        # A chave do meio sobe para o nó pai
        chave_do_meio = no_cheio.chaves[ordem - 1]
        no_pai.chaves.insert(indice_filho, chave_do_meio)

        # Divide as chaves do nó cheio
        novo_no.chaves = no_cheio.chaves[ordem:]        # chaves da direita
        no_cheio.chaves = no_cheio.chaves[:ordem - 1]   # chaves da esquerda

        # Se o nó tinha filhos, também precisamos dividir os filhos
        if not no_cheio.eh_folha:
            novo_no.filhos = no_cheio.filhos[ordem:]
            no_cheio.filhos = no_cheio.filhos[:ordem]

        # Liga o novo nó à lista de filhos do pai
        no_pai.filhos.insert(indice_filho + 1, novo_no)

    # ----------------------------------------
    # Impressão da árvore (em níveis)
    # ----------------------------------------
    def imprimir(self, no=None, nivel=0):
        if no is None:
            no = self.raiz
        print("   " * nivel + str(no.chaves))  # imprime as chaves do nó atual
        for filho in no.filhos:
            self.imprimir(filho, nivel + 1)
