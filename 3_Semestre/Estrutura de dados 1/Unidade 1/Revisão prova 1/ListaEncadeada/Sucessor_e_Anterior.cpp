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

            while(atual != nullptr && novo->numero > atual->numero){
                ant = atual;
                atual = atual->prox;

            }

            if(atual == nullptr){
                ant->prox = novo;
                novo->prox = nullptr;
            } else if(atual == ant){
                novo->prox = inicio;
                inicio = novo;
            } else{
                ant->prox = novo;
                novo->prox = atual;
            }
        }
    }

    void RemoverNos(int x){
        node *atual = inicio,*proximo, *antr = inicio, *anterior;
        while(atual != nullptr){
            proximo = atual->prox;

            if(atual->numero == x){
                if(atual == inicio){
                    atual->prox = proximo->prox;
                    delete proximo;

                }else if(atual->prox == nullptr){
                    anterior->prox = atual;
                    delete antr;

                } else{
                    anterior->prox = atual;
                    atual->prox = proximo->prox;
                    delete proximo; delete antr;
                }
            } else{
                anterior = antr;
            }

          antr = atual;
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
    f1.InserirElemento(4);
    f1.InserirElemento(5);
    f1.InserirElemento(6);

    cout << "Lista original: \n";
    f1.mostrar();
    int n = 3;

    f1.RemoverNos(n);

    cout << "Retirando o sucessor e antecessor de : "<< n << "\n";
    f1.mostrar();


    return 0;
}