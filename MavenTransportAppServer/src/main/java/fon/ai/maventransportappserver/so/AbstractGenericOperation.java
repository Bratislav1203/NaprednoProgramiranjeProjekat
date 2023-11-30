 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so;

import fon.ai.maventransportappserver.database.impl.DatabaseBroker;
/**
 *
 * @author stackoverflowVlado
 * 
 */
public abstract class AbstractGenericOperation {
    public DatabaseBroker db;
    
    public AbstractGenericOperation() {
        db = new DatabaseBroker();
    }
    
    public final void templateExecute(Object entity) throws Exception {
        try {
            validate(entity);
            startTransaction();
            execute(entity);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }
    
    public abstract void validate(Object entity) throws Exception;

    public abstract void execute(Object entity) throws Exception;

    private void startTransaction() throws Exception {
        //Konekcija.getInstance().getConnection().setAutoCommit(false);
        db.connectToDatabase();
    }

    private void commitTransaction() throws Exception {
        //Konekcija.getInstance().commit();
        db.commit();
        System.out.println("COMMIT");
    }

    private void rollbackTransaction() throws Exception {
        //Konekcija.getInstance().rollback();
        db.rollback();
        System.out.println("ROLLBACK");
    }
}
