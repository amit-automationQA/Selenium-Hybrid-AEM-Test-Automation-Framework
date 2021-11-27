package SeleniumTesting.AEMhdfc;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.Categorypage;
import PageObjects.Homepage;
import base.BaseClass;

public class CategorypageTest extends BaseClass{
	Homepage hp;
	Categorypage cp;
	public CategorypageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		initializeDriver();
		hp = new Homepage(driver);
		cp = new Categorypage(driver);
		PageFactory.initElements(driver, cp);
		//softAssertion = new SoftAssert();
	}

	@Test(priority=1, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void navigateToPage() throws InterruptedException
	{	
		cp.navigateToTermCategoryPage();
	}

	@Test(priority=2, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyCalculatePremiumBtn() throws InterruptedException
	{
		cp.verifyCalculatePremiumbtn();
		hp.verifyLinkOpenedInNewWindow("https://onlineinsurance.hdfclife.com/buy-online-term-insurance-plans/click-2-protect-life/basic-details?source=NW_CalcP_termcategory&agentcode=00399206&language=en", 
				"https://www.hdfclife.com/term-insurance-plans");
	}
	
	@Test(priority=3)
	public void verifyTalkToAdvisor() throws InterruptedException
	{
		cp.clickTalkToAdvisorBtn();
	}
	@AfterClass(alwaysRun=true)
	public void tearD()
	{
		driver.quit();
	}
}
