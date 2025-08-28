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

    void RetirarRepetidos(){
        node *atual = inicio, *aux, *antr,*temp;
        while(atual != nullptr){
            aux = atual->prox; 
            antr = aux;

            while(aux != nullptr){
                if(aux->numero == atual->numero){
                    temp = aux;

                    if(aux->prox == nullptr){
                        antr->prox = nullptr;
                        aux = aux->prox;
                        delete temp;
                    }else{
                        antr->prox = aux->prox;
                        aux = aux->prox;
                        delete temp;
                    }
                } else{
                    antr = aux;
                    aux = aux->prox;
                }

            }
          atual = atual->prox;
        }

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
    f1.InserirElemento(1);
    f1.InserirElemento(2);
    f1.InserirElemento(3);
    f1.InserirElemento(2);
    f1.InserirElemento(6);
    f1.InserirElemento(1);

    cout << "Lista original: \n";
    f1.mostrar();

    f1.RetirarRepetidos();
    cout << "Numeros Pares: \n";
    f1.mostrar();


    return 0;
}