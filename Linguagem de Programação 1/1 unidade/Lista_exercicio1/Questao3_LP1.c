#include <stdio.h>

// Escreva um programa em C que leia um número inteiro e exiba todos os números ímpares de 1 até esse número.
int main(){
    int num1, resto,i;

     printf("Digite um numero: ");
      scanf("%d", &num1);


     i=num1;
     while(i>=1){
         resto = i % 2;
         
         if(resto == 1){
             printf("%d\n", i);
         }

      i--;    
     }

     return 0;
}
