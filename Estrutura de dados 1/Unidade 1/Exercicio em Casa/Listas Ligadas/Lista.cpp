//terminar de ajeitar
#include <iostream>
using namespace std;

struct node{
  int num;
  struct node *prox;

};

class Lista{
    private:
    node *inicio;
    node *fim;

    public:
     Lista(){
        inicio = nullptr;
        fim = nullptr;
    }

    void Inserir(int n){
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
        cout << "Inseriu numero: " << n << " \n ";
        fim = novo;
    }

    void Retirar(int n){
        node *temp;
        if(inicio == nullptr){
            cout << "Lista vazia, adicione elementos primeiro! \n";
        } else{
            temp = inicio;
            inicio = inicio->prox;
            cout << "Retirar numero: " << temp->num << " \n ";

            delete temp;
        }
    }

    void mostrar(){
        node *temp = inicio; 

        if(inicio == nullptr){
            cout << "Lista vazia, adicione elementos primeiro! \n";

        } else{
            cout << "Lista: ";
            while(temp != nullptr){
                cout << temp->num << " ";
                temp = temp->prox;
            }
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
        cout << "3 - Mostrar Fila\n";
        cout << "4 - Encerrar\n";
        cout << "Escolha: ";
        cin >> r;

        switch (r)
        {
        case 1:{
            int n;
            cout << "Digite o numero que vc quer retirar da lista: ";
            cin >> n;
            cout <<"\n";
            f1.Inserir(n);
            cout <<"\n";
            break;

        }
        case 2:{
            int n;
            cout << "Digite o numero que vc quer retirar da lista: ";
            cin >> n;

            f1.Retirar(n);
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
