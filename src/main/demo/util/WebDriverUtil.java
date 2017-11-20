package demo.util;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.env.Environment;
import demo.env.RuntimeError;

public class WebDriverUtil {

	/**
	 * Provides value added operations on top of WebDriber - Wait for URL change
	 * - Take Screen-shot
	 */

	private WebDriver driver;
	private Environment env;
	private String rememberedUrl;

	// --------------------------------------------------------------------
	public WebDriverUtil() {

		this.env = Environment.getInstance();
		this.driver = this.env.getCurrentDriver();
		this.rememberedUrl = this.driver.getCurrentUrl();
	}

	// -----------------------------------------------------------------------
	public void close() {
		this.driver.close();
		this.driver.quit();
	}

	// ---------------------------------------------------------------------
	public void waitForUrlChange() {
		// Waits for URL to change from the URL that was when WebDriverUtil was
		// created.
		String currentUrl;
		boolean urlChanged = false;
		for (int i = 1; i <= 30; i++) {
			this.waitSeconds(1);
			currentUrl = this.driver.getCurrentUrl();
			if (!this.rememberedUrl.equals(currentUrl)) {
				urlChanged = true;
				break;
			}
		}
		if (!urlChanged) {
			RuntimeError.raiseStatic("Expected URL Change Did Not Occur in 30 Sec");
		}
	}

	// ------------------------------------------------------------------
	public void takeScreenshot(String filePath) {
		String screenshotFilePath;
		File screenshotFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

		screenshotFilePath = screenshotFile.getAbsolutePath();
		try {
			FileUtils.copyFile(screenshotFile, new File(filePath));
		} catch (IOException ex) {
			RuntimeError
					.raiseStatic("Unable to take screenshot " + filePath + "\n" + RuntimeError.throwableToString(ex));
		}
	}

	// -------------------------------------------------------------------
	private boolean waitSeconds(int i) {

		try {
			Thread.sleep(i * 1000);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
