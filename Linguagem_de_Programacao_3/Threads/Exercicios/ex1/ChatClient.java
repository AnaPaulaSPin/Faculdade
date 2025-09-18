import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
public class ChatClient {
    /* Defini o host e a porta */
    private static final String HOST = "localhost"; 
    private static final int PORT = 12345;

    public static void main(String[] args) {
        /* Imprimi mostrando o host e porta da cliente */
        System.out.println("Conectando em " + HOST + ":" + PORT + "...");
        System.out.print("Digite seu nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        byte[] nomeByte = nome.getBytes();

        try (
            /* Cria um socket para o cliente */
            Socket socket = new Socket(HOST, PORT);
            BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));  /* dispositvo que le converte byte em string que vem do servidor */
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true); /* dispositvo que le a mensagem em string e converte em byte */
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in)) /* Dispositivo que le a mensagem do teclado e converte em string */
            
        ) {
            serverOut.println(nome);
            AtomicBoolean running = new AtomicBoolean(true); /* assunto novo  */
            // Thread para ler mensagens do servidor
            Thread reader = new Thread(() -> {
                try {
                    String line;
                    while ((line = serverIn.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    // servidor pode fechar; encerrar leitor
                } finally {
                    running.set(false);
                }
            });
            reader.start();
            // Loop de envio (stdin -> servidor)
            String userLine;
            while (running.get() && (userLine = userIn.readLine()) != null) {
                // TODO [Aluno]: enviar a linha ao servidor
                serverOut.println(userLine);
                if ("exit".equalsIgnoreCase(userLine.trim())) {
                    break;
                }
            }
            // encerrar conexão
            try { reader.join(500); } catch (InterruptedException ignore) {}
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
