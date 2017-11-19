package demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import demo.env.Environment;

public abstract class BasePage {
	protected WebDriver driver;
	protected Environment env;

	// ----------------------------------------------------------------------
	public BasePage() {
		this.env = new Environment();
		this.driver = this.env.getCurrentDriver();
	}

	// ----------------------------------------------------------------------
	public void enterGlobalSearchString(String searchString) {
		WebElement searchFieldWe;
		searchFieldWe = this.driver.findElement(By.xpath
				("//*[@id=\"ctl00_MasterHeader_ctl00_uchead_GlobalSearchUC_TxtSearchKeyword\"]"));
		searchFieldWe.clear();
		searchFieldWe.sendKeys(searchString);

	}

	// ----------------------------------------------------------------------
	public void globalSearch() {
		WebElement searchButtonWe;
		searchButtonWe = this.driver.findElement
				(By.xpath("//*[@id=\"ctl00_MasterHeader_ctl00_uchead_GlobalSearchUC_BtnSubmitSearch\"]/i"));
		searchButtonWe.click();

	}
}
