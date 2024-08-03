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
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;

public class TelaLogin {

	private JFrame frmManagepro;
	private JTextField campoUsuario;
	private JPasswordField campoSenha;
	private JPanel panel;
	
	public JFrame getFrame() {
		return this.frmManagepro;
	}
	
	public TelaLogin() {
		initialize();
	}

	private void initialize() {
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
		botaoEntrar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String usuario = campoUsuario.getText();
				
					//String senha = passwordLogin.getText();
					// ficou velho ^
					char [] senhaArray = campoSenha.getPassword();
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
	}
}
