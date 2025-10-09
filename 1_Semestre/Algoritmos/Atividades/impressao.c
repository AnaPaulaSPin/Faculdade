#include <stdio.h>

int main() {
    int V[10], i, neg;
    neg = 0;
    
    for(i=0;i<10;i++){
     scanf("%d", &V[i]);
     if(V[i]<=0)
        neg= neg+1;
     }

    for(i=0;i<10;i++){
      printf("\n%d ", V[i]);
      }

    printf("\n\n%d", neg);

  return 0;
}