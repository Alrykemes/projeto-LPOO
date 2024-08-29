package com.managepro.ui;

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
import com.managepro.exceptions.ExcecaoDoSistema;
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
	private JComboBox<String> filtercomboBox;

	public JPanel getPanel() {
		return this.contabilidadePanel;
	}
	
	public TelaContabilidade() {
		
			try {
				this.estatisticaService = new EstatisticaService();
			} catch (ExcecaoDoSistema ex) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			} 
			
			this.initialize();
			this.atualizarInformacoes();
	}
	
	private void initialize() {
		contabilidadePanel = new JPanel();
		contabilidadePanel.setBackground(new Color(192, 192, 192));
		contabilidadePanel.setSize(1020,680);
		contabilidadePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contabilidadePanel.setLayout(null);
		
		painelGrafico2 = new Panel();
		painelGrafico2.setBackground(new Color(255, 255, 255));
		painelGrafico2.setBounds(528, 257, 450, 351);
		contabilidadePanel.add(painelGrafico2);
		
		painelOpcoes = new Panel();
		painelOpcoes.setBackground(new Color(153, 51, 153));
		painelOpcoes.setBounds(0, 0, 1020, 91);
		contabilidadePanel.add(painelOpcoes);
		painelOpcoes.setLayout(null);
		
		JLabel dataLabel = new JLabel("Data Inicial *");
		dataLabel.setForeground(new Color(255, 255, 255));
		dataLabel.setBackground(new Color(255, 255, 255));
		dataLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		dataLabel.setBounds(289, 6, 101, 29);
		painelOpcoes.add(dataLabel);
		
		JLabel finalLabel = new JLabel("Data Final *");
		finalLabel.setForeground(new Color(255, 255, 255));
		finalLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		finalLabel.setBounds(492, 6, 75, 29);
		painelOpcoes.add(finalLabel);
		
		JLabel agruparLabel = new JLabel("Tipo de Gráfico:\r\n");
		agruparLabel.setForeground(new Color(255, 255, 255));
		agruparLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		agruparLabel.setBounds(677, 6, 101, 29);
		painelOpcoes.add(agruparLabel);
		
		filtercomboBox = new JComboBox<String>();
		filtercomboBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
		filtercomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Coluna ", "Pizza"}));
		filtercomboBox.setBounds(677, 34, 120, 35);
		painelOpcoes.add(filtercomboBox);
		
		JButton gerarRelatorio = new JButton("Gerar relatório");
		gerarRelatorio.setBackground(new Color(255, 255, 255));
		gerarRelatorio.setFont(new Font("SansSerif", Font.PLAIN, 18));
		gerarRelatorio.setBounds(844, 34, 155, 35);
		painelOpcoes.add(gerarRelatorio);
		
		escolherDataInicial = new JDateChooser();
		escolherDataInicial.setBounds(289, 34, 155, 35);
		painelOpcoes.add(escolherDataInicial);
		
		escolherDataFinal = new JDateChooser();
		escolherDataFinal.setBounds(492, 34, 161, 35);
		painelOpcoes.add(escolherDataFinal);
		
		
		gerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarData();
			}
		});	
		
		
		painelGrafico3 = new Panel();
		painelGrafico3.setBackground(new Color(255, 255, 255));
		painelGrafico3.setBounds(44, 257, 450, 351);
		contabilidadePanel.add(painelGrafico3);
		
		cardUm = new Panel();
		cardUm.setBackground(new Color(255, 255, 255));
		cardUm.setBounds(44, 113, 255, 116);
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
		cardDois.setBounds(394, 113, 248, 116);
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
		cardTres.setBounds(729, 113, 249, 116);
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
				
				painelGrafico2.removeAll();
				painelGrafico2.revalidate();
				painelGrafico2.repaint();
				
				painelGrafico3.removeAll();
				painelGrafico3.revalidate();
				painelGrafico3.repaint();
			}
		});
		botaoVoltar.setBounds(10, 6, 120, 35);
		painelOpcoes.add(botaoVoltar);
		
		JComboBox<String> filtercomboBox_1 = new JComboBox<String>();
		filtercomboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Total", "Data"}));
		filtercomboBox_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		filtercomboBox_1.setBounds(157, 34, 86, 35);
		painelOpcoes.add(filtercomboBox_1);
		
		JLabel agruparLabel_1 = new JLabel("Filtro:\r\n");
		agruparLabel_1.setForeground(Color.WHITE);
		agruparLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		agruparLabel_1.setBounds(157, 6, 101, 29);
		painelOpcoes.add(agruparLabel_1);
		
		
		
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
		
		
		public void atualizarInformacoes() {
			try {
	            
				Estatistica estatistica = estatisticaService.getEstatistica();
	            
	            if (estatistica != null) {
	                
	                quantidadeProdutos = new JLabel("Quantidade de Produtos: " + estatistica.getQuantidadeProdutos());
	                quantidadeVendas = new JLabel("Quantidade de Vendas: " + estatistica.getQuantidadeVendas());
	                ganhoTotal = new JLabel("Total Ganho: " + estatistica.getTotalGanho());
	                 System.out.println();
	                
	                cardUm.removeAll();
	                cardUm.add(quantidadeProdutos);
	                cardDois.removeAll();
	                cardDois.add(quantidadeVendas);
	                cardTres.removeAll();
	                cardTres.add(ganhoTotal);

	                
	                
	                cardUm.repaint();
	                cardDois.repaint();
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
		
		@SuppressWarnings("unused")
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