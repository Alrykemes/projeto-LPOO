package com.managepro.project.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TeladeEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeladeEstoque frame = new TeladeEstoque();
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
	public TeladeEstoque() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("ManagePro");
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField.setBounds(756, 47, 167, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton botaoPesquisa = new JButton("");
		botaoPesquisa.setIcon(new ImageIcon("C:\\Programação\\LPOO projeto\\projeto-LPOO\\ManagePro\\src\\main\\java\\com\\managepro\\project\\magnify-custom.png"));
		botaoPesquisa.setBounds(933, 47, 40, 38);
		contentPane.add(botaoPesquisa);
		
		JList list = new JList();
		list.setFont(new Font("SansSerif", Font.PLAIN, 11));
		list.setBounds(20, 165, 960, 374);
		contentPane.add(list);
		
		JButton novoProduto = new JButton("NOVO");
		novoProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		novoProduto.setBounds(50, 55, 131, 45);
		contentPane.add(novoProduto);
		
		JButton editarProduto = new JButton("EDITAR");
		editarProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		editarProduto.setBounds(242, 55, 131, 45);
		contentPane.add(editarProduto);
		
		JButton removerProduto = new JButton("REMOVER");
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removerProduto.setFont(new Font("SansSerif", Font.PLAIN, 11));
		removerProduto.setBounds(445, 55, 131, 45);
		contentPane.add(removerProduto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "Nome"}));
		comboBox.setBounds(836, 89, 57, 22);
		contentPane.add(comboBox);
		
		JLabel filtroLabel = new JLabel("Filtrar por:");
		filtroLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		filtroLabel.setBounds(775, 93, 51, 14);
		contentPane.add(filtroLabel);
		
		
		
		botaoPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, textField.getText());
			}
		});
		
	}
}
