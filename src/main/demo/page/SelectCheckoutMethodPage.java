package demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import demo.bo.Checkout.CheckoutMethod;
import demo.env.RunTimeError;

public class SelectCheckoutMethodPage extends BasePage {

	// ------------------------------------------------------------------------
	public SelectCheckoutMethodPage() {
		super();
	}
	
	// ------------------------------------------------------------------------
	public void  selectCheckoutMethod(CheckoutMethod checkoutMethod){
		WebElement guestCheckoutRadioButtonWe, memberCheckoutRadioButtonWe;

		switch (checkoutMethod) {
		case GUEST:
			guestCheckoutRadioButtonWe =  
				this.driver.findElement(By.xpath("//*[@id=\"ctl00_CP_UcCheckoutSignInUC_radioButtonNew\"]"));
			guestCheckoutRadioButtonWe.click();
			break;
		case MEMBER:
			memberCheckoutRadioButtonWe = 
				this.driver.findElement(By.xpath("//*[@id=\"ctl00_CP_UcCheckoutSignInUC_radioButtonSignIn\"]"));
			memberCheckoutRadioButtonWe.click();
			break;
		default:
			RunTimeError.raiseStatic("Unsupported CheckoutMethod => " + checkoutMethod.name());
		}

		
	}

	// ------------------------------------------------------------------------
	public void setMemberEmail(String email) {
		WebElement memberEmailWe;
		memberEmailWe = 
				this.driver.findElement(By.
						xpath("//*[@id=\"ctl00_CP_UcCheckoutSignInUC_UserNameContainer_txtUserName\"]"));
		memberEmailWe.clear();
		memberEmailWe.sendKeys(email);
	}

	// ------------------------------------------------------------------------
	public void setMemberPassword(String password) {
		WebElement memberPasswordWe;
		memberPasswordWe = 
				this.driver.findElement(By.
						xpath("//*[@id=\"ctl00_CP_UcCheckoutSignInUC_PasswordContainer_txtPassword\"]"));
		memberPasswordWe.clear();
		memberPasswordWe.sendKeys(password);
	}
	
	// ------------------------------------------------------------------------
	public void clickContinueCheckout(){
		
	}
	
}
