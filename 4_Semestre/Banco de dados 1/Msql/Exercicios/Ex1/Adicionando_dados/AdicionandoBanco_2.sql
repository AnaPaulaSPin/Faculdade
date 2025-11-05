INSERT INTO modelos(nome,idmarca)
 VALUES 
('Civic', 3),
('Corolla', 3),
('City', 2),
('Uno', 3);

INSERT INTO proprietarios(nome,data_nasc,endereco,idcidade,cep,sexo)
 VALUES 
('Ana Paula', '2001-05-10', 'Rua das Flores, 45', 1, '40000000', 'F'),
('João Silva', '1999-10-20', 'Av. Central, 100', 2, '44000000', 'M');

INSERT INTO telefones(numero, cpf) VALUES 
('99999-1234', 1),
('88888-4321', 2);

INSERT INTO tipoinfracoes(nome,valor) VALUES 
('Velocidade acima do permitido', 150.00),
('Estacionar em local proibido', 120.00);

INSERT INTO veiculos( chassi,placa,nome,ano_fab,ano_modelo,idcor,idmodelo,idcategoria,cpf) VALUES 
('CHASSI001', 'JRO1A29','a' '1999-10-20', '2001-05-10', 1, 2, 1, 2),
('CHASSI002', 'ABZC9rt9','a', "1999-10-20", '2001-05-10', 2, 4, 1, 1 );