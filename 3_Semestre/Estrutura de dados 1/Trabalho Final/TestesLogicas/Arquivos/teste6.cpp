
#include <iostream>
#include <string>
#include <fstream>   // ifstream
#include <sstream>   // stringstream
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


void salvarListaEmArquivo(Lista* inicio, const string& nomeArquivo) {
    ofstream arquivo(nomeArquivo); // abre para escrita

    if (!arquivo) {
        cout << "Erro ao abrir o arquivo para escrita.\n";
        return;
    }

    Lista* atual = inicio;
    while (atual != nullptr) {
        arquivo << atual->dado->id << ";"
                << atual->dado->escolha << ";"
                << atual->dado->resultado << "\n";
        atual = atual->prox;
    }

    arquivo.close();
    cout << "Lista salva no arquivo com sucesso.\n";
}

void carregarListaDeArquivo(ListaSimples& lista, const string& nomeArquivo) {
    ifstream arquivo(nomeArquivo); // abre o arquivo para leitura

    if (!arquivo) {
        cout << "Erro ao abrir o arquivo para leitura.\n";
        return;
    }

    string linha;
    while (getline(arquivo, linha)) {
        stringstream ss(linha);
        string idStr, escolha, resultado;

        // Pega os valores separados por ';'
        getline(ss, idStr, ';');
        getline(ss, escolha, ';');
        getline(ss, resultado, ';');

        // Cria um novo Node
        Node* novo = new Node;
        novo->id = stoi(idStr); // converte de string para int
        novo->escolha = escolha;
        novo->resultado = resultado;

        // Insere na lista
        lista.InserirElemento(novo);
    }

    arquivo.close();
    cout << "Lista carregada do arquivo com sucesso.\n";
}

int main() {
    ListaSimples f1;

    // Carrega do arquivo em vez de criar na mão
    carregarListaDeArquivo(f1, "dados.txt");

    f1.imprimirElemento();

    // Agora monta a árvore como antes
    ArvoreBinaria b;
    Arvore* raiz = nullptr;

    Lista *atual = f1.getInicio();
    
    while(atual != nullptr){
       raiz = b.inserir(raiz, atual->dado);
       atual = atual->prox;
    }

    b.imprimirEmOrdem(raiz);

    return 0;
}