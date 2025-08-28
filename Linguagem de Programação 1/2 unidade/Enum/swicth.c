#include <stdio.h>
#include <time.h>

int main()
{ int mes;

  printf("\n Insira um numero inteiro, correspondente ao mes do ano: ");
  printf("\n Numero: ");
  scanf("%d", &mes);
   if(mes == 0){
    time_t t = time(NULL);
         struct tm tm_info = *localtime(&t);
         mes = tm_info.tm_mon + 1;
         printf("O mes consequente e: ");
   }
  

  switch(mes){
    case 1: {
      printf("Janeiro");
      break;
    }
    case 2: {
      printf("fevereiro");
      break;
    }
    case 3: {
      printf("Marco");
      break;
    }
    case 4: {
      printf("Abril");
      break;
    }
    case 5: {
      printf("maio");
      break;
    }
    case 6: {
      printf("Junho");
      break;
    }
    case 7: {
      printf("Julho");
      break;
    }
    case 8: {
      printf("agosto");
      break;
    }
    case 9: {
      printf("setembro");
      break;
    }
    case 10: {
      printf("Outubro");
      break;
    }
    case 11: {
      printf("Novembro");
      break;
    }
    case 12: {
      printf("Dezembro");
      break;
    }

    default: {
      printf("Mes invalido, nao existe mes com o numero %d !", mes);
      break;
    }
  }

    return 0;
}

