/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappserver.so.AbstractGenericOperationTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class TakeDriversOperationTest extends AbstractGenericOperationTest{
    
    public TakeDriversOperationTest() {
    }
    
    @Before
    public void setUp() throws SQLException {
        entity = new Driver();
        so = new TakeDriversOperation();
        so.db.openConnection();
    }
    
    @After
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

    @Test(expected = java.lang.Exception.class)
    public void testValidate1() throws Exception {
        System.out.println("validate1");
        so.validate(new User());
    }

    /**
     * Test of execute method, of class TakeDriversOperation.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("executing");
        List<Driver> expected = new ArrayList<>();
        List<IGeneralEntity> lista = so.db.vratiSve(entity);
        for(IGeneralEntity ent : lista)
            expected.add((Driver)ent);
        so.execute(entity);
        List<IGeneralEntity> rezultat = ((TakeDriversOperation)so).getLista();
        assertEquals(expected.size(), rezultat.size());
    }

    /**
     * Test of getLista method, of class TakeDriversOperation.
     */
    @Test
    public void testGetLista() throws Exception {
        System.out.println("getLista");
        so.execute(entity);
        List<IGeneralEntity> expResult = ((TakeDriversOperation)so).getLista();
        List<IGeneralEntity> result = so.db.vratiSve(entity);
        
        assertEquals(expResult.size(), result.size());
    }
    
}
