/*
Faça um programa em C que receba do usuário o tamanho de uma string e
chame uma função para alocar dinamicamente essa string. Em seguida o usuário deverá
informar o conteúdo dessa string e o programa deve imprimir a string sem suas vogais.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void vogais(char *string){
    char vogais[] = "aeiouAEIOU";

    for(int i = 0; *(string + i) != '\0'; i++){
        if(strchr(vogais, *(string+i))){
            *(string + i) = '0';
        }


    }

}

int main(void){
    int n;
    printf("Digite o numero da sua string: ");
    scanf("%d", &n);

    char *string = (char*) malloc(n * sizeof(char));

    printf("Digite sua string: ");
    scanf("%s", string);

    vogais(string);
    for(int i = 0; *(string + i) != '\0';i++){
        if(*(string+i)!= '0'){
            printf("%c", *(string+i) );
        }
    }

}