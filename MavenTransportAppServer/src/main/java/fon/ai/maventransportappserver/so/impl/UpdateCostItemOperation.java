package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa UpdateCostItemOperation specijalizovana je za operaciju ažuriranja
 * pojedinačnih troškova (CostItem) u bazi podataka. Ova operacija proverava da li je
 * prosleđeni objekat instance klase CostItem i izvršava ažuriranje tog objekta u bazi.
 * 
 * Nasleđuje apstraktne metode validate i execute iz klase AbstractGenericOperation,
 * primenjujući specifičnu logiku validacije i izvršenja za ažuriranje troškova.
 * 
 * @author Bratislav
 */
public class UpdateCostItemOperation extends AbstractGenericOperation {

	 /**
     * Proverava da li je prosleđeni objekat instance klase CostItem
     * Ako objekat nije validan, baca izuzetak.
     * 
     * @param entity objekat koji se validira, očekuje se da bude tipa CostItem
     * @throws Exception ako objekat nije instance klase {@code CostItem}, signalizira
     *                   da prosleđeni objekat nije validan za ažuriranje.
     */
	@Override
	public void validate(Object entity) throws Exception {
		if (!(entity instanceof CostItem)) {
			throw new Exception("Objekat nije validan!");
		}
	}

    /**
     * Izvršava ažuriranje prosleđenog troška (CostItem) u bazi podataka.
     * Pre izvršenja, objekat se validira metodom validate
     * 
     * @param entity objekat troška koji se ažurira, očekuje se da bude tipa CostItem
     * @throws Exception ako ažuriranje nije uspešno, bilo zbog problema u bazi
     *                   podataka ili nevalidnog objekta.
     */
	@Override
	public void execute(Object entity) throws Exception {
		db.izmeni((IGeneralEntity) entity);
	}

}
