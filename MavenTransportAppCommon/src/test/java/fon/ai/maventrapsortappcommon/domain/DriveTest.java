package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Drive;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

public class DriveTest {

    @Test
    public void testSetDNull() {
        Drive drive = new Drive();
        assertThrows(IllegalArgumentException.class, () -> drive.setD(null), "Očekuje se IllegalArgumentException kada je vozač null.");
    }

    @Test
    public void testSetCostListNull() {
        Drive drive = new Drive();
        assertThrows(IllegalArgumentException.class, () -> drive.setCostList(null), "Očekuje se IllegalArgumentException kada je lista troškova null.");
    }

    @Test
    public void testSetDateInvalid() {
        Drive drive = new Drive();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        assertThrows(IllegalArgumentException.class, () -> drive.setDate(futureDate), "Očekuje se IllegalArgumentException kada je datum u budućnosti.");
    }

    @Test
    public void testSetFacturePriceInvalid() {
        Drive drive = new Drive();
        assertThrows(IllegalArgumentException.class, () -> drive.setFacturePrice(0), "Očekuje se IllegalArgumentException kada je iznos fakture 0.");
    }

    @Test
    public void testSetTrNull() {
        Drive drive = new Drive();
        assertThrows(IllegalArgumentException.class, () -> drive.setTr(null), "Očekuje se IllegalArgumentException kada je prikolica null.");
    }

    @Test
    public void testSetTNull() {
        System.out.println("testSetTNull");
        Drive drive = new Drive();
        assertThrows(IllegalArgumentException.class, () -> drive.setT(null), "Očekuje se IllegalArgumentException kada je kamion null.");
    }

    @Test
    public void testSetIdInvalid() {
        System.out.println("testSetIdInvalid");
        Drive drive = new Drive();
        assertThrows(IllegalArgumentException.class, () -> drive.setId(0), "Očekuje se IllegalArgumentException kada je ID 0.");
    }
}
