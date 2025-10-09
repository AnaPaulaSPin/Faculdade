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
       }
        if(n> raiz->info){
            raiz->dir = inserir(raiz->dir, n);
        } else if()
        
    }

    void retirar(int n){
            
        }

    void mostrar(){
        
       }
    bool verificarExtritamenteBinaria(Node2 *raiz){
        if(raiz == nullptr){
            return true; // significa que a arvore esta vazia
        }
        if(raiz->dir == nullptr && raiz->esq == nullptr){
            return true; // significa que nao tem filhos
            
        } else{
            if(raiz->dir != nullptr && raiz->esq != nullptr){
               return verificarExtritamenteBinaria(raiz->dir) && verificarExtritamenteBinaria(raiz->esq); // verifica as duas subarvores para verificar se sao extritamente binarias.
                
            } else {
                return false; // significa que tem um filho apenas
            }
        }        
    }

       
};

int main()
{
    int r; 
    Arvore f1;

    f1.inserir(1);
    f1.inserir(2);
    f1.inserir(3);

    while(1){
        cout << "Menu de Lista:\n";
        cout << "1 - Adicionar Elemento\n";
        cout << "2- Retirar Elemento\n";
        cout << "3 - Mostrar a Lista\n";
        cout << "4 - Tirar o antecessor e sucessor \n";
        cout << "5 - Encerrar\n";
        cout << "Escolha: ";
        cin >> r;

        switch (r)
        {
        case 1:{
            int n;
            cout << "Digite o numero que vc quer colocar na Lista: ";
            cin >> n;
            cout <<"\n";
            f1.inserir(n);
            cout <<"\n";
            break;

        }
        case 2:{
            int n;
            cout << "Digite o numero que deseja retirar da Lista: ";
            cin >> n;
            cout <<"\n";

            f1.retirar(n);
            cout <<"\n";

            break;
        }
        case 3:{
            f1.mostrar();
            cout <<"\n";
            break;
        }
        
            
        case 4:{
            cout << "Finalizando o programa!\n";
            break;
        }

        default:
        cout << "Digite uma opcao valida! /n";
            break;
        }

        if(r == 4){
            break;
        }

    }


    return 0;
}
