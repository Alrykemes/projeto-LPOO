package com.managepro.ui;

import java.awt.Font;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.managepro.core.model.Funcionario;
import com.managepro.core.service.LoginService;
import com.managepro.exceptions.ExcecaoDeNegocios;
import com.managepro.exceptions.ExcecaoDoSistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class TelaLogin {

	private JPanel panelLogin;
	private JTextField userLogin;
	private JPasswordField passwordLogin;
	private JButton botaoEntrar;
	private JLabel txtLogin;
	private JLabel txtUser;
	private JLabel txtPassword;
	private JLabel logo;
	private Funcionario funcionarioLogado;

	public JPanel getPanel() {
		return this.panelLogin;
	}

	public JTextField getUserLoginField() {
		return this.userLogin;
	}

	public JTextField getUserPasswordField() {
		return this.passwordLogin;
	}

	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionario) {
		funcionarioLogado = funcionario;
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

		panelLogin.setLayout(null);
		userLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		userLogin.setForeground(Color.BLACK);
		userLogin.setToolTipText("");
		panelLogin.add(userLogin);
		userLogin.setColumns(10);

		botaoEntrar = new JButton("Entrar");
		botaoEntrar.setBounds(419, 455, 113, 39);
		botaoEntrar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					logar();
				} catch (ExcecaoDoSistema | ExcecaoDeNegocios  e1) {
					JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		panelLogin.add(botaoEntrar);

		txtLogin = new JLabel("LOGIN");
		txtLogin.setBounds(419, 24, 120, 32);
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setFont(new Font("SansSerif", Font.PLAIN, 30));
		panelLogin.add(txtLogin);

		txtUser = new JLabel("Usuário");
		txtUser.setBounds(318, 248, 60, 16);
		txtUser.setHorizontalAlignment(SwingConstants.LEFT);
		txtUser.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panelLogin.add(txtUser);

		txtPassword = new JLabel("Senha");
		txtPassword.setBounds(317, 352, 65, 16);
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panelLogin.add(txtPassword);

		passwordLogin = new JPasswordField();
		passwordLogin.setForeground(new Color(0, 0, 0));
		passwordLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		passwordLogin.setBounds(317, 372, 320, 51);
		passwordLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						logar();
					} catch (ExcecaoDoSistema | ExcecaoDeNegocios e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panelLogin.add(passwordLogin);

		logo = new JLabel("");
		logo.setIcon(new ImageIcon(TelaLogin.class.getResource("/com/managepro/assets/ManageProLogin.png")));
		logo.setBounds(325, 94, 300, 107);
		panelLogin.add(logo);

		setEnterAsFocusTrigger(userLogin);
		setEnterAsFocusTrigger(passwordLogin);
	}

	private void logar() throws ExcecaoDoSistema, ExcecaoDeNegocios {

		String usuario = userLogin.getText().trim();
		String senha = new String(passwordLogin.getPassword()).trim();

		if (usuario.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(panelLogin, "Usuário e/ou senha não podem estar vazios.", "Erro de Login",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			LoginService loginService = new LoginService();

			if (loginService.authenticate(userLogin.getText(), new String(passwordLogin.getPassword()))) {
				Janela.getInstance().getCardLayout().show(Janela.getInstance().getPanelPrincipal(), "Menu");
				Janela.getInstance().getPanelPrincipal().repaint();
			} else {
				JOptionPane.showMessageDialog(panelLogin, "Usuário ou senha inválidos.", "Erro de Login",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(panelLogin, e.getMessage(), "Erro de Login", JOptionPane.ERROR_MESSAGE);
		}

	}

	@SuppressWarnings("serial")
	private static void setEnterAsFocusTrigger(JTextField textField) {
		textField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "moveFocus");

		textField.getActionMap().put("moveFocus", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				textField.transferFocus(); // Move o foco para o próximo componente
			}
		});
	}
}