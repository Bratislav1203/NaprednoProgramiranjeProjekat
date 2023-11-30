package fon.ai.maventransportappcommon.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja vozilo.
 *
 * @author Vladimir
 * @version 1.0
 * @see Vehicle
 */
public class Vehicle implements Serializable, IGeneralEntity{
    
    /**
     *Privatni atribut koji predstavlja naziv marke vozila.
     */
    protected String brand;

    /**
     *Privatni atribut koji predstavlja godinu proizvodnje vozila.
     */
    protected int productYear;

    /**
     *Privatni atribut koji predstavlja registracionu oznaku vozila.
     */
    protected String registrationMark;

    /**
     *Privatni atribut koji predstavlja tezinu vozila.
     */
    protected double weight;

    /**
     *Privatni atribut koji predstavlja oznaku vozila koja oznacava da li je vozilo prikolica ili kamion.
     */
    protected String oznakaVozila;

    /**
     *Parametrizovani konstruktor klase Vozilo koji inicijalizuje novi objekat ove klase.
     * @param brand marka
     * @param productYear godina proizvodnje
     * @param registrationMark registracije
     * @param weight tezina
     * @param oznakaVozila oznaka koja govori o tipu vozila
     */
    public Vehicle(String brand, int productYear, String registrationMark, double weight, String oznakaVozila) {
        this.brand = brand;
        this.productYear = productYear;
        this.registrationMark = registrationMark;
        this.weight = weight;
        this.oznakaVozila = oznakaVozila;
    }
    
    /**
     *Parametrizovani konstruktor klase Vozilo koji inicijalizuje novi objekat ove klase.
     * @param brand marka
     * @param productYear godina proizvodnje
     * @param registrationMark registracije
     * @param weight tezina
     */
    public Vehicle(String brand, int productYear, String registrationMark, double weight) {
        this.brand = brand;
        this.productYear = productYear;
        this.registrationMark = registrationMark;
        this.weight = weight;
    }

    /**
     *Neparametrizovani konstruktor klase Vozilo.
     */
    public Vehicle() {
    }

    /**
     *Metoda koja vraca String koji predstavlja naziv relacije u bazi.
     * @return String naziv tabele
     */
    @Override
    public String getTableName() {
        return "vehicle";
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
            int id = resultSet.getInt("idcard");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            
            //list.add(new Driver(IDCard,name,surname));
        }
        return list;
    }

     /**
     *Metoda koja vraca String vrednosti svih atributa doticne klase.
     * @return String vrednosti svih atributa.
     */
    @Override
    public String getValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

/**
     *Metoda koja vraca String nalepljenih svih atributa doticne klase.
     * @return String koji predstavlja sve atribute doticne klase.
     */
    @Override
    public String getAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Metoda sa povratnim tipom String.
     * @return Sring koji predstavlja skup atributa koji se postavljaju.
     */
    @Override
    public String setAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Metoda koja vraca marku vozila.
     * @return marka vozila
     */
    public String getBrand() {
        return brand;
    }

    /**
     *Metoda koja postavlja marku vozila.
     * @param brand marka vozila
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *Metoda koja vraca godinu proizovdnje vozila.
     * @return godina proizvodnje
     */
    public int getProductYear() {
        return productYear;
    }

    /**
     *Metoda koja postavlja godinu proizvodnje.
     * @param productYear godina proizvodnje
     */
    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

    /**
     *Metoda koja vraca registracije vozila.
     * @return registracije
     */
    public String getRegistrationMark() {
        return registrationMark;
    }

    /**
     *Metoda koja postavlja registracije vozilu.
     * @param registrationMark registracije
     */
    public void setRegistrationMark(String registrationMark) {
        this.registrationMark = registrationMark;
    }

    /**
     *Metoda koja vraca tezinu vozila.
     * @return tezina
     */
    public double getWeight() {
        return weight;
    }

    /**
     *Metoda koja postavlja tezinu vozila
     * @param weight tezina
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *Metoda koja daje ispis atributa objekta klase Vozilo.
     * @return ispis
     */
    @Override
    public String toString() {
        return brand + " - " + productYear;
    }

    /**
     *Metoda koja vraca oznaku vozila.
     * @return oznaka vozila
     */
    public String getOznakaVozila() {
        return oznakaVozila;
    }

    /**
     *Metoda koja postavlja oznaku vozila.
     * @param oznakaVozila oznaka vozila
     */
    public void setOznakaVozila(String oznakaVozila) {
        this.oznakaVozila = oznakaVozila;
    }
    
    
    
}
