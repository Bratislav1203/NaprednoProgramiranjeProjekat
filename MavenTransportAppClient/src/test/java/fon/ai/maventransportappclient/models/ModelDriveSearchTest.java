package fon.ai.maventransportappclient.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.VehicleType;

public class ModelDriveSearchTest {
	ModelDriveSearch mds;

	@Before
	public void setUp() throws Exception {
		mds = new ModelDriveSearch();
	}

	@After
	public void tearDown() throws Exception {
		mds = null;
	}

	@Test
	public void brojacKolona() {
		assertEquals(6, mds.getColumnCount());
	}

	@Test(expected = java.lang.AssertionError.class)
	public void brojacKolona1() {
		assertEquals(1, mds.getColumnCount());
	}

	@Test
	public void brojacRedova() {
		assertEquals(0, mds.getRowCount());
	}

	@Test(expected = java.lang.AssertionError.class)
	public void brojacRedova1() {
		assertEquals(5, mds.getRowCount());
	}

	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void getValueAtTest() {
		assertEquals(0, mds.getValueAt(0, 0));
	}

	@Test(expected = java.lang.AssertionError.class)
	public void getValueAtTest1() {
		Truck truck = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
		Trailer trailer = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447BG", 7500, "P");
		Driver driver = new Driver(12345678, "Vlada", "Vladic");
		Drive d = new Drive(12, new Date(), 500, trailer, truck, driver);
		ArrayList<Drive> drives = new ArrayList<>();
		drives.add(d);
		mds = new ModelDriveSearch(drives);
		assertEquals(0, mds.getValueAt(0, 0));
	}

	@Test
	public void getValueAtTest2() {
		Truck truck = new Truck("AUTOMATIC", "daf", 1995, "RA013CD", 8800, "K");
		Trailer trailer = new Trailer(VehicleType.CIRADA, 22000, "SMITZ", 1995, "AA447BG", 7500, "P");
		Driver driver = new Driver(12345678, "Vlada", "Vladic");
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
		Driver driver = new Driver(12345678, "Vlada", "Vladic");
		Drive d = new Drive(12, new Date(), 500, trailer, truck, driver);
		ArrayList<Drive> drives = new ArrayList<>();
		drives.add(d);
		mds = new ModelDriveSearch(drives);
		assertEquals(drives.get(0).getFacturePrice(), mds.getValueAt(0, 2));
	}

}
