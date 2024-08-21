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

DELIMITER ;
