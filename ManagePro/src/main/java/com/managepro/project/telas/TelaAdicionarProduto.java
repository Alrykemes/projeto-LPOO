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
	private JPanel contentPane;
	private JTextField preencherNome;
	private JTextField textoCodigo;
	private JTextField textoPreco;
	private JTextField campoQuantidade;
	private JTextField textoMarca;
	private JTextField preencherFornecedor;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel avisoPreencherCampos = new JLabel("Preencha os campos abaixo corretamente *");
		avisoPreencherCampos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		avisoPreencherCampos.setBounds(10, 35, 268, 14);
		contentPane.add(avisoPreencherCampos);
		
		JLabel NomeProduto = new JLabel("Nome do Produto *");
		NomeProduto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NomeProduto.setBounds(34, 73, 118, 14);
		contentPane.add(NomeProduto);
		
		preencherNome = new JTextField();
		preencherNome.setBounds(34, 98, 217, 35);
		contentPane.add(preencherNome);
		preencherNome.setColumns(10);
		
		JLabel Codigo = new JLabel("Código *");
		Codigo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Codigo.setBounds(312, 73, 70, 14);
		contentPane.add(Codigo);
		
		textoCodigo = new JTextField();
		textoCodigo.setColumns(10);
		textoCodigo.setBounds(312, 98, 131, 35);
		contentPane.add(textoCodigo);
		
		textoPreco = new JTextField();
		textoPreco.setColumns(10);
		textoPreco.setBounds(501, 98, 131, 35);
		contentPane.add(textoPreco);
		
		JLabel PrecoVenda = new JLabel("Preço de Venda *");
		PrecoVenda.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PrecoVenda.setBounds(501, 73, 110, 14);
		contentPane.add(PrecoVenda);
		
		Panel rodapeBotoes = new Panel();
		rodapeBotoes.setBackground(new Color(255, 255, 255));
		rodapeBotoes.setBounds(0, 398, 684, 63);
		contentPane.add(rodapeBotoes);
		rodapeBotoes.setLayout(null);
		
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(45, 11, 99, 41);
		rodapeBotoes.add(botaoCancelar);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(539, 11, 99, 41);
		rodapeBotoes.add(botaoCadastrar);
		
		campoQuantidade = new JTextField();
		campoQuantidade.setColumns(10);
		campoQuantidade.setBounds(34, 182, 131, 35);
		contentPane.add(campoQuantidade);
		
		JLabel Quantidade = new JLabel("Quantidade *");
		Quantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quantidade.setBounds(34, 157, 118, 14);
		contentPane.add(Quantidade);
		
		textoMarca = new JTextField();
		textoMarca.setColumns(10);
		textoMarca.setBounds(218, 182, 139, 35);
		contentPane.add(textoMarca);
		
		JLabel Marca = new JLabel("Marca *");
		Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Marca.setBounds(218, 157, 87, 14);
		contentPane.add(Marca);
		
		JLabel Fornecedor = new JLabel("Fornecedor *");
		Fornecedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Fornecedor.setBounds(415, 157, 81, 14);
		contentPane.add(Fornecedor);
		
		preencherFornecedor = new JTextField();
		preencherFornecedor.setColumns(10);
		preencherFornecedor.setBounds(415, 182, 217, 35);
		contentPane.add(preencherFornecedor);
		
		JPanel painelTexto = new JPanel();
		painelTexto.setBackground(new Color(255, 255, 255));
		painelTexto.setBounds(34, 241, 598, 140);
		contentPane.add(painelTexto);
		painelTexto.setLayout(null);
		
		Panel painelInformacoes = new Panel();
		painelInformacoes.setBackground(new Color(128, 128, 128));
		painelInformacoes.setBounds(0, 0, 598, 36);
		painelTexto.add(painelInformacoes);
		painelInformacoes.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Nome");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(51, 11, 46, 14);
		painelInformacoes.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Cód");
		lblNewLabel_9.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(143, 6, 46, 24);
		painelInformacoes.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("R$");
		lblNewLabel_10.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(220, 9, 46, 18);
		painelInformacoes.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Qntd");
		lblNewLabel_11.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(291, 9, 57, 18);
		painelInformacoes.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Marca");
		lblNewLabel_12.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(383, 9, 46, 18);
		painelInformacoes.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Fornecedor");
		lblNewLabel_13.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(465, 11, 87, 14);
		painelInformacoes.add(lblNewLabel_13);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 241, 598, 24);
		contentPane.add(panel_2);
		
		JLabel cadastrarProduto = new JLabel("CADASTRAR PRODUTO");
		cadastrarProduto.setFont(new Font("SansSerif", Font.PLAIN, 20));
		cadastrarProduto.setBounds(10, 11, 295, 24);
		contentPane.add(cadastrarProduto);
		
		botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if (preencherNome.getText().isEmpty() || textoCodigo.getText().isEmpty() || 
                    textoPreco.getText().isEmpty() || campoQuantidade.getText().isEmpty() || 
                    textoMarca.getText().isEmpty() || preencherFornecedor.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {  	
                	JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
		
		botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Deseja mesmo cancelar?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
	}
}
