create table infracoes(
  idinfracao INT primary key auto_increment,
  renavam INT not null,
   data date,
   hora time,
   local varchar(100),
   idtipoinfracao INT, 
   velocidade FLOAT, 
   idagente INT, 
   obs varchar(100),
   foreign key (idtipoinfracao) references tipoinfracoes (idtipoinfracao),
   foreign key (idagente) references agente (id_agente)
);

create table modelos(
  idmodelo INT primary key auto_increment,
  nome varchar(100) not null,
  idmarca INT,
  foreign key (idmarca) references marcas (idmarca)
);






