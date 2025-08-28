/* Questão 5) Faça um programa em C que aloque dinamicamente uma matriz de inteiros
de dimensões definidas pelo usuário e a leia. Em seguida, implemente uma função que
receba um valor, retorne 1 caso o valor esteja na matriz ou retorne 0 caso o valor não
esteja na matriz. */

#include <stdio.h>
#include <stdlib.h>

int EleMatriz(int **matriz, int num, int lin, int col){
    for(int i = 0; i < lin; i++){
        for(int j = 0; j < col; j++){
            if(matriz[i][j]== num){
                return 1;
            }
        }
    }
    return 0;


}

int main(void){
    int col,lin;
    int num;
    printf("Digite uma quantidade de linha e colunas: ");
    scanf("%d %d", &lin, &col);

    int **matriz = (int**) malloc(lin * sizeof(int*));
    for(int i=0;i<lin;i++){
        matriz[i] = (int*) malloc (col * sizeof(int));
    }
    printf("Digite o valores dos elemtos da matriz: \n");
    for(int i =0; i<lin;i++){
        for(int j = 0; j<col;j++){
            printf("Linha %d e numero %d: ", i,j);
            scanf("%d", &matriz[i][j]);
        }
        printf("\n");
    }

    printf("Digite um numero: ");
    scanf("%d", &num);

    int result = EleMatriz(matriz,num, lin,col);

    if(result == 1){
        printf("Numero %d foi encontrado na matriz", num);
    } else{
        printf("Numero %d foi encontrado na matriz", num);
    }
    for(int i =0;i<lin;i++){
        free(matriz[i]);
    }
    free(matriz);


}