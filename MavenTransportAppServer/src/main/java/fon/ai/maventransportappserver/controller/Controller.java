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

	public static Controller getController() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}

	public IGeneralEntity pronadjiKorisnika(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new LoginOperation();
		so.templateExecute(iGeneralEntity);
		return ((LoginOperation) so).getObject();
	}

	public void zapamtiVozaca(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new SaveDriverOperation();
		so.templateExecute(iGeneralEntity);
	}

	public void zapamtiKamion(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new SaveTruckOperation();
		so.templateExecute(iGeneralEntity);
	}

	public void zapamtiPrikolicu(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new SaveTrailerOperation();
		so.templateExecute(iGeneralEntity);
	}

	public List<IGeneralEntity> vratiVozace() throws Exception {
		AbstractGenericOperation so = new TakeDriversOperation();
		so.templateExecute(new Driver());
		return ((TakeDriversOperation) so).getLista();
	}

	public List<IGeneralEntity> vratiVozila() throws Exception {
		AbstractGenericOperation so = new TakeTrucksOperation();
		so.templateExecute(new Truck());
		return ((TakeTrucksOperation) so).getLista();
	}

	public List<IGeneralEntity> vratiPrikolice() throws Exception {
		AbstractGenericOperation so = new TakeTrailersOperation();
		so.templateExecute(new Trailer());
		return ((TakeTrailersOperation) so).getLista();
	}

	public void zapamtiVoznju(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new SaveDriveOperation();
		so.templateExecute(iGeneralEntity);
	}

	public List<IGeneralEntity> vratiVoznje() throws Exception {
		AbstractGenericOperation so = new TakeDrivesOperation();
		so.templateExecute(new Drive());
		return ((TakeDrivesOperation) so).getLista();
	}

	public void obrisiVoznju(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new DeleteDriveOperation();
		so.templateExecute(iGeneralEntity);
	}

	public void obrisiTrosak(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new DeleteCostItemOperation();
		so.templateExecute(iGeneralEntity);
	}

	public void obrisiListuTroskova(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new DeleteCostListOperation();
		so.templateExecute(iGeneralEntity);
	}

	public IGeneralEntity vratiVoznjuPoIDu(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new TakeDriveByIDOperation();
		so.templateExecute(iGeneralEntity);
		return ((TakeDriveByIDOperation) so).getObject();
	}

	public void updateDrive(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new UpdateDriveOperation();
		so.templateExecute(iGeneralEntity);
	}

	public void updateCostItem(IGeneralEntity iGeneralEntity) throws Exception {
		AbstractGenericOperation so = new UpdateCostItemOperation();
		so.templateExecute(iGeneralEntity);
	}

	public List<IGeneralEntity> vratiTroskovePoIDu() throws Exception {
		AbstractGenericOperation so = new TakeCostsOperation();
		so.templateExecute(new CostItem());
		return ((TakeCostsOperation) so).getLista();
	}

}
