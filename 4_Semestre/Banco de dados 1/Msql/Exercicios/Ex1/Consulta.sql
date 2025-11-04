select nome
from modelo
where idmarca = 3

select renavam, data, idtipoinfracao
from infracoes;

select renavam, data
from cidade,
WHERE data BETWEEN '2009-03-01' AND '2009-03-31'AND idtipoinfracao = 5;

select idmarca
from  marcas;

select placa, idmodelo,idcor
from veiculos
where placa like 'JRO%';

select placa, idmodelo,idcor
from veiculos
where placa like '__Z____9';
