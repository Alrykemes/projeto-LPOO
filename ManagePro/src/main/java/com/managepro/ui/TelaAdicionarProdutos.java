package com.managepro.ui;

import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.border.EmptyBorder;
=======
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaAdicionarProdutos{

<<<<<<< HEAD
	private JPanel panel;
	private JTextField campoNomeProduto;
	private JTextField campoCodigo;
	private JTextField campoPrecoVenda;
	private JTextField campoQuantitade;
	private JTextField campoMarcaProduto;
	private JTextField campoFornecedor;
	private JFrame FrmManagePro;
=======
	private JPanel adicionarProdutoPanel;
	private JTextField textFieldNomeProduto;
	private JTextField textFieldCodigo;
	private JTextField textFieldPrecoVenda;
	private JTextField textFieldQuanditade;
	private JTextField textFieldMarca;
	private JTextField textFieldFornecedor;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712

	public JPanel getPanel() {
		return this.adicionarProdutoPanel;
	}

	public TelaAdicionarProdutos() {
		this.initialize();
	}

	private void initialize() {
<<<<<<< HEAD
		FrmManagePro = new JFrame();
		FrmManagePro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAdicionarProdutos.class.getResource("/com/managepro/assets/manageIcon.png")));
		FrmManagePro.setTitle("ManagePro");
		FrmManagePro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		FrmManagePro.setBounds(100, 100, 700, 500);
		FrmManagePro.setResizable(false);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		FrmManagePro.setContentPane(panel);
		
		JLabel TituloTela = new JLabel("CADASTRAR PRODUTO");
		TituloTela.setFont(new Font("SansSerif", Font.PLAIN, 20));
		TituloTela.setBounds(10, 11, 295, 24);
		panel.add(TituloTela);
=======
		adicionarProdutoPanel = new JPanel();
		adicionarProdutoPanel.setSize(700, 500);
		adicionarProdutoPanel.setLayout(null);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712

		JLabel subTituloTela = new JLabel("Preencha os campos abaixo corretamente *");
		subTituloTela.setFont(new Font("SansSerif", Font.PLAIN, 12));
		subTituloTela.setBounds(10, 35, 268, 14);
<<<<<<< HEAD
		panel.add(subTituloTela);

		JLabel labelNomeProduto = new JLabel("Nome do Produto *");
		labelNomeProduto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		labelNomeProduto.setBounds(34, 73, 118, 14);
		panel.add(labelNomeProduto);

		campoNomeProduto = new JTextField();
		campoNomeProduto.setBounds(34, 98, 217, 35);
		panel.add(campoNomeProduto);
		campoNomeProduto.setColumns(10);

		JLabel labelCodigo = new JLabel("Código *");
		labelCodigo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		labelCodigo.setBounds(312, 73, 70, 14);
		panel.add(labelCodigo);

		campoCodigo = new JTextField();
		campoCodigo.setColumns(10);
		campoCodigo.setBounds(312, 98, 131, 35);
		panel.add(campoCodigo);

		JLabel labelPrecoVenda = new JLabel("Preço de Venda *");
		labelPrecoVenda.setFont(new Font("SansSerif", Font.PLAIN, 12));
		labelPrecoVenda.setBounds(501, 73, 110, 14);
		panel.add(labelPrecoVenda);
		
		campoPrecoVenda = new JTextField();
		campoPrecoVenda.setColumns(10);
		campoPrecoVenda.setBounds(501, 98, 131, 35);
		panel.add(campoPrecoVenda);
		
		JLabel labelQuantidade = new JLabel("Quantidade *");
		labelQuantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		labelQuantidade.setBounds(34, 157, 118, 14);
		panel.add(labelQuantidade);
		
		campoQuantitade = new JTextField();
		campoQuantitade.setColumns(10);
		campoQuantitade.setBounds(34, 182, 131, 35);
		panel.add(campoQuantitade);

		JLabel labelMarcaProduto = new JLabel("Marca *");
		labelMarcaProduto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		labelMarcaProduto.setBounds(218, 157, 87, 14);
		panel.add(labelMarcaProduto);

		campoMarcaProduto = new JTextField();
		campoMarcaProduto.setColumns(10);
		campoMarcaProduto.setBounds(218, 182, 139, 35);
		panel.add(campoMarcaProduto);
		
		JLabel labelFornecedor = new JLabel("Fornecedor *");
		labelFornecedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		labelFornecedor.setBounds(415, 157, 81, 14);
		panel.add(labelFornecedor);

		campoFornecedor = new JTextField();
		campoFornecedor.setColumns(10);
		campoFornecedor.setBounds(415, 182, 217, 35);
		panel.add(campoFornecedor);

		JPanel PanelMostrarDescricao = new JPanel();
		PanelMostrarDescricao.setBackground(new Color(255, 255, 255));
		PanelMostrarDescricao.setBounds(34, 241, 598, 140);
		panel.add(PanelMostrarDescricao);
		PanelMostrarDescricao.setLayout(null);

		Panel colunasMostrarDescricao = new Panel();
		colunasMostrarDescricao.setBackground(new Color(128, 128, 128));
		colunasMostrarDescricao.setBounds(0, 0, 598, 36);
		PanelMostrarDescricao.add(colunasMostrarDescricao);
		colunasMostrarDescricao.setLayout(null);
