package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Trailer;

import static org.junit.jupiter.api.Assertions.*;

public class TrailerTest {

    @Test
    public void testSetVtNull() {
        Trailer trailer = new Trailer();
        assertThrows(IllegalArgumentException.class, () -> trailer.setVt(null), "Očekuje se IllegalArgumentException kada je vrsta vozila null.");
    }

    @Test
    public void testSetLoadCapacityInvalid() {
        Trailer trailer = new Trailer();
        assertThrows(IllegalArgumentException.class, () -> trailer.setLoadCapacity(0), "Očekuje se IllegalArgumentException za nosivost 0.");
    }

    @Test
    public void testSetTNull() {
        Trailer trailer = new Trailer();
        assertThrows(IllegalArgumentException.class, () -> trailer.setT(null), "Očekuje se IllegalArgumentException kada je kamion null.");
    }

    @Test
    public void testSetBrandNull() {
        Trailer trailer = new Trailer();
        assertThrows(IllegalArgumentException.class, () -> trailer.setBrand(null), "Očekuje se IllegalArgumentException kada je marka vozila null.");
    }

    @Test
    public void testSetRegistrationMarkNull() {
        Trailer trailer = new Trailer();
        assertThrows(IllegalArgumentException.class, () -> trailer.setRegistrationMark(null), "Očekuje se IllegalArgumentException kada je registraciona oznaka null.");
    }

    @Test
    public void testSetWeightInvalid() {
        Trailer trailer = new Trailer();
        assertThrows(IllegalArgumentException.class, () -> trailer.setWeight(0), "Očekuje se IllegalArgumentException kada je težina 0.");
    }
}
