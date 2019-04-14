package com.bisystem.service;

import java.util.List;

import com.bisystem.model.Sales;

public interface SalesService {

	public List<Object[]> listSales();
	public List<Object[]> getAllProducts();
	public List<Object[]> getCountySales(String county);
	public List<Object[]> getTopBranches(String date);
	public List<Object[]> getTopSalers(String date);
	public List<Object[]> getDailySales(String date);
}
