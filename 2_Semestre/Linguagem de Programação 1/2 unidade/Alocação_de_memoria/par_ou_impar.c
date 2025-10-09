// Faça um programa que leia do usuário o tamanho de um vetor (inteiros) a ser lido e faça a sua alocação dinâmica de memória. 
// Depois, leia do usuário seus valores e imprima o vetor lido e mostre quantos dos números são pares e quantos são ımpares.

#include <stdio.h>
#include <stdlib.h>

int main(){
   int X;
   int par = 0;
   int impar = 0;
   printf("Digite o tamanho do seu vetor: ");
   scanf("%d", &X);

   int *array = (int*) malloc(X*sizeof(int));

   for(int i = 0 ; i < X ; i++){
    printf("Digite o numero: %d: ", i);
    scanf("%d", array+i);

    if(*(array+i) % 2 == 0){
       par++;

    } else{
        impar++;
    }

   }
   printf("\n\nVetores Digitados: ");
   for(int i = 0; i< X; i++){
    printf("%d  ", *(array+i));
   }
   printf("\nNumeros que sao par:%d\n", par);
   printf("Numeros que sao impar:%d", impar);

   free(array);
   return 0;

}