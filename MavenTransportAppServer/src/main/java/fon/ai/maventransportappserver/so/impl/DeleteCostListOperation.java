package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.CostList;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

public class DeleteCostListOperation extends AbstractGenericOperation {

	@Override
	public void validate(Object entity) throws Exception {
		if (!(entity instanceof CostList)) {
			throw new Exception("Objekat nije validan");
		}
	}

	@Override
	public void execute(Object entity) throws Exception {
		db.obrisi((IGeneralEntity) entity);

	}
}