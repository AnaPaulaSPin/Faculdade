#include <stdio.h>
#include <stdlib.h>

int soma(int a,int b){
    int result;

    result = a + b;

    return result;
}

int subtracao(int a,int b){
    int result;

    result = a - b;
    
    return result;
}
int multiplicacao(int a,int b){
    int result;

    result = a * b;
    
    return result;
}

int divisao(int a,int b){
    int result;

    result = a / b;
    
    return result;
}

int modulo(int a,int b){
    int result;

    result = a % b;
    
    return result;
}
void pausar() {
    printf("\nAperte Enter para continuar...");
    getchar();
}

int main(){
    int num1,num2,r,result;
    while(1){
     printf("Digite dois numeros: ");
     scanf("%d %d", &num1, &num2);

     printf("Menu de operacoes: \n");
     printf("1- Soma\n");
     printf("2 - Subtracao\n");
     printf("3- Multiplicacao\n");
     printf("4- Divisao\n");
     printf("5 - Modulo\n");
     printf("-1 - Sair\n");
     printf("Escolha: ");
     scanf("%d", &r);
     getchar();

     switch(r){
        case 1:{
            printf("Soma: ");
            int (*ptr)(int, int);
            ptr = soma;
            result = ptr(num1,num2);
            printf("\nResultado da operacao: %d", result);
             pausar();
            system("clear || cls"); // Limpa a tela
            break;

        }
        case 2:{
            printf("Subtracao: ");
            int (*ptr)(int, int);
            ptr = subtracao;
            result = ptr(num1,num2);
            printf("\nResultado da operacao: %d", result);
             pausar();
            system("clear || cls"); // Limpa a tela
            break;

        }
        case 3:{
            printf("Multiplicacao: ");
            int (*ptr)(int, int);
            ptr = multiplicacao;
            result = ptr(num1,num2);
            printf("\nResultado da operacao: %d", result);
             pausar();
            system("clear || cls"); // Limpa a tela
            break;
        }
        case 4:{
            printf("Divisao: ");
            int (*ptr)(int, int);
            ptr = divisao;
            result = ptr(num1,num2);
            printf("\nResultado da operacao: %d", result);
            pausar();
            system("clear || cls"); // Limpa a tela
            break;

        }
        case 5:{
            printf("Modulo: ");
            int (*ptr)(int, int);
            ptr = modulo;
            result = ptr(num1,num2);
            printf("\nResultado da operacao: %d", result);
             pausar();
            system("clear || cls"); // Limpa a tela
            break;

        }
        case -1:{
            printf("Saindo do programa...");
            pausar();
            break;

        }
        default: {
            printf("Numero invalido, tente novamente!\n");
            pausar();
            system("clear || cls"); // Limpa a tela
            break;
        }
     }
     if(r == -1){
        break;
     }


    }
    
}