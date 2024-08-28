DELIMITER //

CREATE PROCEDURE AtualizarEstatisticaPorData(IN dataEscolhida DATE)
BEGIN
    -- Verifica se já existe uma linha com a data fornecida
    IF EXISTS (SELECT 1 FROM estatistica WHERE data = dataEscolhida) THEN
        -- Se a linha já existe, atualiza a linha
        UPDATE estatistica
        SET 
            quantidade_produtos_vendidos = (
                SELECT COALESCE(SUM(pv.quantidade), 0)
                FROM venda v
                JOIN produto_venda pv ON v.id_venda = pv.id_venda
                WHERE v.data_venda = dataEscolhida
            ),
            quantidade_vendas = (
                SELECT COALESCE(COUNT(*), 0)
                FROM venda
                WHERE data_venda = dataEscolhida
            ),
            total_ganho = (
                SELECT COALESCE(SUM(preco), 0)
                FROM venda
                WHERE data_venda = dataEscolhida
            )
        WHERE data = dataEscolhida;
    ELSE
        -- Se a linha não existe, insere uma nova linha
        INSERT INTO estatistica (quantidade_produtos_vendidos, quantidade_vendas, total_ganho, data)
        SELECT 
            COALESCE(SUM(pv.quantidade), 0),
            COALESCE(COUNT(v.id_venda), 0),
            COALESCE(SUM(v.preco), 0),
            dataEscolhida
        FROM venda v
        LEFT JOIN produto_venda pv ON v.id_venda = pv.id_venda
        WHERE v.data_venda = dataEscolhida;
    END IF;
END //

DELIMITER ;