// Crie um programa em C que defina um enum chamado Mes com os valores:
// JANEIRO, FEVEREIRO, MARÇO, ABRIL, MAIO, JUNHO, JULHO, AGOSTO, SETEMBRO, OUTUBRO, NOVEMBRO, e DEZEMBRO. 
// Utilize um switch para imprimir a quantidade de dias de cada mês correspondente a um valor de enum fornecido pelo usuário. 
//O programa deve solicitar ao usuário um número de 0 a 11 e exibir a quantidade de dias do mês associado a esse número.

#include <stdio.h> 
enum meses{
    janeiro = 1,
    fevereiro,
    marco,
    abril,
    maio,
    junho,
    julho,
    agosto,
    setembro,
    outubro,
    novembro,
    dezembro

};

int main(){
    enum meses mes;

    printf("Digite um numero de 1 a 12: ");
    scanf("%d", &mes);

    switch (mes)
    {
    case 1:
        printf("O mes escolhido foi janeiro, ele possui 30 dias\n");
        break;
    case 2:
        printf("O mes escolhido foi Fevereiro, ele possui 29 dias em anos normais, e 30 em anos bixestos \n");
        break;
    
    case 3:
        printf("O mes escolhido foi marco, ele possui 31 dias\n");
        break;

    case 4:
        printf("O mes escolhido foi abril, ele possui 30 dias\n");
        break;

    case 5:
        printf("O mes escolhido foi maio, ele possui 31 dias\n");
        break;

    case 6:
        printf("O mes escolhido foi junho, ele possui 30 dias\n");
        break;
    
    case 7:
        printf("O mes escolhido foi julho, ele possui 31 dias\n");
        break;
    
    case 8:
        printf("O mes escolhido foi agosto, ele possui 31 dias\n");
        break;
    
    case 9:
        printf("O mes escolhido foi setembro, ele possui 30 dias\n");
        break;

    case 10:
        printf("O mes escolhido foi outubro, ele possui 31 dias\n");
        break;
    
    case 11:
        printf("O mes escolhido foi novembro, ele possui 30 dias\n");
        break;

    case 12:
        printf("O mes escolhido foi dezembro, ele possui 31 dias\n");
        break;
    
    default:
        printf("Esse mes nao existe!");
        break;
    }
    
    return 0;

}