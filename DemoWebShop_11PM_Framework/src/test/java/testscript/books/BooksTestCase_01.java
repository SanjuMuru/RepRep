package testscript.books;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import elementreporitory.HomePage;
import genericlibrary.BaseTest;
import genericlibrary.CommonUtility;

public class BooksTestCase_01 extends BaseTest{
	
	@Test
	public void verify_Books_Page_Is_Displayed() throws InterruptedException, EncryptedDocumentException, IOException {
		
		HomePage hp = new HomePage(driver);
		hp.getBooksLinks().click();
		String booksPageTitle = data_Utility.getDataFromExcel("Sheet2", 1, 1);
		
		Assert.assertEquals(driver.getTitle(), booksPageTitle);
		Reporter.log("BooksTestCase_01 Pass",true);
		
		CommonUtility cu = new CommonUtility();
		cu.captureScreenshot(driver, "BooksTestCase_01");
		
	}

}
