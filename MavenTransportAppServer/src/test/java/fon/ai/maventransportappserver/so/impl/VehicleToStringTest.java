package fon.ai.maventransportappserver.so.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Vehicle;

public class VehicleToStringTest {

	@Test
    void testToString() {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Toyota");
        vehicle.setProductYear(2020); 
        String expectedOutput = "Toyota - 2020";
        assertEquals(expectedOutput, vehicle.toString(), "toString metoda ne vraća očekivani ispis.");
    }
	
}
