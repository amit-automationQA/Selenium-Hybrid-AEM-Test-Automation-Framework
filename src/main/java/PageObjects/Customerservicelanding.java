package PageObjects;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
public class Customerservicelanding extends BaseClass{

	public static Logger log=LogManager.getLogger(Customerservicelanding.class.getName());

	//Constructor for avoiding null pointer exception on driver
	public Customerservicelanding(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	By bannercarouseldot0 =By.xpath("//li[@data-slide-to='0']");
	By bannercarouseldot1= By.xpath("//li[@data-slide-to='1']");
	By bannercarouseldot2= By.xpath("//li[@data-slide-to='2']");
	By bannercarouseldot3 = By.xpath("//li[@data-slide-to='3']");
	By bannercarouseldot4 = By.xpath("//li[@data-slide-to='4']");

	@FindBy(xpath="//a[contains(text(),'Customer Service')]")
	WebElement headercustomerservice;

	@FindBy(xpath="//li[@data-slide-to='0'][@class='active']")
	WebElement bannercarousel0active;

	@FindBy(xpath="//li[@data-slide-to='1'][@class='active']")
	WebElement bannercarousel1active;

	@FindBy(xpath="//li[@data-slide-to='2'][@class='active']")
	WebElement bannercarousel2active;

	@FindBy(xpath="//li[@data-slide-to='3'][@class='active']")
	WebElement bannercarousel3active;

	@FindBy(xpath="//li[@data-slide-to='4'][@class='active']")
	WebElement bannercarousel4active;

	@FindBy(xpath="//a[@class='download-a']")
	WebElement cslandingpopupdownloadbtn;

	@FindBy(xpath="//img[@class='closeAll regulatorypopupAImg']")
	WebElement imageincspopup;	

	@FindBy(xpath="//img[@class='at-element-click-tracking']")
	WebElement cslandingpopupclosebtn;

	@FindBy(xpath="(//a[contains(text(),'Website')])[1]")
	WebElement websiteoptioninbanner;
	
	@FindBy(xpath="(//a[contains(text(),'Mobile')])[1]")
	WebElement mobileoptioninbanner;
	
	@FindBy(xpath="(//a[contains(text(),'Click here')])[3]")
	WebElement linkincarousel3;

	@FindBy(xpath="(//a[contains(text(),'Click here')])[4]")
	WebElement linkincarousel4;
	
	@FindBy(xpath="(//a[@class='btn btnwhite btn-white-data-layer'])[1]")
	WebElement myaccountfaqlearnmorebtn;
	
	@FindBy(xpath="(//div[@class='cs-box-holder forcs font-h2-style'] //ul)[1]")
	WebElement myaccountfaqtile;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[1]")
	WebElement kycproofs;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[2]")
	WebElement formsanddownload;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[3]")
	WebElement demat;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[4]")
	WebElement newbusinessrelated;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[5]")
	WebElement taxation;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[6]")
	WebElement bonus;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[7]")
	WebElement keyfeaturesdocument;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[8]")
	WebElement trackservicerequest;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[9]")
	WebElement ivr;
	
	@FindBy(xpath="(//div[@class='rt-blue-bg']//a)[10]")
	WebElement paypremium;
	
	@FindBy(xpath="//a[@data-modaltarget='service-when']")
	WebElement faqques;
	
	@FindBy(xpath="//div[@id='service-when']//a[@class='modalCloseBtn']")
	WebElement firstfaqpopupclosebtn;
	
	@FindBy(css="a[class='btn btnwhite btn-white-data-layer']")
	List<WebElement> learnmorebtns;
	
	@FindBy(css="button[class='info-blue-button info-blue-button-data-layer']")
	List<WebElement> loginbtns;
	
	@FindBy(xpath="//button[@class='btn btn-primary btnred btn-auto toggleBtnClick']")
	WebElement aadharclickherebtn;
	
	@FindBy(xpath="//a[@class='bannerAdBtn siteButton']")
	WebElement contactusbtn;
	
	public void visitCustomerServiceLandingPage() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(headercustomerservice.isDisplayed());
		headercustomerservice.click();
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(), "https://www.hdfclife.com/customer-service");
		softAssertion.assertAll();

	}

	public void clickDownloadBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(imageincspopup.isDisplayed());
		softAssertion.assertTrue(cslandingpopupdownloadbtn.isDisplayed());
		cslandingpopupdownloadbtn.click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	public void verifyCloseBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(cslandingpopupclosebtn.isDisplayed());
		cslandingpopupclosebtn.click();
		Thread.sleep(3000);
		softAssertion.assertAll();	
	}

	public void verifyBannerCarousel1() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(bannercarouseldot0).isDisplayed());
		driver.findElement(bannercarouseldot0).click();
		Thread.sleep(2000);	
		softAssertion.assertAll();
	}

	public void verifyBannerCarousel2() throws InterruptedException
	{ 
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(bannercarouseldot1).isDisplayed());
		driver.findElement(bannercarouseldot1).click();
		Thread.sleep(2000);
		softAssertion.assertTrue(websiteoptioninbanner.isDisplayed());
		websiteoptioninbanner.click();	
		softAssertion.assertAll();
	}

	public void verifyBannerCarousel2mobileoption() throws InterruptedException
	{ 
		SoftAssert softAssertion = new SoftAssert();
		if(mobileoptioninbanner.isDisplayed())
		{
			mobileoptioninbanner.click();
		}
		else {
			softAssertion.assertTrue(driver.findElement(bannercarouseldot1).isDisplayed());
			driver.findElement(bannercarouseldot1).click();
			Thread.sleep(2000);
			softAssertion.assertTrue(mobileoptioninbanner.isDisplayed());
			mobileoptioninbanner.click();
		}
		
		softAssertion.assertAll();
	}
	
	public void verifyBannerCarousel3() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(bannercarouseldot2).isDisplayed());
		driver.findElement(bannercarouseldot2).click();
		Thread.sleep(2000);
		softAssertion.assertTrue(linkincarousel3.isDisplayed());
		linkincarousel3.click();
		softAssertion.assertAll();
	}
	
	public void verifyBannerCarousel4() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(bannercarouseldot3).isDisplayed());
		driver.findElement(bannercarouseldot3).click();
		Thread.sleep(2000);
		softAssertion.assertTrue(linkincarousel4.isDisplayed());
		linkincarousel4.click();
		softAssertion.assertAll();
	}
	
	public void verifyBannerCarousel5() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(bannercarouseldot4).isDisplayed());
		driver.findElement(bannercarouseldot4).click();
		Thread.sleep(2000);
		softAssertion.assertAll();
	}
	
	public void verifyMyAccountFAQTile() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(myaccountfaqlearnmorebtn.isDisplayed());
		myaccountfaqlearnmorebtn.click();
		Thread.sleep(2000);
	}
	
	public void verifyoption(WebElement opt, String quicklinkurl, String parenturl ) throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(opt.isDisplayed());
		opt.click();
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(), quicklinkurl);
		driver.navigate().back();
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(), parenturl);
		Thread.sleep(3000);
		if(cslandingpopupclosebtn.isDisplayed())
		{
			verifyCloseBtn();
		}
		softAssertion.assertAll();
	}
	
	public void verifyQuickLinks() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,420)");
		verifyoption(kycproofs,"https://www.hdfclife.com/customer-service/list-of-kyc-proofs",
				"https://www.hdfclife.com/customer-service");
		verifyoption(formsanddownload,"https://www.hdfclife.com/customer-service/forms-and-download",
				"https://www.hdfclife.com/customer-service");
		verifyoption(demat,"https://www.hdfclife.com/customer-service/about-demat",
				"https://www.hdfclife.com/customer-service");
		verifyoption(newbusinessrelated,"https://www.hdfclife.com/customer-service/new-business",
				"https://www.hdfclife.com/customer-service");
		verifyoption(taxation,"https://www.hdfclife.com/customer-service/taxation",
				"https://www.hdfclife.com/customer-service");
		verifyoption(bonus,"https://www.hdfclife.com/customer-service/bonus",
				"https://www.hdfclife.com/customer-service");
		verifyoption(keyfeaturesdocument,"https://www.hdfclife.com/customer-service/key-feature-document",
				"https://www.hdfclife.com/customer-service");
		verifyoption(trackservicerequest,"https://myaccount.hdfclife.com/portal.do?_pageid=SRTracking&_portalid=cpSRTrackLink",
				"https://www.hdfclife.com/customer-service");
		verifyoption(ivr,"https://www.hdfclife.com/customer-service/interactive-voice-response",
				"https://www.hdfclife.com/customer-service");
		verifyoption(paypremium,"https://www.hdfclife.com/customer-service/pay-premium",
				"https://www.hdfclife.com/customer-service");		
		
	}
	
	public void verifyFAQpopup() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		softAssertion.assertTrue(faqques.isDisplayed());
		faqques.click();
		Thread.sleep(2000);
		softAssertion.assertTrue(firstfaqpopupclosebtn.isDisplayed());
		firstfaqpopupclosebtn.click();
		Thread.sleep(2000);
		
	}
	
	public void verifyButtonsOnTiles() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		verifyoption(learnmorebtns.get(0), "https://www.hdfclife.com/customer-service/myaccount-faq", 
				"https://www.hdfclife.com/customer-service");
		verifyoption(learnmorebtns.get(1), "https://www.hdfclife.com/customer-service/pay-premium", 
				"https://www.hdfclife.com/customer-service");
		js.executeScript("window.scrollBy(0,300)");
		verifyoption(learnmorebtns.get(2), "https://www.hdfclife.com/customer-service/my-personal-details", 
				"https://www.hdfclife.com/customer-service");
		verifyoption(loginbtns.get(0),"https://myaccount.hdfclife.com/","https://www.hdfclife.com/customer-service");
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		verifyoption(learnmorebtns.get(3), "https://www.hdfclife.com/customer-service/my-policy", 
				"https://www.hdfclife.com/customer-service");
		verifyoption(learnmorebtns.get(4), "https://www.hdfclife.com/customer-service/payouts-related", 
				"https://www.hdfclife.com/customer-service");
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(3000);
		verifyoption(learnmorebtns.get(5), "https://www.hdfclife.com/customer-service/claims", 
				"https://www.hdfclife.com/customer-service");
		verifyoption(learnmorebtns.get(6), "https://www.hdfclife.com/customer-service/grievance-redressal", 
				"https://www.hdfclife.com/customer-service");
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		verifyoption(loginbtns.get(1), "https://www.hdfclife.com/group-insurance-plans/customer-service", 
				"https://www.hdfclife.com/customer-service");
		verifyoption(learnmorebtns.get(7), "https://www.hdfclife.com/customer-service/contact-us", 
				"https://www.hdfclife.com/customer-service");
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		verifyoption(learnmorebtns.get(8), "https://www.hdfclife.com/customer-service/digital-chatbot", 
				"https://www.hdfclife.com/customer-service");
	}
	
	
	public void clickAadharBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(2000);
		softAssertion.assertTrue(aadharclickherebtn.isDisplayed());
		aadharclickherebtn.click();
		Thread.sleep(2000);
	}
	
	public void clickContactUsBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(2000);
		softAssertion.assertTrue(contactusbtn.isDisplayed());
		contactusbtn.click();
		Thread.sleep(2000);
	}
}

