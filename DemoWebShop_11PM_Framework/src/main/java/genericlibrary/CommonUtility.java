package genericlibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonUtility {

	public void captureScreenshot(WebDriver driver, String fileName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./Screenshot/" + fileName + ".png");
		FileHandler.copy(src, trg);
	}

	public void alertAccept(WebDriver driver) {

		Alert alt = driver.switchTo().alert();
		alt.accept();

	}

	// Handle drop down
	// Handle Actions class
	// Pop-up

}
