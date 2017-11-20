package demo.collaborator;

import demo.bo.Product;
import demo.page.AnyPage;
import demo.page.ProductDetailPage;
import demo.page.SearchResultsPage;
import demo.util.WebDriverUtil;

public class SearchCollaborator {

	/**
	 * SearchCollaborator implements the set of operations that a user performs
	 * during the search.
	 */

	private AnyPage anyPage;
	private SearchResultsPage searchResultsPage;
	private ProductDetailPage productDetailPage;
	private WebDriverUtil wdu;

	// -------------------------------------------------------------------------
	public SearchCollaborator() {
		this.anyPage = new AnyPage();
		searchResultsPage = new SearchResultsPage();
		productDetailPage = new ProductDetailPage();
		this.wdu = new WebDriverUtil();
	}

	// -------------------------------------------------------------------------
	/*
	 * Executes global search for the given product.
	 */
	/**
	 * @param product - Product for which this method executes global searc.
	 */
	public void globalSearchProduct(Product product) {
		StringBuffer sb = new StringBuffer();

		if (product.getProductType() != null) {
			sb.append(product.getProductType().name());
		}
		sb.append(" ");
		if (product.getManufacturer() != null) {
			sb.append(product.getManufacturer());
		}
		sb.append(" ");
		if (product.getModel() != null) {
			sb.append(product.getModel());
		}
		anyPage.enterGlobalSearchString(sb.toString());
		anyPage.globalSearch();
		wdu.waitForUrlChange();
	}

	// -------------------------------------------------------------------------
	/**
	 * Preconditions: 
	 * - The driver must be on the Search Results Page.
	 * - The serch result page must be displaying the product
	 * matching the givedn product.
	 *  
	 * Selects the first product that matches the given product and
	 * navigates to Product Detail Page for the product.
	 * 
	 * @param product - Product to match, i.e. product description 
	 * on the page contains the product'smanufacturer and model.
	 */
	public void navigateToProductDetail(Product product) {
		searchResultsPage.navigateToProductDetail(product);
		wdu.waitForUrlChange();

	}

	// -------------------------------------------------------------------------
	/**
	 * Precondition: The driver must be on the Product Detail Page.
	 * Clicks Add to Cart Button
	 */
	/**
	 * Clicks Add to Cart Button 
	 */
	public void addProductToCart() {

		productDetailPage.addToCart();
	}

	// -------------------------------------------------------------------------
	/**
	 * Precondition: The driver must be on the Product Detail Page.
	 * - The Product must had been just added to the Cart.
	 * Clicks Proceed to Checkout Button.
	 */
	public void proceedToCheckout() {
		productDetailPage.proceedToCheckout();
		wdu.waitForUrlChange();
	}

}
