package com.managepro.ui;

import javax.swing.JFrame;
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

	private JFrame frmManagePro;
	private JPanel panel;
	private JDateChooser dataInicialEl;
	private JDateChooser dataFinalEl;
	private JLabel labelAgrupar;

	public JFrame getFrame() {
		return this.frmManagePro;
	}
	
	public TelaContabilidade() {
		this.initialize();
	}
	
	private void initialize() {
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
		
		Panel painelOpcoes = new Panel();
		painelOpcoes.setBackground(new Color(153, 51, 153));
		painelOpcoes.setBounds(0, 0, 1004, 93);
		panel.add(painelOpcoes);
		painelOpcoes.setLayout(null);
		
		Botao botaoVoltar = new Botao("Voltar   ");
		botaoVoltar.setIcon(new ImageIcon(TelaGerenciamentoDeVendas.class.getResource("/com/managepro/assets/BackToHome.png")));
		botaoVoltar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu menu = new TelaMenu();
				getFrame().setVisible(false);
				menu.getFrame().setLocationRelativeTo(null);
				menu.getFrame().setVisible(true);
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
				JOptionPane.showMessageDialog(this.getFrame(), "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				showImage();
			}
    }
	
		private void showImage() {	//MOSTRA AS IMAGENS DOS GRÁFICOS
    }
}