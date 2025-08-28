// Questão 2:
// Escreva uma função que receba o ponteiro de início para uma lista duplamente encadeada de números 
// inteiros. A função informará se a lista é ou não simétrica.
/// Considere uma lista simétrica aquela em que a sequência de números é idêntica em ambos 
// os sentidos: de início ao fim e vice-versa.


#include <iostream>
using namespace std;

struct node{
    int numero;
    struct node *prox, *antr;
};

class Lista{
    private:
     node *inicio;

    public:
    Lista(){
        inicio = nullptr;
    }


    void InserirElemento(int n){
        node *novo, *atual;
        novo = new node();
        if(novo == nullptr){
            return;
        }
        novo->numero = n;
        
        if(inicio == nullptr){
            novo ->antr = nullptr;
            novo ->prox = nullptr;
            inicio = novo;
            return;
        }
        
        atual = inicio;
        
        while(atual->prox != nullptr){
            atual = atual->prox;
        }
        //caso do ultimo elemento
        if(atual ->prox == nullptr){
            atual->prox = novo;
            novo->antr = atual;
            novo->prox = nullptr;
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

    bool ModificarLista(){
        node *atual = inicio, *aux = inicio;

        //encontrar o fim e atribuir:
        while(aux ->prox != nullptr){
            aux = aux->prox;
        }

        while (atual != nullptr){
            if(aux->numero != atual->numero){
                cout << " A lista nao e simetrica!";
                return false;
            }

            atual = atual->prox;
            aux = aux->antr;
       }
       cout << "Lista simetrica!";
       return true;

    }


};

int main(){
    Lista f1;
    f1.InserirElemento(4);
    f1.InserirElemento(2);
    f1.InserirElemento(4);

    f1.ModificarLista();
    cout << "\n";
    
    cout << "\nLista: ";
    f1.mostrar();


    return 0;
}