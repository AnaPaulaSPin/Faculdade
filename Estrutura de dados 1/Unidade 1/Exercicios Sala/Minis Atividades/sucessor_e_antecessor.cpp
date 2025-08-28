//para testar a função sem o menu: 
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
    node *novo, *atual;
    novo = new node();
    if(novo == nullptr){
        return;
    }
    novo->numero = n;

    if(inicio == nullptr){
        novo ->ant = nullptr;
        novo ->prox = nullptr;
        inicio = novo;
        return;
    }

    atual = inicio;

    while((atual->prox != nullptr) && (novo->numero > atual->numero)){
        atual = atual->prox;
    }
    //caso do ultimo elemento
    if(atual ->prox == nullptr && novo->numero > atual->numero){
        atual->prox = novo;
        novo->ant = atual;
        novo->prox = nullptr;

    //caso do primeiro elemento
    } else if(atual == inicio){
        novo ->prox = inicio;
        inicio->ant = novo;
        novo->ant = nullptr;
        inicio = novo;

    // caso do meio:
    } else{
        novo->ant = atual->ant;
        atual->ant->prox = novo;
        novo->prox = atual;
        atual -> ant=novo;
    }
}

void RemoverNos(int x){
    Node2 *atual = inicio,*proximo, *antr = inicio;
    while(atual != nullptr){
        proximo = atual->prox;

        if(atual->info == x){
            if(atual->ant->ant == nullptr && atual->prox->prox == nullptr){
                inicio = atual;

                atual->ant = nullptr;
                atual->prox = nullptr;
            } else
            // caso do primeiro elemento
            if(atual == inicio){
                atual->prox = atual->prox->prox;
                
                atual->prox->prox->ant = atual;
                delete proximo;

             // caso do ultimo elemento
            }else if(atual->prox == nullptr){
               atual->ant = atual->ant->ant;
                
               atual->ant->ant->prox = atual;
                delete antr;

            // caso do elemento no meio, mas so temos 3 elementos:
            } 

                // caso de existir o sucessor do sucessor do atual mas 
                // o antecessor do antecessor do atual nao existir:
              else if(atual->ant == inicio){
                atual->prox = atual->prox->prox;
                atual->ant = nullptr;
                  
                atual->prox->prox->ant = atual;
                inicio = atual;                      
                delete proximo; delete antr;

             // caso de existir o antecessor do antecessor do atual
             // mas o sucessor do sucessor do atual nao existir
             }else if(atual->prox->prox == nullptr){
                atual->ant = atual->ant->ant;
                atual->prox = nullptr;
                  
                atual->ant->ant->prox = atual;                    
                delete antr; delete proximo;

                // caso do meio:
               } else{
                atual->ant = atual->ant->ant;
                atual->prox = atual->prox->prox;
                  
                atual->prox->prox->ant = atual;
                atual->ant->ant->prox = atual;
                delete proximo; delete antr;
            }
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
    f1.InserirElemento(3);
    f1.InserirElemento(2);
    f1.InserirElemento(1);
    f1.InserirElemento(4);
    f1.InserirElemento(5);
    

    cout << "Lista original: ";
    f1.mostrar();
    int n = 1;

    f1.RemoverNos(n);

    cout << "\nNumero : "<< n << "\n";
    cout << "\nLista com o antecessor e sucessor removido: ";
    f1.mostrar();


    return 0;
}