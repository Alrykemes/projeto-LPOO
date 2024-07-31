package gerenciamentoFuncionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class JanelaFuncionario {

	private JFrame frame;
	private JTextField txtManegepro;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtCargo;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaFuncionario window = new JanelaFuncionario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1020, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1006, 643);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtManegepro = new JTextField();
		txtManegepro.setEnabled(false);
		txtManegepro.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtManegepro.setEditable(false);
		txtManegepro.setBounds(0, 0, 115, 30);
		txtManegepro.setText("ManegePro");
		panel_1.add(txtManegepro);
		txtManegepro.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtNome.setText("Nome:");
		txtNome.setBounds(2, 46, 132, 25);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtCpf.setText("CPF:");
		txtCpf.setBounds(144, 46, 115, 25);
		panel_1.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtEmail.setText("Email:");
		txtEmail.setBounds(269, 46, 115, 25);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtSenha.setText("Senha:");
		txtSenha.setBounds(394, 46, 115, 25);
		panel_1.add(txtSenha);
		txtSenha.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtCargo.setText("Cargo:");
		txtCargo.setBounds(519, 46, 123, 25);
		panel_1.add(txtCargo);
		txtCargo.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton.setBounds(867, 46, 123, 27);
		panel_1.add(btnNewButton);
		
		table = new JTable();
		table.setFont(new Font("SansSerif", Font.PLAIN, 10));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(10, 155, 980, 478);
		panel_1.add(table);
		
		lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 125, 115, 20);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(125, 125, 115, 20);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(250, 125, 115, 20);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(375, 125, 115, 20);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Cargo");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(500, 125, 115, 20);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Salário");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(625, 125, 115, 20);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Data Admissão");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(750, 125, 115, 20);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Frequência");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(875, 125, 115, 20);
		panel_1.add(lblNewLabel_7);
	}
}
