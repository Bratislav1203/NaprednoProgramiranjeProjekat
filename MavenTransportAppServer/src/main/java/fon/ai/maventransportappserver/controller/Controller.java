package fon.ai.maventransportappserver.controller;

import fon.ai.maventransportappserver.database.impl.DatabaseBroker;
import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import java.sql.Connection;
import java.util.List;

import fon.ai.maventransportappserver.so.impl.DeleteCostItemOperation;
import fon.ai.maventransportappserver.so.impl.DeleteCostListOperation;
import fon.ai.maventransportappserver.so.impl.DeleteDriveOperation;
import fon.ai.maventransportappserver.so.impl.LoginOperation;
import fon.ai.maventransportappserver.so.impl.SaveDriveOperation;
import fon.ai.maventransportappserver.so.impl.SaveDriverOperation;
import fon.ai.maventransportappserver.so.impl.SaveTrailerOperation;
import fon.ai.maventransportappserver.so.impl.SaveTruckOperation;
import fon.ai.maventransportappserver.so.impl.TakeDriveByIDOperation;
import fon.ai.maventransportappserver.so.impl.TakeDriversOperation;
import fon.ai.maventransportappserver.so.impl.TakeDrivesOperation;
import fon.ai.maventransportappserver.so.impl.TakeTrailersOperation;
import fon.ai.maventransportappserver.so.impl.TakeTrucksOperation;
import fon.ai.maventransportappserver.so.impl.UpdateCostItemOperation;
import fon.ai.maventransportappserver.so.impl.UpdateDriveOperation;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;
import fon.ai.maventransportappserver.so.impl.TakeCostsOperation;

/**
 *
 * 
 * 
 * @author Bratislav
 */

public class Controller {
	private static Controller controller;
	Connection connection;

	private static DatabaseBroker db;

	private Controller() {
		db = new DatabaseBroker();
	}

