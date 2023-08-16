package tests;

import org.testng.annotations.Test;

import basePageObject.baseclass;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;

public class LoginTest extends baseclass{
	
	
	@Test
	public void Loginmethod() {
	HomePageObject hp=new HomePageObject(driver);
	log.info("Clicking on ogin button");
	hp.LoginBtn();
	LoginPageObject lp=new LoginPageObject(driver);
	log.info("Entering email id");
	lp.Enteremail(rb.getString("Email"));
	log.info("Entering pw");
	lp.enterpassword(rb.getString("Password"));
	log.info("Clicking on login button");
	lp.loginclick();
			
	}
}
