#include <stdio.h>

int main(){
    int num, i,j,soma;
    int arr[100];
    i=0;
    printf("Digite os numeros(caso queira parar aperte 0): ");

    while(1){
     scanf("%d", &num);

     if(num==0){
        break;

     } else{
         arr[i]=num;
         i++;
        }
    }

    j=i;
    soma=0;
    for(i=0;i<j;i++){
        soma+=arr[i];
    }

    printf("a soma de todos os numeros foi: %d", soma);


}
