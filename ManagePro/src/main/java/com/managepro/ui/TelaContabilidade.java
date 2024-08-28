package com.managepro.ui;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.Date;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.managepro.core.model.Estatistica;
import com.managepro.core.service.EstatisticaService;
import com.toedter.calendar.JDateChooser;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.BorderLayout;

public class TelaContabilidade {
	

	private JPanel contabilidadePanel;
	private Panel painelGrafico;
	private Panel painelGrafico2;
	private Panel painelGrafico3; 
	private Panel painelOpcoes;
	private Panel cardUm;
	private Panel cardDois;
	private Panel cardTres;
	private JDateChooser escolherDataInicial;
	private JDateChooser escolherDataFinal;
	private JLabel ganhoTotal;
	private JLabel quantidadeProdutos;
	private JLabel quantidadeVendas;
	private EstatisticaService estatisticaService;
	private Estatistica estatistica;
	private JComboBox<String> filtercomboBox;

	public JPanel getPanel() {
		return this.contabilidadePanel;
	}
	
	public TelaContabilidade() throws SQLException, ClassNotFoundException {
		
			this.estatisticaService = new EstatisticaService(); 
			this.estatistica = new Estatistica();
			this.initialize();
			this.atualizarInformacoes();
	}
	
	private void initialize() {
		contabilidadePanel = new JPanel();
		contabilidadePanel.setBackground(new Color(192, 192, 192));
		contabilidadePanel.setSize(1020,680);
		contabilidadePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contabilidadePanel.setLayout(null);
		
		painelGrafico = new Panel();
		painelGrafico.setBackground(new Color(255, 255, 255));
		painelGrafico.setBounds(132, 257, 510, 175);
		contabilidadePanel.add(painelGrafico);
		
		painelGrafico2 = new Panel();
		painelGrafico2.setBackground(new Color(255, 255, 255));
		painelGrafico2.setBounds(648, 257, 280, 351);
		contabilidadePanel.add(painelGrafico2);
		
		painelOpcoes = new Panel();
		painelOpcoes.setBackground(new Color(153, 51, 153));
		painelOpcoes.setBounds(0, 0, 1020, 93);
		contabilidadePanel.add(painelOpcoes);
		painelOpcoes.setLayout(null);
		
		JLabel dataLabel = new JLabel("Data Inicial *");
		dataLabel.setForeground(new Color(255, 255, 255));
		dataLabel.setBackground(new Color(255, 255, 255));
		dataLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		dataLabel.setBounds(163, 11, 101, 29);
		painelOpcoes.add(dataLabel);
		
		JLabel finalLabel = new JLabel("Data Final *");
		finalLabel.setForeground(new Color(255, 255, 255));
		finalLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		finalLabel.setBounds(366, 11, 75, 29);
		painelOpcoes.add(finalLabel);
		
		JLabel agruparLabel = new JLabel("Agrupar por *");
		agruparLabel.setForeground(new Color(255, 255, 255));
		agruparLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		agruparLabel.setBounds(584, 11, 101, 29);
		painelOpcoes.add(agruparLabel);
		
		filtercomboBox = new JComboBox<String>();
		filtercomboBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		filtercomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Venda", "Produto", "Código", "Preço Total"}));
		filtercomboBox.setBounds(584, 39, 167, 35);
		painelOpcoes.add(filtercomboBox);
		
		JButton gerarRelatorio = new JButton("Gerar relatório");
		gerarRelatorio.setBackground(new Color(255, 255, 255));
		gerarRelatorio.setFont(new Font("SansSerif", Font.PLAIN, 12));
		gerarRelatorio.setBounds(826, 41, 145, 31);
		painelOpcoes.add(gerarRelatorio);
		
		escolherDataInicial = new JDateChooser();
		escolherDataInicial.setBounds(163, 39, 155, 35);
		painelOpcoes.add(escolherDataInicial);
		
		escolherDataFinal = new JDateChooser();
		escolherDataFinal.setBounds(366, 39, 161, 35);
		painelOpcoes.add(escolherDataFinal);
		
		
		gerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarData();
			}
		});	
		
		
		painelGrafico3 = new Panel();
		painelGrafico3.setBackground(new Color(255, 255, 255));
		painelGrafico3.setBounds(132, 438, 510, 170);
		contabilidadePanel.add(painelGrafico3);
		
		cardUm = new Panel();
		cardUm.setBackground(new Color(255, 255, 255));
		cardUm.setBounds(132, 126, 255, 116);
		contabilidadePanel.add(cardUm);
		//cardUm.setLayout(null);
		
		
		quantidadeProdutos = new JLabel();
		quantidadeProdutos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		quantidadeProdutos.setBounds(20, 11, 60, 14);
		//cardUm.add(quantidadeProdutos);
		
		/*
		JLabel lblQuantidadeProdutos = new JLabel("");
		lblQuantidadeProdutos.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblQuantidadeProdutos.setBounds(151, 68, 60, 26);
		cardUm.add(lblQuantidadeProdutos);
		*/
		
		cardDois = new Panel();
		//cardDois.setLayout(null);
		cardDois.setBackground(new Color(255, 255, 255));
		cardDois.setBounds(410, 126, 248, 116);
		contabilidadePanel.add(cardDois);
		
		
		quantidadeVendas = new JLabel();
		quantidadeVendas.setFont(new Font("SansSerif", Font.PLAIN, 12));
		quantidadeVendas.setBounds(20, 11, 46, 14);
		//cardDois.add(quantidadeVendas);
		
		/*
		JLabel lblQuantidadeVenda = new JLabel("");
		lblQuantidadeVenda.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblQuantidadeVenda.setBounds(169, 68, 60, 26);
		cardDois.add(lblQuantidadeVenda);
		*/
		
		cardTres = new Panel();
		//cardTres.setLayout(null);
		cardTres.setBackground(new Color(255, 255, 255));
		cardTres.setBounds(679, 126, 249, 116);
		contabilidadePanel.add(cardTres);
		
		
		ganhoTotal = new JLabel();
		ganhoTotal.setFont(new Font("SansSerif", Font.PLAIN, 12));
		ganhoTotal.setBounds(26, 11, 46, 14);
		//cardTres.add(ganhoTotal);
		
		/*
		JLabel lblPrecoTotal = new JLabel("");
		lblPrecoTotal.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblPrecoTotal.setBounds(104, 68, 111, 26);
		cardTres.add(lblPrecoTotal);
		*/
		

		JButton botaoVoltar = new JButton("Voltar   ");
		botaoVoltar.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/com/managepro/assets/BackToHome.png")));
		botaoVoltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Menu");
				escolherDataInicial.setDate(null);
				escolherDataFinal.setDate(null);
				
				painelGrafico.removeAll();
				painelGrafico.revalidate();
				painelGrafico.repaint();
				
				painelGrafico2.removeAll();
				painelGrafico2.revalidate();
				painelGrafico2.repaint();
				
				painelGrafico3.removeAll();
				painelGrafico3.revalidate();
				painelGrafico3.repaint();
			}
		});
		botaoVoltar.setBounds(10, 26, 120, 35);
		painelOpcoes.add(botaoVoltar);
		
		
		
	}
	
	
		private void validarData() { 
			Date dataInicial = escolherDataInicial.getDate();
			Date dataFinal = escolherDataFinal.getDate();
			
			if(dataInicial == null || dataFinal == null) {
				JOptionPane.showMessageDialog(this.contabilidadePanel, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
			    return;
			} 
			
			if(dataInicial.after(dataFinal)) {
				JOptionPane.showMessageDialog(null, "A data final deve ser posterior à data inicial.", "Erro", JOptionPane.ERROR_MESSAGE);
	            return;
			}
			
			gerarGraficos(dataInicial, dataFinal);
    }
		
		
		private void atualizarInformacoes() {
			try {
	            
				List<Estatistica> estatisticas = estatisticaService.getAllEstatisticas();
	            
	            if (!estatisticas.isEmpty()) {
	                Estatistica estatistica = estatisticas.get(0); 
	                
	                quantidadeProdutos = new JLabel("Quantidade de Produtos: " + estatistica.getQuantidadeVendas());
	                quantidadeVendas = new JLabel("Quantidade de Vendas: " + estatistica.getQuantidadeProdutos());
	                ganhoTotal = new JLabel("Total Ganho: " + estatistica.getTotalGanho());
	                
	                
	                cardUm.removeAll();
	                cardUm.add(quantidadeProdutos);
	                cardDois.removeAll();
	                cardDois.add(quantidadeVendas);
	                cardTres.removeAll();
	                cardTres.add(ganhoTotal);

	                
	                cardUm.revalidate();
	                cardUm.repaint();
	                cardDois.revalidate();
	                cardDois.repaint();
	                cardTres.revalidate();
	                cardTres.repaint();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
		
		
		private void gerarGraficos(Date dataInicial, Date dataFinal) {
			createAndDisplayCharts(dataInicial, dataFinal);
	    }
		
		
		
		
		private void createAndDisplayCharts(Date dataInicial, Date dataFinal) {
	        
			
			// Gráfico de barras
	        CategoryDataset datasetBar = createBarDataset(dataInicial, dataFinal);
	        JFreeChart chartBar = ChartFactory.createBarChart(
	            "Gráfico de Barras",
	            "Categoria",
	            "Valor",
	            datasetBar,
	            PlotOrientation.VERTICAL,
	            true,
	            true,
	            false
	        );
	        painelGrafico.removeAll(); 
	        painelGrafico.setLayout(new BorderLayout());
	        ChartPanel chartPanelBar = new ChartPanel(chartBar);
	        painelGrafico.add(chartPanelBar, BorderLayout.SOUTH);
	        chartPanelBar.setPreferredSize(painelGrafico.getSize());
	        painelGrafico.revalidate(); 
	        painelGrafico.repaint(); 

	        
	        
	        // Gráfico de colunas
	        CategoryDataset datasetColumn = createColumnDataset(dataInicial, dataFinal);
	        JFreeChart chartColumn = ChartFactory.createBarChart(
	            "Gráfico de Colunas",
	            "Categoria",
	            "Valor",
	            datasetColumn,
	            PlotOrientation.VERTICAL,
	            true,
	            true,
	            false
	        );
	        painelGrafico3.removeAll(); 
	        painelGrafico3.setLayout(new BorderLayout());
	        ChartPanel chartPanelColumn = new ChartPanel(chartColumn);
	        painelGrafico3.add(chartPanelColumn, BorderLayout.SOUTH);
	        chartPanelColumn.setPreferredSize(painelGrafico3.getSize());
	        painelGrafico3.revalidate(); 
	        painelGrafico3.repaint(); 

	        // Gráfico de pizza
	        DefaultPieDataset<String> datasetPie = createPieDataset(dataInicial, dataFinal);
	        JFreeChart chartPie = ChartFactory.createPieChart(
	            "Gráfico de Pizza",
	            datasetPie,
	            true,
	            true,
	            false
	        );
	        painelGrafico2.removeAll(); 
	        painelGrafico2.setLayout(new BorderLayout());
	        ChartPanel chartPanelPie = new ChartPanel(chartPie);
	        painelGrafico2.add(chartPanelPie, BorderLayout.CENTER);
	        chartPanelPie.setPreferredSize(painelGrafico2.getSize());
	        painelGrafico2.revalidate(); 
	        painelGrafico2.repaint(); 
	        

	    }
		
		private CategoryDataset createBarDataset(Date dataInicial, Date dataFinal) {
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        
	        if(filtercomboBox.getSelectedItem().equals("Venda")) {
	        	try {
					estatisticaService.getByQuantidadeVendas(Long.valueOf("1"));
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}
	        }
	        
	        
	        dataset.addValue(1.0, "Categoria 1", "Item 1");
	        dataset.addValue(4.0, "Categoria 1", "Item 2");
	        dataset.addValue(3.0, "Categoria 1", "Item 3");
	        return dataset;
	    }
		
		private CategoryDataset createColumnDataset(Date dataInicial, Date dataFinal) {
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        // logica para buscar e usar dados reais
	        dataset.addValue(2.0, "Categoria A", "Item A");
	        dataset.addValue(5.0, "Categoria A", "Item B");
	        dataset.addValue(4.0, "Categoria A", "Item C");
	        return dataset;
	    }
		
		private DefaultPieDataset<String> createPieDataset(Date dataInicial, Date dataFinal) {
	        DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
	        // logica para buscar e usar dados reais
	        dataset.setValue("Item 1", 20);
	        dataset.setValue("Item 2", 30);
	        dataset.setValue("Item 3", 50);
	        return dataset;
	    }
	
		
}