import java.io.*;
import java.net.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {

private static final int PORT = 12345; // * definindo a porta

    private static final List<PrintWriter> clients = new CopyOnWriteArrayList<>(); /*criando uma lista para armazenar usuarios que entrarem no chat */

    public static void main(String[] args) {
        System.out.println("[Servidor] Ouvindo na porta  " + PORT + "..."); /*Imprimindo a porta */

        // tentando criar uma conexão
        try (ServerSocket server = new ServerSocket(PORT)) {
            /*servidor sempre estara em busca de novas conexões */
            while (true) {
                Socket socket = server.accept(); /* Fica em estado de espera ate receber uma conexão(do servidor) nova */
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            System.err.println("[Servidor] Erro: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private PrintWriter user; //usuario que entrara no chat

        ClientHandler(Socket socket) {
            this.socket = socket; 
        }

        @Override public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
                user = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                

                // 1) registrar cliente
                clients.add(user); // lista de usuarios conectados para enviar num broadcast
                String nameUser = in.readLine(); // nome do usuario
                System.out.println("Usuario: "+nameUser +" acabou de conectar");

                // 2) dar boas-vindas
                user.println("Bem-vindo! Digite mensagens. Use 'exit' para sair.");
                String msg = nameUser + " entrou no chat";
                broadcastTodos(msg);
                // broadcast(msg, user);

                // 3) laço principal de leitura
                String line;
                while ((line = in.readLine()) != null) {
                    // TODO [Aluno]: se a linha for "exit", encerrar este cliente graciosamente (remover da lista e fechar socket).
                      if(line.equals("exit")){
                        clients.remove(user);
                        System.out.println("Usuario" + nameUser+ "saiu do chat");
                        socket.close();
                       }

                    if ("exit".equalsIgnoreCase(line.trim())) {
                        user.println("Você saiu do chat. Até logo!");
                        broadcast("[" +nameUser + "]:" + "saiu do chat!", user);
                        break;
                    }

                    // TODO [Aluno]: fazer broadcast da mensagem para TODOS os outros clientes.
                       broadcast("[" +nameUser + "]:" + line, user);
                     
                }
            } catch (IOException e) {
                // queda de cliente é comum; logar e seguir
                System.out.println("Cliente desconectou: " + e.getMessage());
            } finally {
                // 4) garantir limpeza
                // TODO [Aluno]: remover o PrintWriter deste cliente de 'clients'
                try { socket.close(); } catch (IOException ignore) {}
            }
        }

        private void broadcast(String msg, PrintWriter sender) {
            // TODO [Aluno]: enviar 'msg' para todos em 'clients'.
            for (PrintWriter pw : clients) {
                if (pw != sender) {
                    pw.println(msg);
                }
            }
        }

        private void broadcastTodos(String msg) {

            for (PrintWriter pw : clients) {
                    pw.println(msg);
                
            }
        }
    }
}
