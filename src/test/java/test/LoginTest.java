package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.ExcelReader;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;

	ExcelReader reader = new ExcelReader("./ExcelData/Project.xlsx");
	String UserName = reader.getCellData("Login", "Username", 2);
	String password = reader.getCellData("Login", "Password", 2);
	
	@Test
	public void UserShouldBeAbleToLoginPage() {
		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.EnterUserName(UserName);
		login.EnterPassword(password);
		login.SignInButton();

		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.VerifyDashBoardPage();

			}

}
