package com.managepro.project.telas;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Scrollbar;

public class TelaAdicionarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PainelConteudo;
	private JTextField PreencherNome;
	private JTextField TextoCodigo;
	private JTextField TextoPreco;
	private JTextField CampoQuantidade;
	private JTextField TextoMarca;
	private JTextField PreencherFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionarProduto frame = new TelaAdicionarProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAdicionarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		PainelConteudo = new JPanel();
		PainelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelConteudo);
		PainelConteudo.setLayout(null);
		
		JLabel AvisoPreencherCampos = new JLabel("Preencha os campos abaixo corretamente *");
		AvisoPreencherCampos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		AvisoPreencherCampos.setBounds(10, 35, 268, 14);
		PainelConteudo.add(AvisoPreencherCampos);
		
		JLabel NomeProduto = new JLabel("Nome do Produto *");
		NomeProduto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NomeProduto.setBounds(34, 73, 118, 14);
		PainelConteudo.add(NomeProduto);
		
		PreencherNome = new JTextField();
		PreencherNome.setBounds(34, 98, 217, 35);
		PainelConteudo.add(PreencherNome);
		PreencherNome.setColumns(10);
		
		JLabel Codigo = new JLabel("Código *");
		Codigo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Codigo.setBounds(312, 73, 70, 14);
		PainelConteudo.add(Codigo);
		
		TextoCodigo = new JTextField();
		TextoCodigo.setColumns(10);
		TextoCodigo.setBounds(312, 98, 131, 35);
		PainelConteudo.add(TextoCodigo);
		
		TextoPreco = new JTextField();
		TextoPreco.setColumns(10);
		TextoPreco.setBounds(501, 98, 131, 35);
		PainelConteudo.add(TextoPreco);
		
		JLabel PrecoVenda = new JLabel("Preço de Venda *");
		PrecoVenda.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoVenda.setBounds(501, 73, 110, 14);
		PainelConteudo.add(PrecoVenda);
		
		Panel RodapeBotoes = new Panel();
		RodapeBotoes.setBackground(new Color(255, 255, 255));
		RodapeBotoes.setBounds(0, 398, 684, 63);
		PainelConteudo.add(RodapeBotoes);
		RodapeBotoes.setLayout(null);
		
		JButton BotaoCancelar = new JButton("Cancelar");
		BotaoCancelar.setBounds(45, 11, 99, 41);
		RodapeBotoes.add(BotaoCancelar);
		
		JButton BotaoCadastrar = new JButton("Cadastrar");
		BotaoCadastrar.setBounds(539, 11, 99, 41);
		RodapeBotoes.add(BotaoCadastrar);
		
		CampoQuantidade = new JTextField();
		CampoQuantidade.setColumns(10);
		CampoQuantidade.setBounds(34, 182, 131, 35);
		PainelConteudo.add(CampoQuantidade);
		
		JLabel Quantidade = new JLabel("Quantidade *");
		Quantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quantidade.setBounds(34, 157, 118, 14);
		PainelConteudo.add(Quantidade);
		
		TextoMarca = new JTextField();
		TextoMarca.setColumns(10);
		TextoMarca.setBounds(218, 182, 139, 35);
		PainelConteudo.add(TextoMarca);
		
		JLabel Marca = new JLabel("Marca *");
		Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marca.setBounds(218, 157, 87, 14);
		PainelConteudo.add(Marca);
		
		JLabel Fornecedor = new JLabel("Fornecedor *");
		Fornecedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Fornecedor.setBounds(415, 157, 81, 14);
		PainelConteudo.add(Fornecedor);
		
		PreencherFornecedor = new JTextField();
		PreencherFornecedor.setColumns(10);
		PreencherFornecedor.setBounds(415, 182, 217, 35);
		PainelConteudo.add(PreencherFornecedor);
		
		JPanel PainelTexto = new JPanel();
		PainelTexto.setBackground(new Color(255, 255, 255));
		PainelTexto.setBounds(34, 241, 598, 140);
		PainelConteudo.add(PainelTexto);
		PainelTexto.setLayout(null);
		
		Panel PainelInformacoes = new Panel();
		PainelInformacoes.setBackground(new Color(128, 128, 128));
		PainelInformacoes.setBounds(0, 0, 598, 36);
		PainelTexto.add(PainelInformacoes);
		PainelInformacoes.setLayout(null);
		
		JLabel ExibirNome = new JLabel("Nome");
		ExibirNome.setFont(new Font("SansSerif", Font.PLAIN, 12));
		ExibirNome.setBounds(51, 11, 46, 14);
		PainelInformacoes.add(ExibirNome);
		
		JLabel ExibirCodigo = new JLabel("Cód");
		ExibirCodigo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		ExibirCodigo.setBounds(143, 6, 46, 24);
		PainelInformacoes.add(ExibirCodigo);
		
		JLabel ExibirValor = new JLabel("R$");
		ExibirValor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		ExibirValor.setBounds(220, 9, 46, 18);
		PainelInformacoes.add(ExibirValor);
		
		JLabel ExibirQuantidade = new JLabel("Qntd");
		ExibirQuantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		ExibirQuantidade.setBounds(291, 9, 57, 18);
		PainelInformacoes.add(ExibirQuantidade);
		
		JLabel ExibirMarca = new JLabel("Marca");
		ExibirMarca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		ExibirMarca.setBounds(383, 9, 46, 18);
		PainelInformacoes.add(ExibirMarca);
		
		JLabel ExibirFornecedor = new JLabel("Fornecedor");
		ExibirFornecedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		ExibirFornecedor.setBounds(465, 11, 87, 14);
		PainelInformacoes.add(ExibirFornecedor);
		
		JLabel CadastrarProduto = new JLabel("CADASTRAR PRODUTO");
		CadastrarProduto.setFont(new Font("SansSerif", Font.PLAIN, 20));
		CadastrarProduto.setBounds(10, 11, 295, 24);
		PainelConteudo.add(CadastrarProduto);
		
		BotaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if (PreencherNome.getText().isEmpty() || TextoCodigo.getText().isEmpty() || 
                    TextoPreco.getText().isEmpty() || CampoQuantidade.getText().isEmpty() || 
                    TextoMarca.getText().isEmpty() || PreencherFornecedor.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {  	
                	JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
		
		BotaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Deseja mesmo cancelar?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
	}
}
