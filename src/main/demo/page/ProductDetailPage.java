package demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {

	/**
	 * Implements user action on the Product Detail Page: Add to cart Proceed to
	 * chekout
	 */
	private final static String ADD_TO_CART_BUTTON_XPATH = "//*[@id=\"btn-cart\"]";
	private final static String EXPRESS_CHECKOUT_BUTTON_XPATH = "//*[@id=\"express-checkout\"]";

	// ------------------------------------------------------------------------
	public ProductDetailPage() {
		super();
	}

	// ------------------------------------------------------------------------
	public void addToCart() {
		WebElement addToCartButtonWe;
		addToCartButtonWe = this.driver.findElement(By.xpath(ADD_TO_CART_BUTTON_XPATH));
		addToCartButtonWe.click();
	}

	// ------------------------------------------------------------------------
	public void proceedToCheckout() {
		WebElement proceedToCheckoutButtonWe;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		proceedToCheckoutButtonWe = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(EXPRESS_CHECKOUT_BUTTON_XPATH)));
		proceedToCheckoutButtonWe.click();
	}

}
