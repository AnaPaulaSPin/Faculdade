import os

lista = [0] * 11

while(1):
    chave = int(input('Digite a chave que deseja inserir: '))

    H = chave % 11
    if(lista[H] == 0):
        lista[H] = chave
    elif(lista[H] == chave):
        print("Chave que vc digitou é duplicada!")
    else: 
      while(1):
        if(lista[(H + H)% 11] != 0):
            lista[H] = chave
            break

        elementosPren = 0
        for i in range(len(lista)):
            if lista[i] != 0:
               elementosPren += 1
        
        if(elementosPren == len(lista)):
            break

    
    print(lista)

    os.system("pause")
    os.system("cls")




