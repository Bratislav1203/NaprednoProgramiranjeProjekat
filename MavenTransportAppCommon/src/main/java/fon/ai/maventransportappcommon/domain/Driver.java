package fon.ai.maventransportappcommon.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja vozaca.
 *
 * @author Vladimir
 * @version 1.0
 * @see Driver
 */

public class Driver implements IGeneralEntity{

    /**
     *Privatni atribut koji predstavlja identifikacioni broj licne karte vozaca.
     */
    private int IDCard;

    /**
     *Privatni atribut koji predstavlja ime vozaca.
     */
    private String name;

    /**
     *Privatni atribut koji predstavlja prezime vozaca.
     */
    private String surname; //ke

    /**
     *Neparametrizovani konstruktor klase Vozac.
     */
    public Driver() {
    }  

    /**
     *Parametrizovani konstruktor klase Vozac koji sluzi za inicijalizaciju objekata ove klase.
     * @param IDCard identifikaciona kartica (licna karta)
     * @param name ime
     * @param surname prezime
     */
    public Driver(int IDCard, String name, String surname) {
        this.IDCard = IDCard;
        this.name = name;
        this.surname = surname;
    }

    /**
     *Metoda koja vraca broj licne karte.
     * @return licna karta
     */
    public int getIDCard() {
        return IDCard;
    }

    /**
     *Metoda koja postavlja broj licne karte.
     * @param IDCard licna karta
     */
    public void setIDCard(int IDCard) {
        this.IDCard = IDCard;
    }

    /**
     *Metoda koja vraca ime vozaca.
     * @return ime
     */
    public String getName() {
        return name;
    }

    /**
     *Metoda koja postavlja ime vozacu.
     * @param name ime
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Metoda koja vraca prezime vozaca.
     * @return prezime
     */
    public String getSurname() {
        return surname;
    }

    /**
     *Metoda koja postavlja prezime vozacu.
     * @param surname prezime
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     *Metoda koja vraca String koji predstavlja naziv relacije u bazi.
     * @return String naziv tabele
     */
    @Override
    public String getTableName() {
        return "driver";
    }

  /**
     *Metoda koja pravi listu od result seta za doticnu klasu.
     * @param resultSet tip podatka koji vraca konekcija sa bazom.
     * @return lista IGeneralEntity
     * @throws Exception Bacanje instance opsteg izuzetka
     */
    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int IDCard = resultSet.getInt("idcard");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            
            list.add(new Driver(IDCard,name,surname));
        }
        return list;
    }

    /**
     *Metoda koja vraca String vrednosti svih atributa doticne klase.
     * @return String vrednosti svih atributa.
     */
    @Override
    public String getValues() {
         return IDCard + ", '" + name + "', '"+ surname + "'";
    }

/**
     *Metoda koja vraca String nalepljenih svih atributa doticne klase.
     * @return String koji predstavlja sve atribute doticne klase.
     */
    @Override
    public String getAttributes() {
        return "IDCard, name, surname";
    }
    /**
     *Metoda sa povratnim tipom String.
     * @return Sring koji predstavlja skup atributa koji se postavljaju.
     */
    @Override
    public String setAttributes() {
        return "IDCard=" + IDCard + ", name='" + name + ",surname='"+ surname + "'";
    }

    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja delete upit za doticnu tabelu.
     * @return String za delete uslov nad bazom
     */
    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja update upit za doticnu tabelu.
     * @return String za update uslov nad bazom
     */
    @Override
    public String getUpdateCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja select upit za doticnu tabelu.
     * @return String za select uslov nad bazom
     */
    @Override
    public String getSelectContidion() {
        return "idcard = '" + getIDCard()+ "'";
    }

    /**
     *Metoda za ispis podataka o vozacu.
     * @return  string ispis
     */
    @Override
    public String toString() {
        return getName() + " " +getSurname();
    }
    
    
}
