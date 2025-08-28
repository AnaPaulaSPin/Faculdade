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
                inicio = atual->prox;
                
            } else if(atual->numero == n && atual->prox == nullptr){
                ant->prox = nullptr;
                
            } else {
                ant->prox = atual->prox;
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

   node* RetirarPrimos(node *primo) {
    node *atual = inicio;
    node *antAtual = nullptr;

    while (atual != nullptr) {
        node *proximo = atual->prox; // guarda o próximo, antes de mexer no atual

        if (this->verificarPrimos(atual->numero)) {
            // Remover da lista original
            if (atual == inicio) {
                inicio = proximo;
            } else {
                antAtual->prox = proximo;
            }

            // Inserir na lista de primos (ordenada)
            if (primo == nullptr || atual->numero < primo->numero) {
                atual->prox = primo;
                primo = atual;
            } else {
                node *aux = primo;
                while (aux->prox != nullptr && aux->prox->numero < atual->numero) {
                    aux = aux->prox;
                }
                atual->prox = aux->prox;
                aux->prox = atual;
            }
        } else {
            // Só atualiza antAtual se o nó não foi retirado
            antAtual = atual;
        }

        atual = proximo;
    }

    if (primo == nullptr) {
        cout << "Não foi possível encontrar elementos primos!\n";
    }

    return primo;
}


    bool verificarPrimos(int num){
        for(int i=2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    void mostrarPrimo(node *primo){
        node *atual = primo;
        if(atual == nullptr){
            cout << " Lista vazia, nao contem ainda nenhum numero primo!\n";
        } else{
            while(atual != nullptr){
                cout << atual->numero << " ";
                atual = atual->prox;

            }
            cout <<" \n";
        }
    }

    void retirarPares(){
        node *atual = inicio;

        while(atual != nullptr){
            if(atual->numero % 2 == 0){
                this->retirarNumero(atual->numero);
            }

        atual = atual->prox;
        }
    }

};

int main(){
    int r; 
    Lista f1;
    node *primo = nullptr;

    f1.InserirElemento(1);
    f1.InserirElemento(2);
    f1.InserirElemento(3);
    f1.InserirElemento(4);
    f1.InserirElemento(5);
    f1.InserirElemento(6);
    f1.InserirElemento(7);
    f1.InserirElemento(8);
    f1.InserirElemento(9);

    while(1){
        cout << "Menu de Fila:\n";
        cout << "1 - Inserir\n";
        cout << "2- Retirar\n";
        cout << "3 - Mostrar lista\n";
        cout << "4 - Retirar Numeros primos\n";
        cout << "5 - Mostrar Lista de Primos\n";
        cout << "6 - Retirar Pares \n";
        cout << "7 - Encerrar\n";
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
            system("pause");
            cout <<"\n";

            break;
        }
        case 3:{
            f1.mostrar();
            system("pause");
            cout <<"\n";
            break;
        }

        case 4:{
            cout << "Retirar Numeros primos\n";
            primo = f1.RetirarPrimos(primo);
            system("pause");
            break;
        }

        case 5:{
            cout << "Mostrar Lista de Primos\n";
            f1.mostrarPrimo(primo);
            system("pause");
            break;
        }

        case 6:{
            cout << "Retirar Pares\n";
            f1.retirarPares();
            system("pause");
            break;
        }

        case 7:{
            cout << "Finalizando o programa!\n";
            break;
        }
        
        default:
        cout << "Digite uma opcao valida! /n";
            break;
        }

        if(r == 7){
            break;
        }

        system("cls");
    }

    return 0;
}
