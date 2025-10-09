#include <stdio.h>
int Ocorrencia(char *string1, char *string2){
    int cont = 0;

    for(int i = 0; *(string1 + i) != '\0';i++){
        for(int j = 0; *(string2 + j) != '\0';j++){
            if(*(string1+i+j)== *(string2+j)){
                break;
            }
            cont++;
        }
        if(string2[cont]=='\0'){
            return 1;
        } else
          cont = 0;

    }
    return 0;

}

int main(void) {
    char palavra1[10] = "pato";
    char palavra2[10] = "to"; // testar a ocorrência

    int resultado = Ocorrencia(palavra1, palavra2);

    if (resultado == 1) {
        printf("Palavra encontrada!\n");
    } else {
        printf("Palavra não encontrada!\n");
    }

    return 0;
}
