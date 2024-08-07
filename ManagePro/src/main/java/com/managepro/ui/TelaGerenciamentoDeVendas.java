package com.managepro.ui;

<<<<<<< HEAD
import javax.swing.JFrame;

=======
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaGerenciamentoDeVendas {

<<<<<<< HEAD
	private JFrame frmManagePro;
	private JPanel panel;
	private JTextField campoPesquisa;
	private JDateChooser escolherDataInicial;
	private JDateChooser escolherDataFinal;
	private JLabel labelDataInicial;
	private JLabel labelDataFinal;
=======
	private JPanel gerenciamentoVendasPanel;
	private JPanel PrincipalPanel;
	private JTextField FieldSearch;
	private JDateChooser dateChooserFrom;
	private JDateChooser dateChooserTo;
	private JLabel textDateFrom;
	private JLabel textDateTo;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712

	public JPanel getPanel() {
		return this.gerenciamentoVendasPanel;
	}
	
	public TelaGerenciamentoDeVendas() {
		initialize();
	}
		
	private void initialize() {
<<<<<<< HEAD
		frmManagePro = new JFrame();
		frmManagePro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/manageIcon.png")));
		frmManagePro.setResizable(false);
		frmManagePro.setLocationRelativeTo(null);
		frmManagePro.setTitle("ManagePro");
		frmManagePro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagePro.setBounds(100, 100, 1024, 680);
=======
		gerenciamentoVendasPanel = new JPanel();
		gerenciamentoVendasPanel.setSize(1020, 680);
		gerenciamentoVendasPanel.setLayout(null);
		PrincipalPanel = new JPanel();
		PrincipalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		PrincipalPanel.setSize(1020, 680);
		gerenciamentoVendasPanel.add(PrincipalPanel);
		PrincipalPanel.setLayout(null);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		frmManagePro.setContentPane(panel);
		
<<<<<<< HEAD
		Botao botaoVoltar = new Botao("Voltar   ");
		botaoVoltar.setIcon(new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		botaoVoltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		botaoVoltar.addActionListener(new ActionListener() {
=======
		JLabel lblSearch = new JLabel("Pesquisar");
		lblSearch.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSearch.setBounds(10, 11, 85, 20);
		SearchPanel.add(lblSearch);
		
		JLabel lblFor = new JLabel("Por:");
		lblFor.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblFor.setBounds(159, 11, 39, 20);
		SearchPanel.add(lblFor);
		
		FieldSearch = new JTextField();
		FieldSearch.setForeground(new Color(105, 105, 105));
		FieldSearch.setText("Pesquise vendas por ID");
		FieldSearch.setFont(new Font("SansSerif", Font.PLAIN, 17));
		FieldSearch.setBounds(10, 42, 307, 30);
		FieldSearch.setColumns(10);
		FieldSearch.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FieldSearch.setText("");
				FieldSearch.setForeground(new Color(0, 0, 0));
			}
			
			public void focusLost(FocusEvent e) {
				FieldSearch.setText("Digite para pesquisar");
				FieldSearch.setForeground(new Color(105, 105, 105));
			}
		});
		SearchPanel.add(FieldSearch);
		
		dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(40, 42, 118, 25);
		textDateFrom = new JLabel("De:");
		textDateFrom.setBounds(10, 46, 30, 15);
		textDateFrom.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		dateChooserTo = new JDateChooser();
		dateChooserTo.setBounds(199, 42, 118, 25);
		textDateTo = new JLabel("Até:");
		textDateTo.setBounds(165, 46, 30, 15);
		textDateTo.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		
		JComboBox<String> FilterComboBox = new JComboBox<String>();
		FilterComboBox.setFont(new Font("SansSerif", Font.PLAIN, 17));
		FilterComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Funcionario", "Data"}));
		FilterComboBox.setBounds(199, 10, 118, 22);
		SearchPanel.add(FilterComboBox);
		FilterComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getItem().equals("ID")) {
					FieldSearch.setBounds(10, 42, 307, 30);
					FieldSearch.setText("Pesquise vendas por ID");
					SearchPanel.add(FieldSearch);
					SearchPanel.remove(dateChooserFrom);
					SearchPanel.remove(textDateFrom);
					SearchPanel.remove(dateChooserTo);
					SearchPanel.remove(textDateTo);
					
				}
				
				if(e.getItem().equals("Data")) {
					FieldSearch.setBounds(0, 0, 0, 0);
					SearchPanel.remove(FieldSearch);
					SearchPanel.add(dateChooserFrom);
					SearchPanel.add(textDateFrom);
					SearchPanel.add(dateChooserTo);
					SearchPanel.add(textDateTo);
				}
				
				if(e.getItem().equals("Funcionario")) {
					FieldSearch.setBounds(10, 42, 307, 30);
					FieldSearch.setText("Pesquise vendas por Funcionario");
					SearchPanel.add(FieldSearch);
					SearchPanel.remove(dateChooserFrom);
					SearchPanel.remove(textDateFrom);
					SearchPanel.remove(dateChooserTo);
					SearchPanel.remove(textDateTo);
				}
			}
		});

		JList<?> SalesList = new JList<Object>();
		SalesList.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		SalesList.setValueIsAdjusting(true);
		SalesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		SalesList.setBounds(10, 83, 307, 491);
		SearchPanel.add(SalesList);
		
		
		JPanel SalePanel = new JPanel();
		SalePanel.setBounds(337, 0, 657, 630);
		PrincipalPanel.add(SalePanel);
		SalePanel.setLayout(null);
		
		JLabel lblIdSale = new JLabel("165198");
		lblIdSale.setToolTipText("");
		lblIdSale.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblIdSale.setBounds(42, 23, 72, 29);
		SalePanel.add(lblIdSale);
		
		JLabel lblTextID = new JLabel("ID:");
		lblTextID.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblTextID.setBounds(10, 23, 33, 29);
		SalePanel.add(lblTextID);
		
		JLabel lblTextDate = new JLabel("Data:");
		lblTextDate.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblTextDate.setBounds(489, 23, 58, 29);
		SalePanel.add(lblTextDate);
		
		JLabel lblDate = new JLabel("17/06/2021");
		lblDate.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblDate.setBounds(547, 23, 100, 29);
		SalePanel.add(lblDate);
		
		JList<?> productsList = new JList<Object>();
		productsList.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		productsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productsList.setFont(new Font("SansSerif", Font.PLAIN, 18));
		productsList.setBounds(10, 75, 637, 342);
		SalePanel.add(productsList);
		
		JButton buttonNotaFiscal = new JButton("Emitir Nota Fiscal");
		buttonNotaFiscal.setFont(new Font("SansSerif", Font.PLAIN, 20));
		buttonNotaFiscal.setBounds(10, 578, 210, 41);
		SalePanel.add(buttonNotaFiscal);
		
		JLabel lblEmployeeName = new JLabel("Alguém da Silva");
		lblEmployeeName.setToolTipText("");
		lblEmployeeName.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblEmployeeName.setBounds(275, 23, 204, 29);
		SalePanel.add(lblEmployeeName);
		
		JLabel lblTextEmployee = new JLabel("Funcionário:");
		lblTextEmployee.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTextEmployee.setBounds(169, 23, 108, 29);
		SalePanel.add(lblTextEmployee);
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnDelete.setBounds(518, 578, 129, 41);
		SalePanel.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Total da Compra:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 428, 146, 29);
		SalePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("R$ 186,60");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(154, 428, 119, 29);
		SalePanel.add(lblNewLabel_1);
		
		JLabel lblMtodoDePagamento = new JLabel("Método de Pagamento:");
		lblMtodoDePagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMtodoDePagamento.setBounds(10, 458, 195, 29);
		SalePanel.add(lblMtodoDePagamento);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dinheiro");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(201, 458, 182, 29);
		SalePanel.add(lblNewLabel_1_1);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblCliente.setBounds(10, 488, 61, 32);
		SalePanel.add(lblCliente);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Alrykemes");
		lblNewLabel_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(74, 490, 182, 29);
		SalePanel.add(lblNewLabel_1_1_1);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblCpf.setBounds(10, 517, 46, 29);
		SalePanel.add(lblCpf);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("123.456.789-12");
		lblNewLabel_1_1_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(55, 517, 135, 29);
		SalePanel.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton = new JButton("Voltar   ");
		btnNewButton.setIcon(new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Menu");
			}
		});
		botaoVoltar.setBounds(20, 8, 120, 35);
		panel.add(botaoVoltar);

		JPanel panelProcurar = new JPanel();
		panelProcurar.setBounds(10, 45, 327, 585);
		panel.add(panelProcurar);
		panelProcurar.setLayout(null);
		
		JLabel labelPesquisar = new JLabel("Pesquisar");
		labelPesquisar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelPesquisar.setBounds(10, 11, 85, 20);
		panelProcurar.add(labelPesquisar);
		
		JLabel labelPor = new JLabel("Por:");
		labelPor.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelPor.setBounds(159, 11, 39, 20);
		panelProcurar.add(labelPor);
		
		ComboBox<String> filtrarPesquisa = new ComboBox<String>();
		filtrarPesquisa.setFont(new Font("SansSerif", Font.PLAIN, 17));
		filtrarPesquisa.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Funcionario", "Data"}));
		filtrarPesquisa.setBounds(199, 10, 118, 22);
		panelProcurar.add(filtrarPesquisa);
		filtrarPesquisa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getItem().equals("ID")) {
					campoPesquisa.setBounds(10, 42, 307, 30);
					campoPesquisa.setText("Pesquise vendas por ID");
					panelProcurar.add(campoPesquisa);
					panelProcurar.remove(escolherDataInicial);
					panelProcurar.remove(labelDataInicial);
					panelProcurar.remove(escolherDataFinal);
					panelProcurar.remove(labelDataFinal);
					
				}
				
				if(e.getItem().equals("Data")) {
					campoPesquisa.setBounds(0, 0, 0, 0);
					panelProcurar.remove(campoPesquisa);
					panelProcurar.add(escolherDataInicial);
					panelProcurar.add(labelDataInicial);
					panelProcurar.add(escolherDataFinal);
					panelProcurar.add(labelDataFinal);
				}
				
				if(e.getItem().equals("Funcionario")) {
					campoPesquisa.setBounds(10, 42, 307, 30);
					campoPesquisa.setText("Pesquise vendas por Funcionario");
					panelProcurar.add(campoPesquisa);
					panelProcurar.remove(escolherDataInicial);
					panelProcurar.remove(labelDataInicial);
					panelProcurar.remove(escolherDataFinal);
					panelProcurar.remove(labelDataFinal);
				}
			}
		});
		
		escolherDataInicial = new JDateChooser();
		escolherDataInicial.setBounds(40, 42, 118, 25);
		labelDataInicial = new JLabel("De:");
		labelDataInicial.setBounds(10, 46, 30, 15);
		labelDataInicial.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		escolherDataFinal = new JDateChooser();
		escolherDataFinal.setBounds(199, 42, 118, 25);
		labelDataFinal = new JLabel("Até:");
		labelDataFinal.setBounds(165, 46, 30, 15);
		labelDataFinal.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		campoPesquisa = new JTextField();
		campoPesquisa.setForeground(new Color(105, 105, 105));
		campoPesquisa.setText("Pesquise vendas por ID");
		campoPesquisa.setFont(new Font("SansSerif", Font.PLAIN, 17));
		campoPesquisa.setBounds(10, 42, 307, 30);
		campoPesquisa.setColumns(10);
		campoPesquisa.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				campoPesquisa.setText("");
				campoPesquisa.setForeground(new Color(0, 0, 0));
			}
			
			public void focusLost(FocusEvent e) {
				campoPesquisa.setText("Digite para pesquisar");
				campoPesquisa.setForeground(new Color(105, 105, 105));
			}
		});
		panelProcurar.add(campoPesquisa);

		JList<?> listaVendas = new JList<Object>();
		listaVendas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		listaVendas.setValueIsAdjusting(true);
		listaVendas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaVendas.setBounds(10, 83, 307, 491);
		panelProcurar.add(listaVendas);
		
		JPanel vendasPanel = new JPanel();
		vendasPanel.setBounds(337, 0, 657, 630);
		panel.add(vendasPanel);
		vendasPanel.setLayout(null);
		
		JLabel labelIdVenda = new JLabel("ID:");
		labelIdVenda.setFont(new Font("SansSerif", Font.PLAIN, 20));
		labelIdVenda.setBounds(10, 23, 33, 29);
		vendasPanel.add(labelIdVenda);
		
		JLabel idVenda = new JLabel("165198");
		idVenda.setToolTipText("");
		idVenda.setFont(new Font("SansSerif", Font.PLAIN, 20));
		idVenda.setBounds(42, 23, 72, 29);
		vendasPanel.add(idVenda);
		
		JLabel labelNomeFuncionario = new JLabel("Funcionário:");
		labelNomeFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelNomeFuncionario.setBounds(169, 23, 108, 29);
		vendasPanel.add(labelNomeFuncionario);
		
		JLabel nomeFuncionario = new JLabel("Alguém da Silva");
		nomeFuncionario.setToolTipText("");
		nomeFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 20));
		nomeFuncionario.setBounds(275, 23, 204, 29);
		vendasPanel.add(nomeFuncionario);
		
		JLabel labelData = new JLabel("Data:");
		labelData.setFont(new Font("SansSerif", Font.PLAIN, 20));
		labelData.setBounds(475, 23, 58, 29);
		vendasPanel.add(labelData);
		
		JLabel data = new JLabel("17/06/2021");
		data.setFont(new Font("SansSerif", Font.PLAIN, 20));
		data.setBounds(530, 23, 117, 29);
		vendasPanel.add(data);
		
		JList<?> listaProdutos = new JList<Object>();
		listaProdutos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		listaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaProdutos.setFont(new Font("SansSerif", Font.PLAIN, 18));
		listaProdutos.setBounds(10, 75, 637, 342);
		vendasPanel.add(listaProdutos);
		
		JLabel labelTotalCompras = new JLabel("Total da Compra:");
		labelTotalCompras.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelTotalCompras.setBounds(10, 428, 146, 29);
		vendasPanel.add(labelTotalCompras);
		
		JLabel totalCompras = new JLabel("R$ 186,60");
		totalCompras.setFont(new Font("SansSerif", Font.PLAIN, 18));
		totalCompras.setBounds(154, 428, 119, 29);
		vendasPanel.add(totalCompras);
		
		JLabel labelMetodoPagamento = new JLabel("Método de Pagamento:");
		labelMetodoPagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelMetodoPagamento.setBounds(10, 458, 195, 29);
		vendasPanel.add(labelMetodoPagamento);
		
		JLabel metodoPagamento = new JLabel("Dinheiro");
		metodoPagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		metodoPagamento.setBounds(201, 458, 129, 29);
		vendasPanel.add(metodoPagamento);
		
		JLabel labelNomeCliente = new JLabel("Cliente:");
		labelNomeCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelNomeCliente.setBounds(10, 488, 61, 32);
		vendasPanel.add(labelNomeCliente);
		
		JLabel nomeCliente = new JLabel("Alrykemes");
		nomeCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		nomeCliente.setBounds(74, 490, 182, 29);
		vendasPanel.add(nomeCliente);
		
		JLabel labelCpfCliente = new JLabel("CPF:");
		labelCpfCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelCpfCliente.setBounds(10, 517, 46, 29);
		vendasPanel.add(labelCpfCliente);
		
		JLabel cpfCliente = new JLabel("123.456.789-12");
		cpfCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		cpfCliente.setBounds(55, 517, 135, 29);
		vendasPanel.add(cpfCliente);
		
		Botao botaoEmitirNotaFiscal = new Botao("Emitir Nota Fiscal");
		botaoEmitirNotaFiscal.setFont(new Font("SansSerif", Font.PLAIN, 20));
		botaoEmitirNotaFiscal.setBounds(10, 578, 210, 41);
		vendasPanel.add(botaoEmitirNotaFiscal);
		
		Botao botaoEditarVenda = new Botao("Editar");
		botaoEditarVenda.setFont(new Font("SansSerif", Font.PLAIN, 20));
		botaoEditarVenda.setBounds(316, 578, 129, 41);
		vendasPanel.add(botaoEditarVenda);
		
		Botao botaoDeletarVenda = new Botao("Deletar");
		botaoDeletarVenda.setForeground(new Color(255, 255, 255));
		botaoDeletarVenda.setBackground(new Color(255, 0, 0));
		botaoDeletarVenda.setFont(new Font("SansSerif", Font.PLAIN, 20));
		botaoDeletarVenda.setBounds(518, 578, 129, 41);
		vendasPanel.add(botaoDeletarVenda);
	}
}
