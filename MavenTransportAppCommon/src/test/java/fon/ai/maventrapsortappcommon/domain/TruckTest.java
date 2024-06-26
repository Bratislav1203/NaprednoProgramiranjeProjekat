package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Truck;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class TruckTest {

	Truck truck;
	
	@BeforeEach
	public void setUp() {
        truck = new Truck();
	}
	
    @Test
    public void testSetTransmissionNull() {
        assertThrows(IllegalArgumentException.class, () -> truck.setTransmission(null), "Očekuje se IllegalArgumentException kada je transmission null.");
    }

    @Test
    public void testSetTransmissionEmpty() {
        assertThrows(IllegalArgumentException.class, () -> truck.setTransmission(""), "Očekuje se IllegalArgumentException kada je transmission prazan string.");
    }

    @Test
    public void testSetTransmissionValid() {
        String transmission = "Manual";
        truck.setTransmission(transmission);
        assertEquals(transmission, truck.getTransmission(), "Transmission treba da bude postavljen na 'Manual'.");
    }
}
