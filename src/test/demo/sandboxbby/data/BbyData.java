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

public class BbyData {

	// --------------------------------------------------------------
	public Product getProduct_A() {
		return new Product(ProductType.LAPTOP, "Lenovo", "ThinkPad X1 Carbon");
	}

	// --------------------------------------------------------------
	public Checkout getCheckoutMethod_A() {
		Checkout checkout = new Checkout(GUEST);
		return checkout;
	}

	// --------------------------------------------------------------
	public Customer getCustomer_A() {
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
	public CreditCard getCreaditCard_A() {
		CreditCard creditCard = new CreditCard(VISA);

		creditCard.setNumber("111222333444");
		creditCard.setExpirationMonth("02");
		creditCard.setExpirationYear("2020");
		return creditCard;
	}

	// ---------------------------------------------------------------------
	public Address getbillingAddress_A() {
		Address billingAddress = new Address();

		billingAddress.setBillingAddresSamesAsShipping(new Boolean(true));
		billingAddress.setConfirmationEmail("daniel.sedin@cunacks.ca");
		return billingAddress;
	}

}
