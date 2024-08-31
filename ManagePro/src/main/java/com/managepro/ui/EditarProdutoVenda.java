package com.managepro.ui;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import com.managepro.core.service.LoginService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class EditarProdutoVenda extends JDialog {
    private JFormattedTextField txtCodigo;
    private JFormattedTextField txtQuantidade;
    private JPasswordField txtSenha;
    private LoginService loginService;
    private boolean confirmado;

    public EditarProdutoVenda(JFrame parent) throws ParseException {
    	super(parent, "Editar Produto", true);

    	loginService = new LoginService();
    	
        getContentPane().setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblCodigo.setBounds(98, 11, 80, 25);
        getContentPane().add(lblCodigo);

        MaskFormatter maskCod = new MaskFormatter("**************");
        maskCod.setValidCharacters("0123456789");
        maskCod.setAllowsInvalid(false);
        
        txtCodigo = new JFormattedTextField(maskCod);
        txtCodigo.setFocusLostBehavior(JFormattedTextField.PERSIST);
        txtCodigo.setBounds(98, 37, 194, 25);
        getContentPane().add(txtCodigo);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(98, 86, 100, 25);
        lblQuantidade.setFont(new Font("SansSerif", Font.PLAIN, 18));
        getContentPane().add(lblQuantidade);

        MaskFormatter maskQtd = new MaskFormatter("******");
        maskCod.setValidCharacters("0123456789");
        maskCod.setAllowsInvalid(false);
        
        txtQuantidade = new JFormattedTextField(maskQtd);
        txtQuantidade.setBounds(98, 112, 194, 25);
        txtQuantidade.setFocusLostBehavior(JFormattedTextField.PERSIST);
        getContentPane().add(txtQuantidade);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(98, 157, 61, 25);
        lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
        getContentPane().add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(98, 182, 194, 25);
        getContentPane().add(txtSenha);

        JButton btnOk = new JButton("OK");
        btnOk.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnOk.setBounds(10, 245, 80, 30);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senhaInserida = new String(txtSenha.getPassword());
                if (loginService.verificarSenha(senhaInserida)) {
                	
                	Janela.getInstance().getTelaNovaVenda().removerProduto(
                			Janela.getInstance().getTelaNovaVenda().getListaProdutos().getSelectedValue());
                	Janela.getInstance().getTelaNovaVenda().adicionarProduto(txtCodigo, txtQuantidade);
                	
                    confirmado = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(parent, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        getContentPane().add(btnOk);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.RED);
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnCancelar.setBounds(294, 245, 100, 30);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = false;
                dispose();
            }
        });
        getContentPane().add(btnCancelar);

        setSize(420, 325);
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public JFormattedTextField getCodigo() {
        return this.txtCodigo;
    }

    public JFormattedTextField getQuantidade() {
        return this.txtQuantidade;
    }

	public void setTxtCodigo(Long codigo) {
		this.txtCodigo.setText(String.valueOf(codigo));	}

	public void setTxtQuantidade(int quantidade) {
		this.txtQuantidade.setText(String.valueOf(quantidade));
	}
    
}
