package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditarProdutos {

	private JPanel editarProdutosPanel;
	private JTextField textFieldNomeProduto;
	private JTextField textFieldCodigo;
	private JTextField textFieldPrecoVenda;
	private JTextField textFieldQuantidade;
	private JTextField textFieldMarca;
	private JTextField textFieldFornecedor;
	
	public JPanel getPanel() {		
		return this.editarProdutosPanel;
	}

	public TelaEditarProdutos() {
		initialize();
	}


	public void initialize() {
		editarProdutosPanel = new JPanel();
		editarProdutosPanel.setSize(700, 500);
		editarProdutosPanel.setLayout(null);

		JLabel textoTituloTela = new JLabel("Preencha os campos abaixo corretamente *");
		textoTituloTela.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textoTituloTela.setBounds(10, 35, 268, 14);
		editarProdutosPanel.add(textoTituloTela);

		JLabel NomedoProduto = new JLabel("Nome do Produto *");
		NomedoProduto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NomedoProduto.setBounds(34, 73, 118, 14);
		editarProdutosPanel.add(NomedoProduto);

		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setBounds(34, 98, 217, 35);
		editarProdutosPanel.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);

		JLabel Codigo = new JLabel("Código *");
		Codigo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Codigo.setBounds(312, 73, 70, 14);
		editarProdutosPanel.add(Codigo);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(312, 98, 131, 35);
		editarProdutosPanel.add(textFieldCodigo);

		textFieldPrecoVenda = new JTextField();
		textFieldPrecoVenda.setColumns(10);
		textFieldPrecoVenda.setBounds(501, 98, 131, 35);
		editarProdutosPanel.add(textFieldPrecoVenda);

		JLabel PrecoDeVenda = new JLabel("Preço de Venda *");
		PrecoDeVenda.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoDeVenda.setBounds(501, 73, 110, 14);
		editarProdutosPanel.add(PrecoDeVenda);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 398, 684, 63);
		editarProdutosPanel.add(panel);
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

		JButton btnEditar = new JButton("Salvar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Estoque");
				Janela.getInstace().getFrame().setBounds(0, 0, 1020, 680);
				Janela.getInstace().getFrame().setLocationRelativeTo(null);
			}
		});
		btnEditar.setBounds(539, 11, 99, 41);
		panel.add(btnEditar);

		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(34, 182, 131, 35);
		editarProdutosPanel.add(textFieldQuantidade);

		JLabel Quantidade = new JLabel("Quantidade *");
		Quantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quantidade.setBounds(34, 157, 118, 14);
		editarProdutosPanel.add(Quantidade);

		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(218, 182, 139, 35);
		editarProdutosPanel.add(textFieldMarca);

		JLabel Marca = new JLabel("Marca *");
		Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marca.setBounds(218, 157, 87, 14);
		editarProdutosPanel.add(Marca);

		JLabel Fornecedor = new JLabel("Fornecedor *");
		Fornecedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Fornecedor.setBounds(415, 157, 81, 14);
		editarProdutosPanel.add(Fornecedor);

		textFieldFornecedor = new JTextField();
		textFieldFornecedor.setColumns(10);
		textFieldFornecedor.setBounds(415, 182, 217, 35);
		editarProdutosPanel.add(textFieldFornecedor);

		JPanel MenuDescricao = new JPanel();
		MenuDescricao.setBackground(new Color(255, 255, 255));
		MenuDescricao.setBounds(34, 241, 598, 140);
		editarProdutosPanel.add(MenuDescricao);
		MenuDescricao.setLayout(null);

		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(0, 0, 598, 36);
		MenuDescricao.add(panel_3);
		panel_3.setLayout(null);

		JLabel Nome = new JLabel("Nome");
		Nome.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Nome.setBounds(25, 11, 46, 14);
		panel_3.add(Nome);

		JLabel Cod = new JLabel("Cód");
		Cod.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Cod.setBounds(104, 6, 46, 24);
		panel_3.add(Cod);

		JLabel Preco = new JLabel("R$");
		Preco.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Preco.setBounds(172, 9, 46, 18);
		panel_3.add(Preco);

		JLabel Qntd = new JLabel("Qntd");
		Qntd.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Qntd.setBounds(228, 9, 57, 18);
		panel_3.add(Qntd);

		JLabel Marc = new JLabel("Marca");
		Marc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marc.setBounds(286, 9, 46, 18);
		panel_3.add(Marc);

		JLabel Forne = new JLabel("Fornecedor");
		Forne.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Forne.setBounds(347, 11, 87, 14);
		panel_3.add(Forne);

		JLabel Descricao = new JLabel("Inserir texto com as informações a serem editadas. //To Do");
		Descricao.setFont(new Font("SansSerif", Font.PLAIN, 14));
		Descricao.setBounds(23, 51, 547, 26);
		MenuDescricao.add(Descricao);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 241, 598, 24);
		editarProdutosPanel.add(panel_2);

		JLabel tituloTela = new JLabel("EDITAR PRODUTO");
		tituloTela.setFont(new Font("SansSerif", Font.PLAIN, 20));
		tituloTela.setBounds(10, 11, 295, 24);
		editarProdutosPanel.add(tituloTela);
	}
}