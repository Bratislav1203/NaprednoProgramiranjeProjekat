package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.CostList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class CostListTest {

	CostList costList;
	
	@BeforeEach
	public void setUp() {
		costList = new CostList();
	}
	
    @Test
    public void testSetDriveNull() {
        assertThrows(IllegalArgumentException.class, () -> costList.setDrive(null), "Očekuje se IllegalArgumentException kada je drive null.");
    }

    @Test
    public void testSetIdInvalid() {
        assertThrows(IllegalArgumentException.class, () -> costList.setId(0), "Očekuje se IllegalArgumentException kada je ID 0.");
    }

    @Test
    public void testSetCostsNull() {
        assertThrows(IllegalArgumentException.class, () -> costList.setCosts(null), "Očekuje se IllegalArgumentException kada je lista troškova null.");
    }
}
