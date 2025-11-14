use veiculos;
-- 1) Liste o renavam, a placa do veículo, data e nome do tipo de infracao das infrações que ocorreram a partir do dia 01/04/2009.
select veiculos.renavam, veiculos.placa, tiposinfracoes.descricao
from veiculos join infracoes on veiculos.renavam = infracoes.renavam
join tipoinfracoes on infracoes.idinfracao = tiposinfracoes.idtipoinfracao;

-- 2) Liste o renavam, a placa do veículo e data das infrações que ocorreram a partir do dia 01/04/2009 e tipo de infração igual a 5.

-- 3) Liste o renavam, o nome do proprietário e data das infrações que ocorreram entre os dias 01/03/2009 e 31/03/2009 e tipo de infração igual a 5
-- 4) Exiba placa, nome do modelo e a nome da cor dos veículos que a placa começa com JRO.
-- 5) Exiba placa, nome do modelo e a nome da cor dos veículos que a placa tem o terceiro dígito Z e termina com 9.
 -- 6) Selecione nome da marca e nome do modelo, dos modelos que o código da marca seja igual a 01, 05, 12, 25, 33 ou 42, ordenado por idmarca e nome do modelo.
-- 7) Mostre a quantidade de veículos por tipo de combustível para a categoria igual a “automóvel”.
-- 8) Mostre a quantidade de veículos por tipo de combustível (exiba o nome do tipo de combustível) para combustíveis cuja quantidade seja maior do que 10.
-- 9) Mostre a quantidade de infrações de cada tipo de infração (exiba o nome do tipo de infração) ocorrida em 2009 somente para tipos de infrações que a quantidade seja maior do que 5.