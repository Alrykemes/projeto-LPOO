DELIMITER $$

CREATE TRIGGER atualizar_estatistica BEFORE UPDATE ON estatistica
FOR EACH ROW
BEGIN
    -- Atualizar linha com id = 1
    UPDATE estatistica
    SET quantidade_produtos_vendidos = (SELECT IFNULL(SUM(quantidade), 0) FROM produto_venda),
        data = CURDATE()
    WHERE id = 1;
END$$

DELIMITER ;

 
 
 
 
 
 