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
    
    int NumeroNoUmFilho(Node2 *raiz){
        if(raiz == nullptr){
            return 0;
        }
        if(raiz->esq == nullptr && raiz->dir == nullptr){
            return 0;
        }

        if(raiz->esq != nullptr && raiz->dir != nullptr){
           return NumeroNoUmFilho(raiz->dir) + NumeroNoUmFilho(raiz->esq);
        }
        if(raiz->esq == nullptr){
            return 1 + NumeroNoUmFilho(raiz->dir);
        } 
        if(raiz->dir == nullptr){
            return 1 + NumeroNoUmFilho(raiz->esq);
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
   raiz = f1.inserir(raiz, 30);
   raiz = f1.inserir(raiz, 55);
   raiz = f1.inserir(raiz, 51);
   cout << "Numero de Nos com 1 filho: " << f1.NumeroNoUmFilho(raiz);
   

    return 0;
}
