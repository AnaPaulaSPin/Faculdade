// Crie uma função que concatene duas strings em uma nova string alocada dinamicamente com o tamanho apropriado.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* conctane( char *str1, char *str2){
    int num1 = strlen(str1);
    int num2 = strlen(str2);
    int total = num1+num2;

    char *ptr = (char*) malloc((total+1)*sizeof(char)+1);
    ptr[0] = '\0';

    strcat(ptr, str1);
    strcat(ptr,str2);
  

    return ptr;

}

int main(){
    char string1[]= "hellow";
    char string2[]= "World";

    char *array = conctane(string1,string2);

    printf("%s", array);
    free(array);

    return 0;
}