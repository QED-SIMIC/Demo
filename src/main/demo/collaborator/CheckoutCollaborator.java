package demo.collaborator;

import static demo.bo.Checkout.CheckoutMethod.*;

import java.util.List;

import demo.bo.Address;
import demo.bo.Checkout;
import demo.bo.Checkout.CheckoutMethod;
import demo.bo.CreditCard;
import demo.bo.Customer;
import demo.env.RunTimeError;
import demo.page.CheckoutPage;
import demo.page.SelectCheckoutMethodPage;
import demo.util.WebDriverUtil;

public class CheckoutCollaborator {

	// -------------------------------------------------------------------------
	public CheckoutCollaborator() {

	}

	// -------------------------------------------------------------------------
	public void selectCheckoutMethod(Checkout checkout) {
		SelectCheckoutMethodPage selectCheckoutMethodPage = new SelectCheckoutMethodPage();
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
			RunTimeError.raiseStatic("Unsupported CheckoutMethod => " + requestedCheckoutMethod.name());
		}
	}

	// -------------------------------------------------------------------------
	public void continueCheckout() {
		WebDriverUtil wdu = new WebDriverUtil();
		SelectCheckoutMethodPage selectCheckoutMethodPage = new SelectCheckoutMethodPage();
		selectCheckoutMethodPage.clickContinueCheckout();
		wdu.waitForUrlChange();

	}

	// -------------------------------------------------------------------------
	public void populateCustomer(Customer customer) {
		CheckoutPage checkoutPage = new CheckoutPage();

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
	public void populateCreditCard(CreditCard creditCard) {
		CheckoutPage checkoutPage = new CheckoutPage();

		checkoutPage.selectCreditCardType(creditCard.getCreditCardType());
		checkoutPage.setCardNumber(creditCard.getNumber());
		checkoutPage.setExpirationMonth(creditCard.getExpirationMonth());
		checkoutPage.setExpirationYear(creditCard.getExpirationYear());
		checkoutPage.setCarCvv(creditCard.getCvv());
	}

	// -------------------------------------------------------------------------
	public void populateBillingAddress(Address billingAddress) {
		CheckoutPage checkoutPage = new CheckoutPage();

		if (billingAddress.getBillingAddresSamesAsShipping().booleanValue()) {
			checkoutPage.setBillingAddresSamesAsShipping(billingAddress.getBillingAddresSamesAsShipping());
		} else {
			RunTimeError.raiseStatic("Unsupported Entry of BIlling Address");
		}
		checkoutPage.setConfiramtionEmal(billingAddress.getConfirmationEmail());
	}

	// -------------------------------------------------------------------------
	public void continueToDeliveryAddressAndPayment() {
		CheckoutPage checkoutPage = new CheckoutPage();
		WebDriverUtil wdu = new WebDriverUtil();
		
		checkoutPage.continueToDeliveryAddressAndPayment();
		wdu.waitForUrlChange();
		
	}

	// -------------------------------------------------------------------------
	public void completeCheckout() {
		CheckoutPage checkoutPage = new CheckoutPage();
		WebDriverUtil wdu = new WebDriverUtil();
		
		checkoutPage.completeCheckout();
		wdu.waitForUrlChange();

		
	}

	// -------------------------------------------------------------------------
	public boolean verifyErrorMessageDisplayed(String expectedErrorMessage) {
		CheckoutPage checkoutPage = new CheckoutPage();
		List<String> errorMessages;
		boolean errorMessageDisplayed = false;
		
		errorMessages = checkoutPage.getDisplayederrorMessages();

		for(String errorMessage : errorMessages){
			if(errorMessage.contains(expectedErrorMessage)){
				errorMessageDisplayed = true;
				break;
			}
		}
		return errorMessageDisplayed;
	}
}
