//Desenvolver um programa que leia três valores inteiros e chame uma função para ordená-los 
// (menor valor na primeira posição, médio na segunda, e maior na última),
// retornando 1 se os valores forem iguais e 0 caso contrário. Exibir os valores ordenados.
// EU VOU ME MATAR BAGULHO DIFICIL DOS QUINTOS DOS INFERNOS Obs:28/10

#include <stdio.h>

void trio_ordenado(int *ptrArray, int num){
  

}

int main(void){
    int array[3];
    int *ptrArray = array;

    for(int i=0; i<3;i++){
        printf("Digite o %d numero: ", i);
        scanf("%d", &*(ptrArray+i));
    }

   
      trio_ordenado(array,3);

     for(int i=0;i<3;i++){

      printf("%d\n", *(ptrArray+i));

     }
     


}

