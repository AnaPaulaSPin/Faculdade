#include <stdio.h>

int main(){
  char num;
  while(1){
     printf("Escolha uma opcao de 0 a 1 ");
  scanf("%c", &num);

  switch(num){
    case '1':{
      printf("escolha numero 1\n");
      break;
    }
    case '0':{
      printf("escolha 0\n");
      break;
    }
  }

   if(num == '1' || num == '0'){
    break;
   }
   else
   printf("Digite outra opcao\n");

  }

  return 0;
  
}
