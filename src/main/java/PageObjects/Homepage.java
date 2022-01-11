package PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class Homepage extends BaseClass{

	//SoftAssert softAssertion = new SoftAssert();
	//https://stackoverflow.com/questions/59083170/single-soft-assertion-error-is-failing-subsequent-passed-scenarios
	//Reason why the above code was commented and softAssert is not declared globally
/*Your dataprovider powered @Test method is basically using one SoftAssert instance and then invoking an assertAll() for all data provider data set iterations using the same instance.
SoftAssert is designed to remember all assertions that have been recorded so far via calls to assertXXX.
To fix this problem you should be instantiating the SoftAssert object inside the @Test method*/
	public static Logger log=LogManager.getLogger(Homepage.class.getName());

	//Constructor
	public Homepage(WebDriver driver) { //Called WebDriver instance to avoid null pointer exception
		// TODO Auto-generated constructor stub
		this.driver=driver; // created driver instance in constructor for this class
		PageFactory.initElements(driver, this);
	}

//@FindBy and By
	By bannercarouseldot0 =By.xpath("//li[@data-slide-to='0']");
	By bannercarouseldot1= By.xpath("//li[@data-slide-to='1']");
	By bannercarouseldot2= By.xpath("//li[@data-slide-to='2']");
	By bannercarouseldot3 = By.xpath("//li[@data-slide-to='3']");
	By bannercarouseldot4 = By.xpath("//li[@data-slide-to='4']");
	By bannercarouselactiveimage = By.xpath("//div[@class='carousel-item active']//img[@class='bg-align']");
	By termplanblock = By.xpath("//a[@onclick='categoryBox(this)'][1]");
	By fixedmaturityplanblock=By.xpath("//a[@href='/savings-plans/sanchay-fixed-maturity-plan']//div");
	By savingplansblock = By.xpath("//a[@href='/savings-plans']//div");
	By retirementplansblock = By.xpath("//a[@href='/retirement-and-pension-plans']//div//h2[@class='h5']");
	By comboplansblock = By.xpath("//a[@class='tile']//div//span[@class='bg-Term_plans bg-plans-8']");
	By viewallbutton = By.xpath("//div[@class='viewall']");
	By childrenplansblock = By.xpath("//a[@href='/children-insurance-plans']//div");
	By healthplansblock= By.xpath("//a[@href='/health-insurance-plans']//div//h2[@class='h5']");
	By posplansblock =By.xpath("//a[@href='/savings-plans/pos-guaranteed-savings-plan']//div//h2[@class='h5']");
	By ulipplansblock= By.xpath("//a[@class='tile']//div//span[@class='bg-Term_plans bg-plans-4']");
	By groupplansblock = By.xpath("//a[@class='tile']//div//span[@class='bg-Term_plans bg-plans-9']");
	By disablednextarrow= By.xpath("//div[@class='swiper-button-next swiper-button-disabled']");
	By disabledpreviousarrow = By.xpath("//div[@class='swiper-button-prev swiper-button-disabled']");
	By mouseindicator= By.xpath("//img[@src='/content/dam/hdfclifeinsurancecompany/home/banner/mc.svg']");
	By brandLogo = By.xpath("//div[@class='headerWrap']//div[@class='logo']//a");
	By scheduleacallbutton = By.xpath("//button[@class='btn btn-primary btnred schedule-btn scb-data-layer']");
	By schedulecallpopupclosebutton = By.xpath("//span[@class='close-icon1']");
	By name = By.xpath("//input[@class='first-name']");
	By cnumber = By.xpath("//input[@class='modilewidth']");
	By submitbutton=By.id("scheduleCallBtn");
	By namevalidationerror= By.xpath("//span[contains(text(),'Please enter valid name')]");
	By mobilenumbervalidationerror= By.xpath("//span[contains(text(),'Please enter mobile number')]");
	By plansdropdownvalidationerror= By.xpath("//span[contains(text(),'Please select plan type')]");
	By schedulepopupcheckbox= By.className("scb-checkbox");
	By checkboxerrorvalidation= By.xpath("//span[@class='scb-checkbox-error error-txt']");
	By minimumnamevalidationerror = By.xpath("//span[contains(text(),'Field should contain minimum 3 and max 50 characters')]");
	By mobilenumbervalidationerror2 = By.xpath("//span[contains(text(),'Please enter valid mobile number')]");
	By currentagefield= By.xpath("(//input[@class='years'])[1]");
	By desiredretirementagefield= By.xpath("(//input[@class='years'])[2]");
	By monthlyexpensesfield= By.id("monthly-expenses");
	By insurancecoverfield= By.id("insurance-cover");
	By qualificationsdropdown = By.id("qualification");
	By liabilitiesdropdown= By.id("liabilities");
	By annualincomefield= By.id("annual-income");
	By calculatebutton2 = By.id("calculateHlv");
	By resultlifecoverrequiredtext = By.xpath("//p[contains(text(),'Your Required life cover to protect your family’s ')]");
	By c2pl= By.xpath("//div[@class='recomendPlans']//a[1]");
	By learnmorebutton= By.xpath("//a[@class='siteButton btnred']");
	By calculatorclosebtn = By.xpath("//span[@class='close-icon calculateClose']");
	By sanchayplusbuynow= By.xpath("//a[@data-button-name='BUY NOW']");
	By disclaimeraccordionexpanded= By.xpath("//a[@data-toggle='collapse']");
	By disclaimeraccordioncollapsed= By.xpath("//a[@class='collapsed']");
	By subscribeemailfield = By.className("emailAddress");
	By subscribebtn= By.id("subscribeButton");
	By emailsubscribemessage = By.xpath("//span[@class='message-success-subscribe']");
	By appleicon = By.xpath("//a[@class='appleIcon']");
	By androidicon= By.xpath("(//a[@data-position='Download App Icon'])[2]");
	By allfootercss = By.cssSelector(".wrapper.footerMenuSec a");


	@FindBy(how=How.ID,using="insurance_category")
	WebElement plansdropdown;	

	@FindBy(how=How.XPATH,using="//div[@class='swiper-button-next']")
	WebElement nextarrow;

	@FindBy(how=How.XPATH,using="//div[@class='swiper-button-prev']")
	WebElement previousarrow;

	@FindBy(how=How.XPATH,using="//h5[contains(text(),'How Much Life Insurance')]")
	WebElement howmuchlifeinsuranceheader;

	@FindBy(how=How.XPATH,using="//button[@class='calculate-btn btn btn-primary btnred cal-data-layer']")
	WebElement letscalculatebutton;

	@FindBy(xpath="//section[@class='calculator-section calculateSection']//h2[1]")
	WebElement result;

	@FindBy(how=How.CSS,using=".stayConnectedSec.footerFormBlk a")
	List<WebElement> stayconnectedlinks;

	@FindBy(how=How.CSS,using=".wrapper.externalLinks a")
	List<WebElement> groupwebsites;
	
	@FindBy(how=How.CSS,using=".deskTopHeader a")
	List<WebElement> headerlinks;
	

	//Initialized objects
	public void verifyBannerCarouselDot0() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		driver.findElement(bannercarouseldot0).click();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(bannercarouselactiveimage).isDisplayed());
		softAssertion.assertAll();
	}

	public WebElement bannerCarouselDot0()
	{
		return driver.findElement(bannercarouseldot0);
	}
	public void verifyBannerCarouselDot1() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		driver.findElement(bannercarouseldot1).click();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(bannercarouselactiveimage).isDisplayed());
		softAssertion.assertAll();
	}
	
	public void verifyBannerCarouselDot2() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		driver.findElement(bannercarouseldot2).click();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(bannercarouselactiveimage).isDisplayed());
		softAssertion.assertAll();
	}

	public void verifyBannerCarouselDot3() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		driver.findElement(bannercarouseldot3).click();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(bannercarouselactiveimage).isDisplayed());
		softAssertion.assertAll();
	}

	public void verifyBannerCarouselDot4() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		driver.findElement(bannercarouseldot4).click();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(bannercarouselactiveimage).isDisplayed());
		softAssertion.assertAll();
	}
	
	public void clickTermPlanBlock() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(termplanblock).click();
	}

	public void clickFixedMaturityPlanBlock() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(fixedmaturityplanblock).isDisplayed());
		driver.findElement(fixedmaturityplanblock).click();
		softAssertion.assertAll();
	}

	public void clickSavingPlansBlock() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(savingplansblock).isDisplayed());
		driver.findElement(savingplansblock).click();
		softAssertion.assertAll();
	}

	public void clickRetirementPlansBlock() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(retirementplansblock).isDisplayed());
		driver.findElement(retirementplansblock).click();
		softAssertion.assertAll();
	}

	public void clickUlipPlansBlock() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(ulipplansblock).isDisplayed());
		driver.findElement(ulipplansblock).click();
		softAssertion.assertAll();
	}


	public void clickViewAllBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(viewallbutton).isDisplayed());
		driver.findElement(viewallbutton).click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	public void clickChildrenPlansBlock() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(childrenplansblock).isDisplayed());
		driver.findElement(childrenplansblock).click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	public void clickHealthPlansBlock() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(healthplansblock).isDisplayed());
		driver.findElement(healthplansblock).click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}


	public void clickPosPlansBlock() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(posplansblock).isDisplayed());
		driver.findElement(posplansblock).click();
		Thread.sleep(3000);
		softAssertion.assertAll();	
	}

	public void clickNextArrow() throws InterruptedException
	{
		nextarrow.click();
		Thread.sleep(3000);
	}

	public WebElement comboplansblock()
	{
		return driver.findElement(comboplansblock);
	}

	public void clickComboPlansBlock() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(comboplansblock).isDisplayed());
		driver.findElement(comboplansblock).click();
		Thread.sleep(3000);
		softAssertion.assertAll();	
	}

	public void multipleClickNextArrow() throws InterruptedException
	{
		for(int narrow = 0; narrow<=4;narrow++)
		{
			if((nextarrow).isDisplayed())
			{
				(nextarrow).click();
				Thread.sleep(3000);
			}
		}
		Thread.sleep(3000);
	}
	public void clickGroupPlansBlock() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(groupplansblock).isDisplayed());
		driver.findElement(groupplansblock).click();
		Thread.sleep(3000);
		softAssertion.assertAll();	
	}

	public WebElement disablednextarrow()
	{
		return driver.findElement(disablednextarrow);
	}

	public void multipleClickPreviousArrow() throws InterruptedException
	{
		for(int parrow = 0; parrow<=4;parrow++)
		{
			if(previousarrow.isDisplayed())
			{
				previousarrow.click();
				Thread.sleep(3000);
			}
		}
		Thread.sleep(3000);
	}

	public WebElement disabledpreviousarrow()
	{
		return driver.findElement(disabledpreviousarrow);
	}

	public void clickpreviousarrow()
	{
		previousarrow.click();
	}

	public WebElement mouseindicator()
	{
		return driver.findElement(mouseindicator);
	}
	
	public void clickMouseIndicator() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(driver.findElement(mouseindicator).isDisplayed());
		Thread.sleep(3000);
		driver.findElement(mouseindicator).click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	public boolean displayNextArrow()
	{
		return nextarrow.isDisplayed();
	}

	public boolean enabledPreviousArrow()
	{
		return previousarrow.isEnabled();
	}

	public WebElement brandLogo()
	{
		return driver.findElement(brandLogo);
	}

	public WebElement clickScheduleACallButton()
	{
		return driver.findElement(scheduleacallbutton);
	}

	public void schedulepopupdata(String fullname, String contactnumber)
	{
		driver.findElement(name).sendKeys(fullname);
		driver.findElement(cnumber).sendKeys(contactnumber);
		Select plndropdown = new Select(plansdropdown);
		plndropdown.selectByValue("Health Plans");

	}

	public void closeScheduleCallPopup() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(schedulecallpopupclosebutton));
		driver.findElement(schedulecallpopupclosebutton).click();
		Thread.sleep(3000);
	}

	public WebElement submitButton()
	{
		return driver.findElement(submitbutton);
	}
	public WebElement schedulePopupCheckbox()
	{
		return driver.findElement(schedulepopupcheckbox);
	}

	public WebElement checkboxErrorValidation()
	{
		return driver.findElement(checkboxerrorvalidation);
	}

	public boolean checkboxErrorValidationDisplayed()
	{
		return driver.findElement(checkboxerrorvalidation).isDisplayed();
	}

	public void inputForNameAndNumberField(String fullname, String contactnumber)
	{
		driver.findElement(name).sendKeys(fullname);
		driver.findElement(cnumber).sendKeys(contactnumber);
	}

	public void invalidDataValidationErrorForNameAndNumber() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(minimumnamevalidationerror));
		softAssertion.assertTrue(driver.findElement(minimumnamevalidationerror).isDisplayed());
		softAssertion.assertEquals(driver.findElement(minimumnamevalidationerror).getText(),
				"Field should contain minimum 3 and max 50 characters");
		softAssertion.assertTrue(driver.findElement(mobilenumbervalidationerror2).isDisplayed());
		softAssertion.assertAll();
		Thread.sleep(3000);
	}
	public void scrollTillLetUsCalculate() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",howmuchlifeinsuranceheader);
		Thread.sleep(3000);

	}

	public void clickLetsCalculateButton() throws InterruptedException
	{
		letscalculatebutton.click();
		Thread.sleep(3000);
	}

	public void calculatorInputs(String age,String desiredretirementage, String annualincome, String monthlyexpenses,String insurancecover, String qualifications, String liabilities) throws InterruptedException
	{
		driver.findElement(currentagefield).sendKeys(age);
		driver.findElement(desiredretirementagefield).sendKeys(desiredretirementage);
		driver.findElement(annualincomefield).sendKeys(annualincome);
		driver.findElement(monthlyexpensesfield).sendKeys(monthlyexpenses);
		driver.findElement(insurancecoverfield).sendKeys(insurancecover);
		Select qualificationsdrpdwn = new Select(driver.findElement(qualificationsdropdown));
		qualificationsdrpdwn.selectByValue(qualifications);
		Select liabilitiesdrpdwn = new Select(driver.findElement(liabilitiesdropdown));
		liabilitiesdrpdwn.selectByValue(liabilities);
		Thread.sleep(3000);
	}

	public void clickCalculateButton2() throws InterruptedException
	{
		driver.findElement(calculatebutton2).click();
		Thread.sleep(3000);
	}

	public void verifyResultSection()
	{
		SoftAssert softAssertion = new SoftAssert();
		String totalresult = result.getText();
		softAssertion.assertEquals(totalresult, "₹ 12,39,952");
		softAssertion.assertTrue(driver.findElement(resultlifecoverrequiredtext).isDisplayed());
		softAssertion.assertTrue(driver.findElement(learnmorebutton).isDisplayed());
		softAssertion.assertAll();
	}

	public void verifyC2PLProductResult() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(c2pl).isDisplayed());
		driver.findElement(c2pl).click();;
		softAssertion.assertEquals(driver.getCurrentUrl(),
				"https://onlineinsurance.hdfclife.com/buy-online-term-insurance-plans/click-2-protect-life/basic-details?source=NW_C2PL_LetsCalc_HP&agentcode=00399206&language=en");
		driver.navigate().back();
		Thread.sleep(4000);
		softAssertion.assertAll();
	}

	public void verifyLearnMorebtn(String learnmoreurl) throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
	driver.findElement(learnmorebutton).click();
	softAssertion.assertEquals(driver.getCurrentUrl(),learnmoreurl);
	driver.navigate().back();
	Thread.sleep(3000);
	softAssertion.assertAll();
	}
	
	public void clickCalculatorCloseBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(calculatorclosebtn).isDisplayed());
		driver.findElement(calculatorclosebtn).click();
		Thread.sleep(3000);
		softAssertion.assertAll();		
	}

	public void clickSanchayPlusBuyNow() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(sanchayplusbuynow).isDisplayed());
		driver.findElement(sanchayplusbuynow).click();	
		softAssertion.assertAll();
		Thread.sleep(3000);
	}

	public WebElement disclaimerAccordionOpened()
	{
		return driver.findElement(disclaimeraccordionexpanded);
	}

	public void scrollToDisclaimer()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2200)");
	}

	public WebElement disclaimerAccordionClosed()
	{
		return driver.findElement(disclaimeraccordioncollapsed);
	}

	public void openCloseDisclaimer() throws InterruptedException
	{
		Thread.sleep(3000);
		if(driver.findElement(disclaimeraccordionexpanded).isDisplayed())
		{
			driver.findElement(disclaimeraccordionexpanded).click();
			Thread.sleep(3000);
		}
		else
		{
			driver.findElement(disclaimeraccordioncollapsed).click();
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
	}

	public WebElement subscribeEmailField()
	{
		return driver.findElement(subscribeemailfield);
	}

	public WebElement subscribeBtn()
	{
		return driver.findElement(subscribebtn);
	}

	public void inputTestEmail(String email)
	{
		driver.findElement(subscribeemailfield).sendKeys(email);
	}
	
	public void verifySubScribeBtnOnClickOfField() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		driver.findElement(subscribeemailfield).click();
		softAssertion.assertTrue(driver.findElement(subscribebtn).isEnabled());
		Thread.sleep(3000);
	}
	
	public void emailPlaceholder()
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(driver.findElement(subscribeemailfield).getAttribute("placeholder"),"Enter your email id");
		softAssertion.assertAll();
	}
	
	public void verifyEmailSubscriptionSuccessfulMessage() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(emailsubscribemessage).isDisplayed());
		softAssertion.assertEquals(driver.findElement(emailsubscribemessage).getText(), "Thank you for subscribing to us.");
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

	public void appleIcon()
	{
		driver.findElement(appleicon).click();
	}

	public void androidIconClick()
	{
		driver.findElement(androidicon).click();
	}

	public void PopularandProductLinks() throws IOException
	{
		log.info("Popular and Product Listing Footer link check started");
		List<WebElement> links= driver.findElements(allfootercss);
		List<WebElement> activelinks = new ArrayList<WebElement>();
		for(int i=0; i<links.size();i++)
		{
			if(links.get(i).getAttribute("href") !=null && (! links.get(i).getAttribute("href").contains("javascript"))){
				activelinks.add(links.get(i));
			}
		}
		for(int j=0;j<activelinks.size();j++)
		{
			HttpsURLConnection connection= (HttpsURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			log.info(activelinks.get(j).getAttribute("href")+ "------>"+response);
		}	
		log.info("Popular and Product Listing Footer link check ended");
	}

	public void stayConnectedFooter() throws IOException
	{
		log.info("Stay Connected With Us Footer link check started");
		List<WebElement> stayconnected= stayconnectedlinks; 
		List<WebElement> activestayconnected = new ArrayList<WebElement>();
		for(int sociallink=0; sociallink<stayconnected.size();sociallink++)
		{
			if(stayconnected.get(sociallink).getAttribute("href") !=null && (! stayconnected.get(sociallink).getAttribute("href").contains("javascript"))){
				activestayconnected.add(stayconnected.get(sociallink));
			}
		}	
		for(int k=0;k<activestayconnected.size();k++)
		{
			HttpsURLConnection connection1= (HttpsURLConnection)new URL(activestayconnected.get(k).getAttribute("href")).openConnection();
			connection1.connect();
			String response = connection1.getResponseMessage();
			connection1.disconnect();
			log.info(activestayconnected.get(k).getAttribute("href")+ "------>"+response);
		}	
		log.info("Stay Connected With Us Footer link check ended");
	}

	public void groupWebsiteLinks() throws IOException
	{
		log.info("Group Websites link check started");	
		List<WebElement> groupwebsite= groupwebsites; 
		List<WebElement> activegw = new ArrayList<WebElement>();
		for(int websitelink=0; websitelink<groupwebsite.size();websitelink++)
		{
			if(groupwebsite.get(websitelink).getAttribute("href") !=null && (! groupwebsite.get(websitelink).getAttribute("href").contains("javascript"))){
				activegw.add(groupwebsite.get(websitelink));
			}
		}	

		for(int l=0;l<activegw.size();l++)
		{
			HttpURLConnection connection2= (HttpURLConnection)new URL(activegw.get(l).getAttribute("href")).openConnection();
			connection2.connect();
			String response = connection2.getResponseMessage();
			connection2.disconnect();
			log.info(activegw.get(l).getAttribute("href")+ "------>"+response);
		}	
		System.out.println("Group Websites link check ended");
	}

	public void verifyLinkOpenedInNewWindow(String childurl, String parenturl) throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it2=windows.iterator();
		String parentId= it2.next();
		String childId=it2.next();
		driver.switchTo().window(childId);
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(),childurl);
		driver.close();
		driver.switchTo().window(parentId);
		softAssertion.assertEquals(driver.getCurrentUrl(), parenturl);
		Thread.sleep(3000);
	}
	
	//Alternate code for the above method open link in new window
	//ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	// driver.switchTo().window(tabs2.get(1));
	// driver.close();
	// driver.switchTo().window(tabs2.get(0));

	public void verifyLink(String pageurl) throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(), pageurl);
		driver.navigate().back();
		softAssertion.assertAll();
		Thread.sleep(3000);
	}

	public void verifyValidationErrorForBlankSubmit()
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(driver.findElement(namevalidationerror).isDisplayed());
		softAssertion.assertEquals(driver.findElement(namevalidationerror).getText(), "Please enter valid name");
		softAssertion.assertTrue(driver.findElement(mobilenumbervalidationerror).isDisplayed());
		softAssertion.assertEquals(driver.findElement(mobilenumbervalidationerror).getText(), "Please enter mobile number");
		softAssertion.assertTrue(driver.findElement(plansdropdownvalidationerror).isDisplayed());
		softAssertion.assertEquals(driver.findElement(plansdropdownvalidationerror).getText(), "Please select plan type");
		softAssertion.assertAll();
	}

	public void verifyConsentCheckbox() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		if(driver.findElement(schedulepopupcheckbox).isSelected())
		{
			driver.findElement(schedulepopupcheckbox).click();
			Thread.sleep(3000);
			softAssertion.assertTrue(driver.findElement(checkboxerrorvalidation).isDisplayed());
		}
		else
		{
			softAssertion.fail();
			log.error("Consent checkbox is not checked when popup opens for first time");
			softAssertion.assertTrue(driver.findElement(checkboxerrorvalidation).isDisplayed());
		}
		softAssertion.assertAll();
	}
	
	public void verifyHeaderLinks() throws IOException, InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// softAssertion = new SoftAssert();
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		Thread.sleep(3000);
		log.info("Header link check started");
		List<WebElement> headerlink= headerlinks; 
		List<WebElement> activeheaderlink = new ArrayList<WebElement>();
		for(int hlink=0; hlink<headerlink.size();hlink++)
		{
			if(headerlink.get(hlink).getAttribute("href") !=null && (! headerlink.get(hlink).getAttribute("href").contains("javascript"))){
				activeheaderlink.add(headerlink.get(hlink));
			}
		}	
		for(int m=0;m<activeheaderlink.size();m++)
		{
			HttpsURLConnection connection1= (HttpsURLConnection)new URL(activeheaderlink.get(m).getAttribute("href")).openConnection();
			connection1.connect();
			String response = connection1.getResponseMessage();
			connection1.disconnect();
			log.info(activeheaderlink.get(m).getAttribute("innerText")+"with link"+activeheaderlink.get(m).getAttribute("href")+ "------>"+response);
		}	
		log.info("Header link check ended");
	}

}






