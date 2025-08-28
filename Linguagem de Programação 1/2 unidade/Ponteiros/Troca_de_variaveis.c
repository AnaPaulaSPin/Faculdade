//Fazer um programa que leia 2 valores inteiros e chame uma função que troque o conteúdo das variáveis passadas (A e B) 
// para que A receba o valor de B e vice-versa.

#include <stdio.h>

void troca( int *ptrX, int *ptrY){
    int numX = *ptrX;
    *ptrX = *ptrY;
    *ptrY = numX;
}

int main(){
    int X = 0;
    int Y = 0;
    int *ptrX = &X;
    int *ptrY = &Y;

    printf("insira um valor da variavel X: ");
    scanf("%d", &*ptrX);

    printf("\n insira um valor da variavel Y: ");
    scanf("%d", &*ptrY);

    printf("\n valores antes da troca: ");
    printf( "Variavel X: %d \n Variavel Y: %d", *ptrX, *ptrY);

    troca(&X,&Y);


    printf("\n\nValores depois da troca: ");
    printf( "\nVariavel X: %d \n Variavel Y: %d", *ptrX, *ptrY);

    return 0;
}
