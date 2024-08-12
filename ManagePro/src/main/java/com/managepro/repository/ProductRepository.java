package com.managepro.repository;

import java.sql.SQLException;

import com.managepro.core.model.Produto;

public interface ProductRepository {

	public void newProduct(Produto produto) throws ClassNotFoundException, SQLException;
}
