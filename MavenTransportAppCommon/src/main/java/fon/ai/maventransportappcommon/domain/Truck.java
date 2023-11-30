/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja kamion.
 *
 * @author Vladimir
 * @version 1.0
 * @see Truck
 */
public class Truck extends Vehicle implements Serializable, IGeneralEntity{

    /**
     *Privatni atribut koji predstavlja vrstu menjaca na kamionu.
     */
    private String transmission;

    /**
     *Neparametrizovani konstruktor klase Kamion.
     */
    public Truck() {
    }

    /**
     *Parametrizovani konstruktor klase Kamion.
     * @param transmission menjac
     * @param brand marka
     * @param productYear godina proizvodnje
     * @param registrationMark registracije
     * @param weight tezina
     * @param oznakaVozila oznaka koja govori o tome da li je tip vozila kamion ili prikolica
     */
    public Truck(String transmission, String brand, int productYear, String registrationMark, double weight, String oznakaVozila) {
        super(brand, productYear, registrationMark, weight, oznakaVozila);
        this.transmission = transmission;
    }

    /**
     *Parametrizovani konstruktor klase Kamion.
     * @param transmission menjac
     */
    public Truck(String transmission) {
        this.transmission = transmission;
    }

    /**
     *Metoda koja vraca vrstu menjaca.
     * @return menjac
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     *Metoda koja postavlja novu vrstu menjaca na kamion.
     * @param transmission menjac
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja select upit za doticnu tabelu.
     * @return String za select uslov nad bazom
     */
    @Override
    public String getSelectContidion() {
        return "registrationMark='" + getRegistrationMark() +"'";
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
     *Metoda koja vraca String nalepljenih svih atributa doticne klase.
     * @return String koji predstavlja sve atribute doticne klase.
     */
    @Override
    public String getAttributes() {
        return "transmission, brand, productYear, registrationMark, weight, oznakavozila";
    }
    
    /**
     *Metoda koja vraca String vrednosti svih atributa doticne klase.
     * @return String vrednosti svih atributa.
     */
    @Override
    public String getValues() {
         return "'"+transmission + "'"  + ", '" + brand + "', '"+ productYear + "', '" + registrationMark + "', '" + weight + "'"  + ",'"+"K'";
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
            String oznakaVozila = resultSet.getString("oznakavozila");
            if(oznakaVozila.equals("K")){
                int productYear = resultSet.getInt("productYear");
                String registrationMark = resultSet.getString("registrationMark");
                String brand = resultSet.getString("brand");
                double weight = resultSet.getDouble("weight");
                String transmission = resultSet.getString("transmission");
                list.add(new Truck(transmission, brand, productYear, registrationMark, weight, oznakaVozila));
            }
        }
        return list;
    }    
    
}
