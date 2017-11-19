package demo.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementUtil {

	public WebElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	// -----------------------------------------------------------------------
	// Here we assume that the input data will never be, such as firstName will
	// never be null
	// If firstName can be null, the implemented semantics is:
	// * fistName == null => do not update
	// * first name == "" => clear the field.
	// -----------------------------------------------------------------------
	public void setTextField(String text, String textFieldXpath) {
		WebElement textFieldWe;
		if (text != null) {
			textFieldWe = this.driver.findElement(By.xpath(textFieldXpath));
			textFieldWe.clear();
			textFieldWe.sendKeys(text);
		}
	}

	// -----------------------------------------------------------------------
	public void selectInDropDownListByVisibleText(String visibleText, String dropDownWeXpath) {
		WebElement dropDownWe;
		Select droplist = null;
		dropDownWe = this.driver.findElement(By.xpath(dropDownWeXpath));
		droplist = new Select(dropDownWe);
		droplist.selectByVisibleText(visibleText);
	}

}
