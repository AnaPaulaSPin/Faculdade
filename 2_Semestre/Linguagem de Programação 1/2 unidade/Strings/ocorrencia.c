// Faça uma função em C que receba duas strings como 
// parâmetros e verifique se a segunda string ocorre dentro da primeira. 

#include <stdio.h>
#include <string.h>

int main(){
    char str1[]="Eu amo programacao";
    char str2[]="amo";

    if(strstr(str1,str2)){
        printf("A segunda string se encontra na primeira");
    } else{
        printf("A segunda string nao se encontra na primeira");
    }
    return 0;
}