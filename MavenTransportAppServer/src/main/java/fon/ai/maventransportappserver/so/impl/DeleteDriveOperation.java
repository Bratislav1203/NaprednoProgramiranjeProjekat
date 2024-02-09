/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa DeleteDriveOperation je zaduzena za operaciju za brisanje voznje iz sistema.
 * Ova klasa implementira metode validate i execute kako bi omogućila
 * proveru validnosti objekta voznje i njegovo brisanje iz baze podataka.
 * @author Bratislav
 */
public class DeleteDriveOperation extends AbstractGenericOperation{
    
    /**
     * Proverava da li je prosleđeni objekat instanca klase Drive.
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju.
     * @throws Exception ako objekat nije instanca klase Drive
     */
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Drive)) {
            throw new Exception("Objekat nije validan");
        }
    }

    /**
     * Izvršava operaciju brisanja voznje iz baze podataka.
     * Pre brisanja, objekat se validira metodom validate
     * 
     * @param entity objekat voznje koji treba obrisati iz baze podataka.
     * @throws Exception ako brisanje nije uspešno ili ako objekat nije validan.
     */
    @Override
    public void execute(Object entity) throws Exception {
    	Drive d = (Drive) entity;
		for (CostItem c : d.getCostList().getCosts()) {
			if (c.getCostList().getId() == d.getId())
				db.obrisi(c);
		}
		db.obrisi(d.getCostList());
    	db.obrisi((IGeneralEntity) entity);
    }
    
    
    
}
