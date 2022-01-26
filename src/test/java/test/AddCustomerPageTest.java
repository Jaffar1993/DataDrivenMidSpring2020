package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.ExcelReader;
import page.LoginPage;
import util.BasePage;
import util.BrowserFactory;

public class AddCustomerPageTest extends BasePage {

	WebDriver driver;

	ExcelReader reader = new ExcelReader("./ExcelData/Project.xlsx");
	String UserName = reader.getCellData("Login", "Username", 2);
	String password = reader.getCellData("Login", "Password", 2);
	String fullname = reader.getCellData("AddContactInfo", "FullName", 2);
	String company = reader.getCellData("AddContactInfo", "CompanyName", 2);
	String email = reader.getCellData("AddContactInfo", "Email", 2);
	String phone = reader.getCellData("AddContactInfo", "Phone", 2);
	String address = reader.getCellData("AddContactInfo", "Address", 2);
	String city = reader.getCellData("AddContactInfo", "City", 2);
	String state = reader.getCellData("AddContactInfo", "State", 2);
	String zip = reader.getCellData("AddContactInfo", "ZipCode", 2);
	String group = reader.getCellData("AddContactInfo", "Group", 2);

	@Test
	public void ValidUserShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.EnterUserName(UserName);
		login.EnterPassword(password);
		login.SignInButton();

		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.VerifyDashBoardPage();

		AddCustomerPage AddCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		AddCustomer.ClickCustomers();
		AddCustomer.ClickAddCustomer();
		AddCustomer.EnterFullName(fullname);
		AddCustomer.EnterCompanyName(company);
		AddCustomer.EnterEmail(email);
		AddCustomer.EnterPhone(phone);
		AddCustomer.EnterAddress(address);
		AddCustomer.EnterCity(city);
		AddCustomer.EnterState(state);
		AddCustomer.EnterZipCode(zip);
		AddCustomer.EnterGroup(group);
		AddCustomer.ClickSaveButton();
		AddCustomer.ClickListCustomer();
		AddCustomer.VerifyEnterCustomerAndDelete();
	}

}
