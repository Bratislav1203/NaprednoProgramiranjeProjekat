/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Klasa koja predstavlja voznju.
 *
 * @author Bratislav
 * @version 1.0
 * @see Drive
 */
public class Drive implements Serializable, IGeneralEntity {

	/**
	 * Privatni atribut koji predstavlja identifikacioni broj voznje.
	 */
	private int id;

	/**
	 * Privatni atribut koji predstavlja instancu klase Costs.
	 */
	private CostList costList;

	/**
	 * Privatni atribut koji predstavlja datum.
	 */
	private Date date;

	/**
	 * Privatni atribut koji predstavlja iznos fakture.
	 */
	private double facturePrice;

	/**
	 * Privatni atribut koji predstavlja prikolicu.
	 */
	private Trailer tr;

	/**
	 * Privatni atribut koji predstavlja kamion.
	 */
	private Truck t;

	/**
	 * Privatni atribut koji predstavlja vozaca.
	 */
	private Driver d;


	/**
	 * Neparametrizovani konstruktor klase Drive.
	 */
	public Drive() {
	}

	/**
	 * Parametrizovani konstruktor klase Drive.
	 * 
	 * @param costList     	troskovi
	 * @param date         	datum
	 * @param facturePrice 	iznos fakture
	 * @param tr           	prikolica
	 * @param t            	kamion
	 * @param d            	vozac
	 */
	public Drive(CostList costList, Date date, double facturePrice, Trailer tr, Truck t, Driver d) {
		this.costList = costList;
		this.date = date;
		this.facturePrice = facturePrice;
		this.tr = tr;
		this.t = t;
		this.d = d;
	}



	public Drive(int int1, java.sql.Date date, double facturePrice, Trailer trailer, Truck truck, Driver driver) {
		id = int1;
		this.date = date;
		this.facturePrice = facturePrice;
		this.tr = trailer;
		this.t = truck;
		this.d = driver;
	}
	
	public Drive(int int1, java.util.Date date, double facturePrice, Trailer trailer, Truck truck, Driver driver) {
		this.date = date;
		this.facturePrice = facturePrice;
		this.tr = trailer;
		this.t = truck;
		this.d = driver;
	}

	public Drive(int cmrNumber, Date date2, double facturePrice2, Trailer tr2, Truck t2, Driver d2, CostList cl) {
		id = cmrNumber;
		date = date2;
		facturePrice = facturePrice2;
		tr = tr2;
		t = t2;
		d = d2;
		costList = cl;
	}

	/**
	 * Metoda koja vraca vozaca sa konkretne voznje.
	 * 
	 * @return vozac
	 */
	public Driver getD() {
		return d;
	}

	/**
	 * Metoda koja postavlja vozaca na konkretnoj voznji.
	 * 
	 * @param d vozac
	 */
	public void setD(Driver d) {
		this.d = d;
	}

	/**
	 * Metoda koja vraca troskove sa konkretne voznje.
	 * 
	 * @return troskovi
	 */
	public CostList getCostList() {
		return costList;
	}

	/**
	 * Metoda koja postavlja troskove sa konkretne voznje.
	 * 
	 * @param cost troskovi
	 */
	public void setCostList(CostList cost) {
		this.costList = cost;
	}

	/**
	 * Metoda koja vraca datum sa konkretne voznje.
	 * 
	 * @return datum
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Metoda koja postavlja datum konkretne voznje.
	 * 
	 * @param date datum
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Metoda koja vraca iznos fakture za voznju.
	 * 
	 * @return iznos fakture
	 */
	public double getFacturePrice() {
		return facturePrice;
	}

	/**
	 * Metoda koja postavlja iznos fakture na novi iznos.
	 * 
	 * @param facturePrice iznos fakture
	 */
	public void setFacturePrice(double facturePrice) {
		this.facturePrice = facturePrice;
	}

	/**
	 * Metoda koja vraca prikolicu koja je na odredjenoj voznji.
	 * 
	 * @return prikolica
	 */
	public Trailer getTr() {
		return tr;
	}

	/**
	 * Metoda koja postavlja prikolicu za konkretnu voznju.
	 * 
	 * @param tr prikolica
	 */
	public void setTr(Trailer tr) {
		this.tr = tr;
	}

	/**
	 * Metoda koja vraca kamion koji je na odredjenoj voznji.
	 * 
	 * @return kamion
	 */
	public Truck getT() {
		return t;
	}

