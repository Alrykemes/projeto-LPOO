package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import com.managepro.core.model.Cliente;
import com.managepro.core.service.ClientService;
import com.managepro.core.service.VendaService;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.ImageIcon;

public class TelaNovaVenda {

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
	private JLabel lblTroco;
	private JLabel txtClientCpf;
	private JLabel txtClientName;
	private JLabel txtNomeCliente;
	private Cliente cliente;
	
	public JPanel getPanel() {
		return this.novaVendaPanel;
	}

	public TelaNovaVenda() throws ParseException {
		initialize();
	}

	private void initialize() throws ParseException {
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
		codField.setBounds(10, 228, 281, 26);
		codField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		addProductPanel.add(codField);
		codField.setColumns(10);
		
		MaskFormatter maskqtd = new MaskFormatter("####");
		maskqtd.setValidCharacters("0123456789");
		maskqtd.setAllowsInvalid(false);
		qtdField = new JFormattedTextField(maskqtd);
		qtdField.setBounds(10, 288, 281, 26);
		qtdField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		qtdField.setColumns(10);
		addProductPanel.add(qtdField);
		
		JLabel lblTextQtd = new JLabel("Informe a quantidade desejada:");
		lblTextQtd.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextQtd.setBounds(10, 265, 264, 24);
		lblTextQtd.setFont(new Font("SansSerif", Font.PLAIN, 18));
		addProductPanel.add(lblTextQtd);
		
		JLabel txtUnitPrice = new JLabel("Preço unitário: ");
		txtUnitPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnitPrice.setBounds(69, 325, 156, 24);
		txtUnitPrice.setFont(new Font("SansSerif", Font.PLAIN, 18));
		addProductPanel.add(txtUnitPrice);
		
		JLabel txtTotalPrice = new JLabel("Preço Total: ");
		txtTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPrice.setBounds(94, 375, 118, 24);
		txtTotalPrice.setFont(new Font("SansSerif", Font.PLAIN, 18));
		addProductPanel.add(txtTotalPrice);
		
		JLabel lblUnitPrice = new JLabel("R$ 16,99");
		lblUnitPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnitPrice.setBounds(69, 352, 156, 24);
		lblUnitPrice.setFont(new Font("SansSerif", Font.BOLD, 18));
		addProductPanel.add(lblUnitPrice);
		
		JLabel lblTotalPrice = new JLabel("R$ 148,89");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setBounds(69, 398, 173, 24);
		lblTotalPrice.setFont(new Font("SansSerif", Font.BOLD, 18));
		addProductPanel.add(lblTotalPrice);
		
		JLabel txtTotalSale = new JLabel("Total Compra:");
		txtTotalSale.setFont(new Font("SansSerif", Font.BOLD, 18));
		txtTotalSale.setBounds(93, 456, 132, 33);
		addProductPanel.add(txtTotalSale);
		
		JLabel lblNewLabel = new JLabel("R$ 847,60");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setBounds(52, 489, 196, 33);
		addProductPanel.add(lblNewLabel);
		
		JButton btnFinalizar = new JButton("Finalizar");
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
		
		JList<?> list = new JList<>();
		list.setBounds(0, 11, 689, 389);
		PrincipalPanel.add(list);
		
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
		cpfField.setForeground(new Color(0, 0, 0));
		cpfField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		cpfField.setBounds(10, 40, 242, 30);
		SaleConfigPanel.add(cpfField);
		cpfField.setColumns(10);
		
		JButton btnPesquisaClient = new JButton("");
		btnPesquisaClient.setIcon(new ImageIcon(TelaNovaVenda.class.getResource("/com/managepro/assets/LupaIcon.png")));
		btnPesquisaClient.setBounds(257, 40, 33, 30);
		btnPesquisaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientService client = new ClientService();
				String cpfCliente = cpfField.getText();
				System.out.println(cpfCliente);
				cliente = client.ClientExist(cpfCliente);
					if(cliente != null) {
						if (cliente.getCpf() == null) {
							
							if(JOptionPane.showConfirmDialog(Janela.getInstace().getPanelPrincipal(), "Deseja Cadastrar um novo Cliente?", "Cadastrar Cliente", JOptionPane.YES_NO_OPTION) == 0) {
								Janela.getInstace().getFrame().setBounds(0, 0, 500, 500);
								Janela.getInstace().getFrame().setLocationRelativeTo(null);
								TelaAdicionarCliente telaAdicionarCliente = Janela.getInstace().getTelaAdicionarCliente();
							    telaAdicionarCliente.setCpfField(cpfCliente);
								Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "AdicionarCliente");
							}	 
						} else if(cliente.getCpf() != null){
							SaleConfigPanel.remove(cpfField);
							SaleConfigPanel.add(txtClientName);
							SaleConfigPanel.add(txtClientCpf);
							txtClientName.setText(cliente.getNome());
							txtClientCpf.setText(cliente.getCpf());	
							SaleConfigPanel.remove(btnPesquisaClient);
							SaleConfigPanel.repaint();						
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
		
		JLabel txtNomeFuncionario = new JLabel("Funcionário: ");
		txtNomeFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtNomeFuncionario.setBounds(10, 146, 105, 24);
		SaleConfigPanel.add(txtNomeFuncionario);
		
		JLabel lblNomeFuncionario = new JLabel("Alrykemes Peso PLENO");
		lblNomeFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNomeFuncionario.setBounds(10, 168, 242, 26);
		SaleConfigPanel.add(lblNomeFuncionario);
		
		JComboBox<String> PagamentocomboBox = new JComboBox<>();
		PagamentocomboBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
		PagamentocomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Dinheiro", "Pix", "Cartão de Crédito", "Cartão de Débito", "Ticket Alimentação"}));
		PagamentocomboBox.setBounds(321, 40, 282, 30);
		PagamentocomboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("Dinheiro")) {
					SaleConfigPanel.add(txtValueInsert);
					SaleConfigPanel.add(ValueInsertField);
					SaleConfigPanel.add(txtTroco);
					SaleConfigPanel.add(lblTroco);
				}
				if(e.getItem().equals("Pix")) {
					SaleConfigPanel.remove(txtValueInsert);
					SaleConfigPanel.remove(ValueInsertField);
					SaleConfigPanel.remove(txtTroco);
					SaleConfigPanel.remove(lblTroco);
				}
				if(e.getItem().equals("Cartão de Crédito")) {
					SaleConfigPanel.remove(txtValueInsert);
					SaleConfigPanel.remove(ValueInsertField);
					SaleConfigPanel.remove(txtTroco);
					SaleConfigPanel.remove(lblTroco);
				}
				if(e.getItem().equals("Cartão de Débito")) {
					SaleConfigPanel.remove(txtValueInsert);
					SaleConfigPanel.remove(ValueInsertField);
					SaleConfigPanel.remove(txtTroco);
					SaleConfigPanel.remove(lblTroco);
				}
				if(e.getItem().equals("Ticket Alimentação")) {
					SaleConfigPanel.remove(txtValueInsert);
					SaleConfigPanel.remove(ValueInsertField);
					SaleConfigPanel.remove(txtTroco);
					SaleConfigPanel.remove(lblTroco);
				}
			}
		});
		SaleConfigPanel.add(PagamentocomboBox);
		
		JLabel txtMetodoPagamento = new JLabel("Selecione o método de pagamento:");
		txtMetodoPagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtMetodoPagamento.setBounds(321, 22, 282, 14);
		SaleConfigPanel.add(txtMetodoPagamento);
		
		txtValueInsert = new JLabel("Valor recebido: ");
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
		
		lblTroco = new JLabel("R$ 2,60");
		lblTroco.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTroco.setBounds(321, 169, 172, 25);
		SaleConfigPanel.add(lblTroco);
		
		JButton btnCancel = new JButton("Cancelar");
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
					
					Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Menu");
				}
			}
		});
		addProductPanel.add(btnCancel);
		
	}
}
