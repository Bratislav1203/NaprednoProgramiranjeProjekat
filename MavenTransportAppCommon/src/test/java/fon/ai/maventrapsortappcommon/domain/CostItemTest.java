package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.CostItem;

import static org.junit.jupiter.api.Assertions.*;

public class CostItemTest {

    @Test
    public void testSetCostTypeNull() {
        CostItem costItem = new CostItem();
        assertThrows(IllegalArgumentException.class, () -> costItem.setCostType(null), "Očekuje se IllegalArgumentException kada je tip troška null.");
    }

    @Test
    public void testSetCostListNull() {
        CostItem costItem = new CostItem();
        assertThrows(IllegalArgumentException.class, () -> costItem.setCostList(null), "Očekuje se IllegalArgumentException kada je costList null.");
    }

    @Test
    public void testSetAmountInvalid() {
        CostItem costItem = new CostItem();
        assertThrows(IllegalArgumentException.class, () -> costItem.setAmount(0), "Očekuje se IllegalArgumentException kada je iznos troška 0.");
    }

    @Test
    public void testSetIdInvalid() {
        CostItem costItem = new CostItem();
        assertThrows(IllegalArgumentException.class, () -> costItem.setId(0), "Očekuje se IllegalArgumentException kada je ID 0.");
    }
}
