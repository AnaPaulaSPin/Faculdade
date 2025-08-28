// Faça uma função em C que receba o ponteiro para a raiz da árvore e retorne a soma de todos os valores armazenados nos nós da árvore.

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

    int SomarNos(Node2 *raiz){
        if(raiz == nullptr){
            return 0;
        }

        return raiz->info + SomarNos(raiz->esq) + SomarNos(raiz->dir);
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

   cout <<"A soma de todos os nos e: " << f1.SomarNos(raiz);
   

    return 0;
}

