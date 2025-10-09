//Criar um programa que contenha duas variáveis inteiras, compare seus endereços e exiba o maior.

#include <stdio.h>

int main(){
    int X = 0,Y = 0;

  int *ptrX = &X;
  int *ptrY = &Y;

  if(ptrX >= ptrY){
    printf("\nEndereco maior e %d", ptrX);

  } else {
     printf("\nEndereco maior e %d", ptrY);

  }


    return 0;
}