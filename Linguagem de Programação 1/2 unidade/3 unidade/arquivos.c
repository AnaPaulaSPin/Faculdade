#include <stdio.h>

FILE *arquivo; // Ponteiro global para o arquivo

// Função para criar e abrir o arquivo
void criarArquivo(const char *nomeArquivo) {
    arquivo = fopen(nomeArquivo, "a"); // Abrir o arquivo para adicionar os dados
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo!\n");
        return;
    }
}

// Função para registrar pontuação
void registrarPontuacao(const char *nome, int pontuacao) {
    if (arquivo != NULL) {
        fprintf(arquivo, "%s %d\n", nome, pontuacao); // Adiciona a pontuação no arquivo
        fclose(arquivo);  // Fecha o arquivo após a gravação
    }
}

// Função para exibir o ranking
void exibirRank() {
    // Reabre o arquivo apenas para leitura
    arquivo = fopen("rank.txt", "r");
    if (arquivo != NULL) {
        char nome[50];
        int pontuacao;
        printf("Ranking:\n");
        while (fscanf(arquivo, "%s %d", nome, &pontuacao) == 2) {
            printf("%s: %d pontos\n", nome, pontuacao);
        }
        fclose(arquivo);  // Fecha o arquivo após a leitura
    }
}

int main() {
    // Cria e abre o arquivo
    criarArquivo("rank.txt");

    // Registra pontuações no arquivo
    registrarPontuacao("Ana", 150);
    registrarPontuacao("Carlos", 200);

    // Exibe o ranking
    exibirRank();

    return 0;
}