	/**
	 * Metoda koja postavlja kamion za odredjenu voznju.
	 * 
	 * @param t kamion
	 */
	public void setT(Truck t) {
		this.t = t;
	}

	/**
	 * Metoda koja vraca String koji predstavlja naziv relacije u bazi.
	 * 
	 * @return String naziv tabele
	 */
	@Override
	public String getTableName() {
		return "drive";
	}

	/**
	 * Metoda koja pravi listu od result seta za doticnu klasu.
	 * 
	 * @param resultSet tip podatka koji vraca konekcija sa bazom.
	 * @return lista IGeneralEntity
	 * @throws Exception Bacanje instance opsteg izuzetka
	 */
	@Override
	public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
		List<IGeneralEntity> list = new ArrayList<>();
		while (resultSet.next()) {
			double facturePrice = resultSet.getDouble("factureprice");
			Truck truck = new Truck();
			truck.setRegistrationMark(resultSet.getString("truck"));
		
			Trailer trailer = new Trailer();
			trailer.setRegistrationMark(resultSet.getString("trailer"));
			java.sql.Date datumsql = resultSet.getDate("date");
			Driver driver = new Driver();
			
			truck.setProductYear(resultSet.getInt("godina kamiona"));
			truck.setWeight(resultSet.getInt("weight"));
			trailer.setLoadCapacity(resultSet.getInt("dozvoljena tezina"));
			trailer.setWeight(resultSet.getInt("tezina prikolice"));
			trailer.setProductYear(resultSet.getInt("godina prikolice"));
			
			driver.setIDCard(resultSet.getInt("driver"));
			int id = resultSet.getInt("id");
			list.add(new Drive(id, datumsql, facturePrice, trailer, truck, driver));
		}
		return list;
	}

	/**
	 * Metoda koja vraca String vrednosti svih atributa doticne klase.
	 * 
	 * @return String vrednosti svih atributa.
	 */
	@Override
	public String getValues() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.format(date);
		Date date11 = new java.sql.Date(date.getTime());
		return "'" + id + "', '" + date11 + "'" + ", '" + facturePrice + "','" + t.getRegistrationMark() + "','"
				+ tr.getRegistrationMark() + "', '" + d.getIDCard() + "'";
	}

	/**
	 * Metoda koja vraca String nalepljenih svih atributa doticne klase.
	 * 
	 * @return String koji predstavlja sve atribute doticne klase.
	 */
	@Override
	public String getAttributes() {
		return "id, date, factureprice, truck, trailer, driver";
	}

	/**
	 * Metoda sa povratnim tipom String.
	 * 
	 * @return Sring koji predstavlja skup atributa koji se postavljaju.
	 */
	@Override
	public String setAttributes() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.format(date);
		Date d = new java.sql.Date(date.getTime());
		System.out.println(d);
		return "id=" + getId() + ", date='" + d + "', factureprice='" + getFacturePrice() + "', truck='"
				+ getT().getRegistrationMark() + "', trailer='" + getTr().getRegistrationMark() + "'";
	}

	/**
	 * Metoda koja za povratnu vrednost ima String koji predstavlja delete upit za
	 * doticnu tabelu.
	 * 
	 * @return String za delete uslov nad bazom
	 */
	@Override
	public String getDeleteCondition() {
		return "id=" + getId();
	}

	/**
	 * Metoda koja za povratnu vrednost ima String koji predstavlja update upit za
	 * doticnu tabelu.
	 * 
	 * @return String za update uslov nad bazom
	 */
	@Override
	public String getUpdateCondition() {
		return "id = '" + getId() + "'";
	}

	/**
	 * Metoda koja za povratnu vrednost ima String koji predstavlja select upit za
	 * doticnu tabelu.
	 * 
	 * @return String za select uslov nad bazom
	 */
	@Override
	public String getSelectContidion() {
		return "id = '" + getId() + "'";
	}

	/**
	 * Metoda koja vraca identifikacioni broj voznje.
	 * 
	 * @return identifikacioni broj
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metoda koja postavlja odredjeni identifikacioni broj voznje.
	 * 
	 * @param id identifikacioni broj
	 */
	public void setId(int id) {
		this.id = id;
	}

	

	/**
	 * Metoda koja se poziva kada zelimo prikaz instance ove klase.
	 * 
	 * @return string id
	 */
	@Override
	public String toString() {
		return id + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Predefinisana equals metoda za poredjenje objekata.
	 * 
	 * @param obj
	 * @return tacno ili ne
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drive other = (Drive) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
