package com.managepro.project.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Scrollbar;

public class TelaAdicionarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionarProduto frame = new TelaAdicionarProduto();
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
	public TelaAdicionarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Preencha os campos abaixo corretamente *");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 35, 268, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Produto *");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(34, 73, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(34, 98, 217, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Código *");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(312, 73, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(312, 98, 131, 35);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(501, 98, 131, 35);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Preço de Venda *");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(501, 73, 110, 14);
		contentPane.add(lblNewLabel_3);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 398, 684, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(45, 11, 99, 41);
		panel.add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(539, 11, 99, 41);
		panel.add(btnCadastrar);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(34, 182, 131, 35);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade *");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(34, 157, 118, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(218, 182, 139, 35);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Marca *");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(218, 157, 87, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fornecedor *");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(415, 157, 81, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(415, 182, 217, 35);
		contentPane.add(textField_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(34, 241, 598, 140);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(0, 0, 598, 36);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Nome");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(25, 11, 46, 14);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Cód");
		lblNewLabel_9.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(104, 6, 46, 24);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("R$");
		lblNewLabel_10.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(172, 9, 46, 18);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Qntd");
		lblNewLabel_11.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(228, 9, 57, 18);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Marca");
		lblNewLabel_12.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(286, 9, 46, 18);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Fornecedor");
		lblNewLabel_13.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(347, 11, 87, 14);
		panel_3.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Inserir texto com as informações do produto que está sendo cadastrado //To Do");
		lblNewLabel_14.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(23, 51, 547, 26);
		panel_1.add(lblNewLabel_14);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 241, 598, 24);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_7 = new JLabel("CADASTRAR PRODUTO");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(10, 11, 295, 24);
		contentPane.add(lblNewLabel_7);
	}
}
