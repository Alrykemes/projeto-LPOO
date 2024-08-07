package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class TelaEstoque {

	private JPanel estoquePanel;
	private JTextField textField;

	public JPanel getPanel() {
		return this.estoquePanel;
	}
	
	public TelaEstoque() {
		this.initialize();
	}
	
	private void initialize() {
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
		novoProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		novoProduto.setBounds(256, 47, 131, 45);
		novoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "AdicionarProdutos");
				Janela.getInstace().getFrame().setBounds(0, 0, 700, 500);
				Janela.getInstace().getFrame().setLocationRelativeTo(null);
			}
		});
		estoquePanel.add(novoProduto);
		
		JButton editarProduto = new JButton("EDITAR");
		editarProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		editarProduto.setBounds(408, 47, 131, 45);
		editarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "EditarProdutos");
				Janela.getInstace().getFrame().setBounds(0, 0, 700, 500);
				Janela.getInstace().getFrame().setLocationRelativeTo(null);
			}
		});
		estoquePanel.add(editarProduto);
		
		JButton removerProduto = new JButton("REMOVER");
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(removerProduto, "Deseja mesmo remover o(s) produto(s) ?","", JOptionPane.YES_NO_OPTION) == 0 ) {
				JOptionPane.showMessageDialog(removerProduto, "Produto(s) removido.");
			}
			}});
		removerProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		removerProduto.setBounds(566, 47, 131, 45);
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
		
		
		botaoPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, textField.getText());
			}
		});
		
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
		
	}
}