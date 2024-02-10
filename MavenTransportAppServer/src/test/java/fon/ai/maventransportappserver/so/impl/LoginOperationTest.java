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

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author Bratislav
 */
public class LoginOperationTest {
	private static IGeneralEntity entity;
	private static AbstractGenericOperation so;

	public LoginOperationTest() {
	}

	@BeforeEach
	public void setUp() throws SQLException {
		entity = new User();
		((User) entity).setUsername("vlado1203");
		((User) entity).setPassword("bane1203");
		so = new LoginOperation();
		so.db.openConnection();
	}

	@AfterEach
	public void tearDown() throws SQLException {
		so.db.closeConnection();
	}

	@Test
	public void testValidate() throws Exception {
		System.out.println("validate");
		so.validate(entity);
	}

	@Test
	public void testValidate1() throws Exception {
		System.out.println("validate1");
		Drive test = new Drive();
		assertThrows(Exception.class, () -> so.validate(test));
	}

	@Test
	public void testGetObject() throws Exception {
		LoginOperation instance = new LoginOperation();
		IGeneralEntity expResult = entity;
		instance.setObject(entity);
		IGeneralEntity result = instance.getObject();
		assertEquals(expResult, result);
	}
}
