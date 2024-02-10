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
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappcommon.domain.VehicleType;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author Bratislav
 */
public class SaveTrailerOperationTest {
	protected IGeneralEntity entity;
	protected AbstractGenericOperation so;

	public SaveTrailerOperationTest() {
	}

	@BeforeEach
	public void setUp() throws SQLException {
		entity = new Trailer(VehicleType.CIRADA, 98765, "SMITZ", 1995, "TE456ST", 7500, "P");
		so = new SaveTrailerOperation();
		so.db.openConnection();
	}

	@AfterEach
	public void tearDown() throws Exception {
		so.db.obrisi(entity);
		so.db.closeConnection();
	}

	/**
	 * Test of validate method, of class SaveTrailerOperation.
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
	    so.templateExecute(entity);
	    Trailer expected = (Trailer) so.db.vratiPoId(entity);
        Trailer compare = (Trailer) entity;

	    assertEquals(expected.getRegistrationMark(), compare.getRegistrationMark());
	}
	


}
