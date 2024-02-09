/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 * Klasa koja predstavlja troskove.
 *
 * @author Bratislav
 * @version 1.0
 *  CostList
 */
public class CostList implements IGeneralEntity {

	/**
	 * Parametrizovani konstruktor koji inicijalizuje listu troskova.
	 * 
	 * @param id - id liste troskova
	 */
	public CostList(int id) {
		super();
		setId(id);
	}

	/**
	 * Privatni atribut koji predstavlja identifikacioni broj voznje.
	 */
	private int id;
	/**
	 * Privatni atribut koji predstavlja listu svih troskova.
	 */
	private List<CostItem> costs;
	/**
	 * Privatni atribut koji predstavlja voznju na koju se troskovi odnose.
	 */
	private Drive drive;
	/**
	 * Privatni atribut koji predstavlja iznos ukupnog troska.
	 */
	private double inTotal;

	/**
	 * Neparametrizovani konstruktor klase Costs.
	 */
	public CostList() {
		costs = new ArrayList<>();
	}

	/**
	 * Parametrizovani konstruktor klase Costs koji incijalizuje objekte ove klase.
	 * 
	 * @param costs listaTroskova
	 * @param drive voznja na koju se lista odnosi
	 */
	public CostList(List<CostItem> costs, Drive drive) {
		setCosts(costs);
		setDrive(drive);
		if (this.costs != null)
			setInTotal(izracunajZbirTroskova(costs));
	}



	/**
	 * Parametrizovani konstruktor klase Costs koji incijalizuje objekte ove klase.
	 * 
	 * @param total ukupni troskovi
	 * @param drive voznja na koju se lista odnosi
	 * @param id - id liste troskova
	 */
	public CostList(int id, double total, Drive drive) {
		setId(id);
		setDrive(drive);
		if (this.costs != null)
			setInTotal(izracunajZbirTroskova(costs));
	}

	/**
	 * Izračunava zbir svih troškova u listi.
	 * 
	 * @param costs lista troškova za koje treba izračunati zbir.
	 * @return zbir iznosa svih troškova u listi.
	 */
	private double izracunajZbirTroskova(List<CostItem> costs) {
	    double zbir = 0;
	    for (CostItem cost : costs) {
	        zbir += cost.getAmount();
	    }
	    return zbir;
	}


	/**
	 * Vraća vožnju kojoj pripadaju troškovi.
	 * 
	 * @return objekat vožnje kojoj pripadaju troškovi.
	 */
	public Drive getDrive() {
	    return drive;
	}


	/**
	 * Postavlja vožnju kojoj pripadaju troškovi. Vožnja ne sme biti {@code null},
	 * čime se osigurava da svaki skup troškova ima jasno definisanu vožnju kojoj pripada.
	 * Ova provera je ključna za praćenje troškova u kontekstu specifičnih vožnji
	 * i sprečava asocijativne greške u radu aplikacije.
	 * 
	 * @param drive objekat vožnje kojoj pripadaju troškovi.
	 * @throws IllegalArgumentException ako je prosleđeni objekat vožnje {@code null}.
	 */
	public void setDrive(Drive drive) {
		if(drive == null) {
			throw new IllegalArgumentException("Drive ne sme biti null");
		}
	    this.drive = drive;
	}

	/**
	 * Vraća identifikator liste troškova.
	 * 
	 * @return identifikator liste troškova.
	 */
	public int getId() {
	    return id;
	}


    /**
     * Postavlja identifikacioni broj listi troskova nakon provere da je uneti identifikacioni broj pozitivan.
     * Ako je prosleđeni identifikacioni broj manji ili jednak 0, baca se {@code IllegalArgumentException}
     * sa porukom da identifikacioni broj mora biti veći od 0.
     * 
     * @param id identifikacioni broj koji se postavlja listi troskova.
     * @throws IllegalArgumentException ako je {@code id} manji ili jednak 0.
     */
	public void setId(int id) {
	    if (id <= 0) {
	        throw new IllegalArgumentException("ID mora biti veći od 0.");
	    }
	    this.id = id;
	}

	/**
	 * Vraća listu troškova.
	 * 
	 * @return lista troškova.
	 */
	public List<CostItem> getCosts() {
	    return costs;
	}


	/**
	 * Postavlja novu listu troškova za objekat. Lista troškova ne sme biti {@code null},
	 * čime se osigurava da objekat uvek ima definisanu listu troškova, čak i ako je lista prazna.
	 * Ova provera pomaže u održavanju integriteta podataka i sprečava greške u radu aplikacije
	 * uzrokovane neinicijalizovanim listama.
	 * 
	 * @param costs nova lista troškova koja se postavlja za objekat.
	 * @throws IllegalArgumentException ako je prosleđena lista troškova {@code null}.
	 */
	public void setCosts(List<CostItem> costs) {
		if (costs == null) {
	        throw new IllegalArgumentException("Troskovi ne smeju biti null.");
	    }
	    this.costs = costs;
	}


	/**
	 * Metoda koja vraca zbir svih troskova
	 * 
	 * @return zbir svih troskova
	 */
	public double getInTotal() {
		return inTotal;
	}

	public void dodajTrosakUTotal(CostItem costItem) {
		inTotal += costItem.getAmount();
	}

	/**
	 * Metoda koja postavlja zbir svih troskova
	 * 
	 * @param inTotal zbir svih troskova
	 */
	public void setInTotal(double inTotal) {
		this.inTotal = inTotal;
	}

	/**
	 * Metoda koja vraca String koji predstavlja naziv relacije u bazi.
	 * 
	 * @return String naziv tabele
	 */
	@Override
	public String getTableName() {
		return "costlist";

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
			double total = resultSet.getDouble("total");
			Drive drive = new Drive();
			drive.setId(resultSet.getInt("drive"));
			list.add(new CostList(resultSet.getInt("id"), total, drive));
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
		return "'" + id + "', '" + inTotal + "'" + ", '" + drive.getId() + "'";
	}

	/**
	 * Metoda koja vraca String nalepljenih svih atributa doticne klase.
	 * 
	 * @return String koji predstavlja sve atribute doticne klase.
	 */
	@Override
	public String getAttributes() {
		return "id, total, drive";
	}

	/**
	 * Metoda sa povratnim tipom String.
	 * 
	 * @return Sring koji predstavlja skup atributa koji se postavljaju.
	 */
	@Override
	public String setAttributes() {
		return "id=" + getId() + "', total='" + getInTotal() + "', drive='" + getDrive().getId() + "'";
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
		return "id=" + getId();
	}

	/**
	 * Metoda koja za povratnu vrednost ima String koji predstavlja select upit za
	 * doticnu tabelu.
	 * 
	 * @return String za select uslov nad bazom
	 */
	@Override
	public String getSelectContidion() {
		return "id=" + getId();
	}

}
