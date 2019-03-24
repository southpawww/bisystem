package com.bisystem.dao;

import java.util.List;

import com.bisystem.model.Sales;

public interface SalesDao {

	public List<Object[]> listSales();
	public List<Object[]> getAllProducts();
}
