package Main;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Action;

public class AvailableRequestTest {

	// get url
	public String baseURL = "https://www.trademartlk.com/operation/dashboard/supplier-login-sqag5";
	// define chromeDriver
	public WebDriver driver;

	@BeforeTest
	public void Startup() throws InterruptedException {
		// set system properties
		System.setProperty("webdriver.chrome.driver",
				"/home/hasindu/Videos/samadi/QAclass/SQAG5/SQAG5---Automation/TradeMartlk/LibraryFiles/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		// login to supplier portal using user name and password
		driver.findElement(By.id("user")).sendKeys("SQAG5");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("btn_login")).click();
		Thread.sleep(3000);
		// click the Operation tab in side bar
		WebElement operationTab = driver.findElement(By.xpath("//*[text()=' Operation ']/i"));
		operationTab.click();
		Thread.sleep(3000);
		// click the available request tab under operation side bar tab
		WebElement availableReqTab = driver.findElement(By.xpath("//*[text()='Available Requests']"));
		availableReqTab.click();
		Thread.sleep(3000);
	}

	@Test(priority = 1, description = "Verify the Spareparts Request page has header text")
	public void TMS_AR_0001() throws InterruptedException {
		Thread.sleep(3000);
		WebElement headerText = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/h2"));
		String actualText = headerText.getText();
		if (!actualText.isEmpty())
			System.out.println("Page header text is " + actualText);
		else
			System.out.println("Page header text is not displayed");
	}

	@Test(priority = 2, description = "Verify the Heading Text is spelled Correctly")
	public void TMS_AR_0003() throws InterruptedException {
		Thread.sleep(3000);
		// locate h2 element by text
		WebElement HeaderText = driver.findElement(By.xpath("//*[text()='Sparepart Requests']"));
		String actualHeaderText = HeaderText.getText();
		if (!actualHeaderText.isEmpty()) {
			String expectedHeaderText = "Sparepart Requests";
			AssertJUnit.assertEquals(actualHeaderText, expectedHeaderText);
			System.out.println("Actual page header  is " + actualHeaderText);
		} else
			System.out.println("Page header text is not displayed");
	}

	@Test(priority = 3, description = "verify the print screen display pressing the print button Properly.")
	public void TMS_AR_0004() throws InterruptedException {
		// click the print button
		Thread.sleep(3000);
		WebElement printButton = driver.findElement(By.cssSelector(".btn-print"));
		printButton.click();
		Thread.sleep(3000);
		// Store the current window handle
		String winHandle = driver.getWindowHandle();
		driver.switchTo().window(winHandle);
		if (!winHandle.isEmpty())
			System.out.println("Print Screen is displayed!");
		else
			System.out.println("Print screen is not displayed!");
	}

	@Test(priority = 4, description = "Verify the sparepart request page has a section for sparepart type")
	public void TMS_AR_0008() throws InterruptedException {
		// check the section is available for spare part type
		Thread.sleep(3000);
		WebElement sparepartTypeddl = driver.findElement(By.id("parttype"));
		if (sparepartTypeddl.isDisplayed())
			System.out.println("There is a section for the spare part type");
		else
			System.out.println("There is no section for the spare part type");
	}

	@Test(priority = 5, description = "Verify the sparepart request page has a section for Bidding status")
	public void TMS_AR_0009() throws InterruptedException {
		Thread.sleep(3000);
		// check the section is available for spare part type
		WebElement biddingStatusddl = driver.findElement(By.id("statusdrop"));
		if (biddingStatusddl.isDisplayed())
			System.out.println("There is a section for the bidding status");
		else
			System.out.println("There is no section for the bidding status");
	}

	@Test(priority = 6, description = "Verify the user can select sparepart type in the designed field selector")
	public void TMS_AR_0010() throws InterruptedException {
		Thread.sleep(3000);
		// select value from spare part type dropdown
		Select sparepartTypeddl = new Select(driver.findElement(By.id("parttype")));
		sparepartTypeddl.selectByVisibleText("Door");
		String actualSparepartTypeddl = sparepartTypeddl.getFirstSelectedOption().getText();
		String expectdSparepartTypeddl = "Door ";
		AssertJUnit.assertEquals(actualSparepartTypeddl, expectdSparepartTypeddl);
		Thread.sleep(3000);

	}

