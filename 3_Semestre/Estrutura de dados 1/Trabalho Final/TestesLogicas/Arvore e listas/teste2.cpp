// criando uma lista de nodes:

#include <iostream>
#include <string>
using namespace std;

struct Node {
    int id;
    string escolha;
    string resultado;
};

struct Lista{
    Node *dado;
    struct Lista *prox;
};

class ListaSimples{
    private:
     Lista *inicio;

    public:
    ListaSimples(){
        inicio = nullptr;
    }

void InserirElemento(Node *elemento){
        Lista *novo;
        novo = new Lista;
        if(novo == nullptr){
            cout <<"Nao foi possivel alocar memoria\n";
            return;
        } 
        novo->dado = elemento;

        if(inicio == nullptr){
            inicio = novo;
            novo->prox = nullptr;

        } else{
            Lista *atual = inicio, *ant = inicio;

            while(atual != nullptr){
                ant = atual;
                atual = atual->prox;

            }
                ant->prox = novo;
                novo->prox = nullptr;
        }
    }

    void imprimirElemento(){        
        if(inicio == nullptr){
            cout << "Nao existe lista";
            return;
        }
        Lista *atual = inicio;

        while(atual != nullptr){
            cout << atual->dado->id << " ";
            atual = atual->prox;

        }
    }
};


int main() {
    // Criando alguns nodes com id e textos
    Node n1 = {50, "Escolha 50", "Resultado 50"};
    Node n2 = {25, "Escolha 25", "Resultado 25"};
    Node n3 = {55, "Escolha 55", "Resultado 55"};
    Node n4 = {5,  "Escolha 5",  "Resultado 5"};
    Node n5 = {30, "Escolha 30", "Resultado 30"};

    ListaSimples f1;

    f1.InserirElemento(&n1);
    f1.InserirElemento(&n2);
    f1.InserirElemento(&n3);
    f1.InserirElemento(&n4);
    f1.InserirElemento(&n5);

    f1.imprimirElemento();

    return 0;
}
