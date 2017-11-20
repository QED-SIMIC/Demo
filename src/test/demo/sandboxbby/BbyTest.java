package demo.sandboxbby;

import org.apache.log4j.BasicConfigurator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebDriver;

import demo.bo.Address;
import demo.bo.Checkout;
import demo.bo.CreditCard;
import demo.bo.Customer;
import demo.bo.Product;
import demo.collaborator.CheckoutCollaborator;
import demo.collaborator.SearchCollaborator;
import demo.env.Environment;
import demo.harness.ResultClerk;
import demo.harness.ResultMonitor;
import demo.sandboxbby.data.BbyTestData;

public class BbyTest {

	private static ResultClerk resultClerk = ResultClerk.getInstance();
	private Environment env;
	private WebDriver driver;

	// --------------------------------------------------------
	@Rule
	public TestName currentTestName = new TestName();

	// --------------------------------------------------------
	@Rule
	public TestWatcher resultMonitor = ResultMonitor.watcher;

	// --------------------------------------------------------
	@BeforeClass
	public static void beforeClass() {
	}

	// --------------------------------------------------------
	@AfterClass
	public static void afterClass() {
	}

	// ----------------------------------------------------------
	@Before
	public void beforeTest() {

		BasicConfigurator.configure();
		env = Environment.getInstance();
		driver = this.env.createAndSetWebDriver();
		resultClerk.recordBeginTest(this.currentTestName.getMethodName());
	}

	// --------------------------------------------------------------------
	@Test
	// --------------------------------------------------------------------
	public void shopAtBestBuy_A() {
		Product product;
		Checkout checkoutMethod;
		Customer customer;
		CreditCard creditCard;
		Address billingAddress;
		boolean errorMessageDisplayed = false;
		String errorMessage = "The format of the credit card number entered does not match the card type you specified. Please check for accuracy and try again. (0018)";

		BbyTestData bbyData = new BbyTestData();
		SearchCollaborator search = new SearchCollaborator();
		CheckoutCollaborator checkout = new CheckoutCollaborator();

		product = bbyData.getProduct();
		checkoutMethod = bbyData.getCheckoutMethod();
		customer = bbyData.getCustomer();
		creditCard = bbyData.getCreditCard();
		billingAddress = bbyData.getbillingAddress();

		driver.get("https://www.bestbuy.ca/");

		search.globalSearchProduct(product);
		search.navigateToProductDetail(product);
		search.addProductToCart();
		search.proceedToCheckout();

		checkout.selectCheckoutMethod(checkoutMethod);
		checkout.continueCheckout();
		checkout.populateCustomer(customer);
		checkout.continueToDeliveryAddressAndPayment();
		checkout.populateCreditCard(creditCard);
		checkout.populateBillingAddress(billingAddress);
		checkout.completeCheckout();
		errorMessageDisplayed = checkout.verifyErrorMessageDisplayed(errorMessage);
		Assert.assertTrue(errorMessageDisplayed);

	}
}
