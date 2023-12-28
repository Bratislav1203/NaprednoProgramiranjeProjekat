/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author Windows HD
 */
public class DeleteDriveOperation extends AbstractGenericOperation{
    

    @Override
    public void validate(Object entity) throws Exception {
        if(!(entity instanceof Drive)) {
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    public void execute(Object entity) throws Exception {
    	Drive d = (Drive) entity;
		for (CostItem c : d.getCostList().getCosts()) {
			if (c.getCostList().getId() == d.getId())
				db.obrisi(c);
		}
		db.obrisi(d.getCostList());
    	db.obrisi((IGeneralEntity) entity);
    }
    
    
    
}
