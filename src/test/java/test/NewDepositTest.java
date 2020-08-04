package test;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewDepositTest {
	
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=login/");
		
		
	}
	@Test
	public void userShouldBeAbleToAddDeposit() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("abc123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name = 'login']")).click();
		Thread.sleep(3000);
		String expectedTitle = "Dashboard- TechFios Test Application - Billing";
//		xpath = //h2[contains(text(), 'Dashboard')]
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Dashboard page did not display!");
	
		
		By SALES_LOCATOR = By.xpath("//ul[@id='side-menu']//descendant::a[@href='#'][3]");
		By NEW_INVOICE_LOCATOR = By.linkText("New Invoice");
		
		//SELECT FOR DROP DOWN MENU
		driver.findElement(SALES_LOCATOR).click();
		waitForElement(NEW_INVOICE_LOCATOR, driver, 10);
		driver.findElement(NEW_INVOICE_LOCATOR).click();
		Select select = new Select(driver.findElement(By.cssSelector("select#duedate")));
		select.selectByVisibleText("+7 days");
		
		//Random rnd = new Random();
		//rnd.nextInt(999);
		
		//=new Random().nextInt(999);
		
		String ExpectedDescription = "AutomationTest" + new Random().nextInt(999);
		//System.out.println(ExpectedDescription);
		
		
		
//		driver.findElement(By.id("Description")).sendKeys(ExpectedDescription);
//		driver.findElement(By.id("Amount")).sendKeys("100000");
//		driver.findElement(By.id("Select")).click();
		
//		By TRANSACTION_MENU_LOCATOR = By.xpath("//ul[@id='side-menu']/descendant::span[text()='Transactions']");
//		By NEW_DEPOSIT_LOCATOR = By.linkText("New Deposit");
//		waitForElement(NEW_DEPOSIT_LOCATOR, driver, 10);
//		driver.findElement(NEW_DEPOSIT_LOCATOR).click();
//		Select select = new Select(driver.findElement(By.cssSelector("select#account")));
//		select.selectByVisibleText("Swimming");
		
		
		
	}
	
	
	private void waitForElement(By LOCATOR, WebDriver driver1, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LOCATOR));
		
		
	}
	@AfterMethod
	public void closeEverything() {
		
//		driver.close();
//		driver.quit();
	}
}
