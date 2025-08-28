#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int soma_comuns(int *arr1,int *arr2, int tamanho1, int tamanho2){
    int soma = 0;
    for(int i = 1; i < tamanho1;i++){
        for(int j = 0; j < tamanho2;j++){
            if(arr1[i]==arr2[j]){
                soma = soma + arr1[i];
                break;

            }
          }
        }



    return soma;

}

int main(){
    int array[] = {1,2,3,4,5};
    int array1[] = {9,8,3,4,7};
    int elementoM = soma_comuns(array,array1,5,5);

    printf("%d", elementoM);

}