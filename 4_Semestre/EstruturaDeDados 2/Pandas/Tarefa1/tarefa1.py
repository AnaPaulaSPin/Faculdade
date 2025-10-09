import pandas as pd
dados = pd.read_csv('Dado.csv')

print(dados.head())
print('=='*90)

print(dados.tail())
print('=='*90)

print(dados['Discipline'])
print('=='*90)

print('=='*90)
print()

print('=='*90)
print(dados.iloc[0])

print('=='*90)
print(dados.loc[(dados['TotalPrompts']>8.0)])



print('=='*90)
print(dados.sort_values(by="SessionLengthMin", ascending= False))

print('=='*90)

i = 0 
num = 10
while i < num:
  print(dados.iloc[i])
  i = i+1

print('=='*90)

# Calcular a media de satisfação de uma amostra de 10 alunos:
while(True):
 r = int(input('Digite quantos alunos vc quer fazer a media de satisfação: '))
 if r < len(dados):
    break

 else:
  print('limite da coluna foi atingido! Digite um numero abaixo de {}!'.format(len(dados)))

media = 0
i = 0
while(i < r):
  num = int(dados.loc[i,'SatisfactionRating'])
  media = media + num
  i = i + 1

print('A media de {} alunos é: {}'.format(r,media/r))
print('=='*90)

#tempo
print('Contar o tempo de ordenação, crescente:\n')
import time

inicio = time.time()  # marca o tempo inicial
print('=='*90)
print(dados.sort_values(by="SessionLengthMin"))

fim = time.time()  # marca o tempo final

print(f"Tempo total: {fim - inicio:.2f} segundos")
