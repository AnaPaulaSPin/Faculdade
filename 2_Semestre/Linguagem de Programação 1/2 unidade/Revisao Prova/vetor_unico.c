// Crie uma função que receba dois vetores de inteiros e retorne um vetor com os elementos que estão no primeiro vetor, mas não no segundo.
#include <stdio.h>
#include <stdlib.h>
#define max 10

int* vetor(int array1[], int tam1, int array2[], int tam2, int *cont){
    int arraytemp[max], j, encontrada = 0;

    for(int i = 0; i < tam1;i++){
        for(j = 0;j < tam2;j++){
            if (array1[i] == array2[j]){
                encontrada = 1;
                break;
            }
        }
        if(encontrada != 1){
            arraytemp[*cont] = array1[i];
            *cont = *cont+1;          
        }
        encontrada = 0; //inicializar sempre com 0
    }

    int *ptr = (int*) malloc(*cont * sizeof(int));

    for(int i = 0; i<*cont;i++){
        *(ptr+i) = arraytemp[i];
    }

    return ptr;

}

int main(){
    int array[]={1,2,3,4,5,6};
    int array2[]={2,4,6};
    int cont = 0;

   int *ptr = vetor(array, 6, array2,3, &cont);

   for(int i = 0; i < cont; i++){
    printf("%d\t", *(ptr+i));

   }
    
}
