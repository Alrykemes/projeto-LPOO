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
import java.util.List;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.managepro.core.model.Estatistica;
import com.managepro.core.service.EstatisticaService;
import com.managepro.core.service.VendaService;
import com.managepro.exceptions.ExcecaoDeNegocios;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.toedter.calendar.JDateChooser;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
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
	private VendaService vendaService;

	public JPanel getPanel() {
		return this.contabilidadePanel;
	}

	public TelaContabilidade() throws ClassNotFoundException, SQLException, ExcecaoDoSistema {

		this.estatisticaService = new EstatisticaService();
		this.vendaService = new VendaService();
		this.initialize();
	}

	private void initialize() throws ExcecaoDoSistema {
		contabilidadePanel = new JPanel();
		contabilidadePanel.setBackground(new Color(192, 192, 192));
		contabilidadePanel.setSize(1020, 680);
		contabilidadePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contabilidadePanel.setLayout(null);

		painelGrafico2 = new Panel();
		painelGrafico2.setBackground(new Color(255, 255, 255));
		painelGrafico2.setBounds(528, 257, 450, 351);
		contabilidadePanel.add(painelGrafico2);

		painelOpcoes = new Panel();
		painelOpcoes.setBackground(new Color(153, 51, 153));
		painelOpcoes.setBounds(0, 0, 1020, 78);
		contabilidadePanel.add(painelOpcoes);
		painelOpcoes.setLayout(null);

		JLabel dataLabel = new JLabel("Data Inicial *");
		dataLabel.setForeground(new Color(255, 255, 255));
		dataLabel.setBackground(new Color(255, 255, 255));
		dataLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		dataLabel.setBounds(272, 0, 101, 29);
		painelOpcoes.add(dataLabel);

		JLabel finalLabel = new JLabel("Data Final *");
		finalLabel.setForeground(new Color(255, 255, 255));
		finalLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		finalLabel.setBounds(445, 0, 101, 29);
		painelOpcoes.add(finalLabel);

		JButton gerarRelatorio = new JButton("Gerar relatório");
		gerarRelatorio.setBackground(new Color(255, 255, 255));
		gerarRelatorio.setFont(new Font("SansSerif", Font.PLAIN, 18));
		gerarRelatorio.setBounds(641, 28, 155, 35);
		painelOpcoes.add(gerarRelatorio);

		JButton gerarAnaliseDiaria = new JButton("Análise Diária");
		gerarAnaliseDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (JOptionPane.showConfirmDialog(Janela.getInstance().getPanelPrincipal(),
							"Deseja realmente gerar o relatório diário ?(deve ser gerado apenas em final de expediente!)",
							"Gerar Relatório", JOptionPane.YES_NO_OPTION) == 0) {
						vendaService.gerarAnaliseDiaria();
					}
				} catch (SQLException | ExcecaoDoSistema ex) {
					JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		gerarAnaliseDiaria.setBackground(new Color(255, 255, 255));
		gerarAnaliseDiaria.setFont(new Font("SansSerif", Font.PLAIN, 18));
		gerarAnaliseDiaria.setBounds(828, 28, 170, 35);
		painelOpcoes.add(gerarAnaliseDiaria);

		escolherDataInicial = new JDateChooser();
		escolherDataInicial.setBounds(272, 28, 155, 35);
		painelOpcoes.add(escolherDataInicial);

		escolherDataFinal = new JDateChooser();
		escolherDataFinal.setBounds(445, 28, 161, 35);
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

		quantidadeProdutos = new JLabel();
		quantidadeProdutos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		quantidadeProdutos.setBounds(20, 11, 60, 14);

		cardDois = new Panel();
		cardDois.setBackground(new Color(255, 255, 255));
		cardDois.setBounds(394, 113, 248, 116);
		contabilidadePanel.add(cardDois);

		quantidadeVendas = new JLabel();
		quantidadeVendas.setFont(new Font("SansSerif", Font.PLAIN, 12));
		quantidadeVendas.setBounds(20, 11, 46, 14);

		cardTres = new Panel();
		cardTres.setBackground(new Color(255, 255, 255));
		cardTres.setBounds(729, 113, 249, 116);
		contabilidadePanel.add(cardTres);

		ganhoTotal = new JLabel();
		ganhoTotal.setFont(new Font("SansSerif", Font.PLAIN, 12));
		ganhoTotal.setBounds(26, 11, 46, 14);

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
		botaoVoltar.setBounds(10, 20, 120, 35);
		painelOpcoes.add(botaoVoltar);

		JComboBox<String> filtercomboBox_1 = new JComboBox<String>();
		filtercomboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "Total", "Data" }));
		filtercomboBox_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		filtercomboBox_1.setBounds(164, 28, 86, 35);
		painelOpcoes.add(filtercomboBox_1);

		filtercomboBox_1.setSelectedItem("Total");
		dataLabel.setVisible(false);
		escolherDataInicial.setVisible(false);
		finalLabel.setVisible(false);
		escolherDataFinal.setVisible(false);
		gerarRelatorio.setVisible(false);

		filtercomboBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selecionado = (String) filtercomboBox_1.getSelectedItem();

				if (selecionado.equals("Total")) {
					dataLabel.setVisible(false);
					escolherDataInicial.setVisible(false);
					finalLabel.setVisible(false);
					escolherDataFinal.setVisible(false);
					gerarRelatorio.setVisible(false);

					exibirGraficosPorDefault();

				} else if (selecionado.equals("Data")) {
					dataLabel.setVisible(true);
					escolherDataInicial.setVisible(true);
					finalLabel.setVisible(true);
					escolherDataFinal.setVisible(true);
					gerarRelatorio.setVisible(true);

					painelGrafico2.removeAll();
					painelGrafico2.revalidate();
					painelGrafico2.repaint();

					painelGrafico3.removeAll();
					painelGrafico3.revalidate();
					painelGrafico3.repaint();
				}
			}
		});

		if (filtercomboBox_1.getSelectedItem().equals("Total")) {
			dataLabel.setVisible(false);
			escolherDataInicial.setVisible(false);
			finalLabel.setVisible(false);
			escolherDataFinal.setVisible(false);
			gerarRelatorio.setVisible(false);
		}

		JLabel agruparLabel_1 = new JLabel("Filtro:\r\n");
		agruparLabel_1.setForeground(Color.WHITE);
		agruparLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		agruparLabel_1.setBounds(164, 0, 86, 29);
		painelOpcoes.add(agruparLabel_1);

	}

	public void exibirGraficosPorDefault() {
		// Exibir gráficos automaticamente com base na seleção "Total"
		try {

			Estatistica estatistica = estatisticaService.getEstatistica();

			painelGrafico2.removeAll();
			painelGrafico3.removeAll();

			// Gráfico de Coluna
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			dataset.addValue(estatistica.getQuantidadeProdutos(), "Quantidade", "Produtos");
			dataset.addValue(estatistica.getQuantidadeVendas(), "Quantidade", "Vendas");
			dataset.addValue(estatistica.getTotalGanho(), "Total", "Ganho");

			JFreeChart chartColuna = ChartFactory.createBarChart("Estatísticas", "Categoria", "Valor", dataset,
					PlotOrientation.VERTICAL, true, true, false);

			ChartPanel chartPanelColuna = new ChartPanel(chartColuna);
			chartPanelColuna.setPreferredSize(new java.awt.Dimension(400, 300));
			painelGrafico2.add(chartPanelColuna, BorderLayout.CENTER);

			// Gráfico de Pizza
			DefaultPieDataset<String> pieDataset = new DefaultPieDataset<String>();
			pieDataset.setValue("Quantidade Produtos", estatistica.getQuantidadeProdutos());
			pieDataset.setValue("Quantidade Vendas", estatistica.getQuantidadeVendas());
			pieDataset.setValue("Ganho Total", estatistica.getTotalGanho());

			JFreeChart chartPizza = ChartFactory.createPieChart("Distribuição", pieDataset, true, true, false);

			ChartPanel chartPanelPizza = new ChartPanel(chartPizza);
			chartPanelPizza.setPreferredSize(new java.awt.Dimension(400, 300));
			painelGrafico3.add(chartPanelPizza, BorderLayout.CENTER);

			painelGrafico2.revalidate();
			painelGrafico2.repaint();
			painelGrafico3.revalidate();
			painelGrafico3.repaint();

		} catch (ExcecaoDeNegocios | SQLException | ExcecaoDoSistema ex) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		} 
	}

	private void validarData() {

		Date dataInicial = escolherDataInicial.getDate();
		Date dataFinal = escolherDataFinal.getDate();

		if (dataInicial == null || dataFinal == null) {
			JOptionPane.showMessageDialog(this.contabilidadePanel, "Por favor, preencha todos os campos obrigatórios.",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (dataInicial.after(dataFinal)) {
			JOptionPane.showMessageDialog(null, "A data final deve ser posterior à data inicial.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			gerarGraficos(dataInicial, dataFinal);
		} catch (ExcecaoDoSistema ex) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void atualizarInformacoes() {
		try {

			Estatistica estatistica = null;

			estatistica = estatisticaService.getEstatistica();

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
		} catch (ExcecaoDeNegocios | SQLException | ExcecaoDoSistema ex) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		} 
	}

	private void gerarGraficos(Date dataInicial, Date dataFinal) throws ExcecaoDoSistema {
		try {
			// Convertendo datas
			java.sql.Date sqlDate = new java.sql.Date(dataInicial.getTime());
			java.sql.Date sqlDate2 = new java.sql.Date(dataFinal.getTime());

			// Obtendo lista de estatísticas
			List<Estatistica> estatisticas;

			estatisticas = estatisticaService.findByData(sqlDate, sqlDate2);

			// Limpar painéis de gráficos
			painelGrafico2.removeAll();
			painelGrafico3.removeAll();

			// Dados para gráficos
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			DefaultPieDataset<String> pieDataset = new DefaultPieDataset<String>();

			// Preencher os dados dos gráficos
			for (Estatistica estatistica : estatisticas) {
				dataset.addValue(estatistica.getQuantidadeProdutos(), "Quantidade", "Produtos");
				dataset.addValue(estatistica.getQuantidadeVendas(), "Quantidade", "Vendas");
				dataset.addValue(estatistica.getTotalGanho(), "Total", "Ganho");

				pieDataset.setValue("Quantidade Produtos", estatistica.getQuantidadeProdutos());
				pieDataset.setValue("Quantidade Vendas", estatistica.getQuantidadeVendas());
				pieDataset.setValue("Ganho Total", estatistica.getTotalGanho());
			}

			// Gráfico de Coluna
			JFreeChart chartColuna = ChartFactory.createBarChart("Estatísticas", "Categoria", "Valor", dataset,
					PlotOrientation.VERTICAL, true, true, false);

			ChartPanel chartPanelColuna = new ChartPanel(chartColuna);
			chartPanelColuna.setPreferredSize(new java.awt.Dimension(400, 300));
			painelGrafico2.add(chartPanelColuna, BorderLayout.CENTER);

			// Gráfico de Pizza
			JFreeChart chartPizza = ChartFactory.createPieChart("Distribuição", pieDataset, true, true, false);

			ChartPanel chartPanelPizza = new ChartPanel(chartPizza);
			chartPanelPizza.setPreferredSize(new java.awt.Dimension(400, 300));
			painelGrafico3.add(chartPanelPizza, BorderLayout.CENTER);

			// Atualizar os painéis
			painelGrafico2.revalidate();
			painelGrafico2.repaint();
			painelGrafico3.revalidate();
			painelGrafico3.repaint();

		} catch (ClassNotFoundException | SQLException | ExcecaoDeNegocios ex) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
