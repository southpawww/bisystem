package com.bisystem.service;

import java.util.List;
import java.util.Map;

public interface CanvasjsChartService {

	public List<List<Map<Object, Object>>> getCanvasjsChartData();
    public List<List<Map<Object, Object>>> getCountyChart();
	public List<List<Map<Object, Object>>> getTopBranches();
	public List<List<Map<Object,Object>>> getTopSellers();
	public List<List<Map<Object,Object>>> getYearSales();

}
