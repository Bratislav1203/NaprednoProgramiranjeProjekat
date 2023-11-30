/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
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
public abstract class AbstractGenericOperationTest {
    protected IGeneralEntity entity;
    protected AbstractGenericOperation so;
    
    public AbstractGenericOperationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        so.db.openConnection();
    }
    
    @After
    public void tearDown() throws SQLException {
       so.db.closeConnection();
       entity = null;
       so = null;
    }


}
