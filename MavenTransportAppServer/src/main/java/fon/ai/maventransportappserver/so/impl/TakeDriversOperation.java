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
 * Klasa TakeDriversOperation specijalizovana je za operaciju dohvatanja svih vozača
 * iz baze podataka. Validira da li je prosleđeni objekat instance klase Driver i 
 * izvršava upit za dohvatanje svih instanci vozača.
 * 
 * Nasleđuje apstraktne metode validate i execute iz klase AbstractGenericOperation
 * Rezultat operacije je lista vozača koji su pronađeni u bazi.
 * 
 * @author Bratislav
 */
public class TakeDriversOperation extends AbstractGenericOperation{
    private List<IGeneralEntity> lista;

    /**
     * Proverava da li je prosleđeni objekat instance klase Driver
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju, očekuje se da bude tipa Driver
     * @throws Exception ako objekat nije instance klase Driver
     */
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Driver)) {
            throw new Exception("Objekat nije validan");
        }
    }

    /**
     * Izvršava operaciju dohvatanja svih vozača iz baze podataka.
     * Ako su vozači pronađeni, njihove instance će biti dodate u listu.
     * 
     * @param entity tipično prazan objekat klase Driver koji služi kao marker za tip entiteta koji treba dohvatiti.
     * @throws Exception ako nije moguće dohvatiti vozače ili ako nije pronađen nijedan vozač.
     */
    @Override
    public void execute(Object entity) throws Exception {
        lista = db.vratiSve((IGeneralEntity) entity);
        if(lista.isEmpty()) {
            throw new Exception("Sistem ne moze da nadje vozace");
        }
    }
    
    /**
     * Vraća listu dohvaćenih vozača.
     * 
     * @return List<IGeneralEntity> lista entiteta vozača.
     */

    public List<IGeneralEntity> getLista() {
        return lista;
    }
    
}
