// testando se é possivel criar um no ordenado numa lista:

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

// Função para criar um novo nó da árvore com o dado recebido
Arvore* criarNo(Node* dado) {
    Arvore* novo = new Arvore;
    novo->dado = dado;
    novo->esquerda = nullptr;
    novo->direita = nullptr;
    return novo;
}

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

// Função para imprimir a árvore em ordem (esquerda, raiz, direita)
void imprimirEmOrdem(Arvore* raiz) {
    if (raiz != nullptr) {
        imprimirEmOrdem(raiz->esquerda);
        cout << "ID: " << raiz->dado->id << " | Escolha: " << raiz->dado->escolha << " | Resultado: " << raiz->dado->resultado << endl;
        imprimirEmOrdem(raiz->direita);
    }
}

int main() {
    // Criando alguns nodes com id e textos
    Node n1 = {50, "Escolha 50", "Resultado 50"};
    Node n2 = {25, "Escolha 25", "Resultado 25"};
    Node n3 = {55, "Escolha 55", "Resultado 55"};
    Node n4 = {5,  "Escolha 5",  "Resultado 5"};
    Node n5 = {30, "Escolha 30", "Resultado 30"};

    Arvore* raiz = nullptr;

    // Inserindo nodes na árvore
    raiz = inserir(raiz, &n1);
    raiz = inserir(raiz, &n2);
    raiz = inserir(raiz, &n3);
    raiz = inserir(raiz, &n4);
    raiz = inserir(raiz, &n5);

    // Imprime a árvore em ordem
    cout << "Árvore em ordem:" << endl;
    imprimirEmOrdem(raiz);

    return 0;
}
