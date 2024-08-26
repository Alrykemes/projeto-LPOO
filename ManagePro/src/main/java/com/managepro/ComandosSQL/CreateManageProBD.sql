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
  forma_pagamento ENUM("CARTAODEALIMENTACAO", "CARTAODECREDITO", "CARTAODEDEBITO", "DINHEIRO", "PIX") NOT NULL,
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

