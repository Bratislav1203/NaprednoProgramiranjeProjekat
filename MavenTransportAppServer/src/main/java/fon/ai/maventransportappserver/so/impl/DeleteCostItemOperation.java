package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa DeleteCostItemOperation je zaduzena za operaciju za brisanje troška iz sistema.
 * Ova klasa implementira metode validate i execute kako bi omogućila
 * proveru validnosti objekta troška i njegovo brisanje iz baze podataka.
 * @author Bratislav
 */

public class DeleteCostItemOperation extends AbstractGenericOperation {
    /**
     * Proverava da li je prosleđeni objekat instanca klase CostItem.
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju.
     * @throws Exception ako objekat nije instanca klase CostItem
     */
	@Override
	public void validate(Object entity) throws Exception {
		if (!(entity instanceof CostItem)) {
			throw new Exception("Objekat nije validan");
		}
	}
	
	/**
     * Izvršava operaciju brisanja troška iz baze podataka.
     * Pre brisanja, objekat se validira metodom validate
     * 
     * @param entity objekat troška koji treba obrisati iz baze podataka.
     * @throws Exception ako brisanje nije uspešno ili ako objekat nije validan.
     */
	@Override
	public void execute(Object entity) throws Exception {
		db.obrisi((IGeneralEntity) entity);
	}
}
