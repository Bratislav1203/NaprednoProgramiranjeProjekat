/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappcommon.domain.VehicleType;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;
import fon.ai.maventransportappserver.so.AbstractGenericOperationTest;
import java.sql.SQLException;
import java.util.Date;
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
public class SaveDriveOperationTest extends AbstractGenericOperationTest{
    
    public SaveDriveOperationTest() {
    }
    
    @Before
    public void setUp() throws SQLException {
        Truck truck = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
        Trailer trailer = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447RA", 7500, "P");
        Driver driver = new Driver(12345678, "Vlada", "Vladic");
        entity = new Drive(14, new Date(), 500, trailer , truck, driver);
        so = new SaveDriveOperation();
        so.db.openConnection();
    }
    
    @After
    public void tearDown(){
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
        System.out.println("execute");
        so.execute(entity);
        Drive expected = (Drive) so.db.vratiPoId((IGeneralEntity)entity);
        Drive compare = (Drive)entity;
        assertEquals(expected.getId(), compare.getId());
    }
    
}
