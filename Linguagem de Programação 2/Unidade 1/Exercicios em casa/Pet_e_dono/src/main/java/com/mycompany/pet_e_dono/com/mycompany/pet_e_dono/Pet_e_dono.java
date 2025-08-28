package com.mycompany.pet_e_dono;

import com.mycompany.pet_e_dono.com.mycompany.pet_e_dono.Dono;

public class Pet_e_dono {

    public static void main(String[] args) {
        Dono d1 = new Dono("Julio", 71982830);
        Pet p1 = new Pet("Junior", "cachorro", d1);
        
        p1.mostrarDono();
        p1.morder();
        
        p1.morder();
        p1.morder();
        
        d1.mostrarMordidas();
        
        
    }
}
