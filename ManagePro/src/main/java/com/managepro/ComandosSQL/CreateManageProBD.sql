BEGIN;

CREATE DATABASE managepro_bd;

USE managepro_bd;

CREATE TABLE cliente (
  id_cliente INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nome varchar(70) NOT NULL,
  cpf varchar(14) NOT NULL,
  data_nascimento DATE NOT NULL
);

CREATE TABLE funcionario (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(70) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    cargo ENUM("ADMINISTRADOR", "CONTADOR", "ESTOQUISTA", "GERENTE", "VENDEDOR") NOT NULL,
    salario decimal(10,2) NOT NULL,
    data_admissao DATE NOT NULL,
    usuario varchar(45) NOT NULL,
    senha varchar(20) NOT NULL
);

CREATE TABLE telefone_cliente (
	id_telefone_cliente INT AUTO_INCREMENT PRIMARY KEY NOT NULL, 
    id_cliente INT NOT NULL,
    numero VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE telefone_funcionario (
	id_telefone_funcionario INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_funcionario INT NOT NULL,
    numero VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
);
CREATE TABLE produto (
  id_produto INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nome VARCHAR(45) NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  quantidade INT NOT NULL,
  marca VARCHAR(45) NOT NULL,
  fornecedor VARCHAR(45) NOT NULL,
  validade DATE NOT NULL
);

CREATE TABLE venda (
  id_venda INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id_funcionario INT NOT NULL,
  id_cliente INT NOT NULL,
  forma_pagamento ENUM("CARTAODECREDITO", "CARTAODEDEBITO", "DINHEIRO", "PIX") NOT NULL,
  data_venda DATE NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  valor_recebido DECIMAL(10, 2),
  troco DECIMAL(10,2),
  FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario),
  FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
  );

CREATE TABLE produto_venda (
  id_produto_venda INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id_venda INT NOT NULL,
  id_produto INT NOT NULL,
  quantidade INT NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (id_venda) REFERENCES venda(id_venda),
  FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);

CREATE TABLE estatistica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantidade_produtos INT,
    quantidade_vendas INT,
    quantidade_funcionarios INT,
    total_ganho DECIMAL(10,2)
);

INSERT INTO estatistica (quantidade_produtos, quantidade_vendas, quantidade_funcionarios, total_ganho)
VALUES (0, 0, 0, 0);

INSERT INTO funcionario (nome, cpf, cargo, salario, data_admissao, usuario, senha) 
VALUES("Administrador MANAGEPRO", "123.456.789-12", "ADMINISTRADOR", 10000.00, '2024-08-12', "admin", "123");

INSERT INTO funcionario (nome, cpf, cargo, salario, data_admissao, usuario, senha) 
VALUES("Vendedor Teste", "123.456.789-12", "VENDEDOR", 1352.30, '2024-08-12', "vendedor", "123");

INSERT INTO telefone_funcionario (id_funcionario, numero) 
VALUES(1, "(81)99256-7489");

INSERT INTO telefone_funcionario (id_funcionario, numero) 
VALUES(2, "(81)91654-3215");

INSERT INTO cliente (nome, cpf, data_nascimento) 
VALUES("Josepe Feitosa", "123.456.789-12", '2024-08-12');

INSERT INTO telefone_cliente (id_cliente, numero) 
VALUES(1, "(81)99929-4959");

INSERT INTO produto (nome, preco, quantidade, marca, fornecedor, validade) 
VALUES("Biscoito Treloso", "2.29", 20, "Vitarela", 'Vitarela', '2024-09-22');

INSERT INTO produto (nome, preco, quantidade, marca, fornecedor, validade) 
VALUES("Arroz", "7.32", 20, "Emoï¿½ï¿½es", 'Cadan Distribuiï¿½ï¿½o', '2027-12-18');

INSERT INTO produto (nome, preco, quantidade, marca, fornecedor, validade) 
VALUES("Feijï¿½o", "5.29", 20, "Turquesa", 'Cadan Distribuiï¿½ï¿½o', '2026-07-26');

