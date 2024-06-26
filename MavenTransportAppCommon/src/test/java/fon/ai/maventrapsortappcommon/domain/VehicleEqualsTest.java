package fon.ai.maventrapsortappcommon.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Vehicle;

public class VehicleEqualsTest {
	
	Vehicle vehicle;
	
	@BeforeEach
	public void setUp() {
        vehicle = new Vehicle();
	}
	
	@Test
    void testEqualsSameObject() {
        assertTrue(vehicle.equals(vehicle), "Objekat bi trebalo da bude jednak samom sebi.");
    }

    @Test
    void testEqualsWithNull() {
        assertFalse(vehicle.equals(null), "Objekat ne bi trebalo da bude jednak null.");
    }

    @Test
    void testEqualsDifferentClass() {
        Object obj = new Object();
        assertFalse(vehicle.equals(obj), "Objekti različitih klasa ne bi trebalo da budu jednaki.");
    }

    @Test
    void testEqualsDifferentValues() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setBrand("Toyota");
        vehicle1.setProductYear(2020);
        vehicle1.setOznakaVozila("ABC123");
        vehicle1.setRegistrationMark("TE123ST");
        vehicle1.setWeight(1500.0);
        
        Vehicle vehicle2 = new Vehicle();
        vehicle1.setBrand("Honda");
        vehicle1.setProductYear(2021);
        vehicle1.setOznakaVozila("DEF456");
        vehicle1.setRegistrationMark("TE456ST");
        vehicle1.setWeight(1400.0);
        
        assertFalse(vehicle1.equals(vehicle2), "Objekti sa različitim vrednostima ne bi trebalo da budu jednaki.");
    }

    @Test
    void testEqualsSameValues() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setBrand("Toyota");
        vehicle1.setProductYear(2020);
        vehicle1.setOznakaVozila("ABC123");
        vehicle1.setRegistrationMark("TE123ST");
        vehicle1.setWeight(1500.0);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setBrand("Toyota");
        vehicle2.setProductYear(2020);
        vehicle2.setOznakaVozila("ABC123");
        vehicle2.setRegistrationMark("TE123ST");
        vehicle2.setWeight(1500.0);

        assertTrue(vehicle1.equals(vehicle2), "Objekti sa istim vrednostima bi trebalo da budu jednaki.");
    }
}
