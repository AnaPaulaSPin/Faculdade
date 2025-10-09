#include <iostream>
using namespace std;

struct node{
    int numero;
    struct node *prox;
};

class Lista{
    private:
     node *inicio, *cicloptr;

    public:
    Lista(){
        inicio = nullptr;
        cicloptr = nullptr;
    }

    Lista(node *inicio){
    this->inicio = inicio;
    cicloptr = nullptr;
   }


    
    void mostrar(){
        node *atual = inicio;
        if(inicio == nullptr){
            cout << " Lista vazia, insira numeros!\n";
        } else{
            while(atual != nullptr && atual->prox != cicloptr){
                cout << atual->numero << " ";
                atual = atual->prox;

            }
            cout <<" \n";
        }
    }

    void verificarCiclo(){
        node *num = inicio;
        if(inicio == nullptr){
            cout << "Lista vazia, insira numeros!\n"; return;
        }
        while (num != nullptr) {
            node *aux = num->prox;
            while (aux != nullptr) {
                if (aux == num) {
                    cicloptr = num;
                    break;
                }
                aux = aux->prox;
            }
            if (cicloptr != nullptr) {
                cout << "Ciclo encontrado!\n";
                break;
            }
            num = num->prox;
        }

        if (cicloptr != nullptr) {
            node *aux = cicloptr;
            do {
                cout << aux->numero << " ";
                aux = aux->prox;
            } while (aux != cicloptr);
            cout << "\n";
        } else {
            cout << "Ciclo nao encontrado!\n";
        }
    }

};

int main(){ 

    // Criando os nós manualmente
    node* n1 = new node{1, nullptr};
    node* n2 = new node{2, nullptr};
    node* n3 = new node{3, nullptr};
    node* n4 = new node{4, nullptr};

    // Ligando os nós em sequência
    n1->prox = n2;
    n2->prox = n3;
    n3->prox = n4;
    n4->prox = n2;  // aqui criamos o ciclo: 4 → 2

    Lista f1(n1);
    f1.verificarCiclo();


    return 0;
}
