#include <stdio.h>

int main(){
    int C;
    float fah;

    printf("Digite a temperatura: ");
    scanf("%d", &C);

    fah= (C * 9/5) + 32;

    if(fah < 50){
        printf("temp: %2.f Frio", fah);

    }else if(fah>50){
        printf("temp: %2.f Quente", fah);
    }

}