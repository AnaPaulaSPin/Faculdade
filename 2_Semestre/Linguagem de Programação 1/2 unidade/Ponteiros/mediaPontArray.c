#include <stdio.h>

int MediaArray(int *pontArry, int tam){
    int media=0;
    for(int i=0;i<tam;i++){
        media = media + *(pontArry+i);
    }

    return media;
}

int main(){
    int array[]={1,2,3,4};
    int media = 0;
    media = MediaArray(array,4);

    printf("%d", media);


    return 0;
}