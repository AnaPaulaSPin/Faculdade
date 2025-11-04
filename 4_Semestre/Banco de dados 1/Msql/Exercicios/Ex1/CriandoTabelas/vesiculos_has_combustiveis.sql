use sistema;
create table veiculos_has_combustiveis(
  renavam INT, 
  idcombustivel int,
  foreign key (renavam) references veiculos (renavam),
  foreign key (idcombustivel) references combustivel (idcombustivel)
);