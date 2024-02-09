/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.CostList;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa SaveDriveOperation specijalizovana je za operaciju čuvanja vožnje u bazi podataka.
 * Ova klasa proverava da li je objekat instance klase Drive i izvršava logiku čuvanja
 * u bazu podataka, uključujući čuvanje pridruženih troškova ako postoje.
 * Nasleđuje apstraktne metode validate i execute iz klase AbstractGenericOperation
 * 
 * @author Bratislav
 */
public class SaveDriveOperation extends AbstractGenericOperation {

    /**
     * Proverava da li je prosleđeni objekat instance klase Drive.
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju.
     * @throws Exception ako objekat nije instance klase Drive.
     */
	@Override
	public void validate(Object entity) throws Exception {
		if (!(entity instanceof Drive)) {
			throw new Exception("Objekat nije validan");
		}
	}

    /**
     * Izvršava operaciju čuvanja vožnje u bazu podataka.
     * Ako vožnja ima pridruženu listu troškova, čuva i nju kao i sve pojedinačne troškove.
     * 
     * @param entity objekat vožnje koji se čuva, očekuje se da bude tipa Drive
     * @throws Exception ako čuvanje nije uspešno ili ako objekat nije validan.
     */
	@Override
	public void execute(Object entity) throws Exception {
		Drive d = (Drive) entity;
		db.sacuvaj((IGeneralEntity) entity);
		if (d.getCostList() == null)
			return;
		else {
			CostList c = d.getCostList();
			c.setDrive(d);
			c.setId(d.getId());
			for(CostItem ci : c.getCosts()) {
				c.dodajTrosakUTotal(ci);
			}
			db.sacuvaj((IGeneralEntity) c);
			for(CostItem ci : c.getCosts()) {
				ci.setCostList(c);
				db.sacuvaj((IGeneralEntity) ci);
			}
		}
		
	}

}
