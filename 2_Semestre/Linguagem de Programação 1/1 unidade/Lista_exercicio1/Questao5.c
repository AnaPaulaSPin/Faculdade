#include <stdio.h>


int main(){
    int num,i;
    float fat;

    printf("Digite o numero: ");
    scanf("%d", &num);

    fat=num;

    for(i=1;i<=num;i++){
        fat= fat*i;
    }

    printf("O fatorial desse numero e: %.1f", fat);
}