package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Trailer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class TrailerTest {

	Trailer trailer;
	
	@BeforeEach
	public void setUp() {
		trailer = new Trailer();
	}
	
    @Test
    public void testSetVtNull() {
        assertThrows(IllegalArgumentException.class, () -> trailer.setVt(null), "Očekuje se IllegalArgumentException kada je vrsta vozila null.");
    }

    @Test
    public void testSetLoadCapacityInvalid() {
        assertThrows(IllegalArgumentException.class, () -> trailer.setLoadCapacity(0), "Očekuje se IllegalArgumentException za nosivost 0.");
    }

    @Test
    public void testSetTNull() {
        assertThrows(IllegalArgumentException.class, () -> trailer.setT(null), "Očekuje se IllegalArgumentException kada je kamion null.");
    }

    @Test
    public void testSetBrandNull() {
        assertThrows(IllegalArgumentException.class, () -> trailer.setBrand(null), "Očekuje se IllegalArgumentException kada je marka vozila null.");
    }

    @Test
    public void testSetRegistrationMarkNull() {
        assertThrows(IllegalArgumentException.class, () -> trailer.setRegistrationMark(null), "Očekuje se IllegalArgumentException kada je registraciona oznaka null.");
    }

    @Test
    public void testSetWeightInvalid() {
        assertThrows(IllegalArgumentException.class, () -> trailer.setWeight(0), "Očekuje se IllegalArgumentException kada je težina 0.");
    }
}
