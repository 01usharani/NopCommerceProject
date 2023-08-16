package tests;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import basePageObject.baseclass;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;


public class RegisterTest extends baseclass{
	
	
	@Test
	public void register() {
		
		log.info("registration process");
		HomePageObject hm=new HomePageObject(driver);
		hm.registerClick();
		log.info("Clicked on register button");
		RegisterPageObject rp=new RegisterPageObject(driver);
		log.info("selecting gender");
		rp.genderselect();
		log.info("entering first name");
		rp.firstname("Usha");
		log.info("entering last name");
		rp.lastname("Rani");
		log.info("entering email id");
		rp.email(rb.getString("Email"));
		log.info("entering company name");
		rp.companyname("accenture");
		log.info("selecting date of birth");
		rp.selectday("5");
		rp.selectmonth("May");
		rp.selectyear("2000");
		log.info("entering pw");
		rp.password(rb.getString("Password"));
		log.info("entwring pw again to confirm pw");
		rp.cpassword(rb.getString("Password"));
		log.info("clicking on register btn");
		rp.register();
	}

}
