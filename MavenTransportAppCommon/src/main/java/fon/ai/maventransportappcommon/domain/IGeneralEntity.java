package fon.ai.maventransportappcommon.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 * Interfejs koji sadrzi sve potrebne metode za manipulaciju sa opstim domenskim
 * objektima prilikom rada sa bazom.
 *
 * @author Vladimir
 * @version 1.0
 */
public interface IGeneralEntity extends Serializable{
    
    /**
     * Metoda koja vraca naziv tabele u bazi.
     *
     * @return naziv tabele kao String.
     */
    public String getTableName();

/**
     *Metoda koja pravi listu od result seta za doticnu klasu.
     * @param resultSet tip podatka koji vraca konekcija sa bazom.
     * @return lista IGeneralEntity
     * @throws Exception Bacanje instance opsteg izuzetka
     */
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception;

    /**
     *Metoda koja vraca String vrednosti svih atributa doticne klase.
     * @return String vrednosti svih atributa.
     */
    public String getValues();

    /**
     *Metoda koja vraca String nalepljenih svih atributa doticne klase.
     * @return String koji predstavlja sve atribute doticne klase.
     */
    public String getAttributes();

    /**
     *Metoda koja vraca String atributa radi postavljanja istih u odredjeni kontekst upita.
     * @return String svih atributa.
     */
    public String setAttributes();

    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja delete upit za doticnu tabelu.
     * @return String za delete uslov nad bazom
     */
    public String getDeleteCondition();
    
    /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja update upit za doticnu tabelu.
     * @return String za update uslov nad bazom
     */
    public String getUpdateCondition();
    
     /**
     *Metoda koja za povratnu vrednost ima String koji predstavlja select upit za doticnu tabelu.
     * @return String za select uslov nad bazom
     */
    public String getSelectContidion();
}
