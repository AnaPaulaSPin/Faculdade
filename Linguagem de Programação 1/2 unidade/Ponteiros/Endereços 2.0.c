// Escrever um programa que contenha duas variáveis inteiras, leia essas variáveis do teclado, 
// compare seus endereços e exiba o conteúdo do maior endereço.

//Criar um programa que contenha duas variáveis inteiras, compare seus endereços e exiba o maior.

#include <stdio.h>

int main(){
    int X = 0,Y = 0;

  int *ptrX = &X;
  int *ptrY = &Y;

  printf("insira um valor da variavel X: ");
  scanf("%d", &*ptrX);

  printf("\ninsira um valor da variavel Y: ");
  scanf("%d", &*ptrY);


  if(ptrX >= ptrY){
    printf("\nEndereco maior e %d", ptrX);

  } else {
     printf("\nEndereco maior e %d", ptrY);

  }


    return 0;
}