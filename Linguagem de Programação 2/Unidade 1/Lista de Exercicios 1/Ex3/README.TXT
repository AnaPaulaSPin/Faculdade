LP2
Lista de exercícios

Em um sistema para o Detran, a carteira de motorista é representada por:
- um número, CPF do proprietário, tipo (A, B ou AB), data de validade, data de expedição, 
pontos e situação (Valida = 1, apreendida = 2 , vencida = 3). 
* Quando uma pessoa passa no exame do Detran, uma nova carteira é emitida com 
os dados do seu proprietário. 

Neste momento o proprietário não possui nenhum ponto na carteira. 
A medida que o tempo passa, se o proprietário fizer alguma infração, 
ele recebe pontos(5 pontos) que são acumulados em sua carteira. Caso ele
ultrapasse 20 pontos sua carteira é apreendida. Esporadicamente, os pontos são zerados.

> Implemente em Java uma classe que represente uma carteira. 
> Forneça métodos para criar uma carteira, acrescentar pontos, 
consultar o saldo de pontos, zerar a carteira, apreender a carteira, verificar se esta está válida.

para comparar strings ou variaveis
if(this.situacao.equals("vencida")){
           System.out.println("Carteira Apreendida - Validade vencida:" + this.pontos);
           this.situacao = "apreendida";