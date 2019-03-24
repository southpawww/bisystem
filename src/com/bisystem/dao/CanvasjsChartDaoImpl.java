package com.bisystem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bisystem.model.ChartsData;

import com.bisystem.service.SalesService;

public class CanvasjsChartDaoImpl implements CanvasjsChartDao {

	 private  SalesService salesService;
		@Autowired(required=true)
		@Qualifier(value="salesService")
		public void setSalesService(SalesService ps){
			this.salesService = ps;
		}
	
	//chart of product sales
		static Map<Object,Object> map = null;
		static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		    
		    dataPoints1.clear();
		    for(int i=0	;i<salesService.listSales().size();i++) {
		    
		    map = new HashMap<Object,Object>(); map.put("label", salesService.listSales().get(i)[0]); map.put("y", salesService.listSales().get(i)[1]);dataPoints1.add(map);
		    	
		    }
			list.clear();
			list.add(dataPoints1);
			return list;
		}
	// county chart
	static Map<Object,Object> mapCounty = null;
	static List<List<Map<Object,Object>>> listCounty = new ArrayList<List<Map<Object,Object>>>();
	static List<Map<Object,Object>> dataPoints1c = new ArrayList<Map<Object,Object>>();
	static List<Map<Object,Object>> dataPoints2c = new ArrayList<Map<Object,Object>>();
	static List<Map<Object,Object>> dataPoints3c = new ArrayList<Map<Object,Object>>();
	static List<Map<Object,Object>> dataPoints4c= new ArrayList<Map<Object,Object>>();
	@Override
	public List<List<Map<Object, Object>>> getCountyChart() {
        
		dataPoints1c.clear();
		dataPoints2c.clear();
		dataPoints3c.clear();
		dataPoints4c.clear();		
		for(int i =0;i< this.salesService.getAllProducts().size();i++)
		{
			
		}
	//	mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 1262284200000L); mapCounty.put("y", 0.1);dataPoints1c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>();mapCounty.put("label", this.salesService.getAllProducts().get(0)[1]); mapCounty.put("x", 7); mapCounty.put("y", this.salesService.getAllProducts().get(0)[0]);dataPoints1c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>();mapCounty.put("label", "Žilinský kraj"); mapCounty.put("x", 3); mapCounty.put("y", 0.4);dataPoints1c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 4); mapCounty.put("y", 0.4);dataPoints1c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 5); mapCounty.put("y", 0.4);dataPoints1c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 6); mapCounty.put("y", 0.4);dataPoints1c.add(mapCounty);
 
		//mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 1); mapCounty.put("y", 0.1);dataPoints2c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>();mapCounty.put("label", "Bratislavský kraj"); mapCounty.put("x", 1); mapCounty.put("y", 35);dataPoints2c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>();mapCounty.put("label", "Žilinský kraj"); mapCounty.put("x", 3); mapCounty.put("y", 0.1);dataPoints2c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 4); mapCounty.put("y", 0.1);dataPoints2c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 5); mapCounty.put("y", 0.1);dataPoints2c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 6); mapCounty.put("y", 0.2);dataPoints2c.add(mapCounty);
 
	 //   mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 1); mapCounty.put("y", 0.3);dataPoints3c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>();mapCounty.put("label", "Bratislavský kraj"); mapCounty.put("x", "Bratislavský kraj"); mapCounty.put("y", 0.4);dataPoints3c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>();mapCounty.put("label", "Žilinský kraj"); mapCounty.put("x", 3); mapCounty.put("y", 0.4);dataPoints3c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 7); mapCounty.put("y", 0.3);dataPoints3c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 5); mapCounty.put("y", 0.4);dataPoints3c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 6); mapCounty.put("y", 0.4);dataPoints3c.add(mapCounty);
 
	//	mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 1); mapCounty.put("y", 0.4);dataPoints4c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>();mapCounty.put("label", "Bratislavský kraj"); mapCounty.put("x", "Bratislavský kraj"); mapCounty.put("y", 0.5);dataPoints4c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>();mapCounty.put("label", "Žilinský kraj"); mapCounty.put("x", 3); mapCounty.put("y", 0.6);dataPoints4c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 4); mapCounty.put("y", 0.7);dataPoints4c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 5); mapCounty.put("y", 0.8);dataPoints4c.add(mapCounty);
		mapCounty = new HashMap<Object,Object>(); mapCounty.put("x", 6); mapCounty.put("y", 0.8);dataPoints4c.add(mapCounty);
	
		listCounty.add(dataPoints1c);
		listCounty.add(dataPoints2c);
		listCounty.add(dataPoints3c);
		listCounty.add(dataPoints4c);
		return listCounty;
	}
	
	
	
	
	
	
	
}
	

