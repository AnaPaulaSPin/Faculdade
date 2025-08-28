// Escrever uma função que receba um array e um valor do mesmo tipo do array, preenchendo o array com esse valor, 
// usando apenas aritmética de ponteiros.

#include <stdio.h>

void array(int *ptrArray, int x){

    for(int i=0;i<5;i++){
        *(ptrArray+i) = x;
    }

}

int main(){
    int array1[5];

    array(array1,9);

    for(int i=0;i<5;i++){
        printf("\n%d", array1[i]);
    }


}
