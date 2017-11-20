package demo.env;

import java.io.File;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Environment {

	/**
	 * Environment class is a singleton keeping the information specific for the
	 * environment in which the test is run, current WebDriver instance, current
	 * system udner test build. Environment class can read the information from
	 * a file or environment variables,
	 */

	public final static Dimension DESKTOP_VIEWPORT = new Dimension(1300, 700);
	public static final Dimension TABLET_PORTRAIT = new Dimension(768 + 36, 1024);
	public static final Dimension TABLET_LANDSCAPE = new Dimension(1024 + 39, 768);
	private static final Point BROWSER_INITIAL_POSITION = new Point(0, 0);

	private final static String CHROME_WEB_DRIVER_FILE_PATH = "C:\\Selenium\\Driver\\chromedriver.exe";
	private final static String CHROME_WB_DRIVER_PROPERTY = "webdriver.chrome.driver";

	// ------------------------------------------------------------------------
	private static Environment env = new Environment();
	// -------------------------------------------------------------
	private WebDriver driver = null;

	private Point initialtBrowserPosition;
	private Dimension initialViewport;

	// ------------------------------------------------------------------------
	// Singleton
	// --------------------------------------------------------------------------
	private Environment() {
		this.initialtBrowserPosition = BROWSER_INITIAL_POSITION;
		this.initialViewport = DESKTOP_VIEWPORT;
		this.driver = null;
	}

	// ------------------------------------------------------------------------
	public static Environment getInstance() {
		return env;
	}

	// --------------------------------------------------------------------
	public WebDriver createAndSetWebDriver() {

		File chromeWebDriverExeFile;

		chromeWebDriverExeFile = new File(CHROME_WEB_DRIVER_FILE_PATH);
		System.setProperty(CHROME_WB_DRIVER_PROPERTY, chromeWebDriverExeFile.getAbsolutePath());

		this.driver = new ChromeDriver();

		this.driver.manage().window().setPosition(this.initialtBrowserPosition);
		this.driver.manage().window().setSize(this.initialViewport);

		return this.driver;
	}

	// --------------------------------------------------------------------
	public WebDriver getCurrentDriver() {
		return this.driver;
	}

}
