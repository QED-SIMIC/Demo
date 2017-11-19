package demo.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import demo.bo.CreditCard.CreditCardType;
import demo.env.RunTimeError;
import demo.bo.Phone;
import demo.util.WebElementUtil;

public class CheckoutPage extends BasePage{

	// ------------------------------------------------------------------------
	public CheckoutPage() {
		super();
		this.weu = new WebElementUtil(this.driver);
	}
	
	private WebElementUtil weu;

	// -----------------------------------------------------------------------
	public void setFirstName(String firstName) {
		this.weu.setTextField(firstName, 
				"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_FirstNameContainer_TxtFirstName\"]");
	}

	public void setLastName(String lastName) {
		this.weu.setTextField(lastName, 
				"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_LastNameContainer_txtLastName\"]");
	}

	public void setAddress(String address) {
		this.weu.setTextField(address, 
				"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_AddressLine1Container_TxtAddressLine1\"]");
	}

	public void setCity(String city) {
		this.weu.setTextField(city, 
				"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_CityContainer_TxtCity\"]");
	}

	public void setProvince(String province) {
		this.weu.selectInDropDownListByVisibleText(province, 
				"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_StateContainer_DdlState\"]");
	}

	public void setPostalCode(String postalCode) {
		this.weu.setTextField(postalCode, 
			"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_PostalCodeContainer_TxtZipCode\"]");
	}

	public void setCountry(String country) {
		this.weu.selectInDropDownListByVisibleText(country, 
			"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_CountryContainer_DdlCountry\"]");
	}

	public void setPhone(Phone phone) {
		this.weu.setTextField(phone.getAreaCode(), 
			"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_PhoneContainer_TxtPhone\"]");
		this.weu.setTextField(phone.getLocalExchangeCode(), 
			"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_Phone1Container_TxtPhone1\"]");
		this.weu.setTextField(phone.getNumber(), 
			"//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_Phone2Container_TxtPhone2\"]");
	}

	//------------------------------------------------------------------------------------------------------
	public void continueToDeliveryAddressAndPayment(){
		WebElement continueButonWe;
		
		continueButonWe = 
				this.driver.findElement(By.xpath("//*[@id=\"ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_btnContinueFromShipping\"]/span"));
		continueButonWe.click();
	}

	//------------------------------------------------------------------------------------------------------
	public void selectCreditCardType(CreditCardType creditCardType) {
		WebElement visaCardWe;
		
		switch (creditCardType){
		case VISA:
			visaCardWe =this.driver.findElement(By.xpath
					("//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_pnlSelectPaymentMethod\"]/div/div[1]/div[2]"));
			visaCardWe.click();
			break;
		default:
			RunTimeError.raiseStatic("Unsupported Credit Card Type => " + creditCardType.name());
		}
		
	}

	//------------------------------------------------------------------------------------------------------
	public void setCardNumber(String number) {
		this.weu.setTextField
			(number, 
					"//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_AddCreditCardUC_CreditCardNumberContainer_TxtCardNumber\"]"); 
	}

	//------------------------------------------------------------------------------------------------------
	public void setExpirationMonth(String expirationMonth) {
		this.weu.selectInDropDownListByVisibleText(expirationMonth, 
			"//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_AddCreditCardUC_MonthContainer_DdlMonth\"]");
	}

	//------------------------------------------------------------------------------------------------------
	public void setExpirationYear(String expirationYear) {
		this.weu.selectInDropDownListByVisibleText(expirationYear, 
			"//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_AddCreditCardUC_YearContainer_DdlYear\"]");
	}

	//------------------------------------------------------------------------------------------------------
	public void setCarCvv(String cvv) {
		this.weu.setTextField
		(cvv, 
				"//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_AddCreditCardUC_CIDNumberContainer_TxtCID\"]"); 
	}

	//------------------------------------------------------------------------------------------------------
	public void setConfiramtionEmal(String confirmationEmail) {
		this.weu.setTextField(confirmationEmail, 
		"//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_TxtEmailAddress\"]");
		
	}

	//------------------------------------------------------------------------------------------------------
	public void setBillingAddresSamesAsShipping(Boolean billingAddresSamesAsShipping) {
		WebElement billingAddresSameAsShippingWe;
		billingAddresSameAsShippingWe =
			this.driver.findElement(By.xpath("//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_ChkSameAsShipping\"]"));
		
		if (billingAddresSamesAsShipping.booleanValue()){
			billingAddresSameAsShippingWe.click();
		}else{
			billingAddresSameAsShippingWe.clear();
		}
		
	}
	//------------------------------------------------------------------------------------------------------
	public void completeCheckout() {
		WebElement continueButonWe;
		
		continueButonWe = 
				this.driver.findElement(By.xpath(
					"//*[@id=\"ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_BtnContinueFromPayment\"]/span"));
		continueButonWe.click();
	}

	//------------------------------------------------------------------------------------------------------
	public List<String> getDisplayederrorMessages() {
		
		List displayedErrorMessages = new ArrayList<String> ();
		
		WebElement topWe;
		List<WebElement> messageWes;
		String styleAttributeValue = null;
		
		topWe = this.driver.findElement(By.xpath(
				"//*[@id=\"divCheckoutContent\"]/div/div[1]"));
		
		messageWes = topWe.findElements(By.tagName("div"));
		
		for(WebElement we : messageWes){
			if("display: block;".equals(styleAttributeValue)){
				displayedErrorMessages.add(we.getText());
			}
		}
		return displayedErrorMessages;
	}

}
