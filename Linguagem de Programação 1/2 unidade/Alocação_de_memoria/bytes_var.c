// Crie um programa em C que declare variáveis dos tipos int, float, double, char e uma struct chamada Aluno com os campos nome 
// (array de 50 caracteres), matricula (int) e nota (float). 
// Use o operador sizeof para imprimir o tamanho de cada tipo de dado, o tamanho da struct Aluno, e o tamanho de cada um de seus campos.
#include <stdio.h>
#include <string.h>

int main(void){
    int x = 0;
    float y =0 ;
    double R = 0;
    char C= 'r';

    typedef struct 
    {
       char nome[50];
       int matricula;
       float nota;
    } alunos;

    alunos aluno;

    strcpy(aluno.nome, "Alice");
    aluno.matricula = 112973873;
    aluno.nota = 7.5;
        

    printf("Uma variavel do tipo inteiro ocupa: %lu bytes", sizeof(x));
    printf("\nUma variavel do tipo float ocupa: %lu bytes", sizeof(y));
    printf("\nUma variavel do tipo double ocupa: %lu bytes", sizeof(R));
    printf("\nUma variavel do tipo char ocupa: %lu bytes", sizeof(C));

    printf("\n\nUma variavel do tipo struct char ocupa: %lu bytes", sizeof(aluno.nome));
    printf("\nUma variavel do tipo struct inteiro ocupa: %lu bytes", sizeof(aluno.matricula));
    printf("\nUma variavel do tipo struct float ocupa: %lu bytes", sizeof(aluno.nota));
    

    
    
}