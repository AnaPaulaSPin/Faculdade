#include <iostream>

using namespace std;
#define TAM 5

class FilaBanco {
    //atributos:
    private:
    int inicio; // Indica o indice do primeiro a sair da fila
    int fim; // Indica o indice do ultimo lugar da fila(que pode entrar mais clientes)
    int qtdFila; // Variavel extra que indica a quantidade de locais ocupados na fila
    char fila[TAM];

    public:
    //contrustor:
    FilaBanco(){
        this->inicio = 0;
        this->fim = 0;
        this->qtdFila = 0;
    }

    bool filaCheia(){
       return qtdFila == TAM; //se os lugares ocupados for igual ao limite de tamanho da fila retorna verdadeiro
    }

    bool filaVazia(){
        return qtdFila == 0; // se os valores ocupados forem nenhum, retorna verdadeiro
    }

    // Função enfileira(entrar na Fila)
    void entrarClient(char numCliente){
       if(filaCheia()){
        cout << "Fila Cheia! Espere os clientes serem chamados para entrar na fila! " << endl;
        return;

       } else{
         fila[fim] =  numCliente;
         fim = (fim + 1) % TAM;
         qtdFila++;


       }
    }

    void chamarAtendimento(){
        if(filaVazia){
            cout << "Fila vazia! Pode entrar clientes!" << endl;
        } else {
            fila[inicio] = '0';
            inicio = (inicio + 1) % TAM;
            qtdFila--;
        }
    }

    void imprimirFila(){
        int cont = 0;
        int atual = inicio;
        

        cout << "Fila: " << endl;

        while(cont < qtdFila){
            cout << fila[inicio] << " ";
            atual = (atual + 1) % TAM; // ele vai atualizar o valor e garantir que caso precise faça uma volta de novo! exemplo: se o inicio estiver no [4], ele vai voltar pro 0.
            cont++;

           
            
        }
    }

};




int main(){

    return 0;
}