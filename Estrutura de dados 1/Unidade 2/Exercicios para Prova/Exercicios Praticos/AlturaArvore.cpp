// Faça uma função em C que retorne a profundidade (altura) de uma árvore binária.

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

    int Altura(Node2 *raiz){
        if(raiz == nullptr){
            return -1;
        }
        int esq = Altura(raiz->esq);
        int dir = Altura(raiz->dir);

        return 1 + Max(esq,dir);
    }

    int Max(int esq, int dir){
        if(esq > dir){
            return esq;
        } else{
            return dir;
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

   cout << "A altura dessa arvore e: " << f1.Altura(raiz);
   

    return 0;
}

