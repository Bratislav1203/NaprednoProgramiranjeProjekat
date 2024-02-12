package fon.ai.maventransportappclient.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModelCostPrikazTest {
    ModelCostPrikaz mcp;

    @BeforeEach
    public void setUp() {
        mcp = new ModelCostPrikaz();
    }

    @AfterEach
    public void tearDown() {
        mcp = null;
    }

    @Test
    public void brojacKolona() {
        assertEquals(2, mcp.getColumnCount());
    }

    @Test
    public void brojacRedova() {
        assertEquals(0, mcp.getRowCount());
    }

    @Test
    public void getValueAtTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> mcp.getValueAt(0, 0));
    }
}
