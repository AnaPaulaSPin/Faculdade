USE loja;

-- ===============================
-- TABELA CLIENTE (com senha)
-- ===============================
CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(120) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL  -- senha do cliente
);

-- ===============================
-- TABELA PRODUTO / ÁLBUM (com descrição)
-- ===============================
CREATE TABLE produto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(120) NOT NULL,
    artista VARCHAR(120),
    descricao TEXT,               -- descrição do álbum
    preco DECIMAL(10,2) NOT NULL,
    estoque INT NOT NULL
);

-- ===============================
-- TABELA CARRINHO
-- ===============================
CREATE TABLE carrinho (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,

    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);
