DELIMITER $$

CREATE TRIGGER funcionario_insert_trigger
AFTER INSERT ON funcionario
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER funcionario_update_trigger
AFTER UPDATE ON funcionario
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER funcionario_delete_trigger
AFTER DELETE ON funcionario
FOR EACH ROW
BEGIN
    CALL atualizar_estatistica_completa();
END$$

DELIMITER ;
