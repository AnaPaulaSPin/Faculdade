
use sistema;
create table veiculos(
  renavam INT primary key auto_increment,
  chassi VARCHAR(10),
  placa VARCHAR(8),
  nome varchar(100) not null,
   ano_fab date,
   ano_modelo date,
   idcor INT, 
   idmodelo INT, 
   idcategoria INT, 
   cpf INT,
   foreign key (idcor) references cores (idcor),
   foreign key (idmodelo) references modelos (idmodelo),
   foreign key (idcategoria) references categorias (idcategoria),
   foreign key (cpf) references proprietarios (cpf)
);