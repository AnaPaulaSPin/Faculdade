use veiculos;
-- 1) Liste o renavam, a placa do veículo, data e nome do tipo de infracao das infrações que ocorreram a partir do dia 01/04/2009.
select veiculos.renavam, 
	   veiculos.placa, 
       tiposinfracoes.descricao
from veiculos 
join infracoes 
  on veiculos.renavam = infracoes.renavam
join tiposinfracoes 
  on infracoes.idtipoinfracao = tiposinfracoes.idtipoinfracao
where datahora > '2009-04-01';

-- 2) Liste o renavam, a placa do veículo e data das infrações que ocorreram a partir do dia 01/04/2009 e tipo de infração igual a 5.
select veiculos.renavam, 
	   veiculos.placa, 
       infracoes.datahora
from veiculos 
join infracoes 
  on veiculos.renavam = infracoes.renavam
join tiposinfracoes 
  on infracoes.idtipoinfracao = tiposinfracoes.idtipoinfracao
where datahora > '2009-04-01' AND infracoes.idtipoinfracao = 5 ;


-- 3) Liste o renavam, o nome do proprietário e data das infrações que ocorreram entre os dias 01/03/2009 e 31/03/2009 e tipo de infração igual a 5
select veiculos.renavam, 
	   proprietarios.nome, 
       infracoes.datahora
from veiculos 
join proprietarios
  on veiculos.cpf = proprietarios.cpf
join infracoes 
  on veiculos.renavam = infracoes.renavam
join tiposinfracoes 
  on infracoes.idtipoinfracao = tiposinfracoes.idtipoinfracao
where datahora between '2009-03-01' AND '2009-03-31' AND infracoes.idtipoinfracao = 5 ;

-- 4) Exiba placa, nome do modelo e a nome da cor dos veículos que a placa começa com JRO.
select veiculos.placa, modelos.nome, cores.nome
from veiculos
join modelos
  on veiculos.idmodelo = modelos.idmodelo
join cores on veiculos.idcor = cores.idcor
where veiculos.placa like 'JRO%';

-- 5) Exiba placa, nome do modelo e a nome da cor dos veículos que a placa tem o terceiro dígito Z e termina com 9.
select veiculos.placa, modelos.nome, cores.nome
from veiculos
join modelos
  on veiculos.idmodelo = modelos.idmodelo
join cores on veiculos.idcor = cores.idcor
where veiculos.placa like '__Z%9';

 -- 6) Selecione nome da marca e nome do modelo, dos modelos que o código da marca seja igual a 01, 05, 12, 25, 33 ou 42, ordenado por idmarca e nome do modelo.
 select veiculos.placa, modelos.nome
 from veiculos
join modelos
  on veiculos.idmodelo = modelos.idmodelo
where veiculos.idmodelo in(1, 5, 12, 25, 33, 42)
order by veiculos.idmodelo ASC;
 
-- 7) Mostre a quantidade de veículos por tipo de combustível para a categoria igual a “automóvel”.
select combustiveis.nome, COUNT(*)
from veiculos_has_combustiveis
join combustiveis
  on veiculos_has_combustiveis.idcombustivel = combustiveis.idcombustivel
JOIN veiculos
  ON veiculos_has_combustiveis.renavam = veiculos.renavam
where veiculos.idcategoria like 'automóvel'
group by combustiveis.idcombustivel;


-- 8) Mostre a quantidade de veículos por tipo de combustível (exiba o nome do tipo de combustível) para combustíveis cuja quantidade seja maior do que 10.
select combustiveis.nome, COUNT(*)
from veiculos_has_combustiveis
join combustiveis
  on veiculos_has_combustiveis.idcombustivel = combustiveis.idcombustivel
JOIN veiculos
  ON veiculos_has_combustiveis.renavam = veiculos.renavam
group by combustiveis.idcombustivel
having count(*) > 10;

-- 9) Mostre a quantidade de infrações de cada tipo de infração (exiba o nome do tipo de infração) ocorrida em 2009 somente para tipos de infrações que a quantidade seja maior do que 5.
select tiposinfracoes.descricao, count(*)
from veiculos 
join infracoes 
  on veiculos.renavam = infracoes.renavam
join tiposinfracoes 
  on infracoes.idtipoinfracao = tiposinfracoes.idtipoinfracao
where datahora like '2009%'
group by infracoes.idtipoinfracao
having COUNT(*) > 5;


