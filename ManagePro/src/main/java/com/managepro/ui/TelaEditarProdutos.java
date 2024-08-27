package com.managepro.ui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.managepro.core.model.Produto;
import com.managepro.core.service.ProdutoService;
import com.managepro.exceptions.ValidacaoException;
import com.toedter.calendar.JDateChooser;

import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;

public class TelaEditarProdutos {


	private JPanel editarProdutosPanel;
	private JTextField textFieldNomeProduto;
	private JTextField textFieldCodigo;
	private JTextField textFieldPrecoVenda;
	private JTextField textFieldQuantidade;
	private JTextField textFieldMarca;
	private JTextField textFieldFornecedor;
	private JDateChooser dataValidade;
	@SuppressWarnings("unused")
	private Produto produtoSelecionado;
	private Long codigoProduto;
	
	public TelaEditarProdutos() throws ParseException {
		this.initialize();
	}
	
	public void setProdutoSelecionado (Produto produto) {
		this.produtoSelecionado = produto;
	}
	
	public JPanel getPanel() {		
		return this.editarProdutosPanel;
	}
	
	public void setNomeProdutoField (String nome) {
		this.textFieldNomeProduto.setText(nome);
	}

	public void setPrecoVendaField (String preco) {
		this.textFieldPrecoVenda.setText(preco);
	}
	
	public void setQuantidadeField (String quantidade) {
		this.textFieldQuantidade.setText(quantidade);
	}
	
	public void setMarcaField (String marca) {
		this.textFieldMarca.setText(marca);
	}
	
	public void setFornecedorField (String fornecedor) {
		this.textFieldFornecedor.setText(fornecedor);
	}
	
	public void setValidadeField (LocalDate validade) {
		this.dataValidade.setDate(Date.valueOf(validade));
	}
	
	public void setCodigoProduto (Long codigoProduto) {
		this.codigoProduto = codigoProduto;
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

		JLabel Codigo = new JLabel("C�digo *");
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


		JLabel PrecoDeVenda = new JLabel("Pre�o de Venda *");
		PrecoDeVenda.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoDeVenda.setBounds(501, 73, 110, 14);
		editarProdutosPanel.add(PrecoDeVenda);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 398, 684, 63);
		editarProdutosPanel.add(panel);
		panel.setLayout(null);

		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(34, 182, 87, 35);
		editarProdutosPanel.add(textFieldQuantidade);

		JLabel Quantidade = new JLabel("Quantidade *");
		Quantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quantidade.setBounds(34, 157, 118, 14);
		editarProdutosPanel.add(Quantidade);

		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(158, 182, 139, 35);
		editarProdutosPanel.add(textFieldMarca);

		JLabel Marca = new JLabel("Marca *");
		Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marca.setBounds(162, 157, 87, 14);
		editarProdutosPanel.add(Marca);

		JLabel Fornecedor = new JLabel("Fornecedor *");
		Fornecedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Fornecedor.setBounds(331, 157, 81, 14);
		editarProdutosPanel.add(Fornecedor);

		textFieldFornecedor = new JTextField();
		textFieldFornecedor.setColumns(10);
		textFieldFornecedor.setBounds(331, 182, 131, 35);
		editarProdutosPanel.add(textFieldFornecedor);

		JLabel tituloTela = new JLabel("EDITAR PRODUTO");
		tituloTela.setFont(new Font("SansSerif", Font.PLAIN, 20));
		tituloTela.setBounds(10, 11, 295, 24);
		editarProdutosPanel.add(tituloTela);
		
		dataValidade = new JDateChooser();
		dataValidade.setBounds(490, 182, 160, 35);
		editarProdutosPanel.add(dataValidade);
		
		JLabel Validade = new JLabel("Data de Validade *");
		Validade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Validade.setBounds(511, 158, 121, 14);
		editarProdutosPanel.add(Validade);
		
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

		JButton btnEditar = new JButton("Salvar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeProduto = textFieldNomeProduto.getText();
				BigDecimal preco = new BigDecimal(textFieldPrecoVenda.getText().replaceAll(",", "."));
				int quantidade = Integer.parseInt(textFieldQuantidade.getText());
				String marca = textFieldMarca.getText();
				String fornecedor = textFieldFornecedor.getText();				
				Instant dataInstant = dataValidade.getDate().toInstant();
				LocalDate validade = dataInstant.atZone(ZoneId.systemDefault()).toLocalDate();
				Produto produto = new Produto (codigoProduto, nomeProduto, quantidade, marca, fornecedor, preco, validade);
				ProdutoService produtoService = new ProdutoService();
				Janela.getInstance().getTelaEstoque().refresh();
				try {
					produtoService.atualizarProduto(produto);
					Janela.getInstance().getTelaEstoque().atualizarEstoque();
				} catch (ValidacaoException e1) {
					e1.printStackTrace();
				}
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Estoque");
				Janela.getInstance().getFrame().setBounds(0, 0, 1020, 680);
				Janela.getInstance().getFrame().setLocationRelativeTo(null);
			}
		});
		btnEditar.setBounds(539, 11, 99, 41);
		panel.add(btnEditar);
	}
}