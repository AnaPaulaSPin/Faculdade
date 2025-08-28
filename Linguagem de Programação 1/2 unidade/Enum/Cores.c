#include <stdio.h>

enum paleta{
    vermelho,
    amarelo,
    verde,
    azul
};

int main(){
    enum paleta cor;
   
   cor = azul;

    switch(cor){

        case 0:{
            printf("vermelho");
        }
        case 1:{
            printf("amarelo");
        }
        case 2:{
            printf("verde");
        }
        case 3:{
            printf("azul");
        }
    }


    return 0;
}