	@Test(priority = 7, description = "Verify the user can select bidding status in the designed field selector")
	public void TMS_AR_0011() throws InterruptedException {
		Thread.sleep(3000);
		// select value from bidding status dropdown
		Select biddingStatusddl = new Select(driver.findElement(By.id("statusdrop")));
		biddingStatusddl.selectByVisibleText("PENDING");
		String actualBiddingStatusddl = biddingStatusddl.getFirstSelectedOption().getText();
		System.out.println(actualBiddingStatusddl);
		String expectdBiddingStatusddl = "PENDING";
		AssertJUnit.assertEquals(actualBiddingStatusddl, expectdBiddingStatusddl);

	}

	@Test(priority = 8, description = "Verify the sparepart request page has a section for winning status")
	public void TMS_AR_0012() throws InterruptedException {
		Thread.sleep(3000);
		// check the section is available for winning status
		WebElement winningStatusddl = driver.findElement(By.id("typedrop"));
		if (winningStatusddl.isDisplayed())
			System.out.println("There is a section for the winning status");
		else
			System.out.println("There is no section for the winning status");

	}

	@Test(priority = 9, description = "Verify the user can select winning  status  in the designed field selector")
	public void TMS_AR_0013() throws InterruptedException {
		Thread.sleep(3000);
		// select value from winning status dropdown
		Select winningStatusddl = new Select(driver.findElement(By.id("typedrop")));
		winningStatusddl.selectByVisibleText("WON");
		String actualWinningStatusddl = winningStatusddl.getFirstSelectedOption().getText();
		System.out.println(actualWinningStatusddl);
		String expectdWinningStatusddl = "WON";
		AssertJUnit.assertEquals(actualWinningStatusddl, expectdWinningStatusddl);

	}

