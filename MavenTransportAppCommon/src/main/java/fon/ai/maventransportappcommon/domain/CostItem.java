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
 * Klasa koja predstavlja trosak.
 *
 * @author Bratislav
 * @version 1.0
 *  CostItem
 */
public class CostItem implements Serializable, IGeneralEntity {

	/**
	 * Privatni atribut koji predstavlja vrstu troska.
	 */
	private int id;
	/**
	 * Privatni atribut koji predstavlja vrstu troska.
	 */
	private CostType costType;

	/**
	 * Privatni atribut koji predstavlja iznos troska.
	 */
	private double amount;

	/**
	 * Privatni atribut koji predstavlja listu troskova kojima pripada.
	 */
	private CostList costList;

	/**
	 * Parametrizovani konstruktor koji inicijalizuje trosak.
	 * 
	 * @param costType tip troska
	 * @param amount   iznos
	 */
	public CostItem(CostType costType, double amount, CostList costList) {
		setCostType(costType);
		setAmount(amount);
		setCostList(costList);
	}

	/**
	 * Neparametrizovani konstruktor klase Trosak.
	 */
	public CostItem() {
	}

	/**
	 * Parametrizovani konstruktor za inicijalizaciju troska.
	 * 
	 * @param costType tip troska
	 * @param amount   iznos
	 */
	public CostItem(CostType costType, double amount) {
		setCostType(costType);
		setAmount(amount);
	}

	/**
	 * Metoda koja vraca String koji predstavlja naziv relacije u bazi.
	 * 
	 * @return String naziv tabele
	 */
	@Override
	public String getTableName() {
		return "costitem";
	}

	/**
	 * Metoda koja vraca listu troskova.
	 * 
	 * @return costList lista troskova
	 */
	public CostList getCostList() {
		return costList;
	}

	/**
	 * Postavlja listu troškova. Lista troškova je ključna za praćenje i upravljanje
	 * svim troškovima povezanim sa specifičnim entitetom ili aktivnošću. Proverava se
	 * da lista troškova nije {@code null} kako bi se osiguralo da je svaki entitet
	 * ili aktivnost pravilno povezan(a) sa svojom listom troškova. Ova provera je važna
	 * za održavanje integriteta podataka unutar sistema.
	 * 
	 * @param costList lista troškova koja se postavlja.
	 * @throws IllegalArgumentException ako je {@code costList} null, što ukazuje
	 * na pokušaj disasocijacije entiteta ili aktivnosti od svih troškova.
	 */
	public void setCostList(CostList costList) {
		if (costList == null) {
	        throw new IllegalArgumentException("CostList ne sme biti null");
	    }
		this.costList = costList;
	}
	/**
	 * Metoda koja vraca id troska.
	 * 
	 * @return id troska
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja identifikacioni broj (ID) troška, osiguravajući da svaki trošak ima
	 * svoj jedinstveni identifikator. ID troška mora biti pozitivan broj veći od 0,
	 * što omogućava jednoznačnu identifikaciju troškova unutar sistema. Provera validnosti
	 * ID-a je ključna za održavanje integriteta baze podataka i sprečavanje grešaka u obradi podataka.
	 * 
	 * @param id identifikacioni broj troška koji se postavlja.
	 * @throws IllegalArgumentException ako je prosleđeni ID manji ili jednak 0,
	 * što ukazuje na nevalidan ID troška.
	 */
	public void setId(int id) {
	    if (id <= 0) {
	        throw new IllegalArgumentException("ID mora biti veći od 0.");
	    }
	    this.id = id;
	}


	/**
	 * Metoda koja vraca tip troska.
	 * 
	 * @return tip troska
	 */
	public CostType getCostType() {
		return costType;
	}

	/**
	 * Metoda koja postavlja tip troska.
	 * 
	 * @param costType tip troska
	 */
	public void setCostType(CostType costType) {
		this.costType = costType;
	}

	/**
	 * Metoda koja vraca iznos troska.
	 * 
	 * @return iznos troska
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Postavlja iznos troška, osiguravajući da je uneti iznos pozitivan.
	 * Ovaj zahtev garantuje da trošak odražava realnu ekonomsku vrednost,
	 * sprečavajući unos negativnih vrednosti koje bi mogle dovesti do nekonzistentnosti
	 * ili grešaka u finansijskom upravljanju. Validacija iznosa je ključna za održavanje
	 * tačnosti i pouzdanosti finansijskih podataka.
	 * 
	 * @param amount iznos troška koji se postavlja.
	 * @throws IllegalArgumentException ako je prosleđeni iznos manji ili jednak 0,
	 * što ukazuje na nevalidan iznos troška.
	 */
	public void setAmount(double amount) {
	    if (amount <= 0) {
	        throw new IllegalArgumentException("Iznos mora biti veći od 0.");
	    }
	    this.amount = amount;
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
			Drive dr = new Drive();
			CostList costList = new CostList();
			costList.setDrive(dr);
			dr.setCostList(costList);
			CostType ct = CostType.valueOf(resultSet.getString("costtype"));
			costList.setId(resultSet.getInt("costList"));
			list.add(new CostItem(ct, resultSet.getDouble("amount"), costList));
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
		return "'" + costList.getId() + "'" + ", '" + costType + "', '" + amount + "'";
	}

	/**
	 * Metoda koja vraca String nalepljenih svih atributa doticne klase.
	 * 
	 * @return String koji predstavlja sve atribute doticne klase.
	 */
	@Override
	public String getAttributes() {
		return "costList, costtype, amount";
	}

	/**
	 * Metoda sa povratnim tipom String.
	 * 
	 * @return String koji predstavlja skup atributa koji se postavljaju.
	 */
	@Override
	public String setAttributes() {
		return "amount = " + getAmount();
	}

	/**
	 * Metoda koja za povratnu vrednost ima String koji predstavlja delete upit za
	 * doticnu tabelu.
	 * 
	 * @return String za delete uslov nad bazom
	 */
	@Override
	public String getDeleteCondition() {
		return "costlist = '" + getCostList().getId() + "' AND costType = '" + getCostType().toString().toLowerCase()
				+ "'";
	}

	/**
	 * Metoda koja za povratnu vrednost ima String koji predstavlja update upit za
	 * doticnu tabelu.
	 * 
	 * @return String za update uslov nad bazom
	 */
	@Override
	public String getUpdateCondition() {
		return "costlist = '" + getCostList().getId() + "' AND costType = '" + getCostType().toString().toLowerCase()
				+ "'";
	}

	/**
	 * Metoda koja za povratnu vrednost ima String koji predstavlja select upit za
	 * doticnu tabelu.
	 * 
	 * @return String za select uslov nad bazom
	 */
	@Override
	public String getSelectContidion() {
		return "costList = '" + costList.getId() + "'";
	}



}
