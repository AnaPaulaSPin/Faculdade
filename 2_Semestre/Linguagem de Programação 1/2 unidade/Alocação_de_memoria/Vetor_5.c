//Escreva uma função que tem um parâmetro inteiro com nome x de entrada. Aloque um vetor de inteiros com 5 vezes o tamanho. 
// Inicialize o vetor com um valor diferente de zero.

#include <stdio.h>
#include <stdlib.h>

int * Aloque(int *X){
    *X = *X * 5;

    int *array = (int *) malloc(*X * sizeof(int));

    for(int i = 0;i<*X;i++){
        *(array+i)=i+1;

    }
    return array;
}

int main(){
    int X;
    printf("Digite um numero: ");
    scanf("%d", &X);

    int *array = Aloque(&X);

    for(int i = 0;i < X; i++){
        printf("%d\n", *(array+i));

    }
    free(array);
    return 0;

}