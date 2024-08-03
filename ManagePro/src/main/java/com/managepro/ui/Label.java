package com.managepro.ui;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Label extends JLabel {
    
    public Label(String text) {
        super(text);
        
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }
}
