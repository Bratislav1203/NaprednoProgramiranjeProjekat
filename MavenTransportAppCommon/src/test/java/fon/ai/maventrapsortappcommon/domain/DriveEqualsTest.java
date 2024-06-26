package fon.ai.maventrapsortappcommon.domain;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.CostList;
import fon.ai.maventransportappcommon.domain.CostType;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.VehicleType;

class DriveEqualsTest {

	Drive drive;
	
	@BeforeEach
	public void setUp() {
		drive = new Drive();
	}
	
    @Test
    void testEqualsSameObject() {
        assertTrue(drive.equals(drive), "Objekat bi trebalo da bude jednak samom sebi.");
    }

    @Test
    void testEqualsWithNull() {
        assertFalse(drive.equals(null), "Objekat ne bi trebalo da bude jednak null.");
    }

    @Test
    void testEqualsDifferentClass() {
        Object obj = new Object();
        assertFalse(drive.equals(obj), "Objekti različitih klasa ne bi trebalo da budu jednaki.");
    }

    @Test
    void testEqualsDifferentValues() {
    	Truck truck = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
		Trailer trailer = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447RA", 7500, "P");
		Driver driver = new Driver(123456788, "Vlada", "Vladic");
		ArrayList<CostItem> costs = new ArrayList<>();
		CostItem c1 = new CostItem(CostType.driverSallary, 300);
		CostItem c2 = new CostItem(CostType.fuel, 300);
		CostItem c3 = new CostItem(CostType.toll, 300);
		CostItem c4 = new CostItem(CostType.other, 300);
		costs.add(c1);
		costs.add(c2);
		costs.add(c3);
		costs.add(c4);
		CostList cl = new CostList(1050);
		c1.setCostList(cl);
		c2.setCostList(cl);
		c3.setCostList(cl);
		c4.setCostList(cl);
		cl.setCosts(costs);

    	Truck truck1 = new Truck("AUTOMATIC", "man", 1990, "RA010CD", 9000, "K");
		Trailer trailer1 = new Trailer(VehicleType.HLADNJACA, 22001, "SMITZ1", 1990, "AA440RA", 8500, "P");
		Driver driver1 = new Driver(123456789, "Proba", "Probic");
		ArrayList<CostItem> costs1 = new ArrayList<>();
		CostItem c11 = new CostItem(CostType.driverSallary, 300);
		CostItem c12 = new CostItem(CostType.fuel, 300);
		CostItem c13 = new CostItem(CostType.toll, 300);
		CostItem c14 = new CostItem(CostType.other, 300);
		costs.add(c11);
		costs.add(c12);
		costs.add(c13);
		costs.add(c14);
		CostList cl1 = new CostList(1050);
		c1.setCostList(cl1);
		c2.setCostList(cl1);
		c3.setCostList(cl1);
		c4.setCostList(cl1);
		cl.setCosts(costs1);
        Drive drive1 = new Drive(1050, new Date(), 500, trailer, truck, driver, cl);
        Drive drive2 = new Drive(1051, new Date(), 501, trailer1, truck1, driver1, cl1);
        assertFalse(drive1.equals(drive2), "Objekti sa različitim vrednostima ne bi trebalo da budu jednaki.");
    }

    @Test
    void testEqualsSameValues() {
    	Truck truck = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
		Trailer trailer = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447RA", 7500, "P");
		Driver driver = new Driver(123456788, "Vlada", "Vladic");
		ArrayList<CostItem> costs = new ArrayList<>();
		CostItem c1 = new CostItem(CostType.driverSallary, 300);
		CostItem c2 = new CostItem(CostType.fuel, 300);
		CostItem c3 = new CostItem(CostType.toll, 300);
		CostItem c4 = new CostItem(CostType.other, 300);
		costs.add(c1);
		costs.add(c2);
		costs.add(c3);
		costs.add(c4);
		CostList cl = new CostList(1050);
		c1.setCostList(cl);
		c2.setCostList(cl);
		c3.setCostList(cl);
		c4.setCostList(cl);
		cl.setCosts(costs);
		
    	Truck truck1 = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
		Trailer trailer1 = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447RA", 7500, "P");
		Driver driver1 = new Driver(123456788, "Vlada", "Vladic");
		ArrayList<CostItem> costs1 = new ArrayList<>();
		CostItem c11 = new CostItem(CostType.driverSallary, 300);
		CostItem c12 = new CostItem(CostType.fuel, 300);
		CostItem c13 = new CostItem(CostType.toll, 300);
		CostItem c14 = new CostItem(CostType.other, 300);
		costs.add(c11);
		costs.add(c12);
		costs.add(c13);
		costs.add(c14);
		CostList cl1 = new CostList(1050);
		c1.setCostList(cl1);
		c2.setCostList(cl1);
		c3.setCostList(cl1);
		c4.setCostList(cl1);
		cl.setCosts(costs1);
		
    	
        Drive drive1 = new Drive(1050, new Date(), 500, trailer, truck, driver, cl);
        Drive drive2 = new Drive(1050, new Date(), 500, trailer1, truck1, driver1, cl1);
        assertTrue(drive1.equals(drive2), "Objekti sa istim vrednostima bi trebalo da budu jednaki.");
    }
}
