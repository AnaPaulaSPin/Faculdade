/* Questão 6) Crie um programa em C que declare uma estrutura (registro) para o cadastro
de alunos, no qual:
    • Deverão ser armazenados para cada aluno: matrícula, sobrenome (apenas um), e ano de nascimento;
    • Ao início do programa, o usuário deverá informar o número de alunos que serão armazenados;
    • O programa deverá alocar dinamicamente a quantidade necessária de memória para armazenar os registros dos alunos;
    • O programa deverá pedir ao usuário que entre com as informações dos alunos;
    • Ao final, mostrar os dados armazenados e liberar a memória alocada.
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int matricula;
    char sobrenome[50];
    char nascimento[10];    
} aluno;

int main(void){
    int n;
    printf("Digite quantos alunos voce deseja registrar: ");
    scanf("%d", &n);
     getchar();

    aluno *alunos = (aluno*) malloc(n * sizeof(aluno));

    printf("Registrando os alunos...");
    getchar();

    for(int i = 0; i < n;i++){
        printf("\nMatricula do %d aluno: ", i+1);
        scanf("%d", &alunos->matricula);

        printf("\nSobrenome do %d aluno: ", i+1);
        scanf("%s", alunos->sobrenome);

        printf("\nNascimento do %d aluno: ", i+1);
        scanf("%s", alunos->nascimento);
    }

     getchar();

    printf("Imprimindo os dados dos alunos...");
    getchar();

    for(int i = 0; i < n; i++){
        printf("\n%d Aluno: \n", i+1);
        printf("Sobrenome: %s", alunos->sobrenome);

        printf("\nMatricula: %d", alunos->matricula);

        printf("\nNascimento: %s", alunos->nascimento);

        printf("\n");
    }

    free(alunos);


}

