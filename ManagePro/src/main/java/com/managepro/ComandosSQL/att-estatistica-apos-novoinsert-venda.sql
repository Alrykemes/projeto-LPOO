DELIMITER $$

CREATE TRIGGER atualizar_estatistica BEFORE UPDATE ON estatistica
FOR EACH ROW
BEGIN
    -- Atualizar linha com id = 1
    UPDATE estatistica
    SET quantidade_vendas = (SELECT IFNULL(COUNT(*), 0) FROM venda),
        total_ganho = (SELECT IFNULL(SUM(preco), 0) FROM venda),
        data = CURDATE()
    WHERE id = 1;
END$$

DELIMITER ;
