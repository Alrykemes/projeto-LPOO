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
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class TelaContabilidade {

	private JPanel contabilidadePanel;
	private Panel painelGrafico;
	private Panel painelGrafico2;
	private Panel painelGrafico3; 
	private Panel painelOpcoes;
	private JDateChooser escolherDataInicial;
	private JDateChooser escolherDataFinal;

	public JPanel getPanel() {
		return this.contabilidadePanel;
	}
	
	public TelaContabilidade() {
		this.initialize();
	}
	
	private void initialize() {
		contabilidadePanel = new JPanel();
		contabilidadePanel.setBackground(new Color(192, 192, 192));
		contabilidadePanel.setSize(1020,680);
		contabilidadePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contabilidadePanel.setLayout(null);
		
		painelGrafico = new Panel();
		painelGrafico.setBackground(new Color(255, 255, 255));
		painelGrafico.setBounds(132, 269, 510, 150);
		contabilidadePanel.add(painelGrafico);
		painelGrafico.setLayout(null);
		
		painelGrafico2 = new Panel();
		painelGrafico2.setBackground(new Color(255, 255, 255));
		painelGrafico2.setBounds(648, 269, 249, 300);
		contabilidadePanel.add(painelGrafico2);
		painelGrafico2.setLayout(null);
		
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
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Venda", "Produto", "Cliente", "Forma de pagamento", "Código"}));
		comboBox.setBounds(584, 39, 167, 35);
		painelOpcoes.add(comboBox);
		
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
		painelGrafico3.setBounds(132, 425, 510, 144);
		contabilidadePanel.add(painelGrafico3);
		painelGrafico3.setLayout(null);
		
		Panel cardUm = new Panel();
		cardUm.setBackground(new Color(255, 255, 255));
		cardUm.setBounds(132, 126, 255, 116);
		contabilidadePanel.add(cardUm);
		cardUm.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 11, 60, 14);
		cardUm.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("340");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(151, 68, 60, 26);
		cardUm.add(lblNewLabel_2);
		
		Panel cardDois = new Panel();
		cardDois.setLayout(null);
		cardDois.setBackground(new Color(255, 255, 255));
		cardDois.setBounds(393, 126, 248, 116);
		contabilidadePanel.add(cardDois);
		
		JLabel lblNewLabel_5 = new JLabel("Vendas");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(20, 11, 46, 14);
		cardDois.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("340");
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(169, 68, 60, 26);
		cardDois.add(lblNewLabel_2_1);
		
		Panel cardTres = new Panel();
		cardTres.setLayout(null);
		cardTres.setBackground(new Color(255, 255, 255));
		cardTres.setBounds(648, 126, 249, 116);
		contabilidadePanel.add(cardTres);
		
		JLabel lblNewLabel_3 = new JLabel("Ganhos");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(26, 11, 46, 14);
		cardTres.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("R$ 12.500");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(104, 68, 111, 26);
		cardTres.add(lblNewLabel_4);
		
		JButton botaoVoltar = new JButton("Voltar   ");
		botaoVoltar.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/com/managepro/assets/BackToHome.png")));
		botaoVoltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Menu");
			}
		});
		botaoVoltar.setBounds(10, 26, 120, 35);
		painelOpcoes.add(botaoVoltar);
		
		createAndDisplayCharts();
		
	}
	
	
		private void validarData() { 
			Date dataInicial = escolherDataInicial.getDate();
			Date dataFinal = escolherDataFinal.getDate();
			
			if(dataInicial == null || dataFinal == null) {
				JOptionPane.showMessageDialog(this.contabilidadePanel, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				gerarGraficos();
			}
    }
		
		private void gerarGraficos() {
	        createAndDisplayCharts();
	    }
		
		private void createAndDisplayCharts() {
	        // Gráfico de barras
	        CategoryDataset datasetBar = createBarDataset();
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
	        ChartPanel chartPanelBar = new ChartPanel(chartBar);
	        chartPanelBar.setPreferredSize(painelGrafico.getSize());
	        painelGrafico.removeAll(); // Limpar o painel antes de adicionar o gráfico
	        painelGrafico.add(chartPanelBar);
	        painelGrafico.revalidate(); // Revalidar para atualizar a visualização
	        painelGrafico.repaint(); // Repaint para garantir que o gráfico seja visível

	        // Gráfico de colunas
	        CategoryDataset datasetColumn = createColumnDataset();
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
	        ChartPanel chartPanelColumn = new ChartPanel(chartColumn);
	        chartPanelColumn.setPreferredSize(painelGrafico2.getSize());
	        painelGrafico2.removeAll(); // Limpar o painel antes de adicionar o gráfico
	        painelGrafico2.add(chartPanelColumn);
	        painelGrafico2.revalidate(); // Revalidar para atualizar a visualização
	        painelGrafico2.repaint(); // Repaint para garantir que o gráfico seja visível

	        // Gráfico de pizza
	        DefaultPieDataset datasetPie = createPieDataset();
	        JFreeChart chartPie = ChartFactory.createPieChart(
	            "Gráfico de Pizza",
	            datasetPie,
	            true,
	            true,
	            false
	        );
	        ChartPanel chartPanelPie = new ChartPanel(chartPie);
	        chartPanelPie.setPreferredSize(painelGrafico3.getSize());
	        painelGrafico3.removeAll(); // Limpar o painel antes de adicionar o gráfico
	        painelGrafico3.add(chartPanelPie);
	        painelGrafico3.revalidate(); // Revalidar para atualizar a visualização
	        painelGrafico3.repaint(); // Repaint para garantir que o gráfico seja visível
	    }
		
		private CategoryDataset createBarDataset() {
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.addValue(1.0, "Categoria 1", "Item 1");
	        dataset.addValue(4.0, "Categoria 1", "Item 2");
	        dataset.addValue(3.0, "Categoria 1", "Item 3");
	        return dataset;
	    }
		
		private CategoryDataset createColumnDataset() {
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.addValue(2.0, "Categoria A", "Item A");
	        dataset.addValue(5.0, "Categoria A", "Item B");
	        dataset.addValue(4.0, "Categoria A", "Item C");
	        return dataset;
	    }
		
		private DefaultPieDataset createPieDataset() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("Item 1", 20);
	        dataset.setValue("Item 2", 30);
	        dataset.setValue("Item 3", 50);
	        return dataset;
	    }
	
		
}
