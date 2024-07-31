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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;

public class TelaInicial {

	private JFrame frame;
	private JTextField userLogin;
	private JPasswordField passwordLogin;
	private JPanel panel;
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shaun\\Downloads\\Untitled design.png"));
		frame.setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 778, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBounds(0, 0, 762, 434);
		frame.getContentPane().add(panel);
		
		userLogin = new JTextField();
		userLogin.setBounds(240, 199, 267, 32);
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
		
		frame.getContentPane().setLayout(null);
		panel.setLayout(null);
		userLogin.setFont(new Font("SansSerif", Font.PLAIN, 11));
		userLogin.setForeground(Color.LIGHT_GRAY);
		userLogin.setToolTipText("");
		panel.add(userLogin);
		userLogin.setColumns(10);
		
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.setBounds(332, 326, 74, 32);
		botaoEntrar.addMouseListener(new MouseAdapter() {
		
		});
		botaoEntrar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String usuario = userLogin.getText();
				
					String senha = passwordLogin.getText();
					// ficou velho ^
					//char [] senhaArray = passwordLogin.getPassword();
					 //String senha = new String(senhaArray);
					 //System.out.print(senha);
					
					if (usuario.equals("rodrigo") && senha.equals("rodrigo123")) 
					{
						JOptionPane.showMessageDialog(frame, "Bem vindo, "+usuario);
					}
					else {
						JOptionPane.showMessageDialog(frame,"Usuário ou senha inválidos.");
						 }
						//java.util.Arrays.fill(senhaArray, '0');
					}
			}
		);
		panel.add(botaoEntrar);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(332, 11, 74, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(240, 181, 53, 16);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBounds(240, 253, 46, 16);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		panel.add(lblNewLabel_1_1);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setForeground(new Color(0, 0, 0));
		passwordLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordLogin.setBounds(240, 271, 267, 32);
		panel.add(passwordLogin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\shaun\\Downloads\\ManagePRO-removebg-preview 1 (1).png"));
		lblNewLabel_2.setBounds(240, 76, 267, 75);
		panel.add(lblNewLabel_2);
		
		
		
	
		
	}
}
