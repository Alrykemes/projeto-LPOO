package teste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBox;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(81, 81, 81));
		panel.setBounds(0, 0, 1004, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 336, 81);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\ManagePRO-removebg-preview 2.png"));
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(888, 30, 89, 23);
		panel.add(btnNewButton);
		
		JButton estoqueBotao = new JButton("Estoque");
		estoqueBotao.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\estoque-pronto (1).png"));
		estoqueBotao.setFont(new Font("SansSerif", Font.PLAIN, 11));
		estoqueBotao.setBorder(new LineBorder(Color.GRAY, 2));
		estoqueBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		estoqueBotao.setBounds(317, 114, 249, 49);
		contentPane.add(estoqueBotao);
		
		JButton vendasBt = new JButton("Vendas");
		vendasBt.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\crescimento (1).png"));
		vendasBt.setFont(new Font("SansSerif", Font.PLAIN, 11));
		vendasBt.setBorder(new LineBorder(Color.GRAY, 2));
		vendasBt.setBounds(317, 237, 249, 49);
		contentPane.add(vendasBt);
		
		JButton funcionariosBt = new JButton("Funcionários");
		funcionariosBt.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\carteira-de-identidade (1).png"));
		funcionariosBt.setFont(new Font("SansSerif", Font.PLAIN, 11));
		funcionariosBt.setBorder(new LineBorder(Color.GRAY, 2));
		funcionariosBt.setBounds(317, 351, 249, 49);
		contentPane.add(funcionariosBt);
		
		JButton contabilidadeBt = new JButton("Contabilidade");
		contabilidadeBt.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\contabilidade (1).png"));
		contabilidadeBt.setFont(new Font("SansSerif", Font.PLAIN, 11));
		contabilidadeBt.setBorder(new LineBorder(Color.GRAY, 2));
		contabilidadeBt.setBounds(317, 466, 249, 49);
		contentPane.add(contabilidadeBt);
	}
}
