/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.Vehicle;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa TakeTrucksOperation specijalizovana je za operaciju dohvatanja svih kamiona
 * iz baze podataka. Validira da li je prosleđeni objekat instance klase Truck i 
 * izvršava upit za dohvatanje svih instanci kamiona.
 * 
 * Nasleđuje apstraktne metode validate iexecute iz klase AbstractGenericOperation
 * Rezultat operacije je lista kamiona koji su pronađeni u bazi.
 * 
 * @author Bratislav
 */
public class TakeTrucksOperation extends AbstractGenericOperation{
    private List<IGeneralEntity> lista;

    /**
     * Proverava da li je prosleđeni objekat instance klase Truck
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju, očekuje se da bude tipa Truck
     * @throws Exception ako objekat nije instance klase Truck
     */
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Truck)) {
            throw new Exception("Objekat nije validan");
        }
    }

    /**
     * Izvršava operaciju dohvatanja svih kamiona iz baze podataka.
     * Rezultat je lista entiteta IGeneralEntity koji predstavljaju kamioni.
     * 
     * @param entity objekat za pretragu, očekuje se da bude tipa Truck
     * @throws Exception ako nije moguće dohvatiti kamione ili ako lista kamiona je prazna.
     */
    @Override
    public void execute(Object entity) throws Exception {
        lista = db.vratiSve((IGeneralEntity) entity);
        if(lista.isEmpty()) {
            throw new Exception("Sistem ne moze da nadje vozila");
        }
    }

    /**
     * Vraća listu dohvaćenih kamiona.
     * 
     * @return lista entiteta IGeneralEntity, svaki predstavlja kamion.
     */
    public List<IGeneralEntity> getLista() {
        return lista;
    }
    
}
