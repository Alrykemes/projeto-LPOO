BEGIN;

CREATE TABLE cliente (
  id_cliente int NOT NULL,
  nome varchar(70) NOT NULL,
  cpf varchar(11) NOT NULL,
  data_nascimento date NOT NULL,
  PRIMARY KEY (id_cliente)
);

CREATE TABLE funcionario (
    id_funcionario INT NOT NULL,
    nome VARCHAR(70) NOT NULL,
    cpf VARCHAR(45) NOT NULL,
    cargo ENUM("ADMINISTRADOR", "CONTADOR", "ESTOQUISTA", "GERENTE", "VENDEDOR") NOT NULL,,
    salario decimal NOT NULL,
    data_admissao DATE NOT NULL,
    usuario varchar(45) NOT NULL,
    senha varchar(120) NOT NULL,
    PRIMARY KEY (id_funcionario)
);

CREATE TABLE telefone_cliente (
    id_cliente INT NOT NULL,
    numero VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_cliente)
        REFERENCES cliente(id_cliente)
);

CREATE TABLE telefone_funcionario (
    id_cliente INT NOT NULL,
    numero VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_funcionario)
        REFERENCES funcionario(id_funcionario)
);

CREATE TABLE produto (
  id_produto int NOT NULL,
  nome varchar(45) NOT NULL,
  preco decimal NOT NULL,
  quantidade int NOT NULL,
  marca varchar(45) NOT NULL,
  fornecedor varchar(45) NOT NULL,
  validade date NOT NULL,
  PRIMARY KEY (id_produto)
);

CREATE TABLE venda (
  id_venda int NOT NULL,
  id_funcionario int NOT NULL,
  id_cliente int NOT NULL,
  forma_pagamento ENUM("CARTAODEALIMENTACAO", "CARTAODECREDITO", "CARTAODEDEBITO", "DINHEIRO", "PIX") NOT NULL,
  data_venda date NOT NULL,
  preco decimal NOT NULL,
  PRIMARY KEY (id_venda),
  FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario),
  FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
  );

CREATE TABLE produto_venda (
  id_produto_venda int NOT NULL,
  id_venda int NOT NULL,
  id_produto int NOT NULL,
  quantidade int NOT NULL,
  preco decimal NOT NULL,
  PRIMARY KEY (id_produto_venda),
  FOREIGN KEY (id_venda) REFERENCES venda(id_venda),
  FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);

INSERT INTO funcionario VALUES(1, "admininastor", "123.456.789-12", "ADMINISTRADOR", 2.50, '2024-08-12', "admin", "123");