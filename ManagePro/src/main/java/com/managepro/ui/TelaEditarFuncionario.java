package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaEditarFuncionario {
	
	private JPanel editarFuncionarioPanel;
	private JLabel tituloTela;
	private JLabel subTituloTela;
	private JLabel txtNome;
	private JTextField campoNome;
	private JLabel txtCpf;
	private JFormattedTextField campoCpf;
	private JLabel txtCargo;
	private JComboBox<String> campoCargo;
	private JLabel txtSalario;
	private JTextField campoSalario;
	private JLabel txtDataAdmissao;
	private JDateChooser dateChooser;
	private JLabel txtUsuario;
	private JTextField campoUsuario;
	private JLabel txtSenha;
	private JTextField campoSenha;
	private JLabel textTelefone;
	private JTextField campoTelefone;
	private JButton botaoCancelar;
	private JButton botaoSalvar;

	public JPanel getPanel() {
		return this.editarFuncionarioPanel;
	} 
	
	public TelaEditarFuncionario( ) throws ParseException {
		this.initialize();
	}
	
	public void initialize() throws ParseException {
		editarFuncionarioPanel = new JPanel();
		editarFuncionarioPanel.setSize(700, 500);
		editarFuncionarioPanel.setLayout(null);
		
		tituloTela = new JLabel("EDITAR FUNCIONÁRIO");
		tituloTela.setFont(new Font("SansSerif", Font.PLAIN, 20));
		tituloTela.setBounds(28, 20, 237, 38);
		editarFuncionarioPanel.add(tituloTela);
		
		subTituloTela = new JLabel("Preencha os campos abaixo corretamente  *");
		subTituloTela.setFont(new Font("SansSerif", Font.PLAIN, 12));
		subTituloTela.setBounds(28, 48, 246, 27);
		editarFuncionarioPanel.add(subTituloTela);
		
		txtNome = new JLabel("Nome:");
		txtNome.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtNome.setBounds(32, 120, 70, 19);
		editarFuncionarioPanel.add(txtNome);

		campoNome = new JTextField();
		campoNome.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoNome.setBounds(31, 150, 170, 35);
		editarFuncionarioPanel.add(campoNome);
		campoNome.setColumns(10);

		txtCpf = new JLabel("CPF:");
		txtCpf.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCpf.setBounds(32, 204, 70, 19);
		editarFuncionarioPanel.add(txtCpf);

		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setValidCharacters("0123456789");
		maskCpf.setAllowsInvalid(false);
		campoCpf = new JFormattedTextField(maskCpf);
		campoCpf.setFont(new Font("SansSerif", Font.PLAIN, 20));
		campoCpf.setText("CPF:");
		campoCpf.setBounds(31, 233, 170, 35);
		editarFuncionarioPanel.add(campoCpf);
		campoCpf.setColumns(10);

		txtCargo = new JLabel("Cargo:");
		txtCargo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCargo.setBounds(256, 120, 70, 19);
		editarFuncionarioPanel.add(txtCargo);

		campoCargo = new JComboBox<>();
		campoCargo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoCargo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "ADMINISTRADOR", "VENDEDOR", "CONTADOR", "ESTOQUISTA", "GERENTE" }));
		campoCargo.setBounds(256, 150, 170, 35);
		editarFuncionarioPanel.add(campoCargo);

		txtSalario = new JLabel("Salário:");
		txtSalario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSalario.setBounds(256, 204, 70, 19);
		editarFuncionarioPanel.add(txtSalario);

		campoSalario = new JTextField();
		campoSalario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoSalario.setBounds(256, 231, 170, 35);
		editarFuncionarioPanel.add(campoSalario);

		txtDataAdmissao = new JLabel("Data Admissão:");
		txtDataAdmissao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtDataAdmissao.setBounds(256, 295, 132, 19);
		editarFuncionarioPanel.add(txtDataAdmissao);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(256, 322, 170, 35);
		dateChooser.setFont(new Font("SansSerif", Font.PLAIN, 18));
		editarFuncionarioPanel.add(dateChooser);

		MaskFormatter maskTelefone = new MaskFormatter("(##)#####-####");
		maskTelefone.setValidCharacters("0123456789");
		maskTelefone.setAllowsInvalid(false);
		campoTelefone = new JFormattedTextField(maskTelefone);
		campoTelefone.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoTelefone.setBounds(31, 322, 170, 35);
		editarFuncionarioPanel.add(campoTelefone);
		campoTelefone.setColumns(10);

		textTelefone = new JLabel("Telefone:");
		textTelefone.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textTelefone.setBounds(32, 290, 94, 29);
		editarFuncionarioPanel.add(textTelefone);

		txtUsuario = new JLabel("Usuário:");
		txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtUsuario.setBounds(491, 158, 70, 19);
		editarFuncionarioPanel.add(txtUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoUsuario.setBounds(491, 194, 180, 38);
		editarFuncionarioPanel.add(campoUsuario);

		txtSenha = new JLabel("Senha:");
		txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSenha.setBounds(491, 251, 70, 19);
		editarFuncionarioPanel.add(txtSenha);

		campoSenha = new JPasswordField();
		campoSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoSenha.setBounds(491, 280, 180, 38);
		editarFuncionarioPanel.add(campoSenha);

		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setFont(new Font("SansSerif", Font.BOLD, 16));
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNome.setText("");
				campoCpf.setText("");
				campoCargo.setSelectedItem("ADMINISTRADOR");
				campoSalario.setText("");
				dateChooser.setDate(null);
				campoTelefone.setText("");
				campoUsuario.setText("");
				campoSenha.setText("");

				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Funcionarios");
				Janela.getInstance().getFrame().setBounds(0, 0, 1020, 680);
				Janela.getInstance().getFrame().setLocationRelativeTo(null);
			}
		});
		botaoCancelar.setBounds(32, 405, 120, 41);
		editarFuncionarioPanel.add(botaoCancelar);
		
		botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoSalvar.setFont(new Font("SansSerif", Font.BOLD, 16));
		botaoSalvar.setBounds(551, 405, 120, 41);
		editarFuncionarioPanel.add(botaoSalvar);
	}
}
