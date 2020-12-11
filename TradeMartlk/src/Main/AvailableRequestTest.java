package Main;

import static org.testng.Assert.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AvailableRequestTest {
	
	private WebDriver driver;
	private By txtUserName = By.id("user");
	private By txtPassword = By.id("pass");
	private By btnLogin = By.id("btn_login");
	
	private By pageTitleText = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/h2");
	
	
	
	
	
	@Test(priority = 0)
	public void NavigateToSparePartRequestPage() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","/home/hasindu/Videos/samadi/QAclass/SQAG5/SQAG5---Automation/TradeMartlk/LibraryFiles/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.trademartlk.com/operation/dashboard/supplier-login-sqag5");
		driver.manage().window().maximize();
		driver.findElement(txtUserName).sendKeys("SQAG5");
		driver.findElement(txtPassword).sendKeys("123456");
		driver.findElement(btnLogin).click();
		driver.get("https://www.trademartlk.com/operation/dashboard/request-management");
		
	}
	
	@Test(priority = 1,description = "Verify the Spareparts Request page has title text")
	public void TMS_AR_001()
	{
		driver.get("https://www.trademartlk.com/operation/dashboard/request-management");
		var pageTitle = driver.getTitle();
		if(!pageTitle.isEmpty())
		{
			System.out.println("Page title is displayed");
		}
		else
			System.out.println("Page title is not displayed");
		
		
		
	}
	
	@Test(priority = 2,description = "Verify the Heading Text is spelled Correctly")
	public void TMS_AR_003()
	{
		String expectedTitle ="Sparepart Requests";
		String actualTitle = driver.findElement(pageTitleText).getText();
		assertEquals(actualTitle, expectedTitle);
		
	}
	
	
	
	
	
	
	

}
