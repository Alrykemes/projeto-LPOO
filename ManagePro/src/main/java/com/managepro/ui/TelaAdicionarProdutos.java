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

public class TelaAdicionarProdutos{

	private JPanel contentPane;
	private JTextField textFieldNomeProduto;
	private JTextField textFieldCodigo;
	private JTextField textFieldPrecoVenda;
	private JTextField textFieldQuanditade;
	private JTextField textFieldMarca;
	private JTextField textFieldFornecedor;
	private JFrame FrmManagePro;

	public JFrame getFrame() {
		return this.FrmManagePro;
	}

	public TelaAdicionarProdutos() {
		this.initialize();
	}

	private void initialize() {
		FrmManagePro = new JFrame();
		FrmManagePro.setTitle("ManagePro");
		FrmManagePro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		FrmManagePro.setBounds(100, 100, 700, 500);
		FrmManagePro.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		FrmManagePro.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel subTituloTela = new JLabel("Preencha os campos abaixo corretamente *");
		subTituloTela.setFont(new Font("SansSerif", Font.PLAIN, 12));
		subTituloTela.setBounds(10, 35, 268, 14);
		contentPane.add(subTituloTela);

		JLabel NomeProduto = new JLabel("Nome do Produto *");
		NomeProduto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NomeProduto.setBounds(34, 73, 118, 14);
		contentPane.add(NomeProduto);

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

		JLabel PrecoVenda = new JLabel("Preço de Venda *");
		PrecoVenda.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoVenda.setBounds(501, 73, 110, 14);
		contentPane.add(PrecoVenda);

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

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().setVisible(false);
			}
		});
		btnCadastrar.setBounds(539, 11, 99, 41);
		panel.add(btnCadastrar);

		textFieldQuanditade = new JTextField();
		textFieldQuanditade.setColumns(10);
		textFieldQuanditade.setBounds(34, 182, 131, 35);
		contentPane.add(textFieldQuanditade);

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

		JPanel MostrarDescricao = new JPanel();
		MostrarDescricao.setBackground(new Color(255, 255, 255));
		MostrarDescricao.setBounds(34, 241, 598, 140);
		contentPane.add(MostrarDescricao);
		MostrarDescricao.setLayout(null);

		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(0, 0, 598, 36);
		MostrarDescricao.add(panel_3);
		panel_3.setLayout(null);

		JLabel Nome2 = new JLabel("Nome");
		Nome2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Nome2.setBounds(25, 11, 46, 14);
		panel_3.add(Nome2);

		JLabel Codigo2 = new JLabel("Cód");
		Codigo2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Codigo2.setBounds(104, 6, 46, 24);
		panel_3.add(Codigo2);

		JLabel PrecoVenda2 = new JLabel("R$");
		PrecoVenda2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoVenda2.setBounds(172, 9, 46, 18);
		panel_3.add(PrecoVenda2);

		JLabel Quantidade2 = new JLabel("Qntd");
		Quantidade2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quantidade2.setBounds(228, 9, 57, 18);
		panel_3.add(Quantidade2);

		JLabel Marca2 = new JLabel("Marca");
		Marca2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marca2.setBounds(286, 9, 46, 18);
		panel_3.add(Marca2);

		JLabel Fornecedor2 = new JLabel("Fornecedor");
		Fornecedor2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Fornecedor2.setBounds(347, 11, 87, 14);
		panel_3.add(Fornecedor2);

		JLabel Descricao = new JLabel("Inserir texto com as informações do produto que está sendo cadastrado //To Do");
		Descricao.setFont(new Font("SansSerif", Font.PLAIN, 14));
		Descricao.setBounds(23, 51, 547, 26);
		MostrarDescricao.add(Descricao);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 241, 598, 24);
		contentPane.add(panel_2);

		JLabel TituloTela = new JLabel("CADASTRAR PRODUTO");
		TituloTela.setFont(new Font("SansSerif", Font.PLAIN, 20));
		TituloTela.setBounds(10, 11, 295, 24);
		contentPane.add(TituloTela);
	}
}