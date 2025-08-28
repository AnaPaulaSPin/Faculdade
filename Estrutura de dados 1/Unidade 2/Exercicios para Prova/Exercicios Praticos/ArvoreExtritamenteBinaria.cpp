// Implemente uma função que retorne verdadeiro (1) se a árvore for estritamente binária, ou seja, se todo nó tiver exatamente 0 ou 2 filhos; caso contrário, retorne falso (0).

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

    bool Verificar(Node2 *raiz){
        if(raiz == nullptr){
            return true;
        }
        if(raiz->esq == nullptr && raiz->dir!= nullptr){
            return false;
        } else if(raiz->esq != nullptr && raiz->dir == nullptr){
            return false;
        }
        return Verificar(raiz->dir) && Verificar(raiz->esq);
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

   bool validar;
   validar = f1.Verificar(raiz);
   if(validar){
    cout << " essa arvore e estritamente binaria!";
   } else {
    cout << "essa arvore nao e estritamente binaria!";
   }
   

    return 0;
}

