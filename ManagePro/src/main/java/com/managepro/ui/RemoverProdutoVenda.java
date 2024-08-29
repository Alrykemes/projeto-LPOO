package com.managepro.ui;

import javax.swing.*;

import com.managepro.core.service.LoginService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class RemoverProdutoVenda extends JDialog {
    private JPasswordField txtSenha;
    private boolean confirmado;
    private LoginService loginService;

    public RemoverProdutoVenda(JFrame parent) {
        super(parent, "Editar Produto", true);
        
        loginService = new LoginService();
        
        getContentPane().setLayout(null);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 22));
        lblSenha.setBounds(62, 40, 100, 35);
        getContentPane().add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtSenha.setBounds(63, 74, 179, 35);
        getContentPane().add(txtSenha);

        JButton btnOk = new JButton("OK");
        btnOk.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnOk.setBounds(10, 170, 80, 30);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senhaInserida = new String(txtSenha.getPassword());
                if (loginService.verificarSenha(senhaInserida)) {
                	Janela.getInstance().getTelaNovaVenda().removerProduto(
                			Janela.getInstance().getTelaNovaVenda().getListaProdutos().getSelectedValue());
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
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnCancelar.setBounds(194, 170, 100, 30);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	confirmado = false;
            	dispose();
            }
        });
        getContentPane().add(btnCancelar);

        setSize(320, 250);
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmado() {
        return confirmado;
    }
}