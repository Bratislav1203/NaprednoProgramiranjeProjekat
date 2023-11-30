/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author Windows HD
 */
public class SaveDriverOperation extends AbstractGenericOperation{
    private List<IGeneralEntity> lista;

    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Driver)) {
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    public void execute(Object entity) throws Exception {
        Driver d = (Driver) entity;
        
        lista = db.vratiPoUslovu((IGeneralEntity) entity);
        if (!lista.isEmpty()) {
            throw new Exception("Vec postoji vozac sa ovim brojem licne karte!");
        }
        db.sacuvaj((IGeneralEntity) entity);
    }
    
    
}
