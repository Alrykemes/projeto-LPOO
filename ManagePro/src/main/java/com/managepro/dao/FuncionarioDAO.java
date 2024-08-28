package com.managepro.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.managepro.core.model.Cargos;
import com.managepro.core.model.Funcionario;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.managepro.repository.FuncionarioRepository;
import com.managepro.repository.MySQLConnection;

public class FuncionarioDAO implements FuncionarioRepository {

	private Funcionario funcionario;

	@Override
	public Funcionario encontrarFuncionarioPeloUsuario(String user) throws ExcecaoDoSistema {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT f.id_funcionario, f.nome, f.cpf, t.numero, f.cargo, f.salario, f.data_admissao, f.usuario, f.senha "
					+ "FROM funcionario AS f INNER JOIN telefone_funcionario AS t ON f.id_funcionario = t.id_funcionario "
					+ "WHERE usuario = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user);

			ResultSet rs = statement.executeQuery();

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

			connection.close();
			rs.close();
			statement.close();

			return funcionario;

		} catch (ClassNotFoundException | SQLException e) {
			throw new ExcecaoDoSistema("Erro ao procurar funcionário pelo usuário", e);
		}
	}

	@Override
	public Funcionario encontrarFuncionarioPeloId(Long id) throws ExcecaoDoSistema {
		try {
			Connection connection = MySQLConnection.getConnection();

			String sql = "SELECT f.id_funcionario, f.nome, f.cpf, t.numero, f.cargo, f.salario, f.data_admissao, f.usuario , f.senha "
					+ "FROM funcionario AS f INNER JOIN telefone_funcionario AS t ON f.id_funcionario = t.id_funcionario "
					+ "WHERE id_funcionario = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);

			ResultSet rs = statement.executeQuery();

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

			connection.close();
			rs.close();
			statement.close();

			return funcionario;

		} catch (ClassNotFoundException | SQLException e) {
			throw new ExcecaoDoSistema("Erro ao procurar funcionário pelo ID", e);
		}
	}

	@Override
	public Funcionario encontrarFuncionarioPeloCpf(String cpf) throws ExcecaoDoSistema {
		try {
			Connection connection = MySQLConnection.getConnection();

			String sql = "SELECT f.id_funcionario, f.nome, f.cpf, t.numero, f.cargo, f.salario, f.data_admissao, f.usuario , f.senha "
					+ "FROM funcionario AS f INNER JOIN telefone_funcionario AS t ON f.id_funcionario = t.id_funcionario "
					+ "WHERE cpf = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cpf);

			ResultSet rs = statement.executeQuery();

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

			connection.close();
			rs.close();
			statement.close();

			return funcionario;

		} catch (ClassNotFoundException | SQLException e) {
			throw new ExcecaoDoSistema("Erro ao procurar funcionário pelo CPF", e);
		}

	}

	@Override
	public void adicionarFuncionario(Funcionario funcionario) throws ExcecaoDoSistema {
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

			int linhasAfetadas = statementFuncionario.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao Atualizar Funcionário, nenhum registro foi modificado!");
			}

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
			throw new ExcecaoDoSistema("Erro ao adicionar funcionário ao banco", e);
		}

	}

	@Override
	public boolean editarFuncionario(Funcionario funcionarioEditado, Funcionario funcionarioOriginal)
			throws ExcecaoDoSistema {
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

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao Atualizar Funcionário, nenhum registro foi modificado!");
			}

			String updateTelefoneQuery = "UPDATE telefone_funcionario SET numero = ? WHERE id_funcionario = ?";
			PreparedStatement statementTelefone = connection.prepareStatement(updateTelefoneQuery);

			statementTelefone.setString(1, funcionarioEditado.getTelefone());
			statementTelefone.setLong(2, funcionarioOriginal.getId());

			statementTelefone.executeUpdate();

			statementFuncionario.close();
			statementTelefone.close();
			connection.close();

			return true;

		} catch (ClassNotFoundException | SQLException e) {
			throw new ExcecaoDoSistema("Erro ao editar funcionário", e);
		}
	}

	@Override
	public boolean removerFuncionario(Long idFuncionario) throws ExcecaoDoSistema {
		try {
			Connection connection = MySQLConnection.getConnection();
			PreparedStatement statementTelefone = connection
					.prepareStatement("DELETE FROM telefone_funcionario WHERE id_funcionario = ?");

			statementTelefone.setLong(1, idFuncionario);
			statementTelefone.execute();

			PreparedStatement statementFuncionario = connection.prepareStatement(
					"DELETE FROM funcionario WHERE id_funcionario = ?", PreparedStatement.RETURN_GENERATED_KEYS);

			statementFuncionario.setLong(1, idFuncionario);
			statementFuncionario.executeUpdate();

			statementFuncionario.close();
			statementTelefone.close();
			connection.close();

			return true;

		} catch (ClassNotFoundException | SQLException e) {
			throw new ExcecaoDoSistema("Erro ao remover funcionário do banco", e);
		}
	}

	@Override
	public List<Funcionario> listaDeFuncionarios() throws ExcecaoDoSistema {

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
			stmt.close();
			rs.close();

			return funcionarios;

		} catch (ClassNotFoundException | SQLException e) {
			throw new ExcecaoDoSistema("Erro ao procurar funcionários", e);
		}
	}

}