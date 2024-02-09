/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa LoginOperation specijalizuje operaciju za autentifikaciju korisnika.
 * Validira da li je prosleđeni objekat instance klase User i pokušava da
 * pronađe korisnika u bazi podataka na osnovu prosleđenih identifikacionih podataka.
 * Nasleđuje operativne metode iz AbstractGenericOperation
 * 
 * @author Bratislav
 */
public class LoginOperation extends AbstractGenericOperation {

    IGeneralEntity object;

    /**
     * Proverava da li je prosleđeni objekat instance klase User
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju, očekuje se da bude tipa User
     * @throws Exception ako objekat nije instance klase User
     */
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof User)) {
            throw new Exception("Objekat nije validan");
        }
    }

    /**
     * Pokušava da vrati korisnika iz baze podataka na osnovu ID-a koji je prosleđen
     * u objektu entity
     * 
     * @param entity objekat korisnika koji se autentifikuje, očekuje se da bude tipa User
     * @throws Exception ako korisnik nije pronađen ili ako dođe do greške u bazi podataka.
     */
    @Override
    public void execute(Object entity) throws Exception {
        object = db.vratiPoId((IGeneralEntity)entity);
    }

    /**
     * Postavlja objekat IGeneralEntity za internu upotrebu.
     * 
     * @param object objekat koji se postavlja.
     */
    public void setObject(IGeneralEntity object) {
        this.object = object;
    }
    
    
    /**
     * Vraća objekat IGeneralEntity koji predstavlja autentifikovanog korisnika.
     * 
     * @return IGeneralEntity autentifikovanog korisnika.
     */
    public IGeneralEntity getObject() {
        return object;
    }
    
}
