package fon.ai.maventrapsortappcommon.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.CostList;
import fon.ai.maventransportappcommon.domain.CostType;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.VehicleType;

public class DriveToStringTest {

	
	@Test
    void testToString() {
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
		CostList cl = new CostList(1);
		c1.setCostList(cl);
		c2.setCostList(cl);
		c3.setCostList(cl);
		c4.setCostList(cl);
		cl.setCosts(costs);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
		String formattedDate = dateFormat.format(new Date());

		Drive drive = new Drive(1, new Date(), 500, trailer, truck, driver, cl);
		String expected = "Drive [id=1, costList=1, date=" + formattedDate + ", facturePrice=500.0, tr=SMITZ - 1995, t=daf - 1995, d=Vlada Vladic]";
		String dobijeni = drive.toString();
		assertEquals(expected, dobijeni, "toString metoda ne vraća očekivani rezultat.");
    }
	
}
