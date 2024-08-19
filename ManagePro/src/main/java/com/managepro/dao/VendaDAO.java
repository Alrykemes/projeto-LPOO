package com.managepro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.managepro.core.model.FormaPagamento;
import com.managepro.core.model.Funcionario;
import com.managepro.core.model.Produto;
import com.managepro.core.model.Venda;
import com.managepro.repository.MySQLConnection;
import com.managepro.repository.SaleRepository;

public class VendaDAO implements SaleRepository {
	
	
	
public void adicionarVendas(Venda venda) throws ClassNotFoundException, SQLException {
		
	  Connection connection = null;
	  PreparedStatement statementVenda = null;
	  PreparedStatement statementProdutoVenda = null;

	   try {
	        
	    connection = MySQLConnection.getConnection();
	    statementVenda = connection.prepareStatement("INSERT INTO venda (id_venda, id_funcionario, id_cliente, forma_pagamento, data_venda, preco) VALUES (?, ?, ?, ?, ?, ?)");
        statementProdutoVenda = connection.prepareStatement("INSERT INTO produto_venda (id_venda, id_produto, quantidade, preco) VALUES (?, ?, ?, ?)");

        statementVenda.setLong(1, venda.getId());
        statementVenda.setLong(2, venda.getFuncionario().getId());
        statementVenda.setLong(3, venda.getCliente().getId());
        statementVenda.setString(4, venda.getFormaDePagamentoEnum().name());
        LocalDate data = venda.getData();
        Date sqlDate = java.sql.Date.valueOf(data); 
        statementVenda.setDate(5, sqlDate); 
        statementVenda.setBigDecimal(6, venda.getPreco());

        statementVenda.execute();

        // Insere produtos na tabela produto_venda
        for (Produto produto : venda.getProdutosVendidos()) {
            statementProdutoVenda.setLong(1, venda.getId());
            statementProdutoVenda.setLong(2, produto.getIdProduto());
            statementProdutoVenda.setInt(3, produto.getQuantidade());
            statementProdutoVenda.setBigDecimal(4, produto.getPreco());

            statementProdutoVenda.execute();
        }

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        try {
            if (statementProdutoVenda != null) statementProdutoVenda.close();
            if (statementVenda != null) statementVenda.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
	
	
	


public void pesquisarVendasPorId(Long Id) throws ClassNotFoundException, SQLException {
	
	Connection connection = null;
    PreparedStatement statementReceberVendas = null;

    try {
    	
        connection = MySQLConnection.getConnection();
        statementReceberVendas = connection.prepareStatement("SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco " +
                "FROM venda v WHERE v.id_venda = ?");

        statementReceberVendas.setLong(1, Id);
        statementReceberVendas.execute();

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace(); 
    } finally {
        try {
            if (statementReceberVendas != null) statementReceberVendas.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




public void deletarVendas(Long Id) throws ClassNotFoundException, SQLException {
	
	Connection connection = null;
    PreparedStatement statementDeletarProduto = null;
    PreparedStatement statementDeletarVendas = null;

    try {
        connection = MySQLConnection.getConnection();
        statementDeletarProduto = connection.prepareStatement("DELETE FROM produto_venda WHERE id_venda = ?");
        statementDeletarVendas = connection.prepareStatement("DELETE FROM venda WHERE id_venda = ?");

        statementDeletarProduto.setLong(1, Id);
        statementDeletarVendas.setLong(1, Id);

        statementDeletarProduto.execute();
        statementDeletarVendas.execute();

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();  
    } finally {
        try {
            if (statementDeletarProduto != null) statementDeletarProduto.close();
            if (statementDeletarVendas != null) statementDeletarVendas.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}




@Override
public List<Venda> listarVendaPorId(Long Id) throws ClassNotFoundException, SQLException {
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        connection = MySQLConnection.getConnection();
        statement = connection.prepareStatement(
            "SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco " +
            "FROM venda v WHERE v.id_venda = ?"
        );

        statement.setLong(1, Id);
        resultSet = statement.executeQuery();
        
        List<Venda> vendas = new ArrayList<>();

        while (resultSet.next()) {
            
        	Venda venda = new Venda();
            
            venda.setId(resultSet.getLong("id_venda"));
            venda.setFuncionario(buscarFuncionarioPorId(resultSet.getLong("id_funcionario"))); // Implementar método TO DO
            venda.setCliente(buscarClientePorId(resultSet.getLong("id_cliente"))); // Implementar método
            venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
            venda.setData(resultSet.getDate("data_venda").toLocalDate());
            venda.setPreco(resultSet.getBigDecimal("preco"));
            venda.setProdutosVendidos(listarProdutosPorVendaId(venda.getId())); // Implementar método

            vendas.add(venda);
        }
        
        return vendas;
    
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace(); 
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



@Override
public List<Venda> listarVendaPorFuncionario(Long idFuncionario) throws ClassNotFoundException, SQLException {
    
	Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        connection = MySQLConnection.getConnection();
        statement = connection.prepareStatement(
                "SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco " +
                        "FROM venda v WHERE v.id_funcionario = ?"
        );

        statement.setLong(1, idFuncionario);
        resultSet = statement.executeQuery();

        List<Venda> vendas = new ArrayList<>();

        while (resultSet.next()) {
            
        	Venda venda = new Venda();
            
            venda.setId(resultSet.getLong("id_venda"));
            venda.setFuncionario(buscarFuncionarioPorId(resultSet.getLong("id_funcionario"))); 
            venda.setCliente(buscarClientePorId(resultSet.getLong("id_cliente"))); 
            venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
            venda.setData(resultSet.getDate("data_venda").toLocalDate());
            venda.setPreco(resultSet.getBigDecimal("preco"));
            venda.setProdutosVendidos(listarProdutosPorVendaId(venda.getId()));

            vendas.add(venda);
        }

        return vendas;

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();  
        return null;
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



@Override
public List<Venda> listarVendasPorData(LocalDate dataVenda) throws ClassNotFoundException, SQLException {
    
	Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        connection = MySQLConnection.getConnection();
        statement = connection.prepareStatement(
                "SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco " +
                        "FROM venda v WHERE v.data_venda = ?"
        );

        statement.setDate(1, Date.valueOf(dataVenda));
        resultSet = statement.executeQuery();

        List<Venda> vendas = new ArrayList<>();

        while (resultSet.next()) {
            
        	Venda venda = new Venda();
            
        	venda.setId(resultSet.getLong("id_venda"));
            venda.setFuncionario(buscarFuncionarioPorId(resultSet.getLong("id_funcionario"))); 
            venda.setCliente(buscarClientePorId(resultSet.getLong("id_cliente"))); 
            venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
            venda.setData(resultSet.getDate("data_venda").toLocalDate());
            venda.setPreco(resultSet.getBigDecimal("preco"));
                venda.setProdutosVendidos(listarProdutosPorVendaId(venda.getId()));

                vendas.add(venda);
            }

            return vendas;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();  
            return null;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}



	
	
	
	
}
