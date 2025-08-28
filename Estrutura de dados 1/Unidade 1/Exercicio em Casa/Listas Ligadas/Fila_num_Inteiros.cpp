#include <iostream>
using namespace std;

struct node{
  int num;
  struct node *prox;

};

class Fila{
    private:
    node *inicio;
    node *fim;

    public:
     Fila(){
        inicio = nullptr;
        fim = nullptr;
    }

    void Enfileirar(int n){
        node *novo = new node;
        if(novo == nullptr){
            cout << "Nao foi possivel alocar memoria!\n";
            return;
        } 
        novo->num = n;
        novo->prox = nullptr;

        if(inicio == nullptr){
            inicio = novo;
        } else{
            fim->prox = novo;
        }
        cout << "Enfileirar numero: " << n << " \n ";
        fim = novo;
    }

    void desenfileirar(){
        node *temp;
        if(inicio == nullptr){
            cout << "Fila vazia, adicione elementos primeiro! \n";
        } else{
            temp = inicio;
            inicio = inicio->prox;
            cout << "Desenfileirar numero: " << temp->num << " \n ";

            delete temp;
        }
    }

    void mostrar(){
        node *temp = inicio; 

        if(inicio == nullptr){
            cout << "Fila vazia, adicione elementos primeiro! \n";

        } else{
            cout << "Fila: ";
            while(temp != nullptr){
                cout << temp->num << " ";
                temp = temp->prox;
            }
        }   
    }
};

int main(){
    int r; 
    Fila f1;

    while(1){
        cout << "Menu de Fila:\n";
        cout << "1 - Enfileirar\n";
        cout << "2- Desenfileirar\n";
        cout << "3 - Mostrar Fila\n";
        cout << "4 - Encerrar\n";
        cout << "Escolha: ";
        cin >> r;

        switch (r)
        {
        case 1:{
            int n;
            cout << "Digite o numero que vc quer colocar na fila: ";
            cin >> n;
            cout <<"\n";
            f1.Enfileirar(n);
            cout <<"\n";
            break;

        }
        case 2:{
            f1.desenfileirar();
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
