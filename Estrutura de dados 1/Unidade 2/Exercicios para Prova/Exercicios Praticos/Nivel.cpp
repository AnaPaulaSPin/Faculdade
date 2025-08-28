// Implemente uma função em C que, dada a raiz de uma árvore binária e um inteiro valor, retorne o nível do nó que contém esse valor.

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
    int Nivel(Node2 *raiz, int num, int nivel){
        if(raiz == nullptr){
            return -1;
        } 

        if(raiz->info == num){
            return nivel;
        } 

        int aux;
        if(num < raiz->info){
            aux = Nivel(raiz->esq, num, nivel + 1);
        } else{
            aux = Nivel(raiz->dir, num, nivel + 1);
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

   int valor = 100;

   cout << "O numero "<< valor << " se encontra no nivel: " << f1.Nivel(raiz,valor,0);
   

    return 0;
}

