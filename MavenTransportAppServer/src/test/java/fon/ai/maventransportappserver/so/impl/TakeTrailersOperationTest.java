/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author stackOverflow
 */
public class TakeTrailersOperationTest {
	protected IGeneralEntity entity;
	protected AbstractGenericOperation so;

	public TakeTrailersOperationTest() {
	}

	@Before
	public void setUp() throws SQLException {
		entity = new Trailer();
		so = new TakeTrailersOperation();
		so.db.openConnection();
	}

	@After
	public void tearDown() throws SQLException {
		so.db.closeConnection();
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
	 * Test of validate method, of class TakeTrailersOperation.
	 */
	/**
	 * Test of execute method, of class TakeTrailersOperation.
	 */
	@Test
	public void testExecute() throws Exception {
		System.out.println("executing");
		List<Trailer> expected = new ArrayList<>();
		List<IGeneralEntity> lista = so.db.vratiSve(entity);
		for (IGeneralEntity ent : lista)
			expected.add((Trailer) ent);
		so.execute(entity);
		List<IGeneralEntity> rezultat = ((TakeTrailersOperation) so).getLista();
		assertEquals(expected.size(), rezultat.size());
	}

	/**
	 * Test of getLista method, of class TakeTrailersOperation.
	 */
	@Test
	public void testGetLista() throws Exception {
		System.out.println("getLista");
		so.execute(entity);
		List<IGeneralEntity> expResult = ((TakeTrailersOperation) so).getLista();
		List<IGeneralEntity> result = so.db.vratiSve(entity);

		assertEquals(expResult.size(), result.size());
	}

}
