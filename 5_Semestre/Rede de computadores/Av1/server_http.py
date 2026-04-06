import socket
from urllib.parse import urlparse, parse_qs

HOST = '127.0.0.1'
PORT = 8080

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST, PORT))
server.listen(1)

dados = [
    {"id": "1", "nome": "Ana", "idade": "20"},
    {"id": "2", "nome": "Carlos", "idade": "25"},
    {"id": "3", "nome": "Maria", "idade": "30"}
]

print(f"Servidor rodando em http://{HOST}:{PORT}")

while True:
    client, addr = server.accept()
    print(f"\nConexão de {addr}")

    request = client.recv(4096).decode()
    print(request)

    # separa header e body
    parts = request.split("\r\n\r\n")
    header = parts[0]
    body = parts[1] if len(parts) > 1 else ""

    method, path, _ = header.split("\n")[0].split()

    # ========================
    # 🔹 GET
    # ========================
    if method == "GET":
        parsed = urlparse(path)
        params = parse_qs(parsed.query)

        # Lógica de busca
        resultado_html = ""

        if "id" in params:
            id_busca = params["id"][0]

            encontrado = None
            for pessoa in dados:
                if pessoa["id"] == id_busca:
                    encontrado = pessoa
                    break

            if encontrado:
                resultado_html = f"""
                <div class="result success">
                    <p><strong>ID:</strong> {encontrado['id']}</p>
                    <p><strong>Nome:</strong> {encontrado['nome']}</p>
                    <p><strong>Idade:</strong> {encontrado['idade']}</p>
                </div>
                """
            else:
                resultado_html = """
                <div class="result error">
                    <p>Nenhum resultado encontrado</p>
                </div>
                """
        else:
            resultado_html = """
            <div class="result info">
                <p>Digite um ID para buscar (ex: ?id=1)</p>
            </div>
            """

        #  HTML
        response_body = f"""
        <html>
        <head>
            <title>Busca de Usuarios</title>
            <style>
                body {{
                    font-family: Arial, sans-serif;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 100vh;
                    margin: 0;
                }}

                .container {{
                    background: white;
                    padding: 30px;
                    border-radius: 12px;
                    box-shadow: 0 6px 15px rgba(0,0,0,0.2);
                    width: 350px;
                    text-align: center;
                }}

                h1 {{
                    color: #333;
                }}

                input {{
                    width: 100%;
                    padding: 8px;
                    margin: 10px 0;
                    border-radius: 6px;
                    border: 1px solid #ccc;
                }}

                button {{
                    width: 100%;
                    padding: 10px;
                    background: #6c63ff;
                    color: white;
                    border: none;
                    border-radius: 6px;
                    cursor: pointer;
                }}

                .result {{
                    margin-top: 15px;
                    padding: 10px;
                    border-radius: 6px;
                    text-align: left;
                }}

                .success {{
                    background: #e6f4ea;
                    border-left: 4px solid #28a745;
                }}

                .error {{
                    background: #fdecea;
                    border-left: 4px solid #dc3545;
                }}

                .info {{
                    background: #e7f3ff;
                    border-left: 4px solid #007bff;
                }}
            </style>
        </head>

        <body>
            <div class="container">
                <h1>Buscar Usuario</h1>

                {resultado_html}

                <form method="GET">
                    <input name="id" placeholder="Digite o ID (ex: 1)">
                    <button type="submit">Buscar</button>
                </form>

                <h2>Adicionar (POST)</h2>

                <form method="POST">
                    <input name="nome" placeholder="Nome">
                    <input name="idade" placeholder="Idade">
                    <button type="submit">Cadastrar</button>
                </form>
            </div>
        </body>
        </html>
        """

    # ========================
    # 🔹 POST
    # ========================
    elif method == "POST":
        params = parse_qs(body)

        nome = params.get("nome", ["Não informado"])[0]
        idade = params.get("idade", ["Não informado"])[0]

        # gerar novo ID
        novo_id = str(len(dados) + 1)

    # adicionar na lista
        dados.append({
        "id": novo_id,
        "nome": nome,
        "idade": idade
         })

        response_body = f"""
        <html>
        <body style="font-family: Arial; display:flex; justify-content:center; align-items:center; height:100vh;">
            <div style="background:white; padding:30px; border-radius:10px;">
                <h1>POST recebido</h1>
                <p><strong>Nome:</strong> {nome}</p>
                <p><strong>Idade:</strong> {idade}</p>
                <a href="/">Voltar</a>
            </div>
        </body>
        </html>
        """

    else:
        response_body = "<h1>Método nao suportado</h1>"

    response = "HTTP/1.1 200 OK\r\n"
    response += "Content-Type: text/html\r\n\r\n"
    response += response_body

    client.sendall(response.encode())
    client.close()