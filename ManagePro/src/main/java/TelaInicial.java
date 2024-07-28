import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class TelaInicial {

	private JFrame frame;
	private JTextField userLogin;
	private JPasswordField passwordLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shaun\\Downloads\\Novo Projeto (1).png"));
		frame.setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 778, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		userLogin = new JTextField();
		userLogin.setFont(new Font("SansSerif", Font.PLAIN, 11));
		userLogin.setText("Usuário");
		userLogin.setBounds(296, 183, 120, 36);
		userLogin.setForeground(Color.LIGHT_GRAY);
		userLogin.setToolTipText("");
		frame.getContentPane().add(userLogin);
		userLogin.setColumns(10);
		
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String usuario = userLogin.getText();
					String senha = passwordLogin.getText();
					
					if (usuario.equals("rodrigo") && senha.equals("rodrigo123")) 
					{
						JOptionPane.showMessageDialog(frame, "Bem vindo, "+usuario);
					}
					else {
						JOptionPane.showMessageDialog(frame,"Usuário ou senha inválidos.");
						 }
						
					}
			}
		);
		botaoEntrar.setBounds(437, 257, 89, 23);
		frame.getContentPane().add(botaoEntrar);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(296, 35, 104, 58);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(296, 154, 56, 36);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBounds(296, 217, 56, 36);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setFont(new Font("SansSerif", Font.PLAIN, 11));
		passwordLogin.setEchoChar('*');
		passwordLogin.setBounds(296, 244, 120, 36);
		frame.getContentPane().add(passwordLogin);
		
	
		
	}
}
