package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Year;

public class VehicleTest {

    @Test
    public void testSetBrandNull() {
        Vehicle vehicle = new Vehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.setBrand(null), "Očekuje se IllegalArgumentException kada je brand null.");
    }

    @Test
    public void testSetBrandEmpty() {
        Vehicle vehicle = new Vehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.setBrand(""), "Očekuje se IllegalArgumentException kada je brand prazan string.");
    }

    @Test
    public void testSetProductYearInvalid() {
        Vehicle vehicle = new Vehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.setProductYear(1950), "Očekuje se IllegalArgumentException kada je productYear manji od 1951.");
        assertThrows(IllegalArgumentException.class, () -> vehicle.setProductYear(Year.now().getValue() + 1), "Očekuje se IllegalArgumentException kada je productYear veći od trenutne godine.");
    }

    @Test
    public void testSetRegistrationMarkNull() {
        Vehicle vehicle = new Vehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.setRegistrationMark(null), "Očekuje se IllegalArgumentException kada je registrationMark null.");
    }

    @Test
    public void testSetRegistrationMarkEmpty() {
        Vehicle vehicle = new Vehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.setRegistrationMark(""), "Očekuje se IllegalArgumentException kada je registrationMark prazan string.");
    }

    @Test
    public void testSetWeightInvalid() {
        Vehicle vehicle = new Vehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.setWeight(0), "Očekuje se IllegalArgumentException kada je weight 0.");
        assertThrows(IllegalArgumentException.class, () -> vehicle.setWeight(-1), "Očekuje se IllegalArgumentException kada je weight negativan.");
    }

    @Test
    public void testSetOznakaVozilaNull() {
        Vehicle vehicle = new Vehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.setOznakaVozila(null), "Očekuje se IllegalArgumentException kada je oznakaVozila null.");
    }

    @Test
    public void testSetOznakaVozilaEmpty() {
        Vehicle vehicle = new Vehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.setOznakaVozila(""), "Očekuje se IllegalArgumentException kada je oznakaVozila prazan string.");
    }
}
