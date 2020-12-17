package Main;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class AvailableRequestTest {
	
	private WebDriver driver;
	private By txtUserName = By.id("user");
	private By txtPassword = By.id("pass");
	private By btnLogin = By.id("btn_login");
	
	private By pageTitleText = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/h2");
	private By partTypeddl = By.id("parttype");
	private By biddingStatusddl = By.id("statusdrop");
	private By winningStatusddl = By.id("typedrop");
	
	private By openbiddingdatebtn= By.id("duereportrange");
	private By calenderleft = By.xpath("/html/body/div[7]/div[1]/div[2]");
	//private By biddingdate_start = By.name("daterangepicker_start");
//	private By biddingdate_end = By.name("daterangepicker_end");
	
	//private By biddingsmonthddl = By.xpath("/html/body/div[7]/div[1]/div[2]/table/thead/tr[1]/th[3]/select[1]");
	private By txtSearch = By.xpath("//*[@id=\"crud-main-datatable_filter\"]/label/input");
	private By currentMonth = By.xpath("/html/body/div[7]/div[1]/div[2]/table/thead/tr[1]/th[3]/select[1]");
	
	
	public void ClearFields()
	{
		driver.findElement(biddingStatusddl).clear();
		driver.findElement(txtSearch).clear();
		driver.findElement(calenderleft).clear();
		driver.findElement(winningStatusddl).clear();
		driver.findElement(openbiddingdatebtn).clear();
		driver.findElement(partTypeddl).clear();
		driver.findElement(currentMonth).clear();
	}
	
	
	@BeforeTest
	//@Test(priority = 0)
	public void NavigateToSparePartRequestPage() 
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
	//	driver.get("https://www.trademartlk.com/operation/dashboard/request-management");
		String expectedTitle ="Sparepart Requests";
		String actualTitle = driver.findElement(pageTitleText).getText();
		assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test(priority = 3,description = "Verify the user can select sparepart type in the designed field selector")
	public void TMS_AR_009()
	{
		try {
			
			ClearFields();
			Select typedropdown = new Select(driver.findElement(partTypeddl));
			typedropdown.selectByValue("3");
			WebElement option = typedropdown.getFirstSelectedOption();
			String actualSelectedType = option.getText();
			System.out.println("Parttype selected value is " +actualSelectedType);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}
	
	@Test(priority = 4,description = "Verify the user can select bidding status  in the designed field selector")
	public void TMS_AR_0010()
	{
		try {
			ClearFields();
			Select biddingstatusdropdown = new Select(driver.findElement(biddingStatusddl));
			biddingstatusdropdown.selectByValue("PENDING");
			WebElement option = biddingstatusdropdown.getFirstSelectedOption();
			String actualSelectedStatus = option.getText();
			System.out.println("Bidding status selected value is " +actualSelectedStatus);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
	}
	
	@Test(priority = 5,description = "Verify the user can select winning  status  in the designed field selector")
	public void TMS_AR_0012()
	{
		try {
			ClearFields();
			Select winningstatusdropdown = new Select(driver.findElement(winningStatusddl));
			winningstatusdropdown.selectByValue("RESTAURANT");
			WebElement option = winningstatusdropdown.getFirstSelectedOption();
			String actualSelectedStatus = option.getText();
			System.out.println("Bidding status selected value is " +actualSelectedStatus);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
	}
	
//	@Test(priority = 6,description = "Verify the user can select bidding date  in the designed datefield")
//	public void TMS_AR_0014()
//	{
	//	try {
			//11/10/2020    
		//	var dateToStart = LocalDate.of(2020,Month.NOVEMBER,10);
			
			//select start date
			
			//verify
				 
			
	//	} catch (Exception e) {
			// TODO: handle exception
		//	System.out.println(e);
	//	}		
//	}
	
	@Test(priority = 7,description = "Verify the user can enter data to search in the designed textfield")
	public void TMS_AR_0016()
	{
		try {
			ClearFields();
			
			String expectedSearchText ="Nissan";
			WebElement searchTextBox = driver.findElement(txtSearch);
			searchTextBox.sendKeys("Nissan");
			String actualSearchText =driver.findElement(txtSearch).getAttribute("value");
			assertEquals(actualSearchText, expectedSearchText);			
			System.out.println("Actual Search data is "+ actualSearchText);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
	}
	
	@Test(priority = 8,description = "Verify the calendar component is active when the bidding date textboxes are clicked.")
	public void TMS_AR_0017()
	{
		try {
			ClearFields();
			driver.findElement(openbiddingdatebtn).click();
			var calender = driver.findElement(calenderleft);
			if(calender.isDisplayed())
			{
				System.out.println("calender is diplayed");
			}
			else
			{
				System.out.println("calender is not diplayed");
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
	}
	
//	@Test(priority = 9,description = "Verify if the calendar component allows to select month field forward and backward.")
//	public void TMS_AR_0020(LocalDate  date)
//	{
	//	try {
			//get current month
		//	var currentPeriod = getCurrentPeriod();
			
			//compare current with destination
			//long month = (long) ChronoUnit.MONTHS.between(currentPeriod, date.withDayOfMonth(1));
	   // }

			
			
		//catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e);
	//	}		
	//}
	
	public LocalDate getCurrentPeriod() {
		ClearFields();
		var CurrentMonth = driver.findElement(currentMonth).getText().split("");
		return LocalDate.of(
				Integer.parseInt(CurrentMonth[1]), 
				Month.valueOf(CurrentMonth[0]),
				LocalDate.now().getDayOfMonth());
	}
	
//	@Test(priority = 10,description = "Verify if the calendar component loads properly after click on any date box.")
//	public void TMS_AR_0018(LocalDate  date)
//	{
//		try {
//	    }
//
//			
//			
//		catch (Exception e) {
//			
//		}		
//	}
//	@Test(priority = 12,description = "Verify if the prev and next links are navigable in the date picker control.")
//	public void TMS_AR_0021(LocalDate  date)
//	{
//		try {
//	    }
//
//			
//			
//		catch (Exception e) {
//			
//		}		
//	}
	
//	@Test(priority = 13,description = "Verify if the calendar component allows 2 years forward and 1 year backward to select the dates.")
//	public void TMS_AR_0022(LocalDate  date)
//	{
//		try {
//	    }
//
//			
//			
//		catch (Exception e) {
//			
//		}		
//	}
//	@Test(priority = 14,description = "Verify if the calendar component  allows to select  hour field forward and backward.")
//	public void TMS_AR_0023(LocalDate  date)
//	{
//		try {
//	    }
//
//			
//			
//		catch (Exception e) {
//			
//		}		
//	}

//	@Test(priority = 15,description = "Verify if the calendar component  allows to select  minutes field forward and backward.")
//	public void TMS_AR_0024(LocalDate  date)
//	{
//		try {
//	    }
//
//			
//			
//		catch (Exception e) {
//			
//		}		
//	}
	
	//@Test(priority = 16,description = "Verify if the calendar component  allows to select 00 to 50  minutes field.")
	//public void TMS_AR_0025(LocalDate  date)
	///{
		//try {
	  //  }

			
			
		//catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e);
		//}		
	//}
	
	
	
	@Test(priority = 20,description = "Verify search response for a large but valid strings")
	public void TMS_AR_0033()
	{
		try {
			ClearFields();
			String expectedSearchText ="Nissan Microcar Head Light 2020";
			WebElement searchTextBox = driver.findElement(txtSearch);
			searchTextBox.clear();
			searchTextBox.sendKeys("Nissan Microcar Head Light 2020");
			String actualSearchText =driver.findElement(txtSearch).getAttribute("value");
			assertEquals(actualSearchText, expectedSearchText);			
			System.out.println("Actual long Search data is "+ actualSearchText);
	    }

			
			
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
	}
	
	
	
	
	
	
	
	
	@AfterTest
	//@Test(priority = 20)
	public void AfterTestRun()
	{
		driver.quit();
	}
	
	
	
	
	
  
}
