package com.managepro.ui;

import javax.swing.JPanel;
import com.managepro.core.model.Produto;
import com.managepro.core.service.ProdutoService;
import com.managepro.exceptions.ExcecaoDeNegocios;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.awt.event.ItemEvent;

public class TelaEstoque {

	private JPanel estoquePanel;
	private JFormattedTextField textPesquisaField;
	private JTable listaProduto;
	private ProdutoService produtoService;
	@SuppressWarnings("unused")
	private Produto produtoSelecionado;
	private JScrollPane scrollPane;
	private JComboBox<String> comboBox;
	private MaskFormatter maskPesquisa;
	@SuppressWarnings("unused")
	private JDateChooser dateChooser;
	private JDateChooser dataValidade;

	public JTable getTableProdutos() {
		return this.listaProduto;
	}
	
	public JPanel getPanel() {
		return this.estoquePanel;
	}

	public TelaEstoque() throws ParseException {
		this.initialize();
	}

	private void initialize() throws ParseException {

		produtoService = new ProdutoService();

		estoquePanel = new JPanel();
		estoquePanel.setSize(1020, 680);
		estoquePanel.setLayout(null);

		maskPesquisa = new MaskFormatter("**************************");
		textPesquisaField = new JFormattedTextField(maskPesquisa);
		textPesquisaField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textPesquisaField.setBounds(756, 47, 167, 38);
		estoquePanel.add(textPesquisaField);
		textPesquisaField.setText("");

		JButton botaoPesquisa = new JButton("");
		botaoPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("ID")) {
					if (textPesquisaField.getText().matches(".*[a-zA-Z].*")) {
						JOptionPane.showMessageDialog(null, "O campo de pesquisa deve conter apenas números.", "Erro",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (textPesquisaField.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "O campo de pesquisa deve conter um id válido.", "Erro",
								JOptionPane.ERROR_MESSAGE);
					} else
						try {
							if (produtoService
									.getProductById(Long.valueOf(textPesquisaField.getText().trim())) == null) {
								JOptionPane.showMessageDialog(null, "O campo de pesquisa deve conter um id válido.",
										"Erro", JOptionPane.ERROR_MESSAGE);
							} else {
								tabelaId(Long.valueOf(textPesquisaField.getText().trim()));

							}
						} catch (ExcecaoDoSistema e1) {
							JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e1.getMessage(), "Erro",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
				}
				if (comboBox.getSelectedItem().equals("Nome")) {
					if (textPesquisaField.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "O campo de pesquisa deve conter um nome válido.", "Erro",
								JOptionPane.ERROR_MESSAGE);
					} else
						try {
							if (produtoService.pesquisarProdutoPorNome(textPesquisaField.getText().trim()) == null) {
								JOptionPane.showMessageDialog(null, "O campo de pesquisa deve conter um nome válido.",
										"Erro", JOptionPane.ERROR_MESSAGE);
							} else {
								tabelaNome(textPesquisaField.getText().trim());
							}
						} catch (ExcecaoDoSistema e1) {
							JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e1.getMessage(), "Erro",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
				}
				if (comboBox.getSelectedItem().equals("Data de Validade")) {
					if (dataValidade.getDate() == null) {
						JOptionPane.showMessageDialog(null, "Selecione uma data, para prosseguir.", "Erro",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						Instant dataInstant = dataValidade.getDate().toInstant();
						LocalDate validade = dataInstant.atZone(ZoneId.systemDefault()).toLocalDate();
						try {
							tabelaValidade(validade);
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		botaoPesquisa.setIcon(new ImageIcon(TelaEstoque.class.getResource("/com/managepro/assets/LupaIcon.png")));
		botaoPesquisa.setBounds(933, 47, 40, 38);
		estoquePanel.add(botaoPesquisa);

		listaProduto = new JTable();
		listaProduto.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaProduto.setLocation(10, 5);
		listaProduto.setFont(new Font("SansSerif", Font.PLAIN, 14));
		estoquePanel.add(listaProduto);

		scrollPane = new JScrollPane(listaProduto);
		scrollPane.setBounds(20, 165, 960, 374);
		estoquePanel.add(scrollPane);

		JButton novoProduto = new JButton("NOVO");
		novoProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		novoProduto.setBounds(256, 47, 131, 45);
		novoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(),
						"AdicionarProdutos");
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
				int selectedRow = listaProduto.getSelectedRow();
				if (listaProduto.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione o produto que deseja editar!", "Erro",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					Long codigoProduto = (Long) listaProduto.getValueAt(selectedRow, 0);
					String nomeProduto = (String) listaProduto.getValueAt(selectedRow, 1);
					String fornecedor = (String) listaProduto.getValueAt(selectedRow, 2);
					Integer quantidade = (Integer) listaProduto.getValueAt(selectedRow, 3);
					String marca = (String) listaProduto.getValueAt(selectedRow, 4);
					BigDecimal preco = (BigDecimal) listaProduto.getValueAt(selectedRow, 5);
					LocalDate validade = (LocalDate) listaProduto.getValueAt(selectedRow, 6);
					Produto produto = new Produto();
					produto.setCodigoProduto(codigoProduto);
					produto.setNomeProduto(nomeProduto);
					produto.setFornecedor(fornecedor);
					produto.setQuantidade(quantidade);
					produto.setMarca(marca);
					produto.setPreco(preco);
					produto.setValidade(validade);
					Produto produtoSelecionado = produto;
					Janela.getInstance().getTelaEditarProdutos().setProdutoSelecionado(produtoSelecionado);
					Janela.getInstance().getTelaEditarProdutos()
							.setNomeProdutoField(produtoSelecionado.getNomeProduto());
					Janela.getInstance().getTelaEditarProdutos()
							.setPrecoVendaField(produtoSelecionado.getPreco().toString());
					Janela.getInstance().getTelaEditarProdutos()
							.setQuantidadeField(Integer.toString(produtoSelecionado.getQuantidade()));
					Janela.getInstance().getTelaEditarProdutos().setMarcaField(produtoSelecionado.getMarca());
					Janela.getInstance().getTelaEditarProdutos().setFornecedorField(produtoSelecionado.getFornecedor());
					Janela.getInstance().getTelaEditarProdutos().setValidadeField(produtoSelecionado.getValidade());
					Janela.getInstance().getTelaEditarProdutos()
							.setCodigoProduto(produtoSelecionado.getCodigoProduto());
					Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(),
							"EditarProdutos");
					Janela.getInstance().getFrame().setBounds(0, 0, 700, 500);
					Janela.getInstance().getFrame().setLocationRelativeTo(null);
				}
			}
		});
		estoquePanel.add(editarProduto);

		JButton removerProduto = new JButton("REMOVER");
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaProduto.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione o produto que deseja remover!", "Erro",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (JOptionPane.showConfirmDialog(Janela.getInstance().getPanelPrincipal(),
							"Deseja mesmo remover o(s) produto(s) ?", "", JOptionPane.YES_NO_OPTION) == 0) {
						JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Produto(s) removido.");
						int selectedRow = listaProduto.getSelectedRow();
						Long codigoProduto = (Long) listaProduto.getValueAt(selectedRow, 0);
						String nomeProduto = (String) listaProduto.getValueAt(selectedRow, 1);
						String fornecedor = (String) listaProduto.getValueAt(selectedRow, 2);
						Integer quantidade = (Integer) listaProduto.getValueAt(selectedRow, 3);
						String marca = (String) listaProduto.getValueAt(selectedRow, 4);
						BigDecimal preco = (BigDecimal) listaProduto.getValueAt(selectedRow, 5);
						LocalDate validade = (LocalDate) listaProduto.getValueAt(selectedRow, 6);
						Produto produto = new Produto();
						produto.setCodigoProduto(codigoProduto);
						produto.setNomeProduto(nomeProduto);
						produto.setFornecedor(fornecedor);
						produto.setQuantidade(quantidade);
						produto.setMarca(marca);
						produto.setPreco(preco);
						produto.setValidade(validade);
						Produto produtoSelecionado = produto;
						try {
							produtoService.removerProduto(produtoSelecionado.getCodigoProduto());
						} catch (ExcecaoDoSistema e1) {
							JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e1.getMessage(), "Erro",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
						atualizarTabela();
					}
				}
			}
		});
		removerProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		removerProduto.setBounds(566, 47, 131, 45);
		estoquePanel.add(removerProduto);

		dataValidade = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dataValidade.getDateEditor();
		editor.setEditable(false);
		dataValidade.setBounds(756, 47, 167, 38);
		estoquePanel.add(dataValidade);
		dataValidade.setVisible(false);

		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedItem().equals("ID")) {
					textPesquisaField.setText("");
					textPesquisaField.setVisible(true);
					dataValidade.setVisible(false);
				}
				if (comboBox.getSelectedItem().equals("Nome")) {
					textPesquisaField.setText("");
					textPesquisaField.setVisible(true);
					dataValidade.setVisible(false);
				}
				if (comboBox.getSelectedItem().equals("Data de Validade")) {
					textPesquisaField.setVisible(false);
					dataValidade.setVisible(true);
				}
				if (comboBox.getSelectedItem().equals("Todos")) {
					textPesquisaField.setText("");
					atualizarTabela();
				}
			}
		});
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "ID", "Nome", "Data de Validade" }));
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
				if (comboBox.getSelectedItem().equals("Todos")) {
					atualizarTabela();
				}
				if (comboBox.getSelectedItem().equals("ID")) {
					tabelaId(Long.valueOf(textPesquisaField.getText().trim()));
				}
				if (comboBox.getSelectedItem().equals("Nome")) {
					tabelaNome(textPesquisaField.getText().trim());
				}
				if (comboBox.getSelectedItem().equals("Data de Validade")) {
					Instant dataInstant = dataValidade.getDate().toInstant();
					LocalDate validade = dataInstant.atZone(ZoneId.systemDefault()).toLocalDate();
					try {
						tabelaValidade(validade);
					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e1.getMessage(), "Erro",
								JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
		});
		botaoAtualizar.setBounds(20, 131, 93, 23);
		estoquePanel.add(botaoAtualizar);

	}

	public DefaultTableModel atualizarTudo() {

		List<Produto> produtos = null;
		try {
			produtos = produtoService.listarProdutos();
		} catch (ExcecaoDoSistema | ExcecaoDeNegocios e1) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e1.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		Object[][] dados = new Object[produtos.size()][7];
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			dados[i][0] = produto.getCodigoProduto();
			dados[i][1] = produto.getNomeProduto();
			dados[i][2] = produto.getFornecedor();
			dados[i][3] = produto.getQuantidade();
			dados[i][4] = produto.getMarca();
			dados[i][5] = produto.getPreco();
			dados[i][6] = produto.getValidade();
		}
		String[] nomeColuna = { "Código", "Nome", "Fornecedor", "Quantidade", "Marca", "Preço", "Data de Validade" };
		DefaultTableModel tabelaAtualizada = new DefaultTableModel(dados, nomeColuna);
		return tabelaAtualizada;
	}

	public void tabelaId(Long id) {

		List<Produto> produtos = null;
		try {
			produtos = produtoService.pesquisarProdutoPorId(id);
		} catch (ExcecaoDoSistema e1) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e1.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		Object[][] dados = new Object[produtos.size()][7];
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			dados[i][0] = produto.getCodigoProduto();
			dados[i][1] = produto.getNomeProduto();
			dados[i][2] = produto.getFornecedor();
			dados[i][3] = produto.getQuantidade();
			dados[i][4] = produto.getMarca();
			dados[i][5] = produto.getPreco();
			dados[i][6] = produto.getValidade();
		}
		String[] nomeColuna = { "Código", "Nome", "Fornecedor", "Quantidade", "Marca", "Preço", "Data de Validade" };
		DefaultTableModel tabelaAtualizada = new DefaultTableModel(dados, nomeColuna);
		listaProduto.setModel(tabelaAtualizada);
	}

	public void tabelaNome(String Nome) {

		List<Produto> produtos = null;
		try {
			produtos = produtoService.pesquisarProdutoPorNome(Nome);
		} catch (ExcecaoDoSistema e1) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e1.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		Object[][] dados = new Object[produtos.size()][7];
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			dados[i][0] = produto.getCodigoProduto();
			dados[i][1] = produto.getNomeProduto();
			dados[i][2] = produto.getFornecedor();
			dados[i][3] = produto.getQuantidade();
			dados[i][4] = produto.getMarca();
			dados[i][5] = produto.getPreco();
			dados[i][6] = produto.getValidade();
		}
		String[] nomeColuna = { "Código", "Nome", "Fornecedor", "Quantidade", "Marca", "Preço", "Data de Validade" };
		DefaultTableModel tabelaAtualizada = new DefaultTableModel(dados, nomeColuna);
		listaProduto.setModel(tabelaAtualizada);
	}

	public void tabelaValidade(LocalDate date) throws ClassNotFoundException, SQLException {

		List<Produto> produtos = null;
		try {
			produtos = produtoService.pesquisarProdutoValidade(date);
		} catch (ExcecaoDoSistema e1) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e1.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		Object[][] dados = new Object[produtos.size()][7];
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			dados[i][0] = produto.getCodigoProduto();
			dados[i][1] = produto.getNomeProduto();
			dados[i][2] = produto.getFornecedor();
			dados[i][3] = produto.getQuantidade();
			dados[i][4] = produto.getMarca();
			dados[i][5] = produto.getPreco();
			dados[i][6] = produto.getValidade();
		}
		String[] nomeColuna = { "Código", "Nome", "Fornecedor", "Quantidade", "Marca", "Preço", "Data de Validade" };
		DefaultTableModel tabelaAtualizada = new DefaultTableModel(dados, nomeColuna);
		listaProduto.setModel(tabelaAtualizada);
	}

	public void atualizarTabela() {
		listaProduto.setModel(atualizarTudo());
	}
}