package SeleniumTesting.AEMhdfc;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.Categorypage;
import PageObjects.Customerservicelanding;
import PageObjects.Homepage;
import PageObjects.Productpage;
import base.BaseClass;

public class CustomerservicelandingTest extends BaseClass{

	Homepage hp;
	Categorypage cp;
	CategorypageTest ct;
	Productpage pp;
	Customerservicelanding csl;
	JavascriptExecutor js;

	public static Logger log=LogManager.getLogger(ProductpageTest.class.getName());

	public CustomerservicelandingTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		initializeDriver();
		//SauceLabs_Invocation(); //uncomment if cross browser testing needs to be done
		hp = new Homepage(driver);
		cp = new Categorypage(driver);
		pp = new Productpage(driver);
		csl= new Customerservicelanding(driver);
		PageFactory.initElements(driver, csl);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		this.js=js;
		ts = (TakesScreenshot) driver;
		log.info("Customer Service Landing Page test cases started");

	}

	@Test(priority=1, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void navigateToCustomerServiceLandingPage() throws InterruptedException
	{
		csl.visitCustomerServiceLandingPage();
	}

	@Test(priority=2, dependsOnMethods= {"navigateToCustomerServiceLandingPage"}, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyCustomerServiceLandingPopup() throws InterruptedException
	{
		csl.clickDownloadBtn();
		hp.verifyLinkOpenedInNewWindow("https://brandsite-static.hdfclife.com/media/documents/apps/Customer%20FAQ%20For%20BCP%20Scenario_VF.pdf",
				"https://www.hdfclife.com/customer-service");
		csl.verifyCloseBtn();
	}

	@Test(priority=3, dependsOnMethods= {"verifyCustomerServiceLandingPopup"}, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyBannerCarousel() throws InterruptedException
	{
		csl.verifyBannerCarousel1();
		csl.verifyBannerCarousel2();
		hp.verifyLinkOpenedInNewWindow("https://lifeai-avatar-landscape.apps-hdfclife.com/", 
				"https://www.hdfclife.com/customer-service");
		csl.verifyBannerCarousel2mobileoption();
		hp.verifyLinkOpenedInNewWindow("http://onelink.to/728gqs", 
				"https://www.hdfclife.com/customer-service");
		csl.verifyBannerCarousel3();
		hp.verifyLinkOpenedInNewWindow("https://api.whatsapp.com/send?phone=918291890569&text=Hi",
				"https://www.hdfclife.com/customer-service");
		csl.verifyBannerCarousel4();
		hp.verifyLinkOpenedInNewWindow("https://chat.hdfclife.com/", 
				"https://www.hdfclife.com/customer-service");
		csl.verifyBannerCarousel5();	
	}

	@Test(priority=4, dependsOnMethods= {"verifyCustomerServiceLandingPopup"}, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyBreadcrumb() throws InterruptedException
	{
		cp.clickHomeIconInBreadcrumb();
		csl.verifyCloseBtn();
	}

	@Test(priority=5, dependsOnMethods= {"verifyCustomerServiceLandingPopup"}, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyQuickLinksSection() throws InterruptedException
	{
		csl.verifyQuickLinks();
	}

	@Test(priority=6, dependsOnMethods= {"verifyQuickLinksSection"}, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyFAQSection() throws InterruptedException
	{
		csl.verifyFAQpopup();
	}

	@Test(priority=7, dependsOnMethods= {"verifyCustomerServiceLandingPopup"})
	public void verifyTiles() throws InterruptedException
	{
		csl.verifyButtonsOnTiles();
	}

	@Test(priority=8, dependsOnMethods= {"navigateToCustomerServiceLandingPage"})
	public void verifyAadharSection() throws InterruptedException
	{
		csl.clickAadharBtn();
		hp.verifyLinkOpenedInNewWindow("https://eportal.incometax.gov.in/iec/foservices/#/pre-login/bl-link-aadhaar"
				, "https://www.hdfclife.com/customer-service");
	}
	
	@Test(priority=9, dependsOnMethods= {"navigateToCustomerServiceLandingPage"})
	public void verifyContactUsSection() throws InterruptedException
	{
		csl.clickContactUsBtn();
		hp.verifyLinkOpenedInNewWindow("https://myaccount.hdfclife.com/static-cp-cms/023953020_-Go-digital-today.html"
				, "https://www.hdfclife.com/customer-service");
	}
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
		log.info("Customer Service Landing Page test cases executed");
	}


}
