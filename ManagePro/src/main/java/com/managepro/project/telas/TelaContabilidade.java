package com.managepro.project.telas;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaContabilidade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblImage1;		//IMAGENS DOS GRÁFICOS (APAGAR DEPOIS: APENAS TESTE)
	private JLabel lblImage2;		//AVISO: NOMES GENÉRICOS CRIADOS PROPOSITALMENTE: APENAS TESTE
	private JLabel lblImage3;
	private JLabel lblImage4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaContabilidade frame = new TelaContabilidade();
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
	public TelaContabilidade() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(109, 109, 109));
		panel.setBounds(132, 175, 458, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(109, 109, 109));
		panel_1.setBounds(608, 175, 260, 192);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(0, 38, 1004, 129);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Data Inicial *");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(62, 28, 101, 29);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data Final *");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(266, 28, 75, 29);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Agrupar por *");
		lblNewLabel_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(469, 28, 101, 29);
		panel_2.add(lblNewLabel_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Venda", "Produto", "Cliente", "Forma de pagamento"}));
		comboBox.setBounds(469, 54, 167, 35);
		panel_2.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setBounds(62, 54, 155, 35);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(266, 54, 155, 35);
		panel_2.add(textField_1);
		
		JButton btnNewButton = new JButton("Gerar relatório");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton.setBounds(735, 57, 145, 31);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarTexto();
			}
		});	
		
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(109, 109, 109));
		panel_3.setBounds(132, 380, 360, 171);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		Panel panel_3_1 = new Panel();
		panel_3_1.setBackground(new Color(109, 109, 109));
		panel_3_1.setBounds(508, 380, 360, 171);
		contentPane.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		
		lblImage1 = new JLabel("fotoaqui");
		lblImage1.setBounds(10, 11, 438, 170);
		panel.add(lblImage1);
		
		lblImage2 = new JLabel("fotoaqui");
		lblImage2.setBounds(10, 11, 438, 170);
		panel_1.add(lblImage2);
		
		lblImage3 = new JLabel("fotoaqui");
		lblImage3.setBounds(10, 11, 438, 170);
		panel_3.add(lblImage3);
		
		lblImage4 = new JLabel("fotoaqui");
		lblImage4.setBounds(10, 11, 438, 170);
		panel_3_1.add(lblImage4);
		
	}
	
	
		private void validarTexto() { //VERIFICA SE A CAIXA DE TEXTO FOI DEIXADA VAZIA
			if (textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				showImage();
			}
    }
	
		private void showImage() {	//MOSTRA AS IMAGENS DOS GRÁFICOS
			lblImage1.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/images/imagem-grafico.png")));
			lblImage2.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/images/imagem-grafico.png")));
			lblImage3.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/images/imagem-grafico.png")));
			lblImage4.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/images/imagem-grafico.png")));
    }
		
		

}
