package demo.sandboxbby.data;

import static demo.bo.Checkout.CheckoutMethod.GUEST;
import static demo.bo.CreditCard.CreditCardType.VISA;

import demo.bo.Address;
import demo.bo.Checkout;
import demo.bo.CreditCard;
import demo.bo.Customer;
import demo.bo.Phone;
import demo.bo.Product;
import demo.bo.Product.ProductType;

public class BbyTestData {

	/**
	 * BbyTestData class encapsulate test data forBbyTest. In this example, the
	 * class has hard-coded data. Data class files can read the actual test data
	 * from external sources, such as files and database. For the purpose of
	 * this project, it is assumed that all user entered data is correct (i.e.
	 * not null). Data classe is responsible for initial check of data validity.
	 */
	// --------------------------------------------------------------
	public Product getProduct() {
		return new Product(ProductType.LAPTOP, "Lenovo", "ThinkPad X1 Carbon");
	}

	// --------------------------------------------------------------
	public Checkout getCheckoutMethod() {
		Checkout checkout = new Checkout(GUEST);
		return checkout;
	}

	// --------------------------------------------------------------
	public Customer getCustomer() {
		Customer customer = new Customer();

		customer.setFirstName("Daniel");
		customer.setLastName("Sedin");
		customer.setAddress("9050 Forest Grove Dr");
		customer.setCity("Burnaby");
		customer.setProvince("British Columbia");
		customer.setPostalCode("V5A3Z5");
		customer.setCountry("Canada");
		customer.setPhone(new Phone("604-421-2345"));
		return customer;
	}

	// -----------------------------------------------------------------
	public CreditCard getCreditCard() {
		CreditCard creditCard = new CreditCard(VISA);

		creditCard.setNumber("111222333444");
		creditCard.setExpirationMonth("02");
		creditCard.setExpirationYear("2020");
		return creditCard;
	}

	// ---------------------------------------------------------------------
	public Address getbillingAddress() {
		Address billingAddress = new Address();

		billingAddress.setBillingAddressSamesAsShipping(new Boolean(true));
		billingAddress.setConfirmationEmail("daniel.sedin.test@canacks.ca");
		return billingAddress;
	}

}
