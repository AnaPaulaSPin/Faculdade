#include <stdio.h>

int Ele(int array[], int n, int *M, int *N){
    int cont = 0; 
    *M = 0; *N = 0;

    for(int i=0;i<n;i++){
        for(int j = 0;j<n;j++){
            if(array[i] == array[j]){
                cont++;
            }
        }
        if(*M < cont){
            *M = cont;
            *N = array[i];
        }
        cont = 0;
    }

    if(*M == 0){
        return 1;
    } else{
        return 0;
    }

}
int main(void){
    int n = 8;
    int N = 0, M=0;
    int array[8]={2,2,3,2,15,16,14,16};

    int result = Ele(array,n, &M,&N);
    if(result == 0){
        printf("\nO Numero que aparece mais vezes no array: %d", N);
        printf("\nEle ocorreu %d vezes no array\n", M);
        printf("...........");


    } else {
        printf("Nao houve numero repetido no array;");
    }
    

    
}