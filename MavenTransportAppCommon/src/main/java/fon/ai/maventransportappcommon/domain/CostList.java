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
 * @see CostList
 */
public class CostList implements IGeneralEntity {

	public CostList(int id) {
		super();
		this.id = id;
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
	 * @param inTotal zbir svih troskova
	 */
	public CostList(List<CostItem> costs, Drive drive) {
		this.costs = costs;
		this.drive = drive;
		if (this.costs != null)
			this.inTotal = izracunajZbirTroskova(costs);
	}

	public CostList(int int1, double total, Drive drive2) {
		id = int1;
		inTotal = total;
		drive = drive2;

	}

	private double izracunajZbirTroskova(List<CostItem> costs2) {
		double zbir = 0;
		for (CostItem cost : costs2) {
			zbir += cost.getAmount();
		}
		return zbir;
	}

	public Drive getDrive() {
		return drive;
	}

	public void setDrive(Drive drive) {
		this.drive = drive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CostItem> getCosts() {
		return costs;
	}

	public void setCosts(List<CostItem> costs) {
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
