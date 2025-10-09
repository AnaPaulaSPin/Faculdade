#include <iostream>
using namespace std;

struct Node2{
    int info;
    struct Node2 *esq, *dir;
};
struct Fila2{
    Node2 *num;
    struct Fila2 *prox;
};

class Fila{
   private:
   Fila2 *inicio, *fim;

   public:
   Fila(){
    inicio = nullptr; fim = nullptr;
   }

   void inserir(Node2 *raiz){
    Fila2 *novo = new Fila2();
    novo->num = raiz;

      if(inicio == nullptr){
        inicio = novo; fim = novo; novo->prox = nullptr;
      } else{
        fim->prox = novo;
        fim = novo;
      }
   }

   Node2* remover(){
    if(inicio == nullptr){
        return nullptr;

    } else{
        Node2 *num = inicio->num;
        Fila2 *aux = inicio;
        inicio = inicio->prox;
        
        delete aux;
        return num;
   }
 } 

   Fila2* getInicio(){
        return inicio;
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

    void imprimir1(Node2 *raiz){
        if(raiz == nullptr){
            return;
        }

        Fila f;
        f.inserir(raiz);

        while (f.getInicio() != nullptr){
            raiz = f.remover();
            cout << raiz->info << " ";

            if(raiz->esq != nullptr){
                f.inserir(raiz->esq);
            }
            if(raiz->dir != nullptr){
                f.inserir(raiz->dir);
            }
        }
        cout << "\n";
    }

       
};



int main()
{
   Arvore f1;
   Node2 *raiz = nullptr;
   raiz = f1.inserir(raiz, 50);
   raiz = f1.inserir(raiz, 25);
   raiz = f1.inserir(raiz, 5);
   raiz = f1.inserir(raiz, 30);
   raiz = f1.inserir(raiz, 55);

   f1.imprimir1(raiz);

    return 0;
}
