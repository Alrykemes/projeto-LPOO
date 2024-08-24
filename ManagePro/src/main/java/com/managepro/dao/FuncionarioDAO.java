package com.managepro.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.managepro.core.model.Cargos;
import com.managepro.core.model.Funcionario;
import com.managepro.repository.FuncionarioRepository;
import com.managepro.repository.MySQLConnection;
import com.managepro.ui.Janela;

public class FuncionarioDAO implements FuncionarioRepository {

	private Funcionario funcionario;

	public Funcionario encontrarFuncionarioPeloUsuario(String user) {
		try {
			Connection connection = MySQLConnection.getConnection();
			Statement stmt = connection.createStatement();

			String sql = "SELECT f.id_funcionario, f.nome, f.cpf, t.numero, f.cargo, f.salario, f.data_admissao, f.usuario , f.senha "
					+ "FROM funcionario AS f INNER JOIN telefone_funcionario AS t ON f.id_funcionario = t.id_funcionario "
					+ "WHERE usuario = '" + user + "';";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id_funcionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setTelefone(rs.getString("numero"));
				funcionario.setFuncao(Cargos.valueOf(rs.getString("cargo")));
				funcionario.setSalario(rs.getBigDecimal("salario"));
				funcionario.setDataAdmissao((rs.getDate("data_admissao").toLocalDate()));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
			}

			return funcionario;

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(),
					"Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Funcionario encontrarFuncionarioPeloId(Long id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			Statement stmt = connection.createStatement();

			String sql = "SELECT f.id_funcionario, f.nome, f.cpf, t.numero, f.cargo, f.salario, f.data_admissao, f.usuario , f.senha "
					+ "FROM funcionario AS f INNER JOIN telefone_funcionario AS t ON f.id_funcionario = t.id_funcionario "
					+ "WHERE id_funcionario = '" + id + "';";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id_funcionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setTelefone(rs.getString("numero"));
				funcionario.setFuncao(Cargos.valueOf(rs.getString("cargo")));
				funcionario.setSalario(rs.getBigDecimal("salario"));
				funcionario.setDataAdmissao((rs.getDate("data_admissao").toLocalDate()));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
			}

			return funcionario;

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(),
					"Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Funcionario encontrarFuncionarioPeloCpf(String cpf) {
		try {
			Connection connection = MySQLConnection.getConnection();
			Statement stmt = connection.createStatement();

			String sql = "SELECT f.id_funcionario, f.nome, f.cpf, t.numero, f.cargo, f.salario, f.data_admissao, f.usuario , f.senha "
					+ "FROM funcionario AS f INNER JOIN telefone_funcionario AS t ON f.id_funcionario = t.id_funcionario "
					+ "WHERE cpf = '" + cpf + "';";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id_funcionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setTelefone(rs.getString("numero"));
				funcionario.setFuncao(Cargos.valueOf(rs.getString("cargo")));
				funcionario.setSalario(rs.getBigDecimal("salario"));
				funcionario.setDataAdmissao((rs.getDate("data_admissao").toLocalDate()));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
			}

			return funcionario;

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(),
					"Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public void adicionarFuncionario(Funcionario funcionario) {
		try {
			Connection connection = MySQLConnection.getConnection();
			PreparedStatement statementFuncionario = connection.prepareStatement(
					"INSERT INTO funcionario(nome, cpf, cargo, salario, data_admissao, usuario, senha) VALUES (?, ?, ?, ?, ?, ? ,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			PreparedStatement statementTelefone = connection
					.prepareStatement("INSERT INTO telefone_funcionario(id_funcionario, numero) VALUES (?, ?);");

			statementFuncionario.setString(1, funcionario.getNome());
			statementFuncionario.setString(2, funcionario.getCpf());
			statementFuncionario.setString(3, funcionario.getFuncao().name());
			statementFuncionario.setBigDecimal(4, funcionario.getSalario());
			statementFuncionario.setDate(5, Date.valueOf(funcionario.getDataAdmissao()));
			statementFuncionario.setString(6, funcionario.getUsuario());
			statementFuncionario.setString(7, funcionario.getSenha());
			statementFuncionario.executeUpdate();

			ResultSet rs = statementFuncionario.getGeneratedKeys();
			if (rs.next()) {
				Long funcionarioId = rs.getLong(1);

				statementTelefone.setLong(1, funcionarioId);
				statementTelefone.setString(2, funcionario.getTelefone());
				statementTelefone.execute();

			} else {
				throw new SQLException("Falha ao Inserir Funcionário, ID não Gerado ou nulo!");
			}

			rs.close();
			statementFuncionario.close();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(),
					"Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void editarFuncionario(Funcionario funcionarioEditado, Funcionario funcionarioOriginal) {
		try {
			Connection connection = MySQLConnection.getConnection();

			String updateFuncionarioQuery = "UPDATE funcionario SET nome = ?, cpf = ?, cargo = ?, salario = ?, data_admissao = ?, usuario = ?, senha = ? WHERE id_funcionario = ?";
			PreparedStatement statementFuncionario = connection.prepareStatement(updateFuncionarioQuery);

			statementFuncionario.setString(1, funcionarioEditado.getNome());
			statementFuncionario.setString(2, funcionarioEditado.getCpf());
			statementFuncionario.setString(3, funcionarioEditado.getFuncao().name());
			statementFuncionario.setBigDecimal(4, funcionarioEditado.getSalario());
			statementFuncionario.setDate(5, Date.valueOf(funcionarioEditado.getDataAdmissao()));
			statementFuncionario.setString(6, funcionarioEditado.getUsuario());
			statementFuncionario.setString(7, funcionarioEditado.getSenha());
			statementFuncionario.setLong(8, funcionarioOriginal.getId()); 

			int linhasAfetadas = statementFuncionario.executeUpdate();
			System.out.println(linhasAfetadas);

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao Atualizar Funcionário, nenhum registro foi modificado!");
			}

			// Atualiza o telefone do funcionário
			String updateTelefoneQuery = "UPDATE telefone_funcionario SET numero = ? WHERE id_funcionario = ?";
			PreparedStatement statementTelefone = connection.prepareStatement(updateTelefoneQuery);

			statementTelefone.setString(1, funcionarioEditado.getTelefone());
			statementTelefone.setLong(2, funcionarioOriginal.getId()); 

			statementTelefone.executeUpdate();

			statementFuncionario.close();
			statementTelefone.close();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(),
					"Erro ao edi, tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public List<Funcionario> listaDeFuncionarios() {

		List<Funcionario> funcionarios = new ArrayList<>();

		try {
			Connection connection = MySQLConnection.getConnection();
			Statement stmt = connection.createStatement();

			String sql = "SELECT f.id_funcionario, f.nome, f.cpf, t.numero, f.cargo, f.salario, f.data_admissao, f.usuario , f.senha "
					+ "FROM funcionario AS f INNER JOIN telefone_funcionario AS t ON f.id_funcionario = t.id_funcionario";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id_funcionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setTelefone(rs.getString("numero"));
				funcionario.setFuncao(Cargos.valueOf(rs.getString("cargo")));
				funcionario.setSalario(rs.getBigDecimal("salario"));
				funcionario.setDataAdmissao(rs.getDate("data_admissao").toLocalDate());
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				funcionarios.add(funcionario);
			}

			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(),
					"Erro na comunicação do sistema. Tente novamente mais tarde.");
			e.printStackTrace();
		}
		return funcionarios;
	}

	@Override
	public void apagarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}

}
