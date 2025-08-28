//Criar um programa que contenha um array de 5 elementos inteiros, leia o array e imprima o endereço das posições com valores pares.
#include <stdio.h>

int main(){
    int array[5] = {1,2,3,4,5};
    int *ptrarray = array;

    for(int i = 0;i<5;i++){
        if(*(ptrarray + i) % 2 == 0){
            
            printf("%p\n", ptrarray);

        }
        
    }

    return 0;
}