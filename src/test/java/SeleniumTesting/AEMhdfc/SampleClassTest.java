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

import PageObjects.SampleClass;
import base.BaseClass;

public class SampleClassTest extends BaseClass{
	SampleClass sc;
	public static Logger log=LogManager.getLogger(SampleClass.class.getName());
	public SampleClassTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		initializeDriver();
		//SauceLabs_Invocation(); //uncomment if cross browser testing needs to be done
		sc= new SampleClass(driver);
		PageFactory.initElements(driver, sc);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ts = (TakesScreenshot) driver;
		log.info(" CEAT test cases started");

	}
	
	@Test
	public void footerTest() throws InterruptedException
	{
		sc.socialFooter();
		sc.footer2();
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
		log.info("CEAT test cases executed");
	}

}


