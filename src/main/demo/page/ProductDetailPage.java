package demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BasePage {

	
	// ------------------------------------------------------------------------
	public ProductDetailPage() {
		super();
	}
	
	// ------------------------------------------------------------------------
	public void addToCart(){
		WebElement addToCartButtonWe;
		addToCartButtonWe = this.driver.findElement(By.xpath("//*[@id=\"btn-cart\"]"));
		addToCartButtonWe.click();
	}

	// ------------------------------------------------------------------------
	public void proceedToCheckout(){
		WebElement addToCartButtonWe;
		addToCartButtonWe = this.driver.findElement(By.xpath("//*[@id=\"express-checkout\"]"));
		addToCartButtonWe.click();
	}

}
