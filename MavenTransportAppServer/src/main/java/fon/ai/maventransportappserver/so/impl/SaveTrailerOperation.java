/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Vehicle;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author Windows HD
 */
public class SaveTrailerOperation extends AbstractGenericOperation{

    private List<IGeneralEntity> lista;
    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Vehicle)) {
            throw new Exception("Objekat nije validan");
        }
        
    }

    @Override
    public void execute(Object entity) throws Exception {
        Vehicle v = (Vehicle) entity;
        System.out.println("makar usao u execute");
        /*lista = db.vratiPoUslovu((IGeneralEntity) entity);
        if (!lista.isEmpty()) {
            throw new Exception("Vec postoji ovaj kamion");
        }
        System.out.println("prosao uslov za postojanje kamiona");*/ // implementiraj ovo kasnije
        db.sacuvaj((IGeneralEntity) entity);
        System.out.println("prosao cuvanje u savetruckoperation");
        
    }
    
}
