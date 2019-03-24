package com.bisystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PREDAJ")
public class Sales {

	    @Id
		@Column(name="ID_PREDAJ")
	    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
		@SequenceGenerator(name = "id_Sequence", sequenceName = "PREDAJ_SEQ",allocationSize = 1)
		private int id;
		
	    @Column(name="PREDAJCA_ID")
		private String predajcaId;
		
	    @Column(name="PRODUKT_ID")
		private String produktId;
		
	    @Column(name="KLIENT_ID")
		private String klientId;
	    
	    @Column(name="TIME")
		private Date time;

		public String getPredajcaId() {
			return predajcaId;
		}

		public void setPredajcaId(String predajcaId) {
			this.predajcaId = predajcaId;
		}

		public String getProduktId() {
			return produktId;
		}

		public void setProduktId(String produktId) {
			this.produktId = produktId;
		}

		public String getKlientId() {
			return klientId;
		}

		public void setKlientId(String klientId) {
			this.klientId = klientId;
		}

		public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}
}
