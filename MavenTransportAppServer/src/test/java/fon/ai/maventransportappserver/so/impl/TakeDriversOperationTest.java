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


import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author stackOverflow
 */
public class TakeDriversOperationTest {
	protected IGeneralEntity entity;
	protected AbstractGenericOperation so;

	public TakeDriversOperationTest() {
	}

	@BeforeEach
	public void setUp() throws SQLException {
		entity = new Driver();
		so = new TakeDriversOperation();
		so.db.openConnection();
	}

	@AfterEach
	public void tearDown() throws SQLException {
		so.db.openConnection();
	}

	/**
	 * Test of validate method, of class TakeDriversOperation.
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
	 * Test of execute method, of class TakeDriversOperation.
	 */
	@Test
	public void testExecute() throws Exception {
		System.out.println("executing");
		List<Driver> expected = new ArrayList<>();
		List<IGeneralEntity> lista = so.db.vratiSve(entity);
		for (IGeneralEntity ent : lista)
			expected.add((Driver) ent);
		so.execute(entity);
		List<IGeneralEntity> rezultat = ((TakeDriversOperation) so).getLista();
		assertEquals(expected.size(), rezultat.size());
	}

	/**
	 * Test of getLista method, of class TakeDriversOperation.
	 */
	@Test
	public void testGetLista() throws Exception {
		System.out.println("getLista");
		so.execute(entity);
		List<IGeneralEntity> expResult = ((TakeDriversOperation) so).getLista();
		List<IGeneralEntity> result = so.db.vratiSve(entity);

		assertEquals(expResult.size(), result.size());
	}

}