INSERT INTO produto (nome, preco, quantidade, marca, fornecedor, validade) 
VALUES("Azeite de Oliva", "46.90", 20, "Gallo", 'Cadan Distribuição', '2026-03-17');

# Trigger para não permitir Troco e Valor Recebido ser nullo quando a forma de pagamento for dinheiro.
DELIMITER //

CREATE TRIGGER validar_venda
BEFORE INSERT ON venda
FOR EACH ROW
BEGIN
    IF NEW.forma_pagamento = 'DINHEIRO' THEN
        IF NEW.valor_recebido IS NULL OR NEW.troco IS NULL THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erro: Valor recebido e troco devem ser preenchidos quando o método de pagamento for DINHEIRO.';
        END IF;
    ELSE
        IF NEW.valor_recebido IS NOT NULL OR NEW.troco IS NOT NULL THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erro: Valor recebido e troco devem ser nulos quando o método de pagamento não for DINHEIRO.';
        END IF;
    END IF;
END//

DELIMITER ;

# Procedure de atualização da tabela de Estatistica

DELIMITER $$

CREATE PROCEDURE atualizar_estatistica_completa()
BEGIN
    UPDATE estatistica
    SET 
        quantidade_produtos = (SELECT COALESCE(COUNT(*), 0) FROM produto),
        quantidade_vendas = (SELECT COALESCE(COUNT(*), 0) FROM venda),
        quantidade_funcionarios = (SELECT COALESCE(COUNT(*), 0) FROM funcionario),
        total_ganho = (SELECT COALESCE(SUM(preco), 0) FROM produto)
    WHERE id = 1;
END$$

DELIMITER ;

# Triggers da tabela funcionario para atualizar estatisticas 

DELIMITER $$

CREATE TRIGGER funcionario_insert_trigger
AFTER INSERT ON funcionario
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER funcionario_update_trigger
AFTER UPDATE ON funcionario
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER funcionario_delete_trigger
AFTER DELETE ON funcionario
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;

# Triggers da tabela produto para atualizar estatisticas

DELIMITER $$

CREATE TRIGGER produto_insert_trigger
AFTER INSERT ON produto
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER produto_update_trigger
AFTER UPDATE ON produto
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER produto_delete_trigger
AFTER DELETE ON produto
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;

# Triggers da tabela funcionario para atualizar estatisticas

DELIMITER $$

CREATE TRIGGER venda_insert_trigger
AFTER INSERT ON venda
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER venda_update_trigger
AFTER UPDATE ON venda
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER venda_delete_trigger
AFTER DELETE ON venda
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;

# Triggers de atualização

DELIMITER $$

CREATE TRIGGER atualiza_total_ganho_after_produto_insert
AFTER INSERT ON produto
FOR EACH ROW
BEGIN
    UPDATE estatistica
    SET total_ganho = (
        SELECT COALESCE(SUM(preco), 0)
        FROM produto
    )
    WHERE id = 1;  
END $$

DELIMITER $$

CREATE TRIGGER atualiza_total_ganho_after_produto_update
AFTER UPDATE ON produto
FOR EACH ROW
BEGIN
    UPDATE estatistica
    SET total_ganho = (
        SELECT COALESCE(SUM(preco), 0)
        FROM produto
    );
END $$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER atualiza_total_ganho_update
AFTER UPDATE ON venda
FOR EACH ROW
BEGIN
    UPDATE estatistica
    SET total_ganho = (
        SELECT SUM(valor_venda)
        FROM venda
    );
END $$

CREATE TRIGGER atualiza_total_ganho_delete
AFTER DELETE ON venda
FOR EACH ROW
BEGIN
    UPDATE estatistica
    SET total_ganho = (
        SELECT SUM(valor_venda)
        FROM venda
    );
END $$

DELIMITER ;
DELIMITER ;