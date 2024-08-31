package com.managepro.ui;

import javax.swing.*;

import com.managepro.core.service.GeradorQrCodePix;
import com.managepro.exceptions.ExcecaoDoSistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class QrCodePix extends JDialog {
    private boolean confirmado;
    private BufferedImage qrCodePix;
    private ImageIcon qrCodePixIcon;
    
    public boolean getConfirmacaoPix() {
		return this.confirmado;
	}
    

    public QrCodePix(JFrame parent, BigDecimal valor) {
        super(parent, "PIX", true);
                
        try {
			qrCodePix = GeradorQrCodePix.obterQrCodePix(valor);
			qrCodePixIcon = new ImageIcon(qrCodePix);
		} catch (ExcecaoDoSistema e) {
			JOptionPane.showMessageDialog(parent, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
        
        getContentPane().setLayout(null);

        JLabel qrCodePixImage = new JLabel("");
        qrCodePixImage.setFont(new Font("SansSerif", Font.PLAIN, 22));
        qrCodePixImage.setBounds(38, 26, 350, 350);
        qrCodePixImage.setIcon(qrCodePixIcon);
        getContentPane().add(qrCodePixImage);

        JButton btnOk = new JButton("OK");
        btnOk.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnOk.setBounds(10, 405, 100, 45);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                dispose();
            }
        });
        getContentPane().add(btnOk);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.RED);
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnCancelar.setBounds(302, 405, 122, 45);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	confirmado = false;
            	dispose();
            }
        });
        getContentPane().add(btnCancelar);

        setSize(450, 500);
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmado() {
        return confirmado;
    }
}
