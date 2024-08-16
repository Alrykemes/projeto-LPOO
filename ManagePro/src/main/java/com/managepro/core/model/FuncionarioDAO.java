package com.managepro.core.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/lpoo-2023.2", "root", "12345");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found.", e);
        }
    }

    public boolean hasFuncionario(String cpf) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM funcionario WHERE cpf = ?");
            stmt.setString(1, cpf);
            ResultSet result = stmt.executeQuery();
            return result.next();
        } catch (SQLException e) {
            throw new RuntimeException("Error trying to access database.", e);
        }
    }

    public void addFuncionario(Funcionario funcionario) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO funcionario (nome, cpf, email, cargo, salario) VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getCargo());
            stmt.setDouble(5, funcionario.getSalario());  // Corrigido: Não há necessidade de usar doubleValue()
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error trying to access database.", e);
        }
    }

    public Funcionario searchFuncionarioByCpf(String cpf) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM funcionario WHERE cpf = ?");
            stmt.setString(1, cpf);
            ResultSet result = stmt.executeQuery();

            Funcionario funcionario = null;
            if (result.next()) {
                funcionario = new Funcionario();  // Certifique-se de que a classe Funcionario tem um construtor padrão
                funcionario.setNome(result.getString("nome"));
                funcionario.setCpf(result.getString("cpf"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setSalario(BigDecimal.valueOf(result.getDouble("salario")));
            }
            return funcionario;
        } catch (SQLException e) {
            throw new RuntimeException("Error trying to access database.", e);
        }
    }

    public void removeFuncionario(String cpf) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM funcionario WHERE cpf = ?");
            stmt.setString(1, cpf);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error trying to access database.", e);
        }
    }

    public boolean inserirFuncionario(Funcionario funcionario) {
        try {
            addFuncionario(funcionario);
            System.out.println("Funcionario inserido no banco de dados: " + funcionario.getNome());
            return true; // Retorna true se a inserção foi bem-sucedida
        } catch (Exception e) {
            System.out.println("Erro ao inserir funcionario: " + e.getMessage());
            return false; // Retorna false se houver algum erro
        }
    }
}
