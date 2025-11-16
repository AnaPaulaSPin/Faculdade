use veiculos;
-- 14- Selecione idmarca e nome do modelo, dos modelos que têm marcas que sejam igual a 01, 05, 12, 25, 33 ou 42, ordenado por idmarca e nome do modelo.
Select idmarca, nome
from modelos where idmarca in(1,5,12,25,33,42);

--  Mostre quantas multas são emitidas por dia no ano de 2009.
Select datahora, COUNT(*) from infracoes where datahora like '2009%' group by MONTH(datahora);

-- 16) Mostre qual a velocidade média e qual a máxima das infrações.
Select velocidade, AVG(velocidade) as media 
from infracoes
group by velocidade;

select velocidade, MAX(velocidade) as maxima
from infracoes
group by velocidade;

-- 17) Liste a quantidade de veículos de cada modelo.
select idmodelo, COUNT(*)
from veiculos
group by idmodelo;

-- 18) Mostre a quantidade de veículos por cor para a categoria 2.
select idcor, COUNT(*)
from veiculos where idcategoria = 2
group by idcor;

-- 19) Mostre a quantidade de veículos por combustível para combustíveis cuja quantidade seja maior do que 10.
select idcombustivel, count(*) as total
from veiculos_has_combustiveis 
group by idcombustivel
HAVING COUNT(*) > 10;


-- 20) Mostre a quantidade de infrações de cada tipo de infração ocorrida em 2009 somente para tipos de infrações que a quantidade seja maior do que 5.
select idtipoinfracao, count(*) AS total
from infracoes
where datahora like '2009%'
group by idtipoinfracao
having count(*) > 5


