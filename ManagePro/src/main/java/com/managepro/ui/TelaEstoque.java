package com.managepro.ui;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;

import org.apache.velocity.runtime.directive.Parse;

import com.managepro.core.model.Produto;
import com.managepro.core.model.ProdutoVendaDetails;
import com.managepro.core.service.ProdutoService;
import com.thoughtworks.qdox.model.expression.Add;
import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TelaEstoque {

	private JPanel estoquePanel;
	private JFormattedTextField textPesquisaField;
	private JList<Produto> listaProduto;
	private ProdutoService produtoService;
	private Produto produtoSelecionado;
	private JScrollPane scrollPane;
	private JComboBox<String> comboBox;
	private MaskFormatter maskPesquisa;
	private DefaultListModel<Produto> listModel;
	private JDateChooser dateChooser;

	public JPanel getPanel() {
		return this.estoquePanel;
	}
	
	public TelaEstoque() throws ParseException {
		this.initialize();
	}
	
	public void refresh () {
		listaProduto.repaint();
	}
	
	
	private void initialize() throws ParseException{
		
		produtoService = new ProdutoService();
		
		estoquePanel = new JPanel();
		estoquePanel.setSize(1020, 680);
		estoquePanel.setLayout(null);
		
		maskPesquisa = new MaskFormatter("*********");
		maskPesquisa.setValidCharacters("0123456789");
		textPesquisaField = new JFormattedTextField();
		textPesquisaField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textPesquisaField.setBounds(756, 47, 167, 38);
		estoquePanel.add(textPesquisaField);
		
		JButton botaoPesquisa = new JButton("");
		botaoPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("ID")) {
					if (textPesquisaField.getText().matches(".*[a-zA-Z].*")) {
	                    JOptionPane.showMessageDialog(null, "O campo de pesquisa deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
	                }
					else if (textPesquisaField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "O campo de pesquisa deve conter um id válido.", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					else {
						listModel.clear();
						listModel.addAll(produtoService.pesquisarProdutoId(Long.parseLong(textPesquisaField.getText())));
					}
				}
				if (comboBox.getSelectedItem().equals("Nome")) {
					listModel.clear();
					listModel.addAll(produtoService.pesquisarProdutoNome(textPesquisaField.getText()));					
				}
			}
		});
		botaoPesquisa.setIcon(new ImageIcon(TelaEstoque.class.getResource("/com/managepro/assets/LupaIcon.png")));
		botaoPesquisa.setBounds(933, 47, 40, 38);
		estoquePanel.add(botaoPesquisa);
		
		listModel = new DefaultListModel<>();
		listModel.addAll(produtoService.listarProdutos());
		listaProduto = new JList<>(listModel);
		listaProduto.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaProduto.setLocation(10, 5);
		listaProduto.setFont(new Font("SansSerif", Font.PLAIN, 25));
		estoquePanel.add(listaProduto);
		
		scrollPane = new JScrollPane(listaProduto);
		scrollPane.setBounds(20, 165, 960, 374);
		estoquePanel.add(scrollPane);
		
		JButton novoProduto = new JButton("NOVO");
		novoProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		novoProduto.setBounds(256, 47, 131, 45);
		novoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "AdicionarProdutos");
				Janela.getInstance().getFrame().setBounds(0, 0, 700, 500);
				Janela.getInstance().getFrame().setLocationRelativeTo(null);
			}
		});
		estoquePanel.add(novoProduto);
		
		JButton editarProduto = new JButton("EDITAR");
		editarProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		editarProduto.setBounds(408, 47, 131, 45);
		editarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtoSelecionado = listaProduto.getSelectedValue();
				Janela.getInstance().getTelaEditarProdutos().setProdutoSelecionado(produtoSelecionado);
				Janela.getInstance().getTelaEditarProdutos().setNomeProdutoField(produtoSelecionado.getNomeProduto());
				Janela.getInstance().getTelaEditarProdutos().setPrecoVendaField(produtoSelecionado.getPreco().toString());
				Janela.getInstance().getTelaEditarProdutos().setQuantidadeField(Integer.toString(produtoSelecionado.getQuantidade()));
				Janela.getInstance().getTelaEditarProdutos().setMarcaField(produtoSelecionado.getMarca());
				Janela.getInstance().getTelaEditarProdutos().setFornecedorField(produtoSelecionado.getFornecedor());
				Janela.getInstance().getTelaEditarProdutos().setValidadeField(produtoSelecionado.getValidade());
				Janela.getInstance().getTelaEditarProdutos().setCodigoProduto(produtoSelecionado.getCodigoProduto());
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "EditarProdutos");
				Janela.getInstance().getFrame().setBounds(0, 0, 700, 500);
				Janela.getInstance().getFrame().setLocationRelativeTo(null);
			}
		});
		estoquePanel.add(editarProduto);
		
		JButton removerProduto = new JButton("REMOVER");
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(Janela.getInstance().getPanelPrincipal(), "Deseja mesmo remover o(s) produto(s) ?","", JOptionPane.YES_NO_OPTION) == 0 ) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Produto(s) removido.");
				Produto produtoSelecionado = (Produto) listaProduto.getSelectedValue();
				produtoService.removerProduto(produtoSelecionado.getCodigoProduto());
				Janela.getInstance().getTelaEstoque().atualizarEstoque();
			}
			}});
		removerProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		removerProduto.setBounds(566, 47, 131, 45);
		estoquePanel.add(removerProduto);
		
		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {		
				if (comboBox.getSelectedItem().equals("Todos")) {
					atualizarEstoque();
					
				}
			}
		});
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "Nome", "Data de Validade", "Todos"}));
		comboBox.setBounds(830, 89, 93, 22);
		estoquePanel.add(comboBox);
		
		JLabel filtroLabel = new JLabel("Filtrar por:");
		filtroLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		filtroLabel.setBounds(756, 90, 76, 19);
		estoquePanel.add(filtroLabel);
		
		JButton Voltar = new JButton("Voltar   ");
		Voltar.setIcon(new ImageIcon(TelaEstoque.class.getResource("/com/managepro/assets/BackToHome.png")));
		Voltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		Voltar.setBounds(20, 8, 120, 35);
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Menu");
			}
		});
		estoquePanel.add(Voltar);
		
		JButton botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarEstoque();
			}
		});
		botaoAtualizar.setBounds(20, 131, 93, 23);
		estoquePanel.add(botaoAtualizar);
		
		
	}
	
	public void atualizarEstoque () {
		listModel.clear();
		listModel.addAll(produtoService.listarProdutos());
	}
}