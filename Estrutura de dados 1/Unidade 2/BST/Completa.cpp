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
         if(n > raiz->info){
            raiz->esq = inserir(raiz->esq, n);
         } else if( n < raiz->info){
            raiz->dir = inserir(raiz->dir, n);
         } else{
            cout << "Numero repetido";
         }

         return raiz;
       } 
    }

    void emOrdem(Node2 *raiz){
        if(raiz == nullptr){
            return;
        } else{
            emOrdem(raiz->esq);
            cout << raiz->info << " ";
            emOrdem(raiz->dir);
        }
    }

    void preOrdem(Node2 *raiz){
        if(raiz == nullptr){
            return;
        } else{
            cout << raiz->info << " ";
           preOrdem(raiz->esq);
           preOrdem(raiz->dir);
        }
    }

    void posOrdem(Node2 *raiz){
     if(raiz == nullptr){
            return;
     } else{
        preOrdem(raiz->esq);
        preOrdem(raiz->dir);
        cout << raiz->info << " ";
        }
    }

       
};

int main()
{
   Arvore f1;
   Node2 *raiz = nullptr;
   int n;
   raiz = f1.inserir(raiz, 50);
   raiz = f1.inserir(raiz, 25);
   raiz = f1.inserir(raiz, 5);
   raiz = f1.inserir(raiz, 30);
   raiz = f1.inserir(raiz, 55);

   while(1){
    cout << " 1- Inserir\n";
    cout << "2- Remover\n";
    cout << "3 - Impressao\n";
    cout << "4 - Busca\n";
    cout << "5 - sair";
    cout << "Opcao: ";
    cin >> n;


    switch (n)
    {
    case 1:{
      
      break;
    }

    case 2: {

      break;
    }

    case 3: {

        break;
    }
    case 4: {
        break;
    }
    case 5:{

        cout << "parando o programa...";
        break;
    }
    
    default:
        cout << "Opcao invalida!";
        break;
    }

    if(n == 5){
        break;
    }
    system("pause");
    system("cls");

   }

    return 0;
}
