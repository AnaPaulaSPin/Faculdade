#include <stdio.h>

void incre(int *ptr){
    *ptr + 1;

}

int main(){
    int num = 10;

    incre(&num);

    printf("%d", num);
}