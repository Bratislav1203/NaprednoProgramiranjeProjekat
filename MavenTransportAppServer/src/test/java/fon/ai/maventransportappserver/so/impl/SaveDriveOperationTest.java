/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

/**
 *
 * @author Bratislav
 */
public class SaveDriveOperationTest {
	protected IGeneralEntity entity;
	protected AbstractGenericOperation so;

	public SaveDriveOperationTest() {
	}

	@BeforeEach
	public void setUp() throws SQLException {
		Truck truck = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
		Trailer trailer = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447RA", 7500, "P");
		Driver driver = new Driver(123456788, "Vlada", "Vladic");ArrayList<CostItem> costs = new ArrayList<>();
		CostItem c1 = new CostItem(CostType.driverSallary, 300);
		CostItem c2 = new CostItem(CostType.fuel, 300);
		CostItem c3 = new CostItem(CostType.toll, 300);
		CostItem c4 = new CostItem(CostType.other, 300);
		costs.add(c1);
		costs.add(c2);
		costs.add(c3);
		costs.add(c4);
		CostList cl = new CostList(1050);
		c1.setCostList(cl);
		c2.setCostList(cl);
		c3.setCostList(cl);
		c4.setCostList(cl);
		
		cl.setCosts(costs);
		
		entity = new Drive(1050, new Date(), 500, trailer, truck, driver, cl);
		cl.setDrive((Drive) entity);
		Drive d = (Drive) entity;
		int id = d.getId();
		
		so = new SaveDriveOperation();
		so.db.openConnection();
	}

	@AfterEach
	public void tearDown() {
		so = new DeleteDriveOperation();
		try {
			so.templateExecute(entity);
		} catch (Exception ex) {
			Logger.getLogger(SaveDriveOperationTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Test of validate method, of class SaveDriveOperation.
	 */
	@Test
	public void testValidate() throws Exception {
		System.out.println("validate");
		so.validate(entity);
	}

	@Test
    public void testValidate1() throws Exception {
        System.out.println("validate1");
        assertThrows(Exception.class, () -> so.validate(new User()));
    }

	@Test
	public void testExecute() throws Exception {
		System.out.println("execute");
		so.execute(entity);
		Drive expected = (Drive) so.db.vratiPoId((IGeneralEntity) entity);
		Drive compare = (Drive) entity;
		assertEquals(expected.getId(), compare.getId());
	}

}