	@Test(priority = 10, description = "Verify the sparepart request page has a section for bidding date ")
	public void TMS_AR_0014() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDate = driver.findElement(By.id("duereportrange"));
		if (biddingDate.isDisplayed())
			System.out.println("There is a section for the bidding date");
		else
			System.out.println("There is no section for the bidding date");
	}

	@Test(priority = 11, description = "Verify the user can enter  from date  in the designed fromdatefield   and  to date field ")
	public void TMS_AR_0015() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDate = driver.findElement(By.id("duereportrange"));
		biddingDate.click();
		Thread.sleep(3000);
		// enter from date
		WebElement fromDateTextbox = driver.findElement(By.name("daterangepicker_start"));
		fromDateTextbox.sendKeys("11/10/2020");
		String expectedFromDate = "11/10/2020";
		String actualFromDate = fromDateTextbox.getText();
		System.out.println(actualFromDate);
		Assert.assertEquals(actualFromDate, expectedFromDate);
		Thread.sleep(3000);
		// enter to date
		WebElement toDateTextbox = driver.findElement(By.name("daterangepicker_end"));
		toDateTextbox.sendKeys("09/12/2020");
		String expectedToDate = "09/12/2020";
		String actualToDate = toDateTextbox.getText();
		AssertJUnit.assertEquals(actualToDate, expectedToDate);
	}

	@Test(priority = 12, description = "Verify the sparepart request page has a section for search   data ")
	public void TMS_AR_0016() throws InterruptedException {
		Thread.sleep(3000);
		// check the section is available for search data
		WebElement searchTextbox = driver
				.findElement(By.cssSelector("//*[@id='crud-main-datatable_filter']/label/input"));
		if (searchTextbox.isDisplayed())
			System.out.println("There is a section for the search");
		else
			System.out.println("There is no section for the search");
	}

	@Test(priority = 13, description = "verify the search available request by free text")
	public void TMS_AR_0017() throws InterruptedException {
		Thread.sleep(5000);
		WebElement searchTextbox = driver.findElement(By.xpath("//*[@id='crud-main-datatable_filter']/label/input"));

		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		// search spare part type
		Action searchTextPartType = (Action) builder.moveToElement(searchTextbox).click().sendKeys("Door").release()
				.build();
		searchTextPartType.perform();
		Thread.sleep(3000);
		System.out.println("search" + searchTextPartType);
		String actualSearchhPartType = searchTextbox.getText();
		String expectedSearchPartType = "Door";
		if (actualSearchhPartType.equalsIgnoreCase(expectedSearchPartType)) {
			System.out.println("Test Passed for search part type");
			searchTextbox.clear();
		} else
			System.out.println("search  text  part type is not enter");
		searchTextbox.clear();
		Thread.sleep(5000);

		// search bidding status
		Action searchTextBiddingStatus = (Action) builder.moveToElement(searchTextbox).click().sendKeys("DONE")
				.release().build();
		searchTextBiddingStatus.perform();
		Thread.sleep(3000);
		System.out.println("search" + searchTextBiddingStatus);
		String actualSearchhBiddingStatus = searchTextbox.getText();
		String expectedSearchBiddingStatus = "DONE";
		if (actualSearchhBiddingStatus.equalsIgnoreCase(expectedSearchBiddingStatus)) {
			System.out.println("Test Passed for search bidding status");
			searchTextbox.clear();
		} else
			System.out.println("search text bidding status is not enter");

		searchTextbox.clear();
		Thread.sleep(5000);
		// search winning status
		Action searchTextWinningStatus = (Action) builder.moveToElement(searchTextbox).click().sendKeys("WON").release()
				.build();
		searchTextWinningStatus.perform();
		Thread.sleep(5000);
		System.out.println("search" + searchTextBiddingStatus);
		String actualSearchhWinningStatus = ((WebElement) searchTextWinningStatus).getText();
		String expectedSearchWinningStatus = "WON";
		if (actualSearchhWinningStatus.equalsIgnoreCase(expectedSearchWinningStatus)) {
			System.out.println("Test Passed for search winning status");
			searchTextbox.clear();
		} else
			System.out.println("search text winning status is not enter");

		searchTextbox.clear();
		Thread.sleep(5000);
		Action searchTextBiddingDate = (Action) builder.moveToElement(searchTextbox).click().sendKeys("2020-11-13")
				.release().build();
		searchTextBiddingDate.perform();
		Thread.sleep(5000);
		System.out.println("search" + searchTextBiddingDate);
		String actualsearchTextBiddingDate = ((WebElement) searchTextWinningStatus).getText();
		String expectedsearchTextBiddingDate = "2020-11-13";
		Assert.assertEquals(actualsearchTextBiddingDate, expectedsearchTextBiddingDate);

		searchTextbox.clear();
		Thread.sleep(5000);
		Action searchTextBiddingDateTime = (Action) builder.moveToElement(searchTextbox).click().sendKeys("14:00")
				.release().build();
		searchTextBiddingDateTime.perform();
		Thread.sleep(5000);
		System.out.println("search" + searchTextBiddingDateTime);
		String actualsearchTextBiddingDateTime = ((WebElement) searchTextWinningStatus).getText();
		String expectedsearchTextBiddingDateTime = "14:00";
		Assert.assertEquals(actualsearchTextBiddingDateTime, expectedsearchTextBiddingDateTime);

		searchTextbox.clear();
		Thread.sleep(5000);
		Action searchText = (Action) builder.moveToElement(searchTextbox).click().sendKeys("Ni").release().build();
		searchText.perform();
		Thread.sleep(5000);
		System.out.println("search" + searchText);
		String actualsearchText = ((WebElement) searchTextWinningStatus).getText();
		String expectedsearchText = "14:00";
		Assert.assertEquals(actualsearchText, expectedsearchText);
		searchTextbox.clear();
		Thread.sleep(5000);
		Action searchNumber = (Action) builder.moveToElement(searchTextbox).click().sendKeys("12").release().build();
		searchNumber.perform();
		Thread.sleep(5000);
		System.out.println("search" + searchNumber);
		String actualsearchNumber = ((WebElement) searchTextWinningStatus).getText();
		String expectedsearchNumber = "14:00";
		Assert.assertEquals(actualsearchNumber, expectedsearchNumber);
	}

	@Test(priority = 14, description = "Verify if the bidding date picker today button click date should select today`s date")
	public void TMS_AR_0018() throws InterruptedException {
		// click bidding date
		Thread.sleep(3000);
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement todayButton = driver.findElement(By.linkText("Today"));
		todayButton.click();
		Thread.sleep(2000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("today is" + acutalEndDate);

	}

	@Test(priority = 15, description = "Verify if the bidding date picker tomorrow button click date should select tomorrow`s date")
	public void TMS_AR_0019() throws InterruptedException {
		Thread.sleep(300);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.cssSelector("#duereportrange"));
		biddingDateTextbox.click();
		WebElement tomorrowButton = driver.findElement(By.xpath("/html/body/div[7]/div[3]/ul/li[2]"));
		tomorrowButton.click();
		Thread.sleep(2000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("tomorrow  is" + acutalEndDate);

	}

	@Test(priority = 16, description = "Verify if the bidding date picker next 7 days button click date should select day adter 7 days")
	public void TMS_AR_0020() throws InterruptedException {
		// click bidding date
		Thread.sleep(3000);
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement next7DaysButton = driver.findElement(By.xpath("/html/body/div[7]/div[3]/ul/li[3]"));
		next7DaysButton.click();
		Thread.sleep(2000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("Next 7 days is" + acutalEndDate);

	}

	@Test(priority = 17, description = "Verify if the bidding date picker next 30 days button click date should select day after 30 days")
	public void TMS_AR_0021() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement next30DaysButton = driver.findElement(By.xpath("/html/body/div[7]/div[3]/ul/li[4]"));
		next30DaysButton.click();
		Thread.sleep(2000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("Next 30 days is" + acutalEndDate);

	}

	@Test(priority = 18, description = "Verify if the bidding date picker this month  button click date should select this month")
	public void TMS_AR_0022() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement thisMonthButton = driver.findElement(By.xpath("/html/body/div[7]/div[3]/ul/li[5]"));
		thisMonthButton.click();
		Thread.sleep(2000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("This month is" + acutalEndDate);
	}

	@Test(priority = 19, description = "Verify if the bidding date picker last month  button click date should select last month")
	public void TMS_AR_0023() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement lastMonthButton = driver.findElement(By.xpath("/html/body/div[7]/div[3]/ul/li[6]"));
		lastMonthButton.click();
		Thread.sleep(2000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("Last month is" + acutalEndDate);
	}

	@Test(priority = 20, description = "Verify if the bidding date picker last 7days  button click date should select last  7days")
	public void TMS_AR_0024() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement last7daysButton = driver.findElement(By.xpath("/html/body/div[7]/div[3]/ul/li[7]"));
		last7daysButton.click();
		Thread.sleep(2000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("Last 7 days is" + acutalEndDate);
	}

	@Test(priority = 21, description = "Verify if the bidding date picker yesterday  button click date should select yesterday")
	public void TMS_AR_0025() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement yesterdayButton = driver.findElement(By.xpath("/html/body/div[7]/div[3]/ul/li[8]"));
		yesterdayButton.click();
		Thread.sleep(2000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("Yesterday is" + acutalEndDate);
	}

	@Test(priority = 22, description = "Verify if the bidding date picker custom  button click display datepicker")
	public void TMS_AR_0026() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement customButton = driver.findElement(By.xpath("/html/body/div[7]/div[3]/ul/li[9]"));
		customButton.click();
		Thread.sleep(5000);
		WebElement selectDay = driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[2]/table/tbody/tr[5]/td[5]"));
		selectDay.click();
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("Custom selected day is" + acutalEndDate);
	}

	@Test(priority = 23, description = "Verify if the bidding date picker submit  button click submit the selected date/time")
	public void TMS_AR_0027() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement startDateText = driver.findElement(By.name("daterangepicker_start"));
		startDateText.sendKeys("12/05/2020");
		WebElement submitButton = driver.findElement(By.cssSelector(".applyBtn"));
		submitButton.click();
		Thread.sleep(5000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("selected day is" + acutalEndDate);
	}

	@Test(priority = 24, description = "Verify if the bidding date picker clear  button click clear the selected date/time")
	public void TMS_AR_0028() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		WebElement startDateText = driver.findElement(By.name("daterangepicker_start"));
		startDateText.sendKeys("12/05/2020");
		WebElement clearButton = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/button[2]"));
		clearButton.click();
		Thread.sleep(5000);
		String acutalEndDate = biddingDateTextbox.getText();
		System.out.println("selected day is" + acutalEndDate);

	}

	@Test(priority = 25, description = "Verify Selected \"Started\" Status Spare parts request supplier may add bid")
	public void TMS_AR_0029() throws InterruptedException {

		// Get table
		Thread.sleep(3000);
		WebElement dataTable = driver.findElement(By.id("crud-main-datatable"));
		Actions builder = new Actions(driver);
		Action clickFirstRow;
		// Get all rows
		List<WebElement> rows = dataTable.findElements(By.tagName("tr"));
		System.out.println("table rows " + rows.size());
		// Print data from each row
		for (WebElement row : rows) {
			String cols = row.findElement(By.xpath("//table/tbody/tr/td[6]")).getText();
			if (cols.equalsIgnoreCase("STARTED")) {
				System.out.println(cols);
				clickFirstRow = builder.doubleClick().build();
				break;
			} else
				System.out.println("Er");
		}
		// click make bid tab
		WebElement clickMyBidButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/nav/ul/li[3]/a"));
		clickMyBidButton.click();
		Thread.sleep(5000);

		// add bid price
		WebElement bidPriceText = driver.findElement(By.id("my-bid-price"));
		bidPriceText.sendKeys("4000");
		Thread.sleep(1000);
		// add warrenty
		WebElement warrentyText = driver.findElement(By.id("my-bid-warranty"));
		warrentyText.sendKeys("5 years");
		Thread.sleep(4000);
		// add Description
		WebElement descriptionText = driver.findElement(By.id("my-bid-description"));
		descriptionText.sendKeys("5 years");
		Thread.sleep(4000);

		// add return policy
		WebElement returnPolicyText = driver.findElement(By.id("my-bid-return"));
		returnPolicyText.sendKeys("refund accept ");
		Thread.sleep(4000);
		// add images
		WebElement imageText = driver.findElement(By.id("my-bid-img1"));
		imageText.sendKeys("/TradeMartlk/Images/sparepart.jpeg");
		Thread.sleep(4000);

//		WebElement saveButton = driver.findElement(By.id(id));
//		saveButton.click();
//		Thread.sleep(3000);

	}

	@Test(priority = 26, description = "Verify Selected \"Started\" Status Spare parts request supplier may modify bid")
	public void TMS_AR_0032() throws InterruptedException {

		// Get table
		Thread.sleep(3000);
		WebElement dataTable = driver.findElement(By.id("crud-main-datatable"));
		Actions builder = new Actions(driver);
		Action clickFirstRow;
		// Get all rows
		List<WebElement> rows = dataTable.findElements(By.tagName("tr"));
		System.out.println("table rows " + rows.size());
		// Print data from each row
		for (WebElement row : rows) {
			String cols = row.findElement(By.xpath("//table/tbody/tr/td[6]")).getText();
			if (cols.equalsIgnoreCase("STARTED")) {
				System.out.println(cols);
				clickFirstRow = builder.doubleClick().build();
				break;
			} else
				System.out.println("Er");
		}

//				WebElement editButton = driver.findElement(By.id(id));
//				editButton.click();
//				Thread.sleep(3000);

		// add bid price
//				WebElement bidPriceText = driver.findElement(By.id("my-bid-price"));
//				bidPriceText.sendKeys("1000");
//				Thread.sleep(1000);

		// add warrenty
		WebElement warrentyText = driver.findElement(By.id("my-bid-warranty"));
		warrentyText.sendKeys("5 years");
		Thread.sleep(1000);

		// add Description
		WebElement descriptionText = driver.findElement(By.id("my-bid-description"));
		descriptionText.sendKeys("5 years");
		Thread.sleep(1000);

		// add return policy
		WebElement returnPolicyText = driver.findElement(By.id("my-bid-return"));
		returnPolicyText.sendKeys("refund accept ");
		Thread.sleep(1000);

		// add images
		WebElement imageText = driver.findElement(By.id("my-bid-img1"));
		imageText.sendKeys("/TradeMartlk/Images/sparepart.jpeg");
		Thread.sleep(1000);

//				WebElement saveButton = driver.findElement(By.id(id));
//				saveButton.click();
//				Thread.sleep(3000);

	}

	@Test(priority = 27, description = "Verify Selected \"Started\" Status Spare parts request supplier may remove bid")
	public void TMS_AR_0033() throws InterruptedException {

		// Get table
		Thread.sleep(3000);
		WebElement dataTable = driver.findElement(By.id("crud-main-datatable"));
		Actions builder = new Actions(driver);
		Action clickFirstRow;
		// Get all rows
		List<WebElement> rows = dataTable.findElements(By.tagName("tr"));
		System.out.println("table rows " + rows.size());
		// Print data from each row
		for (WebElement row : rows) {
			String cols = row.findElement(By.xpath("//table/tbody/tr/td[6]")).getText();
			if (cols.equalsIgnoreCase("STARTED")) {
				System.out.println(cols);
				clickFirstRow = builder.doubleClick().build();
				break;
			} else
				System.out.println("Er");
		}

//		WebElement editButton = driver.findElement(By.id(id));
//		editButton.click();
//		Thread.sleep(3000);

	}

	@Test(priority = 28, description = "Verify the calendar component is active when the bidding date textboxes are clicked.")
	public void TMS_AR_0034() throws InterruptedException {

		// click bidding date
		Thread.sleep(3000);
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		Thread.sleep(3000);
		WebElement calenderComponent = driver.findElement(By.xpath("/html/body/div[7]"));
		if (calenderComponent.isEnabled()) {
			System.out.println("Calender Component is active");
		} else
			System.out.println("Calneder Component is inactive");

	}

	@Test(priority = 29, description = "Verify   if the calendar component allows to select month field forward and backward.")
	public void TMS_AR_0036() throws InterruptedException {

		// click bidding date
		Thread.sleep(3000);
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		Thread.sleep(3000);
		Select monthdropdown = new Select(driver.findElement(By.cssSelector("select.monthselect")));
		monthdropdown.selectByVisibleText("May");
		Thread.sleep(3000);
		String actualForwardSelectedMonth = monthdropdown.getFirstSelectedOption().getText();
		String expectedForwardSelectedMonth = "May";

		if (actualForwardSelectedMonth.contentEquals(expectedForwardSelectedMonth)) {
			System.out.println("Forward Selected Month is " + actualForwardSelectedMonth);
		}
		Thread.sleep(3000);
		monthdropdown.selectByVisibleText("July");
		Thread.sleep(3000);
		String actualBackwardSelectedMonth = monthdropdown.getFirstSelectedOption().getText();
		String expectedBackwardSelectedMonth = "May";
		if (actualForwardSelectedMonth.contentEquals(expectedBackwardSelectedMonth)) {
			System.out.println("Backward Selected Month is " + actualBackwardSelectedMonth);
		}

	}

	@Test(priority = 30, description = "verify if the prev and next links are navigable in the date picker control.")
	public void TMS_AR_0037() throws InterruptedException {
		Thread.sleep(3000);
		// click bidding date
		WebElement biddingDateTextbox = driver.findElement(By.id("duereportrange"));
		biddingDateTextbox.click();
		Thread.sleep(3000);

		// click < prev link
		WebElement prevLink = driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/table/thead/tr[1]/th[2]/i"));
		prevLink.click();
		Thread.sleep(3000);

		if (prevLink.isSelected()) {
			System.out.println("Prev Link is clciked!");
		}

		// click > next link
		WebElement nextLink = driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[2]/table/thead/tr[1]/th[4]/i"));
		prevLink.click();
		Thread.sleep(3000);

		if (nextLink.isSelected()) {
			System.out.println("Next Link is clciked!");
		}

	}

	@Test(priority = 31, description = "Verify Result grids column header spelling accuracy")
	public void TMS_AR_0052() throws InterruptedException {

		// Get table
		Thread.sleep(3000);
		WebElement dataTable = driver.findElement(By.id("crud-main-datatable"));
		// Get all rows
		List<WebElement> rows = dataTable.findElements(By.tagName("tr"));
		System.out.println("table rows " + rows.size());
		// Print data from each row
		for (WebElement row : rows) {
			String column = row.findElement(By.xpath("//table/thead/tr/th")).getText();
			if (column.equalsIgnoreCase("Date")) {
				System.out.println("Data table 1st column header is " + column);

			}
			if (column.equalsIgnoreCase("Code")) {
				System.out.println("Data table 1st column header is " + column);
			}
			if (column.equalsIgnoreCase("Bidding Starts(ed)")) {
				System.out.println("Data table 2nd column header is " + column);
			}
			if (column.equalsIgnoreCase("Bidding Ends(ed)")) {
				System.out.println("Data table 3rd column header is " + column);
			}
			if (column.equalsIgnoreCase("Spare Part")) {
				System.out.println("Data table 4th column header is " + column);
			}
			if (column.equalsIgnoreCase("Status")) {
				System.out.println("Data table 5th column header is " + column);
			} else
				System.out.println("Data table  column header undefine");
		}
		Thread.sleep(3000);
	}

	@Test(priority = 32, description = "Verify the sparepart request page has a section for display request information ")
	public void TMS_AR_0053() throws InterruptedException {
		WebElement requirementInformationSection = driver.findElement(By.linkText("Request Informations"));
		if (requirementInformationSection.isEnabled()) {
			System.out.println("There is a section for Requirement Information");
		} else
			System.out.println("There is no section for Requirement Information");
	}


	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
