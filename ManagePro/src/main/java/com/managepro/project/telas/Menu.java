package com.managepro.project.telas;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;


public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("ManagePRO");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\caioc\\eclipse-workspace\\projeto-LPOO\\ManagePro\\src\\images\\manageIcon.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 560);
		getContentPane().setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 801, 95);
		header.setBackground(new Color(128, 128, 128));
		getContentPane().add(header);
		header.setLayout(null);
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setIcon(new ImageIcon("C:\\Users\\caioc\\eclipse-workspace\\projeto-LPOO\\ManagePro\\src\\main\\java\\com\\managepro\\images\\ManagePRO.png"));
		imgLogo.setBounds(32, 0, 271, 91);
		header.add(imgLogo);
		
		JButton logoutButton = new JButton("SAIR");
		logoutButton.setForeground(new Color(255, 255, 255));
		logoutButton.setBackground(new Color(255, 0, 0));
		logoutButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		logoutButton.setBounds(679, 30, 87, 21);
		header.add(logoutButton);
		
		JButton estoqueButton = new JButton("Estoque");
		estoqueButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		estoqueButton.setBounds(238, 159, 272, 50);
		getContentPane().add(estoqueButton);
		
		JButton funcionariosButton = new JButton("Funcionários");
		funcionariosButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		funcionariosButton.setBounds(238, 236, 272, 50);
		getContentPane().add(funcionariosButton);
		
		JButton vendasButton = new JButton("Vendas");
		vendasButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		vendasButton.setBounds(238, 316, 272, 50);
		getContentPane().add(vendasButton);
		
		JButton contabilidadeButton = new JButton("Contabilidade");
		contabilidadeButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		contabilidadeButton.setBounds(238, 397, 272, 50);
		getContentPane().add(contabilidadeButton);
		
	
	}
}
