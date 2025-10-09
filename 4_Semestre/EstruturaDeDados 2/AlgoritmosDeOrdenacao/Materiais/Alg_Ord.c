#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <locale.h>
#define TAM 11 //  10 elementos o sentinela na pos 0
typedef int Indice;
typedef struct {
            Indice Chave;
            /*outros componentes */
            } Item;

typedef Item Vetor[TAM];
Vetor A;
// Imprimir vetor

void Imprimir(Item *A)
{ int i;
  printf("\n\n  Vetor\n");
  for (i=1; i< TAM; i++)
    printf("  %d  ", A[i].Chave);
  printf("\n\n");
}

void Prencher(Item *A)
{
    A[0].Chave = 0;
    A[1].Chave = 3;
    A[2].Chave = 5;
    A[3].Chave = 4;
    A[4].Chave = 1;
    A[5].Chave = 7;
    A[6].Chave = 6;
    A[7].Chave = 8;
    A[8].Chave = 2;
    A[9].Chave = 9;
    A[10].Chave = 12;

}
// Protótipos


void Selecao (Item *A, int n);
void Insercao(Item *A, Indice *n);
void Shellsort (Item *A, Indice *n);
void shellsort2(Item *v, int n);
void Particao(Indice Esq, Indice Dir, Indice *i, Indice *j, Item *A);
void Ordena(Indice Esq, Indice Dir, Item *A);
void QuickSort(Item *A, Indice *n);
void Refaz(Indice Esq, Indice Dir, Item *A);
void Constroi(Item *A, Indice n);
void Heapsort(Item *A, Indice *n);
void merge(Item *A, int esquerda, int meio, int direita);
void mergeSort(Item *A, int esquerda, int direita);





int main()
{
    char op;
    int n;
    setlocale(LC_ALL,"");
    for(;;){
       system("cls");

      printf("\n----------------------------------");
      printf("\n    ORDENAÇÃ0\n\n");
      printf("\n S: Seleção");
      printf("\n I: Insersão");
      printf("\n L: Shellsort");
      printf("\n Q: Quicksort");
      printf("\n H: Heapsort");
      printf("\n M: Mergesort");
      printf("\n X: Sair");
      printf("\n\n\n Digite sua opcao: ");
      scanf("%c",&op);
      if (islower(op))op =toupper(op);

    switch (op)
    {
       case 'S': printf("\n-----Seleção-----\n");
                 n = TAM-1;
                 Prencher(A);
                 Imprimir(A);
                 Selecao(A,n);
                 Imprimir(A);
                 system("pause");
                 break;
       case 'I': printf("\n-----Inserção-----\n");
                 n = TAM-1;
                 Prencher(A);
                 Imprimir(A);
                 Insercao(A,&n);
                 Imprimir(A);
                 system("pause");
                 break;
       case 'L': printf("\n-----Shellsort-----\n");
                 n = TAM-1;
                 Prencher(A);
                 Imprimir(A);
                 shellsort2(A,n);
                 Imprimir(A);
                 system("pause");
                 break;
       case 'Q': printf("\n-----Quicksort-----\n");
                 n = TAM-1;
                 Prencher(A);
                 Imprimir(A);
                 QuickSort(A,&n);
                 Imprimir(A);
                 system("pause");
                 break;
       case 'H': printf("\n-----Heapsort-----\n");
                 n = TAM-1;
                 Prencher(A);
                 Imprimir(A);
                 Heapsort(A,&n);
                 Imprimir(A);
                 system("pause");
                 break;
       case 'M': printf("\n-----Heapsort-----\n");
                 n = TAM-1;
                 Prencher(A);
                 Imprimir(A);
                 mergeSort(A,1,n);
                 Imprimir(A);
                 system("pause");
                 break;

       case 'X': exit(1);

    }
    }






    return 0;
}
//*********************************************
//   Funções
//*********************************************
// Ordenação por seleção



void Selecao (Item *A, int n)
{	int i, j, Min;
	Item x;
	for (i = 1; i <= n - 1; i++)
	{ Min = i;
	  for (j = i + 1; j <= n; j++)
       if  (A[j].Chave < A[Min].Chave) Min = j;
      x = A[Min];
      A[ Min] = A[i];
     A[i] = x;
    }
  }
// Ordenação por Inserção

  void Insercao(Item *A, Indice *n)
	{ Indice i, j;
		Item x;
		for (i = 2; i <= *n; i++)
		{  x = A[i]; j = i -1;
		   A[0] = x; /* sentinela */
		   while (x.Chave < A[j].Chave)
		   { A[j+1] = A[j];
             j--;
		   }
		  A[j+1] = x;
		}
	}


// Ordenação Shellsort

      void Shellsort (Item *A, Indice *n)
	{	int i, j;
	    int h = 1;
		Item x;
		do
            h = h * 3 + 1;
		while (h < *n);
		printf("\n h = %d",h);
		do
		{  h = h/ 3;
		   for (i = h + 1; i <= *n; i++)
		  {  x = A[i]; j = i;
		     printf("\n h = %d",h);
		     while (A[j-h].Chave > x.Chave)
		      { A[j] = A[j - h]; j =i - h;
		        if (j <= h) break;
              }
		     A[j] = x;
		   }
		} while (h != 1);
		printf("\n fora do while");
	}

	//shellsort 2

void shellsort2(Item *v, int n) {
    int i, j, h;
    Item aux;
    for(h = 1; h < n; h = 3*h+1); /* calcula o h inicial. */
    while(h > 0) {
        h = (h-1)/3; /* atualiza o valor de h. */
        for(i = h; i < n; i++) {
        aux = v[i];
            j = i;
            /* efetua comparações entre elementos com distância h: */
            while(v[j - h].Chave > aux.Chave) {
                v[j] = v[j - h];
                j -= h;
                if(j < h) break;
            }
            v[j] = aux;
        }
    }
}

//---------------Quicksort---------------------------------

void Particao(Indice Esq, Indice Dir, Indice *i, Indice *j, Item *A)
		{ Item x, w;
		  *i = Esq; *j = Dir;
		   x = A[(*i + *j)/2]; /* obtem o pivo x */
		   do
		    { while (x.Chave > A[*i].Chave) (*i)++;
		      while (x.Chave < A[*j].Chave) (*j)--;
		      if ((*i) <= (*j))
		        { w = A[*i]; A[*i] = A[*j]; A[*j] = w;
                     (*i)++; (*j)--;
		         }
		    } while (*i <= *j);
      }
void Ordena(Indice Esq, Indice Dir, Item *A)
	{ int i,j;
      Particao(Esq, Dir, &i, &j, A);
	  if (Esq < j) Ordena(Esq, j, A);
	  if (i < Dir) Ordena(i, Dir, A);
	}

void QuickSort(Item *A, Indice *n)
	{ Ordena(1, *n, A); }

//------------------HeapSort----------------------------------

void Refaz(Indice Esq, Indice Dir, Item *A)
{   Indice i = Esq;
    int j;
    Item x;
    j = i * 2;
    x = A[i];
    while (j <= Dir)
    {
        if (j < Dir)
        { if (A[j].Chave < A[j+1].Chave) j++;
        }
        if (x.Chave >= A[j].Chave) break;
        A[i] = A[j];
        i = j; j = i *2;
    }
    A[i] = x;
}

void Constroi(Item *A, Indice n)
	{ Indice Esq;
	  Esq = n / 2 + 1;
	  while (Esq > 1)
     {
	    Esq--;
	    Refaz(Esq, n, A);
	  }
	}

void Heapsort(Item *A, Indice *n)
{ Indice Esq, Dir;
  Item x;
  Constroi(A, *n); /* constroi o heap */
  Esq = 1; Dir = *n;
  while (Dir > 1)
 { /* ordena o vetor */
      x = A[1];
      A[1] = A[Dir];
      A[Dir] = x;
      Dir--;
      Refaz(Esq, Dir, A);
  }
}

//------------------Mergesort------------------------------

// Função que mescla duas metades ordenadas
void merge(Item *A, int esquerda, int meio, int direita) {
    int n1 = meio - esquerda + 1;
    int n2 = direita - meio;
    int i = 0, j = 0, k = esquerda;
    // Vetores temporários
    Item L[n1], R[n2];

    // Copia os elementos para os vetores temporários
    for (int i = 0; i < n1; i++)
        L[i] = A[esquerda + i];
    for (int j = 0; j < n2; j++)
        R[j] = A[meio + 1 + j];


    // Junta os dois vetores em ordem
    while (i < n1 && j < n2) {
        if (L[i].Chave <= R[j].Chave) {
            A[k] = L[i];
            i++;
        } else {
            A[k] = R[j];
            j++;
        }
        k++;
    }
     // Copia o que sobrar de L[]
    while (i < n1) {
        A[k] = L[i];
        i++;
        k++;
    }

    // Copia o que sobrar de R[]
    while (j < n2) {
        A[k] = R[j];
        j++;
        k++;
    }
}

void mergeSort(Item *A, int esquerda, int direita) {
    if (esquerda < direita) {
        int meio = esquerda + (direita - esquerda) / 2;

        // Ordena a metade esquerda e direita
        mergeSort(A, esquerda, meio);
        mergeSort(A, meio + 1, direita);

        // Mescla as duas metades ordenadas
        merge(A, esquerda, meio, direita);
    }
}


