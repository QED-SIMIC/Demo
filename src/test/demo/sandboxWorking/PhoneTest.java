package demo.sandboxWorking;

import org.junit.Assert;
import org.junit.Test;

import demo.bo.Phone;

public class PhoneTest {

	// --------------------------------------------------------------------
	@Test
	// --------------------------------------------------------------------
	public void phoneDecomposition() {
		
		Phone phone;
		
		phone = new Phone ("604-421-2345");
		
		Assert.assertTrue("604".equals(phone.getAreaCode()));
		Assert.assertTrue("421".equals(phone.getLocalExchangeCode()));
		Assert.assertTrue("2345".equals(phone.getNumber()));
		
	}
}
