// Implemente uma função que, dada uma árvore binária, verifique se existe algum caminho da raiz até alguma folha que tenha soma dos valores igual a um valor S passado como parâmetro.

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

    bool CaminhoSoma(Node2 *raiz,int valor, int soma){
        if(raiz == nullptr){
            return false;
        }
        soma += raiz->info;
        if(soma == valor){
            return true;
        } else if(soma > valor){
            return false;
        } 
            return CaminhoSoma(raiz->dir, valor, soma) || CaminhoSoma(raiz->esq, valor, soma);
        
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

   int valor = 180;
   bool validar = f1.CaminhoSoma(raiz,valor,0);
   if(validar){
    cout << "existe um caminho que somado os nos da " << valor << "!";
   } else{
    cout << "nao existe um caminho que somado os nos da " << valor << "!";
   }
   

    return 0;
}

