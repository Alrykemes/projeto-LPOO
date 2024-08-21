CREATE TABLE estatistica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantidade_produtos INT,
    quantidade_vendas INT,
    quantidade_funcionarios INT,
    total_ganho DECIMAL(10,2)
);

INSERT INTO estatistica (id, quantidade_produtos, quantidade_vendas, quantidade_funcionarios, total_ganho)
VALUES (1, 0, 0, 0, 0);

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

CALL atualizar_estatistica_completa();

SELECT * FROM estatistica WHERE id = 1;
