import pandas as pd
import time
dados = pd.read_csv('Dado.csv')

# Primeiro elemento como pivô:

# Funções do QuickSort:
def quicksort(lista, inicio=0, fim=None):
    # começando a lista
    if fim is None:
        fim = len(lista)-1
    # Começando a ordenar a lista:
    if inicio < fim:
        # pivô o primeiro: 
        p = partition(lista, inicio, fim)
        # ordenando a sublista esquerda(menores)
        quicksort(lista, inicio, p-1)
        # ordenando a sublista direita(maiores)
        quicksort(lista, p+1, fim)

def partition(lista, inicio, fim):
    pivot = lista[inicio] 
    i = inicio + 1         
    j = fim

    while True:
        while i <= j and lista[i] <= pivot:
            i += 1
        while i <= j and lista[j] >= pivot:
            j -= 1
        if i <= j:
            lista[i], lista[j] = lista[j], lista[i]
        else:
            break

    # coloca pivô na posição final (posição j)
    lista[inicio], lista[j] = lista[j], lista[inicio]
    return j

# Contagem de tempo
print('Contar o tempo de ordenação - Quick Sort:\n')
lista = dados['TotalPrompts'].iloc[:1000].tolist()
print('='*80)
print('\n Antes da ordenação em Quick Sort: \n')
print(lista)
print('='*80)

inicio = time.time()  # marca o tempo inicial

quicksort(lista)

fim = time.time()  # marca o tempo final

print('Depois da ordenação Quick Sort: \n')
print(lista)

print(f"Tempo total: {fim - inicio:.2f} segundos")

