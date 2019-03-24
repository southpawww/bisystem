package com.bisystem.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bisystem.model.Sales;
import com.bisystem.model.User;

@Repository
public class SalesDaoImpl implements SalesDao {

    private static final Logger logger = LoggerFactory.getLogger(SalesDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listSales() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> salesList =(List<Object[]>) session.createSQLQuery("select nazov as nazov_produktu, count(*) as pocet from predaj\r\n" + 
				"join produkt  on produkt.id_produkt=predaj.produkt_id\r\n" + 
				"group by produkt_id, nazov").list();
		for(Object[] s : salesList){
			logger.info("Sales List::"+s);
		}
		return salesList;
	}
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> salesList =(List<Object[]>) session.createSQLQuery("select * from produkt").list();
		for(Object[] s : salesList){
			logger.info("Produkt List::"+s);
		}
		return salesList;
	}
    
	
}
