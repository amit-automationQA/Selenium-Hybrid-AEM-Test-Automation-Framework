package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class Productpage extends BaseClass{

	static SoftAssert softAssertion = new SoftAssert();
	public static Logger log=LogManager.getLogger(Productpage.class.getName());

	//Constructor for avoiding null pointer exception on driver
	public Productpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	//@FindBy and By
	@FindBy(xpath="//a[@class='popuptext']")
	WebElement tandcpopup;	

	@FindBy(xpath="//label[normalize-space()='Term Insurance Plans']")
	WebElement categorypagebreadcrumb;

	@FindBy(xpath="//div[@class='icon-wrap rate']")
	WebElement rateicon;

	@FindBy(xpath="//div[@id='starRate']//*[name()='svg'][3]/*[name()='path'][1]")
	WebElement threestarrating;

	@FindBy(xpath="//p[@id='rate-msg']")
	WebElement ratingtext;

	@FindBy(xpath="//div[@class='five-star-wrapper'][@id='starRating']")
	WebElement ratingsacquiredfromapi;

	@FindBy(xpath="//div[@class='icon-wrap print']")
	WebElement printbtn;

	@FindBy(xpath="//div[@class='icon-wrap share']")
	WebElement sharebtn;

	@FindBy(xpath="//li[@class='share_social'][@data-medium='facebook']")
	WebElement facebooksharebtn;

	@FindBy(xpath="//li[@class='share_social'][@data-medium='twitter']")
	WebElement twittersharebtn;

	@FindBy(xpath="//li[@class='share_social'][@data-medium='linkedin']")
	WebElement linkedinsharebtn;

	@FindBy(xpath="//a[@class='product-download-btn downloadPdfClick']")
	WebElement downloadbrochurebtn;

	@FindBy(xpath="//a[@class='product-calculate-btn outlined-button-hover dataLayerBtnClick']")
	WebElement calculatepremiumbtn;
	
	@FindBy(xpath="//a[@class='product-buynow-btn btnred dataLayerBtnClick']")
	WebElement buynowbtn;
	
	//Initialized methods
	public void verifyOnlyPageUrl(String onlycurrenturl) 
	{
		softAssertion.assertEquals(driver.getCurrentUrl(),onlycurrenturl);
		softAssertion.assertAll();
	}

	public void TandC() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(tandcpopup.isDisplayed());
		Thread.sleep(3000);
		tandcpopup.click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	public void verifyCategoryPageLinkInBreadcrumb() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(categorypagebreadcrumb.isDisplayed());
		categorypagebreadcrumb.click();
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(), "https://www.hdfclife.com/term-insurance-plans");
		driver.navigate().back();
		Thread.sleep(3000);
	}

	public void provideRatings() throws InterruptedException
	{
		softAssertion.assertTrue(rateicon.isDisplayed());
		Thread.sleep(3000);
		Actions action = new Actions(driver); // Reference link: https://www.browserstack.com/guide/action-class-in-selenium
		action.moveToElement(rateicon);
		Thread.sleep(3000);
		softAssertion.assertEquals(ratingtext.getText(), "Rate this product");
		Thread.sleep(3000);
		action.moveToElement(threestarrating).click(threestarrating);
		Thread.sleep(3000);
		//Thread.sleep(3000);
		//action.moveToElement(rateicon);
		Thread.sleep(3000);
		//softAssertion.assertEquals(ratingtext.getText(), "PRODUCT RATED");
		softAssertion.assertAll();
	}

	public void viewProductRatingsFromApi() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(ratingsacquiredfromapi.isDisplayed());
		softAssertion.assertAll();
	}

	public void clickPrintBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(printbtn.isDisplayed());
		printbtn.click();
	}

	public void verifyLinkOpeningInNewWindow() throws InterruptedException
	{ 
		//https://stackoverflow.com/questions/9588827/how-to-switch-to-the-new-browser-window-which-opens-after-click-on-the-button
		Thread.sleep(3000);
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		softAssertion.assertEquals(driver.getCurrentUrl(), 
				"https://www.hdfclife.com/content/dam/hdfclifeinsurancecompany/products-page/brochure-pdf/MC062124237-V01-HDFC-Life-Click-2-Protect-Life-Retail-Brochure.pdf");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(3000);

	}

	public void verifySharePopup() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(sharebtn.isDisplayed());
		Actions action = new Actions(driver);
		action.moveToElement(sharebtn).build().perform();
		Thread.sleep(2000);

	}
	public void verifyFacebookShareBtn() throws InterruptedException
	{
		Homepage hp = new Homepage(driver);
		softAssertion.assertTrue(facebooksharebtn.isDisplayed());
		facebooksharebtn.click();
		Thread.sleep(3000);
		hp.verifyLinkOpenedInNewWindow("https://www.facebook.com/login.php?skip_api_login=1&api_key=966242223397117&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fsharer.php%3Fu%3Dhttps%253A%252F%252Fwww.hdfclife.com%252Fterm-insurance-plans%252Fclick-2-protect-life&cancel_url=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Fclose_window%2F%3Fapp_id%3D966242223397117%26connect%3D0%23_%3D_&display=popup&locale=en_GB#discPopup", 
				"https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup");
	}

	public void verifyTwitterShareBtn() throws InterruptedException
	{
		Homepage hp = new Homepage(driver);
		Thread.sleep(3000);
		softAssertion.assertTrue(twittersharebtn.isDisplayed());
		twittersharebtn.click();
		Thread.sleep(3000);
		hp.verifyLinkOpenedInNewWindow("https://twitter.com/intent/tweet?&url=https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup", 
				"https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup");
	}

	public void verifyLinkedInShareBtn() throws InterruptedException
	{
		Homepage hp = new Homepage(driver);
		Thread.sleep(3000);
		softAssertion.assertTrue(linkedinsharebtn.isDisplayed());
		linkedinsharebtn.click();
		Thread.sleep(3000);
		hp.verifyLinkOpenedInNewWindow("https://www.linkedin.com/signup/cold-join?session_redirect=https%3A%2F%2Fwww%2Elinkedin%2Ecom%2FshareArticle%2F%3Furl%3Dhttps%3A%2F%2Fwww%2Ehdfclife%2Ecom%2Fterm-insurance-plans%2Fclick-2-protect-life&trk=login_reg_redirect#discPopup", 
				"https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup");
	}

	public void verifyDownloadingBrochure() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(downloadbrochurebtn.isDisplayed());
		downloadbrochurebtn.click();
	}

	public void clickCalculatePremiumBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(calculatepremiumbtn.isDisplayed());
		calculatepremiumbtn.click();
		Thread.sleep(2000);
	}
	
	public void clickBuyNow() throws InterruptedException
	{
		softAssertion.assertTrue(buynowbtn.isDisplayed());
		buynowbtn.click();
		Thread.sleep(3000);
	}
}


