/*
  Fazer uma função fatores que:
a. Recebe 3 parâmetros: um vetor de inteiros, um número inteiro n passado por
valor e outro número x passado como ponteiro.
b. Retorna um número inteiro.
c. Decompõe o número n em fatores primos
d. e armazena-os nas posições do vetor até um limite de 10. 
e. O conteúdo de x deve receber o número de fatores primos encontrados. 
f. Caso o número de fatores encontrados seja maior que 10, a função deve retornar 1 e o vetor deve receber somente até o décimo fator primo,
g. do contrário deve retornar 0.
*/


#include <stdio.h>

int FatoralPrimo(int array[], int n, int *ptr){
    int divisor = 2;
    int i=0;
    while(divisor <= n){
        while(n % divisor == 0){
            array[i] = divisor;
            n /= divisor;
            i++; 
            *ptr = *ptr + 1;

        }
    divisor++;

    }
     if(i < 10){
        return 1;
    }
}

    int main(void){
    int n;
    int array[10];
    int QutFat=0;

    printf("Digite um numero: ");
    scanf("%d", &n);

    int resultado = FatoralPrimo(array,n,&QutFat);

    printf("Numero fatores: ");

    for(int i=0;i < QutFat;i++){

        printf("%d  ", array[i]);
    }
    printf("\nRetornou: %d", resultado);
    printf("\nQuantos numeros foram usados: %d ", QutFat);

}

