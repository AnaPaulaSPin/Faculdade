#include <stdio.h>
#define max 50

typedef struct
{
    char Nome[max];
    float nota;

} Disciplina;

Disciplina Historia[25];
Disciplina Portugues[25];
Disciplina Matematica[25];

int Media();
void Lista();
int Adicionardisciplina();
