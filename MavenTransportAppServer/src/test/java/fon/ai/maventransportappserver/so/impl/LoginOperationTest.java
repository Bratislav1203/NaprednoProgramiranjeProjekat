/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;
import fon.ai.maventransportappserver.so.AbstractGenericOperationTest;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stackOverflow
 */
public class LoginOperationTest extends AbstractGenericOperationTest{
    private static IGeneralEntity entity;
    private static AbstractGenericOperation so;
    
    public LoginOperationTest() {
    }
    
    @Before
    public void setUp() throws SQLException {
        entity = new User();
        ((User) entity).setName("vlado1203");
        ((User) entity).setPassword("bane1203");
        so = new LoginOperation();
        so.db.openConnection();
    }
    
    @After
    public void tearDown() throws SQLException {
        so.db.closeConnection();
    }

    /**
     * Test of validate method, of class LoginOperation.
     */
    @Test
    public void testValidate() throws Exception {
        System.out.println("validate");
        so.validate(entity);
    }
    
    @Test(expected = java.lang.Exception.class)
    public void testValidate1() throws Exception {
        System.out.println("validate1");
        Drive test = new Drive();
        so.validate(test);
    }

    /**
     * Test of getObject method, of class LoginOperation.
     */
    @Test
    public void testGetObject() throws Exception {
        LoginOperation instance = new LoginOperation();
        IGeneralEntity expResult = entity;
        instance.setObject(entity);
        IGeneralEntity result = instance.getObject();
        assertEquals(expResult, result);
    }
    
}
