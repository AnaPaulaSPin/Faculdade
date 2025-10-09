#include <stdio.h>
#include <string.h>

typedef struct {
    char nomedolivro[100];
    char autor[50];
    int ano;

}  biblioteca;


int main(){
    
    biblioteca livro1;
        
         strcpy(livro1.nomedolivro, "Alice");
         strcpy(livro1.autor, "Lady gaga");
         livro1.ano = 1920;



    printf("%s\n",livro1.nomedolivro);
    printf("%s\n",livro1.autor);
    printf("%d\n",livro1.ano);

    return 0;
}
