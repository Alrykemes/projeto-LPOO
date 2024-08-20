package com.managepro.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.managepro.core.model.Funcionario;
import com.managepro.core.model.FuncionarioService;

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
import java.util.List;

public class TelaFuncionarios {

	private void limparCampos() {
	    txtNome.setText("");
	    txtCpf.setText("");
	    txtEmail.setText("");
	    txtSenha.setText("");
	    txtCargo.setText("");
	    // Se houver mais campos, limpar também
	}
	
	private JFrame frmManagePro;
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

	public JFrame getFrame() {
		return this.frmManagePro;
	}
	
	private FuncionarioService funcionarioService;

	public TelaFuncionarios() {
	    this.funcionarioService = new FuncionarioService();
	    initialize();
	}
	
	private void atualizarTabela() {
	    // Limpar a tabela existente
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	    
	    // Aqui você precisará obter todos os funcionários do banco de dados e adicionar à tabela
	    List<Funcionario> funcionarios = funcionarioService.obterTodosFuncionarios();
	    
	    for (Funcionario funcionario : funcionarios) {
	        model.addRow(new Object[]{
	            funcionario.getNome(),
	            funcionario.getCpf(),
	            funcionario.getEmail(),
	            funcionario.getSenha(),
	            funcionario.getCargo(),
	            funcionario.getSalario(),
	            // Adicione aqui mais campos conforme necessário
	        });
	    }
	}

	private void initialize() {
		frmManagePro = new JFrame();
		frmManagePro.setTitle("ManagePro");
		frmManagePro.setBounds(100, 100, 1020, 680);
		frmManagePro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagePro.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1006, 643);
		frmManagePro.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
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
		txtNome.setBounds(20, 66, 132, 25);
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
		txtCpf.setBounds(162, 66, 115, 25);
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
		txtEmail.setBounds(287, 66, 115, 25);
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
		txtSenha.setBounds(412, 66, 115, 25);
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
		txtCargo.setBounds(537, 66, 123, 25);
		panel_1.add(txtCargo);
		txtCargo.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton.setBounds(867, 66, 123, 27);
		panel_1.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Captura os dados dos campos de texto
		        String nome = txtNome.getText().trim();
		        String cpf = txtCpf.getText().trim();
		        String email = txtEmail.getText().trim();
		        String senha = txtSenha.getText().trim();
		        String cargo = txtCargo.getText().trim();
		        double salario = new BigDecimal(0); // Exemplo: você precisará capturar o salário real da interface
		        
		        // Validação dos campos obrigatórios
		        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || senha.isEmpty() || cargo.isEmpty()) {
		            System.out.println("Erro: Todos os campos obrigatórios devem ser preenchidos.");
		            return;
		        }
		        
		        // Criar um objeto Funcionario
		        Funcionario funcionario = new Funcionario(nome, cpf, email, senha, cargo, 0, null, 0);
		        funcionario.setNome(nome);
		        funcionario.setCpf(cpf);
		        funcionario.setEmail(email);
		        funcionario.setSenha(senha);
		        funcionario.setCargo(cargo);
		        funcionario.setSalario(salario);
		        
		        // Tentar adicionar o funcionário usando o serviço
		        boolean sucesso = funcionarioService.adicionarFuncionario(funcionario);
		        if (sucesso) {
		            System.out.println("Funcionário adicionado com sucesso!");
		            atualizarTabela();  // Atualizar a tabela na interface gráfica
		            limparCampos();     // Limpar os campos após a inserção
		        } else {
		            System.out.println("Erro: Funcionário com o mesmo CPF já existe.");
		        }
		        
		        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || senha.isEmpty() || cargo.isEmpty()) {
		            mostrarMensagem("Erro: Todos os campos obrigatórios devem ser preenchidos.");
		            return;
		        }
		        
		        Funcionario funcionario = new Funcionario(nome, cpf, email, senha, cargo, 0, null, 0);
		        funcionario.setNome(nome);
		        funcionario.setCpf(cpf);
		        funcionario.setEmail(email);
		        funcionario.setSenha(senha);
		        funcionario.setCargo(cargo);
		        funcionario.setSalario(salario);
		        
		        try {
		            boolean sucesso1 = FuncionarioService.adicionarFuncionario(funcionario);
		            if (sucesso1) {
		                mostrarMensagem("Funcionário adicionado com sucesso!");
		                atualizarTabela();
		                limparCampos();
		            } else {
		                mostrarMensagem("Erro: Funcionário com o mesmo CPF já existe.");
		            }
		        } catch (Exception ex) {
		            mostrarMensagem("Erro ao adicionar funcionário: " + ex.getMessage());
		        }
		    }

			private void mostrarMensagem(String string) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
		
		JButton btnComeback = new JButton("Voltar   ");
		btnComeback.setIcon(new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		btnComeback.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnComeback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu menu = new TelaMenu();
				getFrame().setVisible(false);
				menu.getFrame().setLocationRelativeTo(null);
				menu.getFrame().setVisible(true);
			}
		});
		btnComeback.setBounds(20, 8, 120, 35);
		panel_1.add(btnComeback);
	}
}