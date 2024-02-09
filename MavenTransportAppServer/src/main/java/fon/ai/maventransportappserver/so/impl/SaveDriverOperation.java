/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa SaveDriverOperation specijalizovana je za operaciju čuvanja vozaca u bazi podataka.
 * Ova klasa proverava da li je objekat instance klase Driver i izvršava logiku čuvanja u bazu podataka
 * Nasleđuje apstraktne metode validate i execute iz klase AbstractGenericOperation
 * 
 * @author Bratislav
 */
public class SaveDriverOperation extends AbstractGenericOperation{
    private List<IGeneralEntity> lista;

    /**
     * Proverava da li je prosleđeni objekat instance klase Driver.
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju.
     * @throws Exception ako objekat nije instance klase Driver.
     */
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Driver)) {
            throw new Exception("Objekat nije validan");
        }
    }

    /**
     * Izvršava operaciju čuvanja vozaca u bazu podataka.
     * @param entity objekat vožnje koji se čuva, očekuje se da bude tipa Driver
     * @throws Exception ako čuvanje nije uspešno ili ako objekat nije validan.
     */
    @Override
    public void execute(Object entity) throws Exception {
        Driver d = (Driver) entity;
        
        lista = db.vratiPoUslovu((IGeneralEntity) entity);
        if (!lista.isEmpty()) {
            throw new Exception("Vec postoji vozac sa ovim brojem licne karte!");
        }
        db.sacuvaj((IGeneralEntity) entity);
    }
    
    
}
