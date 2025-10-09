#include <stdio.h>

int main(){
    int n[] ={ 3,5,6,7,8};
    int *ptr = n; 
    int cont=0;

    for(int i = 0; i < 6; i++){
        if(*(ptr+i)%2 != 0){
            cont++;
        }
        
    }
    printf("No vetor existem %d numeros impares", cont);
}