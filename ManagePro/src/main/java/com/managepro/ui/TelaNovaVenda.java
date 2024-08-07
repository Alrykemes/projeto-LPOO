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
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaNovaVenda {

<<<<<<< HEAD
	private JFrame frmManagePro;
	private JTextField campoCodigo;
	private JTextField campoQuantidade;
	private JTextField campoDesconto;
	private JTextField campoCPF;
	private JTextField campoValorRecebido;
	private JLabel labelValorRebido;
	private JLabel labelValorTroco;
	private JLabel valorTroco;
=======
	private JPanel novaVendaPanel;
	private JTextField codField;
	private JTextField qtdField;
	private JTextField descontoField;
	private JTextField txtDigiteOCpf;
	private JTextField ValueInsertField;
	private JLabel txtValueInsert;
	private JLabel txtTroco;
	private JLabel lblTroco;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
	
	public JPanel getPanel() {
		return this.novaVendaPanel;
	}

	public TelaNovaVenda() {
		initialize();
	}

	private void initialize() {
<<<<<<< HEAD
		frmManagePro = new JFrame();
		frmManagePro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaNovaVenda.class.getResource("/com/managepro/assets/manageIcon.png")));
		frmManagePro.setResizable(false);
		frmManagePro.setTitle("ManagePro");
		frmManagePro.setBounds(100, 100, 1024, 680);
		frmManagePro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagePro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 984, 619);
		panel.setLayout(null);
		frmManagePro.getContentPane().add(panel);
