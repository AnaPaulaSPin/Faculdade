// faça um programa que pegue um nuemro, e mostre apenas a fatoraçãos dos numeros primos

#include <stdio.h>

// função para verificar se o numero é primo 
int primo(int n){
    // ele começa divindo o n pelo 2 e vai ate quando i for menor que n porque um numero primo so é divicel por ele mesmo e por 1
    for(int i=2;i<n;i++){
        // se n for divisil por qualquer numero de i, significa que ele nao é primo, como por exemplo o 15 e o 25
        if(n % i== 0){
            //sendo assim o codigo vai parar e vai retornar 1
           return 1;
        }

    }
    //caso nao seja divisil por nenhum numero, ele retorna 0, ou seja, ele é primo
    return 0;
}

int main(){
    int n = 25;
    int resultado;

    for(int i=3;i<=n;i+=2){

       // o valor de i, vai ser jogado para a função para a verificação se o numero é primo:
        resultado = primo(i);

        // se resultado continuar com o valor zero, significa que o numero é primo
        if(resultado == 0){
            printf("%d \n", i);
        } 
    }


    return 0;
}