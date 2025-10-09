#include <iostream>
using namespace std;

struct node
{
    string palavra;
    struct node *prox, *ant;
};

class Editor
{
private:
    node *inicio, *atual, *fim;

public:
    Editor()
    {
        inicio = nullptr;
        atual = nullptr;
        fim = nullptr;
    }

    void InserirElemento(string n)
    {
        node *novo;
        novo = new node;
        if (novo == nullptr)
        {
            cout << "Nao foi possivel alocar memoria\n";
            return;
        }
        novo->palavra = n;

        // Primeiro elemento a ser digitado:
        if (inicio == nullptr)
        {
            novo->prox = novo;
            novo->ant = novo;
            fim = novo;
            inicio = novo;
            atual = novo;

            // Caso o elemento seja digitado no "fim' da lista: (aponta pro fim) |Ed| <- |Aula| -> |de|-> |Ed| -> |aula| (aponta para o inicio)
        }
        else if (atual->prox == inicio)
        {
            novo->ant = atual;
            novo->prox = inicio;
            inicio->ant = novo;
            atual->prox = novo;
            fim = novo;
        }
        // Caso o elemento seja digitado no meio da lista:
        else
        {
            novo->prox = atual->prox;
            novo->ant = atual;
            atual->prox->ant = novo;
            atual->prox = novo;
        }

        atual = novo;
    }

    void retirarPalavra()
    {
        node *temp;

        if (inicio == nullptr)
        {
            cout << "Lista sem elementos para retirar!\n";
            return;
            
        }
        else {
            temp = atual;
            if (atual->ant == fim && atual->prox == inicio)
            {
                inicio = nullptr; fim = nullptr;
                delete temp;

                // Caso o elemento que vamos retirar esteja no "fim" da lista:
            }
            // Caso o elemento que vamos retirar esteja no inicio da lista:
            if (atual->ant == fim)
            {
                atual->prox->ant = fim;
                fim->prox = atual->prox;
                atual = atual->prox;
                inicio = atual;
                delete temp;

                // Caso o elemento que vamos retirar esteja no "fim" da lista:
            }
            else if (atual->prox == inicio)
            {
                atual->prox->ant = atual->ant;
                atual->ant->prox = inicio;
                atual = atual->prox;
                fim = atual;
                delete temp;

                // Caso o elemento que vamos retirar esteja no meio da lista:
            }
            else
            {
                atual->ant->prox = atual->prox;
                atual->prox->ant = atual->ant;
                atual = atual->prox;
                delete temp;
            }
        }
    }

    void mostrar()
    {
        node *pos = inicio;
        if (inicio == nullptr)
        {
            cout << " Lista vazia, insira as palavras o frases!\n";
        }
        else {
            do {
                if (pos == atual)
                {
                    cout << "\033[1;31m" << pos->palavra << "\033[0m ";
                }
                else
                {
                    cout << pos->palavra << " ";
                }
                pos = pos->prox;
            } while (pos != inicio);
            cout << " \n";
            cout << " A palavra em vermelho eh a sua atual!";
            cout << " \n";
        }
    }

    void moverDireita(){
       if(inicio == nullptr){
        return;
       }
       atual = atual->prox;
    }

    void moverEsquerda(){
        if(inicio == nullptr){
        return;
       }
       atual = atual->ant;
    }

    void mudarPalavra(string n){
        if(inicio == nullptr){
            return;
        }
        atual->palavra = n;
    }
};

int main()
{
    int r;
    Editor f1;

    while (1)
    {
        cout << "Menu do Editor de Texto:\n";
        cout << "1 - Inserir (depois da palavra atual)\n";
        cout << "2- Eliminar palavra\n";
        cout << "3- Editar a palavra\n";
        cout << "4 - Mostrar seu texto \n";
        cout << "5 - Mover para direita\n";
        cout << "6 - Mover para esquerda\n";
        cout << "7 - Encerrar\n";
        cout << "Escolha: ";
        cin >> r;

        switch (r)
        {
        case 1:
        {
            string n;
            cout << "Digite a palavra que vc quer adicionar: ";
            cin >> n;
            cout << "\n";

            f1.InserirElemento(n);

            f1.mostrar();
            cout << "\n";

            system("pause");
            system("cls");

            break;
        }
        case 2:
        {

            cout << "\n";
            f1.retirarPalavra();
            cout << "\n";

            f1.mostrar();
            cout << "\n";

            system("pause");
            system("cls");

            break;
        }
        case 3:
        {
            string n;
            cout << "Digite a palavra que vc quer substituir: ";
            cin >> n;
            cout << "\n";

            f1.mudarPalavra(n);

            f1.mostrar();
            cout << "\n";

            system("pause");
            system("cls");

            break;
        }

        case 4:
        {
            f1.mostrar();
            cout << "\n";

            system("pause");
            system("cls");

            break;
        }
        case 5:
        {
            cout << "movendo para direita...\n";
            f1.moverDireita();

            f1.mostrar();
            cout << "\n";

            system("pause");
            system("cls");
            break;
        }

        case 6:{
            cout << "movendo para esquerda...\n";
            f1.moverEsquerda();

            f1.mostrar();
            cout << "\n";

            system("pause");
            system("cls");

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

        if (r == 7)
        {
            break;
        }
    }

    return 0;
}
