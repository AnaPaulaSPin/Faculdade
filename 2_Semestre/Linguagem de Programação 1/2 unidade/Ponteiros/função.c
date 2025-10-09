// Desenvolver um programa que contenha uma função que receba 
// dois números inteiros (A e B), some-os e armazene o resultado em A. Imprimir A e B na função principal.

#include <stdio.h>

void funcao(int *ptrX, int *ptrY){

    *ptrX += *ptrY;

}

int main(){
    int X = 30;
    int Y = 90;
    int *ptrX = &X;
    int *ptrY = &Y;

    funcao(&X,&Y);

    printf("Valor de X: %d \n valor de Y: %d", *ptrX, *ptrY);

    return 0;
}