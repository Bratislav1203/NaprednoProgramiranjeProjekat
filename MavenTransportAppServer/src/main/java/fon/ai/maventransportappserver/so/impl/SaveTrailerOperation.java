/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Vehicle;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa SaveDriverOperation specijalizovana je za operaciju čuvanja prikolice u bazi podataka.
 * Ova klasa proverava da li je objekat instance klase Vehicle i izvršava logiku čuvanja u bazu podataka
 * Nasleđuje apstraktne metode validate i execute iz klase AbstractGenericOperation
 * 
 * @author Bratislav
 */
public class SaveTrailerOperation extends AbstractGenericOperation{

    private List<IGeneralEntity> lista;
    
    /**
     * Proverava da li je prosleđeni objekat instance klase Vehicle.
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju.
     * @throws Exception ako objekat nije instance klase Vehicle
     */
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Vehicle)) {
            throw new Exception("Objekat nije validan");
        }
        
    }

    /**
     * Izvršava operaciju čuvanja prikolice u bazu podataka.
     * @param entity objekat prikolice koji se čuva, očekuje se da bude tipa Vehicle
     * @throws Exception ako čuvanje nije uspešno ili ako objekat nije validan.
     */
    @Override
    public void execute(Object entity) throws Exception {
        Vehicle v = (Vehicle) entity;
        System.out.println("makar usao u execute");
        /*lista = db.vratiPoUslovu((IGeneralEntity) entity);
        if (!lista.isEmpty()) {
            throw new Exception("Vec postoji ovaj kamion");
        }
        System.out.println("prosao uslov za postojanje kamiona");*/ // implementiraj ovo kasnije
        db.sacuvaj((IGeneralEntity) entity);
        System.out.println("prosao cuvanje u savetruckoperation");
        
    }
    
}
