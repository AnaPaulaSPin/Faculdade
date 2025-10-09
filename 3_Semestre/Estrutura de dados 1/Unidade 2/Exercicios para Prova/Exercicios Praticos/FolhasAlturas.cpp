// Escreva uma função, em C++, para imprimir a(s) folha(s) de maior altura e a(s) folha(s) de menor 
// altura, com os seus respectivos valores de altura, de uma árvore binária.

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
    
    
    // calcular e achar a altura maior da arvore
    int Altura(Node2 *raiz){
        if(raiz == nullptr){
            return -1;
        }
        int esq = Altura(raiz->esq);
        int dir = Altura(raiz->dir);

        return 1 + maior(esq,dir);

    }

    int maior(int esq, int dir){
        if(esq > dir ){
            return esq;
        } else{
            return dir;
        }
    }

    void imprimirMenor(Node2 *raiz){
         if(raiz == nullptr){
            return;
         }

         if(raiz->dir == nullptr && raiz->esq == nullptr){
            cout << "A folha de menor altura que temos e: " << raiz->info << "\n";
            return;
         }

         
         int esq = Altura(raiz->esq);
         int dir = Altura(raiz->dir);

         if(esq < dir){
            imprimirMenor(raiz->esq);
         } else{
            imprimirMenor(raiz->dir);
         }
    }

    void imprimirMaior(Node2 *raiz){
         if(raiz == nullptr){
            return;
         }

         if(raiz->dir == nullptr && raiz->esq == nullptr){
            cout << "A folha de maior altura que temos e: " << raiz->info << "\n";
            return;
         }

         
         int esq = Altura(raiz->esq);
         int dir = Altura(raiz->dir);

         if(esq > dir){
            imprimirMaior(raiz->esq);
         } else{
            imprimirMaior(raiz->dir);
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

   f1.imprimirMaior(raiz);
   f1.imprimirMenor(raiz);
   

    return 0;
}
