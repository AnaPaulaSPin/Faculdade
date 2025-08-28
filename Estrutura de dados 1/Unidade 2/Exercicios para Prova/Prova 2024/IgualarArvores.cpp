// Faça uma função em C que receba como parâmetro o ponteiro para a raiz de uma árvore binária de 
// pesquisa já criada. A função deverá igualar o número de folhas das sub-árvores da raiz principal.


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

    int ContarFolhas(Node2 *raiz){
        if(raiz == nullptr){
            return 0;
        }
        if(raiz->dir == nullptr && raiz->esq == nullptr){
            return 1;
        }

        return ContarFolhas(raiz->esq) + ContarFolhas(raiz->dir);
    }

    Node2* Remover(Node2 *raiz){
       if(raiz==nullptr){
        return nullptr;
       }
       if(raiz->esq == nullptr && raiz->dir == nullptr){
        delete raiz;
        return nullptr;
       }

       // se tiver subárvore esquerda, tenta remover lá primeiro
       if(raiz->esq != nullptr){
        raiz->esq = Remover(raiz->esq);
      }
       // senão tenta na direita
      else if(raiz->dir != nullptr){
        raiz->dir = Remover(raiz->dir);
      }

      return raiz;
    }

    void igualarRaiz(Node2 *raiz){
        if(raiz == nullptr){
            return;
        }

        int esq = ContarFolhas(raiz->esq);
        int dir = ContarFolhas(raiz->dir);

        if(esq > dir){
            while(esq != dir){
                raiz->esq = Remover(raiz->esq);
                esq = ContarFolhas(raiz->esq);
            }
        } else if(dir > esq){
            while(dir != esq){
                raiz->dir = Remover(raiz->dir);
                dir = ContarFolhas(raiz->dir);
            }
        }

    }

    void imprimirEmOrdem(Node2 *raiz){
        if(raiz == nullptr){
            return;
        }

        imprimirEmOrdem(raiz->esq);
        cout << raiz->info << " ";
        imprimirEmOrdem(raiz->dir);
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

   cout << "Numero de Folhas da arvore e: " << f1.ContarFolhas(raiz) << "\n";
   f1.igualarRaiz(raiz);

   f1.imprimirEmOrdem(raiz);
   

    return 0;
}

