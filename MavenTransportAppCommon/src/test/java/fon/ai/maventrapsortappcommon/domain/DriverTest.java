package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import fon.ai.maventransportappcommon.domain.Driver;

import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {

    private Driver driver;

    @BeforeEach
    public void setUp() {
        driver = new Driver();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 123})
    public void testSetIDCardInvalid(int invalidIDCard) {
        assertThrows(IllegalArgumentException.class, () -> driver.setIDCard(invalidIDCard), "Očekuje se IllegalArgumentException kada je IDCard " + invalidIDCard + ".");
    }

    @Test
    public void testSetNameNull() {
        assertThrows(IllegalArgumentException.class, () -> driver.setName(null), "Očekuje se IllegalArgumentException kada je ime null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "A1", "A"})
    public void testSetNameInvalid(String invalidName) {
        assertThrows(IllegalArgumentException.class, () -> driver.setName(invalidName), "Očekuje se IllegalArgumentException za nevalidno ime: " + invalidName);
    }

    @Test
    public void testSetSurnameNull() {
        assertThrows(IllegalArgumentException.class, () -> driver.setSurname(null), "Očekuje se IllegalArgumentException kada je prezime null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "B1", "B"})
    public void testSetSurnameInvalid(String invalidSurname) {
        assertThrows(IllegalArgumentException.class, () -> driver.setSurname(invalidSurname), "Očekuje se IllegalArgumentException za nevalidno prezime: " + invalidSurname);
    }
}
