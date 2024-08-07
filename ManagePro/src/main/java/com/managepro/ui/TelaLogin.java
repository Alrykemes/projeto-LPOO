package com.managepro.ui;

<<<<<<< HEAD
import javax.swing.JFrame;


=======
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
<<<<<<< HEAD
=======
import javax.swing.ImageIcon;
import javax.swing.JButton;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
<<<<<<< HEAD
import java.awt.Toolkit;
=======
import java.awt.event.MouseAdapter;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;

public class TelaLogin {

<<<<<<< HEAD
	private JFrame frmManagepro;
	private JTextField campoUsuario;
	private JPasswordField campoSenha;
	private JPanel panel;
=======
	private JPanel panelLogin;
	private JTextField userLogin;
	private JPasswordField passwordLogin;
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
	
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
<<<<<<< HEAD
		frmManagepro = new JFrame();		
		frmManagepro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/com/managepro/assets/manageIcon.png")));
		frmManagepro.setTitle("ManagePro");
		frmManagepro.setForeground(Color.WHITE);
		frmManagepro.getContentPane().setBackground(Color.WHITE);
		frmManagepro.setResizable(false);
		frmManagepro.setBounds(100, 100, 1024, 680);
		frmManagepro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1024, 680);
		frmManagepro.getContentPane().add(panel);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(360, 225, 290, 40);
		campoUsuario.addFocusListener(new FocusAdapter() {
=======
		panelLogin = new JPanel();		
		panelLogin.setBackground(Color.WHITE);
		panelLogin.setBounds(0, 0, 1024, 680);
		
		userLogin = new JTextField();
		userLogin.setBounds(317, 268, 320, 51);
		userLogin.addFocusListener(new FocusAdapter() {
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
			public void focusGained(FocusEvent e) {
				campoUsuario.setText("");
				campoUsuario.setForeground(Color.black);
			}
			public void focusLost(FocusEvent e) {
                if (campoUsuario.getText().isEmpty()) {
                    campoUsuario.setText("Usuário");
                    campoUsuario.setForeground(Color.LIGHT_GRAY);
                }
            }
		});
		
<<<<<<< HEAD
		frmManagepro.getContentPane().setLayout(null);
		panel.setLayout(null);
		campoUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoUsuario.setForeground(Color.LIGHT_GRAY);
		campoUsuario.setToolTipText("");
		panel.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel labelTitulo = new JLabel("LOGIN");
		labelTitulo.setBounds(425, 95, 150, 30);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("SansSerif", Font.PLAIN, 30));
		panel.add(labelTitulo);
		
		JLabel labelUsuario = new JLabel("Usuário");
		labelUsuario.setBounds(360, 205, 60, 15);
		labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		labelUsuario.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.add(labelUsuario);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(360, 275, 45, 15);
		labelSenha.setHorizontalAlignment(SwingConstants.LEFT);
		labelSenha.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.add(labelSenha);
		
		campoSenha = new JPasswordField();
		campoSenha.setForeground(new Color(0, 0, 0));
		campoSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		campoSenha.setBounds(360, 295, 290, 40);
		panel.add(campoSenha);
		
		Botao botaoEntrar = new Botao("Entrar");
		botaoEntrar.setBounds(450, 360, 115, 40);
=======
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
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
		botaoEntrar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String usuario = campoUsuario.getText();
				
<<<<<<< HEAD
					//String senha = passwordLogin.getText();
					// ficou velho ^
					char [] senhaArray = campoSenha.getPassword();
					String senha = new String(senhaArray);
=======
					String senha = new String(passwordLogin.getPassword());
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
					
					
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
<<<<<<< HEAD
		
		panel.add(botaoEntrar);
=======
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
		
>>>>>>> 3e2d2b8bb61d0847ffe527d238c0239bd88fa712
	}
}
