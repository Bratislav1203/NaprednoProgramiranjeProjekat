/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Trailer;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa TakeTrailersOperation specijalizovana je za operaciju dohvatanja svih prikolica
 * iz baze podataka. Validira da li je prosleđeni objekat instance klase Trailer i 
 * izvršava upit za dohvatanje svih instanci prikolica.
 * 
 * Nasleđuje apstraktne metode validate iexecute iz klase AbstractGenericOperation
 * Rezultat operacije je lista prikolica koji su pronađeni u bazi.
 * 
 * @author Bratislav
 */
public class TakeTrailersOperation extends AbstractGenericOperation{
    private List<IGeneralEntity> lista;

    /**
     * Proverava da li je prosleđeni objekat instance klase Trailer
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju, očekuje se da bude tipa Trailer
     * @throws Exception ako objekat nije instance klase Trailer
     */
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Trailer)) {
            throw new Exception("Objekat nije validan");
        }
    }

    /**
     * Izvršava operaciju dohvatanja svih prikolica iz baze podataka.
     * Rezultat je lista entiteta IGeneralEntity koji predstavljaju prikolice.
     * 
     * @param entity objekat za pretragu, očekuje se da bude tipa Trailer
     * @throws Exception ako nije moguće dohvatiti prikolice ili ako lista prikolica je prazna.
     */
    @Override
    public void execute(Object entity) throws Exception {
        lista = db.vratiSve((IGeneralEntity) entity);
        if(lista.isEmpty()) {
            throw new Exception("Sistem ne moze da nadje vozila");
        }
    }
    
    /**
     * Vraća listu dohvaćenih prikolica.
     * 
     * @return lista entiteta IGeneralEntity, svaki predstavlja prikolicu.
     */
    public List<IGeneralEntity> getLista() {
        return lista;
    }
    
}
