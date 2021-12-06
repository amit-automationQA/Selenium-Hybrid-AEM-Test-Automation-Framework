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
import PageObjects.Homepage;
import PageObjects.Productpage;
import base.BaseClass;

public class ProductpageTest extends BaseClass{

	Homepage hp;
	Categorypage cp;
	CategorypageTest ct;
	Productpage pp;
	JavascriptExecutor js;
	
	public static Logger log=LogManager.getLogger(ProductpageTest.class.getName());
	
	public ProductpageTest() {
		super();
	}
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		initializeDriver();
		//SauceLabs_Invocation(); //uncomment if cross browser testing needs to be done
		hp = new Homepage(driver);
		cp = new Categorypage(driver);
		pp = new Productpage(driver);
		PageFactory.initElements(driver, pp);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		this.js=js;
		ts = (TakesScreenshot) driver;
		log.info("Product page test cases started");
		//folder.mkdir();
	}
	
	@Test(priority=1, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void navigateToProductPage() throws InterruptedException
	{
		cp.navigateToTermCategoryPage();
		js.executeScript("window.scrollBy(0,2700)");
		cp.clickC2plLearnMoreBtn();
		pp.verifyOnlyPageUrl("https://www.hdfclife.com/term-insurance-plans/click-2-protect-life");		
	}
	
	@Test(priority=2, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyTandCOption() throws InterruptedException
	{
		pp.TandC();
		js.executeScript("window.scrollBy(0,-100)");
		Thread.sleep(3000);
		hp.openCloseDisclaimer();
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);	
	}
	
	@AfterClass(alwaysRun=true)
	public void tear()
	{
		driver.quit();
		log.info("Product page test cases executed");
		//cp.deleteFolder();
		//log.info("Folder deleted for Category downloads");
	}

}
