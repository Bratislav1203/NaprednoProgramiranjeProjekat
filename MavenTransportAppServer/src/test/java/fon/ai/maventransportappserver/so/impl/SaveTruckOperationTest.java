/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author Bratislav
 */
public class SaveTruckOperationTest {
	protected IGeneralEntity entity;
	protected AbstractGenericOperation so;

	public SaveTruckOperationTest() {
	}

	@BeforeEach
	public void setUp() throws SQLException {
		entity = new Truck("AUTOMATIC", "daf", 1995, "TE123ST", 8800, "K");
		so = new SaveTruckOperation();
		so.db.openConnection();
	}

	@AfterEach
	public void tearDown() {
		try {
			so.db.obrisi(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test of validate method, of class SaveTruckOperation.
	 */
	@Test
	public void testValidate() throws Exception {
		System.out.println("validate");
		so.validate(entity);
	}

    @Test
    public void testValidate1() {
        System.out.println("validate1");
        assertThrows(Exception.class, () -> so.validate(new User()));
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        so.execute(entity);
        Truck expected = (Truck) so.db.vratiPoId(entity);
        Truck compare = (Truck) entity;
        
        assertEquals(expected.getRegistrationMark(), compare.getRegistrationMark());
    }
    
}
