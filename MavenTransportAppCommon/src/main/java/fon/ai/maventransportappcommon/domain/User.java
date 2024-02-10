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
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * 
 * Klasa koja predstavlja korisnika.
 *
 * @author Bratislav
 * @version 1.0
 *  User
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
        setUserID(userID);
        setUsername(username);
        setPassword(password);
        setName(name);
        setSurname(surname);
        setEmail(email);
    }

    /**
     *Metoda koja vraca identifikacioni broj Korisnika.
     * @return identifikacioni broj
     */
    public long getUserID() {
        return userID;
    }

    /**
     * Postavlja identifikacioni broj korisniku nakon provere da je uneti identifikacioni broj pozitivan.
     * Ako je prosleđeni identifikacioni broj manji ili jednak 0, baca se {@code IllegalArgumentException}
     * sa porukom da identifikacioni broj mora biti veći od 0. Ovo osigurava da svaki korisnik ima validan,
     * pozitivan identifikacioni broj.
     * 
     * @param userID identifikacioni broj koji se postavlja korisniku.
     * @throws IllegalArgumentException ako je {@code userID} manji ili jednak 0.
     */
    public void setUserID(long userID) {
    	if (userID <= 0) {
            throw new IllegalArgumentException("ID mora biti veći od 0.");
        }
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
     * Postavlja korisničko ime korisniku nakon provere da uneta vrednost nije prazan string ili null.
     * Korisničko ime je osnovni identifikator za korisnika i ne sme biti ostavljeno neodređeno.
     * Ako je prosleđeno korisničko ime {@code null} ili prazan string nakon uklanjanja početnih i krajnjih praznih mesta,
     * baca se {@code IllegalArgumentException} sa porukom da korisničko ime ne sme biti prazan string ili null.
     * 
     * @param username korisničko ime koje se postavlja.
     * @throws IllegalArgumentException ako je {@code username} prazan string ili null.
     */
    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username ne sme biti prazan string ili null.");
        }
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
     * Postavlja šifru korisniku nakon provere da uneta vrednost nije prazan string ili null.
     * Šifra je ključna za zaštitu pristupa korisničkom nalogu i mora biti definisana.
     * Ako je prosleđena šifra {@code null} ili prazan string nakon uklanjanja početnih i krajnjih praznih mesta,
     * baca se {@code IllegalArgumentException} sa porukom da šifra ne sme biti prazan string ili null.
     * 
     * @param password šifra koja se postavlja korisniku.
     * @throws IllegalArgumentException ako je {@code password} prazan string ili null.
     */
    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password ne sme biti prazan string ili null.");
        }
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
     * Postavlja ime korisniku nakon provere da uneta vrednost nije prazan string ili null
     * i da ime sadrži samo slova i ima minimalnu dužinu od 2 karaktera. Ovo osigurava da ime
     * korisnika zadovoljava osnovne kriterijume formata i dužine.
     * 
     * @param name ime korisnika koje se postavlja.
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
     *Metoda koja vraca prezime korisnika.
     * @return prezime
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Postavlja prezime korisniku nakon provere da uneta vrednost nije prazan string ili null
     * i da prezime sadrži samo slova i ima minimalnu dužinu od 2 karaktera. Ovo osigurava da prezime
     * korisnika zadovoljava osnovne kriterijume formata i dužine.
     * 
     * @param surname prezime korisnika koje se postavlja.
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
     *Metoda koja vraca email korisnika.
     * @return email korisnika
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja email adresu korisniku nakon provere da uneta email adresa ima validan format.
     * Ovo osigurava da je email adresa korisnika u formatu koji je prihvatljiv i može biti korišćen
     * za komunikaciju.
     * 
     * @param email email adresa korisnika koja se postavlja.
     * @throws IllegalArgumentException ako email adresa nije u validnom formatu.
     */
    public void setEmail(String email) {
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("Email adresa nije u validnom formatu.");
        }
        this.email = email;
    }


    /**
     * Proverava da li je data email adresa u validnom formatu.
     * 
     * @param email email adresa koja se proverava.
     * @return true ako je email validan, u suprotnom false
     */
    public boolean isEmailValid(String email) {
        // Definisanje regex paterna za validaciju email adrese
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
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
        throw new UnsupportedOperationException("getValues Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

/**
     *Metoda koja vraca String nalepljenih svih atributa doticne klase.
     * @return String koji predstavlja sve atribute doticne klase.
     */
    @Override
    public String getAttributes() {
        throw new UnsupportedOperationException("getAttributes Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /**
     *Metoda sa povratnim tipom String.
     * @return Sring koji predstavlja skup atributa koji se postavljaju.
     */
    @Override
    public String setAttributes() {
        throw new UnsupportedOperationException("setAttributes Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja delete upit za doticnu tabelu.
     * @return String za delete uslov nad bazom
     */
    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("getDeleteCondition Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja update upit za doticnu tabelu.
     * @return String za update uslov nad bazom
     */
    @Override
    public String getUpdateCondition() {
        throw new UnsupportedOperationException("getUpdateCondition Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
