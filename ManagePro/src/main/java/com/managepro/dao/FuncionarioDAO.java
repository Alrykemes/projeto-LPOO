package com.managepro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.managepro.core.model.Cargos;
import com.managepro.core.model.Funcionario;
import com.managepro.repository.EmployeeRepository;
import com.managepro.repository.MySQLConnection;
import com.managepro.ui.Janela;

public class FuncionarioDAO implements EmployeeRepository{
	
	private Funcionario funcionario;

	@Override
	public Funcionario findEmployeeByUser(String user) {
		try {
			Connection connection = MySQLConnection.getConnection();
			Statement stmt = connection.createStatement();
			
			String sql = "SELECT f.id_funcionario, f.nome, f.cpf, t.numero, f.cargo, f.salario, f.data_admissao, f.usuario , f.senha "
					+ "FROM funcionario AS f INNER JOIN telefone_funcionario AS t ON f.id_funcionario = t.id_funcionario "
					+ "WHERE usuario = '" + user + "';";
			 
			 
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
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
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunicação do sistema tente novamente mais tarde");
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
	}

	public Funcionario findEmployeeById(Long id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			Statement stmt = connection.createStatement();
			
			String sql = "SELECT f.id_funcionario, f.nome, f.cpf, t.numero, f.cargo, f.salario, f.data_admissao, f.usuario , f.senha "
					+ "FROM funcionario AS f INNER JOIN telefone_funcionario AS t ON f.id_funcionario = t.id_funcionario "
					+ "WHERE id_funcionario = '" + id + "';";
			 
			 
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
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
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunicação do sistema tente novamente mais tarde");
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
	}
}
