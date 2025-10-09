#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int codigo;
    char nome[20];
    int estoque;
    float valor;

} produto;

void MaiorPreco(produto *ptr, int n){
    float maiorPreco = 0; int pos = 0;
    for(int i = 0; i < n; i++){
        if(maiorPreco<ptr[i].valor){
            maiorPreco = ptr[i].valor;
            pos = i;
        }
    }
    printf("O produto com maior preco de venda e %s com o preco de %3.f", ptr[pos].nome, ptr[pos].valor);

}
void MaiorEstoque(produto *ptr, int n){
    int estoque = 0; int pos;
    for(int i =0;i< n;i++){
        if(estoque < ptr[i].estoque){
            estoque = ptr[i].estoque;
            pos = i;
        }
    }
    printf("\nO produto com o maior estoque e %s com o estoque de %d", ptr[pos].nome, ptr[pos].estoque);

}

int main(void){
    int num;
    printf("digite quantos numeros vc deseja registrar: ");
    scanf("%d", &num);
    getchar();

    produto *ptr = (produto*) malloc(num * sizeof(produto));

    printf("Registrando os produtos..");
    getchar();


    for(int i = 0; i < num; i++){
        printf("Produto %d\n", i+1);
        printf("Codigo do produto: ");
        scanf("%d", &ptr[i].codigo);

        printf("Nome do produto: ");
        scanf("%s", ptr[i].nome);

        printf("Quantidade do produto no estoque: ");
        scanf("%d", &ptr[i].estoque);

        printf("Valor do produto: ");
        scanf("%f", &ptr[i].valor);

        printf("\n");

    }
    MaiorPreco(ptr,num);

    MaiorEstoque(ptr,num);
    
}
