// Faça uma função em C que receba como parâmetro o ponteiro para a raiz de uma árvore binária de 
// pesquisa já criada. A função deverá indicar qual das sub-árvores esquerda ou direita tem o maior
// número de folhas e qual é o número de folhas.


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

    void MaiorFolhaSubArvore(Node2 *raiz){
        if(raiz == nullptr){
            return;
        }

        int esq = ContarFolhas(raiz->esq);
        int dir = ContarFolhas(raiz->dir);

        if(esq > dir){
            cout << "raiz esquerda possui maiores folhas, com: " << esq <<" Folhas";
        } else if(dir > esq){
            cout << "raiz direita possui maiores folhas, com: " << dir << " Folhas";
        } else{
            cout << " As subArvores tem tamanhos de folhas iguais!";
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
   raiz = f1.inserir(raiz, 30);
   raiz = f1.inserir(raiz, 55);
   raiz = f1.inserir(raiz, 51);
   raiz = f1.inserir(raiz, 56);

   cout << "Numero de Folhas da arvore e: " << f1.ContarFolhas(raiz) << "\n";
   f1.MaiorFolhaSubArvore(raiz);

    return 0;
}

