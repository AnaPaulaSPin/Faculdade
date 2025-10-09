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

    void emOrdem(Node2 *raiz){
        if(raiz == nullptr){
            return;
        } else{
            emOrdem(raiz->esq);
            cout << raiz->info << " ";
            emOrdem(raiz->dir);
        }
    }

    void preOrdem(Node2 *raiz){
        if(raiz == nullptr){
            return;
        } else{
            cout << raiz->info << " ";
           preOrdem(raiz->esq);
           preOrdem(raiz->dir);
        }
    }

    void posOrdem(Node2 *raiz){
     if(raiz == nullptr){
            return;
     } else{
        preOrdem(raiz->esq);
        preOrdem(raiz->dir);
        cout << raiz->info << " ";
        }
    }

       
};

int main()
{
   Arvore f1;
   Node2 *raiz = nullptr;
   raiz = f1.inserir(raiz, 50);
   raiz = f1.inserir(raiz, 30);
   raiz = f1.inserir(raiz, 20);
   raiz = f1.inserir(raiz, 40);
   raiz = f1.inserir(raiz, 70);
   
   cout <<" EmOrdem: ";
   f1.emOrdem(raiz);

   cout << "\n PreOrdem: ";
   f1.preOrdem(raiz);

   cout << "\n PosOrdem: ";
   f1.posOrdem(raiz);

    return 0;
}
