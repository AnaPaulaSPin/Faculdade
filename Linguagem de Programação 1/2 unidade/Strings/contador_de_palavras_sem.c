/*
   Contar o número de palavras em uma string (sem a biblioteca)
*/

#include <stdio.h>

int main(){
    int palavra = 0; int i;
    char frase[]="Eu gosto de programacao";

    for(i = 0; frase[i] != '\0'; i++){
        if(frase[i]==' '){
            palavra++;
        }
    }
    palavra += 1; // conta a ultima ´palavra da frase

    printf("%s\n", frase);
    printf("%d palavras", palavra);
    printf("\nA frase possui um total de %d", i);
}