package com.managepro.ui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import com.managepro.repository.MySQLConnection;

public class Main {
	public static void main(String[] args) {
		try {
            Connection conn = MySQLConnection.getConnection();
            if (conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
                conn.close();
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela.getInstace().getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
