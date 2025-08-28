#include <stdio.h>
#include <string.h>
#include <time.h>

#define Max 50

typedef struct 
{
    char Aluno[Max];
    int matricula;
    float nota;
    

} Alunos;

Alunos Aluno[100];

int AdicionarAluno();
void ExibirAlunos();
void PesquisarAluno();

int main(){
    //declarações variaveis
    int r; // opções do menu
    int i=0;
    int TotalAlunos=0; // total de alunos cadastrados
    int num; //simboliza a quantidade adicionada de alunos.
    char c; // variavel para responder se ele gostaria de continuar ou parar.

  while(1){

    printf("Bem vindo(a), ao Gerenciamento Student\n");

    printf("Menu\n");
    printf("1- Adicionar Novo aluno\n");
    printf("2- Exibir lista dos Alunos\n");
    printf("3- Pesquisar Aluno\n");
    printf("4- Sair\n");
    scanf("%i", &r);

    switch (r)
    {
    case 1:{
        printf("Adicionar Novo Aluno\n");
        printf("Quantos alunos voce deseja adicionar?");
        printf("\nResposta: ");
        scanf("%d", &num);

         // Limpa o buffer de entrada
         getchar();

        for(i=1;i<=num;i++){
            AdicionarAluno(&Aluno[i], i);

            getchar(); //limpar o buffer

            printf("deseja continuar?(s/n)\n");
            printf("Resposta: ");
            scanf(" %c", &c);

            if(i == 1 || i < num){
                if(c !='s' && c != 'S'){
                printf("Saindo da funcao...");
                num=i;
                break;
            }
            }

            
            // Limpa o buffer de entrada
             getchar();
        }
        

        //Toda vez que ele adicionar os alunos, o numero vai atualizar, 
        // para assim temos ciencia de quantos alunos estao cadastardos ao total:
        TotalAlunos= TotalAlunos + num;
        printf("\nTotal de Alunos cadastrados: %d", TotalAlunos);
         printf("\n\n");
         getchar();
         system("clear || cls"); // Limpa a tela
        break;
       
    }
    case 2: {
    printf("Exibir lista dos Alunos\n");
    ExibirAlunos(Aluno, TotalAlunos);
    printf("\n\n");
    getchar();
    system("clear || cls"); // Limpa a tela
    break;
    }

    case 3:{
        printf("Pesquisar Aluno\n");
        PesquisarAluno(Aluno, TotalAlunos);
         printf("\n\n");
         system("clear || cls"); // Limpa a tela
        break;
    }
    case 4:{
        printf("saindo do sistema...");
        system("clear || cls"); // Limpa a tela
        break;
    }
           
    }

    if(r==4){
        break;
    }
  }

    return 0;
}

int AdicionarAluno(Alunos *a, int num1){

        printf("Nome do %d aluno: ", num1 );
        fgets(a->Aluno, Max, stdin);
        a->Aluno[strcspn(a->Aluno, "\n")] = 0;

         // Limpa o buffer de entrada
         getchar();


        printf("Matricula do %d aluno: ", num1 );
        scanf("%d", & a->matricula );

        getchar();

        printf("Nota do %d aluno: ", num1 );
        scanf("%f", & a->nota );

        // Limpa o buffer de entrada
         getchar();

        
   return num1;
}

void ExibirAlunos(Alunos aluno[], int contAl) {
    printf("Lista de Alunos\n");
    int i;

    // imprimir as informações dos alunos:
    for (i = 1; i <= contAl; i++) {
        printf("\nNome do Aluno: %s\n", aluno[i].Aluno);
        printf("Matricula: %i", aluno[i].matricula);
        printf("\nNota: %.2f", aluno[i].nota);
        printf("\n______________________________________\n");
    }
}

void PesquisarAluno(Alunos aluno[], int contAl){
    int matricula, i, encontrado=0;
    printf("Digite o numero da matricula: ");
    scanf("%d", &matricula);

    for(i = 1; i <= contAl; i++){
        if(matricula == Aluno[i].matricula){
            printf("\nAluno encontrado!");
            printf("\nNome do Aluno: %s\n", aluno[i].Aluno);
            printf("Matricula: %i", aluno[i].matricula);
            printf("\nNota: %.2f", aluno[i].nota);
            encontrado = 1;
            break;
        }

    }
     if(encontrado==0){
        printf("Aluno nao encontrado.");

     }


}