package demo.util;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import demo.env.Environment;
import demo.env.RunTimeError;


public class WebDriverUtil {

	private final static int WAIT_BETWEEN_RETRIES_SEC = 2;
	private final static int MAX_RETRIES = 15;
	private final static int MAX_WAIT_FOR_ELEMENT = 15;

	private WebDriver driver;
	private Environment env;
	private String rememberedUrl;
	private Set<String> winHandlesBeforeActionOpeningNewWindow;
	private String winHandleBeforeActionOpeningNewWindow;

	// --------------------------------------------------------------------
	public WebDriverUtil() {

		this.env = new Environment();
		this.driver = this.env.getCurrentDriver();
		this.rememberedUrl = this.driver.getCurrentUrl();
		this.winHandlesBeforeActionOpeningNewWindow = this.driver.getWindowHandles();
		this.winHandleBeforeActionOpeningNewWindow = this.driver.getWindowHandle();

	}

	// -----------------------------------------------------------------------
	public String getCurrentUrlNoWait() {
		String currentUrl;
		currentUrl = this.driver.getCurrentUrl();
		return currentUrl;
	}

	// ------------------------------------------------------------------------
	public String getCurrentUrlAfterChange(String oldUrl) {

		String currentUrl = null;
		boolean urlChanged = false;

		for (int i = 1; i < 25; i++) {
			currentUrl = this.driver.getCurrentUrl();
			if (!oldUrl.equalsIgnoreCase(currentUrl)) {
				urlChanged = true;
				break;
			}
		}
		if (!urlChanged) {
			RunTimeError.raiseStatic("WebDriverUtil.getCurrentUrlAfterChange-- " + "URL did not change " + oldUrl);
		}
		return currentUrl;
	}

	// -----------------------------------------------------------------------
	public void close() {
		this.driver.close();
		this.driver.quit();
	}

	// -----------------------------------------------------------------------
	public void closeWindow() {
		this.driver.close();
		this.driver.switchTo().window(this.winHandleBeforeActionOpeningNewWindow);
	}

	// ----------------------------------------------------
	public void acceptAlert() {
		Alert alert;
		if (this.isAlertPresent()) {
			alert = driver.switchTo().alert();
			alert.accept();
		} else {
			RunTimeError.raiseStatic("Expected Alert Not Present!");
		}
	}

	// ----------------------------------------------------
	public boolean isAlertPresent() {
		boolean presentFlag = false;
		Alert alert;

		try {
			// Check the presence of alert
			alert = this.driver.switchTo().alert();
			// Alert present; set the flag
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			presentFlag = false;
		}
		return presentFlag;
	}

	// ------------------------------------------------------
	public String getAlertText() {
		String alertText = null;
		Alert alert;
		if (this.isAlertPresent()) {
			alert = this.driver.switchTo().alert();
			alertText = alert.getText();
		} else {
			RunTimeError.raiseStatic("Expected Alert Not Present!");
		}
		return alertText;
	}

	// ---------------------------------------------------------------------
	public void waitForUrlChange() {
		// Waits for URL to change from the URL that was when WebDriverUtil was
		// created.
		String currentUrl;
		boolean urlChanged = false;
		for (int i = 1; i <= 30; i++) {
			this.waitSeconds(2);
			currentUrl = this.driver.getCurrentUrl();
			if (!this.rememberedUrl.equals(currentUrl)) {
				urlChanged = true;
				break;
			}
		}
		if (!urlChanged) {
			RunTimeError.raiseStatic("Expected URL Change Did Not Occur in 60 Sec");
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
			RunTimeError
					.raiseStatic("Unable to take screenshot " + filePath + "\n" + RunTimeError.exceptionToString(ex));
		}
	}

	// -------------------------------------------------------------------
	private static boolean waitSeconds(int i) {

		try {
			Thread.sleep(i * 1000);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
