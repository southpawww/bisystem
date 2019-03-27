package com.bisystem.dao;

import java.util.ArrayList;
import java.util.Collection;
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
	static List<Map<Object, Object>>dataPoints4c= new ArrayList<Map<Object,Object>>();
      
	
	
	
	@Override
	public List<List<Map<Object, Object>>> getCountyChart() {
     	
		
	   if(!listCounty.isEmpty()){
  	   listCounty.clear();
	   }
	   
		for(int i =0; i< this.salesService.getAllProducts().size();i++){
		
			listCounty.add(new ArrayList<Map<Object,Object>>());
		}
		List<Object[]> countySales;
		for(int i =0; i< this.salesService.getAllProducts().size();i++){
			
			countySales = this.salesService.getCountySales((String)this.salesService.getAllProducts().get(i)[0]);
			for(int j =0; j< 8;j++){
			
				mapCounty = new HashMap<Object,Object>();
				mapCounty.put("label",countySales.get(j)[0]); 
				mapCounty.put("x", j+1); 
				mapCounty.put("y", countySales.get(j)[1]); 
				listCounty.get(i).add(mapCounty);    
			}	
			countySales.clear();		
	    }
	
		return listCounty;
    }
	
	
	
}
	

