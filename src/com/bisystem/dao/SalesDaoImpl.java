package com.bisystem.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
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
		List<Object[]> salesList =(List<Object[]>) session.createSQLQuery("select pr.nazov as pnazov, count(*) from kraj k"
				+ " join okres o on o.kraj_id = k.id_kraj"
				+ " join mesto m on m.okres_id = o.id_okres"
				+ " join klient k on k.mesto_id = m.id_mesto"
				+ " join predaj p on p.klient_id = k.id_klient"
				+ " join produkt pr on pr.id_produkt = p.produkt_id "
				+"group by pr.nazov"
			).list();
		for(Object[] s : salesList){
			logger.info("Produkt List::"+s);
		}
		return salesList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getCountySales(String product) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> countySales =(List<Object[]>) session.createSQLQuery(
				"select k.nazov, count(pr.id_predaj) as meno from kraj k "
				+"left join okres o on o.kraj_id = k.id_kraj "
				+"left join mesto m on m.okres_id = o.id_okres "
				+"left join klient kl on kl.mesto_id = m.id_mesto "
				+"left join predaj pr on pr.klient_id = kl.id_klient and pr.produkt_id in (select id_produkt from produkt where nazov in :product ) "
				+"left join produkt p on p.id_produkt = pr.produkt_id "  
				+"group by k.nazov").setParameter("product", product)
				.list();
		     
		for(Object[] s : countySales){
			logger.info("CountySales List:"+s);
		}
		
		
		return countySales;		
		
	}
    
	
	
}
