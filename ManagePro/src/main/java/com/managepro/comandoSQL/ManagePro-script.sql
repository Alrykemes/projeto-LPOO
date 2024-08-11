CREATE TABLE `cliente` (
  `id` int NOT NULL,
  `nome` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `cpf` varchar(11) COLLATE utf8mb3_bin NOT NULL,
  `main_telefone` varchar(15) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `estoque` (
  `id` int NOT NULL,
  `cod_produto` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `quantidade` int NOT NULL,
  `lote` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `data` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `funcionario` (
  `idfuncionario` int NOT NULL,
  `nome` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `cpf` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `tipo_funcionario` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`idfuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `produtos` (
  `cod_produtos` int NOT NULL,
  `nome` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `fornecedor` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `marca` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `preco` decimal(10,0) NOT NULL,
  PRIMARY KEY (`cod_produtos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `produtos_por_venda` (
  `id` int NOT NULL,
  `id_venda` int NOT NULL,
  `codigo_produto` int NOT NULL,
  `quantidade` int NOT NULL,
  `preco_total` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `tipo_funcionario` (
  `id` int NOT NULL,
  `tipo_funcionario` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `vendas` (
  `id` int NOT NULL,
  `id_cliente` int NOT NULL,
  `valor_total` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `forma_pagamento` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `data_venda` timestamp NOT NULL,
  `id_funcionario` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin