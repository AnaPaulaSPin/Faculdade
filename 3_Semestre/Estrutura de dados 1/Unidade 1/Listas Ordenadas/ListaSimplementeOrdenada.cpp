#include <iostream>
using namespace std;

struct node{
    int numero;
    struct node *prox;
};

class Lista{
    private:
     node *inicio;

    public:
    Lista(){
        inicio = nullptr;
    }

    void InserirElemento(int n){
        node *novo;
        novo = new node;
        if(novo == nullptr){
            cout <<"Nao foi possivel alocar memoria\n";
            return;
        } 
        novo->numero = n;
        if(inicio == nullptr){
            inicio = novo;
            novo->prox = nullptr;

        } else{
            node *atual = inicio, *ant = inicio;

            while(atual != nullptr && novo->numero > atual->numero){
                ant = atual;
                atual = atual->prox;

            }

            if(atual == nullptr){
                ant->prox = novo;
                novo->prox = nullptr;
            } else if(atual == ant){
                novo->prox = inicio;
                inicio = novo;
            } else{
                ant->prox = novo;
                novo->prox = atual;
            }
        }
    }

    void retirarNumero(int n){
        node *temp;
        if(inicio == nullptr){
            cout << "Lista sem elementos para retirar!\n";
        } else{
            node *atual = inicio,*ant = inicio;
            while(atual != nullptr && n != atual->numero){
                ant = atual;
                atual = atual->prox;
            }
            if(atual == nullptr){
                cout << "Elemento nao encontrado\n";
            } else if(atual == ant){
                temp = atual;
                inicio = atual->prox;
                delete temp;
            } else if(atual->numero == n && atual->prox == nullptr){
                temp = atual;
                ant->prox = nullptr;
                delete temp;
            } else {
                temp = atual;
                ant->prox = atual->prox;
                delete temp;
            }
        }
    }
    void mostrar(){
        node *atual = inicio;
        if(inicio == nullptr){
            cout << " Lista vazia, insira numeros!\n";
        } else{
            while(atual != nullptr){
                cout << atual->numero << " ";
                atual = atual->prox;

            }
            cout <<" \n";
        }
    }

};

int main(){
    int r; 
    Lista f1;

    while(1){
        cout << "Menu de Fila:\n";
        cout << "1 - Inserir\n";
        cout << "2- Retirar\n";
        cout << "3 - Mostrar\n";
        cout << "4 - Encerrar\n";
        cout << "Escolha: ";
        cin >> r;

        switch (r)
        {
        case 1:{
            int n;
            cout << "Digite o numero que vc quer colocar na Lista: ";
            cin >> n;
            cout <<"\n";
            f1.InserirElemento(n);
            cout <<"\n";
            break;

        }
        case 2:{
            int n;
            cout << "Digite o numero que deseja retirar da Lista: ";
            cin >> n;
            cout <<"\n";

            f1.retirarNumero(n);
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

        system("pause");
        system("cls");

    }
    
    return 0;
}
