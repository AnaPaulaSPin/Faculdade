// Escrever um programa que leia dois valores inteiros e chame uma função que receba esses valores e 
// retorne o maior na primeira variável e o menor na segunda, imprimindo os valores.

#include <stdio.h>

void troca( int *ptrX, int *ptrY){
    int numX = *ptrX;

    if(*ptrX <= *ptrY){

        *ptrX = *ptrY;
        *ptrY = numX;  
    }
    
   
}

int main(){
    int X = 0;
    int Y = 0;
    int *ptrX = &X;
    int *ptrY = &Y;

     printf("insira um valor da variavel X: ");
     scanf("%d", &*ptrX);

     printf("\ninsira um valor da variavel Y: ");
     scanf("%d", &*ptrY);


    troca(&X,&Y);


    printf( "Maior Variavel: %d \n Menor Variavel: %d", *ptrX, *ptrY);

    return 0;
}
