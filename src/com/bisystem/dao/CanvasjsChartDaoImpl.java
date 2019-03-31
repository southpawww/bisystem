package com.bisystem.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
		    for(int i=0	;i<salesService.listSales().size();i++){
		    
		    map = new HashMap<Object,Object>();
		    map.put("label", salesService.listSales().get(i)[0]); 
		    map.put("y", salesService.listSales().get(i)[1]);
		    dataPoints1.add(map);
		    	
		    }
			list.clear();
			list.add(dataPoints1);
			return list;
		}
	// county chart
	static Map<Object,Object> mapCounty = null;
	static List<List<Map<Object,Object>>> listCounty = new ArrayList<List<Map<Object,Object>>>();

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
     
	static List<List<Map<Object,Object>>> listBranches = new ArrayList<List<Map<Object,Object>>>();
	static Map<Object,Object> mapBranch = null;
	@Override
	public List<List<Map<Object, Object>>> getTopBranches() {
		 if(!listBranches.isEmpty()){
			 listBranches.clear();
			   }
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("01-MMM-yy");
		String a = ft.format(date);
		List<Object[]> branchSales= this.salesService.getTopBranches(a);;
		for(int i =0; i< this.salesService.getTopBranches(a).size();i++){
			
			listBranches.add(new ArrayList<Map<Object,Object>>());
		}
		branchSales = this.salesService.getTopBranches(a);
         for(int i =0; i< this.salesService.getTopBranches(a).size();i++){

        	 mapBranch = new HashMap<Object,Object>();
        	 mapBranch.put("name",branchSales.get(i)[0]); 
        	 mapBranch.put("sales",branchSales.get(i)[1]); 
        	 listBranches.get(i).add(mapBranch);    
        	
	    }
		
		return listBranches;
	}
	@Override
	public List<List<Map<Object, Object>>> getYearSales() {
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		List<Map<Object,Object>> dataPoints2 = new ArrayList<Map<Object,Object>>();
		List<Map<Object,Object>> dataPoints3 = new ArrayList<Map<Object,Object>>();
		
	
			map = new HashMap<Object,Object>(); map.put("x", 1136053800000L); map.put("y", 38.4);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1167589800000L); map.put("y", 38.3);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1199125800000L); map.put("y", 36.9);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1230748200000L); map.put("y", 34.8);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1262284200000L); map.put("y", 34.9);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1293820200000L); map.put("y", 35.1);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1325356200000L); map.put("y", 34.9);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1356978600000L); map.put("y", 37.9);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1388514600000L); map.put("y", 38.3);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1420050600000L); map.put("y", 41.9);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1451586600000L); map.put("y", 40.3);dataPoints1.add(map);
			
			map = new HashMap<Object,Object>(); map.put("x", 1136053800000L); map.put("y", 29);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1167589800000L); map.put("y", 28.5);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1199125800000L); map.put("y", 33.4);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1230748200000L); map.put("y", 21.3);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1262284200000L); map.put("y", 20.2);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1293820200000L); map.put("y", 19.2);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1325356200000L); map.put("y", 21.5);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1356978600000L); map.put("y", 15.7);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1388514600000L); map.put("y", 15.7);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1420050600000L); map.put("y", 16);dataPoints2.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1451586600000L); map.put("y", 23.2);dataPoints2.add(map);
			
			map = new HashMap<Object,Object>(); map.put("x", 1136053800000L); map.put("y", 29.9);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1167589800000L); map.put("y", 18.5);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1199125800000L); map.put("y", 14.9);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1230748200000L); map.put("y", 15.6);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1262284200000L); map.put("y", 10);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1293820200000L); map.put("y", 7.8);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1325356200000L); map.put("y", 9.2);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1356978600000L); map.put("y", 11.7);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1388514600000L); map.put("y", 9.3);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1420050600000L); map.put("y", 13.6);dataPoints3.add(map);
			map = new HashMap<Object,Object>(); map.put("x", 1451586600000L); map.put("y", 14);dataPoints3.add(map);
			
			list.add(dataPoints1);
			list.add(dataPoints2);
			list.add(dataPoints3);
		
	 
		
		return list;
		
	}
	
	static List<List<Map<Object,Object>>> listSelers = new ArrayList<List<Map<Object,Object>>>();
	static Map<Object,Object> mapSelers = null;
	@Override
	public List<List<Map<Object, Object>>> getTopSellers() {
		
			 if(!listSelers.isEmpty()){
				 listSelers.clear();
				   }
			Date date = new Date();
			SimpleDateFormat ft = new SimpleDateFormat ("01-MMM-yy");
			String a = ft.format(date);
			List<Object[]> branchSales= this.salesService.getTopSalers(a);
			for(int i =0; i< this.salesService.getTopSalers(a).size();i++){
				
				listSelers.add(new ArrayList<Map<Object,Object>>());
			}
	         for(int i =0; i< this.salesService.getTopBranches(a).size();i++){

	        	 mapSelers = new HashMap<Object,Object>();
	        	 mapSelers.put("name",branchSales.get(i)[0]); 
	        	 mapSelers.put("surname",branchSales.get(i)[1]); 
	        	 mapSelers.put("sales",branchSales.get(i)[2]); 
	        	 listSelers.get(i).add(mapSelers);    
	        	
		    }
			
			return listSelers;
	}
	
	
	
}
	

