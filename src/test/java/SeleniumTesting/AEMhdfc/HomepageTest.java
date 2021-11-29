package SeleniumTesting.AEMhdfc;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import PageObjects.Homepage;
import base.BaseClass;
import util.ExcelUtil;

public class HomepageTest extends BaseClass {
	private SoftAssert softAssertion = new SoftAssert();
	JavascriptExecutor js;
	Homepage hp;
	String calculatedamount;
	public HomepageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		initializeDriver();
		hp = new Homepage(driver);
		PageFactory.initElements(driver, hp);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		this.js=js;
		ts = (TakesScreenshot) driver;
		System.out.println("Homepage test cases started");
	}


	@Test(priority=1,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyBannerCarousel() throws IOException
	{  
		hp.bannerCarouselDot1().click();
		softAssertion.assertTrue(hp.bannercarouselactiveimage().isDisplayed());
		hp.bannerCarouselDot2().click();
		softAssertion.assertTrue(hp.bannercarouselactiveimage().isDisplayed());
		hp.bannerCarouselDot3().click();
		softAssertion.assertTrue(hp.bannercarouselactiveimage().isDisplayed());
		hp.bannerCarouselDot4().click();
		softAssertion.assertTrue(hp.bannercarouselactiveimage().isDisplayed());
		hp.bannerCarouselDot0().click();
		softAssertion.assertTrue(hp.bannercarouselactiveimage().isDisplayed());
		softAssertion.assertAll();	
		
	}

	/*@Test(priority=2,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyTermPlanOnBanner() throws InterruptedException
	{
		hp.clickTermPlanBlock();
		hp.verifyLink("https://www.hdfclife.com/term-insurance-plans/click-2-protect-life");
	}

	@Test(priority=3, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyFixedMaturityPlanOnBanner() throws InterruptedException
	{
		hp.clickFixedMaturityPlanBlock();
		hp.verifyLink("https://www.hdfclife.com/savings-plans/sanchay-fixed-maturity-plan");
	}

	@Test(priority=4, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifySavingPlansOnBanner() throws InterruptedException
	{
		hp.clickSavingPlansBlock();
		hp.verifyLink("https://www.hdfclife.com/savings-plans");
	}

	@Test(priority=5, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyRetirementPlansOnBanner() throws InterruptedException
	{
		hp.clickRetirementPlansBlock();
		hp.verifyLink("https://www.hdfclife.com/retirement-and-pension-plans");
	}

	@Test(priority=6, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyULIPPlansOnBanner() throws InterruptedException
	{
		hp.clickUlipPlansBlock();
		hp.verifyLink("https://www.hdfclife.com/ulip-plans");
	}

	@Test(priority=7, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyViewAllButton() throws InterruptedException
	{
		hp.clickViewAllBtn();
	}

	@Test(priority=8)
	public void verifyChildrenPlansOnBanner() throws InterruptedException
	{
		hp.clickChildrenPlansBlock();
		hp.verifyLink("https://www.hdfclife.com/children-insurance-plans");
	}

	@Test(priority=9, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyHealthPlansOnBanner() throws InterruptedException
	{
		hp.clickViewAllBtn();
		hp.clickHealthPlansBlock();
		hp.verifyLink("https://www.hdfclife.com/health-insurance-plans");
	}

	@Test(priority=10, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyPosPlansOnBanner() throws InterruptedException
	{
		hp.clickViewAllBtn();
		hp.clickPosPlansBlock();
		hp.verifyLink("https://www.hdfclife.com/savings-plans/pos-guaranteed-savings-plan");
	}

	@Test(priority=11, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyComboPlansOnBanner() throws InterruptedException
	{
		hp.clickViewAllBtn();
		hp.clickNextArrow();
		Thread.sleep(2000);
		hp.clickComboPlansBlock();
		hp.verifyLink("https://www.hdfclife.com/sanchay-maximiser");
	}


	@Test(priority=12, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyGroupPlansOnBanner() throws InterruptedException
	{
		hp.clickViewAllBtn();
		hp.multipleClickNextArrow();
		hp.clickGroupPlansBlock();
		hp.verifyLink("https://www.hdfclife.com/group-insurance-plans");
	}

	@Test(priority=13, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyArrowButtonsOnBanner() throws InterruptedException
	{
		hp.clickViewAllBtn();
		hp.multipleClickNextArrow();
		softAssertion.assertTrue(hp.disablednextarrow().isDisplayed());
		hp.multipleClickPreviousArrow();
		softAssertion.assertTrue(hp.disabledpreviousarrow().isDisplayed());
		softAssertion.assertTrue(hp.displayNextArrow());
		hp.clickNextArrow();
		softAssertion.assertTrue(hp.enabledPreviousArrow());
		softAssertion.assertAll();
	}

	@Test(priority=14, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyMouseIndicator() throws InterruptedException
	{

		js.executeScript("arguments[0].scrollIntoView();", hp.bannerCarouselDot0());
		Thread.sleep(3000);
		softAssertion.assertTrue(hp.mouseindicator().isDisplayed());
		Thread.sleep(3000);
		hp.mouseindicator().click();
		Thread.sleep(3000);
	}

	@DataProvider
	public Object[][] getscheduleformData()
	{
		Object data[][]=ExcelUtil.getTestData("Sheet1");
		return data;
	}

	@Test(priority=15, dataProvider="getscheduleformData")
	public void verifyschedulePopupWithValidData(String fname, String number) throws InterruptedException
	{
		hp.clickScheduleACallButton().click();
		Thread.sleep(2000);
		hp.schedulepopupdata(fname, number);
		hp.closeScheduleCallPopup();
		Thread.sleep(3000);
	}

	@Test(priority=16)
	public void verifyschedulepopupblankSubmit() throws InterruptedException //verify submitting blank data in schedule a call popup
	{
		hp.clickScheduleACallButton().click();
		hp.submitButton().click();
		hp.verifyValidationErrorForBlankSubmit();
		hp.verifyConsentCheckbox();
		hp.closeScheduleCallPopup();
		Thread.sleep(3000);

	}
	@Test(priority=17)
	public void verifyschedulePopupwithoutmindata() throws InterruptedException
	{
		hp.clickScheduleACallButton().click();
		hp.inputForNameAndNumberField("Am", "976846205");
		hp.invalidDataValidationErrorForNameAndNumber();
		hp.closeScheduleCallPopup();
	}

	@Test(priority=18)
	public void verifycalculatorWithValidData() throws InterruptedException
	{
		hp.scrollTillLetUsCalculate();
		hp.clickLetsCalculateButton();
		hp.calculatorInputs("30", "50", "200000", "2000", "0", "graduate", "0");
		hp.clickCalculateButton2();
		hp.verifyResultSection();
		hp.verifyC2PLProductResult();
		js.executeScript("window.scrollBy(0,-800)");
		Thread.sleep(3000);
		hp.clickLetsCalculateButton();
		hp.calculatorInputs("30", "50", "200000", "2000", "0", "graduate", "0");
		hp.clickCalculateButton2();
		hp.verifyLearnMorebtn("https://www.hdfclife.com/term-insurance-plans/click-2-protect-life");
	}
	@Test(priority=19)
	public void verifyCalculatorCloseBtn() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,-800)");
		Thread.sleep(3000);
		hp.clickLetsCalculateButton();
		hp.clickCalculatorCloseBtn();
	}

	@Test(priority=20)
	public void verifySanchayPlusBuyNowBtn() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		hp.clickSanchayPlusBuyNow();
		hp.verifyLinkOpenedInNewWindow("https://onlineinsurance.hdfclife.com/buy-online-savings-plans/sanchayplus-savings-plan?source=NW_SANCHAYP_HP_BuyNow&agentcode=00399206&language=sanchp_EN", 
				"https://www.hdfclife.com/");
	}

	@Test(priority=21)
	public void verifyDisclaimer() throws InterruptedException
	{
		hp.scrollToDisclaimer();
		Thread.sleep(3000);
		softAssertion.assertTrue(hp.disclaimerAccordionOpened().isDisplayed());//check if the accordion is open on page load
		hp.openCloseDisclaimer();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	@Test(priority=22)
	public void verifyProductAndPopularLinks() throws Throwable, Exception 
	{
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		hp.PopularandProductLinks();
	}

	@Test(priority=23)
	public void verifyStayConnectedwithUs() throws InterruptedException, IOException
	{
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		hp.stayConnectedFooter();
	}

	@Test(priority=24)
	public void verifyDownloadLinks() throws InterruptedException, IOException
	{
		hp.appleIcon();
		hp.verifyLinkOpenedInNewWindow("https://apps.apple.com/in/app/id900441427?mt=8", "https://www.hdfclife.com/");
		hp.androidIconClick();
		hp.verifyLinkOpenedInNewWindow("https://play.google.com/store/apps/details?id=com.hdfcclife.activities&shortlink=b165a46c&pid=Brandsite&c=TestLinks"
				, "https://www.hdfclife.com/");
	}

	@Test(priority=25)
	public void verifySubscribeOptionWithValidData() throws InterruptedException
	{
		hp.emailPlaceholder(); // To verify placeholder
		hp.verifySubScribeBtnOnClickOfField();// // to check if the button is enabled after clicking on field
		hp.inputTestEmail("amit@teknopoint.in");
		hp.subscribeBtn().click();
		Thread.sleep(3000);
		hp.verifyEmailSubscriptionSuccessfulMessage();
	}

	@Test(priority=26, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyGroupWebsitesLinks() throws IOException, InterruptedException
	{
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		hp.groupWebsiteLinks();
	}*/
	
	@AfterClass(alwaysRun=true)
	public void tear()
	{
		System.out.println("Homepage test cases executed");
		driver.quit();
	}

}
