#include <iostream>
using namespace std;

struct node{
    int numero;
    struct node *prox, *ant;
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
        novo->prox = nullptr;
        novo->ant = nullptr;

        if(inicio == nullptr){
            inicio = novo;

        } else{
            node *atual = inicio;

            while(atual->prox != nullptr){
                atual = atual->prox;
            }

                atual->prox = novo;
                novo->ant = atual; 
            
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

    node *Multiplos3(){
        node *multiplo = nullptr, *proximo,*aux, *atual = inicio;

        while (atual != nullptr){
            proximo = atual->prox;

           if(atual->numero % 3 == 0){
            if(atual==inicio){
                atual->prox->ant = nullptr;
                inicio = inicio->prox;

            } else if(atual->prox == nullptr){
                atual->ant->prox = nullptr;

            } else{
                atual->ant->prox = atual->prox;
                atual->prox->ant = atual->ant;
            }

            // adicionar lista de pares:
            if(multiplo == nullptr){
             atual->ant = nullptr;
             atual->prox = nullptr;
             multiplo = atual;

            } else{
              aux = multiplo;

              while(aux->prox != nullptr &&  atual->numero > aux->numero){
                aux = aux->prox;

               } if(aux->prox == nullptr){
                aux->prox = atual;
                atual->ant = aux;
                atual->prox = nullptr;


               } else if(aux == multiplo){
                atual->prox = multiplo;
                multiplo->ant = atual;
                multiplo = atual;

               } else{
                aux->ant->prox = atual;
                atual->prox = aux;
                atual->ant = aux->ant;
                aux->ant = atual;
               }
             
         }

         } 

         atual = proximo;
        }

        return multiplo;
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
    f1.InserirElemento(6);
    f1.InserirElemento(7);

    cout << "Lista original: \n";
    f1.mostrar();

    node *multiplo = f1.Multiplos3();
    
    cout << "Multiplos: \n";
    f1.mostrar(multiplo);


    return 0;
}