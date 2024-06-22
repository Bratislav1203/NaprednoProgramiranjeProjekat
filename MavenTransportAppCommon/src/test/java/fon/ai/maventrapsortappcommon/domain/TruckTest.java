package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Truck;

import static org.junit.jupiter.api.Assertions.*;

public class TruckTest {

    @Test
    public void testSetTransmissionNull() {
        Truck truck = new Truck();
        assertThrows(IllegalArgumentException.class, () -> truck.setTransmission(null), "Očekuje se IllegalArgumentException kada je transmission null.");
    }

    @Test
    public void testSetTransmissionEmpty() {
        Truck truck = new Truck();
        assertThrows(IllegalArgumentException.class, () -> truck.setTransmission(""), "Očekuje se IllegalArgumentException kada je transmission prazan string.");
    }

    @Test
    public void testSetTransmissionValid() {
        Truck truck = new Truck();
        String transmission = "Manual";
        truck.setTransmission(transmission);
        assertEquals(transmission, truck.getTransmission(), "Transmission treba da bude postavljen na 'Manual'.");
    }
}
