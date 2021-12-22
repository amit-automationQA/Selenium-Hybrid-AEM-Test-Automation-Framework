package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.WebEventListener;

public class BaseClass {
	public WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TakesScreenshot ts;
	//public static String downloadPath = System.getProperty("user.dir") + "\\Downloaded";
	//https://stackoverflow.com/questions/50143872/how-to-auto-set-chromedriver-path
	public static File folder;
	//String projectpath= System.getProperty("user.dir");

	public void initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\configFiles\\config.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");

		folder = new File(UUID.randomUUID().toString());
		if (browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup(); //https://www.youtube.com/watch?v=tdA3tSl0jUg
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); // code from developer chrome website
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", folder.getAbsolutePath());// to download any file in project directory only*/
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications"); // Disabled notifications popup
			options.addArguments("--incognito");
			options.addArguments("--start-maximized"); // https://stackoverflow.com/a/26283818/1689770
			options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770 -->> comment to disable automation message in browser
			options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
			options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
			options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
			//options.setExperimentalOption("useAutomationExtension", false);
			//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			options.setExperimentalOption("prefs", chromePrefs);
			options.setCapability("chrome.binary",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			options.setCapability(ChromeOptions.CAPABILITY, options);
			driver= new ChromeDriver(options);
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
		}

		else if(browsername.equals("firefox")) //http://kb.mozillazine.org/About:config_entries
		{
			WebDriverManager.firefoxdriver().setup(); //https://www.youtube.com/watch?v=tdA3tSl0jUg
			WebDriverManager.firefoxdriver().getDownloadedDriverPath();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "FirefoxLogsforeveryexecution.txt");
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			FirefoxOptions options = new FirefoxOptions();
			//Prerequisite : Create Firefox profile with command firefox -p profilemanager
			//https://www.youtube.com/watch?v=ilwlp8iI4xc
			ProfilesIni profini= new ProfilesIni(); 
			FirefoxProfile prof= profini.getProfile("AutomationAEM");
			options.setProfile(prof);
			prof.setPreference("dom.webnotifications.enabled", false);
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			//prof.setPreference("browser.download.useDownloadDir", true);
			prof.setPreference("browser.download.dir", folder.getAbsolutePath());
			prof.setPreference("browser.download.folderList",2);
			prof.setPreference("browser.download.viewableInternally.enabledTypes", "");
			prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;text/plain;application/text;text/xml;application/xml");
			//prof.setPreference("browser.helperApps.alwaysAsk.force", false);
			prof.setPreference("pdfjs.disabled", true);  // disable the built-in PDF viewer
			prof.setPreference("javascript.enabled", true);
			/*options.addPreference("browser.download.useDownloadDir", true);
			options.addPreference("browser.download.folderList",2); //Use for the default download directory the last folder specified for a download
			options.addPreference("browser.download.dir", folder.getAbsolutePath());
			options.addPreference("browser.download.viewableInternally.enabledTypes", "");
			options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;text/plain;application/text;text/xml;application/xml");
			options.addPreference("pdfjs.disabled", true);  // disable the built-in PDF viewer
			options.addPreference("dom.webnotifications.enabled", false);
			options.addPreference("javascript.enabled", true);
			options.setCapability("marionette", true);
			options.addPreference("browser.link.open_newwindow", 3);
			options.addPreference("browser.link.open_newwindow.restriction", 0);
			//options.addPreference("browser.privatebrowsing.autostart", true);
			//options.setCapability("firefox.binary",System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
			//options.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);*/
			driver = new FirefoxDriver(options);
			//driver.manage().window().maximize();
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
		}
		else if(browsername.equals("edge")) //https://docs.microsoft.com/en-us/microsoft-edge/webdriver-chromium/?tabs=java
		{
			WebDriverManager.edgedriver().setup(); //https://www.youtube.com/watch?v=tdA3tSl0jUg
			//System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "\\Driver\\msedgedriver.exe");
			EdgeOptions options= new EdgeOptions();
			DesiredCapabilities capabilities = DesiredCapabilities.edge();
			HashMap<String, Object> edgeprefs = new HashMap<String, Object>(); // code from developer edge website
			edgeprefs.put("profile.default_content_settings.popups", 0);
			edgeprefs.put("download.default_directory", folder.getAbsolutePath());// to download any file in project directory only
			edgeprefs.put("profile.default_content_setting_values.notifications", 2); //https://www.linkedin.com/pulse/how-handle-browser-level-notification-using-selenium-webdriver-maske
			options.addArguments("--no-sandbox");
			options.addArguments("-inprivate"); 
			//https://stackoverflow.com/questions/61735197/cant-open-private-window-in-edge-browser-using-selenium
			options.addArguments("--disable-notifications");
	        options.addArguments("disable-infobars"); // disabling infobars
	        options.addArguments("--disable-extensions"); // disabling extensions
	        options.addArguments("--disable-gpu"); // applicable to windows os only
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--start-maximized");
	        options.addArguments("enable-automation"); 
	        options.setExperimentalOption("prefs", edgeprefs);
	        //options.addArguments("--headless");
			options.merge(capabilities);
			capabilities.setCapability(EdgeOptions.CAPABILITY, options);
			driver= (EdgeDriver)new EdgeDriver(options); 
			options.setBinary(System.getProperty("user.dir") + "\\Driver\\msedgedriver.exe");
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
		}
		
		//return driver;
	}
	public String getScreenShotPath(String testcasename, WebDriver driver) throws IOException
	{

		ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir")+"\\Screenshots\\"+testcasename+System.currentTimeMillis() +".png";
		FileUtils.copyFile(source, new File(destinationfile));
		return destinationfile;
	}
	//SauceLabs credentials
	//email: kundaramit55@gmail.com [Sign in via Google]
	//Expiry date for free trial: 28/12/2021
	//After expiry date please create saucelabs account and replace username, access key and url with saucelabs >> usersettings
	public static final String AUTOMATE_USERNAME = "oauth-kundaramit55-b543a";
	public static final String AUTOMATE_ACCESS_KEY = "82029b88-45ca-4364-ae80-24d72e4eff95";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";


	public void SauceLabs_Invocation() throws MalformedURLException, IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\configFiles\\config.properties");
		prop.load(fis);
		folder = new File(UUID.randomUUID().toString());
		//String baseurl = "https://benjerry.where2getit.com/";
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		ChromeOptions options1 = new ChromeOptions();
		//Map<String, Object> sauceOptions = new HashMap<>();
		//options1.setCapability("sauce:options", sauceOptions);
		options1.addArguments("--disable-notifications");
		options1.addArguments("--start-maximized");
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "92");
		caps.setCapability("resolution", "1920x1080");
		caps.setCapability("project", "AEM automation");
		caps.setCapability("build", "SauceLabs Test build");
		caps.setCapability("name", "SauceLabs Test suite");
		caps.setCapability(ChromeOptions.CAPABILITY, options1);
		driver = new RemoteWebDriver(new URL(URL), caps);
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Dimension dim = new Dimension(1920,1080);
		//driver.manage().window().setSize(dim);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
