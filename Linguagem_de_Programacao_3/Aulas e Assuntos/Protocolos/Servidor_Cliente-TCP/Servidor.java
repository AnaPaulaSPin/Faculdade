// Pacote do projeto (se estiver usando pacotes)
// package com.mycompany.primeira_aula;

import java.io.ObjectOutputStream; // Para enviar objetos ao cliente
import java.net.ServerSocket;      // Para criar o servidor que escuta conexões
import java.net.Socket;            // Para representar a conexão com cada cliente
import java.util.Date;             // Para enviar a data atual como exemplo

public class Servidor {
    public static void main(String[] args) {
        try {
            // 1️⃣ Criar o servidor e abrir a porta 1234
            ServerSocket servidor = new ServerSocket(1234);
            System.out.println("Servidor ouvindo a porta 1234...");

            // 2️⃣ Loop infinito para aceitar vários clientes
            while (true) {
                System.out.println("Aguardando conexão do cliente...");

                // 3️⃣ Aceitar a conexão de um cliente
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

                // 4️⃣ Criar stream para enviar dados para o cliente
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush(); // Garante que o buffer seja enviado imediatamente

                // 5️⃣ Enviar a data atual para o cliente
                saida.writeObject(new Date());
                System.out.println("Data enviada com sucesso!");

                // 6️⃣ Fechar streams e socket do cliente
                saida.close();
                cliente.close();
                System.out.println("Conexão encerrada com o cliente.\n");
            }
        } catch (Exception e) {
            // Captura qualquer erro que acontecer no servidor
            System.out.println("Erro no servidor:");
            e.printStackTrace(); // Mostra detalhes do erro
        }
    }
}
