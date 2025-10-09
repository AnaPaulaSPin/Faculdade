#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int Maisproximo(int *arr,int tamanho, int n){
    int Diferenca;
    int elementM = arr[0];
    int tempdif = n - arr[0];
    for(int i = 1; i < tamanho;i++){
        Diferenca = n - arr[i];
        if(Diferenca <= tempdif){
            tempdif = Diferenca;
            elementM = arr[i];
        }

    }


    return elementM;

}

int main(){
    int array[] = {1,2,3,4,5};
    int elementoM = Maisproximo(array,5,9);

    printf("%d", elementoM);

}