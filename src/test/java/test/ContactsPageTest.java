package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.ContactsPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class ContactsPageTest {
	
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\MockData.xlsx");
	String UserName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String Password = exlRead.getCellData("LoginInfo", "Password", 2);
	String Dashboard = exlRead.getCellData("AddContactInfo", "Page", 2);
	String Contacts = exlRead.getCellData("AddContactInfo", "Page", 3);
	String FullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String Company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String Email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String PhoneNo = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String Address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String City = exlRead.getCellData("AddContactInfo", "City", 2);
	String Country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String State = exlRead.getCellData("AddContactInfo", "State", 2);
	String ZipCode = exlRead.getCellData("AddContactInfo", "Zip", 2);
	
	@Test
	public void userShouldBeAbleToCreateNewCustomer() throws InterruptedException {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(UserName);
		loginPage.insertPassword(Password);
		loginPage.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(Dashboard);
		dashboardPage.clickCustomerManuElement();
		dashboardPage.clickAddCustomerManuElement();
		
		ContactsPage contactsPage = PageFactory.initElements(driver, ContactsPage.class);
		contactsPage.validateOfContactsPageHeader(Contacts);
		contactsPage.insertFullName(FullName);
		contactsPage.selectCompany(Company);
		contactsPage.insertEmail(Email);
		contactsPage.insertPhoneNo(PhoneNo);
		contactsPage.insertAddress(Address);
		contactsPage.insertCity(City);
		contactsPage.insertState(State);
		contactsPage.insertZipCode(ZipCode);
		contactsPage.selectCountry(Country);
		contactsPage.clickOnSaveButton();
		
		
		BrowserFactory.tearDown();
		
	}

}
