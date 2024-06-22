package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Driver;

import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {

    @Test
    public void testSetIDCardInvalid() {
        Driver driver = new Driver();
        assertThrows(IllegalArgumentException.class, () -> driver.setIDCard(0), "Očekuje se IllegalArgumentException kada je IDCard 0.");
        assertThrows(IllegalArgumentException.class, () -> driver.setIDCard(123), "Očekuje se IllegalArgumentException kada IDCard nema tačno 9 cifara.");
    }

    @Test
    public void testSetNameNull() {
        Driver driver = new Driver();
        assertThrows(IllegalArgumentException.class, () -> driver.setName(null), "Očekuje se IllegalArgumentException kada je ime null.");
    }

    @Test
    public void testSetNameEmpty() {
        Driver driver = new Driver();
        assertThrows(IllegalArgumentException.class, () -> driver.setName(""), "Očekuje se IllegalArgumentException kada je ime prazan string.");
    }

    @Test
    public void testSetNameInvalid() {
        Driver driver = new Driver();
        assertThrows(IllegalArgumentException.class, () -> driver.setName("A1"), "Očekuje se IllegalArgumentException kada ime sadrži nedozvoljene karaktere.");
        assertThrows(IllegalArgumentException.class, () -> driver.setName("A"), "Očekuje se IllegalArgumentException kada ime ima manje od 2 karaktera.");
    }

    @Test
    public void testSetSurnameNull() {
        Driver driver = new Driver();
        assertThrows(IllegalArgumentException.class, () -> driver.setSurname(null), "Očekuje se IllegalArgumentException kada je prezime null.");
    }

    @Test
    public void testSetSurnameEmpty() {
        Driver driver = new Driver();
        assertThrows(IllegalArgumentException.class, () -> driver.setSurname(""), "Očekuje se IllegalArgumentException kada je prezime prazan string.");
    }

    @Test
    public void testSetSurnameInvalid() {
        Driver driver = new Driver();
        assertThrows(IllegalArgumentException.class, () -> driver.setSurname("B1"), "Očekuje se IllegalArgumentException kada prezime sadrži nedozvoljene karaktere.");
        assertThrows(IllegalArgumentException.class, () -> driver.setSurname("B"), "Očekuje se IllegalArgumentException kada prezime ima manje od 2 karaktera.");
    }
}
