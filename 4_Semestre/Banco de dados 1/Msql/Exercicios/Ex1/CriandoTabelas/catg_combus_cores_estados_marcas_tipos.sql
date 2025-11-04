use sistema;
create table categorias(
  idcategoria INT primary key auto_increment,
  nome varchar(100) not null
);


create table combustivel(
  idcombustivel INT primary key auto_increment,
  nome varchar(100) not null
);

create table cores(
  idcor INT primary key auto_increment,
  nome varchar(100) not null
);

create table estados(
  idestado INT primary key auto_increment,
  nome varchar(100) not null,
   sigla varchar(100) not null
);


create table marcas(
  idmarca INT primary key auto_increment,
  nome varchar(100) not null
);


create table tipoinfracoes(
  idtipoinfracao INT primary key auto_increment,
  nome varchar(100) not null,
  valor float not null
);




