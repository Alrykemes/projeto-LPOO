BEGIN;

CREATE DATABASE managepro_bd;

USE managepro_bd;

CREATE TABLE cliente (
  id_cliente INT PRIMARY KEY NOT NULL,
  nome varchar(70) NOT NULL,
  cpf varchar(14) NOT NULL,
  data_nascimento date NOT NULL,
  PRIMARY KEY (id_cliente)
);

CREATE TABLE funcionario (
    id_funcionario INT PRIMARY KEY NOT NULL,
    nome VARCHAR(70) NOT NULL,
    data_admissao DATE NOT NULL,
    usuario varchar(45) NOT NULL,
    senha varchar(120) NOT NULL
);

CREATE TABLE telefone_cliente (
	id_telefone_cliente INT PRIMARY KEY NOT NULL, 
    id_cliente INT NOT NULL,
    numero VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE telefone_funcionario (
	id_telefone_funcionario INT PRIMARY KEY NOT NULL,
    id_funcionario INT NOT NULL,
    numero VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
);

CREATE TABLE produto (
  id_produto INT PRIMARY KEY NOT NULL,
  nome VARCHAR(45) NOT NULL,
  preco DECIMAL NOT NULL,
  quantidade INT NOT NULL,
  marca VARCHAR(45) NOT NULL,
  fornecedor VARCHAR(45) NOT NULL,
  validade DATE NOT NULL
);

CREATE TABLE venda (
  id_venda INT PRIMARY KEY NOT NULL,
  id_funcionario INT NOT NULL,
  id_cliente INT NOT NULL,
  forma_pagamento ENUM("CARTAODEALIMENTACAO", "CARTAODECREDITO", "CARTAODEDEBITO", "DINHEIRO", "PIX") NOT NULL,
  data_venda date NOT NULL,
  preco decimal(10,2) NOT NULL,
  PRIMARY KEY (id_venda),
  FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario),
  FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
  );

CREATE TABLE produto_venda (
  id_produto_venda int NOT NULL,
  id_venda int NOT NULL,
  id_produto int NOT NULL,
  quantidade int NOT NULL,
  preco decimal(10,2) NOT NULL,
  PRIMARY KEY (id_produto_venda),
  FOREIGN KEY (id_venda) REFERENCES venda(id_venda),
  FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);

INSERT INTO funcionario VALUES(1, "admininastor", "123.456.789-12", "ADMINISTRADOR", 2.50, '2024-08-12', "admin", "123");