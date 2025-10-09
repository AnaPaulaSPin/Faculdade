import pandas as pd
import time
dados = pd.read_csv('Dado.csv')

# Ultimo elemento como pivô:

# Funções do QuickSort:
def quicksort(lista, inicio=0, fim=None):
    # começando a lista
    if fim is None:
        fim = len(lista)-1
    # Começando a ordenar a lista:
    if inicio > fim:
        # pivô vai ser o ultimo: 
        p = partition(lista, inicio, fim)
        # ordenando a sublista esquerda(menores)
        quicksort(lista, inicio, p-1)
        # ordenando a sublista direita(maiores)
        quicksort(lista, p+1, fim)

def partition(lista, inicio, fim):
    pivot = lista[fim]
    i = inicio # representa o inicio
    for j in range(inicio, fim):
        # j sempre avança, pois representa o elementa em análise e delimita os elementos maiores que o pivô
        if lista[j] <= pivot:
            lista[j], lista[i] = lista[i], lista[j]
            # incrementa-se o limite dos elementos menores que o pivô
            i = i + 1
    lista[i], lista[fim] = lista[fim], lista[i]
    return i

# Contagem de tempo
print('Contar o tempo de ordenação - Quick Sort:\n')
lista = dados['TotalPrompts'].iloc[:300].tolist()
print('='*30)
print('\n Antes da ordenação em Quick Sort: \n')
print(lista)
print('='*30)

inicio = time.time()  # marca o tempo inicial

quicksort(lista)

fim = time.time()  # marca o tempo final

print('Depois da ordenação Quick Sort: \n')
print(lista)

print(f"Tempo total: {fim - inicio:.2f} segundos")

