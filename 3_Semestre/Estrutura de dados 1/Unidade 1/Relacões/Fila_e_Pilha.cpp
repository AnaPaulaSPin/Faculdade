#include <iostream>
#define MAX 5
using namespace std;

class Fila {
    private:
    int v[MAX];
    int inicio, fim, qtd;

    public: 
    Fila(){
        inicio = 0; fim = 0; qtd = 0;
    }

    void enfileirar(int n){
        if(fim == MAX){
            cout << "Fila Cheia!";
        } else {
            v[fim] = n;
            fim++; qtd++;
            cout << "Cliente numero: " << n << " Acabou de entrar na fila\n";
            cout << "________________________________________\n";
        }
    }
    int desenfileirar(){
        if(qtd == 0){
            cout << "\nFila vazia";
        } else{
            int n = v[inicio];
            cout << "\nCliente numero: " << v[inicio] << " se direcione pro atendimento!\n";
            cout << "________________________________________\n\n";
            inicio ++; qtd --;
            return n;
        }
        return 0;
    }
    void mostrarFila(){
        if(qtd == 0){
            cout << "\nFila vazia";
        } else{
            cout << "\nFila: ";
            for(int i = inicio; i < fim; i++){
                cout << v[i] << " ";
            }
        }
    }
};

class Pilha{
    private:
    int V[MAX];
    int topo;

    public:
    Pilha(){
        topo = -1;
    }
    void empilhar(int n){
        if(topo == MAX){
            cout << "Atendimento cheioo";
        } else{
            topo++;
            V[topo] = n;
            cout << "Cliente numero: " << n << " esta indo para o atendimento\n";
            cout << "================================================\n";
        }
    }
    void desempilhar(){
        if(topo == -1){
            cout << "\nAtendimento vazio!";
        } else{
            cout << "\nCliente numero " << V[topo] << " Acaba de ser atendido!\n";
            cout << "========================================\n";
            topo --;
        }
    }
    void mostrarPilha(){
        if(topo == -1){
            cout << "\nAtendimento vazio!";
        } else{
            cout << "\nEm atendimento: ";
            for(int i = topo; i >= 0; i--){
                cout << V[i] << " ";
            }
        }
    }
};

int main(){
    Fila f1;int n;
    Pilha p1;

    cout << "\n";
    f1.enfileirar(10);
    f1.mostrarFila();

    cout << "\n";
    n = f1.desenfileirar();

    cout << "\n";
    p1.empilhar(n);
    p1.mostrarPilha();

    cout << "\n";
    f1.enfileirar(11);
    f1.mostrarFila();

    cout << "\n";
    n = f1.desenfileirar();

    cout << "\n";
    p1.empilhar(n);
    p1.mostrarPilha();

    p1.desempilhar();
    p1.desempilhar();

    p1.mostrarPilha();


    return 0;
}