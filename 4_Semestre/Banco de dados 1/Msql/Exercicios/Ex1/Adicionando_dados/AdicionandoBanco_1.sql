use sistema;
insert into agente(nome,datacontratacao)
   values
   ('Ana', "2030-11-15"),
   ("Julia", "2030-11-15");
   
insert into categorias(nome)
 values
  ("moto"),
  ("carro");
  
insert into cores(nome)
 values
  ("azul"),
  ("preto");
  
insert into estados(nome, sigla)
 values
  ("Bahia", "BA"),
  ("Sao Paulo", "SP");

insert into combustivel(nome)
 values
  ("gasolina"),
  ("gas"),
  ("alcool");
  
insert into cidade(nome, idestado)
values 
("Salvador", 1),
("Sao Paulo", 2);

INSERT INTO marcas 
VALUES 
('Fiat'),
('Honda'),
('Toyota');





