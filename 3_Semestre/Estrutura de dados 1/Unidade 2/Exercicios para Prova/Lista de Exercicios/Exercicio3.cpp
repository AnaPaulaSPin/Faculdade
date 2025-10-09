// Escreva uma função recursiva, em C, para gerar uma pilha contendo os nós ascendentes de 
// um determinado nó de uma árvore binária de pesquisa, de tal forma que no topo da pilha 
// encontraremos sempre o maior valor dos nós ascendentes. 

#include <iostream>
using namespace std;

struct Node2{
    int info;
    struct Node2 *esq, *dir;
};

struct Lista{
    Node2 *info;
    struct Lista *prox;
};

struct pilha{
    Node2 *info;
    struct pilha *prox;
};

class ListaOrdenada{
    public:
    Lista *inicio;

    ListaOrdenada(){
        inicio = nullptr;
    }

    void inserir(Node2 *p){
        Lista *novo;
        novo = new Lista;
        if(novo == nullptr){
            cout <<"Nao foi possivel alocar memoria\n";
            return;
        } 
        novo->info = p;

        if(inicio == nullptr){
            inicio = novo;
            novo->prox = nullptr;

        } else{
            Lista *atual = inicio, *ant = inicio;

            while(atual != nullptr && novo->info->info > atual->info->info){
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

    Node2* removerOrdenamente(){
       if (inicio == nullptr) {
          return nullptr;
        }

      Lista *aux = inicio;
      inicio = inicio->prox;
      Node2 *res = aux->info;
      delete aux;
      return res;
    }
};

class Pilha{
    public:
    pilha *topo;

    Pilha(){
        topo = nullptr;
    }

    void empilhar(Node2 *raiz){
       pilha *novo = new pilha;
       novo->info = raiz;

       if(topo == nullptr){
        topo = novo;
        novo->prox = nullptr;
        return;
       }
       novo->prox = topo;
       topo = novo;
       
    }

    Node2* desempilhar(){
        if(topo == nullptr){
            return nullptr;
        }

        pilha *aux = topo;
        topo = topo->prox;
        return aux->info;
    }

    void Ordenar(ListaOrdenada l){
         if(topo == nullptr){
            return;
         }

         Node2 *aux;

         while(topo!= nullptr){
            aux = desempilhar();
            l.inserir(aux);
         }

         while(l.inicio != nullptr){
            aux = l.removerOrdenamente();
            empilhar(aux);

            
         }
    }

    void imprimirPilha() {
      if(topo == nullptr){
        cout << " Pilha vazia!";
      }

      pilha *atual = topo;

      while (atual != nullptr) {
        cout << atual->info->info << " ";
        atual = atual->prox;
      }
      cout << endl;
    }   
};

class Arvore{
    public:
    Node2 *raiz;

    Arvore(){
        raiz = nullptr;
    }

    Node2* inserir(Node2 *raiz, int n){
       if(raiz == nullptr){
           raiz = new Node2;
           if(raiz == nullptr){ exit(1);}
           raiz->info = n;
           raiz->esq = nullptr;
           raiz->dir = nullptr;
           return raiz;

       } else{
         if(n < raiz->info){
            raiz->esq = inserir(raiz->esq, n);
         } else if( n > raiz->info){
            raiz->dir = inserir(raiz->dir, n);
         } else{
            cout << "Numero repetido";
         }

         return raiz;
       } 
    }
    

    Node2* GuardarAscedentes(Node2 *raiz, int n, Pilha &f){
        Node2 *aux = raiz;
        if(raiz == nullptr){
            return nullptr;
        }

        if(raiz->info == n){
            return raiz; // achou o nó, não adiciona ele na lista
        }


        if(n < raiz->info){
           aux = GuardarAscedentes(raiz->esq,n, f);
        }else if(n > raiz->info){
           aux = GuardarAscedentes(raiz->dir,n,f);
        } 
      

        if(aux != nullptr){
            f.empilhar(raiz);
        }

        return aux;
    }

       
};


int main()
{
    Arvore f1;
    Node2 *raiz = nullptr;

    // Inserindo valores na árvore
    raiz = f1.inserir(raiz, 50);
    raiz = f1.inserir(raiz, 25);
    raiz = f1.inserir(raiz, 5);
    raiz = f1.inserir(raiz, 30);
    raiz = f1.inserir(raiz, 55);
    raiz = f1.inserir(raiz, 51);

    ListaOrdenada lista;
    Pilha pilhaAscendentes;

    // Guarda os ascendentes de 51 na pilha
    f1.GuardarAscedentes(raiz, 5, pilhaAscendentes);
    //ordenar a pilha de menor a maior e jogar na pilha
    pilhaAscendentes.Ordenar(lista);

    pilhaAscendentes.imprimirPilha();

    

    cout << endl;

    return 0;
}