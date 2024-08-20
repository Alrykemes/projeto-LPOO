package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.managepro.core.model.Cargos;
import com.managepro.core.model.Funcionario;
import com.managepro.core.service.FuncionarioService;
import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JComboBox;

public class TelaFuncionarios {

	private JPanel funcionariosPanel;
	private JTextField campoNome;
	private JFormattedTextField campoCpf;
//	private JTextField campoCargo;
	private JComboBox<String> campoCargo;
	private JTextField campoSalario;
	private JFormattedTextField campoDataAdmissao;
	private JTable tabela;
	private JLabel lblNomeLabel;
	private JLabel lblCPFLabel;
	private JLabel lblEmailLabel;
	private JLabel lblSenhaLabel;
	private JLabel lblCargoLabel;
	private JLabel lblSalarioLabel;
	private JLabel lblDataAdmissaoLabel;
	private JTextField campoUsuario;
	private JTextField campoSenha;
	private JLabel txtCpf;
	private JLabel txtCargo;
	private JLabel txtSalario;
	private JLabel txtDataAdmissao;
	private JLabel txtUsuario;
	private JLabel txtSenha;
	private JDateChooser dateChooser;

	public JPanel getPanel() {
		return this.funcionariosPanel;
	}

	public TelaFuncionarios() throws ParseException {
		initialize();
	}

	private void initialize() throws ParseException {
		funcionariosPanel = new JPanel();
		funcionariosPanel.setSize(1020, 680);
		funcionariosPanel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setSize(1006, 643);
		funcionariosPanel.add(panel_1);
		panel_1.setLayout(null);

		JButton botaoVoltar = new JButton("Voltar   ");
		botaoVoltar.setIcon(
				new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		botaoVoltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Menu");
			}
		});
		botaoVoltar.setBounds(20, 8, 120, 35);
		panel_1.add(botaoVoltar);

		JLabel txtNome = new JLabel("Nome:");
		txtNome.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtNome.setBounds(20, 53, 70, 19);
		panel_1.add(txtNome);

		campoNome = new JTextField();
		campoNome.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoNome.setBounds(21, 82, 180, 38);
		panel_1.add(campoNome);
		campoNome.setColumns(10);

		txtCpf = new JLabel("CPF:");
		txtCpf.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCpf.setBounds(211, 59, 70, 19);
		panel_1.add(txtCpf);

		campoCpf = new JFormattedTextField();
		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setValidCharacters("0123456789");
		maskCpf.setAllowsInvalid(false);
		campoCpf = new JFormattedTextField(maskCpf);
		campoCpf.setFont(new Font("SansSerif", Font.PLAIN, 20));
		campoCpf.setText("CPF:");
		campoCpf.setBounds(211, 82, 180, 38);
		panel_1.add(campoCpf);
		campoCpf.setColumns(10);

		txtCargo = new JLabel("Cargo:");
		txtCargo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCargo.setBounds(401, 59, 70, 19);
		panel_1.add(txtCargo);

		campoCargo = new JComboBox<>();
		campoCargo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoCargo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "ADMINISTRADOR", "VENDEDOR", "CONTADOR", "ESTOQUISTA", "GERENTE" }));
		campoCargo.setBounds(401, 83, 180, 38);
		panel_1.add(campoCargo);

		txtSalario = new JLabel("Salário:");
		txtSalario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSalario.setBounds(591, 59, 70, 19);
		panel_1.add(txtSalario);

		campoSalario = new JTextField();
		campoSalario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoSalario.setBounds(591, 82, 180, 38);
		panel_1.add(campoSalario);

		txtDataAdmissao = new JLabel("Data Admissão:");
		txtDataAdmissao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtDataAdmissao.setBounds(20, 130, 132, 19);
		panel_1.add(txtDataAdmissao);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(21, 155, 180, 38);
		dateChooser.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel_1.add(dateChooser);

		txtUsuario = new JLabel("Usuário:");
		txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtUsuario.setBounds(211, 130, 70, 19);
		panel_1.add(txtUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoUsuario.setColumns(10);
		campoUsuario.setBounds(211, 155, 180, 38);
		panel_1.add(campoUsuario);

		txtSenha = new JLabel("Senha:");
		txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSenha.setBounds(405, 131, 70, 19);
		panel_1.add(txtSenha);

		campoSenha = new JPasswordField();
		campoSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoSenha.setColumns(10);
		campoSenha.setBounds(406, 155, 180, 38);
		panel_1.add(campoSenha);

		JButton botaoAdicionarFuncionario = new JButton("Adicionar");
		botaoAdicionarFuncionario.setBackground(new Color(255, 255, 255));
		botaoAdicionarFuncionario.setFont(new Font("SansSerif", Font.BOLD, 20));
		botaoAdicionarFuncionario.setBounds(797, 127, 171, 47);
		panel_1.add(botaoAdicionarFuncionario);
		botaoAdicionarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instant instant = dateChooser.getDate().toInstant();
				LocalDate dataAdmissaoLD = instant.atZone(ZoneId.systemDefault()).toLocalDate();

				String valorNome = campoNome.getText();
				String valorCpf = campoCpf.getText();
				Cargos valorCargo = Cargos.valueOf(campoCargo.getSelectedItem().toString().replaceAll(" ", ""));
				BigDecimal valorSalario = new BigDecimal(campoSalario.getText());
				LocalDate valorDataAdmissao = dataAdmissaoLD;
				String valorUsuario = campoUsuario.getText();
				String valorSenha = campoSenha.getText();
				
				System.out.println(valorSalario);

				FuncionarioService funcionarioS = new FuncionarioService();
				Funcionario funcionario = new Funcionario(valorNome, valorCpf, valorCargo, valorSalario,
						valorDataAdmissao, valorUsuario, valorSenha);

				try {
					funcionarioS.validarCampos(funcionario);
					funcionarioS.criarFuncionario(funcionario);
				} catch (Exception e1) {
					System.out.println("Erro ao criar funcionário");
					e1.printStackTrace();
				}
			}
		});

		lblNomeLabel = new JLabel("Nome");
		lblNomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNomeLabel.setBounds(50, 218, 115, 20);
		panel_1.add(lblNomeLabel);

		lblCPFLabel = new JLabel("CPF");
		lblCPFLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPFLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCPFLabel.setBounds(175, 218, 115, 20);
		panel_1.add(lblCPFLabel);

		lblEmailLabel = new JLabel("Usuário");
		lblEmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblEmailLabel.setBounds(715, 218, 115, 20);
		panel_1.add(lblEmailLabel);

		lblSenhaLabel = new JLabel("Senha");
		lblSenhaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSenhaLabel.setBounds(840, 218, 115, 20);
		panel_1.add(lblSenhaLabel);

		lblCargoLabel = new JLabel("Cargo");
		lblCargoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargoLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCargoLabel.setBounds(311, 218, 115, 20);
		panel_1.add(lblCargoLabel);

		lblSalarioLabel = new JLabel("Salário");
		lblSalarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalarioLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSalarioLabel.setBounds(444, 218, 115, 20);
		panel_1.add(lblSalarioLabel);

		lblDataAdmissaoLabel = new JLabel("Data Admissão");
		lblDataAdmissaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataAdmissaoLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDataAdmissaoLabel.setBounds(578, 218, 115, 20);
		panel_1.add(lblDataAdmissaoLabel);

		tabela = new JTable();
		tabela.setFont(new Font("SansSerif", Font.PLAIN, 10));
		tabela.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabela.setToolTipText("");
		tabela.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column",
						"New column" }));
		tabela.setBounds(39, 248, 929, 305);
		panel_1.add(tabela);
	}
}