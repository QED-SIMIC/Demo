package demo.bo;

public class Address {

	/**
	 * Address object in its initial implementation includes only the
	 * information that the billing address is the same as shipping. Further
	 * work on the Address class is required.
	 */
	public Address() {

	}

	private Boolean billingAddressSameAsShipping;
	private String confirmationEmail;

	// -------------------------------------------------------------------------
	public Boolean getBillingAddresSamesAsShipping() {
		return billingAddressSameAsShipping;
	}

	// -------------------------------------------------------------------------
	public void setBillingAddressSamesAsShipping(Boolean billingAddressSamesAsShipping) {
		this.billingAddressSameAsShipping = billingAddressSamesAsShipping;
	}

	// -------------------------------------------------------------------------
	public String getConfirmationEmail() {
		return confirmationEmail;
	}

	// -------------------------------------------------------------------------
	public void setConfirmationEmail(String confirmationEmail) {
		this.confirmationEmail = confirmationEmail;
	}

}
