use sistema;

create table cidade(
  idcidade INT primary key auto_increment,
  nome varchar(100) not null,
  idestado INT,
   foreign key (idestado) references estados (idestado)
);