=======
		novaVendaPanel = new JPanel();
		novaVendaPanel.setSize(1020, 680);
		novaVendaPanel.setLayout(null);
		
		JPanel PrincipalPanel = new JPanel();
		PrincipalPanel.setBounds(10, 11, 984, 619);
		novaVendaPanel.add(PrincipalPanel);
		PrincipalPanel.setLayout(null);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		JPanel addProdutoPanel = new JPanel();
		addProdutoPanel.setBounds(699, 0, 285, 400);
		panel.add(addProdutoPanel);
		addProdutoPanel.setLayout(null);
		
		JLabel labelCodigo = new JLabel("Informe o código do produto: ");
		labelCodigo.setBounds(10, 11, 274, 24);
		labelCodigo.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProdutoPanel.add(labelCodigo);
		
		campoCodigo = new JTextField();
		campoCodigo.setBounds(10, 34, 264, 26);
		campoCodigo.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProdutoPanel.add(campoCodigo);
		campoCodigo.setColumns(10);
		
		JLabel labelQuantidade = new JLabel("Informe a quantidade desejada:");
		labelQuantidade.setBounds(10, 71, 274, 24);
		labelQuantidade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProdutoPanel.add(labelQuantidade);
		
		campoQuantidade = new JTextField();
		campoQuantidade.setBounds(10, 94, 264, 26);
		campoQuantidade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		campoQuantidade.setColumns(10);
		addProdutoPanel.add(campoQuantidade);
		
		JLabel labelDesconto = new JLabel("Informe o código do desconto");
		labelDesconto.setFont(new Font("SansSerif", Font.PLAIN, 16));
		labelDesconto.setBounds(10, 130, 274, 24);
		addProdutoPanel.add(labelDesconto);
		
		campoDesconto = new JTextField();
		campoDesconto.setFont(new Font("SansSerif", Font.PLAIN, 16));
		campoDesconto.setColumns(10);
		campoDesconto.setBounds(10, 153, 264, 26);
		addProdutoPanel.add(campoDesconto);
		
		JLabel labelPrecoUnitario = new JLabel("Preço Unitário: \r\n");
		labelPrecoUnitario.setBounds(10, 208, 119, 24);
		labelPrecoUnitario.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProdutoPanel.add(labelPrecoUnitario);
		
		JLabel precoUnitario = new JLabel("R$ 16,99");
		precoUnitario.setBounds(118, 208, 156, 24);
		precoUnitario.setFont(new Font("SansSerif", Font.BOLD, 16));
		addProdutoPanel.add(precoUnitario);
		
		JLabel labelPrecoTotal = new JLabel("Total Compra:");
		labelPrecoTotal.setFont(new Font("SansSerif", Font.BOLD, 18));
		labelPrecoTotal.setBounds(84, 292, 132, 33);
		addProdutoPanel.add(labelPrecoTotal);
		
		JLabel precoTotal = new JLabel("R$ 847,60");
		precoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		precoTotal.setFont(new Font("SansSerif", Font.BOLD, 24));
		precoTotal.setBounds(43, 325, 196, 33);
		addProdutoPanel.add(precoTotal);
		
		JList<?> list = new JList<>();
		list.setBounds(0, 0, 700, 400);
		panel.add(list);
		
		JPanel configuracaoVendaPanel = new JPanel();
		configuracaoVendaPanel.setBounds(0, 399, 984, 220);
		panel.add(configuracaoVendaPanel);
		configuracaoVendaPanel.setLayout(null);
		
		JLabel labelCPFCliente = new JLabel("CPF do cliente:");
		labelCPFCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelCPFCliente.setBounds(10, 11, 150, 30);
		configuracaoVendaPanel.add(labelCPFCliente);
		
		campoCPF = new JTextField();
		campoCPF.setForeground(new Color(192, 192, 192));
		campoCPF.setText("digite o cpf");
		campoCPF.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoCPF.setBounds(10, 40, 242, 30);
		campoCPF.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				campoCPF.setText("");
				campoCPF.setForeground(new Color(0, 0, 0));
			}
			public void focusLost(FocusEvent e) {
				campoCPF.setText("digite o cpf");
				campoCPF.setForeground(new Color(192, 192, 192));
			}
		});
		configuracaoVendaPanel.add(campoCPF);
		campoCPF.setColumns(10);
		
		JLabel labelNomeFuncionario = new JLabel("Funcionário:\r\n");
		labelNomeFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelNomeFuncionario.setBounds(10, 146, 105, 24);
		configuracaoVendaPanel.add(labelNomeFuncionario);
		
		JLabel NomeFuncionario = new JLabel("Alrykemes Peso PLENO");
		NomeFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		NomeFuncionario.setBounds(10, 168, 242, 26);
		configuracaoVendaPanel.add(NomeFuncionario);
		
		ComboBox<String> listaTipoPagamento = new ComboBox<>();
		listaTipoPagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		listaTipoPagamento.setModel(new DefaultComboBoxModel<String>(new String[] {"Dinheiro", "Pix", "Cartão de Crédito", "Cartão de Débito", "Ticket Alimentação"}));
		listaTipoPagamento.setBounds(321, 40, 282, 30);
		listaTipoPagamento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("Dinheiro")) {
					configuracaoVendaPanel.add(labelValorRebido);
					configuracaoVendaPanel.add(campoValorRecebido);
					configuracaoVendaPanel.add(labelValorTroco);
					configuracaoVendaPanel.add(valorTroco);
				}
				if(e.getItem().equals("Pix")) {
					configuracaoVendaPanel.remove(labelValorRebido);
					configuracaoVendaPanel.remove(campoValorRecebido);
					configuracaoVendaPanel.remove(labelValorTroco);
					configuracaoVendaPanel.remove(valorTroco);
				}
				if(e.getItem().equals("Cartão de Crédito")) {
					configuracaoVendaPanel.remove(labelValorRebido);
					configuracaoVendaPanel.remove(campoValorRecebido);
					configuracaoVendaPanel.remove(labelValorTroco);
					configuracaoVendaPanel.remove(valorTroco);
				}
				if(e.getItem().equals("Cartão de Débito")) {
					configuracaoVendaPanel.remove(labelValorRebido);
					configuracaoVendaPanel.remove(campoValorRecebido);
					configuracaoVendaPanel.remove(labelValorTroco);
					configuracaoVendaPanel.remove(valorTroco);
				}
				if(e.getItem().equals("Ticket Alimentação")) {
					configuracaoVendaPanel.remove(labelValorRebido);
					configuracaoVendaPanel.remove(campoValorRecebido);
					configuracaoVendaPanel.remove(labelValorTroco);
					configuracaoVendaPanel.remove(valorTroco);
				}
			}
		});
		configuracaoVendaPanel.add(listaTipoPagamento);
		
		JLabel labelMetodoPagamento = new JLabel("Selecione o método de pagamento:");
		labelMetodoPagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelMetodoPagamento.setBounds(321, 22, 282, 14);
		configuracaoVendaPanel.add(labelMetodoPagamento);
		
		labelValorRebido = new JLabel("Valor recebido:");
		labelValorRebido.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelValorRebido.setBounds(321, 81, 150, 24);
		configuracaoVendaPanel.add(labelValorRebido);
		
		campoValorRecebido = new JTextField();
		campoValorRecebido.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoValorRecebido.setBounds(321, 105, 282, 30);
		campoValorRecebido.setColumns(10);
		configuracaoVendaPanel.add(campoValorRecebido);
		
		labelValorTroco = new JLabel("Troco:");
		labelValorTroco.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelValorTroco.setBounds(321, 146, 71, 14);
		configuracaoVendaPanel.add(labelValorTroco);
		
		valorTroco = new JLabel("R$ 2,60");
		valorTroco.setFont(new Font("SansSerif", Font.PLAIN, 18));
		valorTroco.setBounds(321, 169, 172, 25);
		configuracaoVendaPanel.add(valorTroco);
		
		Botao botaoCancelar = new Botao("Cancelar\r\n");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				TelaMenu menu = new TelaMenu();
				if(JOptionPane.showConfirmDialog(botaoCancelar, "Deseja realmente cancelar a venda?", "Cancelar", JOptionPane.YES_NO_OPTION) == 0) {
					getFrame().setVisible(false);
					menu.getFrame().setLocationRelativeTo(null);
					menu.getFrame().setVisible(true);
=======
				if(JOptionPane.showConfirmDialog(btnCancel, "Deseja realmente cancelar a venda?", "Cancelar", JOptionPane.YES_NO_OPTION) == 0) {
					Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Menu");
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
				}
			}
		});
		botaoCancelar.setBackground(new Color(255, 0, 0));
		botaoCancelar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		botaoCancelar.setBounds(778, 22, 150, 37);
		configuracaoVendaPanel.add(botaoCancelar);	
	}
}
