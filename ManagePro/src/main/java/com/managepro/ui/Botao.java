package com.managepro.ui;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Botao extends JButton {
	public Botao(String texto) {
		super(texto);
		
		addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
		
	}
}
