Um curso de uma faculdade é representado por um código, nome, duração (em 
semestres), valor total do curso e ano de criação do curso. 
------------------------------------------------------------------------
  Criação de um curso com todos os dados necessários;
 ------------------------------------------------------------------------
  Criação de um curso sem informar a duração. Neste caso o default são 8 semestres;
 ------------------------------------------------------------------------
  Metódo para calcular o valor da mensalidade de um aluno, considerando que o valor é fíxo, ou seja, o valor total do curso pode ser pago em parcelas mensais:
 Se o curso custa R$9.600,00 e será pago em 8 semestres, e cada semestre tem 6 meses, então o número total de parcelas é:
               8×6=48 meses
                9600/48 = R$200,00
    ------------------------------------------------------------------------            
    Continuando o exercício anterior, crie uma classe que represente uma Faculdade. Uma 
Faculdade tem um nome, ano de criação e um ou mais cursos (represente estes cursos 
utilizando a classe Curso da questão anterior). Necessário utilizar array nesta questão. 
Crie métodos nesta classe para: 
• Criar uma faculdade informando o nome e ano de criação;
• Adicionar um Curso (passado como parâmetro) à faculdade. Entretanto, não é possível 
adicionar um curso já existindo um outro curso com o mesmo nome na Faculdade.
• Remover um Curso dado um nome, passado como parâmetro. Se não houver nenhum 
curso com o nome fornecido, uma mensagem deve ser impressa na tela informando o 
fato;
• Retornar uma nova Faculdade (uma nova instância da classe Faculdade) que contenha 
como cursos, os cursos que foram criados no máximo 5 anos depois da Faculdade. Este 
método deve receber como parâmetro o nome e o ano de criação da nova faculdade            

                
