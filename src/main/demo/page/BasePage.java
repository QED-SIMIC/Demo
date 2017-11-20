package demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import demo.env.Environment;

public abstract class BasePage {

	/**
	 * BasePage aggregates the functionality available on every page: * Enter
	 * text in the global search field, and execute global search.
	 */
	private static final String SEARCH_FIELD_XPATH = "//*[@id=\"ctl00_MasterHeader_ctl00_uchead_GlobalSearchUC_TxtSearchKeyword\"]";
	private static final String SEARCH_BUTTON_XPATH = "//*[@id=\"ctl00_MasterHeader_ctl00_uchead_GlobalSearchUC_BtnSubmitSearch\"]/i";

	protected WebDriver driver;
	protected Environment env;

	// ----------------------------------------------------------------------
	public BasePage() {
		this.env = Environment.getInstance();
		this.driver = this.env.getCurrentDriver();
	}

	// ----------------------------------------------------------------------
	public void enterGlobalSearchString(String searchString) {
		WebElement searchFieldWe;
		searchFieldWe = this.driver.findElement(By.xpath(SEARCH_FIELD_XPATH));
		searchFieldWe.clear();
		searchFieldWe.sendKeys(searchString);

	}

	// ----------------------------------------------------------------------
	public void globalSearch() {
		WebElement searchButtonWe;
		searchButtonWe = this.driver.findElement(By.xpath(SEARCH_BUTTON_XPATH));
		searchButtonWe.click();

	}
}
