#include <iostream>
using namespace std;

struct Node2{
    int info;
    struct Node2 *esq, *dir;
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

    Node2* Remover(Node2*raiz, int n){
        if(raiz == nullptr){
            return nullptr;
        } 

        if(raiz->info == n){
            raiz = RemoverTipo(raiz);

        } else if(n < raiz->info){
           raiz->esq = Remover(raiz->esq, n);
        } else if(n > raiz->info){
            raiz->dir = Remover(raiz->dir,n);
        }

        return raiz;
    }
    Node2 *RemoverTipo(Node2 *raiz){
        if(raiz->esq == nullptr && raiz->dir == nullptr){
            delete raiz;
            return nullptr;
        } 

        if(raiz->esq != nullptr && raiz->dir == nullptr){
            Node2 *aux = raiz;
            raiz = raiz->esq;
            delete aux;
        }

        if(raiz->esq == nullptr && raiz->dir != nullptr){
            Node2 *aux = raiz;
            raiz = raiz->dir;
            delete aux;
        }

        if(raiz->esq != nullptr && raiz->dir != nullptr){
            Node2 *atual = raiz->dir;
            while(atual->esq != nullptr){
                atual = atual->esq;
            }

            raiz->info = atual->info;
            raiz->dir = Remover(raiz->dir, atual->info);
        }

        return raiz;

    }

    void emOrdem(Node2 *raiz){
        if(raiz == nullptr){
            return;
        } else{
            emOrdem(raiz->esq);
            cout << raiz->info << " ";
            emOrdem(raiz->dir);
        }
    }

    

       
};

int main()
{
   Arvore f1;
   Node2 *raiz = nullptr;
   raiz = f1.inserir(raiz, 50);
   raiz = f1.inserir(raiz, 25);
   raiz = f1.inserir(raiz, 5);
   raiz = f1.inserir(raiz, 55);
   raiz = f1.inserir(raiz, 51);

   cout << "\n";
   f1.emOrdem(raiz);
   cout << "\n\n";

   raiz = f1.Remover(raiz, 25);


   f1.emOrdem(raiz);

    return 0;
}
