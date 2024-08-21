DELIMITER $$

CREATE TRIGGER produto_insert_trigger
AFTER INSERT ON produto
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER produto_update_trigger
AFTER UPDATE ON produto
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER produto_delete_trigger
AFTER DELETE ON produto
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;
