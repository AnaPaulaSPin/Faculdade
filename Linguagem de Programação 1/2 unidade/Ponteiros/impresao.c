#include <stdio.h>

int main(){
    int n[] ={ 1,2,3};
    int *ptr = n; 

    for(int i = 0; i < 3; i++){
        printf("%d\t", *(i+ptr));
    }
}