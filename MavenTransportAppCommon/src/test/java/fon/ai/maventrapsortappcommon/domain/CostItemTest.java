package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.CostItem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class CostItemTest {

	CostItem costItem;
	
	@BeforeEach
	public void setUp() {
		costItem = new CostItem();
	}
	
    @Test
    public void testSetCostTypeNull() {
        assertThrows(IllegalArgumentException.class, () -> costItem.setCostType(null), "Očekuje se IllegalArgumentException kada je tip troška null.");
    }

    @Test
    public void testSetCostListNull() {
        assertThrows(IllegalArgumentException.class, () -> costItem.setCostList(null), "Očekuje se IllegalArgumentException kada je costList null.");
    }

    @Test
    public void testSetAmountInvalid() {
        assertThrows(IllegalArgumentException.class, () -> costItem.setAmount(0), "Očekuje se IllegalArgumentException kada je iznos troška 0.");
    }

    @Test
    public void testSetIdInvalid() {
        assertThrows(IllegalArgumentException.class, () -> costItem.setId(0), "Očekuje se IllegalArgumentException kada je ID 0.");
    }
}
