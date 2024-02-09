/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa TakeDrivesOperation specijalizovana je za operaciju dohvatanja svih vožnji
 * iz baze podataka. Validira da li je prosleđeni objekat instance klase Drive i 
 * izvršava upit za dohvatanje svih instanci vožnji.
 * 
 * Nasleđuje apstraktne metode validate i execute iz klase AbstractGenericOperation
 * Rezultat operacije je lista vožnji koji su pronađeni u bazi.
 * 
 * @author Bratislav
 */
public class TakeDrivesOperation extends AbstractGenericOperation{
    private List<IGeneralEntity> lista;

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
     * Izvršava operaciju dohvatanja svih voznji iz baze podataka.
     * Rezultat je lista entiteta IGeneralEntity koji predstavljaju voznje.
     * 
     * @param entity objekat za pretragu, očekuje se da bude tipa Drive
     * @throws Exception ako nije moguće dohvatiti voznje ili ako lista voznji je prazna.
     */
    @Override
    public void execute(Object entity) throws Exception {
        lista = db.vratiSve((IGeneralEntity) entity);
        if(lista.isEmpty()) {
            throw new Exception("Sistem ne moze da nadje vozila, prvo dodaj vozila pa onda voznju!");
        }
    }
    
    /**
     * Vraća listu dohvaćenih voznji.
     * 
     * @return lista entiteta IGeneralEntity, svaki predstavlja voznju.
     */
    public List<IGeneralEntity> getLista() {
        return lista;
    }
    
}
