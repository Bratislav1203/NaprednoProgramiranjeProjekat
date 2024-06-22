package fon.ai.maventrapsortappcommon.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Driver;

public class DriverToStringTest {

	@Test
    void testToString() {
        Driver driver = new Driver();
        driver.setName("Petar");
        driver.setSurname("Petrovic"); 
        String expectedOutput = "Petar Petrovic";
        assertEquals(expectedOutput, driver.toString(), "toString metoda ne vraća očekivani ispis.");
    }
	
}
