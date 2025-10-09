// criando uma lista de nodes e inserindo em uma arvore:

#include <iostream>
#include <string>
using namespace std;

struct Node {
    int id;
    string escolha;
    string resultado;
};

struct Arvore {
    Node* dado;
    Arvore* esquerda;
    Arvore* direita;
};


struct Lista{
    Node *dado;
    struct Lista *prox;
};

// Função para criar um novo nó da árvore com o dado recebido
Arvore* criarNo(Node* dado) {
    Arvore* novo = new Arvore;
    novo->dado = dado;
    novo->esquerda = nullptr;
    novo->direita = nullptr;
    return novo;
}

class ListaSimples{
    private:
     Lista *inicio;

    public:
    ListaSimples(){
        inicio = nullptr;
    }

    Lista *getInicio(){
      return inicio;
    }

void InserirElemento(Node *elemento){
        Lista *novo;
        novo = new Lista;
        if(novo == nullptr){
            cout <<"Nao foi possivel alocar memoria\n";
            return;
        } 
        novo->dado = elemento;

        if(inicio == nullptr){
            inicio = novo;
            novo->prox = nullptr;

        } else{
            Lista *atual = inicio, *ant = inicio;

            while(atual != nullptr){
                ant = atual;
                atual = atual->prox;

            }
                ant->prox = novo;
                novo->prox = nullptr;
        }
    }

    void imprimirElemento(){        
        if(inicio == nullptr){
            cout << "Nao existe lista";
            return;
        }
        Lista *atual = inicio;

        while(atual != nullptr){
            cout << atual->dado->id << " ";
            atual = atual->prox;

        }
    }
};

class ArvoreBinaria{
    public:
  // Função para inserir um dado na árvore binária com base no id
   Arvore* inserir(Arvore* raiz, Node* dado) {
    if (raiz == nullptr) {
        // Árvore vazia: cria o nó
        return criarNo(dado);
    }

    if (dado->id < raiz->dado->id) {
        // Vai para a subárvore esquerda
        raiz->esquerda = inserir(raiz->esquerda, dado);
    } else if (dado->id > raiz->dado->id) {
        // Vai para a subárvore direita
        raiz->direita = inserir(raiz->direita, dado);
    } else {
        // id igual: aqui pode decidir o que fazer (ignorar ou atualizar)
        cout << "ID " << dado->id << " já existe na árvore." << endl;
    }

    return raiz;
    }

   // Função para imprimir a árvore em ordem (esquerda, raiz, direita) - Vamos imprimir no jogo por Altura
   void imprimirEmOrdem(Arvore* raiz) {
    if (raiz != nullptr) {
        imprimirEmOrdem(raiz->esquerda);
        cout << raiz->dado->id << " ";
        imprimirEmOrdem(raiz->direita);
    }
  }
};

int main() {
    // Criando alguns nodes com id e textos
    Node n1 = {50, "Escolha 50", "Resultado 50"};
    Node n2 = {25, "Escolha 25", "Resultado 25"};
    Node n3 = {55, "Escolha 55", "Resultado 55"};
    Node n4 = {5,  "Escolha 5",  "Resultado 5"};
    Node n5 = {30, "Escolha 30", "Resultado 30"};

    ListaSimples f1;

    f1.InserirElemento(&n1);
    f1.InserirElemento(&n2);
    f1.InserirElemento(&n3);
    f1.InserirElemento(&n4);
    f1.InserirElemento(&n5);

    f1.imprimirElemento();
    ArvoreBinaria b;
    Arvore* raiz = nullptr;

    Lista *atual = f1.getInicio();
    cout << "\n";

    while(atual != nullptr){
       raiz = b.inserir(raiz, atual->dado);
       atual = atual->prox;
    }

    b.imprimirEmOrdem(raiz);

    return 0;
}
