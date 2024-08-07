package com.managepro.ui;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class TelaMenu {

<<<<<<< HEAD
	private JFrame frmManagePro;
	private JPanel panel;
	
	public JFrame getFrame() {
		return this.frmManagePro;
=======
	private JPanel panelMenu;
	private JPanel panel;
	

	public JPanel getPanel() {
		return this.panelMenu;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
	}

	public TelaMenu() {
		this.initialize();
	}
	
	public void initialize() {
<<<<<<< HEAD
		frmManagePro = new JFrame();
		frmManagePro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMenu.class.getResource("/com/managepro/assets/manageIcon.png")));
		frmManagePro.setResizable(false);
		frmManagePro.setTitle("ManagePro");
		frmManagePro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagePro.setBounds(100, 100, 1024, 680);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
=======
		panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 0, 1024, 680);
		panelMenu.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(81, 81, 81));
		panel.setBounds(0, 0, 1024, 83);
		panelMenu.add(panel);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		panel.setLayout(null);
		frmManagePro.setContentPane(panel);
		
<<<<<<< HEAD
		JPanel cabecalho = new JPanel();
		cabecalho.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cabecalho.setBackground(new Color(80, 80, 80));
		cabecalho.setBounds(0, 0, 1004, 83);
		cabecalho.setLayout(null);
		panel.add(cabecalho);
=======
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 336, 81);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\ManagePRO-removebg-preview 2.png"));
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		Botao sairBotao = new Botao("Sair");
		sairBotao.setForeground(new Color(255, 255, 255));
		sairBotao.setFont(new Font("SansSerif", Font.BOLD, 18));
		sairBotao.setBackground(new Color(255, 0, 0));
		
		sairBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getTelaLogin().getUserLoginField().setText("");
				Janela.getInstace().getTelaLogin().getUserPasswordField().setText("");
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Login");
			}
		});
		
		sairBotao.setBounds(890, 25, 90, 30);
		cabecalho.add(sairBotao);
		
		Botao estoqueBotao = new Botao("Estoque       ");
		estoqueBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/EstoqueIcon.png")));
		estoqueBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		estoqueBotao.setBorder(new LineBorder(Color.GRAY, 2));
		estoqueBotao.setBounds(381, 125, 249, 60);
		
		estoqueBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Estoque");
			}
		});
<<<<<<< HEAD
		panel.add(estoqueBotao);
=======
		panelMenu.add(estoqueBotao);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		Botao novaVendaBotao = new Botao("Nova Venda   ");
		novaVendaBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/NovaVendaIcon.png")));
		novaVendaBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		novaVendaBotao.setBorder(new LineBorder(Color.GRAY, 2));
		novaVendaBotao.setBounds(381, 211, 249, 60);
		
		novaVendaBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "NovaVenda");
			}
		});
<<<<<<< HEAD
		panel.add(novaVendaBotao);
=======
		panelMenu.add(novaVendaBotao);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		Botao vendasBotao = new Botao("Vendas        ");
		vendasBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/VendasIcon.png")));
		vendasBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		vendasBotao.setBorder(new LineBorder(Color.GRAY, 2));
		vendasBotao.setBounds(381, 302, 249, 60);
		
		vendasBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "GerenciamentoDeVendas");
			}
		});
<<<<<<< HEAD
		panel.add(vendasBotao);
=======
		panelMenu.add(vendasBt);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		Botao funcionariosBotao = new Botao("Funcionários ");
		funcionariosBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/FuncionariosIcon.png")));
		funcionariosBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		funcionariosBotao.setBorder(new LineBorder(Color.GRAY, 2));
		funcionariosBotao.setBounds(381, 400, 249, 60);
		funcionariosBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Funcionarios");
			}
		});
<<<<<<< HEAD
		panel.add(funcionariosBotao);
=======
		panelMenu.add(funcionariosBt);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		Botao contabilidadeBotao = new Botao("Contabilidade");
		contabilidadeBotao.setIcon(new ImageIcon(TelaMenu.class.getResource("/com/managepro/assets/ContabilidadeIcon.png")));
		contabilidadeBotao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contabilidadeBotao.setBorder(new LineBorder(Color.GRAY, 2));
		contabilidadeBotao.setBounds(381, 492, 249, 60);
		
		contabilidadeBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Contabilidade");
			}
		});
<<<<<<< HEAD
		panel.add(contabilidadeBotao);
=======
		panelMenu.add(contabilidadeBt);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
	}
}