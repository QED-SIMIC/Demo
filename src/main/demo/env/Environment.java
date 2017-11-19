package demo.env;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Environment {

		public final static Dimension DESKTOP_VIEWPORT = new Dimension(1300, 700);
	public static final Dimension TABLET_PORTRAIT = new Dimension(768 + 36, 1024);
	public static final Dimension TABLET_LANDSCAPE = new Dimension(1024 + 39, 768);
	private static final Point BROWSER_INITIAL_POSITION = new Point(0, 0);

	private final static String CHROME_WEB_DRIVER_FILE_PATH = "C:\\Selenium\\Driver\\chromedriver.exe";
	private final static String CHROME_WB_DRIVER_PROPERTY = "webdriver.chrome.driver";

	
	// -------------------------------------------------------------
	private static WebDriver driver = null;

	private Point initialtBrowserPosition;
	private Dimension initialViewport;

	// ------------------------------------------------------------------------
	public Environment() {
		this.initialtBrowserPosition = BROWSER_INITIAL_POSITION;
		this.initialViewport = DESKTOP_VIEWPORT;
	}

	// --------------------------------------------------------------------
	public WebDriver createAndSetWebDriver() {

		File chromeWebDriverExeFile;

		chromeWebDriverExeFile = new File(CHROME_WEB_DRIVER_FILE_PATH);
		System.setProperty(CHROME_WB_DRIVER_PROPERTY, chromeWebDriverExeFile.getAbsolutePath());

		Environment.driver = new ChromeDriver();

		// Implicit Time-Outs conflict with explicit Time-Outs => Use explicit waits and Time-Outs
		// Environment.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		// Environment.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		Environment.driver.manage().window().setPosition(this.initialtBrowserPosition);
		Environment.driver.manage().window().setSize(this.initialViewport);

		return Environment.driver;
	}

	// --------------------------------------------------------------------
	public WebDriver getCurrentDriver() {
		return Environment.driver;
	}


}
