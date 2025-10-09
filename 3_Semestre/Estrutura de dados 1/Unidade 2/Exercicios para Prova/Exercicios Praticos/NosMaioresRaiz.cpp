// Faça uma função em C que receba a raiz de uma árvore e conte quantos nós possuem valor maior do que o valor armazenado na raiz.

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
    int MaioresValores(Node2 *raiz, int valor){
        if(raiz == nullptr){
            return 0;
        }
        if(raiz->info < valor){
            return 0;
        }
        if(raiz->info == valor){
            return MaioresValores(raiz->esq,valor) + MaioresValores(raiz->dir, valor);
        }

        return 1 + MaioresValores(raiz->esq,valor) + MaioresValores(raiz->dir, valor);
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
   
   cout << " Valores maiores que " << raiz->info << " sao: " << f1.MaioresValores(raiz, raiz->info) << " nos";

    return 0;
}

