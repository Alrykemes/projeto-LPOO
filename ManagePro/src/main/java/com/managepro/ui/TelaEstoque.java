package com.managepro.ui;

<<<<<<< HEAD
import javax.swing.JFrame;

=======
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class TelaEstoque {

<<<<<<< HEAD
	private JFrame frmManagePro;
	private JPanel panel;
	private JTextField campoTexto;
=======
	private JPanel estoquePanel;
	private JTextField textField;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712

	public JPanel getPanel() {
		return this.estoquePanel;
	}
	
	public TelaEstoque() {
		this.initialize();
	}
	
	private void initialize() {
<<<<<<< HEAD
		frmManagePro = new JFrame();
		frmManagePro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaEstoque.class.getResource("/com/managepro/assets/manageIcon.png")));
		frmManagePro.setResizable(false);
		frmManagePro.setLocationRelativeTo(null);
		frmManagePro.setTitle("ManagePro");
		frmManagePro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagePro.setBounds(100, 100, 1024, 680);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		frmManagePro.setContentPane(panel);
		
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
		
		Botao novoProduto = new Botao("NOVO");
=======
		estoquePanel = new JPanel();
		estoquePanel.setSize(1020, 680);
		estoquePanel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField.setBounds(756, 47, 167, 38);
		estoquePanel.add(textField);
		textField.setColumns(10);
		
		JButton botaoPesquisa = new JButton("");
		botaoPesquisa.setIcon(new ImageIcon(TelaEstoque.class.getResource("/com/managepro/assets/LupaIcon.png")));
		botaoPesquisa.setBounds(933, 47, 40, 38);
		estoquePanel.add(botaoPesquisa);
		
		JList<?> list = new JList<>();
		list.setFont(new Font("SansSerif", Font.PLAIN, 11));
		list.setBounds(20, 165, 960, 374);
		estoquePanel.add(list);
		
		JButton novoProduto = new JButton("NOVO");
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		novoProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		novoProduto.setBounds(256, 47, 131, 45);
		novoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "AdicionarProdutos");
				Janela.getInstace().getFrame().setBounds(0, 0, 700, 500);
				Janela.getInstace().getFrame().setLocationRelativeTo(null);
			}
		});
<<<<<<< HEAD
		panel.add(novoProduto);
=======
		estoquePanel.add(novoProduto);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		Botao editarProduto = new Botao("EDITAR");
		editarProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		editarProduto.setBounds(408, 47, 131, 45);
		editarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "EditarProdutos");
				Janela.getInstace().getFrame().setBounds(0, 0, 700, 500);
				Janela.getInstace().getFrame().setLocationRelativeTo(null);
			}
		});
<<<<<<< HEAD
		panel.add(editarProduto);
=======
		estoquePanel.add(editarProduto);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		Botao removerProduto = new Botao("REMOVER");
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(removerProduto, "Deseja mesmo remover o(s) produto(s) ?","", JOptionPane.YES_NO_OPTION) == 0 ) {
				JOptionPane.showMessageDialog(removerProduto, "Produto(s) removido.");
			}
			}});
		removerProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		removerProduto.setBounds(566, 47, 131, 45);
<<<<<<< HEAD
		panel.add(removerProduto);
		
		campoTexto = new JTextField();
		campoTexto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		campoTexto.setBounds(756, 47, 167, 38);
		panel.add(campoTexto);
		campoTexto.setColumns(10);
		
		JLabel labelFiltro = new JLabel("Filtrar por:");
		labelFiltro.setFont(new Font("SansSerif", Font.PLAIN, 16));
		labelFiltro.setBounds(756, 90, 76, 19);
		panel.add(labelFiltro);
		
		ComboBox<String> filtrar = new ComboBox<String>();
		filtrar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		filtrar.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Nome"}));
		filtrar.setBounds(830, 89, 93, 22);
		panel.add(filtrar);
=======
		estoquePanel.add(removerProduto);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Nome"}));
		comboBox.setBounds(830, 89, 93, 22);
		estoquePanel.add(comboBox);
		
		JLabel filtroLabel = new JLabel("Filtrar por:");
		filtroLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		filtroLabel.setBounds(756, 90, 76, 19);
		estoquePanel.add(filtroLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(966, 166, 14, 373);
		estoquePanel.add(scrollPane);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		Botao botaoPesquisa = new Botao("");
		botaoPesquisa.setIcon(new ImageIcon(TelaEstoque.class.getResource("/com/managepro/assets/LupaIcon.png")));
		botaoPesquisa.setBounds(933, 47, 40, 38);
		panel.add(botaoPesquisa);
		
		botaoPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, campoTexto.getText());
			}
		});
		
<<<<<<< HEAD
		JList<?> list = new JList<>();
		list.setFont(new Font("SansSerif", Font.PLAIN, 11));
		list.setBounds(20, 165, 960, 374);
		panel.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(966, 166, 14, 373);
		panel.add(scrollPane);
=======
		JButton btnNewButton = new JButton("Voltar   ");
		btnNewButton.setIcon(new ImageIcon(TelaEstoque.class.getResource("/com/managepro/assets/BackToHome.png")));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(20, 8, 120, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Menu");
			}
		});
		estoquePanel.add(btnNewButton);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
	}
}