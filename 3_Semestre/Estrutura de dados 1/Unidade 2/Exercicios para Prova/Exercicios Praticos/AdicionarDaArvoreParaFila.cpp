#include <iostream>
using namespace std;

struct Node2{
    int info;
    struct Node2 *esq, *dir;
};

struct estruturaFila{
   Node2 *info;
   struct estruturaFila *prox;
};

class Fila{
   public:
   estruturaFila *inicio;

   Fila(){
    inicio = nullptr;
   }

   void enfileirar(Node2 *raiz){
     if(raiz == nullptr){
        return;
     }

     estruturaFila *novo = new estruturaFila();
     novo->info = raiz;

     if(inicio == nullptr){
       inicio = novo;
       novo->prox = nullptr;

     } else{
        estruturaFila *atual = inicio;
        while(atual->prox != nullptr){
            atual = atual->prox;
        }
        atual->prox = novo;
        novo->prox = nullptr;
     }
   }

   void Imprimir(){
     if(inicio == nullptr){
        return;
     }
     estruturaFila *atual = inicio;
     while(atual!= nullptr){
        cout << atual->info->info << " ";
        atual = atual->prox;
     }
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
    
    Node2* retirarArvore(Node2 *raiz, int n, Fila &f ){
       if(raiz == nullptr){
        cout << "numero nao encontrado!"; return nullptr;
       }

       if( n < raiz->info ){
        raiz->esq = retirarArvore(raiz->esq, n, f);

       } else if(n > raiz->info){
        raiz->dir = retirarArvore(raiz->dir,n,f);
       } else{
         raiz = retirarElemento(raiz,n,f);
       }

       return raiz;
    }

    Node2 *retirarElemento(Node2 *raiz,int n,Fila &f){
      if(raiz->dir == nullptr && raiz->esq == nullptr){
        f.enfileirar(raiz);
        return nullptr;
      }

      if(raiz->dir == nullptr){
          Node2 *temp = raiz->esq;
          f.enfileirar(raiz);
          return temp;
      }

      if(raiz->esq == nullptr){
        Node2 *temp = raiz->dir;
        f.enfileirar(raiz);
        return temp;
      }

      if(raiz->dir != nullptr && raiz->esq != nullptr){
        Node2 *atual = raiz->dir;
        while(atual->esq != nullptr){
            atual = atual->esq;
        }
        int valorSucessor = raiz->info;
        raiz->info = atual->info;
        atual->info = valorSucessor;

        raiz->dir = retirarArvore(raiz->dir, valorSucessor, f);
        return raiz;
      }

       // Para garantir que sempre retorna algo (apesar de não ser esperado chegar aqui)
        return raiz;
    }
       
};

int main()
{
   Arvore f1;
   Node2 *raiz = nullptr;
   Fila fila;

   raiz = f1.inserir(raiz, 50);
   raiz = f1.inserir(raiz, 25);
   raiz = f1.inserir(raiz, 5);
   raiz = f1.inserir(raiz, 30);
   raiz = f1.inserir(raiz, 55);

   raiz = f1.retirarArvore(raiz, 25,fila);
   fila.Imprimir();
   cout << "\n";

   

    return 0;
}
