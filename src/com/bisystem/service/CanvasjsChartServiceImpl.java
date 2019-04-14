package com.bisystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import com.bisystem.dao.CanvasjsChartDao;

@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService {

	@Autowired
	private CanvasjsChartDao canvasjsChartDao;
 
	public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
		this.canvasjsChartDao = canvasjsChartDao;
	}
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return this.canvasjsChartDao.getCanvasjsChartData();
	}

	@Override
	public List<List<Map<Object, Object>>> getCountyChart() {
		return this.canvasjsChartDao.getCountyChart();
	}
	
	@Override
	@Transactional
	public List<List<Map<Object, Object>>> getTopBranches() {
		return this.canvasjsChartDao.getTopBranches();
	}

	@Override
	@Transactional
	public List<List<Map<Object, Object>>> getYearSales() {
				return this.canvasjsChartDao.getYearSales();
	}

	@Override
	@Transactional
	public List<List<Map<Object, Object>>> getTopSellers() {
		return this.canvasjsChartDao.getTopSellers();
	}

	@Override
	public List<List<Map<Object, Object>>> getDailySales() {
		return this.canvasjsChartDao.getDailySales();

	}
}
