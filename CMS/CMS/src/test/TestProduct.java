package test;

import junit.framework.TestCase;

import com.cms.domain.Product;
/**
 * Domain object test class to test getters and setters
 * @author Kunal
 *
 */
public class TestProduct extends TestCase {
	private final static int PRODUCT_ID = 1;
	private final static double PRICE  = 100.00;
	private final static String STOCK_NUMBER= "ABC123";
	private final static String AVAILABILITY = "Yes";
	private final static String DESCRIPTION= "Product One Description";
	
public void testConstructorSettersGetters() throws Exception {
		
		Product theProduct= new Product();
		theProduct.setPrice(PRICE);
		theProduct.setStockNumber(STOCK_NUMBER);
		theProduct.setAvailability(AVAILABILITY);
		theProduct.setDescription(DESCRIPTION);

		assertNotNull("Should be an object", theProduct);
		assertEquals("Id should not be 0", 1, PRODUCT_ID);
		assertEquals("Prices should match", this.STOCK_NUMBER, theProduct.getStockNumber());
		assertEquals("Stock Numbers should match", this.PRICE, theProduct.getPrice());
		assertEquals("Availability should match", this.AVAILABILITY,theProduct.getAvailability());
		assertEquals("Description should match", this.DESCRIPTION, theProduct.getDescription());
	}

}
