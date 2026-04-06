import java.io.*;
import java.net.*;
import java.util.*;

public class server {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Servidor rodando em http://localhost:" + port);

        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("\nConexão recebida: " + client.getInetAddress());
            handleRequest(client);
        }
    }

    private static void handleRequest(Socket client) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            OutputStream out = client.getOutputStream()
        ) {

            String requestLine = in.readLine();

            if (requestLine == null || requestLine.isEmpty()) {
                client.close();
                return;
            }

            System.out.println("Request: " + requestLine);

            StringTokenizer tokenizer = new StringTokenizer(requestLine);
            String method = tokenizer.nextToken();
            String path = tokenizer.nextToken();

            Map<String, String> headers = new HashMap<>();
            String line;
            int contentLength = 0;

            while (!(line = in.readLine()).isEmpty()) {
                String[] header = line.split(": ");
                if (header.length == 2) {
                    headers.put(header[0], header[1]);

                    if (header[0].equalsIgnoreCase("Content-Length")) {
                        contentLength = Integer.parseInt(header[1]);
                    }
                }
            }

            char[] bodyChars = new char[contentLength];
            if (contentLength > 0) {
                in.read(bodyChars, 0, contentLength);
            }
            String body = new String(bodyChars);

            System.out.println("Método: " + method);
            System.out.println("Path: " + path);
            System.out.println("Body: " + body);

            String responseBody;

            if (method.equals("GET")) {
                responseBody = handleGet(path);
            } else if (method.equals("POST")) {
                responseBody = handlePost(path, body);
            } else {
                responseBody = "<h1>405 - Método não permitido</h1>";
            }

            String response =
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "\r\n" +
                    responseBody;

            out.write(response.getBytes());
            out.flush();

            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ======================
    // GET (Página inicial)
    // ======================
    private static String handleGet(String path) {
        if (path.equals("/")) {
            return """
                <html>
                <head>
                    <title>Cadastro</title>
                    <style>
                        body {
                            font-family: Arial;
                            text-align: center;
                            margin-top: 50px;
                            background-color: #f4f4f4;
                        }
                        form {
                            background: white;
                            padding: 20px;
                            display: inline-block;
                            border-radius: 10px;
                            box-shadow: 0 0 10px rgba(0,0,0,0.1);
                        }
                        input {
                            padding: 8px;
                            margin: 5px;
                            width: 200px;
                        }
                        button {
                            padding: 10px;
                            background-color: #4CAF50;
                            color: white;
                            border: none;
                            border-radius: 5px;
                            cursor: pointer;
                        }
                        button:hover {
                            background-color: #45a049;
                        }
                    </style>
                </head>
                <body>
                    <h1>Cadastro de Usuário</h1>

                    <form action="/usuarios" method="POST">
                        <input type="text" name="nome" placeholder="Nome"><br>
                        <input type="text" name="curso" placeholder="Curso"><br>
                        <button type="submit">Enviar</button>
                    </form>
                </body>
                </html>
            """;
        }

        return "<h1>404 - Página não encontrada</h1>";
    }

    // ======================
    // POST (Processa dados)
    // ======================
    private static String handlePost(String path, String body) {
    if (path.equals("/usuarios")) {

        Map<String, String> params = parseFormData(body);

        String nome = params.getOrDefault("nome", "Não informado");
        String curso = params.getOrDefault("curso", "Não informado");

        return "<html>" +
               "<head><title>Resultado</title></head>" +
               "<body style='font-family: Arial; text-align:center; margin-top:50px;'>" +
               "<h1>Usuário Recebido</h1>" +

               "<p><strong>Nome:</strong> " + nome + "</p>" +
               "<p><strong>Curso:</strong> " + curso + "</p>" +

               "<br>" +
               "<a href='/'>Voltar</a>" +

               "</body>" +
               "</html>";
    }

    return "<h1>404 - Não encontrado</h1>";
}

    // ======================
    // Parser de dados POST
    // ======================
    private static Map<String, String> parseFormData(String body) {
        Map<String, String> params = new HashMap<>();

        String[] pairs = body.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                params.put(keyValue[0], decode(keyValue[1]));
            }
        }

        return params;
    }

    private static String decode(String value) {
        return URLDecoder.decode(value, java.nio.charset.StandardCharsets.UTF_8);
    }
}