package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
