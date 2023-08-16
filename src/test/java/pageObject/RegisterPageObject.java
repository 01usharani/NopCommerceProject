package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPageObject extends BasePageObject{

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='gender-female']")
	WebElement gender;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement fasttname;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement companyname;

	@FindBy(xpath="//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement ConfirmPassword;

	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	WebElement Selectday;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	WebElement SelectMonth;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	WebElement SelectYear;
	
	@FindBy(xpath ="//button[@id='register-button']")
	WebElement registerbutton;
	
	public void genderselect() {
		gender.click();
	}
	public void firstname(String name) {
		fasttname.sendKeys(name);
	}
	public void lastname(String Lastname) {
		lastname.sendKeys(Lastname);
	}
	public void email(String Email) {
		email.sendKeys(Email);
		
	}
	public void companyname(String cname) {
		companyname.sendKeys(cname);
	}
	public void password(String pw) {
		password.sendKeys(pw);
	}
	public void cpassword(String cpw) {
		ConfirmPassword.sendKeys(cpw);
	}
	public void selectday(String day) {
		Select s=new Select(Selectday);
		s.selectByVisibleText(day);
	}
	public void selectmonth(String month) {
		Select s=new Select(SelectMonth);
		s.selectByVisibleText(month);
	}
	public void selectyear(String year) {
		Select s=new Select(SelectYear);
		s.selectByVisibleText(year);
	}
	public void register() {
		registerbutton.click();
	}




}
