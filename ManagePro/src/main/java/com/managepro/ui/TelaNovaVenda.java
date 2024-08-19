package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import com.managepro.core.model.Cliente;
import com.managepro.core.model.FormaPagamento;
import com.managepro.core.model.Produto;
import com.managepro.core.model.ProdutoVendaDetails;
import com.managepro.core.model.Venda;
import com.managepro.core.service.ClientService;
import com.managepro.core.service.VendaService;
import com.managepro.dao.ProdutoDAO;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.ImageIcon;

public class TelaNovaVenda {

	//TO DO: ORGANIZAR VARIAVEIS E SEUS NOMES
	
	private JPanel novaVendaPanel;
	private JPanel PrincipalPanel;
	private JPanel addProductPanel;
	private JPanel SaleConfigPanel;
	private JFormattedTextField codField;
	private JFormattedTextField qtdField;
	private JFormattedTextField cpfField;
	private JFormattedTextField ValueInsertField;
	private JLabel txtValueInsert;
	private JLabel txtTroco;
	private JLabel troco;
	private JLabel txtClientCpf;
	private JLabel txtClientName;
	private JLabel txtNomeCliente;
	private static JLabel nomeFuncionario;
	private Cliente cliente;
	private JButton btnPesquisaClient;
	private JList<ProdutoVendaDetails> listProdutos;
	private JLabel unitPrice;
	private JLabel totalPrice;
	private JLabel totalPriceSale;
	private BigDecimal totalPriceOfSale;
	private List<BigDecimal> priceOfProducts;
	private List<ProdutoVendaDetails> listaProdutosVenda;
	private JComboBox<String> PagamentocomboBox;
	
	public JPanel getPanel() {
		return this.novaVendaPanel;
	}
	
