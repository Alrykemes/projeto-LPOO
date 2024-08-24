package com.managepro.ui;

import javax.swing.JPanel;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import com.managepro.core.model.Cargos;
import com.managepro.core.model.Funcionario;
import com.managepro.core.service.FuncionarioService;
import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.swing.JComboBox;

public class TelaFuncionarios {

	private JPanel funcionariosPanel;
	private JTextField campoNome;
	private JFormattedTextField campoCpf;
	private JComboBox<Cargos> campoCargo;
	private JTable tabela;
	private JTextField campoUsuario;
	private JTextField campoSenha;
	private JLabel txtCpf;
	private JLabel txtCargo;
	private JLabel txtSalario;
	private JLabel txtDataAdmissao;
	private JLabel txtUsuario;
	private JLabel txtSenha;
	private JDateChooser dateChooser;
	private JTextField campoTelefone;
	private JFormattedTextField campoSalario;
	private JButton botaoRemoverFuncionario;
	private Funcionario funcionario;

	public JPanel getPanel() {
		return this.funcionariosPanel;
	}

	public TelaFuncionarios() {
		initialize();
	}

	private void initialize() {
		funcionariosPanel = new JPanel();
		funcionariosPanel.setSize(1020, 680);
		funcionariosPanel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLocation(7, 1);
		panel_1.setSize(1006, 643);
		funcionariosPanel.add(panel_1);
		panel_1.setLayout(null);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setIcon(
				new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		botaoVoltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNome.setText("");
				campoCpf.setText("");
				campoCargo.setSelectedItem(Cargos.ADMINISTRADOR);
				campoSalario.setValue(BigDecimal.ZERO);
				dateChooser.setDate(null);
				campoTelefone.setText("");
				campoUsuario.setText("");
				campoSenha.setText("");
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
		campoCpf.setBounds(211, 82, 180, 38);
		panel_1.add(campoCpf);
		campoCpf.setColumns(10);

		txtCargo = new JLabel("Cargo:");
		txtCargo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCargo.setBounds(401, 59, 70, 19);
		panel_1.add(txtCargo);

		campoCargo = new JComboBox<Cargos>(Cargos.values());
		campoCargo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoCargo.setBounds(401, 83, 180, 38);
		panel_1.add(campoCargo);

		txtSalario = new JLabel("Salário:");
		txtSalario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSalario.setBounds(591, 59, 70, 19);
		panel_1.add(txtSalario);

		NumberFormat format = new DecimalFormat("#,##0.00");
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(BigDecimal.class);
		formatter.setAllowsInvalid(false);
		formatter.setMinimum(new BigDecimal("0.00"));
		formatter.setMaximum(new BigDecimal("99999999.99"));
		campoSalario = new JFormattedTextField(formatter);
		campoSalario.setColumns(10);
		campoSalario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoSalario.setBounds(591, 82, 180, 38);
		panel_1.add(campoSalario);

		txtDataAdmissao = new JLabel("Data Admissão:");
		txtDataAdmissao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtDataAdmissao.setBounds(20, 130, 132, 19);
		panel_1.add(txtDataAdmissao);

		dateChooser = new JDateChooser();
		JTextField textField = (JTextField) dateChooser.getComponent(1);
		textField.setEditable(false);
		dateChooser.setBounds(21, 155, 180, 38);
		dateChooser.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel_1.add(dateChooser);

		JLabel textTelefone = new JLabel("Telefone:");
		textTelefone.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textTelefone.setBounds(211, 136, 45, 13);
		panel_1.add(textTelefone);

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
		campoTelefone.setBounds(211, 155, 180, 38);
		panel_1.add(campoTelefone);
		campoTelefone.setColumns(10);

		txtUsuario = new JLabel("Usuário:");
		txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtUsuario.setBounds(401, 130, 70, 19);
		panel_1.add(txtUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoUsuario.setColumns(10);
		campoUsuario.setBounds(401, 155, 180, 38);
		panel_1.add(campoUsuario);

		txtSenha = new JLabel("Senha:");
		txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSenha.setBounds(591, 130, 70, 19);
		panel_1.add(txtSenha);

		campoSenha = new JPasswordField();
		campoSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoSenha.setColumns(10);
		campoSenha.setBounds(591, 155, 180, 38);
		panel_1.add(campoSenha);

		JButton botaoAdicionarFuncionario = new JButton("Adicionar");
		botaoAdicionarFuncionario.setBackground(new Color(255, 255, 255));
		botaoAdicionarFuncionario.setFont(new Font("SansSerif", Font.BOLD, 20));
		botaoAdicionarFuncionario.setBounds(797, 77, 170, 40);
		panel_1.add(botaoAdicionarFuncionario);

		botaoAdicionarFuncionario.addActionListener(new ActionListener() {
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
					campoSalario.commitEdit();
					valorSalario = (BigDecimal) campoSalario.getValue();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Salário inválido");

				}

				LocalDate valorDataAdmissao = dataAdmissaoLD;
				String valorTelefone = campoTelefone.getText();
				String valorUsuario = campoUsuario.getText();
				String valorSenha = campoSenha.getText();

				FuncionarioService funcionarioS = new FuncionarioService();
				funcionario = new Funcionario(valorNome, valorCpf, valorCargo, valorSalario, valorDataAdmissao,
						valorTelefone, valorUsuario, valorSenha);

				try {
					funcionarioS.criarFuncionario(funcionario);

					campoNome.setText("");
					campoCpf.setText("");
					campoCargo.setSelectedItem("ADMINISTRADOR");
					campoSalario.setValue(BigDecimal.ZERO);
					dateChooser.setDate(null);
					campoTelefone.setText("");
					campoUsuario.setText("");
					campoSenha.setText("");

					carregarFuncionariosNaTabela();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(Janela.getInstance().getFrame(),
							"Erro ao cadastrar funcionário, tente novamente mais tarde", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		botaoRemoverFuncionario = new JButton("Remover");
		botaoRemoverFuncionario.setForeground(new Color(0, 0, 0));
		botaoRemoverFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		botaoRemoverFuncionario.setFont(new Font("SansSerif", Font.BOLD, 20));
		botaoRemoverFuncionario.setBackground(new Color(255, 255, 255));
		botaoRemoverFuncionario.setBounds(525, 269, 170, 40);
		panel_1.add(botaoRemoverFuncionario);

		JButton botaoEditarFuncionario = new JButton("Editar");
		botaoEditarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tabela.getSelectedRow();
				if (linhaSelecionada != -1) {
					FuncionarioService funcionarioService = new FuncionarioService();
					List<Funcionario> funcionarios = funcionarioService.obterTodosFuncionarios();

					Janela.getInstance().getTelaEditarFuncionario().setCampos(funcionarios.get(linhaSelecionada));
					Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(),
							"EditarFuncionario");
					Janela.getInstance().getFrame().setBounds(0, 0, 700, 500);
					Janela.getInstance().getFrame().setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(Janela.getInstance().getFrame(),
							"Selecione um funcionário na tabela abaixo", "Nenhuma seleção",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		botaoEditarFuncionario.setBackground(new Color(255, 255, 255));
		botaoEditarFuncionario.setFont(new Font("SansSerif", Font.BOLD, 20));
		botaoEditarFuncionario.setBounds(274, 269, 170, 40);
		panel_1.add(botaoEditarFuncionario);

		tabela = new JTable();
		tabela.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tabela.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabela.setToolTipText("");
		tabela.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null } },
				new String[] { "Nome", "CPF", "Cargo", "Salário", "Data Admissão", "Telefone", "Usuário", "Senha" }));
		tabela.setBounds(50, 248, 930, 200);

		JTableHeader tableHeader = tabela.getTableHeader();
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 17));

		tabela.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setLocation(10, 335);
		scrollPane.setSize(986, 200);

		panel_1.add(scrollPane);

		carregarFuncionariosNaTabela();
	}

	public void carregarFuncionariosNaTabela() {
		try {
			FuncionarioService funcionarioService = new FuncionarioService();
			List<Funcionario> funcionarios = funcionarioService.obterTodosFuncionarios();

			DefaultTableModel model = (DefaultTableModel) tabela.getModel();
			model.setRowCount(0);

			for (Funcionario funcionario : funcionarios) {
				model.addRow(new Object[] { funcionario.getNome(), funcionario.getCpf(), funcionario.getFuncao(),
						funcionario.getSalario(), funcionario.getDataAdmissao(), funcionario.getTelefone(),
						funcionario.getUsuario(), funcionario.getSenha() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(),
					"Erro ao inserir funcionários na tabela, tente novamente mais tarde", "Erro",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}