#include <stdio.h>
#include <stdlib.h>

// As maçãs custam R$ 0,30 cada se forem compradas menos do que uma dúzia, e R$ 0,25 se forem compradas pelo menos doze. 
// Escreva um programa que leia o número de maçãs compradas, calcule e escreva o valor total da compra. 

int main(){
    int frut;
    float total;

   printf("bem vindos a loja de frutas Frut\n");
   printf("Responda conforme for pedido ok?\n");
   printf("Quantas frutas o usuario comprou?\n");
   printf("Digite aqui: ");
   scanf("%d", &frut);
   
   if(frut < 12){
    total= 0.30*frut;
    printf("\nO total da sua compra foi de %.2f", total);

   } else if(frut>=12){
      total=0.25*frut;
      printf("\nO total da sua compra foi de %.2f", total);
   
   }
   




    return 0;
}
