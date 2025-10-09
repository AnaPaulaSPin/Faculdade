#include <stdio.h>

int main(){
    int num, i,j,maior;
    int arr[100];
    i=0;
    printf("Digite os numeros(caso queira parar digite um numero menor que 0): ");

    while(1){
     scanf("%d", &num);

     if(num<0){
        break;
        }else{
            arr[i]=num;
            i++;
        }

    }

    j=i;
    maior=0;
    for(i=0;i<j;i++){
        if(arr[i]>maior){
            maior=arr[i];
        }
    }

    printf("o maior numero digitado foi: %d", maior);


}
