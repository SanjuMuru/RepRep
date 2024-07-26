package genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import elementreporitory.HomePage;
import elementreporitory.LoginPage;


public class BaseTest {

	public DataUtility data_Utility = new DataUtility();
	public WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void launchTheBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(data_Utility.getDataFromProperties("url"));
	}

	@BeforeMethod(alwaysRun = true)
	public void performLogin() throws IOException {
		
		HomePage hp = new HomePage(driver);
		hp.getLoginLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmailTextFeild().sendKeys(data_Utility.getDataFromProperties("email"));
		lp.getPasswordTextFeild().sendKeys(data_Utility.getDataFromProperties("password"));
		lp.getLoginButton().click();
	}

	@AfterMethod(alwaysRun = true)
	public void performLogout() {
		
		HomePage hp = new HomePage(driver);
		hp.getLogoutLink().click();
	}

	@AfterClass(alwaysRun = true)
	public void closeTheBrowser() {
		driver.quit();
	}

}
