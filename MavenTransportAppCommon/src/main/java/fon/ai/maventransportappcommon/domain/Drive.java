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
 *  Drive
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
	 * @param date         	datum
	 * @param facturePrice 	iznos fakture
	 * @param trailer		prikolica
	 * @param truck	    	kamion
	 * @param driver       	vozac
	 * @param costList      lista troskova
	 */
	public Drive(int cmrNumber, Date date, double facturePrice, Trailer trailer, Truck truck, Driver driver, CostList costList) {
		setId(cmrNumber);
		setDate(date);
		setFacturePrice(facturePrice);
		setT(truck);
		setTr(trailer);
		setD(driver);
		setCostList(costList);
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
		setDate(date);
		setFacturePrice(facturePrice);
		setT(t);
		setTr(tr);
		setD(d);
		setCostList(costList);
	}




	/**
	 * Parametrizovani konstruktor klase Drive.
	 * 
	 * @param date         	datum
	 * @param facturePrice 	iznos fakture
	 * @param trailer		prikolica
	 * @param truck	    	kamion
	 * @param driver       	vozac
	 */
	public Drive(int int1, java.util.Date date, double facturePrice, Trailer trailer, Truck truck, Driver driver) {
		setDate(date);
		setFacturePrice(facturePrice);
		setT(truck);
		setTr(trailer);
		setD(driver);
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
	 * Postavlja vozača za konkretnu vožnju nakon provere da vozač nije {@code null}.
	 * Ovo osigurava da svaka vožnja ima dodeljenog vozača pre nego što se izvrši,
	 * što je ključni element za uspešno realizovanje vožnje.
	 * 
	 * @param d vozač koji se dodeljuje vožnji.
	 * @throws IllegalArgumentException ako je {@code d} null, što ukazuje da vozač
	 * nije određen za vožnju.
	 */
	public void setD(Driver d) {
		if (d == null) {
	        throw new IllegalArgumentException("Vozac ne sme biti null.");
	    }
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
	 * Postavlja listu troškova za konkretnu vožnju nakon provere da lista troškova nije {@code null}.
	 * Ovo omogućava precizno praćenje i upravljanje troškovima povezanim sa svakom vožnjom,
	 * čime se doprinosi efikasnom upravljanju finansijama.
	 * 
	 * @param costList lista troškova koja se dodeljuje vožnji.
	 * @throws IllegalArgumentException ako je {@code costList} null, što ukazuje na nedostatak
	 * definisanih troškova za vožnju.
	 */
	public void setCostList(CostList costList) {
		if (costList == null) {
	        throw new IllegalArgumentException("Lista troskova ne sme biti null.");
	    }
		this.costList = costList;
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
	 * Postavlja datum konkretne vožnje nakon provere da uneti datum nije u budućnosti.
	 * Ova provera osigurava da datum vožnje odgovara realnom vremenskom periodu i sprečava
	 * unos datuma koji još nisu nastupili. Ako je prosleđeni datum u budućnosti, baca se
	 * {@code IllegalArgumentException} sa odgovarajućom porukom.
	 * 
	 * @param date datum vožnje koji se postavlja.
	 * @throws IllegalArgumentException ako je {@code date} datum u budućnosti.
	 */
	public void setDate(Date date) {
		 if (date.after(new Date())) {
		        throw new IllegalArgumentException("Datum mora biti u prošlosti.");
		    }
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
	 * Postavlja iznos fakture na novi iznos nakon provere da je uneti iznos pozitivan.
	 * Ovo osigurava da iznos fakture odražava stvarnu vrednost i sprečava unos negativnih
	 * ili nultih vrednosti koje nisu validne u kontekstu fakturisanja.
	 * 
	 * @param facturePrice novi iznos fakture koji se postavlja.
	 * @throws IllegalArgumentException ako je {@code facturePrice} manji ili jednak 0,
	 * što ukazuje na nevalidan iznos fakture.
	 */
	public void setFacturePrice(double facturePrice) {
		if (facturePrice <= 0) {
	        throw new IllegalArgumentException("Iznos fakture mora biti veći od 0.");
	    }
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
	 * Postavlja prikolicu za konkretnu vožnju nakon provere da prikolica nije {@code null}.
	 * Ovo omogućava da vožnja uključuje prikolicu kad je to potrebno, osiguravajući
	 * kompletiranje svih elemenata vožnje pre njenog izvršavanja.
	 * 
	 * @param tr prikolica koja se dodeljuje vožnji.
	 * @throws IllegalArgumentException ako je {@code tr} null, što ukazuje da prikolica
	 * nije određena za vožnju.
	 */
	public void setTr(Trailer tr) {
		if (tr == null) {
	        throw new IllegalArgumentException("Prikolica ne sme biti null.");
	    }
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
	 * Postavlja kamion za određenu vožnju nakon provere da kamion nije {@code null}.
	 * Ovo osigurava da svaka vožnja ima dodeljen kamion pre nego što se izvrši,
	 * sprečavajući time vožnju bez odgovarajućeg vozila.
	 * 
	 * @param t kamion koji se dodeljuje vožnji.
	 * @throws IllegalArgumentException ako je {@code t} null, što ukazuje da kamion
	 * nije određen za vožnju.
	 */
	public void setT(Truck t) {
		if (t == null) {
	        throw new IllegalArgumentException("Kamion ne sme biti null.");
	    }
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
			
			list.add(new Drive(id, datumsql, facturePrice, trailer, truck, driver, new CostList(id)));
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
		return "d.id = '" + getId() + "'";
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
	 * Postavlja određeni identifikacioni broj vožnje nakon provere da je uneti broj pozitivan.
	 * Ovo osigurava da svaka vožnja ima jedinstveni i validan identifikacioni broj veći od 0.
	 * Ako je prosleđeni identifikacioni broj manji ili jednak 0, baca se
	 * {@code IllegalArgumentException} sa odgovarajućom porukom da ID mora biti veći od 0.
	 * 
	 * @param id identifikacioni broj vožnje koji se postavlja.
	 * @throws IllegalArgumentException ako je {@code id} manji ili jednak 0.
	 */
	public void setId(int id) {
		if (id <= 0) {
	        throw new IllegalArgumentException("ID mora biti veći od 0.");
	    }
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
