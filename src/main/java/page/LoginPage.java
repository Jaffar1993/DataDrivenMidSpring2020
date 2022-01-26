package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@name='login']")
	WebElement LOGIN_BUTTON_FIELD;

	public void EnterUserName(String FullName) {
		USERNAME_FIELD.sendKeys(FullName);
	}

	public void EnterPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}

	public void SignInButton() {
		LOGIN_BUTTON_FIELD.click();
	}

}
