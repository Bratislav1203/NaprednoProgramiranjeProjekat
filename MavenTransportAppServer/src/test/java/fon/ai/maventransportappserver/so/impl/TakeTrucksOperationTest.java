/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * @author stackOverflow
 */
public class TakeTrucksOperationTest {
	protected IGeneralEntity entity;
	protected AbstractGenericOperation so;

	public TakeTrucksOperationTest() {
	}

	@BeforeEach
	public void setUp() throws SQLException {
		entity = new Truck();
		so = new TakeTrucksOperation();
		so.db.openConnection();
	}

	@AfterEach
	public void tearDown() throws SQLException {
		so.db.openConnection();
	}

	/**
	 * Test of validate method, of class TakeTrucksOperation.
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

	/**
	 * Test of execute method, of class TakeTrucksOperation.
	 */
	@Test
	public void testExecute() throws Exception {
		System.out.println("executing");
		List<Truck> expected = new ArrayList<>();
		List<IGeneralEntity> lista = so.db.vratiSve(entity);
		for (IGeneralEntity ent : lista)
			expected.add((Truck) ent);
		so.execute(entity);
		List<IGeneralEntity> rezultat = ((TakeTrucksOperation) so).getLista();
		assertEquals(expected.size(), rezultat.size());
	}

	/**
	 * Test of getLista method, of class TakeTrucksOperation.
	 */
	@Test
	public void testGetLista() throws Exception {
		System.out.println("getLista");
		so.execute(entity);
		List<IGeneralEntity> expResult = ((TakeTrucksOperation) so).getLista();
		List<IGeneralEntity> result = so.db.vratiSve(entity);

		assertEquals(expResult.size(), result.size());
	}
}
