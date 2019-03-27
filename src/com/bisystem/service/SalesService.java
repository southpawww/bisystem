package com.bisystem.service;

import java.util.List;

import com.bisystem.model.Sales;

public interface SalesService {

	public List<Object[]> listSales();
	public List<Object[]> getAllProducts();
	public List<Object[]> getCountySales(String county);
}
