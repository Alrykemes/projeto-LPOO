package com.managepro.ui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;

public class TelaContabilidade {

<<<<<<< HEAD
	private JFrame frmManagePro;
	private JPanel panel;
	private JDateChooser dataInicialEl;
	private JDateChooser dataFinalEl;
	private JLabel labelAgrupar;
=======
	private JPanel contabilidadePanel;
	private JLabel lblImage1;		//IMAGENS DOS GRÁFICOS (APAGAR DEPOIS: APENAS TESTE)
	private JLabel lblImage2;		//AVISO: NOMES GENÉRICOS CRIADOS PROPOSITALMENTE: APENAS TESTE
	private JLabel lblImage3;
	private Panel painelGrafico;
	private Panel painelGrafico2;
	private Panel painelOpcoes;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712

	public JPanel getPanel() {
		return this.contabilidadePanel;
	}
	
	public TelaContabilidade() {
		this.initialize();
	}
	
	private void initialize() {
<<<<<<< HEAD
		frmManagePro = new JFrame();
		frmManagePro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaContabilidade.class.getResource("/com/managepro/assets/manageIcon.png")));
		frmManagePro.setResizable(false);
		frmManagePro.setLocationRelativeTo(null);
		frmManagePro.setTitle("ManagePro");
		frmManagePro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagePro.setBounds(100, 100, 1024, 680);
		
		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		frmManagePro.setContentPane(panel);
=======
		contabilidadePanel = new JPanel();
		contabilidadePanel.setBackground(new Color(192, 192, 192));
		contabilidadePanel.setSize(1020,680);
		contabilidadePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contabilidadePanel.setLayout(null);
		
		painelGrafico = new Panel();
		painelGrafico.setBackground(new Color(255, 255, 255));
		painelGrafico.setBounds(132, 230, 510, 150);
		contabilidadePanel.add(painelGrafico);
		painelGrafico.setLayout(null);
		
		painelGrafico2 = new Panel();
		painelGrafico2.setBackground(new Color(255, 255, 255));
		painelGrafico2.setBounds(648, 230, 249, 300);
		contabilidadePanel.add(painelGrafico2);
		painelGrafico2.setLayout(null);
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		
		painelOpcoes = new Panel();
		painelOpcoes.setBackground(new Color(153, 51, 153));
		painelOpcoes.setBounds(0, 0, 1004, 93);
