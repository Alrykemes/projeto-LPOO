CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL,
  `nome` varchar(70) COLLATE utf8mb3_bin NOT NULL,
  `cpf` varchar(11) COLLATE utf8mb3_bin NOT NULL,
  `data_nascimento` date NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `funcionario` (
  `id_funcionario` int NOT NULL,
  `nome` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `cpf` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `cargo` enum('ADMINISTRADOR','CONTADOR','ESTOQUISTA','GERENTE','VENDEDOR') COLLATE utf8mb3_bin NOT NULL,
  `salario` decimal(10,0) NOT NULL,
  `data_admissao` date NOT NULL,
  `usuario` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `senha` varchar(120) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`id_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `produto` (
  `id_produto` int NOT NULL,
  `nome` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `preco` decimal(10,0) NOT NULL,
  `quantidade` int NOT NULL,
  `marca` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `fornecedor` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `validade` date NOT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `venda` (
  `id_venda` int NOT NULL,
  `id_funcionario` int NOT NULL,
  `id_cliente` int NOT NULL,
  `valor_total` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `forma_pagamento` enum('CARTAO_DE_ALIMENTACAO','CARTAO_DE_CREDITO','CARTAO_DE_DEBITO','DINHEIRO','PIX') COLLATE utf8mb3_bin NOT NULL,
  `data_venda` date NOT NULL,
  `preco` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `id_cliente_idx` (`id_cliente`),
  KEY `id_funcionario_idx` (`id_funcionario`),
  CONSTRAINT `fk_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `fk_id_funcionario` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `produto_venda` (
  `id_produto_venda` int NOT NULL,
  `id_venda` int NOT NULL,
  `id_produto` int NOT NULL,
  `quantidade` int NOT NULL,
  `preco` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_produto_venda`),
  KEY `id_venda_idx` (`id_venda`),
  KEY `id_produto_idx` (`id_produto`),
  CONSTRAINT `fk_id_produto` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`),
  CONSTRAINT `fk_id_venda` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `telefone_cliente` (
  `id_cliente` int NOT NULL,
  `numero` varchar(15) COLLATE utf8mb3_bin NOT NULL,
  KEY `id_cliente_idx` (`id_cliente`),
  CONSTRAINT `fk_id_cliente_fk` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `telefone_funcionario` (
  `id_funcionario` int NOT NULL,
  `numero` varchar(15) COLLATE utf8mb3_bin NOT NULL,
  KEY `id_funcionario_idx` (`id_funcionario`),
  CONSTRAINT `fk_id_funcionario_fk` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

