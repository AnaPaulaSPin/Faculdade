import pandas as pd
import time
dados = pd.read_csv('Dado.csv')

# Primeiro elemento como pivô:

# Funções do QuickSort:


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

