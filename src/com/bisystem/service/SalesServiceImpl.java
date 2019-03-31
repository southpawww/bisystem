package com.bisystem.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bisystem.dao.SalesDao;

import com.bisystem.model.Sales;

@Service
public class SalesServiceImpl implements SalesService {

private SalesDao salesDao;
	
	public void setSalesDao(SalesDao salesDao) {
		this.salesDao = salesDao;
	}
	
	
	@Override
	@Transactional
	public List<Object[]> listSales() {
		return this.salesDao.listSales();
	}


	@Override
	@Transactional
	public List<Object[]> getAllProducts() {
		return this.salesDao.getAllProducts();
	}


	@Override
	@Transactional
	public List<Object[]> getCountySales(String county) {
		return this.salesDao.getCountySales(county);
	}


	@Override
	@Transactional
	public List<Object[]> getTopBranches(String date) {
		return this.salesDao.getTopBranches(date);
	}


	@Override
	public List<Object[]> getTopSalers(String date) {
		return this.salesDao.getTopSellers(date);
	}

}
