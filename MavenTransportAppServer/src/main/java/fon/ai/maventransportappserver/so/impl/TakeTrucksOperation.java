/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.Vehicle;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author Windows HD
 */
public class TakeTrucksOperation extends AbstractGenericOperation{
    private List<IGeneralEntity> lista;

    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Truck)) {
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    public void execute(Object entity) throws Exception {
        lista = db.vratiSve((IGeneralEntity) entity);
        if(lista.isEmpty()) {
            throw new Exception("Sistem ne moze da nadje vozila");
        }
    }
    public List<IGeneralEntity> getLista() {
        return lista;
    }
    
}
