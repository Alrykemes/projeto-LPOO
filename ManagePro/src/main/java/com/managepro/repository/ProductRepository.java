package com.managepro.repository;

import java.sql.SQLException;

import com.managepro.core.model.Produto;

public interface ProductRepository {

	public Produto findProductById(Long id) throws ClassNotFoundException, SQLException;
}
