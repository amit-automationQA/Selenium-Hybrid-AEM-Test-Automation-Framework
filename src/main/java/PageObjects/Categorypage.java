package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class Categorypage extends BaseClass{
	SoftAssert softAssertion = new SoftAssert();
	public Categorypage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[@class='megaMenuLink']")
	WebElement headeralllink;
	
	@FindBy(xpath="(//a[@class='moreMenuLink gtm-moreMenuLink'])[1]")
	WebElement termpagelink;
	
	@FindBy(xpath="//a[@class='siteButton dataLayerBtnClick']")
	WebElement calculatepremiumbtn;
	
	@FindBy (xpath="(//a[@class='siteButton outlinedBtn'])[4]")
	WebElement talktoadvisorbtn;
	
	@FindBy(xpath="//img[@class='homeIconImg']")
	WebElement breadcrumbhomeicon;
	
	@FindBy(xpath="(//a[@class=\"siteButton outlinedBtn learMoreBtn dataLayerBtnClick\"])[1]")
	WebElement c2pllearnmorebtn;

	public void clickheaderAllLink()
	{
		headeralllink.click();
	}
	
	public void navigateToTermCategoryPage() throws InterruptedException
	{
		headeralllink.click();
		Thread.sleep(3000);
		termpagelink.click();
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(), "https://www.hdfclife.com/term-insurance-plans");
		softAssertion.assertAll();
	}
	
	
	public void verifyCalculatePremiumbtn() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(calculatepremiumbtn.isDisplayed());
		calculatepremiumbtn.click();
		Thread.sleep(3000);

	}
		
	public void clickTalkToAdvisorBtn() throws InterruptedException
	{
		softAssertion.assertTrue(talktoadvisorbtn.isDisplayed());
		softAssertion.assertTrue(talktoadvisorbtn.isEnabled());
		talktoadvisorbtn.click();
		softAssertion.assertAll();
		Thread.sleep(3000);
	}
	
	public void clickHomeIconInBreadcrumb() throws InterruptedException
	{
		breadcrumbhomeicon.isDisplayed();
		breadcrumbhomeicon.click();
		Thread.sleep(3000);
	}
	
	public void clickC2plLearnMoreBtn() throws InterruptedException
	{
		c2pllearnmorebtn.isDisplayed();
		c2pllearnmorebtn.click();
		Thread.sleep(3000);
	}
}
