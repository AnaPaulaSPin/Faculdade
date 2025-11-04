use sistema;
create table telefones(
  idtelefone INT primary key auto_increment,
  nome varchar(100) not null,
  numero INT,
  cpf INT,
  foreign key (cpf) references proprietarios (cpf)
);



