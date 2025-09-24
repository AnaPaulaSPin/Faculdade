import os

lista = [0] * 11
dinamico = False

while(1):
    chave = int(input('Digite a chave que deseja inserir: '))

    enderecoBase = chave % 11

    if(lista[enderecoBase] == 0):
        lista[enderecoBase] = chave

    elif(lista[enderecoBase] == chave):
        print("Chave que vc digitou é duplicada!")

    #Temos que fazer o deslocamento e tentar mudar o atual do lugar:
    else: 
      atual = enderecoBase
      #Tentar mudar o atual endereço do lugar:
      while(1):
        #tentar achar o proximo disponivel para mudar o endereco atual:
        if lista[atual] == 0:
            dinamico = True
            lista[atual] = lista[enderecoBase]
            lista[enderecoBase] = chave
    
  
    while(1):
     deslocamento = chave // 11
     if deslocamento == 0:
        deslocamento = 1

     endereco = (enderecoBase + deslocamento) % 11

    if lista[endereco] == 0:
        lista[endereco] = chave
        break

    if endereco == enderecoBase:
     print('Tabela cheia!')
     break

    
    print(lista)

    os.system("pause")

    if chave == -1:
        print('Saindo do programa...')
        break
    




