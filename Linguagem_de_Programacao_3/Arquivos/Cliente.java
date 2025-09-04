import java.io.*;
import java.net.*;



public class Cliente {
    public static void main(String[] args) {
        String caminhoArquivo = 'Caminho_arquivos'

        try {
            System.out.println("Tentando conectar ao servidor...");
            Socket cliente = new Socket("127.0.0.1", 1234);
            System.out.println("Conectado ao servidor!");

            File arquivo = new File(caminhoArquivo);
                        byte[] buffer = new byte[4096];
            
                        FileInputStream fileIn = new FileInputStream(arquivo);
                        OutputStream out = cliente.getOutputStream();
            
                        int bytesLidos;
                        while ((bytesLidos = fileIn.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesLidos);
                        }
            
                        System.out.println("Arquivo enviado com sucesso!");
            
                        fileIn.close();

            out.close();
            cliente.close();
            System.out.println("Conexão encerrada");

        } catch (Exception e) {
            System.out.println("Erro no cliente:");
            e.printStackTrace();
        }
    }
}
