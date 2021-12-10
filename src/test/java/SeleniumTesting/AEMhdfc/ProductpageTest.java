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
		
	}

	@Test(priority=1, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void navigateToProductPage() throws InterruptedException
	{
		cp.navigateToTermCategoryPage();
		js.executeScript("window.scrollBy(0,2700)");
		cp.clickC2plLearnMoreBtn();
		pp.verifyOnlyPageUrl("https://www.hdfclife.com/term-insurance-plans/click-2-protect-life");		
	}

	@Test(priority=2, retryAnalyzer = Analyzer.RetryAnalyzer.class, dependsOnMethods={"navigateToProductPage"})
	public void verifyTandCOption() throws InterruptedException
	{
		pp.TandC();
		js.executeScript("window.scrollBy(0,-100)");
		Thread.sleep(3000);
		hp.openCloseDisclaimer();
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)"); //To scroll at the top of the page
		Thread.sleep(3000);	
	}

	@Test(priority=3, retryAnalyzer = Analyzer.RetryAnalyzer.class, dependsOnMethods={"navigateToProductPage"})
	public void verifyProductPageBreadcrumb() throws InterruptedException
	{
		cp.clickHomeIconInBreadcrumb();
		pp.verifyCategoryPageLinkInBreadcrumb();
	}

	@Test(priority=4, retryAnalyzer = Analyzer.RetryAnalyzer.class, dependsOnMethods={"navigateToProductPage"})
	public void verifyRatingOption() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,300)");
		pp.provideRatings();
	}

	@Test(priority=5, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyPrintBtn() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,300)");
		pp.clickPrintBtn();
		pp.verifyLinkOpeningInNewWindow();
	}

	@Test(priority=6, retryAnalyzer = Analyzer.RetryAnalyzer.class , dependsOnMethods={"verifyPrintBtn"})
	public void verifyShareOption() throws InterruptedException
	{
		pp.verifySharePopup();
		pp.verifyFacebookShareBtn();
		pp.verifySharePopup();
		pp.verifyTwitterShareBtn();
		pp.verifySharePopup();
		pp.verifyLinkedInShareBtn();

	}
	@Test(priority=7, retryAnalyzer = Analyzer.RetryAnalyzer.class , dependsOnMethods={"verifyPrintBtn"})
	public void verifyRatingsFromAPI() throws InterruptedException
	{
		pp.viewProductRatingsFromApi();
	}

	@Test(priority=8, retryAnalyzer = Analyzer.RetryAnalyzer.class , dependsOnMethods={"verifyPrintBtn"})
	public void verifyDownloadBrochure() throws InterruptedException
	{
		folder.mkdir();
		pp.verifyDownloadingBrochure();
		cp.isFileDownloaded("MC062124237-V01-HDFC-Life-Click-2-Protect-Life-Retail-Brochure.pdf");
		cp.deleteFolder();
	}

	@Test(priority=9, retryAnalyzer = Analyzer.RetryAnalyzer.class , dependsOnMethods={"verifyPrintBtn"})
	public void verifyCalculatePremiumBtn() throws InterruptedException
	{
		pp.clickCalculatePremiumBtn();
		hp.verifyLinkOpenedInNewWindow("https://onlineinsurance.hdfclife.com/buy-online-term-insurance-plans/click-2-protect-life/basic-details?source=NW_C2PL_PP_CALC&agentcode=00399206&language=en", 
				"https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup");
	}

	@Test(priority=10, retryAnalyzer = Analyzer.RetryAnalyzer.class , dependsOnMethods={"verifyPrintBtn"})
	public void verifyBuyNowBtn() throws InterruptedException
	{
		pp.clickBuyNow();
		hp.verifyLinkOpenedInNewWindow("https://onlineinsurance.hdfclife.com/buy-online-term-insurance-plans/click-2-protect-life/basic-details?source=NW_C2PL_BuyNow&agentcode=00399206&language=en",
				"https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup");
		driver.navigate().refresh();
	}

	@Test(priority=11, retryAnalyzer = Analyzer.RetryAnalyzer.class, dependsOnMethods= {"navigateToProductPage"})
	public void verifyDownloadsSectionAfterScroll() throws InterruptedException
	{
		driver.navigate().refresh();
		log.info("Download section verification after scroll started");
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		verifyRatingOption();
		Thread.sleep(3000);
		verifyPrintBtn();	
		verifyShareOption();
		verifyRatingsFromAPI();
		verifyDownloadBrochure();
		verifyCalculatePremiumBtn();
		verifyBuyNowBtn();
	}
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
		log.info("Product page test cases executed");
		//cp.deleteFolder();
		//log.info("Folder deleted for Category downloads");
	}

}
