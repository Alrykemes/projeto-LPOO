package com.managepro.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class TelaGerenciamentoDeVendas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PrincipalPanel;
	private JTextField FieldSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciamentoDeVendas frame = new TelaGerenciamentoDeVendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaGerenciamentoDeVendas() {
		setResizable(false);
		setTitle("ManagePro - Gerenciamento de vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 680);
		PrincipalPanel = new JPanel();
		PrincipalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PrincipalPanel);
		PrincipalPanel.setLayout(null);
		
		JPanel SearchPanel = new JPanel();
		SearchPanel.setBounds(10, 0, 288, 630);
		PrincipalPanel.add(SearchPanel);
		SearchPanel.setLayout(null);
		
		JLabel lblSearch = new JLabel("Pesquisar");
		lblSearch.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSearch.setBounds(10, 11, 85, 20);
		SearchPanel.add(lblSearch);
		
		JLabel lblFor = new JLabel("Por:");
		lblFor.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblFor.setBounds(121, 11, 39, 20);
		SearchPanel.add(lblFor);
		
		FieldSearch = new JTextField();
		FieldSearch.setForeground(new Color(105, 105, 105));
		FieldSearch.setText("Pesquise vendas por data");
		FieldSearch.setFont(new Font("SansSerif", Font.PLAIN, 18));
		FieldSearch.setBounds(10, 35, 268, 30);
		SearchPanel.add(FieldSearch);
		FieldSearch.setColumns(10);
		
		JComboBox FilterComboBox = new JComboBox();
		FilterComboBox.setFont(new Font("SansSerif", Font.PLAIN, 17));
		FilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"Data", "ID", "Funcionario"}));
		FilterComboBox.setBounds(160, 10, 118, 22);
		SearchPanel.add(FilterComboBox);
		
		JList SalesList = new JList();
		SalesList.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		SalesList.setValueIsAdjusting(true);
		SalesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		SalesList.setBounds(10, 76, 268, 543);
		SearchPanel.add(SalesList);
		
		JPanel SalePanel = new JPanel();
		SalePanel.setBounds(297, 0, 697, 630);
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
		lblTextDate.setBounds(529, 23, 58, 29);
		SalePanel.add(lblTextDate);
		
		JLabel lblDate = new JLabel("17/06/2021");
		lblDate.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblDate.setBounds(587, 23, 100, 29);
		SalePanel.add(lblDate);
		
		JList productsList = new JList();
		productsList.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		productsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productsList.setFont(new Font("SansSerif", Font.PLAIN, 18));
		productsList.setBounds(10, 75, 677, 342);
		SalePanel.add(productsList);
		
		JButton buttonNotaFiscal = new JButton("Emitir Nota Fiscal");
		buttonNotaFiscal.setFont(new Font("SansSerif", Font.PLAIN, 20));
		buttonNotaFiscal.setBounds(10, 578, 210, 41);
		SalePanel.add(buttonNotaFiscal);
		
		JLabel lblEmployeeName = new JLabel("Alguém da Silva");
		lblEmployeeName.setToolTipText("");
		lblEmployeeName.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblEmployeeName.setBounds(307, 23, 204, 29);
		SalePanel.add(lblEmployeeName);
		
		JLabel lblTextEmployee = new JLabel("Funcionário:");
		lblTextEmployee.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTextEmployee.setBounds(201, 23, 108, 29);
		SalePanel.add(lblTextEmployee);
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnDelete.setBounds(558, 578, 129, 41);
		SalePanel.add(btnDelete);
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnEdit.setBounds(316, 578, 129, 41);
		SalePanel.add(btnEdit);
		
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
	}
}
