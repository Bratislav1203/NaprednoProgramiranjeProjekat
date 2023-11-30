
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
 * Klasa koja predstavlja prikolicu.
 *
 * @author Vladimir
 * @version 1.0
 * @see Trailer
 */
public class Trailer extends Vehicle implements Serializable, IGeneralEntity{

    /**
     *Privatni atribut koji predstavlja tip vozila.
     */
    private VehicleType vt;

    /**
     *Privatni atribut koji predstavlja kapacitet utovara u prikolicu.
     */
    private double loadCapacity;

    /**
     *Neparametrizovani konstruktor klase Prikolica.
     */
    public Trailer() {
        
    }

    /**
     *Parametrizovani konstruktor klase prikolica koji inicijalizuje objekte ove klase.
     * @param vt tip vozila
     * @param loadCapacity nosivost
     */
    public Trailer(VehicleType vt, double loadCapacity) {
        this.vt = vt;
        this.loadCapacity = loadCapacity;
    }

    /**
     *Parametrizovani konstruktor klase prikolica koji inicijalizuje objekte ove klase.
     * @param vt tip vozila
     * @param loadCapacity nosivost
     * @param brand marka
     * @param productYear godinaProizvodnje
     * @param registrationMark registracije
     * @param weight tezina
     * @param oznakaVozila oznaka koja pokazuje da li je kamion ili prikolica u pitanju
     */
    public Trailer(VehicleType vt, double loadCapacity, String brand, int productYear, String registrationMark, double weight, String oznakaVozila) {
        super(brand, productYear, registrationMark, weight, oznakaVozila);
        this.vt = vt;
        this.loadCapacity = loadCapacity;
    }

    /**
     *Metoda koja vraca vrstu vozila.
     * @return vrsta vozila
     */
    public VehicleType getVt() {
        return vt;
    }

    /**
     *Metoda koja postavlja vrstu vozila na novu vrednost.
     * @param vt vrsta vozila
     */
    public void setVt(VehicleType vt) {
        this.vt = vt;
    }

    /**
     *Metoda koja vraca nosivost prikolice.
     * @return nosivost
     */
    public double getLoadCapacity() {
        return loadCapacity;
    }

    /**
     *Metoda koja postavlja novu nosivost prikolice
     * @param loadCapacity nosivost
     */
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
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
        return "loadcapacity, brand, productYear, registrationMark, weight, vehicletype, oznakavozila";
    }
    
    /**
     *Metoda koja vraca String vrednosti svih atributa doticne klase.
     * @return String vrednosti svih atributa.
     */
    @Override
    public String getValues() {
         return "'"+loadCapacity + "'"  + ", '" + brand + "', '"+ productYear + "', '" + registrationMark + "', '" + weight + "'" + ",'" + vt.toString() + "'" + ",'"+"P'";
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
            if(oznakaVozila.equals("P")){
                int productYear = resultSet.getInt("productYear");
                String registrationMark = resultSet.getString("registrationMark");
                String brand = resultSet.getString("brand");
                double weight = resultSet.getDouble("weight");
                String vehicleType = resultSet.getString("vehicletype");
                double loadCapacity = resultSet.getDouble("loadcapacity");
                VehicleType vt = VehicleType.valueOf(vehicleType);
                list.add(new Trailer(vt, loadCapacity, brand, productYear, registrationMark, weight, oznakaVozila));
            }
        }        
        return list;
    }    

}
