package com.managepro.ui;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaMenu {

	private JPanel panelMenu;
	private JPanel panel;
	

	public JPanel getPanel() {
		return this.panelMenu;
	}

	public TelaMenu() {
		this.initialize();
	}
	
	public void initialize() {
		panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 0, 1024, 680);
		panelMenu.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(81, 81, 81));
		panel.setBounds(0, 0, 1024, 83);
		panelMenu.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 336, 81);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\ManagePRO-removebg-preview 2.png"));
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getTelaLogin().getUserLoginField().setText("");
				Janela.getInstace().getTelaLogin().getUserPasswordField().setText("");
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Login");
			}
		});
		btnNewButton.setBounds(889, 27, 89, 27);
		panel.add(btnNewButton);
		
		JButton estoqueBotao = new JButton("Estoque       ");
		estoqueBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/EstoqueIcon.png")));
		estoqueBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		estoqueBotao.setBorder(new LineBorder(Color.GRAY, 2));
		estoqueBotao.setBounds(381, 125, 249, 60);
		estoqueBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Estoque");
			}
		});
		panelMenu.add(estoqueBotao);
		
		JButton novaVendaBotao = new JButton("Nova Venda   ");
		novaVendaBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/NovaVendaIcon.png")));
		novaVendaBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		novaVendaBotao.setBorder(new LineBorder(Color.GRAY, 2));
		novaVendaBotao.setBounds(381, 211, 249, 60);
		novaVendaBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "NovaVenda");
			}
		});
		panelMenu.add(novaVendaBotao);
		
		JButton vendasBt = new JButton("Vendas        ");
		vendasBt.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/VendasIcon.png")));
		vendasBt.setFont(new Font("SansSerif", Font.PLAIN, 18));
		vendasBt.setBorder(new LineBorder(Color.GRAY, 2));
		vendasBt.setBounds(381, 302, 249, 60);
		vendasBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "GerenciamentoDeVendas");
			}
		});
		panelMenu.add(vendasBt);
		
		JButton funcionariosBt = new JButton("Funcionários ");
		funcionariosBt.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/FuncionariosIcon.png")));
		funcionariosBt.setFont(new Font("SansSerif", Font.PLAIN, 18));
		funcionariosBt.setBorder(new LineBorder(Color.GRAY, 2));
		funcionariosBt.setBounds(381, 400, 249, 60);
		funcionariosBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Funcionarios");
			}
		});
		panelMenu.add(funcionariosBt);
		
		JButton contabilidadeBt = new JButton("Contabilidade");
		contabilidadeBt.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/ContabilidadeIcon.png")));
		contabilidadeBt.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contabilidadeBt.setBorder(new LineBorder(Color.GRAY, 2));
		contabilidadeBt.setBounds(381, 492, 249, 60);
		contabilidadeBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Contabilidade");
			}
		});
		panelMenu.add(contabilidadeBt);
	}
}