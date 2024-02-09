/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa TakeDriveByIDOperation specijalizovana je za operaciju dohvatanja specifične vožnje
 * iz baze podataka na osnovu njenog identifikacionog broja (ID). Ova operacija validira da li je
 * prosleđeni objekat instance klase {Drive i izvršava upit za dohvatanje vožnje sa datim ID-em.
 * 
 * Nasleđuje apstraktne metode validate i execute iz klase AbstractGenericOperation
 * 
 * @author Bratislav
 */
public class TakeDriveByIDOperation extends AbstractGenericOperation {

    IGeneralEntity object;

    /**
     * Proverava da li je prosleđeni objekat instance klase Drive
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju, očekuje se da bude tipa Drive
     * @throws Exception ako objekat nije instance klase Drive
     */
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Drive)) {
            throw new Exception("Objekat nije validan");
        }
    }

    /**
     * Izvršava operaciju dohvatanja vožnje iz baze podataka na osnovu ID-a.
     * Ako vožnja sa datim ID-em postoji, vratiće se kao rezultat.
     * 
     * @param entity objekat za pretragu, očekuje se da bude tipa Drive sa postavljenim ID-em.
     * @throws Exception ako dođe do greške prilikom pretrage u bazi podataka.
     */
    @Override
    public void execute(Object entity) throws Exception {
        object = db.vratiPoId((IGeneralEntity)entity);
    }

    /**
     * Vraća dohvaćenu vožnju.
     * 
     * @return IGeneralEntity objekat koji predstavlja dohvaćenu vožnju.
     */
    public IGeneralEntity getObject() {
        return object;
    }
    
}
