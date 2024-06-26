package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import fon.ai.maventransportappcommon.domain.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Year;
import java.util.stream.Stream;

public class VehicleTest {

    private Vehicle vehicle;

    @BeforeEach
    public void setUp() {
        vehicle = new Vehicle();
    }

    @Test
    public void testSetBrandNull() {
        assertThrows(IllegalArgumentException.class, () -> vehicle.setBrand(null), "Očekuje se IllegalArgumentException kada je brand null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void testSetBrandInvalid(String invalidBrand) {
        assertThrows(IllegalArgumentException.class, () -> vehicle.setBrand(invalidBrand), "Očekuje se IllegalArgumentException kada je brand prazan string ili samo whitespace.");
    }
    
    static Stream<Integer> provideInvalidProductYears() {
        return Stream.of(1950, Year.now().getValue() + 1);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidProductYears")
    public void testSetProductYearInvalid(int invalidYear) {
        assertThrows(IllegalArgumentException.class, () -> vehicle.setProductYear(invalidYear), "Očekuje se IllegalArgumentException za nevalidnu godinu proizvodnje: " + invalidYear);
    }
    

    @Test
    public void testSetRegistrationMarkNull() {
        assertThrows(IllegalArgumentException.class, () -> vehicle.setRegistrationMark(null), "Očekuje se IllegalArgumentException kada je registrationMark null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void testSetRegistrationMarkInvalid(String invalidMark) {
        assertThrows(IllegalArgumentException.class, () -> vehicle.setRegistrationMark(invalidMark), "Očekuje se IllegalArgumentException kada je registrationMark prazan string ili samo whitespace.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void testSetWeightInvalid(int invalidWeight) {
        assertThrows(IllegalArgumentException.class, () -> vehicle.setWeight(invalidWeight), "Očekuje se IllegalArgumentException za nevalidnu težinu: " + invalidWeight);
    }

    @Test
    public void testSetOznakaVozilaNull() {
        assertThrows(IllegalArgumentException.class, () -> vehicle.setOznakaVozila(null), "Očekuje se IllegalArgumentException kada je oznakaVozila null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void testSetOznakaVozilaInvalid(String invalidOznaka) {
        assertThrows(IllegalArgumentException.class, () -> vehicle.setOznakaVozila(invalidOznaka), "Očekuje se IllegalArgumentException kada je oznakaVozila prazan string ili samo whitespace.");
    }
}
