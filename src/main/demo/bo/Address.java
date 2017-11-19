package demo.bo;

public class Address {

	public Address() {

	}

	private Boolean billingAddresSamesAsShipping;
	private String confirmationEmail;

	//-------------------------------------------------------------------------
	public Boolean getBillingAddresSamesAsShipping() {
		return billingAddresSamesAsShipping;
	}

	//-------------------------------------------------------------------------
	public void setBillingAddresSamesAsShipping(Boolean billingAddresSamesAsShipping) {
		this.billingAddresSamesAsShipping = billingAddresSamesAsShipping;
	}

	//-------------------------------------------------------------------------
	public String getConfirmationEmail() {
		return confirmationEmail;
	}

	// -------------------------------------------------------------------------
	public void setConfirmationEmail(String confirmationEmail) {
		this.confirmationEmail = confirmationEmail;
	}

}
