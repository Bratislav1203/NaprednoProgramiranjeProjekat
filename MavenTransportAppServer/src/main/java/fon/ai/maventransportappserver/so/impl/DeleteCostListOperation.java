package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.CostList;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa DeleteCostListOperation je zaduzena za operaciju za brisanje liste troskova iz sistema.
 * Ova klasa implementira metode validate i execute kako bi omogućila
 * proveru validnosti objekta liste troskova i njegovo brisanje iz baze podataka.
 * @author Bratislav
 */
public class DeleteCostListOperation extends AbstractGenericOperation {

    /**
     * Proverava da li je prosleđeni objekat instanca klase CostList.
     * Ako nije, baca izuzetak.
     * 
     * @param entity objekat za validaciju.
     * @throws Exception ako objekat nije instanca klase CostList
     */
	@Override
	public void validate(Object entity) throws Exception {
		if (!(entity instanceof CostList)) {
			throw new Exception("Objekat nije validan");
		}
	}

	/**
     * Izvršava operaciju brisanja liste troskova iz baze podataka.
     * Pre brisanja, objekat se validira metodom validate
     * 
     * @param entity objekat liste troskova koji treba obrisati iz baze podataka.
     * @throws Exception ako brisanje nije uspešno ili ako objekat nije validan.
     */
	@Override
	public void execute(Object entity) throws Exception {
		db.obrisi((IGeneralEntity) entity);

	}
}