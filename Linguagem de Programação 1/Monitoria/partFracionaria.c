#include <stdio.h>

void frac(float num, int *partInteira, int *partFracionaria){
    *partInteira = num;

    float n = num - *partInteira;
    n*=100;
    *partFracionaria = n;

}

int main(){
    float num;
    int partFr, partInt;

    printf("Digite um numero float: ");
    scanf("%f", &num);

    frac(num ,&partInt, &partFr);

    printf("Parte inteira do numero: %d", partInt);
    printf("\nParte fracionaria do numero: %d", partFr);

    return 0;
}