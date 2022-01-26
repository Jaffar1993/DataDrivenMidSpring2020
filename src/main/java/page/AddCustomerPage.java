package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.BasePage;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]")
	WebElement CUSTOMERS_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]")
	WebElement ADD_CUSTOMER_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULL_NAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_DROPDOWN_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//select[@id='group']")
	WebElement GROUP_DROPDOWN_LOCATOR;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SAVE_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customers')]")
	WebElement LIST_CUSTOMER_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Ali58')]")
	WebElement CUSTOMER_INFO_FIELD;

	public void ClickCustomers() {
		CUSTOMERS_BUTTON_LOCATOR.click();
	}

	public void ClickAddCustomer() {
		ADD_CUSTOMER_BUTTON_LOCATOR.click();
	}

	String EnteredName;

	public void EnterFullName(String fullname) {
		EnteredName = fullname + BasePage.RandomNumGenerate();
		FULL_NAME_FIELD_LOCATOR.sendKeys(EnteredName);
	}

	public void EnterCompanyName(String company) {
		BasePage.DropDown(COMPANY_DROPDOWN_LOCATOR, company);
	}

	public void EnterEmail(String email) {
		String EnteredEmail = BasePage.RandomNumGenerate() + email;
		EMAIL_FIELD_LOCATOR.sendKeys(EnteredEmail);
	}

	public void EnterPhone(String phone) {
		PHONE_FIELD_LOCATOR.sendKeys(phone);
	}

	public void EnterAddress(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}

	public void EnterCity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}

	public void EnterState(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}

	public void EnterZipCode(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}

	public void EnterGroup(String group) {
		BasePage.DropDown(GROUP_DROPDOWN_LOCATOR, group);
	}

	public void ClickSaveButton() {
		SAVE_BUTTON_LOCATOR.click();
	}

	public void ClickListCustomer() {
		LIST_CUSTOMER_BUTTON_LOCATOR.click();
	}

	public void ClickCustomerName() {
		CUSTOMER_INFO_FIELD.click();
	}

	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";

	public void VerifyEnterCustomerAndDelete() {
		//This part is verification for the dynamic table.
		for (int i = 2; i <= 5; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			 //Assert.assertEquals(name, EnteredName, "Name does not match!!!");
			
			// This part for the delete the customer name but this is not a mandatory.
			if (name.contains(EnteredName)) {
				System.out.println("Name already exists!");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
				BasePage.WaitForElements(driver, 10, By.xpath("//button[@class='btn btn-primary']"));
				driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

			}
		}
	}

	// tbody/tr[2]/td[3]
	// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]--Delete button
}
