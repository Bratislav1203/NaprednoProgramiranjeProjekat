/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.domain;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * Klasa koja predstavlja korisnika.
 *
 * @author Vladimir
 * @version 1.0
 * @see User
 */
public class User implements IGeneralEntity{

    /**
     *Privatni atribut koji predstavlja identifikacioni broj korisnika.
     */
    private long userID;

    /**
     *Privatni atribut koji predstavlja korisnicko ime.
     */
    private String username;

    /**
     *Privatni atribut koji predstavlja korisnicku sifru.
     */
    private String password;

    /**
     *Privatni atribut koji predstavlja ime korisnika.
     */
    private String name;

    /**
     *Privatni atribut koji predstavlja prezime korisnika.
     */
    private String surname;

    /**
     *Privatni atribut koji predstavlja email korisnika.
     */
    private String email;

    /**
     *Neparametrizovani konstruktor klase Korisnik.
     */
    public User() {
    }

    /**
     *Parametrizovani konstruktor klase Korisnik.
     * @param userID identifikacioni broj
     * @param username korisnicko ime
     * @param password korisnicka sifra
     * @param name ime korisnika
     * @param surname prezime korisnika
     * @param email email korisnika
     */
    public User(long userID, String username, String password, String name, String surname, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    /**
     *Metoda koja vraca identifikacioni broj Korisnika.
     * @return identifikacioni broj
     */
    public long getUserID() {
        return userID;
    }

    /**
     *Metoda koja postavlja identifikacioni broj konkretnom Korisniku.
     * @param userID identifikacioni broj
     */
    public void setUserID(long userID) {
        this.userID = userID;
    }

    /**
     *Metoda koja vraca korisnicko ime.
     * @return korisnicko ime
     */
    public String getUsername() {
        return username;
    }

    /**
     *Metoda koja postavlja korisnicko ime.
     * @param username korisnicko ime
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *Metoda koja vraca sifru korisnika.
     * @return sifra korisnika
     */
    public String getPassword() {
        return password;
    }

    /**
     *Metoda koja postavlja sifru korisniku.
     * @param password sifra korisnika
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *Metoda koja vraca ime korisnika.
     * @return ime
     */
    public String getName() {
        return name;
    }

    /**
     *Metoda koja postavlja ime korisniku.
     * @param name ime
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Metoda koja vraca prezime korisnika.
     * @return prezime
     */
    public String getSurname() {
        return surname;
    }

    /**
     *Metoda koja postavlja prezime korisniku.
     * @param surname prezime
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *Metoda koja vraca email korisnika.
     * @return email korisnika
     */
    public String getEmail() {
        return email;
    }

    /**
     *Metoda koja postavlja korisnikov email.
     * @param email korisnikov email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *Metoda koja sluzi za poredjenje korisnika.
     * @param obj opsti objekat
     * @return tacno/netacno
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    /**
     *Ispis za konkretan objekat po atributima.
     * @return ispis
     */
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", email=" + email + '}';
    }

    /**
     *Metoda koja vraca String koji predstavlja naziv relacije u bazi.
     * @return String naziv tabele
     */
    @Override
    public String getTableName() {
        return "user";
    }

/**
     *Metoda koja pravi listu od result seta za doticnu klasu.
     * @param resultSet tip podatka koji vraca konekcija sa bazom.
     * @return lista IGeneralEntity
     * @throws Exception Bacanje instance opsteg izuzetka
     */
    @Override
    public List<IGeneralEntity> getList(ResultSet rs) throws Exception {
        List<IGeneralEntity> users = new ArrayList<>();
        
        while(rs.next()){
            User u = new User(rs.getInt("userID"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("surname"), rs.getString("email"));
            users.add(u);
        }
        return users;
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
        return "username = '" + getUsername() + "' and password = '" + getPassword() + "'";
    }

    /**
     *Parametrizovani konstruktor klase Korisnik koji inicijalizuje vrednost id Korisnika.
     * @param userID identifikacioni broj korisnika
     */
    public User(long userID) {
        this.userID = userID;
    }
    
    
    
    
}
