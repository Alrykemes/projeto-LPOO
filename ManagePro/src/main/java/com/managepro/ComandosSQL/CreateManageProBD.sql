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
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  quantidade_produtos_vendidos bigint DEFAULT '0',
  quantidade_vendas bigint DEFAULT '0',
  total_ganho decimal(20,2) DEFAULT '0.00',
  data date DEFAULT NULL
);

INSERT INTO estatistica (quantidade_produtos_vendidos, quantidade_vendas, total_ganho, data)
VALUES (0, 0, 0, null);

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

# Atualizacao do estoque a cada venda que e feita por trigger no bd

DELIMITER $$

CREATE TRIGGER atualiza_estoque AFTER INSERT ON produto_venda FOR EACH ROW
BEGIN
    DECLARE qtd_disponivel INT;
    DECLARE nome_produto VARCHAR(255);
    DECLARE msg_erro VARCHAR(255);

    SELECT quantidade, nome_produto INTO qtd_disponivel, nome_produto
    FROM produto
    WHERE id_produto = NEW.id_produto;

    IF qtd_disponivel IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Produto não encontrado.';
    ELSEIF qtd_disponivel < NEW.quantidade THEN
        SET msg_erro = CONCAT('Estoque insuficiente para o produto "', nome_produto, '". Quantidade disponível: ', qtd_disponivel, '.');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = msg_erro;
    ELSE
        UPDATE produto SET quantidade = quantidade - NEW.quantidade
        WHERE id_produto = NEW.id_produto;
    END IF;
END$$

DELIMITER ;


# Procedure de atualização da tabela de Estatistica

DELIMITER //

CREATE PROCEDURE AtualizarEstatisticaPorData(IN dataEscolhida DATE)
BEGIN
    -- Verifica se já existe uma linha com a data fornecida
    IF EXISTS (SELECT 1 FROM estatistica WHERE data = dataEscolhida) THEN
        -- Se a linha já existe, atualiza a linha
        UPDATE estatistica
        SET 
            quantidade_produtos_vendidos = (
                SELECT COALESCE(SUM(pv.quantidade), 0)
                FROM venda v
                JOIN produto_venda pv ON v.id_venda = pv.id_venda
                WHERE v.data_venda = dataEscolhida
            ),
            quantidade_vendas = (
                SELECT COALESCE(COUNT(*), 0)
                FROM venda
                WHERE data_venda = dataEscolhida
            ),
            total_ganho = (
                SELECT COALESCE(SUM(preco), 0)
                FROM venda
                WHERE data_venda = dataEscolhida
            )
        WHERE data = dataEscolhida;
    ELSE
        -- Se a linha não existe, insere uma nova linha
        INSERT INTO estatistica (quantidade_produtos_vendidos, quantidade_vendas, total_ganho, data)
        SELECT 
            COALESCE(SUM(pv.quantidade), 0),
            COALESCE(COUNT(v.id_venda), 0),
            COALESCE(SUM(v.preco), 0),
            dataEscolhida
        FROM venda v
        LEFT JOIN produto_venda pv ON v.id_venda = pv.id_venda
        WHERE v.data_venda = dataEscolhida;
    END IF;
END //

DELIMITER ;
DELIMITER ;



# Triggers de atualização

DELIMITER $$

CREATE TRIGGER atualiza_total_ganho_after_produto_insert
AFTER INSERT ON produto_venda
FOR EACH ROW
BEGIN
    UPDATE estatistica
    SET quantidade_produtos_vendidos = (
        SELECT COALESCE(SUM(quantidade), 0)
        FROM produto_venda
    )
    WHERE id = 1;  
END $$

DELIMITER $$

CREATE TRIGGER atualiza_total_ganho_after_produto_update
AFTER DELETE ON produto_venda
FOR EACH ROW
BEGIN
    UPDATE estatistica
    SET quantidade_produtos_vendidos = (
        SELECT COALESCE(SUM(quantidade), 0)
        FROM produto_venda
    );
END $$

DELIMITER ;

#atualiza a quantidade de vendas e o ganho total apos deletar ou inserir uma nova venda

DELIMITER $$

CREATE TRIGGER atualiza_estatistica_after_insert
AFTER INSERT ON venda
FOR EACH ROW
BEGIN
    -- Atualiza a quantidade de vendas e o total ganho na tabela estatistica
    UPDATE estatistica
    SET quantidade_vendas = (SELECT COUNT(*) FROM venda),
        total_ganho = (SELECT COALESCE(SUM(preco), 0) FROM venda)
    WHERE id = 1; -- Ajuste o WHERE conforme necessário
END$$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER atualiza_estatistica_after_delete
AFTER DELETE ON venda
FOR EACH ROW
BEGIN
    -- Atualiza a quantidade de vendas e o total ganho na tabela estatistica
    UPDATE estatistica
    SET quantidade_vendas = (SELECT COUNT(*) FROM venda),
        total_ganho = (SELECT COALESCE(SUM(preco), 0) FROM venda)
    WHERE id = 1; -- Ajuste o WHERE conforme necessário
END$$

DELIMITER ;

# Atualiza os produtos vendidos

DELIMITER $$

CREATE TRIGGER atualizar_quantidade_produtos_vendidos
AFTER INSERT ON produto_venda
FOR EACH ROW
BEGIN
    DECLARE total_quantidade INT;

    -- Soma todas as quantidades da tabela produto_venda
    SELECT SUM(quantidade) INTO total_quantidade FROM produto_venda;

    -- Atualiza a tabela estatistica com o valor total apenas onde id = 1
    UPDATE estatistica
    SET quantidade_produtos_vendidos = total_quantidade
    WHERE id = 1;
END$$

DELIMITER ;
