//Escrever um programa que contenha um array de float com 10 elementos e imprima o endereço de cada posição.

#include <stdio.h>

int main(){
    float array[10] = {1,2,3,4,5,6,7,8,9,10};
    float *ptrArry = array;

    for(int i=0;i<10;i++){
        // %p vc usa para ve endereços.
        system("clear || cls"); // Limpa a tela
        printf("%p\n", ptrArry+i );

    }

    return 0;
}