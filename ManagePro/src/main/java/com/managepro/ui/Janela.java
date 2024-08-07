package com.managepro.ui;

import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela {

	private static Janela instance;
	private JFrame frame;
	private JPanel panelPrincipal;
	private CardLayout cardLayout;
	private TelaLogin telaLogin;
	private TelaMenu telaMenu;
	private TelaEstoque telaEstoque;
	private TelaAdicionarProdutos telaAdicionarProdutos;
	private TelaEditarProdutos telaEditarProdutos;
	private TelaNovaVenda telaNovaVenda;
	private TelaGerenciamentoDeVendas telaGerenciamentoDeVendas;
	private TelaFuncionarios telaFuncionarios;
	private TelaContabilidade telaContabilidade;
	
	
	public static Janela getInstace() {
		if(instance == null) {
			instance = new Janela();
		}
		return instance;
	}
	
	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
	
	public JPanel getPanelPrincipal() {
		return this.panelPrincipal;
	}
	
	public TelaLogin getTelaLogin() {
		return this.telaLogin;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}

	private Janela() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setName("ManagePro");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMenu.class.getResource("/com/managepro/assets/ManageProIcon.png")));
		frame.setBounds(0, 0, 1020, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		panelPrincipal = new JPanel(new CardLayout());
		frame.add(panelPrincipal);
		
		telaLogin = new TelaLogin();
		telaMenu = new TelaMenu();
		telaEstoque = new TelaEstoque();
		telaAdicionarProdutos = new TelaAdicionarProdutos();
		telaEditarProdutos = new TelaEditarProdutos();
		telaNovaVenda = new TelaNovaVenda();
		telaGerenciamentoDeVendas = new TelaGerenciamentoDeVendas();
		telaFuncionarios = new TelaFuncionarios();
		telaContabilidade = new TelaContabilidade();
		
		panelPrincipal.add(telaContabilidade.getPanel(), "Contabilidade");
		panelPrincipal.add(telaFuncionarios.getPanel(), "Funcionarios");
		panelPrincipal.add(telaGerenciamentoDeVendas.getPanel(), "GerenciamentoDeVendas");
		panelPrincipal.add(telaNovaVenda.getPanel(), "NovaVenda");
		panelPrincipal.add(telaAdicionarProdutos.getPanel(), "AdicionarProdutos");
		panelPrincipal.add(telaEditarProdutos.getPanel(), "EditarProdutos");
		panelPrincipal.add(telaEstoque.getPanel(), "Estoque");
		panelPrincipal.add(telaMenu.getPanel(), "Menu");
		panelPrincipal.add(telaLogin.getPanel(), "Login");
		
		cardLayout = (CardLayout)(panelPrincipal.getLayout());
		cardLayout.show(panelPrincipal, "Login");
		
	}
}
