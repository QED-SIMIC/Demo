package demo.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.bo.CreditCard.CreditCardType;
import demo.bo.Phone;
import demo.env.RuntimeError;
import demo.util.WebDriverUtil;
import demo.util.WebElementUtil;

public class CheckoutPage extends BasePage {

	/**
	 * Implements user actions on the Checkout Page.
	 */
	private static final String FIRST_NAME_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_FirstNameContainer_TxtFirstName\"]";
	private static final String LAST_NAME_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_LastNameContainer_txtLastName\"]";
	private static final String ADDRESS_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_AddressLine1Container_TxtAddressLine1\"]";
	private static final String CITY_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_CityContainer_TxtCity\"]";
	private static final String PROVINCE_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_StateContainer_DdlState\"]";
	private static final String POSTAL_CODE_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_PostalCodeContainer_TxtZipCode\"]";
	private static final String COUNTRY_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_CountryContainer_DdlCountry\"]";
	private static final String AREA_CODE_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_PhoneContainer_TxtPhone\"]";
	private static final String LOCAL_EXCHANGE_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_Phone1Container_TxtPhone1\"]";
	private static final String LOCAL_EXCHANGE_NUMBER_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_Phone2Container_TxtPhone2\"]";
	private static final String CONTINUE_TO_DELIVERY_ADDRESS_AND_PAYMENT_NUTTON_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_btnContinueFromShipping\"]/span";
	private static final String SELECT_CREDIT_CARD_BUTTON_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_lnkCreditCard\"]";
	private static final String CREDIT_CARD_NUMBER_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_AddCreditCardUC_CreditCardNumberContainer_TxtCardNumber\"]";
	private static final String EXPIRATION_MONTH_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_AddCreditCardUC_MonthContainer_DdlMonth\"]";
	private static final String EXPIRATION_YEAR_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_AddCreditCardUC_YearContainer_DdlYear\"]";
	private static final String CVV_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_AddCreditCardUC_CIDNumberContainer_TxtCID\"]";
	private static final String CONFIRMATION_EMAIL_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_TxtEmailAddress\"]";
	private static final String BILLING_NUMBER_SAME_CHECKBOX_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_ChkSameAsShipping\"]";
	private static final String COMPLETE_CHECKOUT_BUTTON_XPATH = "//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_BtnContinueFromPayment\"]/span";
	private static final String DISPLAYED_ERROR_MESSAGEs_LIST_XPATH = "//*[@id=\"ctl00_CP_ErrorSummaryUC12_ValidationSummary1\"]/ul";

	// ------------------------------------------------------------------------
	public CheckoutPage() {
		super();
		this.weu = new WebElementUtil(this.driver);
	}

	private WebElementUtil weu;

	// ------------------------------------------------------------------------
	public void setFirstName(String firstName) {
		this.weu.setTextField(firstName, FIRST_NAME_XPATH);
	}

	public void setLastName(String lastName) {
		this.weu.setTextField(lastName, LAST_NAME_XPATH);
	}

	public void setAddress(String address) {
		this.weu.setTextField(address, ADDRESS_XPATH);
	}

	public void setCity(String city) {
		this.weu.setTextField(city, CITY_XPATH);
	}

	public void setProvince(String province) {
		this.weu.selectInDropDownListByVisibleText(province, PROVINCE_XPATH);
	}

	public void setPostalCode(String postalCode) {
		this.weu.setTextField(postalCode, POSTAL_CODE_XPATH);
	}

	public void setCountry(String country) {
		this.weu.selectInDropDownListByVisibleText(country, COUNTRY_XPATH);
	}

	public void setPhone(Phone phone) {
		this.weu.setTextField(phone.getAreaCode(), AREA_CODE_XPATH);
		this.weu.setTextField(phone.getLocalExchangeCode(), LOCAL_EXCHANGE_XPATH);
		this.weu.setTextField(phone.getLocalExchangeNumber(), LOCAL_EXCHANGE_NUMBER_XPATH);
	}

	// ------------------------------------------------------------------------
	public void continueToDeliveryAddressAndPayment() {
		WebElement continueButonWe;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		continueButonWe = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(CONTINUE_TO_DELIVERY_ADDRESS_AND_PAYMENT_NUTTON_XPATH)));
		continueButonWe.click();
	}

	// ------------------------------------------------------------------------
	public void selectCreditCardType(CreditCardType creditCardType) {
		WebElement selectCreditCardWe;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		switch (creditCardType) {
		case VISA:
			selectCreditCardWe = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(SELECT_CREDIT_CARD_BUTTON_XPATH)));
			selectCreditCardWe.click();
			break;
		default:
			RuntimeError.raiseStatic("Unsupported Credit Card Type => " + creditCardType.name());
		}
	}

	// ------------------------------------------------------------------------
	public void setCardNumber(String number) {
		this.weu.setTextField(number, CREDIT_CARD_NUMBER_XPATH);
	}

	// ------------------------------------------------------------------------
	public void setExpirationMonth(String expirationMonth) {
		this.weu.selectInDropDownListByVisibleText(expirationMonth, EXPIRATION_MONTH_XPATH);
	}

	// ------------------------------------------------------------------------
	public void setExpirationYear(String expirationYear) {
		this.weu.selectInDropDownListByVisibleText(expirationYear, EXPIRATION_YEAR_XPATH);
	}

	// ------------------------------------------------------------------------
	public void setCardCvv(String cvv) {
		this.weu.setTextField(cvv, CVV_XPATH);
	}

	// ------------------------------------------------------------------------
	public void setConfiramtionEmal(String confirmationEmail) {
		this.weu.setTextField(confirmationEmail, CONFIRMATION_EMAIL_XPATH);

	}

	// ------------------------------------------------------------------------
	public void setBillingAddresSamesAsShipping(Boolean billingAddresSamesAsShipping) {
		WebElement billingAddresSameAsShippingWe;
		billingAddresSameAsShippingWe = this.driver.findElement(By.xpath(BILLING_NUMBER_SAME_CHECKBOX_XPATH));

		if (billingAddresSamesAsShipping.booleanValue()) {
			billingAddresSameAsShippingWe.click();
		} else {
			billingAddresSameAsShippingWe.clear();
		}

	}

	// ------------------------------------------------------------------------
	public void completeCheckout() {
		WebElement continueButonWe;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		continueButonWe = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COMPLETE_CHECKOUT_BUTTON_XPATH)));
		continueButonWe.click();
	}

	// ------------------------------------------------------------------------
	public List<String> getDisplayedErrorMessages() {

		List<String> displayedErrorMessages = new ArrayList<String>();

		WebElement topWe;
		List<WebElement> messageWes;

		topWe = this.driver.findElement(By.xpath(DISPLAYED_ERROR_MESSAGEs_LIST_XPATH));

		messageWes = topWe.findElements(By.xpath("./li"));

		for (WebElement we : messageWes) {
			displayedErrorMessages.add(we.getText());
		}
		return displayedErrorMessages;
	}

}
