select nome
from modelos where idmarca = 3;

select renavam, datahora, idtipoinfracao
from infracoes where datahora >=  '2009-04-01 00:00:00';  

select renavam, datahora
from infracoes WHERE datahora BETWEEN '2009-03-01 00:00:00' AND '2009-03-31 00:00:00'AND idtipoinfracao = 5;

select placa, idmodelo,idcor
from veiculos
where placa like 'JRO%';

select placa, idmodelo,idcor
from veiculos
where placa like '__Z___9' ;
