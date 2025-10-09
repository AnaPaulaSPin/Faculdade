package com.mycompany.celular;

public class Celular {
    public static void main(String[] args) {
        Empresa apple = new Empresa("Apple");
        
        Usuario user1 = new Usuario("Ana", "askf", 2005);
        Usuario user2 = new Usuario("Gabi", "KAs", 2007);
        Usuario user3 = new Usuario("Sarah", "1235", 2010);
        
        apple.addUsers(user1);
        apple.addUsers(user2);
        apple.addUsers(user3);
        
        Aplicativos app1 = new Aplicativos("Whatzap", "Mandar mensagem", 50);
        Aplicativos app2 = new Aplicativos("Mensager", "Mandar mensagem", 60, 20);
        Aplicativos app3 = new Aplicativos("Instagram", "Postar fotinhaa", 50);
        
        apple.addApps(app3);
        apple.addApps(app1);
        apple.addApps(app2);
        
        // usuarios comprando um app
        user1.addApps(app1); // comprou um app gratis
        app1.addUsers(user1);
        boolean teste = apple.reduzConta(user1); // ele deveria retornar falso porque ja temos o app mais barato!
        
        System.out.println(teste);
        
        user2.addApps(app2);
        app2.addUsers(user2);
        
        user2.addApps(app1); 
        app2.addUsers(user1);
        
        teste = apple.reduzConta(user2); // ele deveria retornar falso porque ja temos o app mais barato!
        
        System.out.println(teste);
        
        String app = apple.maisUsers();
        System.out.println(app);
        
    }
}
