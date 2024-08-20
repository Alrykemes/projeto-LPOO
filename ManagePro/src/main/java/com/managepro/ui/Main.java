package com.managepro.ui;

import java.awt.EventQueue;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import org.apache.commons.collections4.Get;

import com.managepro.core.model.Cargos;
import com.managepro.core.model.Funcionario;
import com.managepro.core.service.FuncionarioService;

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
