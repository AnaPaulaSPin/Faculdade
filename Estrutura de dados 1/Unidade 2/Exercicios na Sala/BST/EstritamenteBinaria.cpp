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

    bool verificar(Node2 *raiz){
        if(raiz == nullptr){
            return true;
        }
        if(raiz->esq == nullptr && raiz->dir == nullptr){
            return true;
        }
        if(raiz->dir != nullptr && raiz->esq != nullptr){
            return verificar(raiz->dir) && verificar(raiz->esq);
            
        } else{
            return false;
        }

    }

       
};

int main()
{
   Arvore f1;
   Node2 *raiz = nullptr;
   raiz = f1.inserir(raiz, 50);
   raiz = f1.inserir(raiz, 30);
   raiz = f1.inserir(raiz, 20);
   raiz = f1.inserir(raiz, 70);

   if(f1.verificar(raiz)){
     cout << " Ela e extritamente binaria";
   } else{
    cout << "Ela nao e extritamente binaria";
   }
   
    return 0;
}
