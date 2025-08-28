#include <stdio.h>

int main() {
    int i, V[10];

    printf("Digite o numero do vetor: ");
    for(i=0;i<10;i++)
     scanf("%d", &V[i]);
     
    for(i=9;i>=0;i--)
        printf("\n%d", V[i]);
    

    return 0;
}