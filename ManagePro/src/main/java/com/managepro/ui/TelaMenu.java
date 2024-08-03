package com.managepro.ui;


import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class TelaMenu {

	private JFrame frmManagePro;
	private JPanel contentPane;
	
	public JFrame getFrame() {
		return this.frmManagePro;
	}

	public TelaMenu() {
		this.initialize();
	}
	
	public void initialize() {
		frmManagePro = new JFrame();
		frmManagePro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMenu.class.getResource("/com/managepro/assets/manageIcon.png")));
		frmManagePro.setResizable(false);
		frmManagePro.setTitle("ManagePro");
		frmManagePro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagePro.setBounds(100, 100, 1024, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmManagePro.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(80, 80, 80));
		panel.setBounds(0, 0, 1004, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Botao sairBotao = new Botao("Sair");
		sairBotao.setForeground(new Color(255, 255, 255));
		sairBotao.setFont(new Font("SansSerif", Font.BOLD, 18));
		sairBotao.setBackground(new Color(255, 0, 0));
		
		sairBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telaInicial = new TelaLogin();
				getFrame().setVisible(false);
				telaInicial.getFrame().setLocationRelativeTo(null);
				telaInicial.getFrame().setVisible(true);
			}
		});
		
		sairBotao.setBounds(890, 25, 90, 30);
		panel.add(sairBotao);
		
		Botao estoqueBotao = new Botao("Estoque       ");
		estoqueBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/EstoqueIcon.png")));
		estoqueBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		estoqueBotao.setBorder(new LineBorder(Color.GRAY, 2));
		estoqueBotao.setBounds(381, 125, 249, 60);
		
		estoqueBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque();
				getFrame().setVisible(false);
				telaEstoque.getFrame().setLocationRelativeTo(null);
				telaEstoque.getFrame().setVisible(true);
			}
		});
		contentPane.add(estoqueBotao);
		
		Botao novaVendaBotao = new Botao("Nova Venda   ");
		novaVendaBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/NovaVendaIcon.png")));
		novaVendaBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		novaVendaBotao.setBorder(new LineBorder(Color.GRAY, 2));
		novaVendaBotao.setBounds(381, 211, 249, 60);
		
		novaVendaBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNovaVenda telaNovaVenda = new TelaNovaVenda();
				getFrame().setVisible(false);
				telaNovaVenda.getFrame().setLocationRelativeTo(null);
				telaNovaVenda.getFrame().setVisible(true);
			}
		});
		contentPane.add(novaVendaBotao);
		
		Botao vendasBotao = new Botao("Vendas        ");
		vendasBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/VendasIcon.png")));
		vendasBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		vendasBotao.setBorder(new LineBorder(Color.GRAY, 2));
		vendasBotao.setBounds(381, 302, 249, 60);
		
		vendasBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerenciamentoDeVendas telaVendas = new TelaGerenciamentoDeVendas();
				getFrame().setVisible(false);
				telaVendas.getFrame().setLocationRelativeTo(null);
				telaVendas.getFrame().setVisible(true);
			}
		});
		contentPane.add(vendasBotao);
		
		Botao funcionariosBotao = new Botao("Funcionários ");
		funcionariosBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/FuncionariosIcon.png")));
		funcionariosBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		funcionariosBotao.setBorder(new LineBorder(Color.GRAY, 2));
		funcionariosBotao.setBounds(381, 400, 249, 60);
		funcionariosBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
				getFrame().setVisible(false);
				telaFuncionarios.getFrame().setLocationRelativeTo(null);
				telaFuncionarios.getFrame().setVisible(true);
			}
		});
		contentPane.add(funcionariosBotao);
		
		Botao contabilidadeBotao = new Botao("Contabilidade");
		contabilidadeBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/ContabilidadeIcon.png")));
		contabilidadeBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contabilidadeBotao.setBorder(new LineBorder(Color.GRAY, 2));
		contabilidadeBotao.setBounds(381, 492, 249, 60);
		
		contabilidadeBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaContabilidade telaContabilidade = new TelaContabilidade();
				getFrame().setVisible(false);
				telaContabilidade.getFrame().setLocationRelativeTo(null);
				telaContabilidade.getFrame().setVisible(true);
			}
		});
		contentPane.add(contabilidadeBotao);
	}
}