package com.managepro.project.telas;

import java.awt.EventQueue;

public class JanelaPrincipal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeladeEstoque window = new TeladeEstoque();
					window.getFrame().setLocationRelativeTo(null);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}