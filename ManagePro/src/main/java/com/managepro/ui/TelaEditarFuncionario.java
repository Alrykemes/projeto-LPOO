package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import com.managepro.core.model.Cargos;
import com.managepro.core.model.Funcionario;
import com.managepro.core.service.FuncionarioService;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TelaEditarFuncionario {

	private JPanel editarFuncionarioPanel;
	private JLabel tituloTela;
	private JLabel subTituloTela;
	private JLabel txtNome;
	private JTextField campoNome;
	private JLabel txtCpf;
	private JFormattedTextField campoCpf;
	private JLabel txtCargo;
	private JComboBox<Cargos> campoCargo;
	private JLabel txtSalario;
	private JTextField campoSalario;
	private JLabel txtDataAdmissao;
	private JDateChooser dateChooser;
	private JLabel txtUsuario;
	private JTextField campoUsuario;
	private JLabel txtSenha;
	private JTextField campoSenha;
	private JLabel txtTelefone;
	private JTextField campoTelefone;
	private JButton botaoCancelar;
	private JButton botaoSalvar;
	private String cpfOriginal;

	public JPanel getPanel() {
		return this.editarFuncionarioPanel;
	}

	public TelaEditarFuncionario() {
		this.initialize();
	}

	public void initialize() {
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
		campoNome.setBounds(28, 149, 180, 35);
		editarFuncionarioPanel.add(campoNome);
		campoNome.setColumns(10);

		txtCpf = new JLabel("CPF:");
		txtCpf.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCpf.setBounds(28, 204, 70, 19);
		editarFuncionarioPanel.add(txtCpf);

		try {
			MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
			maskCpf.setValidCharacters("0123456789");
			maskCpf.setAllowsInvalid(false);
			campoCpf = new JFormattedTextField(maskCpf);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao aplicar a máscara de cpf: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		campoCpf.setFont(new Font("SansSerif", Font.PLAIN, 20));
		campoCpf.setText("CPF:");
		campoCpf.setBounds(28, 233, 180, 35);
		editarFuncionarioPanel.add(campoCpf);
		campoCpf.setColumns(10);

		txtCargo = new JLabel("Cargo:");
		txtCargo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCargo.setBounds(244, 120, 70, 19);
		editarFuncionarioPanel.add(txtCargo);

		campoCargo = new JComboBox<Cargos>(Cargos.values());
		campoCargo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoCargo.setBounds(244, 149, 180, 35);
		editarFuncionarioPanel.add(campoCargo);

		txtSalario = new JLabel("Sal�rio:");
		txtSalario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSalario.setBounds(244, 204, 70, 19);
		editarFuncionarioPanel.add(txtSalario);

		NumberFormat format = new DecimalFormat("#,##0.00");
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(BigDecimal.class);
		formatter.setAllowsInvalid(false);
		formatter.setMinimum(new BigDecimal("0.00"));
		formatter.setMaximum(new BigDecimal("99999999.99"));
		campoSalario = new JFormattedTextField(formatter);
		campoSalario.setColumns(10);
		campoSalario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoSalario.setBounds(244, 234, 180, 35);
		editarFuncionarioPanel.add(campoSalario);

		txtDataAdmissao = new JLabel("Data de Admissão:");
		txtDataAdmissao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtDataAdmissao.setBounds(244, 295, 132, 19);
		editarFuncionarioPanel.add(txtDataAdmissao);

		dateChooser = new JDateChooser();
		JTextField textField = (JTextField) dateChooser.getComponent(1);
		textField.setEditable(false);
		dateChooser.setBounds(244, 322, 180, 35);
		dateChooser.setFont(new Font("SansSerif", Font.PLAIN, 18));
		editarFuncionarioPanel.add(dateChooser);

		txtTelefone = new JLabel("Telefone:");
		txtTelefone.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtTelefone.setBounds(28, 290, 94, 29);
		editarFuncionarioPanel.add(txtTelefone);

		try {
			MaskFormatter maskTelefone = new MaskFormatter("(##)#####-####");
			maskTelefone.setValidCharacters("0123456789");
			maskTelefone.setAllowsInvalid(false);
			campoTelefone = new JFormattedTextField(maskTelefone);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao aplicar a máscara de telefone: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		campoTelefone.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoTelefone.setBounds(28, 322, 180, 35);
		editarFuncionarioPanel.add(campoTelefone);
		campoTelefone.setColumns(10);

		txtUsuario = new JLabel("Usuário:");
		txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtUsuario.setBounds(480, 157, 70, 19);
		editarFuncionarioPanel.add(txtUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoUsuario.setBounds(480, 194, 180, 38);
		editarFuncionarioPanel.add(campoUsuario);

		txtSenha = new JLabel("Senha:");
		txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSenha.setBounds(480, 249, 70, 19);
		editarFuncionarioPanel.add(txtSenha);

		campoSenha = new JPasswordField();
		campoSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoSenha.setBounds(480, 285, 180, 38);
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
				Janela.getInstance().getTelaFuncionarios().carregarFuncionariosNaTabela();
			}
		});
		botaoCancelar.setBounds(32, 405, 120, 41);
		editarFuncionarioPanel.add(botaoCancelar);

		botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate dataAdmissaoLD = null;
				BigDecimal valorSalario = BigDecimal.ZERO;

				try {
					Instant instant = dateChooser.getDate().toInstant();
					dataAdmissaoLD = instant.atZone(ZoneId.systemDefault()).toLocalDate();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Data inválida");
				}

				String valorNome = campoNome.getText();
				String valorCpf = campoCpf.getText();
				Cargos valorCargo = Cargos.valueOf(campoCargo.getSelectedItem().toString());

				try {
					((JFormattedTextField) campoSalario).commitEdit();
					valorSalario = (BigDecimal) ((JFormattedTextField) campoSalario).getValue();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Salário inválido");

				}

				LocalDate valorDataAdmissao = dataAdmissaoLD;
				String valorTelefone = campoTelefone.getText();
				String valorUsuario = campoUsuario.getText();
				String valorSenha = campoSenha.getText();

				FuncionarioService funcionarioS = new FuncionarioService();
				Funcionario funcionario = new Funcionario(valorNome, valorCpf, valorCargo, valorSalario,
						valorDataAdmissao, valorTelefone, valorUsuario, valorSenha);

				try {
					funcionarioS.editarFuncionario(funcionario, cpfOriginal);

					campoNome.setText("");
					campoCpf.setText("");
					campoCargo.setSelectedItem("ADMINISTRADOR");
					((JFormattedTextField) campoSalario).setValue(BigDecimal.ZERO);
					dateChooser.setDate(null);
					campoTelefone.setText("");
					campoUsuario.setText("");
					campoSenha.setText("");

					Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Funcionários");
					Janela.getInstance().getFrame().setBounds(0, 0, 1020, 680);
					Janela.getInstance().getFrame().setLocationRelativeTo(null);
					Janela.getInstance().getTelaFuncionarios().carregarFuncionariosNaTabela();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(Janela.getInstance().getFrame(),
							"Erro ao editar funcionário, tente novamente mais tarde", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		botaoSalvar.setFont(new Font("SansSerif", Font.BOLD, 16));
		botaoSalvar.setBounds(542, 405, 120, 41);
		editarFuncionarioPanel.add(botaoSalvar);
	}

	public void setCampos(Funcionario funcionario) {
		cpfOriginal = funcionario.getCpf();

		// Convertendo de LocalDate para Date;
		LocalDateTime localDateTime = funcionario.getDataAdmissao().atStartOfDay();
		Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
		Date dateAdmissao = Date.from(instant);

		campoNome.setText(funcionario.getNome());
		campoCpf.setText(funcionario.getCpf());
		((JFormattedTextField) campoSalario).setValue(funcionario.getSalario());
		campoCargo.setSelectedItem(Cargos.valueOf(funcionario.getFuncao().toString()));
		dateChooser.setDate(dateAdmissao);
		campoTelefone.setText(funcionario.getTelefone());
		campoUsuario.setText(funcionario.getUsuario());
		campoSenha.setText(funcionario.getSenha());
	}
}
