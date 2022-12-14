package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage {
	
	public int generateRandomNo(int boundNo) {
		Random rnd = new Random();
		int generateNo = rnd.nextInt(boundNo);
		return generateNo;
	}
	
	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void pageVerification(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

}
