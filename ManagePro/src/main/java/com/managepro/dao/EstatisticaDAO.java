package com.managepro.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.managepro.core.model.Estatistica;
import com.managepro.repository.StatisticRepository;
import com.managepro.ui.Janela;
import com.toedter.calendar.JDateChooser;
import com.managepro.repository.MySQLConnection;	

	@SuppressWarnings("unused")
	public class EstatisticaDAO implements StatisticRepository {
		
		private Connection connection;

	    public EstatisticaDAO() {
	    	try {
				this.connection = MySQLConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(),
						"Erro na comunicação do sistema");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
	    }


	    
	    public Estatistica read(Long id) throws SQLException {
	        String sql = "SELECT * FROM estatistica WHERE id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setLong(1, id);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    return new Estatistica(
	                        rs.getLong("id"),
	                        rs.getLong("quantidade_venda"),
	                        rs.getLong("quantidade_produto"),
	                        rs.getLong("quantidade_funcionario"),
	                        rs.getBigDecimal("preco_total")
	                    );
	                } else {
	                    return null;
	                }
	            }
	        }
	    }

	       
	    public List<Estatistica> listAll() throws SQLException {
	        List<Estatistica> list = new ArrayList<>();
	        
	        String sql = "SELECT * FROM estatistica";
	        
	        try (PreparedStatement stmt = connection.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	            
	            while (rs.next()) {
	                
	                Estatistica estatistica = new Estatistica (
	                    
	                	rs.getLong("id"),
	                    rs.getLong("quantidade_venda"),
	                    rs.getLong("quantidade_produto"),
	                    rs.getLong("quantidade_funcionario"),
	                    rs.getBigDecimal("preco_total")
	                );
	                
	                list.add(estatistica);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;  
	        }
	        
	        return list;  
	    }
	    
	    
	    public List<Estatistica> findByQuantidadeVenda(Long quantidadeVenda) throws SQLException {
	        List<Estatistica> list = new ArrayList<>();
	        String sql = "SELECT * FROM estatistica WHERE quantidade_venda = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setLong(1, quantidadeVenda);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    list.add(new Estatistica(
	                        rs.getLong("id"),
	                        rs.getLong("quantidade_venda"),
	                        rs.getLong("quantidade_produto"),
	                        rs.getLong("quantidade_funcionario"),
	                        rs.getBigDecimal("preco_total")
	                    ));
	                }
	            }
	        }
	        return list;
	    }
	    
	    
	    public List<Estatistica> findByQuantidadeFuncionario(Long quantidadeFuncionario) throws SQLException {
	        List<Estatistica> list = new ArrayList<>();
	        String sql = "SELECT * FROM estatistica WHERE quantidade_funcionario = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setLong(1, quantidadeFuncionario);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    list.add(new Estatistica(
	                        rs.getLong("id"),
	                        rs.getLong("quantidade_venda"),
	                        rs.getLong("quantidade_produto"),
	                        rs.getLong("quantidade_funcionario"),
	                        rs.getBigDecimal("preco_total")
	                    ));
	                }
	            }
	        }
	        return list;
	    }
	    
	    
	    public List<Estatistica> findByPrecoTotal(BigDecimal precoTotal) throws SQLException {
	        List<Estatistica> list = new ArrayList<>();
	        String sql = "SELECT * FROM estatistica WHERE preco_total = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setBigDecimal(1, precoTotal);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    list.add(new Estatistica(
	                        rs.getLong("id"),
	                        rs.getLong("quantidade_venda"),
	                        rs.getLong("quantidade_produto"),
	                        rs.getLong("quantidade_funcionario"),
	                        rs.getBigDecimal("preco_total")
	                    ));
	                }
	            }
	        }
	        return list;
	    }
	    
	    
	    /*
	    public List<Object[]> getQuantidadeVendasPorCategoria(JDateChooser dateChooserInicial, JDateChooser dateChooserFinal) throws SQLException {
	        List<Object[]> result = new ArrayList<>();
	        String sql = "SELECT categoria, COUNT(*) as quantidade FROM vendas WHERE data BETWEEN ? AND ? GROUP BY categoria";

	        Date dataInicial = new Date(dateChooserInicial.getDate().getTime());
	        Date dataFinal = new Date(dateChooserFinal.getDate().getTime());

	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setDate(1, dataInicial);
	            stmt.setDate(2, dataFinal);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    result.add(new Object[]{rs.getString("categoria"), rs.getInt("quantidade")});
	                }
	            }
	        }
	        return result;
	    }
	    */
	    
	    
	    
	    public Estatistica obterEstatisticas() throws SQLException {
	        Estatistica estatistica = new Estatistica();
	        String query = "SELECT quantidade_produtos, quantidade_funcionarios, total_ganho FROM estatisticas";
	        
	        try (PreparedStatement stmt = connection.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                estatistica.setQuantidadeProdutos(rs.getLong("quantidade_produtos"));
	                estatistica.setQuantidadeFuncionarios(rs.getLong("quantidade_funcionarios"));
	                estatistica.setTotalGanho(rs.getBigDecimal("total_ganho"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return estatistica;
	    }
	    
	    
	    
	    
	}


