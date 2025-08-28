#include <stdio.h>

int main(){
    int num = 10;
    int *pontnum = &num;

    printf("%d", *pontnum);
}