package com.managepro.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.managepro.core.model.ProdutoVendaDetails;
import com.managepro.core.model.Venda;
import com.managepro.core.service.VendaService;
import com.managepro.exceptions.ExcecaoDeNegocios;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.toedter.calendar.JDateChooser;

public class TelaGerenciamentoDeVendas {

	private JPanel gerenciamentoVendasPanel;
	private JPanel PrincipalPanel;
	private JPanel pesquisaPanel;
	private JFormattedTextField FieldPesquisar;
	private JButton btnPesquisaVenda;
	private JDateChooser dateChooserDe;
	private JDateChooser dateChooserAte;
	private JComboBox<String> ComboBoxFiltro;
	private JList<Venda> listaVendas;
	private JPanel vendaPanel;
	private JList<ProdutoVendaDetails> listaProdutos;
	private JLabel textDateDe;
	private JLabel textDateAte;
	private JButton buttonNotaFiscal;
	private JLabel funcionarioNome;
	private JLabel idVenda;
	private JLabel data;
    private DateTimeFormatter formatoData;
	private JLabel metodoPagamento;
	private JLabel clienteNome;
	private JLabel cpfCliente;
	private JButton btnDeletar;
	private JLabel totalCompra;
	private DefaultListModel<Venda> listModelVendas;
	private DefaultListModel<ProdutoVendaDetails> listModelProdutos;
	
	private VendaService vendaService;
	

	public JPanel getPanel() {
		return this.gerenciamentoVendasPanel;
	}
	
	public TelaGerenciamentoDeVendas() throws ParseException {
		initialize();
	}
		
	private void initialize() throws ParseException {
		vendaService = new VendaService();
		formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		listModelVendas = new DefaultListModel<>();
		listModelProdutos = new DefaultListModel<>();
		
		gerenciamentoVendasPanel = new JPanel();
		gerenciamentoVendasPanel.setSize(1020, 680);
		gerenciamentoVendasPanel.setLayout(null);
		PrincipalPanel = new JPanel();
		PrincipalPanel.setLocation(0, 0);
		PrincipalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		PrincipalPanel.setSize(1020, 680);
		gerenciamentoVendasPanel.add(PrincipalPanel);
		PrincipalPanel.setLayout(null);
		
		pesquisaPanel = new JPanel();
		pesquisaPanel.setBounds(10, 45, 392, 585);
		PrincipalPanel.add(pesquisaPanel);
		pesquisaPanel.setLayout(null);
		
		JLabel txtPesquisar = new JLabel("Pesquisar");
		txtPesquisar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtPesquisar.setBounds(10, 11, 85, 20);
		pesquisaPanel.add(txtPesquisar);
		
		JLabel txtFiltrar = new JLabel("Filtrar:");
		txtFiltrar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtFiltrar.setBounds(211, 11, 52, 20);
		pesquisaPanel.add(txtFiltrar);
		
		MaskFormatter maskPesquisa = new MaskFormatter("**********");
		maskPesquisa.setValidCharacters("0123456789");
		maskPesquisa.setAllowsInvalid(false);
		FieldPesquisar = new JFormattedTextField(maskPesquisa);
		FieldPesquisar.setFocusLostBehavior(JFormattedTextField.PERSIST);
		FieldPesquisar.setForeground(new Color(105, 105, 105));
		FieldPesquisar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		FieldPesquisar.setBounds(10, 42, 329, 30);
		FieldPesquisar.setColumns(10);
		FieldPesquisar.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FieldPesquisar.setForeground(new Color(0, 0, 0));
			}
			
