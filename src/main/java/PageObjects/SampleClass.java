package PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class SampleClass extends BaseClass{
	
	public SampleClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void socialFooter() throws InterruptedException
	{
		Thread.sleep(3000);
		//WebElement socialMediaLinks = driver.findElement(By.cssSelector(".social-link-wrap"));
		List<WebElement> socialmedialinkcollection = driver.findElements(By.cssSelector(".social-link-wrap a"));
		int noofsociallinks = socialmedialinkcollection.size();
		int smcount=0;
		for(int j=0; j<noofsociallinks;j++)
		{
			WebElement socialmedialink = socialmedialinkcollection.get(j);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);",socialmedialink);
			executor.executeScript("arguments[0].click();", socialmedialink);
			 Set<String> windows = driver.getWindowHandles();
			 Iterator<String>it2=windows.iterator();
			 String parentId= it2.next();
			 String childId=it2.next();
			 driver.switchTo().window(childId);
			 Thread.sleep(3000);
			driver.close();
			driver.switchTo().window(parentId);
		}
	}
	
public void footer2() throws InterruptedException
{
	List<WebElement> footer2linkcollection = driver.findElements(By.cssSelector(".top-footer-links.level-2 a"));
	int nooffooter2links = footer2linkcollection.size();
	int f2count=0;
	for(int k=0; k<nooffooter2links;k++)
	{
		WebElement footer2link = footer2linkcollection.get(k);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",footer2link);
		
		if (footer2link.getAttribute("innerText").equalsIgnoreCase("Register Warranty")) {
			footer2link.sendKeys(Keys.CONTROL+"t");
			executor.executeScript("arguments[0].click();", footer2link);
			
			}
			
			else
			{
				executor.executeScript("arguments[0].click();", footer2link);
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(2000);
			}
		
	}
}
	public void footer() throws InterruptedException {
		
		
		WebElement header1 = driver.findElement(By.xpath("//div[@class='cp-footer']"));
		List<WebElement> lin = header1.findElements(By.tagName("a"));

		int nooflinks = lin.size();
		System.out.println(" the number of link in section : " +nooflinks);

		int count=0;
		for(int i=0; i<nooflinks; i++) {
		WebElement header1New = driver.findElement(By.xpath("//div[@class='cp-footer']"));
		List<WebElement> linNew = header1New.findElements(By.tagName("a"));

		WebElement linkss = linNew.get(i);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",linkss);
		if (linkss.getAttribute("innerText").equalsIgnoreCase("Register Warranty")) {
		linkss.sendKeys(Keys.CONTROL+"t");
		executor.executeScript("arguments[0].click();", linkss);
		}
		
		else
		{
			executor.executeScript("arguments[0].click();", linkss);
		}
		

		Thread.sleep(3000);
		// for(int j = driver.getWindowHandles().size() -1 ; j > 0 ; j--){
		// String winHandle = driver.getWindowHandles().toArray()[j].toString();
		// driver.switchTo().window(winHandle);
		// driver.close();
		// }

		// Set<String> windows = driver.getWindowHandles();
		// Iterator<String>it2=windows.iterator();
		// String parentId= it2.next();
		// String childId=it2.next();
		// driver.switchTo().window(childId);
		// Thread.sleep(3000);
		//
		//
		//
		// //softAssertion.assertEquals(driver.getCurrentUrl(),childurl);
		// driver.close();
		// driver.switchTo().window(parentId);
		// //softAssertion.assertEquals(driver.getCurrentUrl(), parenturl);
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		String title =driver.getTitle();
		System.out.println(url+ "*** the page tiltle is :***" +title);

		if(title.contains("404")) {
		System.out.println("Broken link found");
		count++;
		}


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		if(count==0) {
		System.out.println("No Broken link found");
		}
		}



		} 


