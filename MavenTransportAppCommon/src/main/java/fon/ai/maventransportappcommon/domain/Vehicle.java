package fon.ai.maventransportappcommon.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.Year;

/**
 * Klasa koja predstavlja vozilo.
 *
 * @author Bratislav
 * @version 1.0
 *  Vehicle
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
        setBrand(brand);
        setProductYear(productYear);
        setRegistrationMark(registrationMark);
        setWeight(weight);
        setOznakaVozila(oznakaVozila);
    }
    
    /**
     *Parametrizovani konstruktor klase Vozilo koji inicijalizuje novi objekat ove klase.
     * @param brand marka
     * @param productYear godina proizvodnje
     * @param registrationMark registracije
     * @param weight tezina
     */
    public Vehicle(String brand, int productYear, String registrationMark, double weight) {
        setBrand(brand);
        setProductYear(productYear);
        setRegistrationMark(registrationMark);
        setWeight(weight);
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
    
    /**
     *Metoda koja vraca marku vozila.
     * @return marka vozila
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Postavlja marku vozila nakon provere da uneta vrednost nije prazan string ili null.
     * Ako je prosleđena marka vozila {@code null} ili prazan string nakon uklanjanja početnih i krajnjih praznih mesta,
     * baca se {@code IllegalArgumentException} sa porukom da marka ne sme biti prazan string ili null.
     * 
     * @param brand marka vozila koja se postavlja.
     * @throws IllegalArgumentException ako je {@code brand} prazan string ili null.
     */
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand ne sme biti prazan string ili null.");
        }
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
     * Postavlja godinu proizvodnje vozila nakon provere da uneta vrednost nije manja od 1951 ili veca od trenutne godine
     * Ako je prosleđena godina proizvodnje vozila  <= 1950  ili godina proizvodnje > trenutnagodina ,
     * baca se {@code IllegalArgumentException} sa porukom da godina proizvodnje ne sme biti van dozvoljenih granica
     * 
     * @param productYear godina prozivodnje vozila koja se postavlja.
     * @throws IllegalArgumentException ako je {@code productYear} manja od 1950 ili veca od trenutne godine
     */
    public void setProductYear(int productYear) {
        int currentYear = Year.now().getValue();
        
        if (productYear <= 1950 || productYear > currentYear) {
            throw new IllegalArgumentException("Godina proizvodnje mora biti između 1951 i " + currentYear + ".");
        }
        
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
     * Postavlja marku vozila nakon provere da uneta vrednost nije prazan string ili null.
     * Ako je prosleđena registracija vozila {@code null} ili prazan string nakon uklanjanja početnih i krajnjih praznih mesta,
     * baca se {@code IllegalArgumentException} sa porukom da registracija ne sme biti prazan string ili null.
     * 
     * @param registracija vozila koja se postavlja.
     * @throws IllegalArgumentException ako je {@code registrationMark} prazan string ili null.
     */
    public void setRegistrationMark(String registrationMark) {
   	 if (registrationMark == null || registrationMark.trim().isEmpty()) {
         throw new IllegalArgumentException("Registratice ne smeju biti prazan string ili null.");
     }
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
     * Postavlja tezinu vozila nakon provere da uneta vrednost nije manja od 0
     * Ako je prosleđena tezina vozila  <= 0 ,
     * baca se {@code IllegalArgumentException} sa porukom da tezina ne sme biti manja od 0
     * 
     * @param tezina vozila koja se postavlja.
     * @throws IllegalArgumentException ako je {@code brand} prazan string ili null.
     */
    public void setWeight(double weight) {
    	if (weight <= 0) {
            throw new IllegalArgumentException("Tezina mora biti veća od 0.");
        }
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
	 * Predefinisana equals metoda za poredjenje objekata.
	 * 
	 * @param obj
	 * @return tacno ili ne
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(oznakaVozila, other.oznakaVozila)
				&& productYear == other.productYear && Objects.equals(registrationMark, other.registrationMark)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
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
        throw new UnsupportedOperationException("DJASLKDSAA supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

/**
     *Metoda koja vraca String nalepljenih svih atributa doticne klase.
     * @return String koji predstavlja sve atribute doticne klase.
     */
    @Override
    public String getAttributes() {
        throw new UnsupportedOperationException("RETRETR supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Metoda sa povratnim tipom String.
     * @return Sring koji predstavlja skup atributa koji se postavljaju.
     */
    @Override
    public String setAttributes() {
        throw new UnsupportedOperationException("ASDSAD supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja delete upit za doticnu tabelu.
     * @return String za delete uslov nad bazom
     */
    @Override
    public String getDeleteCondition() {
    	return "registrationMark='" + getRegistrationMark() +"'";
    }

    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja update upit za doticnu tabelu.
     * @return String za update uslov nad bazom
     */
    @Override
    public String getUpdateCondition() {
        throw new UnsupportedOperationException("AASDD supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja select upit za doticnu tabelu.
     * @return String za select uslov nad bazom
     */
    @Override
    public String getSelectContidion() {
        if (this.registrationMark == null) {
            throw new IllegalStateException("Registraciona oznaka ne sme biti null.");
        }
        return "registrationMark='" + this.registrationMark + "'";
    }


  
    
}
