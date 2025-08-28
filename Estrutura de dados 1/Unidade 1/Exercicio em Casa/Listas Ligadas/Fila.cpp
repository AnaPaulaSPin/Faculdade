#include <iostream>

using namespace std;

struct fila{
    int numFila;
    struct fila *ptr;
};

    // Criar e adicionar uma pessoa na fila
    void enqueue(fila* &inicio,fila* &fim, int num){

      // criando uma nova pessoa na fila
      fila *novo = new fila;

      // adicionando o valor recebido
      novo->numFila = num;
      novo->ptr = nullptr;
      
      //Verificar se esta vazio, caso sim o primeiro elemento sera o inicio e fim da fila.
      if(fim == nullptr){
         inicio = novo; 
         fim = novo;
     
      //Caso ja tenha elementos ele vai ligar o fim da fila com endereço com a nova variavel:
      } else{
        fim->ptr = novo;
        fim = novo;
      }

    }

    void dequeue(fila* &inicio){
        if(inicio == nullptr){
            cout << "Fila vazia!" << endl;

        } else {
            fila *temp;
            temp = inicio;
            inicio = inicio->ptr;
            delete temp;
        }
    }

    void mostrar(fila *inicio){
        
        if(inicio == nullptr){
            cout << "\nFila Vazia" << endl;

        }else{
            cout << "\nFila: " << endl;
            while(inicio != nullptr){
                cout << inicio->numFila << " ";
                inicio = inicio->ptr;
            }
        }
        
        
    }






int main(){
    fila *inicio = nullptr;
    fila *fim = nullptr;

    enqueue(inicio, fim, 10);
    enqueue(inicio, fim, 20);
    enqueue(inicio, fim, 30);
    mostrar(inicio);

    dequeue(inicio);
    mostrar(inicio);

    dequeue(inicio);
    mostrar(inicio);

    dequeue(inicio);
    mostrar(inicio);


}