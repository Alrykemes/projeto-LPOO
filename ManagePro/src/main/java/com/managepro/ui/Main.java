package com.managepro.ui;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) throws Exception {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela.getInstance().getFrame().setVisible(true);;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
