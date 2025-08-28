// Criar um programa que leia dois valores inteiros e chame uma função que retorne a soma do dobro desses valores, 
//armazenando o dobro de A em A e o dobro de B em B.

#include <stdio.h>

void dobro(int *ptrX, int *ptrY){

    *ptrX *= 2;
    *ptrY *= 2;

}

int main(){
    int X =0; int Y = 0;

    int *ptrX = &X;
    int *ptrY = &Y;

    printf("Digite um valor para variavel X: ");
    scanf("%d", &*ptrX);

    printf("Digite um valor para variavel Y: ");
    scanf("%d", &*ptrY);
    
    dobro(&X,&Y);

    printf("\nValores das variaveis depois de dobradas: \n Variavel X: %d \n Variavel Y: %d", *ptrX, *ptrY);



    return 0;
}