			public void focusLost(FocusEvent e) {
				FieldPesquisar.setForeground(new Color(105, 105, 105));
			}
		});
		pesquisaPanel.add(FieldPesquisar);
		
		dateChooserDe = new JDateChooser();
		dateChooserDe.setBounds(40, 42, 128, 30);
		textDateDe = new JLabel("De:");
		textDateDe.setBounds(10, 48, 30, 15);
		textDateDe.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		dateChooserAte = new JDateChooser();
		dateChooserAte.setBounds(210, 42, 128, 30);
		textDateAte = new JLabel("Atï¿½:");
		textDateAte.setBounds(175, 48, 40, 15);
		textDateAte.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		
		ComboBoxFiltro = new JComboBox<String>();
		ComboBoxFiltro.setFont(new Font("SansSerif", Font.PLAIN, 17));
		ComboBoxFiltro.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "IDFuncionario", "Data", "Todas"}));
		ComboBoxFiltro.setBounds(264, 10, 118, 22);
		pesquisaPanel.add(ComboBoxFiltro);
		ComboBoxFiltro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getItem().equals("ID")) {
					FieldPesquisar.setBounds(10, 42, 329, 30);
					FieldPesquisar.setEnabled(true);
					FieldPesquisar.setText("");
					btnPesquisaVenda.setEnabled(true);
					dateChooserAte.cleanup();
					dateChooserDe.cleanup();
					pesquisaPanel.add(FieldPesquisar);
					pesquisaPanel.remove(dateChooserDe);
					pesquisaPanel.remove(textDateDe);
					pesquisaPanel.remove(dateChooserAte);
					pesquisaPanel.remove(textDateAte);
					idVenda.setText("0");
					funcionarioNome.setText("-");
					data.setText("00/00/0000");
					totalCompra.setText("R$ 0,00");
					metodoPagamento.setText("-");
					clienteNome.setText("-");
					cpfCliente.setText("-");
					listModelVendas.clear();
					listModelProdutos.clear();
					vendaPanel.repaint();
					pesquisaPanel.repaint();
				}
				
				if(e.getItem().equals("Data")) {
					FieldPesquisar.setBounds(0, 0, 0, 0);
					pesquisaPanel.remove(FieldPesquisar);
					btnPesquisaVenda.setEnabled(true);
					FieldPesquisar.setText("");
					pesquisaPanel.repaint();
					pesquisaPanel.add(dateChooserDe);
					pesquisaPanel.add(textDateDe);
					pesquisaPanel.add(dateChooserAte);
					pesquisaPanel.add(textDateAte);
					idVenda.setText("0");
					funcionarioNome.setText("-");
					data.setText("00/00/0000");
					totalCompra.setText("R$ 0,00");
					metodoPagamento.setText("-");
					clienteNome.setText("-");
					cpfCliente.setText("-");
					listModelVendas.clear();
					listModelProdutos.clear();
					vendaPanel.repaint();
					pesquisaPanel.repaint();
				}
				
				if(e.getItem().equals("IDFuncionario")) {
					FieldPesquisar.setBounds(10, 42, 329, 30);
					FieldPesquisar.setEnabled(true);
					btnPesquisaVenda.setEnabled(true);
					dateChooserAte.cleanup();
					dateChooserDe.cleanup();
					FieldPesquisar.setText("");
					pesquisaPanel.add(FieldPesquisar);
					pesquisaPanel.remove(dateChooserDe);
					pesquisaPanel.remove(textDateDe);
					pesquisaPanel.remove(dateChooserAte);
					pesquisaPanel.remove(textDateAte);
					idVenda.setText("0");
					funcionarioNome.setText("-");
					data.setText("00/00/0000");
					totalCompra.setText("R$ 0,00");
					metodoPagamento.setText("-");
					clienteNome.setText("-");
					cpfCliente.setText("-");
					listModelVendas.clear();
					listModelProdutos.clear();
					vendaPanel.repaint();
					pesquisaPanel.repaint();
				}
				
				if(e.getItem().equals("Todas")) {
					FieldPesquisar.setBounds(10, 42, 329, 30);
					FieldPesquisar.setEnabled(false);
					dateChooserAte.cleanup();
					dateChooserDe.cleanup();
					FieldPesquisar.setText("");
					pesquisaPanel.add(FieldPesquisar);
					btnPesquisaVenda.setEnabled(false);
					pesquisaPanel.remove(dateChooserDe);
					pesquisaPanel.remove(textDateDe);
					pesquisaPanel.remove(dateChooserAte);
					pesquisaPanel.remove(textDateAte);
					idVenda.setText("0");
					funcionarioNome.setText("-");
					data.setText("00/00/0000");
					totalCompra.setText("R$ 0,00");
					metodoPagamento.setText("-");
					clienteNome.setText("-");
					cpfCliente.setText("-");
					listModelVendas.clear();
					listModelProdutos.clear();
					try {
						listModelVendas.addAll(vendaService.getTodasVendas());
					} catch (ExcecaoDoSistema | ExcecaoDeNegocios ex) {
						JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
					vendaPanel.repaint();
					pesquisaPanel.repaint();
				}
			}
		});
		
		listaVendas = new JList<Venda>(listModelVendas);
		listaVendas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Venda vendaSelecionada = (Venda) listaVendas.getSelectedValue();
					if(vendaSelecionada != null) {
						idVenda.setText(vendaSelecionada.getId().toString());
						funcionarioNome.setText(vendaSelecionada.getFuncionario().getNome());
						data.setText(vendaSelecionada.getData().format(formatoData));
						totalCompra.setText(String.format("R$ %.2f", vendaSelecionada.getPreco()));
						metodoPagamento.setText(vendaSelecionada.getFormaDePagamentoEnum().toString());
						clienteNome.setText(vendaSelecionada.getCliente().getNome());
						cpfCliente.setText(vendaSelecionada.getCliente().getCpf());
						listModelProdutos.clear();
						listModelProdutos.addAll(vendaSelecionada.getProdutosVendidos());
					}
				}
			}
		});
		listaVendas.setFont(new Font("SansSerif", Font.PLAIN, 18));
		listaVendas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		listaVendas.setValueIsAdjusting(true);
		listaVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneVendas = new JScrollPane(listaVendas);
		scrollPaneVendas.setBounds(10, 83, 372, 491);
		pesquisaPanel.add(scrollPaneVendas, BorderLayout.CENTER);
		
		btnPesquisaVenda = new JButton("");
		btnPesquisaVenda.setIcon(new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/LupaIcon.png")));
		btnPesquisaVenda.setBounds(349, 42, 33, 30);
		btnPesquisaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					atualizarListModels();
				}
			});
		pesquisaPanel.add(btnPesquisaVenda);
		
		
		vendaPanel = new JPanel();
		vendaPanel.setBounds(402, 0, 592, 630);
		PrincipalPanel.add(vendaPanel);
		vendaPanel.setLayout(null);
		
		idVenda = new JLabel("0");
		idVenda.setToolTipText("");
		idVenda.setFont(new Font("SansSerif", Font.PLAIN, 20));
		idVenda.setBounds(10, 23, 72, 29);
		vendaPanel.add(idVenda);
		
		JLabel TextID = new JLabel("ID:");
		TextID.setFont(new Font("SansSerif", Font.PLAIN, 20));
		TextID.setBounds(10, 0, 33, 29);
		vendaPanel.add(TextID);
		
		JLabel txtData = new JLabel("Data:");
		txtData.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtData.setBounds(466, 0, 116, 29);
		vendaPanel.add(txtData);
		
		data = new JLabel("00/00/0000");
		data.setFont(new Font("SansSerif", Font.PLAIN, 20));
		data.setBounds(466, 23, 116, 29);
		vendaPanel.add(data);
		
		listaProdutos = new JList<ProdutoVendaDetails>(listModelProdutos);
		listaProdutos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		listaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaProdutos.setFont(new Font("SansSerif", Font.PLAIN, 20));
		JScrollPane scrollPaneProdutos = new JScrollPane(listaProdutos);
		scrollPaneProdutos.setBounds(10, 75, 572, 342);
		vendaPanel.add(scrollPaneProdutos, BorderLayout.CENTER);
		
		buttonNotaFiscal = new JButton("Emitir Nota Fiscal");
		buttonNotaFiscal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Escolha onde salvar a nota fiscal");
				
				Venda vendaNota = listaVendas.getSelectedValue();
				
				fileChooser.setSelectedFile(new File("ID_" + vendaNota.getId() + "_" + vendaNota.getData() + ".pdf"));
				
				int userSelection = fileChooser.showSaveDialog(Janela.getInstance().getFrame());
				
				if(userSelection == JFileChooser.APPROVE_OPTION) {
					File arquivoSalvo = fileChooser.getSelectedFile();
					
					if (arquivoSalvo.exists()) {
	                    int resposta = JOptionPane.showConfirmDialog(
	                            Janela.getInstance().getFrame(),
	                            "O arquivo jï¿½ existe. Deseja sobrescrevï¿½-lo?",
	                            "Arquivo existente",
	                            JOptionPane.YES_NO_OPTION,
	                            JOptionPane.WARNING_MESSAGE
	                    );

	                    if (resposta == JOptionPane.NO_OPTION) {
	                        JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Por favor, escolha outro nome para o arquivo.");
	                        return;
	                    }
	                }
					
					try (PDDocument documento = new PDDocument()){
						PDPage pagina = new PDPage();
						documento.addPage(pagina);
						
						try (PDPageContentStream contentStream = new PDPageContentStream(documento, pagina)){
							// Centralizando e mostrando titulo da pagina
							String titulo = "ManagePro";
							float calcDoTexto = PDType1Font.HELVETICA_BOLD.getStringWidth(titulo) / 1000 * 20;
							float centro = (pagina.getMediaBox().getWidth() - calcDoTexto) / 2;
							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
							contentStream.newLineAtOffset(centro, pagina.getMediaBox().getHeight() - 50);
 							contentStream.showText(titulo);
							contentStream.endText();
							// Dados da compra e da empresa
							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
							contentStream.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 100);
 							contentStream.showText("CNPJ: 93.157.244/0001-33");
 							contentStream.endText();
 							
 							contentStream.beginText();
 							contentStream.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 120);
 							contentStream.showText("ENDEREï¿½O: Av. Prefeito Geraldo Pinho Alves, Nï¿½ 1.400, Maranguape I, Paulista/PE CEP: 53441-600");
 							contentStream.endText();
 							
 							contentStream.beginText();
 							contentStream.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 140);
 							contentStream.showText("DATA: " + vendaNota.getData().format(formatoData));
 							contentStream.endText();
 							
 							contentStream.beginText();
 							contentStream.newLineAtOffset(12, pagina.getMediaBox().getHeight() - 160);
 							contentStream.showText("------------------------------------------------------------------------------------------"
 									+ "---------------------------------------------------------");
							contentStream.endText();
							
							String cliente = "Cliente";
							float calcDoTexto2 = PDType1Font.HELVETICA_BOLD.getStringWidth(cliente) / 1000 * 20;
							float centro2 = (pagina.getMediaBox().getWidth() - calcDoTexto2) / 2;
							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 22);
 							contentStream.newLineAtOffset(centro2, pagina.getMediaBox().getHeight() - 180);
 							contentStream.showText(cliente);
 							contentStream.endText();
 							
 							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
 							contentStream.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 210);
 							contentStream.showText("CLIENTE: " + vendaNota.getCliente().getNome());
 							contentStream.endText();
 							
 							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
 							contentStream.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 230);
 							contentStream.showText("CPF: " + vendaNota.getCliente().getCpf());
 							contentStream.endText();
 							
 							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
 							contentStream.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 250);
 							contentStream.showText("DATA DE NASCIMENTO: " + vendaNota.getCliente().getDataNascimento().format(formatoData));
 							contentStream.endText();
 							
 							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
 							contentStream.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 270);
 							contentStream.showText("TELEFONE: " + vendaNota.getCliente().getTelefone());
 							contentStream.endText();
 							
 							contentStream.beginText();
 							contentStream.newLineAtOffset(12, pagina.getMediaBox().getHeight() - 290);
 							contentStream.showText("------------------------------------------------------------------------------------------"
 									+ "---------------------------------------------------------");
							contentStream.endText();
							
							String txtCupomFiscal = "Cupom Fiscal";
							float calcDoTexto3 = PDType1Font.HELVETICA_BOLD.getStringWidth(txtCupomFiscal) / 1000 * 20;
							float centro3 = (pagina.getMediaBox().getWidth() - calcDoTexto3) / 2;
							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 22);
 							contentStream.newLineAtOffset(centro3, pagina.getMediaBox().getHeight() - 310);
 							contentStream.showText(txtCupomFiscal);
 							contentStream.endText();
 							
 							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
 							contentStream.newLineAtOffset(140, pagina.getMediaBox().getHeight() - 340);
 							contentStream.showText("Cï¿½D.  |             NOME             |   QUANTIDADE     "
 									+ "  |   VALOR");
 							contentStream.endText();
 							
							int inicioLinha = 360;
							for (ProdutoVendaDetails pvd : vendaNota.getProdutosVendidos()) {	
								contentStream.beginText();
								contentStream.newLineAtOffset(150, pagina.getMediaBox().getHeight() - inicioLinha);
								contentStream.showText(pvd.getCodigoProduto().toString());
								contentStream.endText();
								
								contentStream.beginText();
								contentStream.newLineAtOffset(198, pagina.getMediaBox().getHeight() - inicioLinha);
								contentStream.showText(pvd.getNomeProduto());
								contentStream.endText();
								
								contentStream.beginText();
								contentStream.newLineAtOffset(355, pagina.getMediaBox().getHeight() - inicioLinha);
								contentStream.showText(String.valueOf(pvd.getQuantidade()));
								contentStream.endText();
								
								contentStream.beginText();
								contentStream.newLineAtOffset(440, pagina.getMediaBox().getHeight() - inicioLinha);
								contentStream.showText(String.format("%.2f", pvd.getPreco()));
								contentStream.endText();
								
								inicioLinha += 15;
								
							}
							
							inicioLinha += 25;
							
							contentStream.beginText();
							contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
							contentStream.newLineAtOffset(160, pagina.getMediaBox().getHeight() - inicioLinha);
							contentStream.showText("Mï¿½TODO DE PAGAMENTO: " + vendaNota.getFormaDePagamentoEnum().name());
							contentStream.endText();
							inicioLinha += 15;
							
							contentStream.beginText();
							contentStream.newLineAtOffset(160, pagina.getMediaBox().getHeight() - inicioLinha);
							contentStream.showText("TOTAL DA COMPRA: " + String.format("R$ %.2f", vendaNota.getPreco()));
							contentStream.endText();
			
							
						} 
						
						
						
						documento.save(arquivoSalvo.getAbsolutePath());
						JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Nota Fiscal criada e salva em: " + arquivoSalvo.getAbsolutePath());
					} catch (IOException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro ao criar o PDF.");
	                }
				}
				
			}
		});
		buttonNotaFiscal.setFont(new Font("SansSerif", Font.PLAIN, 20));
		buttonNotaFiscal.setBounds(10, 578, 210, 41);
		vendaPanel.add(buttonNotaFiscal);
		
		funcionarioNome = new JLabel("");
		funcionarioNome.setToolTipText("");
		funcionarioNome.setFont(new Font("SansSerif", Font.PLAIN, 20));
		funcionarioNome.setBounds(125, 23, 331, 29);
		vendaPanel.add(funcionarioNome);
		
		JLabel txtFuncionario = new JLabel("Funcionï¿½rio:");
		txtFuncionario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtFuncionario.setBounds(125, 1, 331, 29);
		vendaPanel.add(txtFuncionario);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!listaVendas.isSelectionEmpty()) {
					if(JOptionPane.showConfirmDialog(Janela.getInstance().getPanelPrincipal(), "Deseja realmente cancelar a venda?", "Cancelar", JOptionPane.YES_NO_OPTION) == 0) {
						try {
							vendaService.deletarVendaPorId(listaVendas.getSelectedValue().getId());
						} catch (ExcecaoDoSistema | ExcecaoDeNegocios ex) {
							JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						}
						atualizarListModels();
					}
				} else {
					JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), 
							"Vocï¿½ precisa selecionar alguma das vendas antes de deletar!");
				}
			}
			
		});
		btnDeletar.setForeground(new Color(255, 255, 255));
		btnDeletar.setBackground(new Color(255, 0, 0));
		btnDeletar.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnDeletar.setBounds(453, 578, 129, 41);
		vendaPanel.add(btnDeletar);
		
		JLabel txtTotalCompra = new JLabel("Total da Compra:");
		txtTotalCompra.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtTotalCompra.setBounds(10, 428, 146, 29);
		vendaPanel.add(txtTotalCompra);
		
		totalCompra = new JLabel("R$ 0,00");
		totalCompra.setFont(new Font("SansSerif", Font.PLAIN, 18));
		totalCompra.setBounds(154, 428, 119, 29);
		vendaPanel.add(totalCompra);
		
		JLabel txtMetodoPagamento = new JLabel("Mï¿½todo de Pagamento:");
		txtMetodoPagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtMetodoPagamento.setBounds(10, 458, 195, 29);
		vendaPanel.add(txtMetodoPagamento);
		
		metodoPagamento = new JLabel("");
		metodoPagamento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		metodoPagamento.setBounds(201, 458, 182, 29);
		vendaPanel.add(metodoPagamento);
		
		JLabel txtCliente = new JLabel("Cliente:");
		txtCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCliente.setBounds(10, 488, 61, 32);
		vendaPanel.add(txtCliente);
		
		clienteNome = new JLabel("");
		clienteNome.setFont(new Font("SansSerif", Font.PLAIN, 18));
		clienteNome.setBounds(74, 490, 245, 29);
		vendaPanel.add(clienteNome);
		
		JLabel txtCpf = new JLabel("CPF:");
		txtCpf.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtCpf.setBounds(10, 517, 46, 29);
		vendaPanel.add(txtCpf);
		
		cpfCliente = new JLabel("000.000.000-00");
		cpfCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		cpfCliente.setBounds(55, 517, 135, 29);
		vendaPanel.add(cpfCliente);
		
		JButton btnVoltar = new JButton("Voltar   ");
		btnVoltar.setIcon(new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		btnVoltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModelVendas.clear();
				listModelProdutos.clear();
				idVenda.setText("0");
				funcionarioNome.setText("-");
				data.setText("00/00/0000");
				totalCompra.setText("R$ 0,00");
				metodoPagamento.setText("-");
				clienteNome.setText("-");
				cpfCliente.setText("-");
				dateChooserAte.cleanup();
				dateChooserDe.cleanup();
				
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Menu");
			}
		});
		btnVoltar.setBounds(10, 11, 120, 35);
		PrincipalPanel.add(btnVoltar);
	}
	
	private void atualizarListModels() {
		
		if (ComboBoxFiltro.getSelectedItem().equals("IDFuncionario")) {
			String pesquisaString = FieldPesquisar.getText().replaceAll(" ", "");
			if(!pesquisaString.isEmpty()) {
				listModelVendas.clear();
				try {																	
					listModelVendas.addAll(vendaService.getVendasPorFuncionarioId(Long.valueOf(pesquisaString)));											
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				listModelVendas.clear();
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), 
						"Vocï¿½ precisa digitar antes de Pesquisar");
			}
		}
		
		if (ComboBoxFiltro.getSelectedItem().equals("ID")) {
			String pesquisaString = FieldPesquisar.getText().replaceAll(" ", "");
			if(!pesquisaString.isEmpty()) {
				listModelVendas.clear();
					try {
						listModelVendas.addAll(vendaService.getVendasPorId(Long.valueOf(pesquisaString)));
					} catch (ExcecaoDoSistema | ExcecaoDeNegocios ex) {
						JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}																		
				
			} else {
				listModelVendas.clear();
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), 
						"Você precisa digitar antes de Pesquisar");
			}
		}
		
		if (ComboBoxFiltro.getSelectedItem().equals("Todas")) {
			listModelVendas.clear();
			try {
				listModelVendas.addAll(vendaService.getTodasVendas());
			} catch (ExcecaoDoSistema | ExcecaoDeNegocios ex) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (ComboBoxFiltro.getSelectedItem().equals("Data")) {
			
			Instant instantDe = dateChooserDe.getDate().toInstant();
			LocalDate de = instantDe.atZone(ZoneId.systemDefault()).toLocalDate();
			Instant instantAte = dateChooserAte.getDate().toInstant();
			LocalDate ate = instantAte.atZone(ZoneId.systemDefault()).toLocalDate();
			if (de.compareTo(ate) >= 0) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), 
						"Você precisa selecionar as datas antes de Pesquisar");
			} else {
				
				try {
					if(!vendaService.getVendasPorIntervaloDeDatas(de, ate).isEmpty()) {
						listModelVendas.clear();
						listModelVendas.addAll(vendaService.getVendasPorIntervaloDeDatas(de, ate));	
					} else {
						listModelVendas.clear();
						JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), 
								"Você precisa selecionar as datas antes de Pesquisar");
					}
				} catch (ExcecaoDoSistema | ExcecaoDeNegocios ex) {
					JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
}
