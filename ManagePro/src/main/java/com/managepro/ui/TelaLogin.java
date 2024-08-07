package com.managepro.ui;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class TelaLogin {

	private JFrame frmManagepro;
	private JTextField userLogin;
	private JPasswordField passwordLogin;
	private JPanel panel;
	
	public JFrame getFrame() {
		return this.frmManagepro;
	}
	
	public TelaLogin() {
		initialize();
	}

	private void initialize() {
		frmManagepro = new JFrame();		
		frmManagepro.setTitle("ManagePro");
		frmManagepro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shaun\\Downloads\\Untitled design.png"));
		frmManagepro.setForeground(Color.WHITE);
		frmManagepro.getContentPane().setBackground(Color.WHITE);
		frmManagepro.setResizable(false);
		frmManagepro.setBounds(100, 100, 1024, 680);
		frmManagepro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBounds(0, 0, 1020, 680);
		frmManagepro.getContentPane().add(panel);
		
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
		
		frmManagepro.getContentPane().setLayout(null);
		panel.setLayout(null);
		userLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		userLogin.setForeground(Color.LIGHT_GRAY);
		userLogin.setToolTipText("");
		panel.add(userLogin);
		userLogin.setColumns(10);
		
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.setBounds(419, 455, 113, 39);
		botaoEntrar.addMouseListener(new MouseAdapter() {
		
		});
		botaoEntrar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String usuario = userLogin.getText();
				
					//String senha = passwordLogin.getText();
					// ficou velho ^
					char [] senhaArray = passwordLogin.getPassword();
					String senha = new String(senhaArray);
					
					
					if (usuario.equals("sa") && senha.equals("sa")) {
						TelaMenu menu = new TelaMenu();
						menu.getFrame().setLocationRelativeTo(null);
						getFrame().setVisible(false);
						menu.getFrame().setVisible(true);
						JOptionPane.showMessageDialog(frmManagepro, "Bem vindo, "+usuario);
					}
					else {
						JOptionPane.showMessageDialog(frmManagepro,"Usuário ou senha inválidos.");
						 }
						//java.util.Arrays.fill(senhaArray, '0');
					}
			}
		);
		panel.add(botaoEntrar);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(419, 24, 120, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("Usuário");
		lblUser.setBounds(318, 248, 60, 16);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.add(lblUser);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(317, 352, 65, 16);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.add(lblSenha);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setForeground(new Color(0, 0, 0));
		passwordLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		passwordLogin.setBounds(317, 372, 320, 51);
		panel.add(passwordLogin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/com/managepro/assets/ManagePRO-logo.png")));
		lblLogo.setBounds(325, 94, 300, 107);
		panel.add(lblLogo);
		
		
		
	
		
	}
}
