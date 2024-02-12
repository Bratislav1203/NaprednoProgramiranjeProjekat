package fon.ai.maventransportappclient.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.VehicleType;

public class ModelDriveSearchTest {
    ModelDriveSearch mds;

    @BeforeEach
    public void setUp() {
        mds = new ModelDriveSearch();
    }

    @AfterEach
    public void tearDown() {
        mds = null;
    }

    @Test
    public void brojacKolona() {
        assertEquals(6, mds.getColumnCount());
    }

    @Test
    public void brojacRedova() {
        assertEquals(0, mds.getRowCount());
    }

    @Test
    public void getValueAtTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> mds.getValueAt(0, 0));
    }

    @Test
    public void getValueAtTest1() {
        Truck truck = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
        Trailer trailer = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447BG", 7500, "P");
        Driver driver = new Driver(123456788, "Vlada", "Vladic");
        Drive d = new Drive(12, new Date(), 500, trailer, truck, driver);
        ArrayList<Drive> drives = new ArrayList<>();
        drives.add(d);
        mds = new ModelDriveSearch(drives);
        assertEquals(drives.get(0).getId(), mds.getValueAt(0, 0));
    }

    @Test
    public void getValueAtTest3() {
        Truck truck = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
        Trailer trailer = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447BG", 7500, "P");
        Driver driver = new Driver(123456788, "Vlada", "Vladic");
        Drive d = new Drive(12, new Date(), 500, trailer, truck, driver);
        ArrayList<Drive> drives = new ArrayList<>();
        drives.add(d);
        mds = new ModelDriveSearch(drives);
        assertEquals(drives.get(0).getFacturePrice(), mds.getValueAt(0, 2));
    }
}
