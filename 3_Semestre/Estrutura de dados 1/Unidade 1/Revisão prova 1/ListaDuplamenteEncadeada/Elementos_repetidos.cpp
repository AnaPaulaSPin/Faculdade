#include <iostream>
using namespace std;

#include <iostream>
using namespace std;

struct Node2{
    int info;
    struct Node2 *ant, *prox;
};

class ListaDupla{
    private:
    Node2 *inicio;
    
    public:
    ListaDupla(){
        inicio = nullptr;
    }
    
    void inserir(int n){
        Node2 *novo, *atual;
        novo = new Node2();
        if(novo == nullptr){
            return;
        }
        novo->info = n;
        
        if(inicio == nullptr){
            novo ->ant = nullptr;
            novo ->prox = nullptr;
            inicio = novo;
            return;
        }
        
        atual = inicio;
        
        while((atual->prox != nullptr) && (novo->info > atual->info)){
            atual = atual->prox;
        }
        //caso do ultimo elemento
        if(atual ->prox == nullptr && novo->info > atual->info){
            atual->prox = novo;
            novo->ant = atual;
            novo->prox = nullptr;
            
        //caso do primeiro elemento
        } else if(atual == inicio){
            novo ->prox = inicio;
            inicio->ant = novo;
            novo->ant = nullptr;
            inicio = novo;
            
        // caso do meio:
        } else{
            novo->ant = atual->ant;
            atual->ant->prox = novo;
            novo->prox = atual;
            atual -> ant=novo;
        }
    }
    void retirar(int n){
            Node2 *atual;
            if(inicio == nullptr){
                cout << "Nao existe elementos para retirar!";
                return;
            }
            atual = inicio;
            
            // percorrer a Lista
            while((atual != nullptr) && (n != atual -> info)){
                atual = atual->prox;
            }
            
            // Chegou ao final e nao achou os elementos: 
            if(atual == nullptr){
                cout << "Elemento nao encontrado!";
                return;
            }
            
            // remove o primeiro e unico elemento da lista e finaliza?
            if((inicio == atual) && (atual->prox == nullptr)){
                inicio = nullptr;
                return;
            }
            
            //primeiro elemento
            if(inicio == atual){
                inicio = inicio->prox;
                inicio->ant = nullptr;
            
            //ulitmo elemento:
            } else {
            if(atual -> prox == nullptr)
                atual->ant->prox = nullptr;
                
            // Elemento do meio:
            else{
                atual->ant->prox = atual->prox;
                atual->prox->ant = atual->ant;}
            }
            
            delete atual;
        }
        
        void mostrar(){
        Node2 *atual = inicio;
        if(inicio == nullptr){
            cout << " Lista vazia, insira numeros!\n";
        } else{
            cout << " \n Lista: ";
            while(atual != nullptr){
                cout << atual->info << " ";
                atual = atual->prox;
            }
            cout <<" \n";
        }
       }

       void ElementosRepetidos(){
        Node2 *atual = inicio, *num = inicio, *temp = nullptr;
        if(inicio == nullptr){
            return;
        }
        while(num != nullptr){
            while(atual != nullptr){
                if(atual==num){
                    atual = atual->prox;
                    continue;
                }
                if(atual->info == num->info){
                    temp = atual;
                    if(atual->prox == nullptr){
                        atual->ant->prox = nullptr;
                        delete temp;

                    } else{
                        atual->ant->prox = atual->prox;
                        atual->prox->ant = atual->ant;
                        delete temp;
                    }
                } 
                  atual = atual->prox;
                
            }
            num = num->prox; atual = inicio;
        }
       }
};

int main()
{
    int r; 
    ListaDupla f1;

    f1.inserir(10);
    f1.inserir(20);
    f1.inserir(30);
    f1.inserir(20);
    f1.inserir(40);
    f1.inserir(10);
    f1.inserir(30);
    f1.inserir(50);

    while(1){
        cout << "Menu de Lista:\n";
        cout << "1 - Adicionar Elemento\n";
        cout << "2-Retirar Elemento\n";
        cout << "3 - Retirar Repetidos\n";
        cout << "4 - Mostrar a Lista\n";
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

            system("pause");
            system("cls");
            
            break;

        }
        case 2:{
            int n;
            cout << "Digite o numero que deseja retirar da Lista: ";
            cin >> n;
            cout <<"\n";

            f1.retirar(n);
            cout <<"\n";

            system("pause");
            system("cls");

            break;
        }
        case 3:{
            f1.ElementosRepetidos();

            system("pause");
            system("cls");

            break;
        }

        case 4:{
            f1.mostrar();
            cout <<"\n";

            system("pause");
            system("cls");

            break;
        }

        case 5:{
            cout << "Finalizando o programa!\n";
            break;
        }
        
        default:
        cout << "Digite uma opcao valida! /n";
            break;
        }

        if(r == 5){
            break;
        }

    }
    

    return 0;
}