	/**
     * Vraća instancu kontrolera.
     * Ako instanca ne postoji, kreira se nova.
     * 
     * @return {@code Controller} instanca kontrolera.
     */
	public static Controller getController() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}

	/**
     * Pronalazi korisnika u bazi podataka na osnovu prosleđenog entiteta.
     * 
     * @param iGeneralEntity entitet korisnika koji se pretražuje.
     * @return {@code IGeneralEntity} instanca pronađenog korisnika.
     * @throws Exception ako dođe do greške prilikom pretraživanja.
     */
	public IGeneralEntity pronadjiKorisnika(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new LoginOperation();
		so.templateExecute(iGeneralEntity);
		return ((LoginOperation) so).getObject();
	}

	 /**
     * Dodaje novog vozača u bazu podataka.
     * 
     * @param iGeneralEntity entitet vozača koji treba zapamtiti.
     * @throws Exception ako dodje do greške prilikom zapisa u bazu.
     */
	public void zapamtiVozaca(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new SaveDriverOperation();
		so.templateExecute(iGeneralEntity);
	}

	 /**
     * Dodaje novi kamion u bazu podataka.
     * 
     * @param iGeneralEntity entitet kamiona koji treba zapamtiti.
     * @throws Exception ako dodje do greške prilikom zapisa u bazu.
     */
	public void zapamtiKamion(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new SaveTruckOperation();
		so.templateExecute(iGeneralEntity);
	}

	 /**
     * Dodaje nove prikolice u bazu podataka.
     * 
     * @param iGeneralEntity entitet prikolice koju treba zapamtiti.
     * @throws Exception ako dodje do greške prilikom zapisa u bazu.
     */
	public void zapamtiPrikolicu(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new SaveTrailerOperation();
		so.templateExecute(iGeneralEntity);
	}

    /**
     * Vraca listu svih vozaca iz baze podataka.
     * 
     * @return lista entiteta vozaca.
     * @throws Exception ako dodje do greske prilikom ucitavanja iz baze.
     */
	public List<IGeneralEntity> vratiVozace() throws Exception {
		AbstractGenericOperation so = new TakeDriversOperation();
		so.templateExecute(new Driver());
		return ((TakeDriversOperation) so).getLista();
	}

    /**
     * Vraća listu svih kamiona iz baze podataka.
     * 
     * @return lista entiteta kamiona.
     * @throws Exception ako dođe do greške prilikom učitavanja iz baze.
     */
	public List<IGeneralEntity> vratiVozila() throws Exception {
		AbstractGenericOperation so = new TakeTrucksOperation();
		so.templateExecute(new Truck());
		return ((TakeTrucksOperation) so).getLista();
	}

    /**
     * Vraća listu svih prikolica iz baze podataka.
     * 
     * @return lista entiteta prikolica.
     * @throws Exception ako dođe do greške prilikom učitavanja iz baze.
     */
	public List<IGeneralEntity> vratiPrikolice() throws Exception {
		AbstractGenericOperation so = new TakeTrailersOperation();
		so.templateExecute(new Trailer());
		return ((TakeTrailersOperation) so).getLista();
	}

	/**
	 * Zapamti podatke o vožnji u bazu podataka.
	 *
	 * @param iGeneralEntity entitet vožnje koji treba zapamtiti.
	 * @throws Exception ako dođe do greške prilikom zapisa u bazu.
	 */
	public void zapamtiVoznju(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new SaveDriveOperation();
		so.templateExecute(iGeneralEntity);
	}

	/**
	 * Vraća listu svih vožnji iz baze podataka.
	 *
	 * @return lista entiteta vožnji.
	 * @throws Exception ako dođe do greške prilikom učitavanja iz baze.
	 */
	public List<IGeneralEntity> vratiVoznje() throws Exception {
		AbstractGenericOperation so = new TakeDrivesOperation();
		so.templateExecute(new Drive());
		return ((TakeDrivesOperation) so).getLista();
	}

	/**
	 * Obriši određenu vožnju iz baze podataka.
	 *
	 * @param iGeneralEntity entitet vožnje koji treba obrisati.
	 * @throws Exception ako dođe do greške prilikom brisanja iz baze.
	 */
	public void obrisiVoznju(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new DeleteDriveOperation();
		so.templateExecute(iGeneralEntity);
	}

	/**
	 * Obriši određeni trošak iz baze podataka.
	 *
	 * @param iGeneralEntity entitet troška koji treba obrisati.
	 * @throws Exception ako dođe do greške prilikom brisanja iz baze.
	 */
	public void obrisiTrosak(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new DeleteCostItemOperation();
		so.templateExecute(iGeneralEntity);
	}

	/**
	 * Obriši celu listu troškova za određenu vožnju iz baze podataka.
	 *
	 * @param iGeneralEntity entitet liste troškova koji treba obrisati.
	 * @throws Exception ako dođe do greške prilikom brisanja iz baze.
	 */
	public void obrisiListuTroskova(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new DeleteCostListOperation();
		so.templateExecute(iGeneralEntity);
	}

	/**
	 * Vraća vožnju iz baze podataka na osnovu njenog ID-a.
	 *
	 * @param iGeneralEntity entitet vožnje sa specifikovanim ID-em za pretragu.
	 * @return IGeneralEntity entitet pronađene vožnje.
	 * @throws Exception ako dođe do greške prilikom učitavanja iz baze.
	 */
	public IGeneralEntity vratiVoznjuPoIDu(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new TakeDriveByIDOperation();
		so.templateExecute(iGeneralEntity);
		return ((TakeDriveByIDOperation) so).getObject();
	}
	
	/**
	 * Ažurira podatke o vožnji u bazi podataka.
	 *
	 * @param iGeneralEntity entitet vožnje sa ažuriranim podacima.
	 * @throws Exception ako dođe do greške prilikom ažuriranja u bazi.
	 */
	public void updateDrive(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new UpdateDriveOperation();
		so.templateExecute(iGeneralEntity);
	}

	/**
	 * Ažurira podatke o trošku u bazi podataka.
	 *
	 * @param iGeneralEntity entitet troška sa ažuriranim podacima.
	 * @throws Exception ako dođe do greške prilikom ažuriranja u bazi.
	 */
	public void updateCostItem(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new UpdateCostItemOperation();
		so.templateExecute(iGeneralEntity);
	}

	/**
	 * Vraća listu troškova iz baze podataka za određenu vožnju.
	 *
	 * @return lista entiteta troškova.
	 * @throws Exception ako dođe do greške prilikom učitavanja iz baze.
	 */
	public List<IGeneralEntity> vratiTroskovePoIDu() throws Exception {
		AbstractGenericOperation so = new TakeCostsOperation();
		so.templateExecute(new CostItem());
		return ((TakeCostsOperation) so).getLista();
	}

}
