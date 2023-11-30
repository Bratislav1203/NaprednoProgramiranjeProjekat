/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappserver.so.AbstractGenericOperationTest;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SaveTruckOperationTest extends AbstractGenericOperationTest{
    
    public SaveTruckOperationTest() {
    }
    
    @Before
    public void setUp() throws SQLException {
        entity = new Truck("AUTOMATIC", "daf", 1995, "RA013CG", 8800, "K");
        so = new SaveTruckOperation();
        so.db.openConnection();
    }
    
    @After
    public void tearDown() { //ne znaci rollback, tako da ako jednom unesem sa jednim ID-em, sledeci put test ne prolazi
 
    }

    /**
     * Test of validate method, of class SaveTruckOperation.
     */
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
     * Test of execute method, of class SaveTruckOperation.
     */
    @Test(expected = java.lang.Exception.class)
    public void testExecute() throws Exception {
        System.out.println("execute");
        so.execute(entity);
        Truck expected = (Truck) so.db.vratiPoId((IGeneralEntity)entity);
        Truck compare = (Truck)entity;
        assertEquals(expected.getRegistrationMark(), compare.getRegistrationMark());
    }
    
}
