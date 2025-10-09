//Fazer um programa que contenha um array de inteiros com 5 elementos, 
//leia esse array do teclado usando aritmética de ponteiros e imprima o dobro de cada valor lido.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <stdbool.h>

int main(){
    int array[10] = {1,2,3,4,5};
    int *ptrArray = array;

    for(int i = 0;i<5;i++){
        printf("Digite o %d elemento: ", i);
        scanf("%d",& *(ptrArray+i));

    }
     system("clear || cls"); // Limpa a tela

    for(int i= 0; i<5;i++){
        printf("%d\n", *(ptrArray+i)*2);

    }



    return 0;
}