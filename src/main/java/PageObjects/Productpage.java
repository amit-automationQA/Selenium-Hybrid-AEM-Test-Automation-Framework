package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class Productpage extends BaseClass{

	//static SoftAssert softAssertion = new SoftAssert();
	//https://stackoverflow.com/questions/59083170/single-soft-assertion-error-is-failing-subsequent-passed-scenarios
	//Reason why the above code was commented and softAssert is not declared globally
	/*Your dataprovider powered @Test method is basically using one SoftAssert instance and then invoking an assertAll() for all data provider data set iterations using the same instance.
	SoftAssert is designed to remember all assertions that have been recorded so far via calls to assertXXX.
	To fix this problem you should be instantiating the SoftAssert object inside the @Test method*/
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

	@FindBy(css="#rate-msg")
	WebElement ratetext;

	@FindBy(xpath="(//*[name()='svg'][@class='starttest'])[2]")
	WebElement twostarrating;

	@FindBy(xpath="(//a[@class='talk-to-advisor-link outlined-button-hover product-benefits-cards-data-layer'])[1]")
	WebElement benefitstalktoadvisorbtn;

	@FindBy(id="view-eligibility-table")
	WebElement eligibilitycriteriabtn;

	@FindBy(className="close-table")
	WebElement eligibilitycriteriaclosebtn;

	@FindBy(xpath="(//a[@class='viewMoreBtn'])[3]")
	WebElement ridersectionviewmorebtn;

	@FindBy(xpath="//div[@id='myModal']//input[@placeholder='Name']")
	WebElement scheduleacallname;

	@FindBy(xpath="//div[@id='myModal']//input[@placeholder='Mobile Number']")
	WebElement scheduleacallnumber;

	@FindBy(xpath="(//select[@id='insurance_category'])[5]")
	WebElement plansdropdown;	
	
	@FindBy(xpath="(//span[@class='close-icon1'])[5]")
	WebElement scheduleacallclosebtn;

	@FindBy(xpath="(//a[@class='viewMoreBtn'])[4]")
	WebElement faqviewmorebtn;
	
	@FindBy(xpath="//a[@class='viewMoreBtn viewLessBtn']")
	WebElement viewlessbtn;
	
	@FindBy(xpath="(//button[@class='btn btnwhite dataLayerBtnClick'])[1]")
	WebElement viewexamplbtn;
	
	@FindBy(xpath="(//span[@class='close-iconprod'])[1]")
	WebElement examplepopupclosebtn;
	
	//Initialized methods
	public void verifyOnlyPageUrl(String onlycurrenturl) 
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(driver.getCurrentUrl(),onlycurrenturl);
		softAssertion.assertAll();
	}

	public void TandC() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(tandcpopup.isDisplayed());
		Thread.sleep(3000);
		tandcpopup.click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	public void verifyCategoryPageLinkInBreadcrumb() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(categorypagebreadcrumb.isDisplayed());
		categorypagebreadcrumb.click();
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(), "https://www.hdfclife.com/term-insurance-plans");
		driver.navigate().back();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	public void provideRatings() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(rateicon.isDisplayed());
		Thread.sleep(3000);
		Actions action = new Actions(driver); // Reference link: https://www.browserstack.com/guide/action-class-in-selenium
		//Performing the mouse hover action on the target element.
		action.moveToElement(rateicon).perform();
		String productratetext = ratetext.getAttribute("innerText");
		softAssertion.assertEquals(productratetext, "Rate this product");
		twostarrating.click();
		Thread.sleep(3000);
		action.moveToElement(rateicon).perform();
		Thread.sleep(3000);
		String productratetext1 = ratetext.getAttribute("innerText");
		softAssertion.assertEquals(productratetext1, "PRODUCT RATED");
		softAssertion.assertAll();
	}

	public void viewProductRatingsFromApi() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(ratingsacquiredfromapi.isDisplayed());
		softAssertion.assertAll();
	}

	public void clickPrintBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(printbtn.isDisplayed());
		printbtn.click();
		softAssertion.assertAll();
	}

	public void verifyLinkOpeningInNewWindow() throws InterruptedException
	{ 
		SoftAssert softAssertion = new SoftAssert();
		//https://stackoverflow.com/questions/9588827/how-to-switch-to-the-new-browser-window-which-opens-after-click-on-the-button
		Thread.sleep(3000);
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		softAssertion.assertEquals(driver.getCurrentUrl(), 
				"https://www.hdfclife.com/content/dam/hdfclifeinsurancecompany/products-page/term-insurance-plan/click-2-protect-life/HDFC-Life-Click-2-Protect-Life-101N139V02-Brochure.pdf");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(3000);
		softAssertion.assertAll();

	}

	public void verifySharePopup() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(sharebtn.isDisplayed());
		Actions action = new Actions(driver);
		action.moveToElement(sharebtn).build().perform();
		Thread.sleep(2000);
		softAssertion.assertAll();

	}
	public void verifyFacebookShareBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Homepage hp = new Homepage(driver);
		softAssertion.assertTrue(facebooksharebtn.isDisplayed());
		facebooksharebtn.click();
		Thread.sleep(3000);
		hp.verifyLinkOpenedInNewWindow("https://www.facebook.com/login.php?skip_api_login=1&api_key=966242223397117&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fsharer.php%3Fu%3Dhttps%253A%252F%252Fwww.hdfclife.com%252Fterm-insurance-plans%252Fclick-2-protect-life&cancel_url=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Fclose_window%2F%3Fapp_id%3D966242223397117%26connect%3D0%23_%3D_&display=popup&locale=en_GB#discPopup", 
				"https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup");
		softAssertion.assertAll();
	}

	public void verifyTwitterShareBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Homepage hp = new Homepage(driver);
		Thread.sleep(3000);
		softAssertion.assertTrue(twittersharebtn.isDisplayed());
		twittersharebtn.click();
		Thread.sleep(3000);
		hp.verifyLinkOpenedInNewWindow("https://twitter.com/intent/tweet?&url=https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup", 
				"https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup");
		softAssertion.assertAll();
	}

	public void verifyLinkedInShareBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Homepage hp = new Homepage(driver);
		Thread.sleep(3000);
		softAssertion.assertTrue(linkedinsharebtn.isDisplayed());
		linkedinsharebtn.click();
		Thread.sleep(3000);
		hp.verifyLinkOpenedInNewWindow("https://www.linkedin.com/signup/cold-join?session_redirect=https%3A%2F%2Fwww%2Elinkedin%2Ecom%2FshareArticle%2F%3Furl%3Dhttps%3A%2F%2Fwww%2Ehdfclife%2Ecom%2Fterm-insurance-plans%2Fclick-2-protect-life&trk=login_reg_redirect#discPopup", 
				"https://www.hdfclife.com/term-insurance-plans/click-2-protect-life#discPopup");
		softAssertion.assertAll();
	}

	public void verifyDownloadingBrochure() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(downloadbrochurebtn.isDisplayed());
		downloadbrochurebtn.click();
		softAssertion.assertAll();
	}

	public void clickCalculatePremiumBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(calculatepremiumbtn.isDisplayed());
		calculatepremiumbtn.click();
		Thread.sleep(2000);
		softAssertion.assertAll();
	}

	public void clickBuyNow() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(buynowbtn.isDisplayed());
		buynowbtn.click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	public void clickBenefitsTalkToAdvisorBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(benefitstalktoadvisorbtn.isDisplayed());
		benefitstalktoadvisorbtn.click();
		softAssertion.assertAll();
	}

	public void openAndCloseEligibilityCriteria() throws InterruptedException
	{
		Thread.sleep(3000);
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(eligibilitycriteriabtn.isDisplayed());
		eligibilitycriteriabtn.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(eligibilitycriteriaclosebtn));
		eligibilitycriteriaclosebtn.click();
		Thread.sleep(2000);
		softAssertion.assertTrue(eligibilitycriteriabtn.isDisplayed());
		softAssertion.assertAll();
		Thread.sleep(2000);
	}

	public void verifyProductPageViewMoreOnLoad() throws InterruptedException
	{
		Thread.sleep(3000);
		if(ridersectionviewmorebtn.isDisplayed())
		{
			ridersectionviewmorebtn.click();
			Thread.sleep(3000);
		}	
	}

	public void clickScheduleACallClosePopup()
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(scheduleacallclosebtn.isDisplayed());
		scheduleacallclosebtn.click();
		softAssertion.assertAll();
	}
	public void verifywithData(String fullname, String contactnumber, String plantype) throws InterruptedException
	{
		Thread.sleep(2000);
		scheduleacallname.sendKeys(fullname);
		scheduleacallnumber.sendKeys(contactnumber);
		Select plndropdown = new Select(plansdropdown);
		plndropdown.selectByValue(plantype);
		Thread.sleep(3000);
		clickScheduleACallClosePopup();
		Thread.sleep(3000);
	}
	
	public void verifyScheduleAPopupWithInvalidData(String fullname1, String contactnumber1) throws InterruptedException
	{
		Thread.sleep(2000);
		scheduleacallname.sendKeys(fullname1);
		scheduleacallnumber.sendKeys(contactnumber1);
		Thread.sleep(3000);
	}

	public void verifyFAQViewMoreBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		if(faqviewmorebtn.isDisplayed())
		{
			faqviewmorebtn.click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,900)");
			Thread.sleep(3000);
			viewlessbtn.click();
			Thread.sleep(3000);
			softAssertion.assertTrue(faqviewmorebtn.isDisplayed());	
		}
		else {
			//softAssertion.assertTrue(false, "View more button for term insurance buying guide is not visible on page load");
			log.error("View more button for FAQ is not visible on page load");
		}
		softAssertion.assertAll();
	}
	
	public void verifyCarouselNextArrow() throws InterruptedException {
		for(int narrow = 0; narrow<=2;narrow++)
		{
			if((driver.findElement(By.xpath("(//button[@class='owl-next'])[1]"))).isDisplayed())
			{
				(driver.findElement(By.xpath("(//button[@class='owl-next'])[1]"))).click();
				Thread.sleep(3000);
			}
		}
		Thread.sleep(3000);
	}
	
	public void verifyCarouselPreviousArrow() throws InterruptedException
	{
		for(int parrow = 0; parrow<=1;parrow++)
		{
			if(driver.findElement(By.xpath("(//button[@class='owl-prev'])[1]")).isDisplayed())
			{
				driver.findElement(By.xpath("(//button[@class='owl-prev'])[1]")).click();
				Thread.sleep(3000);
			}
		}
		Thread.sleep(3000);
	}
	
	public void verifyBenefitsSection() throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.product-info-card').scrollTop=500");
		Thread.sleep(3000);
		viewexamplbtn.click();
		Thread.sleep(3000);
		examplepopupclosebtn.click();
		Thread.sleep(3000);
		//js.executeScript("window.scrollBy(0,0)");
		Thread.sleep(2000);	
		verifyCarouselNextArrow();
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(By.xpath("(//button[@class='owl-next disabled'])[1]")).isDisplayed());
		Thread.sleep(3000);
		verifyCarouselPreviousArrow();
		softAssertion.assertTrue(driver.findElement(By.xpath("(//button[@class='owl-prev disabled'])[1]")).isDisplayed());
		
	}	
	
	

	}



