
// Escrever um programa que declare um inteiro, um real e um char, com ponteiros para cada tipo. 
// Associar as variáveis aos ponteiros, modificar os valores usando os ponteiros e imprimir os valores antes e depois da modificação.

#include <stdio.h>

int main(){
    int X =10;
    float Y = 20;
    char L = 'b';

    int *ptrX = &X;
    float *ptrY = &Y;
    char *ptrL = &L;

    printf("Antes da motificacao: ");
    printf("\nVariavel X: %d", *ptrX );
    printf("\nVariavel Y: %f", *ptrY );
    printf("\nVariavel L: %c", *ptrL );

    *ptrX = 50;
    *ptrY = 30.9;
    *ptrL = 'c';

    printf("\n\nDepois da motificacao: ");
    printf("\nVariavel X: %d", *ptrX );
    printf("\nVariavel Y: %f", *ptrY );
    printf("\nVariavel L: %c", *ptrL );


    



    return 0;
}