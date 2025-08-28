#include <stdio.h>


void somaElementos(int *ptr, int tamanho) {
    int soma = 0;

    for(int i=0;i<tamanho;i++){
       soma += *(ptr + i);

    }
    printf("%d",soma);

}

int main(){
    int soma[]= {1,2,3,4,5,7,8,9,10};

    somaElementos(&soma[2],7);

    
}