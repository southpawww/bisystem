package com.bisystem.dao;

import java.util.List;

import com.bisystem.model.Sales;

public interface SalesDao {

	public List<Object[]> listSales();
	public List<Object[]> getAllProducts();
	public List<Object[]> getCountySales(String county);
	public List<Object[]> getTopBranches(String date);
	public List<Object[]> getTopSellers(String date);
	
}
