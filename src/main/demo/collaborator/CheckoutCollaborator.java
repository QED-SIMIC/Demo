package demo.collaborator;

import java.util.List;

import demo.bo.Address;
import demo.bo.Checkout;
import demo.bo.Checkout.CheckoutMethod;
import demo.bo.CreditCard;
import demo.bo.Customer;
import demo.env.RuntimeError;
import demo.page.CheckoutPage;
import demo.page.SelectCheckoutMethodPage;

public class CheckoutCollaborator {

	   /** 
     * CheckoutCollaborator implements the set of operations that a user
     * performs during the checkout process.
     */
	
	
	
	private SelectCheckoutMethodPage selectCheckoutMethodPage;
	private CheckoutPage checkoutPage;
	
	// -------------------------------------------------------------------------
	public CheckoutCollaborator() {
		this.selectCheckoutMethodPage = new SelectCheckoutMethodPage();
		this.checkoutPage = new CheckoutPage();
	}

	// -------------------------------------------------------------------------
	/**
	 * @param checkout - Checkout method to execute (Guest/Member)
	 */
	public void selectCheckoutMethod(Checkout checkout) {
		CheckoutMethod requestedCheckoutMethod;

		requestedCheckoutMethod = checkout.getCheckoutMethod();
		selectCheckoutMethodPage.selectCheckoutMethod(requestedCheckoutMethod);

		switch (requestedCheckoutMethod) {

		case GUEST:
			break;
		case MEMBER:
			selectCheckoutMethodPage.setMemberEmail(checkout.getEmail());
			selectCheckoutMethodPage.setMemberPassword(checkout.getPassword());
			break;
		default:
			RuntimeError.raiseStatic("Unsupported CheckoutMethod => " + requestedCheckoutMethod.name());
		}
	}

	// -------------------------------------------------------------------------
	/**
	 * Clicks COntinue to Checkut Button
	 */
	public void continueCheckout() {
		selectCheckoutMethodPage.clickContinueCheckout();

	}

	// -------------------------------------------------------------------------
	/**
	 * Populate Customer data
	 * 
	 * @param customer Customer object with values to enter on the page.
	 */
	public void populateCustomer(Customer customer) {

		checkoutPage.setFirstName(customer.getFirstName());
		checkoutPage.setLastName(customer.getLastName());
		checkoutPage.setAddress(customer.getAddress());
		checkoutPage.setCity(customer.getCity());
		checkoutPage.setProvince(customer.getProvince());
		checkoutPage.setPostalCode(customer.getPostalCode());
		checkoutPage.setCountry(customer.getCountry());
		checkoutPage.setPhone(customer.getPhoneNumber());
	}

	// -------------------------------------------------------------------------
	/**
	 * Populates Credit Card information on the page
	 * 
	 * @param creditCard - Credit Card information to enter on the page.
	 */
	public void populateCreditCard(CreditCard creditCard) {

		checkoutPage.selectCreditCardType(creditCard.getCreditCardType());
		checkoutPage.setCardNumber(creditCard.getNumber());
		checkoutPage.setExpirationMonth(creditCard.getExpirationMonth());
		checkoutPage.setExpirationYear(creditCard.getExpirationYear());
		checkoutPage.setCardCvv(creditCard.getCvv());
	}

	// -------------------------------------------------------------------------
	/**
	 * Populates billing information.
	 * 
	 * @param billingAddress - Billing inforamtion info to enter on the page.
	 */
	public void populateBillingAddress(Address billingAddress) {

		if (billingAddress.getBillingAddresSamesAsShipping().booleanValue()) {
			checkoutPage.setBillingAddresSamesAsShipping(billingAddress.getBillingAddresSamesAsShipping());
		} else {
			RuntimeError.raiseStatic("Unsupported Entry of BIlling Address");
		}
		checkoutPage.setConfiramtionEmal(billingAddress.getConfirmationEmail());
	}

	// -------------------------------------------------------------------------
	/**
	 * CLicks Continue to Delivery addres and Payment button.
	 */
	public void continueToDeliveryAddressAndPayment() {
		checkoutPage.continueToDeliveryAddressAndPayment();
	}

	// -------------------------------------------------------------------------
	/**
	 * clicks complete Checkout button.
	 */
	public void completeCheckout() {
		checkoutPage.completeCheckout();
	}

	// -------------------------------------------------------------------------
	/**
	 * Verifies that the page displays the given error message.
	 * 
	 * @param expectedErrorMessage - Expected Error Me3ssage Test 
	 * @return true if the page displays the expected mesage.
	 */
	public boolean verifyErrorMessageDisplayed(String expectedErrorMessage) {
		List<String> errorMessages;
		boolean errorMessageDisplayed = false;

		errorMessages = checkoutPage.getDisplayedErrorMessages();

		for (String errorMessage : errorMessages) {
			if (errorMessage.contains(expectedErrorMessage)) {
				errorMessageDisplayed = true;
				break;
			}
		}
		return errorMessageDisplayed;
	}
}