	public JLabel getLabelFuncionarioJLabel() {
		return nomeFuncionario;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TelaNovaVenda() throws ParseException {
		initialize();
	}

	private void initialize() throws ParseException {
		totalPriceOfSale = BigDecimal.ZERO;
		priceOfProducts = new ArrayList<>();
		listaProdutosVenda = new ArrayList<>();

		
		novaVendaPanel = new JPanel();
		novaVendaPanel.setSize(1020, 680);
		novaVendaPanel.setLayout(null);
		
		PrincipalPanel = new JPanel();
		PrincipalPanel.setBounds(10, 0, 1020, 680);
		novaVendaPanel.add(PrincipalPanel);
		PrincipalPanel.setLayout(null);
		
		addProductPanel = new JPanel();
		addProductPanel.setBounds(699, 0, 314, 681);
		PrincipalPanel.add(addProductPanel);
		addProductPanel.setLayout(null);
		
		JLabel lblTextCod = new JLabel("Informe o código do produto: ");
		lblTextCod.setBounds(10, 205, 264, 24);
		lblTextCod.setFont(new Font("SansSerif", Font.PLAIN, 18));
		addProductPanel.add(lblTextCod);
		
		MaskFormatter maskCod = new MaskFormatter("#############");
		maskCod.setValidCharacters("0123456789");
		maskCod.setAllowsInvalid(false);
		codField = new JFormattedTextField(maskCod);
		codField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		codField.setBounds(10, 234, 240, 30);
		codField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		addProductPanel.add(codField);
		codField.setColumns(10);
		
		MaskFormatter maskqtd = new MaskFormatter("####");
		maskqtd.setValidCharacters("0123456789");
		maskqtd.setAllowsInvalid(false);
		qtdField = new JFormattedTextField(maskqtd);
		qtdField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		qtdField.setBounds(10, 294, 240, 30);
		qtdField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		qtdField.setColumns(10);
		addProductPanel.add(qtdField);
		
		DefaultListModel<ProdutoVendaDetails> listModel = new DefaultListModel<>();
		
		listProdutos = new JList<>(listModel);
		listProdutos.setFont(new Font("SansSerif", Font.PLAIN, 26));
		JScrollPane scrollPane = new JScrollPane(listProdutos);
		scrollPane.setBounds(0, 11, 689, 389);
		PrincipalPanel.add(scrollPane, BorderLayout.CENTER);
		
		JButton btnAddProducts = new JButton("");
		btnAddProducts.setIcon(new ImageIcon(TelaNovaVenda.class.getResource("/com/managepro/assets/NovoProdutoIcon.png")));
		btnAddProducts.setBounds(260, 234, 30, 30);
		addProductPanel.add(btnAddProducts);
		btnAddProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				ProdutoVendaDetails produtoVendaDetails = new ProdutoVendaDetails();
				
				Long IDnovoProduto = Long.valueOf(codField.getText().replaceAll(" ", ""));
				Produto produto = produtoDAO.findProductById(IDnovoProduto);
				
					if(produto == null) {
						JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Produto não encontrado na base de dados!");
					} else {
						
						produtoVendaDetails.setCodigoProduto(produto.getCodigoProduto());
						produtoVendaDetails.setNomeProduto(produto.getNomeProduto());
						
						int qtdProdutos = Integer.valueOf(qtdField.getText().replaceAll(" ", ""));
						
						if(qtdProdutos != 0) {
							produtoVendaDetails.setQuantidade(qtdProdutos);
							BigDecimal precoProdutos = produto.getPreco().multiply(BigDecimal.valueOf(Long.valueOf(qtdProdutos)));
							produtoVendaDetails.setPreco(precoProdutos);
							
							unitPrice.setText(String.format("R$ %.2f", produto.getPreco()));
							totalPrice.setText(String.format("R$ %.2f", precoProdutos));
							
							priceOfProducts.add(precoProdutos);
							
							totalPriceOfSale = priceOfProducts
					                .stream()				            
					                .reduce(BigDecimal.ZERO, BigDecimal::add);
							
							listModel.addElement(produtoVendaDetails);
							listaProdutosVenda.add(produtoVendaDetails);
		
						} else {
							JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Insira a quantidade de produtos desejada");
						}
						totalPriceSale.setText(String.format("R$ %.2f", totalPriceOfSale));
					}
				}
		});
		
		JLabel lblTextQtd = new JLabel("Informe a quantidade desejada:");
		lblTextQtd.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextQtd.setBounds(10, 265, 264, 24);
		lblTextQtd.setFont(new Font("SansSerif", Font.PLAIN, 18));
		addProductPanel.add(lblTextQtd);
		
		JLabel txtUnitPrice = new JLabel("Pre\u00E7o Unit\u00E1rio: \r\n");
		txtUnitPrice.setBounds(10, 335, 156, 24);
		txtUnitPrice.setFont(new Font("SansSerif", Font.PLAIN, 18));
		addProductPanel.add(txtUnitPrice);
		
		JLabel txtTotalPrice = new JLabel("Preço Total: ");
		txtTotalPrice.setBounds(10, 392, 118, 24);
		txtTotalPrice.setFont(new Font("SansSerif", Font.PLAIN, 18));
		addProductPanel.add(txtTotalPrice);
		
		unitPrice = new JLabel("R$ 0,00");
		unitPrice.setBounds(10, 357, 156, 24);
		unitPrice.setFont(new Font("SansSerif", Font.BOLD, 18));
		addProductPanel.add(unitPrice);
		
		totalPrice = new JLabel("R$ 0,00");
		totalPrice.setBounds(10, 414, 173, 24);
		totalPrice.setFont(new Font("SansSerif", Font.BOLD, 18));
		addProductPanel.add(totalPrice);
		
		JLabel txtTotalSale = new JLabel("Total Compra:");
		txtTotalSale.setFont(new Font("SansSerif", Font.BOLD, 18));
		txtTotalSale.setBounds(93, 456, 132, 33);
		addProductPanel.add(txtTotalSale);
		
		totalPriceSale = new JLabel("R$ 0,00");
		totalPriceSale.setHorizontalAlignment(SwingConstants.CENTER);
		totalPriceSale.setFont(new Font("SansSerif", Font.BOLD, 24));
		totalPriceSale.setBounds(52, 489, 196, 33);
		addProductPanel.add(totalPriceSale);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// implementar adicao no bd apos confirmacao de venda pela lib do mercado pago
				VendaService vendaService = new VendaService();
				Venda newVenda = new Venda();
				newVenda.setFuncionario(Janela.getInstance().getTelaLogin().getFuncionarioLogado());
				newVenda.setCliente(cliente);
				newVenda.setData(LocalDate.now());
				newVenda.setProdutosVendidos(listaProdutosVenda);
				newVenda.setFormaDePagamentoEnum(FormaPagamento.valueOf(PagamentocomboBox.getSelectedItem().toString().replaceAll(" ",   "")));
				newVenda.setPreco(totalPriceOfSale);
				
				vendaService.cadastrarVenda(newVenda);
				
				cliente = null;
				SaleConfigPanel.add(cpfField);
				SaleConfigPanel.remove(txtClientName);
				SaleConfigPanel.remove(txtClientCpf);
				SaleConfigPanel.add(btnPesquisaClient);
				listModel.clear();
				priceOfProducts.clear();
				listaProdutosVenda.clear();
				unitPrice.setText("R$ 0,00");
				totalPrice.setText("R$ 0,00");
				totalPriceSale.setText("R$ 0,00");
				SaleConfigPanel.repaint();
			}
		});
		btnFinalizar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnFinalizar.setBackground(new Color(50, 205, 50));
		btnFinalizar.setBounds(79, 533, 150, 37);
		addProductPanel.add(btnFinalizar);
		
		Canvas linha1 = new Canvas();
		linha1.setBackground(new Color(0, 0, 0));
		linha1.setBounds(0, 444, 314, 4);
		addProductPanel.add(linha1);
		
		Canvas linha2 = new Canvas();
		linha2.setBounds(0, -11, 4, 682);
		addProductPanel.add(linha2);
		linha2.setBackground(Color.BLACK);
		
		SaleConfigPanel = new JPanel();
		SaleConfigPanel.setBounds(0, 399, 700, 259);
		PrincipalPanel.add(SaleConfigPanel);
		SaleConfigPanel.setLayout(null);
		
		JLabel txtCpfCliente = new JLabel("CPF do cliente:");
		txtCpfCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCpfCliente.setBounds(10, 11, 150, 30);
		SaleConfigPanel.add(txtCpfCliente);

		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setValidCharacters("0123456789");
		maskCpf.setAllowsInvalid(false);
		cpfField = new JFormattedTextField(maskCpf);
		cpfField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		cpfField.setForeground(new Color(192, 192, 192));
		cpfField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		cpfField.setBounds(10, 40, 242, 30);
		cpfField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				cpfField.setText("");
				cpfField.setForeground(new Color(0, 0, 0));
			}
			public void focusLost(FocusEvent e) {
				cpfField.setForeground(new Color(192, 192, 192));
			}
		});
		SaleConfigPanel.add(cpfField);
		cpfField.setColumns(10);
		
		btnPesquisaClient = new JButton("");
		btnPesquisaClient.setIcon(new ImageIcon(TelaNovaVenda.class.getResource("/com/managepro/assets/LupaIcon.png")));
		btnPesquisaClient.setBounds(257, 40, 33, 30);
		btnPesquisaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientService service = new ClientService();
				String cpfCliente = cpfField.getText();
				cliente = service.getClientCpf(cpfCliente);
				
					if(cliente != null) {
						if (cliente.getCpf() == null) {
							
							if(JOptionPane.showConfirmDialog(Janela.getInstance().getPanelPrincipal(), "Deseja Cadastrar um novo Cliente?", "Cadastrar Cliente", JOptionPane.YES_NO_OPTION) == 0) {
								Janela.getInstance().getFrame().setBounds(0, 0, 500, 500);
								Janela.getInstance().getFrame().setLocationRelativeTo(null);
								Janela.getInstance().getTelaAdicionarCliente().setCpfField(cpfCliente);
								Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "AdicionarCliente");
							}	 	
						} else if(cliente.getCpf() != null){
							
							setClienteNaTela();
						}
					}
			}
		});
		SaleConfigPanel.add(btnPesquisaClient);
		
		txtClientCpf = new JLabel();
		txtClientCpf.setBounds(10, 35, 280, 35);
		txtClientCpf.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		txtClientName = new JLabel();
		txtClientName.setBounds(10, 97, 242, 30);
		txtClientName.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		txtNomeCliente = new JLabel("Nome :");
		txtNomeCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtNomeCliente.setBounds(10, 75, 150, 30);
		SaleConfigPanel.add(txtNomeCliente);
		
		JLabel txtNomeFuncionario = new JLabel("Funcionário:\r\n");
		txtNomeFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtNomeFuncionario.setBounds(10, 146, 105, 24);
		SaleConfigPanel.add(txtNomeFuncionario);
		
		nomeFuncionario = new JLabel();
		nomeFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		nomeFuncionario.setBounds(10, 168, 280, 26);
		SaleConfigPanel.add(nomeFuncionario);
		
		PagamentocomboBox = new JComboBox<>();
		PagamentocomboBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
		PagamentocomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"DINHEIRO", "PIX", "CARTAO DE CREDITO", "CARTAO DE DEBITO", "TICKET DE ALIMENTACAO"}));
		PagamentocomboBox.setBounds(321, 45, 282, 30);
		PagamentocomboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("Dinheiro")) {
					SaleConfigPanel.add(txtValueInsert);
					SaleConfigPanel.add(ValueInsertField);
					SaleConfigPanel.add(txtTroco);
					SaleConfigPanel.add(troco);
				}
				if(e.getItem().equals("Pix")) {
					SaleConfigPanel.remove(txtValueInsert);
					SaleConfigPanel.remove(ValueInsertField);
					SaleConfigPanel.remove(txtTroco);
					SaleConfigPanel.remove(troco);
				}
				if(e.getItem().equals("Cartão de Crédito")) {
					SaleConfigPanel.remove(txtValueInsert);
					SaleConfigPanel.remove(ValueInsertField);
					SaleConfigPanel.remove(txtTroco);
					SaleConfigPanel.remove(troco);
				}
				if(e.getItem().equals("Cartão de Crédito")) {
					SaleConfigPanel.remove(txtValueInsert);
					SaleConfigPanel.remove(ValueInsertField);
					SaleConfigPanel.remove(txtTroco);
					SaleConfigPanel.remove(troco);
				}
				if(e.getItem().equals("Ticket Alimentação")) {
					SaleConfigPanel.remove(txtValueInsert);
					SaleConfigPanel.remove(ValueInsertField);
					SaleConfigPanel.remove(txtTroco);
					SaleConfigPanel.remove(troco);
				}
			}
		});
		SaleConfigPanel.add(PagamentocomboBox);
		
		JLabel txtMetodoPagamento = new JLabel("Selecione o método de pagamento:");
		txtMetodoPagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtMetodoPagamento.setBounds(321, 16, 282, 25);
		SaleConfigPanel.add(txtMetodoPagamento);
		
		txtValueInsert = new JLabel("Valor recebido:\r\n");
		txtValueInsert.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtValueInsert.setBounds(321, 81, 120, 24);
		SaleConfigPanel.add(txtValueInsert);
		
		ValueInsertField = new JFormattedTextField();
		ValueInsertField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		ValueInsertField.setBounds(321, 105, 282, 30);
		ValueInsertField.setColumns(10);
		SaleConfigPanel.add(ValueInsertField);
		
		txtTroco = new JLabel("Troco:");
		txtTroco.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtTroco.setBounds(321, 146, 71, 14);
		SaleConfigPanel.add(txtTroco);
		
		troco = new JLabel("R$ 0,00");
		troco.setFont(new Font("SansSerif", Font.PLAIN, 18));
		troco.setBounds(321, 169, 172, 25);
		SaleConfigPanel.add(troco);
		
		JButton btnCancel = new JButton("Cancelar\r\n");
		btnCancel.setBounds(79, 581, 150, 37);
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(btnCancel, "Deseja realmente cancelar a venda?", "Cancelar", JOptionPane.YES_NO_OPTION) == 0) {
					cliente = null;
					SaleConfigPanel.add(cpfField);
					SaleConfigPanel.remove(txtClientName);
					SaleConfigPanel.remove(txtClientCpf);
					SaleConfigPanel.add(btnPesquisaClient);
					listModel.clear();
					priceOfProducts.clear();
					listaProdutosVenda.clear();
					unitPrice.setText("R$ 0,00");
					totalPrice.setText("R$ 0,00");
					totalPriceSale.setText("R$ 0,00");
					
					
					Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Menu");
				}
			}
		});
		addProductPanel.add(btnCancel);
		
		
	}
	
	public void setClienteNaTela() {
		SaleConfigPanel.remove(cpfField);
		SaleConfigPanel.add(txtClientName);
		SaleConfigPanel.add(txtClientCpf);
		txtClientName.setText(cliente.getNome());
		txtClientCpf.setText(cliente.getCpf());	
		SaleConfigPanel.remove(btnPesquisaClient);
		SaleConfigPanel.repaint();
	}
}
