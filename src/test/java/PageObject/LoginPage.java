package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="Email")
	WebElement email;

	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement LoginBtn;


	@FindBy(linkText = "Logout")
	WebElement logout;
	
	//action for entering email Address, password and clicking login button
	public void enterEmail(String emailAdd)
	{
		email.clear();
		email.sendKeys(emailAdd);
	}

	public void enterPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}


	public void clickOnLoginButton() {
		LoginBtn.click();
	}

	public void clickOnLogOutButton()
	{
		logout.click();
	}

}

          