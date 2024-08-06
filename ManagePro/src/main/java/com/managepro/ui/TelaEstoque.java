package com.managepro.ui;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	private JFrame frmManagePro;
	private JPanel panel;
	private JTextField campoTexto;

	public JFrame getFrame() {
		return this.frmManagePro;
	}
	
	public TelaEstoque() {
		this.initialize();
	}
	
	private void initialize() {
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
		novoProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		novoProduto.setBounds(256, 47, 131, 45);
		novoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarProdutos telaAddProdutos = new TelaAdicionarProdutos();
				telaAddProdutos.getFrame().setVisible(true);
			}
		});
		panel.add(novoProduto);
		
		Botao editarProduto = new Botao("EDITAR");
		editarProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		editarProduto.setBounds(408, 47, 131, 45);
		editarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEditarProdutos telaEditar = new TelaEditarProdutos();
				telaEditar.getFrame().setVisible(true);
			}
		});
		panel.add(editarProduto);
		
		Botao removerProduto = new Botao("REMOVER");
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(removerProduto, "Deseja mesmo remover o(s) produto(s) ?","", JOptionPane.YES_NO_OPTION) == 0 ) {
				JOptionPane.showMessageDialog(removerProduto, "Produto(s) removido.");
			}
			}});
		removerProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		removerProduto.setBounds(566, 47, 131, 45);
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
		
		Botao botaoPesquisa = new Botao("");
		botaoPesquisa.setIcon(new ImageIcon(TelaEstoque.class.getResource("/com/managepro/assets/LupaIcon.png")));
		botaoPesquisa.setBounds(933, 47, 40, 38);
		panel.add(botaoPesquisa);
		
		botaoPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, campoTexto.getText());
			}
		});
		
		JList<?> list = new JList<>();
		list.setFont(new Font("SansSerif", Font.PLAIN, 11));
		list.setBounds(20, 165, 960, 374);
		panel.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(966, 166, 14, 373);
		panel.add(scrollPane);
		
	}
}