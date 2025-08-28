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

    node *OrdenarLista(){
        node *proximo, *antr, *aux, *atual = inicio, *ordenada = nullptr;

        while (atual != nullptr){
            proximo = atual->prox;

            //Ordenar:
            if(ordenada == nullptr){
             ordenada = atual;
             atual->prox = nullptr;
            } else{
              aux = ordenada;
              while(aux != nullptr && atual->numero > aux->numero){
                antr = aux;
                aux = aux->prox;
               }
             if(aux == ordenada){
                atual->prox = ordenada;
                ordenada = atual;

             } else if(aux == nullptr){
                antr->prox = atual;
                atual->prox = nullptr;
             } else{
                antr->prox = atual;
                atual->prox = aux;
             }

         }

         atual = proximo;
        }

        return ordenada;
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
    f1.InserirElemento(4);
    f1.InserirElemento(3);
    f1.InserirElemento(7);
    f1.InserirElemento(1);
    f1.InserirElemento(6);
    f1.InserirElemento(2);

    cout << "Lista original: \n";
    f1.mostrar();

    node *par = f1.OrdenarLista();
    
    cout << "ListaOrdenada: \n";
    f1.mostrar(par);


    return 0;
}