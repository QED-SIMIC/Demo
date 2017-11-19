package demo.bo;

public class CreditCard {

	public enum CreditCardType {
		VISA, MASTER_CARD, AMERICAN_EXPRESS, PAY_PAL
	};

	public CreditCard(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
		this.number = null;
		this.expirationMonth = null;
		this.expirationYear = null;
		this.cvv = null;
	}

	private CreditCardType creditCardType;
	private String number;
	private String expirationMonth;
	private String expirationYear;
	private String cvv;

	// ------------------------------------------------------------------------
	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	// ------------------------------------------------------------------------
	public String getNumber() {
		return number;
	}

	// ------------------------------------------------------------------------
	public void setNumber(String number) {
		this.number = number;
	}

	// ------------------------------------------------------------------------
	public String getExpirationMonth() {
		return expirationMonth;
	}

	// ------------------------------------------------------------------------
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	// ------------------------------------------------------------------------
	public String getExpirationYear() {
		return expirationYear;
	}

	// ------------------------------------------------------------------------
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}

	// ------------------------------------------------------------------------
	public String getCvv() {
		return cvv;
	}

	// ------------------------------------------------------------------------
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
