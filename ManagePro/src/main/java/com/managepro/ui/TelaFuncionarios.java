package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;

public class TelaFuncionarios {

<<<<<<< HEAD
	private JFrame frmManagePro;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoEmail;
	private JTextField campoSenha;
	private JTextField campoCargo;
=======
	private JPanel funcionariosPanel;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtCargo;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
	private JTable table;
	private JLabel labelNome;
	private JLabel labelCpf;
	private JLabel labelEmail;
	private JLabel labelSenha;
	private JLabel labelCargo;
	private JLabel labelSalario;
	private JLabel labelDataAdmissao;
	private JLabel labelFrequencia;

	public JPanel getPanel() {
		return this.funcionariosPanel;
	}
	
	public TelaFuncionarios() {
		initialize();
	}

	
	private void initialize() {
<<<<<<< HEAD
		frmManagePro = new JFrame();
		frmManagePro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFuncionarios.class.getResource("/com/managepro/assets/manageIcon.png")));
		frmManagePro.setTitle("ManagePro");
		frmManagePro.setBounds(100, 100, 1024, 680);
		frmManagePro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagePro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1006, 643);
		panel.setLayout(null);
		frmManagePro.getContentPane().add(panel);
=======
		funcionariosPanel = new JPanel();
		funcionariosPanel.setSize(1020, 680);
		funcionariosPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setSize(1006, 643);
		funcionariosPanel.add(panel_1);
		panel_1.setLayout(null);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		Botao botaoVoltar = new Botao("Voltar   ");
		botaoVoltar.setIcon(new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		botaoVoltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu menu = new TelaMenu();
				getFrame().setVisible(false);
				menu.getFrame().setLocationRelativeTo(null);
				menu.getFrame().setVisible(true);
			}
		});
		botaoVoltar.setBounds(20, 8, 120, 35);
		panel.add(botaoVoltar);
		
		campoNome = new JTextField();
		campoNome.setFont(new Font("SansSerif", Font.PLAIN, 20));
		campoNome.setText("Nome:");
		campoNome.setBounds(20, 66, 132, 25);
		campoNome.setColumns(10);
		campoNome.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				 // Limpa o texto quando o campo ganha foco
				if (campoNome.getText().equals("Nome:")) {
					campoNome.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				// Se o campo estiver vazio quando perder o foco, redefine o texto original
				if (campoNome.getText().isEmpty()) {
					campoNome.setText("Nome:");
				}
			}
		});
		panel.add(campoNome);
		
		campoCpf = new JTextField();
		campoCpf.setFont(new Font("SansSerif", Font.PLAIN, 20));
		campoCpf.setText("CPF:");
		campoCpf.setBounds(162, 66, 115, 25);
		campoCpf.setColumns(10);
		campoCpf.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (campoCpf.getText().equals("CPF:")) {
					campoCpf.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (campoCpf.getText().isEmpty()) {
					campoCpf.setText("CPF:");
				}
			}
		});
		panel.add(campoCpf);
		
		campoEmail = new JTextField();	
		campoEmail.setFont(new Font("SansSerif", Font.PLAIN, 20));
		campoEmail.setText("Email:");
		campoEmail.setBounds(287, 66, 115, 25);
		campoEmail.setColumns(10);
		campoEmail.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (campoEmail.getText().equals("Email:")) {
					campoEmail.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (campoEmail.getText().isEmpty()) {
					campoEmail.setText("Email:");
				}
			}
		});
		panel.add(campoEmail);
		
		campoSenha = new JTextField();
		campoSenha.setFont(new Font("SansSerif", Font.PLAIN, 20));
		campoSenha.setText("Senha:");
		campoSenha.setBounds(412, 66, 115, 25);
		campoSenha.setColumns(10);
		campoSenha.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (campoSenha.getText().equals("Senha:")) {
					campoSenha.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (campoSenha.getText().isEmpty()) {
					campoSenha.setText("Senha:");
				}
			}
		});
		panel.add(campoSenha);
		
		campoCargo = new JTextField();
		campoCargo.setFont(new Font("SansSerif", Font.PLAIN, 20));
		campoCargo.setText("Cargo:");
		campoCargo.setBounds(537, 66, 123, 25);
		campoCargo.setColumns(10);
		campoCargo.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (campoCargo.getText().equals("Cargo:")) {
					campoCargo.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (campoCargo.getText().isEmpty()) {
					campoCargo.setText("Cargo:");
				}
			}
		});
		panel.add(campoCargo);
		
		Botao botaoAdicionarFuncionario = new Botao("Adicionar");
		botaoAdicionarFuncionario.setBackground(new Color(255, 255, 255));
		botaoAdicionarFuncionario.setFont(new Font("SansSerif", Font.BOLD, 20));
		botaoAdicionarFuncionario.setBounds(835, 66, 155, 27);
		panel.add(botaoAdicionarFuncionario);
		
		labelNome = new JLabel("Nome");
		labelNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelNome.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelNome.setBounds(0, 125, 115, 20);
		panel.add(labelNome);
		
		labelCpf = new JLabel("CPF");
		labelCpf.setHorizontalAlignment(SwingConstants.CENTER);
		labelCpf.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelCpf.setBounds(125, 125, 115, 20);
		panel.add(labelCpf);
		
		labelEmail = new JLabel("Email");
		labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
		labelEmail.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelEmail.setBounds(250, 125, 115, 20);
		panel.add(labelEmail);
		
		labelSenha = new JLabel("Senha");
		labelSenha.setHorizontalAlignment(SwingConstants.CENTER);
		labelSenha.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelSenha.setBounds(375, 125, 115, 20);
		panel.add(labelSenha);
		
		labelCargo = new JLabel("Cargo");
		labelCargo.setHorizontalAlignment(SwingConstants.CENTER);
		labelCargo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelCargo.setBounds(500, 125, 115, 20);
		panel.add(labelCargo);
		
		labelSalario = new JLabel("Salário");
		labelSalario.setHorizontalAlignment(SwingConstants.CENTER);
		labelSalario.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelSalario.setBounds(625, 125, 115, 20);
		panel.add(labelSalario);
		
		labelDataAdmissao = new JLabel("Data Admissão");
		labelDataAdmissao.setHorizontalAlignment(SwingConstants.CENTER);
		labelDataAdmissao.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelDataAdmissao.setBounds(750, 125, 115, 20);
		panel.add(labelDataAdmissao);
		
		labelFrequencia = new JLabel("Frequência");
		labelFrequencia.setHorizontalAlignment(SwingConstants.CENTER);
		labelFrequencia.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelFrequencia.setBounds(875, 125, 115, 20);
		panel.add(labelFrequencia);
		
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
<<<<<<< HEAD
		panel.add(table);
=======
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
		
		JButton btnComeback = new JButton("Voltar   ");
		btnComeback.setIcon(new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		btnComeback.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnComeback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Menu");
			}
		});
		btnComeback.setBounds(20, 8, 120, 35);
		panel_1.add(btnComeback);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
	}
}