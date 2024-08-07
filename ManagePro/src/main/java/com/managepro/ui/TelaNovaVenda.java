package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaNovaVenda {

	private JPanel novaVendaPanel;
	private JTextField codField;
	private JTextField qtdField;
	private JTextField descontoField;
	private JTextField txtDigiteOCpf;
	private JTextField ValueInsertField;
	private JLabel txtValueInsert;
	private JLabel txtTroco;
	private JLabel lblTroco;
	
	public JPanel getPanel() {
		return this.novaVendaPanel;
	}

	public TelaNovaVenda() {
		initialize();
	}

	private void initialize() {
		novaVendaPanel = new JPanel();
		novaVendaPanel.setSize(1020, 680);
		novaVendaPanel.setLayout(null);
		
		JPanel PrincipalPanel = new JPanel();
		PrincipalPanel.setBounds(10, 11, 984, 619);
		novaVendaPanel.add(PrincipalPanel);
		PrincipalPanel.setLayout(null);
		
		JPanel addProductPanel = new JPanel();
		addProductPanel.setBounds(699, 0, 285, 400);
		PrincipalPanel.add(addProductPanel);
		addProductPanel.setLayout(null);
		
		JLabel lblTextCod = new JLabel("Informe o código do produto: ");
		lblTextCod.setBounds(10, 11, 274, 24);
		lblTextCod.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProductPanel.add(lblTextCod);
		
		codField = new JTextField();
		codField.setBounds(10, 34, 264, 26);
		codField.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProductPanel.add(codField);
		codField.setColumns(10);
		
		qtdField = new JTextField();
		qtdField.setBounds(10, 94, 264, 26);
		qtdField.setFont(new Font("SansSerif", Font.PLAIN, 16));
		qtdField.setColumns(10);
		addProductPanel.add(qtdField);
		
		JLabel lblTextQtd = new JLabel("Informe a quantidade desejada:");
		lblTextQtd.setBounds(10, 71, 274, 24);
		lblTextQtd.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProductPanel.add(lblTextQtd);
		
		JLabel txtUnitPrice = new JLabel("Preço Unitário: \r\n");
		txtUnitPrice.setBounds(10, 208, 119, 24);
		txtUnitPrice.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProductPanel.add(txtUnitPrice);
		
		JLabel txtTotalPrice = new JLabel("Preço Total: ");
		txtTotalPrice.setBounds(10, 239, 97, 24);
		txtTotalPrice.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProductPanel.add(txtTotalPrice);
		
		JLabel lblUnitPrice = new JLabel("R$ 16,99");
		lblUnitPrice.setBounds(118, 208, 156, 24);
		lblUnitPrice.setFont(new Font("SansSerif", Font.BOLD, 16));
		addProductPanel.add(lblUnitPrice);
		
		JLabel lblTotalPrice = new JLabel("R$ 148,89");
		lblTotalPrice.setBounds(97, 239, 178, 24);
		lblTotalPrice.setFont(new Font("SansSerif", Font.BOLD, 16));
		addProductPanel.add(lblTotalPrice);
		
		JLabel txtTotalSale = new JLabel("Total Compra:");
		txtTotalSale.setFont(new Font("SansSerif", Font.BOLD, 18));
		txtTotalSale.setBounds(84, 292, 132, 33);
		addProductPanel.add(txtTotalSale);
		
		JLabel lblNewLabel = new JLabel("R$ 847,60");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setBounds(43, 325, 196, 33);
		addProductPanel.add(lblNewLabel);
		
		JLabel txtDesconto = new JLabel("Informe o código do desconto");
		txtDesconto.setFont(new Font("SansSerif", Font.PLAIN, 16));
		txtDesconto.setBounds(10, 130, 274, 24);
		addProductPanel.add(txtDesconto);
		
		descontoField = new JTextField();
		descontoField.setFont(new Font("SansSerif", Font.PLAIN, 16));
		descontoField.setColumns(10);
		descontoField.setBounds(10, 153, 264, 26);
		addProductPanel.add(descontoField);
		
		JList<?> list = new JList<>();
		list.setBounds(0, 0, 700, 400);
		PrincipalPanel.add(list);
		
		JPanel SaleConfigPanel = new JPanel();
		SaleConfigPanel.setBounds(0, 399, 984, 220);
		PrincipalPanel.add(SaleConfigPanel);
		SaleConfigPanel.setLayout(null);
		
		JLabel txtCpfCliente = new JLabel("CPF do cliente:");
		txtCpfCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCpfCliente.setBounds(10, 11, 150, 30);
		SaleConfigPanel.add(txtCpfCliente);
		
		txtDigiteOCpf = new JTextField();
		txtDigiteOCpf.setForeground(new Color(192, 192, 192));
		txtDigiteOCpf.setText("digite o cpf");
		txtDigiteOCpf.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtDigiteOCpf.setBounds(10, 40, 242, 30);
		txtDigiteOCpf.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				txtDigiteOCpf.setText("");
				txtDigiteOCpf.setForeground(new Color(0, 0, 0));
			}
			public void focusLost(FocusEvent e) {
				txtDigiteOCpf.setText("digite o cpf");
				txtDigiteOCpf.setForeground(new Color(192, 192, 192));
			}
		});
		SaleConfigPanel.add(txtDigiteOCpf);
		txtDigiteOCpf.setColumns(10);
		
		JLabel txtNomeFuncionario = new JLabel("Funcionário:\r\n");
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
		
		txtValueInsert = new JLabel("Valor recebido:\r\n");
		txtValueInsert.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtValueInsert.setBounds(321, 81, 120, 24);
		SaleConfigPanel.add(txtValueInsert);
		
		ValueInsertField = new JTextField();
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
		
		JButton btnCancel = new JButton("Cancelar\r\n");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(btnCancel, "Deseja realmente cancelar a venda?", "Cancelar", JOptionPane.YES_NO_OPTION) == 0) {
					Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Menu");
				}
			}
		});
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnCancel.setBounds(778, 22, 150, 37);
		SaleConfigPanel.add(btnCancel);
		
	}
}
