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
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JanelaFuncionario {

	private JFrame frame;
	private JTextField txtManegepro;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtCargo;
	private JTable table;
	private JLabel lblNomeLabel;
	private JLabel lblCPFLabel;
	private JLabel lblEmailLabel;
	private JLabel lblSenhaLabel;
	private JLabel lblCargoLabel;
	private JLabel lblSalarioLabel;
	private JLabel lblDataAdmissaoLabel;
	private JLabel lblFrequenciaLabel;

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
		txtNome.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				 // Limpa o texto quando o campo ganha foco
				if (txtNome.getText().equals("Nome:")) {
					txtNome.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				// Se o campo estiver vazio quando perder o foco, redefine o texto original
				if (txtNome.getText().isEmpty()) {
					txtNome.setText("Nome:");
				}
			}
		});
		txtNome.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtNome.setText("Nome:");
		txtNome.setBounds(2, 46, 132, 25);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (txtCpf.getText().equals("CPF:")) {
					txtCpf.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtCpf.getText().isEmpty()) {
					txtCpf.setText("CPF:");
				}
			}
		});
		txtCpf.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtCpf.setText("CPF:");
		txtCpf.setBounds(144, 46, 115, 25);
		panel_1.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().equals("Email:")) {
					txtEmail.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText("Email:");
				}
			}
		});
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtEmail.setText("Email:");
		txtEmail.setBounds(269, 46, 115, 25);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (txtSenha.getText().equals("Senha:")) {
					txtSenha.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtSenha.getText().isEmpty()) {
					txtSenha.setText("Senha:");
				}
			}
		});
		txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtSenha.setText("Senha:");
		txtSenha.setBounds(394, 46, 115, 25);
		panel_1.add(txtSenha);
		txtSenha.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (txtCargo.getText().equals("Cargo:")) {
					txtCargo.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtCargo.getText().isEmpty()) {
					txtCargo.setText("Cargo:");
				}
			}
		});
		txtCargo.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtCargo.setText("Cargo:");
		txtCargo.setBounds(519, 46, 123, 25);
		panel_1.add(txtCargo);
		txtCargo.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBackground(new Color(255, 255, 255));
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
		
		lblNomeLabel = new JLabel("Nome");
		lblNomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNomeLabel.setBounds(0, 125, 115, 20);
		panel_1.add(lblNomeLabel);
		
		lblCPFLabel = new JLabel("CPF");
		lblCPFLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPFLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCPFLabel.setBounds(125, 125, 115, 20);
		panel_1.add(lblCPFLabel);
		
		lblEmailLabel = new JLabel("Email");
		lblEmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblEmailLabel.setBounds(250, 125, 115, 20);
		panel_1.add(lblEmailLabel);
		
		lblSenhaLabel = new JLabel("Senha");
		lblSenhaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSenhaLabel.setBounds(375, 125, 115, 20);
		panel_1.add(lblSenhaLabel);
		
		lblCargoLabel = new JLabel("Cargo");
		lblCargoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargoLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCargoLabel.setBounds(500, 125, 115, 20);
		panel_1.add(lblCargoLabel);
		
		lblSalarioLabel = new JLabel("Salário");
		lblSalarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalarioLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSalarioLabel.setBounds(625, 125, 115, 20);
		panel_1.add(lblSalarioLabel);
		
		lblDataAdmissaoLabel = new JLabel("Data Admissão");
		lblDataAdmissaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataAdmissaoLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDataAdmissaoLabel.setBounds(750, 125, 115, 20);
		panel_1.add(lblDataAdmissaoLabel);
		
		lblFrequenciaLabel = new JLabel("Frequência");
		lblFrequenciaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrequenciaLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblFrequenciaLabel.setBounds(875, 125, 115, 20);
		panel_1.add(lblFrequenciaLabel);
	}
}
