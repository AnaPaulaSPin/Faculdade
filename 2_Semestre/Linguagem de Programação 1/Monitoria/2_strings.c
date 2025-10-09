#include <stdio.h>

int f(char *palavra1, char *palavra2) {
    int i, j;

    // Percorre a palavra1
    for (i = 0; *(palavra1 + i) != '\0'; i++) {
        // Tenta encontrar a palavra2 a partir da posição i
        for (j = 0; *(palavra2 + j) != '\0'; j++) {
            // Se as letras não coincidirem, sai do loop
            if (*(palavra1 + i + j) != *(palavra2 + j)) {
                break;
            }
        }
        // Se j alcança o fim de palavra2, significa que foi encontrada
        if (*(palavra2 + j) == '\0') {
            return 1; // Palavra encontrada
        }
    }
    return 0; // Palavra não encontrada
}

int main(void) {
    char palavra1[10] = "pato";
    char palavra2[10] = "to"; // testar a ocorrência

    int resultado = f(palavra1, palavra2);

    if (resultado == 1) {
        printf("Palavra encontrada!\n");
    } else {
        printf("Palavra não encontrada!\n");
    }

    return 0;
}
