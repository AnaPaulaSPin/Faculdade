/*
 Faça um programa em C que receba do usuário a quantidade N de números
a ser digitada. Em seguida, o programa deve alocar dinamicamente um vetor de N
inteiros, receber N números do usuário e armazenar no vetor, e mostrar o maior valor do
vetor, o menor valor do vetor e a média dos valores. 
*/
#include <stdio.h>
#include <stdlib.h>

int EleM(int *ptr, int n){
    int maior = 0;
     for(int i = 0; i< n; i++){
        if(maior < *(ptr+i)){
            maior = *(ptr+i); 
        }
     }
    return maior;
    
}

int EleMenor(int *ptr, int n){
    int menor = *ptr;  // Inicializa com o primeiro elemento
    
     for(int i = 1; i< n; i++){
        if(menor > *(ptr+i)){
            menor = *(ptr+i); 
        }
     }
    return menor;
}

int MediaEle(int *ptr, int n){
    int media = 0;
    for( int i = 0; i < n; i++){
        media = media + *(ptr+i);
    }
    media /= n;

    return media;

}

int main(){
    int n;
    printf("Digite quantos numeros seu vetor tera: ");
    scanf("%d", &n);

    int *ptr = (int*) malloc(n * sizeof(int)); 

    for(int i = 0 ; i < n ; i++){
        printf("Preenchar o valor da %d posicao: ", i);
        scanf("%d", ptr+i);
    }

    int maior = EleM(ptr,n);
    printf("\nO maior elemento do vetor e: %d", maior);

    int menor = EleMenor(ptr,n);
    printf("\nA O menor elemento do vetor e: %d", menor);

    int media = MediaEle(ptr,n);
    printf("\nA media do vetor e: %d", media);

    return 0;
}