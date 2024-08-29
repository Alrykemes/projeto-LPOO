package com.managepro.dao;

	import java.math.BigDecimal;
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.managepro.core.model.Estatistica;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.managepro.repository.MySQLConnection;
import com.managepro.repository.StatisticRepository;	

	public class EstatisticaDAO implements StatisticRepository {
		
		private Connection connection;

	    public EstatisticaDAO() throws ExcecaoDoSistema {
	    	try {
				this.connection = MySQLConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
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
	                        rs.getLong("quantidade_vendas"),
	                        rs.getLong("quantidade_produtos_vendidos"),
	                        rs.getBigDecimal("total_ganho"),
	                        rs.getDate("date")
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
	                	rs.getLong("quantidade_produtos_vendidos"),
	                    rs.getLong("quantidade_vendas"),
	                    rs.getBigDecimal("total_ganho"),
	                    rs.getDate("data")
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
	        String sql = "SELECT * FROM estatistica WHERE quantidade_vendas = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setLong(1, quantidadeVenda);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    list.add(new Estatistica(
	                        rs.getLong("id"),
	                        rs.getLong("quantidade_vendas"),
	                        rs.getLong("quantidade_produtos"),
	                        rs.getBigDecimal("total_ganho"),
	                        rs.getDate("data")
	                    ));
	                }
	            }
	        }
	        return list;
	    }
	    
	    
	    
	    public List<Estatistica> findByQuantidadeFuncionario(Long quantidadeFuncionario) throws SQLException {
	        List<Estatistica> list = new ArrayList<>();
	        String sql = "SELECT * FROM estatistica WHERE quantidade_funcionarios = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setLong(1, quantidadeFuncionario);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    list.add(new Estatistica(
	                        rs.getLong("id"),
	                        rs.getLong("quantidade_vendas"),
	                        rs.getLong("quantidade_produtos_vendidos"),
	                        rs.getBigDecimal("total_ganho"),
	                        rs.getDate("data")
	                    ));
	                }
	            }
	        }
	        return list;
	    }
	    
	    
	    
	    public List<Estatistica> findByTotalGanho(BigDecimal precoTotal) throws SQLException {
	        List<Estatistica> list = new ArrayList<>();
	        String sql = "SELECT * FROM estatistica WHERE preco_total = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setBigDecimal(1, precoTotal);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    list.add(new Estatistica(
	                        rs.getLong("id"),
	                        rs.getLong("quantidade_vendas"),
	                        rs.getLong("quantidade_produtos_vendidos"),
	                        rs.getBigDecimal("total_ganho"),
	                        rs.getDate("data")
	                    ));
	                }
	            }
	        }
	        return list;
	    }
	    
	    
	    
	    
	    public Estatistica obterEstatisticas() throws SQLException {
	        Estatistica estatistica = new Estatistica();
	        String query = "SELECT quantidade_produtos_vendidos, quantidade_vendas, total_ganho FROM estatistica";
	        
	        try (PreparedStatement stmt = connection.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                estatistica.setQuantidadeProdutos(rs.getLong("quantidade_produtos_vendidos"));
	                estatistica.setQuantidadeVendas(rs.getLong("quantidade_vendas"));
	                estatistica.setTotalGanho(rs.getBigDecimal("total_ganho"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return estatistica;
	    }
	    
	    
	    
	    
	    public List<Estatistica> findByDataAndTipo(Date dataInicio, Date dataFim, String tipo) throws SQLException {
	        List<Estatistica> list = new ArrayList<>();
	        String sql = "SELECT * FROM estatistica WHERE data BETWEEN ? AND ? AND tipo = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setDate(1, dataInicio);
	            stmt.setDate(2, dataFim);
	            stmt.setString(3, tipo);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    list.add(new Estatistica(
	                        rs.getLong("id"),
	                        rs.getLong("quantidade_vendas"),
	                        rs.getLong("quantidade_produtos"),
	                        rs.getBigDecimal("total_ganho"),
	                        rs.getDate("data")
	                    ));
	                }
	            }
	        }
	        return list;
	    }



	    

	    
	    
	    
	    
	}