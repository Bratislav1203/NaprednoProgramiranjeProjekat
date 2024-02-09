/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa TakeCostsOperation specijalizovana je za operaciju dohvatanja svih troškova
 * iz baze podataka koji su povezani sa određenom vožnjom. Ova operacija proverava da li je
 * prosleđeni objekat instance klase CostItem i izvršava upit za dohvatanje svih troškova.
 * 
 * Nasleđuje apstraktne metode validate i execute iz klase AbstractGenericOperation
 * 
 * @author Bratislav
 */
public class TakeCostsOperation extends AbstractGenericOperation{
    private List<IGeneralEntity> lista;

    /**
     * Proverava da li je prosleđeni objekat instance klase CostItem
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju, očekuje se da bude tipa CostItem
     * @throws Exception ako objekat nije instance klase CostItem
     */
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof CostItem)) {
            throw new Exception("Objekat nije validan");
        }
    }

    /**
     * Izvršava operaciju dohvatanja svih troškova za određenu vožnju iz baze podataka.
     * Rezultat je lista entiteta IGeneralEntity koji predstavljaju troškove.
     * 
     * @param entity objekat za pretragu, očekuje se da bude tipa CostItem
     * @throws Exception ako nije moguće dohvatiti troškove ili ako lista troškova je prazna.
     */
    @Override
    public void execute(Object entity) throws Exception {
        lista = db.vratiSve((IGeneralEntity) entity);
        if(lista.isEmpty()) {
            throw new Exception("Sistem ne moze da vrati troskove!");
        }
    }
    
    /**
     * Vraća listu dohvaćenih troškova.
     * 
     * @return lista entiteta IGeneralEntity, svaki predstavlja trošak.
     */
    public List<IGeneralEntity> getLista() {
        return lista;
    }
    
}
