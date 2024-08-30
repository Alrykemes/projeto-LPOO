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

	public EstatisticaDAO() {
	}

	public Estatistica read(Long id) throws ExcecaoDoSistema, SQLException {
		try {
		connection = MySQLConnection.getConnection();
		String sql = "SELECT * FROM estatistica WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					return new Estatistica(rs.getLong("id"), rs.getLong("quantidade_vendas"),
							rs.getLong("quantidade_produtos_vendidos"), rs.getBigDecimal("total_ganho"),
							rs.getDate("date"));
				} else {
					return null;
				}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
			}
	}

	public List<Estatistica> listAll() throws SQLException, ExcecaoDoSistema {
		try {
			connection = MySQLConnection.getConnection();
		List<Estatistica> list = new ArrayList<>();

		String sql = "SELECT * FROM estatistica";

		PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Estatistica estatistica = new Estatistica(

						rs.getLong("id"), rs.getLong("quantidade_vendas"), rs.getLong("quantidade_produtos_vendidos"),
						rs.getBigDecimal("total_ganho"), rs.getDate("data"));

				list.add(estatistica);
			}
		return list;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	public List<Estatistica> findByQuantidadeVenda(Long quantidadeVenda) throws SQLException, ExcecaoDoSistema, ClassNotFoundException {
		try {
			connection = MySQLConnection.getConnection();
		List<Estatistica> list = new ArrayList<>();
		String sql = "SELECT * FROM estatistica WHERE quantidade_vendas = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, quantidadeVenda);
			ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					list.add(new Estatistica(rs.getLong("id"), rs.getLong("quantidade_vendas"),
							rs.getLong("quantidade_produtos"), rs.getBigDecimal("total_ganho"), rs.getDate("data")));
				}
			
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	public List<Estatistica> findByQuantidadeFuncionario(Long quantidadeFuncionario) throws SQLException, ExcecaoDoSistema {
		try {
			connection = MySQLConnection.getConnection();
		List<Estatistica> list = new ArrayList<>();
		String sql = "SELECT * FROM estatistica WHERE quantidade_funcionarios = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, quantidadeFuncionario);
			ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					list.add(new Estatistica(rs.getLong("id"), rs.getLong("quantidade_vendas"),
							rs.getLong("quantidade_produtos_vendidos"), rs.getBigDecimal("total_ganho"),
							rs.getDate("data")));
				}
				return list;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	public List<Estatistica> findByTotalGanho(BigDecimal precoTotal) throws SQLException, ExcecaoDoSistema {
		try {
			connection = MySQLConnection.getConnection();
		List<Estatistica> list = new ArrayList<>();
		String sql = "SELECT * FROM estatistica WHERE preco_total = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setBigDecimal(1, precoTotal);
			ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					list.add(new Estatistica(rs.getLong("id"), rs.getLong("quantidade_vendas"),
							rs.getLong("quantidade_produtos_vendidos"), rs.getBigDecimal("total_ganho"),
							rs.getDate("data")));
				}
				return list;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	public Estatistica obterEstatisticas() throws SQLException, ExcecaoDoSistema {
		try {
			connection = MySQLConnection.getConnection();
		Estatistica estatistica = new Estatistica();
		String query = "SELECT quantidade_produtos_vendidos, quantidade_vendas, total_ganho FROM estatistica";

		PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				estatistica.setQuantidadeProdutos(rs.getLong("quantidade_produtos_vendidos"));
				estatistica.setQuantidadeVendas(rs.getLong("quantidade_vendas"));
				estatistica.setTotalGanho(rs.getBigDecimal("total_ganho"));
			}
			return estatistica;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		} 
	}

	public List<Estatistica> findByData(Date dataInicio, Date dataFim) throws SQLException, ExcecaoDoSistema {
		try {
			connection = MySQLConnection.getConnection();
		List<Estatistica> list = new ArrayList<>();
		String sql = "SELECT * FROM estatistica WHERE data BETWEEN ? AND ?";
		PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setDate(1, new java.sql.Date(dataInicio.getTime()));
			stmt.setDate(2, new java.sql.Date(dataFim.getTime()));

			ResultSet rs = stmt.executeQuery();
				while (rs.next()) {

					list.add(new Estatistica(rs.getLong("id"), rs.getLong("quantidade_vendas"),
							rs.getLong("quantidade_produtos_vendidos"), rs.getBigDecimal("total_ganho"),
							rs.getDate("data")));
				}
			
			return list;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}
}
