package com.bisystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return canvasjsChartDao.getCanvasjsChartData();
	}

	@Override
	public List<List<Map<Object, Object>>> getCountyChart() {
		return canvasjsChartDao.getCountyChart();
	}
}
