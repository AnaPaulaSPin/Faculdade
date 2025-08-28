#include <stdio.h>
void Ele(int array[],int n, int *M, int *N){
    *M = 0;
    for(int i=0;i<n;i++){
        if(*M < array[i]){
            *M = array[i];
        }
    }
    *N = 0;
    for(int i=0;i<n;i++){
        if(*M == array[i]){
            *N = *N + 1;
        }
    }

}
int main(){ 
    int array[7]= {1,2,3,4,5,6,6};
   int n = 7;
   int M,N;

    Ele(array,n,&M,&N);

    printf("Numero maior do vetor: %d", M);
    printf("\nEle aparece %d vezes no vetor", N);

    return 0;
}