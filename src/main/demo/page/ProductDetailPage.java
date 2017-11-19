package demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {

	// ------------------------------------------------------------------------
	public ProductDetailPage() {
		super();
	}

	// ------------------------------------------------------------------------
	public void addToCart() {
		WebElement addToCartButtonWe;
		addToCartButtonWe = this.driver.findElement(By.xpath("//*[@id=\"btn-cart\"]"));
		addToCartButtonWe.click();
	}

	// ------------------------------------------------------------------------
	public void proceedToCheckout() {
		WebElement proceedToCheckoutButtonWe;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		proceedToCheckoutButtonWe = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"express-checkout\"]")));
		proceedToCheckoutButtonWe.click();
	}

}
