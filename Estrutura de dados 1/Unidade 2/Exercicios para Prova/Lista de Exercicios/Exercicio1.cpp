// Escreva uma função, em C, para mostrar o conteúdo da folha mais à esquerda, e da folha mais 
// à direita de uma árvore binária.

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
    
    void FolhaMaior(Node2 *raiz){
        if(raiz == nullptr){
            return;
        }
        if(raiz->dir == nullptr){
            cout<<"Folha maior: " <<  raiz->info;
            return;
        }
        FolhaMaior(raiz->dir);
    }

    void FolhaMenor(Node2 *raiz){
        if(raiz == nullptr){
            return;
        }
        if(raiz->esq == nullptr){
            cout<<"Folha menor: " <<  raiz->info;
            return;
        }
        FolhaMenor(raiz->esq);
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
   
   f1.FolhaMaior(raiz);
   cout <<"\n";
   f1.FolhaMenor(raiz);

    return 0;
}
