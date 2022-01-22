package SeleniumTesting.AEMhdfc;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.Categorypage;
import PageObjects.Homepage;
import base.BaseClass;
import util.ExcelUtil;
import org.openqa.selenium.TakesScreenshot;

public class HomepageTest extends BaseClass {

	private SoftAssert softAssertion = new SoftAssert();
	JavascriptExecutor js;
	Homepage hp;
	Categorypage cp;
	public static Logger log = LogManager.getLogger(HomepageTest.class.getName());
	String calculatedamount;

	public HomepageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		initializeDriver();
		// SauceLabs_Invocation(); //uncomment if cross browser testing needs to be done
		hp = new Homepage(driver);
		PageFactory.initElements(driver, hp);
		cp = new Categorypage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		this.js = js;
		ts = (TakesScreenshot) driver;
		log.info("Homepage test cases started");
	}

	/*
	 * @Test(priority=1) public void verifyHeader() throws IOException,
	 * InterruptedException { hp.verifyHeaderLinks(); }
	 */
	@Test(priority = 1, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyBannerCarousel() throws IOException, InterruptedException {
		hp.verifyBannerCarouselDot1();
		hp.verifyBannerCarouselDot2();
		hp.verifyBannerCarouselDot3();
		hp.verifyBannerCarouselDot4();
		hp.verifyBannerCarouselDot0();
		log.error("Error occured");
	}

	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		log.info("Homepage test cases executed");
		driver.quit();
	}

}
