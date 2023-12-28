package fon.ai.maventransportappclient.models;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModelCostPrikazTest {
	ModelCostPrikaz mcp;

	@Before
	public void setUp() throws Exception {
		mcp = new ModelCostPrikaz();
	}

	@After
	public void tearDown() throws Exception {
		mcp = null;
	}

	@Test
	public void brojacKolona() {
		assertEquals(2, mcp.getColumnCount());
	}

	@Test(expected = java.lang.AssertionError.class)
	public void brojacKolona1() {
		assertEquals(1, mcp.getColumnCount());
	}

	@Test
	public void brojacRedova() {
		assertEquals(0, mcp.getRowCount());
	}

	@Test(expected = java.lang.AssertionError.class)
	public void brojacRedova1() {
		assertEquals(5, mcp.getRowCount());
	}

	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void getValueAtTest() {
		assertEquals(0, mcp.getValueAt(0, 0));
	}

}