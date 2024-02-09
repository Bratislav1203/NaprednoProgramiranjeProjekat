package fon.ai.maventransportappcommon.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja vozaca.
 *
 * @author Bratislav
 * @version 1.0
 *  Driver
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
        setIDCard(IDCard);
        setName(name);
        setSurname(surname);
    }

    /**
     *Metoda koja vraca broj licne karte.
     * @return licna karta
     */
    public int getIDCard() {
        return IDCard;
    }

    /**
     * Postavlja broj lične karte vozaču nakon provere da je uneti broj pozitivan
     * i da tačno sadrži 9 cifara. Ovo osigurava da broj lične karte zadovoljava
     * osnovne formate identifikacionih dokumenata.
     * 
     * @param IDCard broj lične karte koji se postavlja.
     * @throws IllegalArgumentException ako broj lične karte nije pozitivan ili nema tačno 9 cifara.
     */
    public void setIDCard(int IDCard) {
        int length = String.valueOf(IDCard).length();
        if (IDCard <= 0 || length != 9) {
            throw new IllegalArgumentException("IDCard mora biti pozitivan broj sa tačno 9 cifara.");
        }
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
     * Postavlja ime vozaču nakon provere da uneta vrednost nije prazan string ili null
     * i da ime sadrži samo slova te ima minimalnu dužinu od 2 karaktera. Ovo osigurava
     * da ime vozača zadovoljava osnovne kriterijume formata i dužine.
     * 
     * @param name ime vozača koje se postavlja.
     * @throws IllegalArgumentException ako ime ne zadovoljava kriterijume validnosti.
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ime ne sme biti prazan string ili null.");
        }
        if (!name.matches("[a-zA-Z ]+") || name.length() < 2) {
            throw new IllegalArgumentException("Ime mora sadržati samo slova i imati minimalnu dužinu od 2 karaktera.");
        }
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
     * Postavlja prezime vozaču nakon provere da uneta vrednost nije prazan string ili null
     * i da prezime sadrži samo slova te ima minimalnu dužinu od 2 karaktera. Ovo osigurava
     * da prezime vozača zadovoljava osnovne kriterijume formata i dužine.
     * 
     * @param surname prezime vozača koje se postavlja.
     * @throws IllegalArgumentException ako prezime ne zadovoljava kriterijume validnosti.
     */
    public void setSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Prezime ne sme biti prazan string ili null.");
        }
        if (!surname.matches("[a-zA-Z ]+") || surname.length() < 2) {
            throw new IllegalArgumentException("Prezime mora sadržati samo slova i imati minimalnu dužinu od 2 karaktera.");
        }

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
