package demo.collaborator;

import demo.bo.Product;
import demo.page.AnyPage;
import demo.page.ProductDetailPage;
import demo.page.SearchResultsPage;
import demo.util.WebDriverUtil;

public class SearchCollaborator {

	
//-------------------------------------------------------------------------
public SearchCollaborator(){
		
	}

	//-------------------------------------------------------------------------
	public void globalSearchProduct(Product product) {
		AnyPage anyPage = new AnyPage();
		WebDriverUtil wdu = new WebDriverUtil();
		StringBuffer sb = new StringBuffer();
		
		if(product.getProductType() != null){
			sb.append(product.getProductType().name());
		}
		sb.append(" ");
		if(product.getManufacturer() != null){
			sb.append(product.getManufacturer());
		}
		sb.append(" ");
		if(product.getModel() != null){
			sb.append(product.getModel());
		}
		anyPage.enterGlobalSearchString(sb.toString());
		anyPage.globalSearch();
		wdu.waitForUrlChange();
	}

	//-------------------------------------------------------------------------
	public void navigateToProductDetail(Product product) {
		SearchResultsPage searchResultsPage = new SearchResultsPage();
		WebDriverUtil wdu = new WebDriverUtil();
		searchResultsPage.navigateToProductDetail(product);
		wdu.waitForUrlChange();
		
	}

	//-------------------------------------------------------------------------
	public void addProductToCart() {
		ProductDetailPage productDetailPage = new ProductDetailPage();
		
		productDetailPage.addToCart();
	}

	//-------------------------------------------------------------------------
	public void proceedToCheckout() {
		ProductDetailPage productDetailPage = new ProductDetailPage();
		WebDriverUtil wdu = new WebDriverUtil();
		productDetailPage.proceedToCheckout();
		wdu.waitForUrlChange();
	}

}
