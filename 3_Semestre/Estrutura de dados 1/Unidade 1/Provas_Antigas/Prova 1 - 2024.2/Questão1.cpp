// Questão 1
// Escreva uma função que receba o ponteiro de início de uma lista encadeada e dois inteiros M e N.
// A tarefa é percorrer a lista vinculada de forma que você pule M nós, exclua os próximos N nós e 
// continue o mesmo até o final da lista. Considere que o valor de M não pode ser 0.

#include <iostream>
using namespace std;

struct node{
    int numero;
    struct node *prox;
};

class Lista{
    private:
     node *inicio;

    public:
    Lista(){
        inicio = nullptr;
    }


    void InserirElemento(int n){
        node *novo;
        novo = new node;
        if(novo == nullptr){
            cout <<"Nao foi possivel alocar memoria\n";
            return;
        } 
        novo->numero = n;
        if(inicio == nullptr){
            inicio = novo;
            novo->prox = nullptr;

        } else{
            node *atual = inicio, *ant = inicio;

            while(atual != nullptr){
                ant = atual;
                atual = atual->prox;

            }
                ant->prox = novo;
                novo->prox = nullptr;
            
        }
    }

    void mostrar(node *ptr){
        node *atual = ptr;
        if(ptr == nullptr){
            cout << " Lista vazia, insira numeros!\n";
        } else{
            while(atual != nullptr){
                cout << atual->numero << " ";
                atual = atual->prox;

            }
            cout <<" \n";
        }
    }

    node *ModificarLista(int M, int N){
        node *atual = inicio, *lista = inicio, *proximo, *antr, *temp;

        while (atual != nullptr){
            for(int i = 0; atual != nullptr && i < M; i++){
                antr = atual;
                atual = atual->prox;
            }

            for(int i = 0; atual != nullptr && i <N; i++){
                proximo = atual->prox;

                if(atual->prox == nullptr){
                    antr->prox = nullptr;
                    temp = atual;
                    delete temp;
                } else{
                    antr->prox = proximo;
                }
                atual = proximo;

            }
        }

        return lista;
    }

    void mostrar(){
        node *atual = inicio;
        if(inicio == nullptr){
            cout << " Lista vazia, insira numeros!\n";
        } else{
            while(atual != nullptr){
                cout << atual->numero << " ";
                atual = atual->prox;

            }
            cout <<" \n";
        }
    }


};

int main(){
    Lista f1;

    f1.InserirElemento(7);
    f1.InserirElemento(2);
    f1.InserirElemento(1);
    f1.InserirElemento(3);
    f1.InserirElemento(9);
    f1.InserirElemento(1);
    f1.InserirElemento(4);

    cout << "Lista original: \n";
    f1.mostrar();

    node *inicio = f1.ModificarLista(1,2);
    
    cout << "Lista modificada: : \n";
    f1.mostrar(inicio);


    return 0;
}