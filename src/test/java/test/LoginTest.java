package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\MockData.xlsx");
	String UserName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String Password = exlRead.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
//		LoginPage loginPage1 = new LoginPage(); //Page Object Model we can't use new keyword. Selenium offer us a class
//		call PageFactory and it contain some method. we need to chose the lastone.
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(UserName);
		loginPage.insertPassword(Password);
		loginPage.clickSignInButton();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.validateDashboardPage("Dashboard");
		
		BrowserFactory.tearDown();
	}
	

}
