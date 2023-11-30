/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappcommon.domain.VehicleType;
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
public class SaveTrailerOperationTest extends AbstractGenericOperationTest{
    
    public SaveTrailerOperationTest() {
    }

    @Before
    public void setUp() throws SQLException {
        entity = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447RA", 7500, "P");
        so = new SaveTruckOperation();
        so.db.openConnection();
    }
    
    @After
    public void tearDown() throws SQLException {
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
    
    @Test(expected = java.lang.Exception.class)
    public void testValidate1() throws Exception {
        System.out.println("validate1");
        so.validate(new User());
    }

    /**
     * Test of execute method, of class SaveTrailerOperation.
     */
    @Test(expected = java.lang.Exception.class)
    public void testExecute() throws Exception {
        System.out.println("execute");
        so.execute(entity);
        Trailer expected = (Trailer) so.db.vratiPoId((IGeneralEntity)entity);
        Trailer compare = (Trailer)entity;
        assertEquals(expected.getRegistrationMark(), compare.getRegistrationMark());
    }
    
}
