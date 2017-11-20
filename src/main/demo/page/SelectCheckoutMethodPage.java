package demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.bo.Checkout.CheckoutMethod;
import demo.env.RuntimeError;

public class SelectCheckoutMethodPage extends BasePage {

	/**
	 * Implements user actions on the Select Checkout Method Page - Select Guest
	 * checkout - Enters confirmation email
	 */

	private static final String GUEST_CHECKOUT_RADIONUTTON_XPATH = "//*[@id=\"ctl00_CP_UcCheckoutSignInUC_radioButtonNew\"]";
	private static final String MEMBER_CHECKOUT_RADIONUTTON_XPATH = "//*[@id=\"ctl00_CP_UcCheckoutSignInUC_radioButtonSignIn\"]";
	private static final String MEMBER_EMAIL_XPATH = "//*[@id=\"ctl00_CP_UcCheckoutSignInUC_UserNameContainer_txtUserName\"]";
	private static final String MEMBER_PASSWORD_XPATH = "//*[@id=\"ctl00_CP_UcCheckoutSignInUC_PasswordContainer_txtPassword\"]";
	private static final String CONTINUE_CHECKOUT_BUTTON_XPATH = "//*[@id=\"ctl00_CP_UcCheckoutSignInUC_btnSubmitOrder\"]/span";

	// ------------------------------------------------------------------------
	public SelectCheckoutMethodPage() {
		super();
	}

	// ------------------------------------------------------------------------
	public void selectCheckoutMethod(CheckoutMethod checkoutMethod) {
		WebElement guestCheckoutRadioButtonWe, memberCheckoutRadioButtonWe;

		switch (checkoutMethod) {
		case GUEST:
			guestCheckoutRadioButtonWe = this.driver.findElement(By.xpath(GUEST_CHECKOUT_RADIONUTTON_XPATH));
			guestCheckoutRadioButtonWe.click();
			break;
		case MEMBER:
			memberCheckoutRadioButtonWe = this.driver.findElement(By.xpath(MEMBER_CHECKOUT_RADIONUTTON_XPATH));
			memberCheckoutRadioButtonWe.click();
			break;
		default:
			RuntimeError.raiseStatic("Unsupported CheckoutMethod => " + checkoutMethod.name());
		}

	}

	// ------------------------------------------------------------------------
	public void setMemberEmail(String email) {
		WebElement memberEmailWe;
		memberEmailWe = this.driver.findElement(By.xpath(MEMBER_EMAIL_XPATH));
		memberEmailWe.clear();
		memberEmailWe.sendKeys(email);
	}

	// ------------------------------------------------------------------------
	public void setMemberPassword(String password) {
		WebElement memberPasswordWe;
		memberPasswordWe = this.driver.findElement(By.xpath(MEMBER_PASSWORD_XPATH));
		memberPasswordWe.clear();
		memberPasswordWe.sendKeys(password);
	}

	// ------------------------------------------------------------------------
	public void clickContinueCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement continueCheckoutButtonWe;
		continueCheckoutButtonWe = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(CONTINUE_CHECKOUT_BUTTON_XPATH)));
		continueCheckoutButtonWe.click();
	}

}
