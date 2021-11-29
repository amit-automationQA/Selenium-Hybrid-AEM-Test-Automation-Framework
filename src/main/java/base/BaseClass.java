package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import util.WebEventListener;

public class BaseClass {
	public WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TakesScreenshot ts;
	//public static String downloadPath = System.getProperty("user.dir") + "\\Downloaded";
	public static File folder;
	//String projectpath= System.getProperty("user.dir");

	//@BeforeSuite
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\configFiles\\config.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		
		folder = new File(UUID.randomUUID().toString());
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); // code from developer chrome website
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", folder.getAbsolutePath());// to download any file in project directory only*/
            ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications"); // Disabled notifications popup
			options.addArguments("--start-maximized"); // https://stackoverflow.com/a/26283818/1689770
			options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
			options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
			options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
			options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
			options.setExperimentalOption("prefs", chromePrefs);
			capabilities.setCapability("chrome.binary",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver= new ChromeDriver(options);
			
		}
		
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		fis.close();
		return driver;
	}
	public String getScreenShotPath(String testcasename, WebDriver driver) throws IOException
	{

		ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir")+"\\Screenshots\\"+testcasename+System.currentTimeMillis() +".png";
		FileUtils.copyFile(source, new File(destinationfile));
		return destinationfile;
	}
	/*@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}*/
}
