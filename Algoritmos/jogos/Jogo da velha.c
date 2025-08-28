#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int L, C, i,j, encontrou, chance, ganhou;
char JV[3][3], V[3][3];
char G, r, ganhador;
void JogoDaVelha();
void PreencherMatriz();
void vencedor();

int main() {
    // atribuir a Matriz do jogo um espaço
  PreencherMatriz();
  chance = 0;
  ganhou = 0;
  
  // começo do jogo
  do{
    //vizualizaçao do jogo
    JogoDaVelha();
    
    // garantir que o usuario so digite uma coluna e linha coerente
  do{
    printf("\nDigite a coluna \n");
    scanf("%d", &C);

    printf("\nDigite a linha\n");
     scanf("%d", &L);
    
  } while(L < 0 || L > 2 || C < 0 || C > 2); 
  
    printf("Digite X ou O: ");
     scanf(" %c", &G);
      JV[L][C] = G; 

    encontrou = 0;
    
  // verificar se repetiu a posiçao
         if(V[L][C] == 'X' || V[L][C] == 'O'|| V[L][C] == 'x'|| V[L][C] == 'o'){
           encontrou = 1;
           printf("\nEssa posicao ja foi preenchida, tente novamente\n");
         } else
        V[L][C] = JV[L][C]; 
        chance = chance + 1;
    
    // visualizar o jogo da velha dps da jogada
    JogoDaVelha();
    

    //validaçao da partida
 if(chance == 3){
    vencedor();
 }
  
  if (ganhou == 1){
     break;
  }
   
  // se o usuario desejar continuar com o jogo
   printf("\nDeseja continuar?(s/n): ");
    scanf(" %c", &r);
  } while(r == 's' || r == 'S');
  
  return 0;
}

void vencedor(){
    // verificar se deu ----
    for(i=0;i<2;i++){
        for(j=0;j<2;j++){
    if(V[i][j] == V[i][j+1] && V[i][j+1] == V[i][j+2] ){
        ganhador = V[i][j];
        ganhou = 1;
        break;
    
    // verificar se deu |
    } else {
      if(V[i][j] == V[i+1][j] && V[i+1][j] == V[i+2][j] ){
        ganhador = V[i][j];
        ganhou = 1;
        break;

    // verificando se deu /
    } else if(V[0][0] == V[1][1] && V[1][1] == V[2][2]){
        ganhador = V[0][0];
        ganhou = 1;
        break;

    } else if(V[2][0] == V[1][1] && V[1][1] == V[0][2]){
       ganhador = V[2][0];
        ganhou = 1;
        break;

    }
        }

    }
}

}

void JogoDaVelha(){
   printf("    \nJogo da velha\n\n");
   printf("col   0  1  2    \n");
printf("lin 0|%c |%c |%c\n", V[0][0], V[0][1], V[0][2]);
   printf("    1|%c  |%c |%c\n", V[1][0], V[1][1], V[1][2]);
   printf("    2|%c  |%c |%c\n", V[2][0], V[2][1], V[2][2]);

  
}

void PreencherMatriz(){
  int i,j;
   for(i=0; i<3; i++)
     for(j=0;j<3;j++)
       V[L][C] = ' ';
}
