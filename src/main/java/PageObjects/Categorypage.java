package PageObjects;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class Categorypage extends BaseClass{
	static SoftAssert softAssertion = new SoftAssert();
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

	@FindBy(xpath="(//a[@class='siteButton outlinedBtn learMoreBtn dataLayerBtnClick'])[1]")
	WebElement c2pllearnmorebtn;

	@FindBy(xpath="(//a[@class='dwnldLink dataLayerBtnClick'])[1]")
	WebElement c2pldowbloadbrochure;
	
	@FindBy(xpath="(//a[@class='siteButton buyOnlineBtn dataLayerBtnClick'])[1]")
	WebElement c2plbuyonlinebtn;
	
	@FindBy(xpath="(//a[@class='siteButton outlinedBtn learMoreBtn dataLayerBtnClick'])[2]")
	WebElement sjblearnmorebtn;
	
	@FindBy(xpath="(//a[@class='siteButton buyOnlineBtn dataLayerBtnClick'])[2]")
	WebElement sjbbuyonlinebtn;
	
	@FindBy(xpath="(//a[@class='bannerAdBtn siteButton'])[1]")
	WebElement letscalculate;
	
	@FindBy(xpath="(//a[@class='viewMoreBtn'])[1]")
	WebElement whysectionviewmorebtn;
	
	@FindBy(xpath="(//a[@class='viewMoreBtn viewLessBtn'])[1]")
	WebElement whysectionviewlessbtn;
	
	
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
		driver.navigate().back();
		Thread.sleep(3000);
	}

	public WebElement c2plLearnMoreBtn()
	{
		return c2pllearnmorebtn;
	}

	public void clickC2plLearnMoreBtn() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(c2pllearnmorebtn));
		c2pllearnmorebtn.isDisplayed();
		c2pllearnmorebtn.click();

		Thread.sleep(3000);
	}

	public void downloadBrochure()
	{
		c2pldowbloadbrochure.click();
	}

	public static Boolean isFileDownloaded(String fileName) throws InterruptedException {
		Thread.sleep(3000);
		boolean flag = false;
		//paste your directory path below
		//eg: C:\\Users\\username\\Downloads
		File []listOfFiles= folder.listFiles();
		if (listOfFiles.length == 0 || listOfFiles == null) {
			System.out.println("The directory is empty");
			flag = false;
		} else {
			for (File listFile : listOfFiles) {
				if (listFile.getName().contains(fileName)) {
					System.out.println(fileName + " is present");
				}
				else {
					System.out.println(fileName + " is incorrect");	
					break;
				}
				flag = true;
			}
		}
		return flag;
	}


	public void deleteFolder()
	{
		for(File file : folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}
	
	public void clickC2plBuyNowBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(c2plbuyonlinebtn.isDisplayed());
		c2plbuyonlinebtn.click();
	}
	
	public void clickSJBLearnMorebtn() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(sjblearnmorebtn.isDisplayed());
		sjblearnmorebtn.click();
	}
	
	public void clickSJBBuyOnlineBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(sjbbuyonlinebtn.isDisplayed());
		sjbbuyonlinebtn.click();
	}
	
	public void clickLetsCalculateBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		softAssertion.assertTrue(letscalculate.isDisplayed());
		letscalculate.click();
	}
	
	public void verifyWhyViewMoreAndViewLess() throws InterruptedException
	{
		softAssertion.assertTrue(whysectionviewmorebtn.isDisplayed()); // verify on page load
		whysectionviewmorebtn.click();
		Thread.sleep(3000);
		if(whysectionviewlessbtn.isDisplayed()) {
			whysectionviewlessbtn.click();
			Thread.sleep(3000);
			softAssertion.assertTrue(whysectionviewlessbtn.isDisplayed());
			}
		else {
			softAssertion.fail("View Less button is not getting displayed in Why section after clicking on view more");
		}
		softAssertion.assertAll();
	}
}



