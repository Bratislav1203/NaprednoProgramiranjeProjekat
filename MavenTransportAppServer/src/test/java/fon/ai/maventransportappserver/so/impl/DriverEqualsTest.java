package fon.ai.maventransportappserver.so.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Driver;

public class DriverEqualsTest {

	@Test
    void testEqualsSameObject() {
        Driver driver = new Driver();
        assertTrue(driver.equals(driver), "Objekat bi trebalo da bude jednak samom sebi.");
    }

    @Test
    void testEqualsWithNull() {
        Driver driver = new Driver();
        assertFalse(driver.equals(null), "Objekat ne bi trebalo da bude jednak null.");
    }

    @Test
    void testEqualsDifferentClass() {
        Driver driver = new Driver();
        Object obj = new Object();
        assertFalse(driver.equals(obj), "Objekti različitih klasa ne bi trebalo da budu jednaki.");
    }

    @Test
    void testEqualsDifferentValues() {
        Driver driver1 = new Driver();
        driver1.setIDCard(123456789); 
        driver1.setName("Petar");
        driver1.setSurname("Petrovic");

        Driver driver2 = new Driver();
        driver2.setIDCard(987654321);
        driver2.setName("Marko");
        driver2.setSurname("Markovic");

        assertFalse(driver1.equals(driver2), "Objekti sa različitim vrednostima ne bi trebalo da budu jednaki.");
    }

    @Test
    void testEqualsSameValues() {
        Driver driver1 = new Driver();
        driver1.setIDCard(123456789);
        driver1.setName("Petar");
        driver1.setSurname("Petrovic");

        Driver driver2 = new Driver();
        driver2.setIDCard(123456789);
        driver2.setName("Petar");
        driver2.setSurname("Petrovic");

        assertTrue(driver1.equals(driver2), "Objekti sa istim vrednostima bi trebalo da budu jednaki.");
    }
	
}
