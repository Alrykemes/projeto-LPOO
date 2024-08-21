DELIMITER $$

CREATE TRIGGER atualiza_total_ganho_after_produto_update
AFTER UPDATE ON produto
FOR EACH ROW
BEGIN
    UPDATE estatistica
    SET total_ganho = (
        SELECT COALESCE(SUM(preco), 0)
        FROM produto
    );
END $$

DELIMITER ;