=======
		adicionarProdutoPanel.add(subTituloTela);

		JLabel NomeProduto = new JLabel("Nome do Produto *");
		NomeProduto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NomeProduto.setBounds(34, 73, 118, 14);
		adicionarProdutoPanel.add(NomeProduto);

		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setBounds(34, 98, 217, 35);
		adicionarProdutoPanel.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);

		JLabel Codigo = new JLabel("Código *");
		Codigo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Codigo.setBounds(312, 73, 70, 14);
		adicionarProdutoPanel.add(Codigo);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(312, 98, 131, 35);
		adicionarProdutoPanel.add(textFieldCodigo);

		textFieldPrecoVenda = new JTextField();
		textFieldPrecoVenda.setColumns(10);
		textFieldPrecoVenda.setBounds(501, 98, 131, 35);
		adicionarProdutoPanel.add(textFieldPrecoVenda);

		JLabel PrecoVenda = new JLabel("Preço de Venda *");
		PrecoVenda.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoVenda.setBounds(501, 73, 110, 14);
		adicionarProdutoPanel.add(PrecoVenda);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 398, 684, 63);
		adicionarProdutoPanel.add(panel);
		panel.setLayout(null);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Estoque");
				Janela.getInstace().getFrame().setBounds(0, 0, 1020, 680);
				Janela.getInstace().getFrame().setLocationRelativeTo(null);
			}
		});
		btnCancelar.setBounds(45, 11, 99, 41);
		panel.add(btnCancelar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Estoque");
				Janela.getInstace().getFrame().setBounds(0, 0, 1020, 680);
				Janela.getInstace().getFrame().setLocationRelativeTo(null);
			}
		});
		btnCadastrar.setBounds(539, 11, 99, 41);
		panel.add(btnCadastrar);

		textFieldQuanditade = new JTextField();
		textFieldQuanditade.setColumns(10);
		textFieldQuanditade.setBounds(34, 182, 131, 35);
		adicionarProdutoPanel.add(textFieldQuanditade);

		JLabel Quantidade = new JLabel("Quantidade *");
		Quantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quantidade.setBounds(34, 157, 118, 14);
		adicionarProdutoPanel.add(Quantidade);

		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(218, 182, 139, 35);
		adicionarProdutoPanel.add(textFieldMarca);

		JLabel Marca = new JLabel("Marca *");
		Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marca.setBounds(218, 157, 87, 14);
		adicionarProdutoPanel.add(Marca);

		JLabel Fornecedor = new JLabel("Fornecedor *");
		Fornecedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Fornecedor.setBounds(415, 157, 81, 14);
		adicionarProdutoPanel.add(Fornecedor);

		textFieldFornecedor = new JTextField();
		textFieldFornecedor.setColumns(10);
		textFieldFornecedor.setBounds(415, 182, 217, 35);
		adicionarProdutoPanel.add(textFieldFornecedor);

		JPanel MostrarDescricao = new JPanel();
		MostrarDescricao.setBackground(new Color(255, 255, 255));
		MostrarDescricao.setBounds(34, 241, 598, 140);
		adicionarProdutoPanel.add(MostrarDescricao);
		MostrarDescricao.setLayout(null);

		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(0, 0, 598, 36);
		MostrarDescricao.add(panel_3);
		panel_3.setLayout(null);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712

		JLabel Nome2 = new JLabel("Nome");
		Nome2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Nome2.setBounds(25, 11, 46, 14);
		colunasMostrarDescricao.add(Nome2);

		JLabel Codigo2 = new JLabel("Cód");
		Codigo2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Codigo2.setBounds(104, 6, 46, 24);
		colunasMostrarDescricao.add(Codigo2);

		JLabel PrecoVenda2 = new JLabel("R$");
		PrecoVenda2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoVenda2.setBounds(172, 9, 46, 18);
		colunasMostrarDescricao.add(PrecoVenda2);

		JLabel Quantidade2 = new JLabel("Qntd");
		Quantidade2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quantidade2.setBounds(228, 9, 57, 18);
		colunasMostrarDescricao.add(Quantidade2);

		JLabel Marca2 = new JLabel("Marca");
		Marca2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marca2.setBounds(286, 9, 46, 18);
		colunasMostrarDescricao.add(Marca2);

		JLabel Fornecedor2 = new JLabel("Fornecedor");
		Fornecedor2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Fornecedor2.setBounds(347, 11, 87, 14);
		colunasMostrarDescricao.add(Fornecedor2);

		JLabel Descricao = new JLabel("Inserir texto com as informações do produto que está sendo cadastrado //To Do");
		Descricao.setFont(new Font("SansSerif", Font.PLAIN, 14));
		Descricao.setBounds(23, 51, 547, 26);
		PanelMostrarDescricao.add(Descricao);
		
		Panel panelInferior = new Panel();
		panelInferior.setBackground(new Color(255, 255, 255));
		panelInferior.setBounds(0, 398, 684, 63);
		panel.add(panelInferior);
		panelInferior.setLayout(null);

<<<<<<< HEAD
		Botao botaoCancelar = new Botao("Cancelar");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().setVisible(false);
			}
		});
		botaoCancelar.setBounds(45, 11, 99, 41);
		panelInferior.add(botaoCancelar);

		Botao botaoCadastrar = new Botao("Cadastrar");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().setVisible(false);
			}
		});
		botaoCadastrar.setBounds(539, 11, 99, 41);
		panelInferior.add(botaoCadastrar);
=======
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 241, 598, 24);
		adicionarProdutoPanel.add(panel_2);

		JLabel TituloTela = new JLabel("CADASTRAR PRODUTO");
		TituloTela.setFont(new Font("SansSerif", Font.PLAIN, 20));
		TituloTela.setBounds(10, 11, 295, 24);
		adicionarProdutoPanel.add(TituloTela);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
	}
}