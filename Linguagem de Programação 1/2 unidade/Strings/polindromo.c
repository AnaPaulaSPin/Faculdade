// Verificar se uma string é um palíndromo

#include <stdio.h>
#include <string.h>

#define max 20

int main(){
    char str1[]="programacao";
    int n = strlen(str1);
    char str2[max];
    n -=1;

    for(int i = 0; str1[i] != '\0';i++){
        str2[i] = str1[n-i];
    }

    str2[n+1]='\0';

    printf("%s", str2);

    if(strstr(str1,str2)){
        printf("\nA palavra %s e um polindromo\n", str1);
    } else{
        printf("\nA palavra %s nao e um polindromo!",str1);
    }



    return 0;
}