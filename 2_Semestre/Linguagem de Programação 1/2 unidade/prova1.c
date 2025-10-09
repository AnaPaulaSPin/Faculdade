#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *repetirstring(const char *str, int n){
    int tamstr = strlen(str);
    n = n * tamstr;
    int j = 0;

    char *strycopy = (char*) malloc (n*sizeof(char));

    for(int i = 0; i < n;i++){
        strycopy[i] = str[j];
        j++;
        if(str[j] == '\0'){
            j = 0;
        }

    }
    strycopy[n] = '\0';

    return strycopy;

}

int main(){
    char str[] = "Oi";
    char *strcopy = repetirstring(str, 3);

    printf("%s", strcopy);

}