DELIMITER $$

CREATE TRIGGER atualiza_total_ganho_update
AFTER UPDATE ON venda
FOR EACH ROW
BEGIN
    UPDATE estatistica
    SET total_ganho = (
        SELECT SUM(valor_venda)
        FROM venda
    );
END $$

CREATE TRIGGER atualiza_total_ganho_delete
AFTER DELETE ON venda
FOR EACH ROW
BEGIN
    UPDATE estatistica
    SET total_ganho = (
        SELECT SUM(valor_venda)
        FROM venda
    );
END $$

DELIMITER ;
