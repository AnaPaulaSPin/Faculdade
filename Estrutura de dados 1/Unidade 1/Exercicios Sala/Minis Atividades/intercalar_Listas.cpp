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

    Lista(node *inicio){
    this->inicio = inicio;
   }



    void mostrar(node *z){
        node *atual = z;
        if(z == nullptr){
            cout << " Lista vazia, insira numeros!\n";
        } else{
            while(atual != nullptr){
                cout << atual->numero << " ";
                atual = atual->prox;

            }
            cout <<" \n";
        }
    }

node* intercalar(node* x, node* y) {
    node* z = nullptr; // início da nova lista
    node* fim = nullptr; // fim da nova lista

    while (x != nullptr && y != nullptr) {
        // Adiciona x
        if (z == nullptr) {
            z = x;
            fim = x;
        } else {
            fim->prox = x;
            fim = fim->prox;
        }
        x = x->prox;

        // Adiciona y
        fim->prox = y;
        fim = fim->prox;
        y = y->prox;
    }

    // Adiciona o restante de x ou y
    if (x != nullptr) fim->prox = x;
    if (y != nullptr) fim->prox = y;

    return z;
}

};

int main(){ 

    // Criando os nós manualmente
    node* n1 = new node{1, nullptr};
    node* n2 = new node{2, nullptr};
    node* n3 = new node{3, nullptr};
    node* n4 = new node{4, nullptr};
    node* n8 = new node{5, nullptr};

    // Ligando os nós em sequência
    n1->prox = n2;
    n2->prox = n3;
    n3->prox = n4;
    n4->prox = n8;
    n8->prox = nullptr;

    node* n5 = new node{5, nullptr};
    node* n6 = new node{6, nullptr};
    node* n7 = new node{7, nullptr};


    n5->prox = n6;
    n6->prox = n7;
    n7->prox = nullptr;

    Lista f1(n1);
    node *z = f1.intercalar(n1,n5);
    f1.mostrar(z);


    return 0;
}
