use sistema;

create table proprietarios(
  cpf INT primary key auto_increment,
  nome varchar(100) not null,
   data_nasc date,
   endereco varchar(100), 
   idcidade INT, 
   cep INT, 
   sexo VARCHAR(10),
   foreign key (idcidade) references cidade(idcidade)
);

