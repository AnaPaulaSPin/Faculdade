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
        Node2 *novo, *atual = inicio, *antr = nullptr;
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
        
        while((atual != nullptr) && (novo->info < atual->info)){
            antr = atual;
            atual = atual->prox;
        }
        //caso do ultimo elemento
        if(atual == nullptr){
            antr->prox = novo;
            novo->ant = atual;
            novo->prox = nullptr;
            
        //caso do primeiro elemento
        } else if(atual == inicio){
            novo ->prox = atual;
            atual->ant = novo;
            novo->ant = nullptr;
            inicio = novo;
            
        // caso do meio:
        } else{
            novo->ant = antr;
            antr->prox= novo;
            novo->prox = atual;
            atual ->ant= novo;
        }
    }
    void retirar(int n){
            Node2 *atual = inicio;
            if(inicio == nullptr){
                cout << "Nao existe elementos para retirar!";
                return;
            }
            
            // percorrer a Lista
            while((atual != nullptr) && (n != atual -> info)){
                atual = atual->prox;
            }
            
            // remove o primeiro e unico elemento da lista e finaliza
            if((inicio == atual) && (atual->prox == nullptr)){
                inicio = nullptr;
            }

            // Chegou ao final e nao achou os elementos: 
            if(atual == nullptr){
                cout << "Elemento nao encontrado!";
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
};

int main()
{
    int r; 
    ListaDupla f1;

    while(1){
        cout << "Menu de Lista:\n";
        cout << "1 - Adicionar Elemento\n";
        cout << "2-Retirar Elemento\n";
        cout << "3 - Mostrar a Lista\n";
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
