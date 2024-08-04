package com.managepro.ui;

import javax.swing.JFrame;
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
import java.awt.Toolkit;

public class TelaNovaVenda {

	private JFrame frmManagePro;
	private JTextField campoCodigo;
	private JTextField campoQuantidade;
	private JTextField campoDesconto;
	private JTextField campoCPF;
	private JTextField campoValorRecebido;
	private JLabel tituloValorRebido;
	private JLabel trocoTitulo;
	private JLabel valorTroco;
	
	public JFrame getFrame() {
		return this.frmManagePro;
	}

	public TelaNovaVenda() {
		initialize();
	}

	private void initialize() {
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
		
		JPanel addProdutoPanel = new JPanel();
		addProdutoPanel.setBounds(699, 0, 285, 400);
		panel.add(addProdutoPanel);
		addProdutoPanel.setLayout(null);
		
		JLabel tituloCodigo = new JLabel("Informe o código do produto: ");
		tituloCodigo.setBounds(10, 11, 274, 24);
		tituloCodigo.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProdutoPanel.add(tituloCodigo);
		
		campoCodigo = new JTextField();
		campoCodigo.setBounds(10, 34, 264, 26);
		campoCodigo.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProdutoPanel.add(campoCodigo);
		campoCodigo.setColumns(10);
		
		JLabel tituloQuantidade = new JLabel("Informe a quantidade desejada:");
		tituloQuantidade.setBounds(10, 71, 274, 24);
		tituloQuantidade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProdutoPanel.add(tituloQuantidade);
		
		campoQuantidade = new JTextField();
		campoQuantidade.setBounds(10, 94, 264, 26);
		campoQuantidade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		campoQuantidade.setColumns(10);
		addProdutoPanel.add(campoQuantidade);
		
		JLabel tituloDesconto = new JLabel("Informe o código do desconto");
		tituloDesconto.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tituloDesconto.setBounds(10, 130, 274, 24);
		addProdutoPanel.add(tituloDesconto);
		
		campoDesconto = new JTextField();
		campoDesconto.setFont(new Font("SansSerif", Font.PLAIN, 16));
		campoDesconto.setColumns(10);
		campoDesconto.setBounds(10, 153, 264, 26);
		addProdutoPanel.add(campoDesconto);
		
		JLabel tituloPrecoUnitario = new JLabel("Preço Unitário: \r\n");
		tituloPrecoUnitario.setBounds(10, 208, 119, 24);
		tituloPrecoUnitario.setFont(new Font("SansSerif", Font.PLAIN, 16));
		addProdutoPanel.add(tituloPrecoUnitario);
		
		JLabel precoUnitario = new JLabel("R$ 16,99");
		precoUnitario.setBounds(118, 208, 156, 24);
		precoUnitario.setFont(new Font("SansSerif", Font.BOLD, 16));
		addProdutoPanel.add(precoUnitario);
		
		JLabel tituloPrecoTotal = new JLabel("Total Compra:");
		tituloPrecoTotal.setFont(new Font("SansSerif", Font.BOLD, 18));
		tituloPrecoTotal.setBounds(84, 292, 132, 33);
		addProdutoPanel.add(tituloPrecoTotal);
		
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
		
		JLabel tituloCPFCliente = new JLabel("CPF do cliente:");
		tituloCPFCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		tituloCPFCliente.setBounds(10, 11, 150, 30);
		configuracaoVendaPanel.add(tituloCPFCliente);
		
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
		
		JLabel tituloNomeFuncionario = new JLabel("Funcionário:\r\n");
		tituloNomeFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		tituloNomeFuncionario.setBounds(10, 146, 105, 24);
		configuracaoVendaPanel.add(tituloNomeFuncionario);
		
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
					configuracaoVendaPanel.add(tituloValorRebido);
					configuracaoVendaPanel.add(campoValorRecebido);
					configuracaoVendaPanel.add(trocoTitulo);
					configuracaoVendaPanel.add(valorTroco);
				}
				if(e.getItem().equals("Pix")) {
					configuracaoVendaPanel.remove(tituloValorRebido);
					configuracaoVendaPanel.remove(campoValorRecebido);
					configuracaoVendaPanel.remove(trocoTitulo);
					configuracaoVendaPanel.remove(valorTroco);
				}
				if(e.getItem().equals("Cartão de Crédito")) {
					configuracaoVendaPanel.remove(tituloValorRebido);
					configuracaoVendaPanel.remove(campoValorRecebido);
					configuracaoVendaPanel.remove(trocoTitulo);
					configuracaoVendaPanel.remove(valorTroco);
				}
				if(e.getItem().equals("Cartão de Débito")) {
					configuracaoVendaPanel.remove(tituloValorRebido);
					configuracaoVendaPanel.remove(campoValorRecebido);
					configuracaoVendaPanel.remove(trocoTitulo);
					configuracaoVendaPanel.remove(valorTroco);
				}
				if(e.getItem().equals("Ticket Alimentação")) {
					configuracaoVendaPanel.remove(tituloValorRebido);
					configuracaoVendaPanel.remove(campoValorRecebido);
					configuracaoVendaPanel.remove(trocoTitulo);
					configuracaoVendaPanel.remove(valorTroco);
				}
			}
		});
		configuracaoVendaPanel.add(listaTipoPagamento);
		
		JLabel tituloMetodoPagamento = new JLabel("Selecione o método de pagamento:");
		tituloMetodoPagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		tituloMetodoPagamento.setBounds(321, 22, 282, 14);
		configuracaoVendaPanel.add(tituloMetodoPagamento);
		
		tituloValorRebido = new JLabel("Valor recebido:");
		tituloValorRebido.setFont(new Font("SansSerif", Font.PLAIN, 18));
		tituloValorRebido.setBounds(321, 81, 150, 24);
		configuracaoVendaPanel.add(tituloValorRebido);
		
		campoValorRecebido = new JTextField();
		campoValorRecebido.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoValorRecebido.setBounds(321, 105, 282, 30);
		campoValorRecebido.setColumns(10);
		configuracaoVendaPanel.add(campoValorRecebido);
		
		trocoTitulo = new JLabel("Troco:");
		trocoTitulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		trocoTitulo.setBounds(321, 146, 71, 14);
		configuracaoVendaPanel.add(trocoTitulo);
		
		valorTroco = new JLabel("R$ 2,60");
		valorTroco.setFont(new Font("SansSerif", Font.PLAIN, 18));
		valorTroco.setBounds(321, 169, 172, 25);
		configuracaoVendaPanel.add(valorTroco);
		
		Botao botaoCancelar = new Botao("Cancelar\r\n");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu menu = new TelaMenu();
				if(JOptionPane.showConfirmDialog(botaoCancelar, "Deseja realmente cancelar a venda?", "Cancelar", JOptionPane.YES_NO_OPTION) == 0) {
					getFrame().setVisible(false);
					menu.getFrame().setLocationRelativeTo(null);
					menu.getFrame().setVisible(true);
				}
			}
		});
		botaoCancelar.setBackground(new Color(255, 0, 0));
		botaoCancelar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		botaoCancelar.setBounds(778, 22, 150, 37);
		configuracaoVendaPanel.add(botaoCancelar);	
	}
}
