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

       void RemoverNos(int x){
        Node2 *atual = inicio,*proximo, *antr = inicio;
        while(atual != nullptr){
            proximo = atual->prox;

            if(atual->info == x){
                 // caso do elemento no meio, mas so temos 3 elementos: 
                if(atual->ant->ant == nullptr && atual->prox->prox == nullptr){
                    inicio = atual;

                    atual->ant = nullptr;
                    atual->prox = nullptr;
                } else
                // caso do primeiro elemento
                if(atual == inicio){
                    atual->prox = atual->prox->prox;
                    
                    atual->prox->prox->ant = atual;
                    delete proximo;

                 // caso do ultimo elemento
                }else if(atual->prox == nullptr){
                   atual->ant = atual->ant->ant;
                    
                   atual->ant->ant->prox = atual;
                    delete antr;
                } 

                    // caso de existir o sucessor do sucessor do atual mas 
                    // o antecessor do antecessor do atual nao existir:
                  else if(atual->ant == inicio){
                    atual->prox = atual->prox->prox;
                    atual->ant = nullptr;
                      
                    atual->prox->prox->ant = atual;
                    inicio = atual;                      
                    delete proximo; delete antr;

                 // caso de existir o antecessor do antecessor do atual
                 // mas o sucessor do sucessor do atual nao existir
                 }else if(atual->prox->prox == nullptr){
                    atual->ant = atual->ant->ant;
                    atual->prox = nullptr;
                      
                    atual->ant->ant->prox = atual;                    
                    delete antr; delete proximo;

                    // caso do meio:
                   } else{
                    atual->ant = atual->ant->ant;
                    atual->prox = atual->prox->prox;
                      
                    atual->prox->prox->ant = atual;
                    atual->ant->ant->prox = atual;
                    delete proximo; delete antr;
                }
            }

          antr = atual;
          atual = atual->prox;
         }

    }
};

int main()
{
    int r; 
    ListaDupla f1;

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
            int n;
            cout << "Digite o numero que deseja retirar o antecessor e sucessor: ";
            cin >> n;
            f1.RemoverNos(n);
            cout <<"\n";
            f1.mostrar();
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
