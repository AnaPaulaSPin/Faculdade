#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

char pal[] = "mouse";
char tent[] = "_____";
int i, tam;
void desenho();

int main() {
  int encontrou, erro, acertos;
  char palavra[5];
  char c;
  tam = strlen(pal);
  erro = 0;
  acertos = 0;

  // começo da forca
  while(c != '#'){
  
  //le a letra
  printf("\nDigite uma letra\n (digite # para sair): ");
    scanf(" %c", &c);
    if(c =='#'){
      printf("saindo da forca...");
      break;
    }
    
    // recomendaçao da professora para tirar qualquer espaço:
    if (c != ' ' && c != '\n'){ 
      encontrou = 0;
      
    // compara a letra  
    for(i=0; i < tam;i++) {
      if(c == pal[i]){
      encontrou = 1;
      tent[i] = pal[i]; 
      acertos = acertos +1;
    }

    }
    if(encontrou == 0) {
         erro = erro + 1;
         desenho(erro); 
         for(i=0;i < tam; i++){
           printf("%c", tent[i]);
         }
    }

    else{
      desenho(erro); 
      for(i=0;i < tam; i++){
        printf("%c", tent[i]);
      }
         }

       if(acertos == 2){
         printf("\nDeseja adivihar a palavra?(s/n): ");
         scanf(" %c", &c);

         while(c != 'n'){

           printf("\n\nDigite a palavra: ");
          scanf("%s", palavra);

           if (strcmp(pal, palavra) == 0) {
             break;
           } else {
             break;
           }
         }

       }
      // quando a letra for completada ele vai parar
      if (strcmp(pal, tent) == 0 || strcmp(pal, palavra) == 0) {
        printf("\nParabéns! Você acertou a palavra!\n");
        break;
      }

     if (erro == 5){
       break;
     }
}

 
}
   return 0;
}

void desenho(int erro){
  if(erro == 0){
    printf(" _____\n");
    printf("| \n");
    printf("| \n");
    printf("| \n");
     printf("  ");

  } else if (erro == 1){
    printf(" _____\n");
    printf("|  O\n");
    printf("|   \n");
    printf("|   \n");
     printf("  ");

  } else if(erro == 2){
    printf(" _____\n");
    printf("|  O \n");
    printf("|  | \n");
    printf("|    \n");
     printf("  ");

  } else if(erro == 3){
  printf(" _____\n");
  printf("|  O \n");
  printf("|  | \n");
  printf("| / ] \n");
     printf("  ");

} else if(erro == 4){
      printf(" _____\n");
      printf("|  O \n");
      printf("| /| \n");
      printf("| / ] \n");
     printf("  ");

    }  else if(erro == 5){
    printf(" _____\n");
    printf("|  O \n");
    printf("| /|> \n");
    printf("| / ] \n");
     printf("  ");
  }
}