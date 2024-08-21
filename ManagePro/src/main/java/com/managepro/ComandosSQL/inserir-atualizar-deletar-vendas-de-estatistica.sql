DELIMITER $$

CREATE TRIGGER venda_insert_trigger
AFTER INSERT ON venda
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER venda_update_trigger
AFTER UPDATE ON venda
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER venda_delete_trigger
AFTER DELETE ON venda
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;