<<<<<<< HEAD
		panel.add(painelOpcoes);
		painelOpcoes.setLayout(null);
		
		Botao botaoVoltar = new Botao("Voltar   ");
		botaoVoltar.setIcon(new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		botaoVoltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		botaoVoltar.addActionListener(new ActionListener() {
=======
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
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(163, 39, 155, 35);
		painelOpcoes.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(366, 39, 161, 35);
		painelOpcoes.add(dateChooser_1);
		
		//BOTÃO
		gerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarData();
			}
		});	
		
		
		Panel painelGrafico3 = new Panel();
		painelGrafico3.setBackground(new Color(255, 255, 255));
		painelGrafico3.setBounds(132, 386, 510, 144);
		contabilidadePanel.add(painelGrafico3);
		painelGrafico3.setLayout(null);
		
		Panel cardUm = new Panel();
		cardUm.setBackground(new Color(255, 255, 255));
		cardUm.setBounds(132, 108, 255, 116);
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
		
		
		lblImage1 = new JLabel("fotoaqui");
		lblImage1.setBounds(10, 11, 438, 170);
		painelGrafico.add(lblImage1);
		
		lblImage2 = new JLabel("fotoaqui");
		lblImage2.setBounds(15, 11, 208, 265);
		painelGrafico2.add(lblImage2);
		
		lblImage3 = new JLabel("fotoaqui");
		lblImage3.setBounds(10, -21, 438, 170);
		painelGrafico3.add(lblImage3);
		
		Panel cardDois = new Panel();
		cardDois.setLayout(null);
		cardDois.setBackground(new Color(255, 255, 255));
		cardDois.setBounds(394, 108, 248, 116);
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
		cardTres.setBounds(648, 108, 249, 116);
		contabilidadePanel.add(cardTres);
		
		JLabel lblNewLabel_3 = new JLabel("Ganhos");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(26, 11, 46, 14);
		cardTres.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("R$ 12.500");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(104, 68, 111, 26);
		cardTres.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Voltar   ");
		btnNewButton.setIcon(new ImageIcon(TelaContabilidade.class.getResource("/com/managepro/assets/BackToHome.png")));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
			public void actionPerformed(ActionEvent e) {
				Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Menu");
			}
		});
		botaoVoltar.setBounds(10, 26, 120, 35);
		painelOpcoes.add(botaoVoltar);
		
		JLabel labelDataEl = new JLabel("Data Inicial *");
		labelDataEl.setForeground(new Color(255, 255, 255));
		labelDataEl.setBackground(new Color(255, 255, 255));
		labelDataEl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		labelDataEl.setBounds(163, 11, 101, 29);
		painelOpcoes.add(labelDataEl);
		
		dataInicialEl = new JDateChooser();
		dataInicialEl.setBounds(163, 39, 155, 35);
		painelOpcoes.add(dataInicialEl);
		
		JLabel labelDataFinalEl = new JLabel("Data Final *");
		labelDataFinalEl.setForeground(new Color(255, 255, 255));
		labelDataFinalEl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		labelDataFinalEl.setBounds(366, 11, 75, 29);
		painelOpcoes.add(labelDataFinalEl);
		
		dataFinalEl = new JDateChooser();
		dataFinalEl.setBounds(366, 39, 161, 35);
		painelOpcoes.add(dataFinalEl);
		
		labelAgrupar = new JLabel("Agrupar por *");
		labelAgrupar.setForeground(new Color(255, 255, 255));
		labelAgrupar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		labelAgrupar.setBounds(584, 11, 101, 29);
		painelOpcoes.add(labelAgrupar);
		
		ComboBox<String> listaAgrupar = new ComboBox<String>();
		listaAgrupar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		listaAgrupar.setModel(new DefaultComboBoxModel<String>(new String[] {"Venda", "Produto", "Cliente", "Forma de pagamento", "Código"}));
		listaAgrupar.setBounds(584, 39, 167, 35);
		painelOpcoes.add(listaAgrupar);
		
		Botao botaoGerarRelatorio = new Botao("Gerar relatório");
		botaoGerarRelatorio.setBackground(new Color(255, 255, 255));
		botaoGerarRelatorio.setFont(new Font("SansSerif", Font.PLAIN, 12));
		botaoGerarRelatorio.setBounds(826, 41, 145, 31);
		painelOpcoes.add(botaoGerarRelatorio);
		
		botaoGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarData();
			}
		});	
		
		Panel panelProdutos = new Panel();
		panelProdutos.setBackground(new Color(255, 255, 255));
		panelProdutos.setBounds(132, 108, 255, 116);
		panel.add(panelProdutos);
		panelProdutos.setLayout(null);
		
		JLabel tituloPanelProdutos = new JLabel("Produtos");
		tituloPanelProdutos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tituloPanelProdutos.setBounds(20, 11, 60, 14);
		panelProdutos.add(tituloPanelProdutos);
		
		JLabel resultadoProdutos = new JLabel("340");
		resultadoProdutos.setFont(new Font("SansSerif", Font.PLAIN, 20));
		resultadoProdutos.setBounds(151, 68, 60, 26);
		panelProdutos.add(resultadoProdutos);
		
		Panel panelVendas = new Panel();
		panelVendas.setLayout(null);
		panelVendas.setBackground(new Color(255, 255, 255));
		panelVendas.setBounds(394, 108, 248, 116);
		panel.add(panelVendas);
		
		JLabel tituloPanelVendas = new JLabel("Vendas");
		tituloPanelVendas.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tituloPanelVendas.setBounds(20, 11, 46, 14);
		panelVendas.add(tituloPanelVendas);
		
		JLabel resultadoVendas = new JLabel("27890");
		resultadoVendas.setFont(new Font("SansSerif", Font.PLAIN, 20));
		resultadoVendas.setBounds(169, 68, 60, 26);
		panelVendas.add(resultadoVendas);
		
		Panel panelGanhos = new Panel();
		panelGanhos.setLayout(null);
		panelGanhos.setBackground(new Color(255, 255, 255));
		panelGanhos.setBounds(648, 108, 249, 116);
		panel.add(panelGanhos);
		
		JLabel tituloPanelGanhos = new JLabel("Ganhos");
		tituloPanelGanhos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tituloPanelGanhos.setBounds(26, 11, 46, 14);
		panelGanhos.add(tituloPanelGanhos);
		
		JLabel resultadoGanhos = new JLabel("R$ 122.500");
		resultadoGanhos.setFont(new Font("SansSerif", Font.PLAIN, 20));
		resultadoGanhos.setBounds(104, 68, 111, 26);
		panelGanhos.add(resultadoGanhos);
		
		Panel painelGrafico1 = new Panel();
		painelGrafico1.setBackground(new Color(255, 255, 255));
		painelGrafico1.setBounds(132, 230, 510, 150);
		panel.add(painelGrafico1);
		painelGrafico1.setLayout(null);
		
		JLabel grafico1 = new JLabel("Gráfico");
		grafico1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		grafico1.setBounds(200, 57, 93, 43);
		painelGrafico1.add(grafico1);
		
		Panel painelGrafico2 = new Panel();
		painelGrafico2.setBackground(new Color(255, 255, 255));
		painelGrafico2.setBounds(132, 386, 510, 144);
		panel.add(painelGrafico2);
		painelGrafico2.setLayout(null);
		
		JLabel grafico2 = new JLabel("Gráfico");
		grafico2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		grafico2.setBounds(196, 49, 93, 43);
		painelGrafico2.add(grafico2);
		
		Panel painelGrafico3 = new Panel();
		painelGrafico3.setBackground(new Color(255, 255, 255));
		painelGrafico3.setBounds(648, 230, 249, 300);
		panel.add(painelGrafico3);
		painelGrafico3.setLayout(null);
		
		JLabel grafico3 = new JLabel("Gráfico");
		grafico3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		grafico3.setBounds(80, 116, 93, 43);
		painelGrafico3.add(grafico3);
	}
	
		private void validarData() { 
			Date dataInicial = dataInicialEl.getDate();
			Date dataFinal = dataFinalEl.getDate();
			
			if(dataInicial == null || dataFinal == null) {
				JOptionPane.showMessageDialog(this.contabilidadePanel, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				showImage();
			}
    }
	
		private void showImage() {	//MOSTRA AS IMAGENS DOS GRÁFICOS
    }
}