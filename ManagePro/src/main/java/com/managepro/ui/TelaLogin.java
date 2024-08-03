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
		frmManagepro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/com/managepro/assets/manageIcon.png")));
		frmManagepro.setTitle("ManagePro");
		frmManagepro.setForeground(Color.WHITE);
		frmManagepro.getContentPane().setBackground(Color.WHITE);
		frmManagepro.setResizable(false);
		frmManagepro.setBounds(100, 100, 1024, 680);
		frmManagepro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBounds(0, 0, 1020, 680);
		frmManagepro.getContentPane().add(panel);
		
		userLogin = new JTextField();
		userLogin.setBounds(361, 224, 292, 40);
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
		botaoEntrar.setBounds(451, 357, 113, 39);
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
		lblNewLabel.setBounds(426, 96, 148, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(362, 204, 60, 16);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBounds(361, 275, 46, 16);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.add(lblNewLabel_1_1);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setForeground(new Color(0, 0, 0));
		passwordLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		passwordLogin.setBounds(361, 295, 292, 40);
		panel.add(passwordLogin);
		
		
		
	
		
	}
}
