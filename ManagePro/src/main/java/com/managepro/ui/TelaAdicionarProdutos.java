package com.managepro.ui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Panel;
import java.awt.TextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;

import com.managepro.core.model.Produto;
import com.managepro.core.service.ProdutoService;
import com.managepro.exceptions.ValidacaoException;
import com.toedter.calendar.JDateChooser;

public class TelaAdicionarProdutos{

	private JPanel adicionarProdutoPanel;
	private JTextField textFieldNomeProduto;
	private JTextField textFieldCodigo;
	private JFormattedTextField textFieldPrecoVenda;
	private JTextField textFieldQuantidade;
	private JTextField textFieldMarca;
	private JTextField textFieldFornecedor;
	private JDateChooser dataValidade;

	public JPanel getPanel() {
		return this.adicionarProdutoPanel;
	}

	public TelaAdicionarProdutos() throws ParseException {
		this.initialize();
	}

	private void initialize() throws ParseException {
		adicionarProdutoPanel = new JPanel();
		adicionarProdutoPanel.setSize(700, 500);
		adicionarProdutoPanel.setLayout(null);

		JLabel subTituloTela = new JLabel("Preencha os campos abaixo corretamente *");
		subTituloTela.setFont(new Font("SansSerif", Font.PLAIN, 12));
		subTituloTela.setBounds(10, 35, 268, 14);
		adicionarProdutoPanel.add(subTituloTela);

		JLabel NomeProduto = new JLabel("Nome do Produto *");
		NomeProduto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NomeProduto.setBounds(34, 73, 118, 14);
		adicionarProdutoPanel.add(NomeProduto);

		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setBounds(34, 98, 217, 35);
		adicionarProdutoPanel.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);

		JLabel Codigo = new JLabel("C�digo *");
		Codigo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Codigo.setBounds(312, 73, 70, 14);
		adicionarProdutoPanel.add(Codigo);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(312, 98, 131, 35);
		adicionarProdutoPanel.add(textFieldCodigo);
		
		textFieldPrecoVenda = new JFormattedTextField();
		textFieldPrecoVenda.setFocusLostBehavior(JFormattedTextField.PERSIST);
		textFieldPrecoVenda.setColumns(10);
		textFieldPrecoVenda.setBounds(501, 98, 131, 35);
		adicionarProdutoPanel.add(textFieldPrecoVenda);

		JLabel PrecoVenda = new JLabel("Pre�o de Venda *");
		PrecoVenda.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoVenda.setBounds(501, 73, 110, 14);
		adicionarProdutoPanel.add(PrecoVenda);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 398, 684, 63);
		adicionarProdutoPanel.add(panel);
		panel.setLayout(null);

		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(34, 182, 87, 35);
		adicionarProdutoPanel.add(textFieldQuantidade);

		JLabel Quantidade = new JLabel("Quantidade *");
		Quantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quantidade.setBounds(34, 157, 118, 14);
		adicionarProdutoPanel.add(Quantidade);

		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(158, 182, 139, 35);
		adicionarProdutoPanel.add(textFieldMarca);

		JLabel Marca = new JLabel("Marca *");
		Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marca.setBounds(162, 157, 87, 14);
		adicionarProdutoPanel.add(Marca);

		JLabel Fornecedor = new JLabel("Fornecedor *");
		Fornecedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Fornecedor.setBounds(331, 157, 81, 14);
		adicionarProdutoPanel.add(Fornecedor);

		textFieldFornecedor = new JTextField();
		textFieldFornecedor.setColumns(10);
		textFieldFornecedor.setBounds(331, 182, 131, 35);
		adicionarProdutoPanel.add(textFieldFornecedor);

		JLabel TituloTela = new JLabel("CADASTRAR PRODUTO");
		TituloTela.setFont(new Font("SansSerif", Font.PLAIN, 20));
		TituloTela.setBounds(10, 11, 295, 24);
		adicionarProdutoPanel.add(TituloTela);
		
		dataValidade = new JDateChooser();
		dataValidade.setBounds(490, 182, 160, 35);
		adicionarProdutoPanel.add(dataValidade);
		
		JLabel Validade = new JLabel("Data de Validade *");
		Validade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Validade.setBounds(511, 158, 121, 14);
		adicionarProdutoPanel.add(Validade);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Estoque");
				Janela.getInstance().getFrame().setBounds(0, 0, 1020, 680);
				Janela.getInstance().getFrame().setLocationRelativeTo(null);
			}
		});
		btnCancelar.setBounds(45, 11, 99, 41);
		panel.add(btnCancelar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeProduto = textFieldNomeProduto.getText();
				BigDecimal preco = new BigDecimal(textFieldPrecoVenda.getText());
				int quantidade = Integer.parseInt(textFieldQuantidade.getText());
				String marca = textFieldMarca.getText();
				String fornecedor = textFieldFornecedor.getText();				
				Instant dataInstant = dataValidade.getDate().toInstant();
				LocalDate validade = dataInstant.atZone(ZoneId.systemDefault()).toLocalDate();
				Produto produto = new Produto (nomeProduto, preco, quantidade, marca, fornecedor, validade);
				ProdutoService produtoService = new ProdutoService();
				try {
					produtoService.adicionarProduto(produto);
					Janela.getInstance().getTelaEstoque().atualizarEstoque();
				} catch (ValidacaoException e1) {
					e1.printStackTrace();
				}
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Estoque");
				Janela.getInstance().getFrame().setBounds(0, 0, 1020, 680);
				Janela.getInstance().getFrame().setLocationRelativeTo(null);
			}
		});
		btnCadastrar.setBounds(539, 11, 99, 41);
		panel.add(btnCadastrar);
		
		
	}
}