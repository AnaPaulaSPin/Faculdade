-- Adicionando clientes
INSERT INTO cliente (nome, email, senha)
VALUES
('Ana Souza', 'ana@email.com', '123456'),
('Gabriel Santos', 'gabriel@email.com', 'senha123'),
('Maria Oliveira', 'maria@email.com', 'abc123');

-- Adicionando Albuns
INSERT INTO produto (nome, artista, descricao, preco, estoque)
VALUES
('Proof', 'BTS', 'Álbum antológico com três CDs incluindo faixas inéditas e versões remasterizadas.', 199.90, 15),

('Born Pink', 'BLACKPINK', 'Segundo álbum de estúdio do grupo com hits globais e produção refinada.', 179.90, 20),

('Golden', 'Jungkook', 'Primeiro álbum solo de Jungkook do BTS, com pop vibrante e participação de grandes produtores.', 159.90, 12),

('7', 'Jimin', 'Álbum solo do Jimin com forte identidade artística, misturando pop e R&B.', 149.90, 10);

-- Carrinhos
INSERT INTO carrinho (cliente_id, produto_id, quantidade)
VALUES
(1, 1, 1),  -- Ana adicionou o álbum Proof
(1, 3, 2),  -- Ana adicionou 2 álbuns Golden  
(2, 2, 1),  -- Gabriel adicionou Born Pink
(3, 4, 1);  -- Maria adicionou o álbum 7
