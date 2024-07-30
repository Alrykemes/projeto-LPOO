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

public class JanelaFuncionario {

	private JFrame frame;
	private JTextField txtManegepro;
	private JTextField txtCadastrarFuncionrio;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtCargo;
	private JTextField txtNome_1;
	private JTextField txtEmail_1;
	private JTextField txtCpf_1;
	private JTextField txtSenha_1;
	private JTextField txtCargo_1;
	private JTextField txtSalrio;
	private JTextField txtDataAdmisso;
	private JTextField txtFrequncia;
	private JTable table;

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
		txtManegepro.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtManegepro.setEditable(false);
		txtManegepro.setBounds(0, 0, 115, 30);
		txtManegepro.setText("ManegePro");
		panel_1.add(txtManegepro);
		txtManegepro.setColumns(10);
		
		txtCadastrarFuncionrio = new JTextField();
		txtCadastrarFuncionrio.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtCadastrarFuncionrio.setEditable(false);
		txtCadastrarFuncionrio.setBounds(0, 75, 1006, 54);
		txtCadastrarFuncionrio.setText("Cadastrar Funcionário");
		panel_1.add(txtCadastrarFuncionrio);
		txtCadastrarFuncionrio.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtNome.setText("Nome:");
		txtNome.setBounds(0, 139, 96, 19);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtCpf.setText("CPF:");
		txtCpf.setBounds(106, 139, 96, 19);
		panel_1.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtEmail.setText("Email:");
		txtEmail.setBounds(212, 139, 96, 19);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtSenha.setText("Senha:");
		txtSenha.setBounds(318, 139, 96, 19);
		panel_1.add(txtSenha);
		txtSenha.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtCargo.setText("Cargo:");
		txtCargo.setBounds(424, 139, 96, 19);
		panel_1.add(txtCargo);
		txtCargo.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 10));
		btnNewButton.setBounds(598, 138, 85, 21);
		panel_1.add(btnNewButton);
		
		txtNome_1 = new JTextField();
		txtNome_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtNome_1.setEditable(false);
		txtNome_1.setText("Nome");
		txtNome_1.setBounds(0, 168, 115, 20);
		panel_1.add(txtNome_1);
		txtNome_1.setColumns(10);
		
		txtEmail_1 = new JTextField();
		txtEmail_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtEmail_1.setEditable(false);
		txtEmail_1.setText("Email");
		txtEmail_1.setBounds(250, 168, 115, 20);
		panel_1.add(txtEmail_1);
		txtEmail_1.setColumns(10);
		
		txtCpf_1 = new JTextField();
		txtCpf_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtCpf_1.setEditable(false);
		txtCpf_1.setText("CPF");
		txtCpf_1.setBounds(125, 168, 115, 20);
		panel_1.add(txtCpf_1);
		txtCpf_1.setColumns(10);
		
		txtSenha_1 = new JTextField();
		txtSenha_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtSenha_1.setEditable(false);
		txtSenha_1.setText("Senha");
		txtSenha_1.setBounds(375, 168, 115, 20);
		panel_1.add(txtSenha_1);
		txtSenha_1.setColumns(10);
		
		txtCargo_1 = new JTextField();
		txtCargo_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtCargo_1.setEditable(false);
		txtCargo_1.setText("Cargo");
		txtCargo_1.setBounds(500, 168, 115, 20);
		panel_1.add(txtCargo_1);
		txtCargo_1.setColumns(10);
		
		txtSalrio = new JTextField();
		txtSalrio.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtSalrio.setEditable(false);
		txtSalrio.setText("Salário");
		txtSalrio.setBounds(625, 168, 115, 20);
		panel_1.add(txtSalrio);
		txtSalrio.setColumns(10);
		
		txtDataAdmisso = new JTextField();
		txtDataAdmisso.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtDataAdmisso.setEditable(false);
		txtDataAdmisso.setText("Data Admissão");
		txtDataAdmisso.setBounds(750, 168, 115, 20);
		panel_1.add(txtDataAdmisso);
		txtDataAdmisso.setColumns(10);
		
		txtFrequncia = new JTextField();
		txtFrequncia.setFont(new Font("SansSerif", Font.PLAIN, 10));
		txtFrequncia.setEditable(false);
		txtFrequncia.setText("Frequência");
		txtFrequncia.setBounds(875, 168, 115, 20);
		panel_1.add(txtFrequncia);
		txtFrequncia.setColumns(10);
		
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
		table.setBounds(10, 198, 980, 435);
		panel_1.add(table);
	}
}
