// Faça uma função em C que receba como parâmetro o ponteiro para a raiz de uma árvore binária de pesquisa já criada.
// A função deverá retornar o número total de nós internos (nós que não são folhas).

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

    int ContarNos(Node2 *raiz){
        if(raiz == nullptr){
            return 0;
        }

        if(raiz->esq == nullptr && raiz->dir == nullptr){
            return 0;
        }

        return 1 + ContarNos(raiz->esq) + ContarNos(raiz->dir);
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
   raiz = f1.inserir(raiz, 52);

   cout << "Os nos que essa arvore tem sao: " << f1.ContarNos(raiz);
   

    return 0;
}

