package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePageObject{

	public LoginPageObject(WebDriver driver) {
		super(driver);
	}
		@FindBy(xpath="//input[@name='Email']")
		WebElement EmailID;
		
		@FindBy(xpath="//input[@name='Password']")
		WebElement password;
		
		@FindBy(xpath="//button[text()='Log in']")
		WebElement LoginBtn;
		
		@FindBy(xpath="//*[text()='Welcome to our store']")
		WebElement logincon;
		
		@FindBy(xpath="//*[text()='Log out']")
		WebElement logout;
		
		public void Enteremail(String id) {
			EmailID.sendKeys(id);
		}
		
		public void enterpassword(String pw) {
			password.sendKeys(pw);
		}
		
		public void loginclick() {
			LoginBtn.click();
		}
		
		public boolean confirmlogin() {
			return logincon.isDisplayed();
		}
		
		public void logoutclick() {
			logout.click();
		}


	// checking push
	

}
