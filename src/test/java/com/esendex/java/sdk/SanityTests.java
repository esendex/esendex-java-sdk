
package com.esendex.java.sdk;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Class SanityTest.
 */
public class SanityTests extends BaseTest {

	/**
	 * Test account details available.
	 */
	@Test
	public void testAccountDetailsAvailable() {
		assertTrue("To perform the tests BaseTest.USER, BaseTest.PASSWORD and BaseTest.ACCOUNT must all be set",
				USER != null && PASSWORD != null && ACCOUNT!= null);	
	}
}
