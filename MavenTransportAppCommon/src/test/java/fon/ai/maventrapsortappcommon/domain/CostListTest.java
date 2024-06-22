package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.CostList;

import static org.junit.jupiter.api.Assertions.*;

public class CostListTest {

    @Test
    public void testSetDriveNull() {
        CostList costList = new CostList();
        assertThrows(IllegalArgumentException.class, () -> costList.setDrive(null), "Očekuje se IllegalArgumentException kada je drive null.");
    }

    @Test
    public void testSetIdInvalid() {
        CostList costList = new CostList();
        assertThrows(IllegalArgumentException.class, () -> costList.setId(0), "Očekuje se IllegalArgumentException kada je ID 0.");
    }

    @Test
    public void testSetCostsNull() {
        CostList costList = new CostList();
        assertThrows(IllegalArgumentException.class, () -> costList.setCosts(null), "Očekuje se IllegalArgumentException kada je lista troškova null.");
    }
}
