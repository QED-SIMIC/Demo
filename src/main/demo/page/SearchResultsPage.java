package demo.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import demo.bo.Product;

public class SearchResultsPage extends BasePage {

	// ------------------------------------------------------------------------
	public SearchResultsPage() {
		super();
	}

	// ------------------------------------------------------------------------
	public void navigateToProductDetail(Product product) {
		List<WebElement> divWes;
		List<WebElement> liWes;
		WebElement productFoundWe = null;

		divWes = this.driver
				.findElements(By.xpath("//*[@id=\"ctl00_CC_ProductSearchResultListing_SearchProductListing\"]/ul/div"));
		for (WebElement divWe : divWes) {
			liWes = divWe.findElements(By.xpath("./li"));
			for (WebElement liWe : liWes) {
				productFoundWe = this.isProductMatching(product, liWe);
				if (productFoundWe != null) {
					break;
				}
			}
			if (productFoundWe != null) {
				break;
			}
		}
		productFoundWe.click();
	}

	// ------------------------------------------------------------------------
	private WebElement isProductMatching(Product product, WebElement liWe) {
		WebElement productDescriptionWe = null;
		WebElement productFoundWe = null;
		String productDescription = null;
		boolean productMatch = true;

		productDescriptionWe = liWe.findElement(By.xpath("./div/div[2]/h4/a"));
		productDescription = productDescriptionWe.getText();
		productMatch = productDescription.contains(product.getManufacturer());
		productMatch = productMatch && productDescription.contains(product.getModel());
		if (productMatch) {
			productFoundWe = productDescriptionWe;
		}
		return productFoundWe;
	}

}
