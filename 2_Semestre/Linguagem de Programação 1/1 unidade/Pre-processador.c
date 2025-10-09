//Definindo e usando macros
#include <stdio.h>
#define quadrado(x) (x*x)
#define DEBUG


int main(){
    int num, result;

    printf("Digite seu numero: ");
    scanf("%d", &num);

    result= quadrado(num);

    printf("o quadrado de %d e %d", num, result);

    return 0;
}