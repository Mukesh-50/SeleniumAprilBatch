package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import lib.Utility;

public class ContactPage {

	WebDriver driver;
	String usernameValidation;

	public ContactPage(WebDriver ldriver) {

		this.driver = ldriver;
	}
	
	@FindBy(how=How.XPATH,using="//*[text()='Admin']") 
	WebElement adminTab;
	
	@FindBy(id="btnAdd") WebElement addButton;
	
	@FindBy(id="systemUser_userType") WebElement userType;
	
	@FindBy(xpath="(//input[contains(@id,'employeeName')])[1]") WebElement empName;
	
	@FindBy(xpath="//input[contains(@id,'userName')]") WebElement username;
	
	@FindBy(xpath="//input[contains(@id,'password')]") WebElement password;
	
	@FindBy(xpath="//input[contains(@id,'confirmPassword')]") WebElement confPass;
	
	@FindBy(xpath="//input[contains(@value,'Save')]") WebElement saveButton;
		

	
	
	public void navigateToContactPage()
	{
		
		Utility.waitForWebElement(driver, adminTab, 20).click();;
		
		Utility.waitForWebElement(driver, addButton, 20).click();
	}
	
	public void addContact(String unameForContact,String passforContact)
	{
		Select type=new Select(userType);
		
		type.selectByIndex(0);
		
		empName.sendKeys("Abhishekk J Pinaki");
		
		username.sendKeys(unameForContact);
		
		password.sendKeys(passforContact);
		
		confPass.sendKeys(passforContact);
		
		saveButton.click();
		
		usernameValidation=unameForContact;
	
	}
	
	public void validateContactAdded(String userAdded)
	{
		String xpath="//*[contains(text(),'"+usernameValidation+"')]";

		By validateUser=By.xpath(xpath);
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		boolean status=wait.until(ExpectedConditions.presenceOfElementLocated(validateUser)).isDisplayed();
		
		Assert.assertTrue(status);
		
	}

}
