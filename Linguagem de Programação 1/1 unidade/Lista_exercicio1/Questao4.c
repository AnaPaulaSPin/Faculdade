#include <stdio.h>

int num,resto;

int main(){
    printf("Digite um numero: ");
    scanf("%d", &num);
    resto = num % 2;

    if(resto==0){
     printf("este numero e par");
    } else if(resto == 1){
        printf("este numero e impar");
    }
    
}