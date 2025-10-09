// Escreva uma função recursiva, em C, para imprimir todos os nós ascendentes de um certo nó 
//de uma árvore binária de pesquisa. 

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
    

    Node2* imprimirAscedentes(Node2 *raiz, int n){
        Node2 *aux = raiz;
        if(raiz == nullptr){
            return nullptr;
        }
        if(n < raiz->info){
           imprimirAscedentes(raiz->esq,n);
        }else if(n > raiz->info){
           imprimirAscedentes(raiz->dir,n);
        } 
      

        if(aux != nullptr){
            cout << raiz->info << " ";
        }

        return aux;
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
   f1.imprimirAscedentes(raiz,5);

    return 0;
}
