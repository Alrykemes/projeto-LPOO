package com.managepro.ui;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;

public class TelaLogin {

	private JPanel panelLogin;
	private JTextField userLogin;
	private JPasswordField passwordLogin;
	
	public JPanel getPanel() {
		return this.panelLogin;
	}
	
	public JTextField getUserLoginField() {
		return this.userLogin;
	}
	
	public JTextField getUserPasswordField() {
		return this.passwordLogin;
	}
	
	public TelaLogin() {
		this.initialize();
	}

	private void initialize() {
		panelLogin = new JPanel();		
		panelLogin.setBackground(Color.WHITE);
		panelLogin.setBounds(0, 0, 1024, 680);
		
		userLogin = new JTextField();
		userLogin.setBounds(317, 268, 320, 51);
		userLogin.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				userLogin.setText("");
				userLogin.setForeground(Color.black);
			}
			public void focusLost(FocusEvent e) {
                if (userLogin.getText().isEmpty()) {
                    userLogin.setText("Usuário");
                    userLogin.setForeground(Color.LIGHT_GRAY);
                }
            }
		});
		
		panelLogin.setLayout(null);
		userLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		userLogin.setForeground(Color.LIGHT_GRAY);
		userLogin.setToolTipText("");
		panelLogin.add(userLogin);
		userLogin.setColumns(10);
		
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.setBounds(419, 455, 113, 39);
		botaoEntrar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				new Cursor(Cursor.HAND_CURSOR);
			}
		});
		botaoEntrar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String usuario = userLogin.getText();
				
					String senha = new String(passwordLogin.getPassword());
					
					
					if (usuario.equals("sa") && senha.equals("sa")) {
						Janela.getInstace().getCardLayout().show(Janela.getInstace().getPanelPrincipal(), "Menu");	
						JOptionPane.showMessageDialog(panelLogin, "Bem vindo, " + usuario);
					}
					else {
						JOptionPane.showMessageDialog(panelLogin,"Usuário ou senha inválidos.");
						 }
					}
			}
		);
		panelLogin.add(botaoEntrar);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(419, 24, 120, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
		panelLogin.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("Usuário");
		lblUser.setBounds(318, 248, 60, 16);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panelLogin.add(lblUser);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(317, 352, 65, 16);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panelLogin.add(lblSenha);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setForeground(new Color(0, 0, 0));
		passwordLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		passwordLogin.setBounds(317, 372, 320, 51);
		panelLogin.add(passwordLogin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/com/managepro/assets/ManageProLogin.png")));
		lblLogo.setBounds(325, 94, 300, 107);
		panelLogin.add(lblLogo);
		
	}
}
