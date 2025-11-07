use veiculos;
select idmodelo, count(*)
from veiculos
group by placa;

