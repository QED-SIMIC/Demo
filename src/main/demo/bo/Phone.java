package demo.bo;

public class Phone {

	/**
	 * Phone initial abstraction. Phone splits the phone number in the format
	 * <Area Code>-<Local Exchange Number>-<Local Branch Number> into the
	 * composite parts.
	 */

	private String phoneNumber;
	private String areaCode;
	private String localExchangeCode;
	private String localExchangeNumber;

	public Phone(String phoneAreaDashExchageDashNumber) {
		this.phoneNumber = phoneAreaDashExchageDashNumber;
		this.areaCode = extractAreaCode();
		this.localExchangeCode = this.extractLocalExchangeCode();
		this.localExchangeNumber = this.extractLocalExchangeNumber();
	}

	// ------------------------------------------------------------------------
	private String extractAreaCode() {
		String areaCode = null;
		int firstDashIx = 0;

		firstDashIx = this.phoneNumber.indexOf("-");

		areaCode = this.phoneNumber.substring(0, firstDashIx);

		return areaCode;
	}

	// ------------------------------------------------------------------------
	private String extractLocalExchangeCode() {
		String localExchangeCode = null;
		int firstDashIx = -1, secondDashIx = -1;

		firstDashIx = this.phoneNumber.indexOf('-');
		secondDashIx = this.phoneNumber.indexOf('-', firstDashIx + 1);

		localExchangeCode = this.phoneNumber.substring(firstDashIx + 1, secondDashIx);

		return localExchangeCode;
	}

	// ------------------------------------------------------------------------
	private String extractLocalExchangeNumber() {
		String number = null;
		int ixFirst = 0, ixLast = 0;

		ixFirst = this.phoneNumber.indexOf('-', 0);
		ixFirst = this.phoneNumber.indexOf('-', (ixFirst + 1)) + 1;
		ixLast = this.phoneNumber.length();
		number = this.phoneNumber.substring(ixFirst, ixLast);

		return number;
	}

	// ------------------------------------------------------------------------
	public String getNumber() {
		return this.phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getLocalExchangeCode() {
		return localExchangeCode;
	}

	public void setLocalExchangeCode(String localExchangeCode) {
		this.localExchangeCode = localExchangeCode;
	}

	public String getLocalExchangeNumber() {
		return localExchangeNumber;
	}

	public void setLocalExchangeNumber(String localExchangeNumber) {
		this.localExchangeNumber = localExchangeNumber;
	}

}
