package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePageObject.baseclass;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import utilities.DataProviders;

public class Loginddt extends baseclass {
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void logindatadriventest(String email, String pw, String exp) {
		
		HomePageObject hp=new HomePageObject(driver);
		log.info("Clicking on login button");
		hp.LoginBtn();
		LoginPageObject lp=new LoginPageObject(driver);
		log.info("Entering email id");
		lp.Enteremail(email);
		log.info("Entering pw");
		lp.enterpassword(pw);
		log.info("Clicking on login button");
		lp.loginclick();
		
		
		if(exp.equals("valid")) {
			
			if(lp.confirmlogin()==true) {
				log.info("login true");
			    Assert.assertTrue(true);
			    lp.logoutclick();
			}
			else {
				
				Assert.assertTrue(false);
			}
					
		}
		
		if(exp.equals("invalid")) {
			
			if(lp.confirmlogin()==true) {
				log.info("login false");
			    Assert.assertTrue(false);
			    lp.logoutclick();
			}
			else {
				
				Assert.assertTrue(true);
			}
			
		}
	}

}
