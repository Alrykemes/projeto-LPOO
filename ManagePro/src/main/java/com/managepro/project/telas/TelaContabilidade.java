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
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class TelaContabilidade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblImage1;		//IMAGENS DOS GRÁFICOS (APAGAR DEPOIS: APENAS TESTE)
	private JLabel lblImage2;		//AVISO: NOMES GENÉRICOS CRIADOS PROPOSITALMENTE: APENAS TESTE
	private JLabel lblImage3;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;

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
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel painelGrafico = new Panel();
		painelGrafico.setBackground(new Color(255, 255, 255));
		painelGrafico.setBounds(132, 230, 510, 150);
		contentPane.add(painelGrafico);
		painelGrafico.setLayout(null);
		
		Panel painelGrafico2 = new Panel();
		painelGrafico2.setBackground(new Color(255, 255, 255));
		painelGrafico2.setBounds(648, 230, 249, 300);
		contentPane.add(painelGrafico2);
		painelGrafico2.setLayout(null);
		
		Panel painelOpcoes = new Panel();
		painelOpcoes.setBackground(new Color(153, 51, 153));
		painelOpcoes.setBounds(0, 0, 1004, 93);
		contentPane.add(painelOpcoes);
		painelOpcoes.setLayout(null);
		
		JLabel dataLabel = new JLabel("Data Inicial *");
		dataLabel.setForeground(new Color(255, 255, 255));
		dataLabel.setBackground(new Color(255, 255, 255));
		dataLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		dataLabel.setBounds(72, 11, 101, 29);
		painelOpcoes.add(dataLabel);
		
		JLabel finalLabel = new JLabel("Data Final *");
		finalLabel.setForeground(new Color(255, 255, 255));
		finalLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		finalLabel.setBounds(289, 11, 75, 29);
		painelOpcoes.add(finalLabel);
		
		JLabel agruparLabel = new JLabel("Agrupar por *");
		agruparLabel.setForeground(new Color(255, 255, 255));
		agruparLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		agruparLabel.setBounds(507, 11, 101, 29);
		painelOpcoes.add(agruparLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Venda", "Produto", "Cliente", "Forma de pagamento", "Código"}));
		comboBox.setBounds(507, 39, 167, 35);
		painelOpcoes.add(comboBox);
		
		JButton gerarRelatorio = new JButton("Gerar relatório");
		gerarRelatorio.setBackground(new Color(255, 255, 255));
		gerarRelatorio.setFont(new Font("SansSerif", Font.PLAIN, 12));
		gerarRelatorio.setBounds(749, 41, 145, 31);
		painelOpcoes.add(gerarRelatorio);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(72, 39, 155, 35);
		painelOpcoes.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(289, 39, 161, 35);
		painelOpcoes.add(dateChooser_1);
		
		//BOTÃO
		gerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarData();
			}
		});	
		
		
		Panel painelGrafico3 = new Panel();
		painelGrafico3.setBackground(new Color(255, 255, 255));
		painelGrafico3.setBounds(132, 386, 510, 144);
		contentPane.add(painelGrafico3);
		painelGrafico3.setLayout(null);
		
		Panel cardUm = new Panel();
		cardUm.setBackground(new Color(255, 255, 255));
		cardUm.setBounds(132, 108, 255, 116);
		contentPane.add(cardUm);
		cardUm.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 11, 60, 14);
		cardUm.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("340");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(151, 68, 60, 26);
		cardUm.add(lblNewLabel_2);
		
		
		lblImage1 = new JLabel("fotoaqui");
		lblImage1.setBounds(10, 11, 438, 170);
		painelGrafico.add(lblImage1);
		
		lblImage2 = new JLabel("fotoaqui");
		lblImage2.setBounds(15, 11, 208, 265);
		painelGrafico2.add(lblImage2);
		
		lblImage3 = new JLabel("fotoaqui");
		lblImage3.setBounds(10, -21, 438, 170);
		painelGrafico3.add(lblImage3);
		
		Panel cardDois = new Panel();
		cardDois.setLayout(null);
		cardDois.setBackground(new Color(255, 255, 255));
		cardDois.setBounds(394, 108, 248, 116);
		contentPane.add(cardDois);
		
		JLabel lblNewLabel_5 = new JLabel("Vendas");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(20, 11, 46, 14);
		cardDois.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("340");
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(169, 68, 60, 26);
		cardDois.add(lblNewLabel_2_1);
		
		Panel cardTres = new Panel();
		cardTres.setLayout(null);
		cardTres.setBackground(new Color(255, 255, 255));
		cardTres.setBounds(648, 108, 249, 116);
		contentPane.add(cardTres);
		
		JLabel lblNewLabel_3 = new JLabel("Ganhos");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(26, 11, 46, 14);
		cardTres.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("R$ 12.500");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(104, 68, 111, 26);
		cardTres.add(lblNewLabel_4);
		
	}
	
	
		private void validarData() { 
			Date dataInicial = dateChooser.getDate();
			Date dataFinal = dateChooser_1.getDate();
			
			if(dataInicial == null || dataFinal == null) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				showImage();
			}
    }
	
		private void showImage() {	//MOSTRA AS IMAGENS DOS GRÁFICOS
			lblImage1.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/images/imagem-grafico.png")));
			lblImage2.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/images/imagem-grafico.png")));
			lblImage3.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/images/imagem-grafico.png")));
    }
}
