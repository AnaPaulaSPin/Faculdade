/*- [ ]  **Exercicio 2:** Crie um programa que:
    - [ ]  a) Aloque dinamicamente um vetor de 5 números inteiros
    - [ ]  b) Peça para o usuário digitar os 5 números no espaço alocado
    - [ ]  c) Mostre na tela os 5 números
    - [ ]  d) Libere a memória alocada.
*/
#include <stdio.h>
#include <stdlib.h>

int main(){ 

    int *array = (int *) malloc(5*sizeof(int));

    printf("Digite 5 numeros: ");

    for(int i=0;i<5;i++){
        scanf("%i", array+i);
    }

    for(int i = 0;i<5;i++){
        printf("%d\n", *(array+i));
    }

    free(array);

    return 0;
}