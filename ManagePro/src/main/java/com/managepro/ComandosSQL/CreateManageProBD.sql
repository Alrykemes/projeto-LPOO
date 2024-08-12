BEGIN;

CREATE TABLE cliente (
  id_cliente int NOT NULL,
  nome varchar(45) NOT NULL,
  cpf varchar(11) NOT NULL,
  data_nascimento date NOT NULL,
  PRIMARY KEY (id_cliente)
);

CREATE TABLE funcionario (
    id_funcionario INT NOT NULL,
    nome VARCHAR(45) NOT NULL,
    cpf VARCHAR(45) NOT NULL,
    cargo VARCHAR(45) NOT NULL,
    salario INT NOT NULL,
    data_admissao DATE NOT NULL,
    PRIMARY KEY (id_funcionario)
);

CREATE TABLE telefone (
    id_portador INT NOT NULL,
    numero VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_portador)
        REFERENCES cliente (id_cliente),
    FOREIGN KEY (id_portador)
        REFERENCES funcionario (id_funcionario)
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
  forma_pagamento varchar(45) NOT NULL,
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