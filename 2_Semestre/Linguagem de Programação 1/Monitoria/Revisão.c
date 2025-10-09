// Dado dois vetores de inteiros e seus respectivos tamanhos retorne quantos elementos aparecem em ambos os vetores

#include <stdio.h>

int vetor(int array1[], int tam1, int array2[], int tam2){
    int ocorrencias = 0; int k = 0;



    for(int i = 0; i < tam1; i++){
        for(int j = 0; j < tam2; j++){
            
            if(array1[i] == array2[j]){
                ocorrencias++;

            }
        }
    }
    return ocorrencias;

}

int main(){
    int array[]={1,2,3,4,5,6};
    int array2[]={2,4,6};

   int ocorrencias = vetor(array,6,array2,3);
    printf("\nO numeros de correncias e de: %d", ocorrencias);
}

