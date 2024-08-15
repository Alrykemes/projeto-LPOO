package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class TelaAdicionarCliente{

	private JPanel adicionarProdutoPanel;
	private JTextField textFieldNomeCliente;
	private JFormattedTextField textFieldCPF;
	private JFormattedTextField textFieldNumero;
	private JDateChooser dateChooser;

	public JPanel getPanel() {
		return this.adicionarProdutoPanel;
	}

	public TelaAdicionarCliente() throws ParseException {
		this.initialize();
	}

	private void initialize() throws ParseException {
		adicionarProdutoPanel = new JPanel();
		adicionarProdutoPanel.setSize(500, 500);
		adicionarProdutoPanel.setLayout(null);

		JLabel subTituloTela = new JLabel("Preencha os campos abaixo corretamente *");
		subTituloTela.setFont(new Font("SansSerif", Font.PLAIN, 12));
		subTituloTela.setBounds(10, 35, 268, 14);
		adicionarProdutoPanel.add(subTituloTela);

		JLabel NomeCliente = new JLabel("Nome do Cliente*");
		NomeCliente.setFont(new Font("SansSerif", Font.PLAIN, 16));
		NomeCliente.setBounds(137, 71, 148, 14);
		adicionarProdutoPanel.add(NomeCliente);

		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldNomeCliente.setBounds(137, 96, 217, 35);
		adicionarProdutoPanel.add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);

		JLabel CpfCliente = new JLabel("CPF Cliente*");
		CpfCliente.setFont(new Font("SansSerif", Font.PLAIN, 16));
		CpfCliente.setBounds(137, 142, 121, 14);
		adicionarProdutoPanel.add(CpfCliente);

		
		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setValidCharacters("0123456789");
		maskCpf.setAllowsInvalid(false);
		textFieldCPF = new JFormattedTextField(maskCpf);
		textFieldCPF.setFocusLostBehavior(JFormattedTextField.PERSIST);
		textFieldCPF.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(137, 167, 217, 35);
		adicionarProdutoPanel.add(textFieldCPF);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 400, 500, 63);
		adicionarProdutoPanel.add(panel);
		panel.setLayout(null);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCPF.setText(" ");
				textFieldNomeCliente.setText(null);
				
				dateChooser.setDate(null);
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "NovaVenda");
				Janela.getInstace().getFrame().setBounds(0, 0, 1020, 680);
				Janela.getInstace().getFrame().setLocationRelativeTo(null);
			}
		});
		btnCancelar.setBounds(10, 11, 99, 41);
		panel.add(btnCancelar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "NovaVenda");
				Janela.getInstace().getFrame().setBounds(0, 0, 1020, 680);
				Janela.getInstace().getFrame().setLocationRelativeTo(null);
			}
		});
		btnCadastrar.setBounds(391, 11, 99, 41);
		panel.add(btnCadastrar);

		JLabel DataNascimento = new JLabel("Data de Nascimento *");
		DataNascimento.setFont(new Font("SansSerif", Font.PLAIN, 16));
		DataNascimento.setBounds(137, 284, 158, 14);
		adicionarProdutoPanel.add(DataNascimento);

		JLabel TituloTela = new JLabel("CADASTRAR CLIENTE");
		TituloTela.setFont(new Font("SansSerif", Font.PLAIN, 20));
		TituloTela.setBounds(10, 11, 295, 24);
		adicionarProdutoPanel.add(TituloTela);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(137, 309, 217, 35);
		dateChooser.setFont(new Font("SansSerif", Font.PLAIN, 18));
		adicionarProdutoPanel.add(dateChooser);
		
		JLabel lblNmeroCliente = new JLabel("N\u00FAmero do Cliente*");
		lblNmeroCliente.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNmeroCliente.setBounds(137, 213, 141, 14);
		adicionarProdutoPanel.add(lblNmeroCliente);
		
		MaskFormatter maskNumero = new MaskFormatter("(##)#####-####");
		maskCpf.setValidCharacters("0123456789");
		maskCpf.setAllowsInvalid(false);
		textFieldNumero = new JFormattedTextField(maskNumero);
		textFieldNumero.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(137, 238, 217, 35);
		adicionarProdutoPanel.add(textFieldNumero);
	}
}