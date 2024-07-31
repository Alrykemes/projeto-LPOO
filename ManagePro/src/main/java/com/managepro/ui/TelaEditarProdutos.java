package com.managepro.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditarProdutos {

	private JFrame FrmManagePro;
	public JFrame getFrame() {		
		return this.FrmManagePro;
	}

	public TelaEditarProdutos() {
		initialize();
	}

	private JPanel contentPane;
	private JTextField textFieldNomeProduto;
	private JTextField textFieldCodigo;
	private JTextField textFieldPrecoVenda;
	private JTextField textFieldQuantidade;
	private JTextField textFieldMarca;
	private JTextField textFieldFornecedor;

	public void initialize() {
		FrmManagePro = new JFrame();
		FrmManagePro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		FrmManagePro.setBounds(100, 100, 700, 500);
		FrmManagePro.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		FrmManagePro.setTitle("ManagePro");

		FrmManagePro.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel textoTituloTela = new JLabel("Preencha os campos abaixo corretamente *");
		textoTituloTela.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textoTituloTela.setBounds(10, 35, 268, 14);
		contentPane.add(textoTituloTela);

		JLabel NomedoProduto = new JLabel("Nome do Produto *");
		NomedoProduto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NomedoProduto.setBounds(34, 73, 118, 14);
		contentPane.add(NomedoProduto);

		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setBounds(34, 98, 217, 35);
		contentPane.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);

		JLabel Codigo = new JLabel("Código *");
		Codigo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Codigo.setBounds(312, 73, 70, 14);
		contentPane.add(Codigo);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(312, 98, 131, 35);
		contentPane.add(textFieldCodigo);

		textFieldPrecoVenda = new JTextField();
		textFieldPrecoVenda.setColumns(10);
		textFieldPrecoVenda.setBounds(501, 98, 131, 35);
		contentPane.add(textFieldPrecoVenda);

		JLabel PrecoDeVenda = new JLabel("Preço de Venda *");
		PrecoDeVenda.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoDeVenda.setBounds(501, 73, 110, 14);
		contentPane.add(PrecoDeVenda);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 398, 684, 63);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().setVisible(false);
			}
		});
		btnCancelar.setBounds(45, 11, 99, 41);
		panel.add(btnCancelar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().setVisible(false);
			}
		});
		btnEditar.setBounds(539, 11, 99, 41);
		panel.add(btnEditar);

		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(34, 182, 131, 35);
		contentPane.add(textFieldQuantidade);

		JLabel Quantidade = new JLabel("Quantidade *");
		Quantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quantidade.setBounds(34, 157, 118, 14);
		contentPane.add(Quantidade);

		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(218, 182, 139, 35);
		contentPane.add(textFieldMarca);

		JLabel Marca = new JLabel("Marca *");
		Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marca.setBounds(218, 157, 87, 14);
		contentPane.add(Marca);

		JLabel Fornecedor = new JLabel("Fornecedor *");
		Fornecedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Fornecedor.setBounds(415, 157, 81, 14);
		contentPane.add(Fornecedor);

		textFieldFornecedor = new JTextField();
		textFieldFornecedor.setColumns(10);
		textFieldFornecedor.setBounds(415, 182, 217, 35);
		contentPane.add(textFieldFornecedor);

		JPanel MenuDescricao = new JPanel();
		MenuDescricao.setBackground(new Color(255, 255, 255));
		MenuDescricao.setBounds(34, 241, 598, 140);
		contentPane.add(MenuDescricao);
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
		contentPane.add(panel_2);

		JLabel tituloTela = new JLabel("EDITAR PRODUTO");
		tituloTela.setFont(new Font("SansSerif", Font.PLAIN, 20));
		tituloTela.setBounds(10, 11, 295, 24);
		contentPane.add(tituloTela);
	}
}