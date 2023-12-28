package fon.ai.maventransportappserver.so.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.CostList;
import fon.ai.maventransportappcommon.domain.CostType;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappcommon.domain.VehicleType;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;
import static org.junit.Assert.assertNull;

public class DeleteDriveOperationTest {

	protected IGeneralEntity entity;
	protected AbstractGenericOperation so;

	@Before
	public void setUp() throws Exception {
		Truck truck = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
		Trailer trailer = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447RA", 7500, "P");
		Driver driver = new Driver(12345678, "Vlada", "Vladic");
		ArrayList<CostItem> costs = new ArrayList<>();
		CostItem c1 = new CostItem(CostType.driverSallary, 300);
		CostItem c2 = new CostItem(CostType.fuel, 300);
		CostItem c3 = new CostItem(CostType.toll, 300);
		CostItem c4 = new CostItem(CostType.other, 300);
		costs.add(c1);
		costs.add(c2);
		costs.add(c3);
		costs.add(c4);
		CostList cl = new CostList(2);
		c1.setCostList(cl);
		c2.setCostList(cl);
		c3.setCostList(cl);
		c4.setCostList(cl);
		cl.setCosts(costs);
		entity = new Drive(2, new Date(), 500, trailer, truck, driver, cl);
		
		
		so = new TakeDriveByIDOperation();
		so.db.openConnection();
		
		Drive expected = (Drive) so.db.vratiPoId(entity);

		if (expected == null) {
			so = new SaveDriveOperation();
			so.templateExecute((Drive) entity);
		}
		so = new DeleteDriveOperation();

	}

	@After
	public void tearDown() throws Exception {
		so.db.openConnection();
		Drive expected = (Drive) so.db.vratiPoId(entity);

		if (expected != null) {
			so.db.closeConnection();
			return;
		}
		so = new SaveDriveOperation();
		try {
			so.templateExecute(entity);
		} catch (Exception ex) {
			Logger.getLogger(SaveDriveOperationTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Test
	public void testValidate() throws Exception {
		System.out.println("validate");
		so.validate(entity);
	}

	@Test(expected = java.lang.Exception.class)
	public void testValidate1() throws Exception {
		System.out.println("validate1");
		so.validate(new User());
	}

	/**
	 * Test of execute method, of class SaveDriveOperation.
	 */
	@Test
	public void testExecute() throws Exception {
		so.templateExecute(entity);

		Drive deletedDrive = (Drive) so.db.vratiPoId((IGeneralEntity) entity);
		assertNull("Voznja bi trebalo da je obrisana iz baze", deletedDrive);
	}

}
