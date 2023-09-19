package StepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;

public class steps {
	
	WebDriver driver;
	Logger log;
	HomePageObject hm;
	LoginPageObject lp;
	@Before
	public void setup() {
		log=LogManager.getLogger(this.getClass());
		
	}
	 @After
	    public void tearDown(Scenario scenario) {
	        System.out.println("Scenario status ======>"+scenario.getStatus());
	        if(scenario.isFailed()) {
	        	
	        	TakesScreenshot ts=(TakesScreenshot) driver;
	        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	        	scenario.attach(screenshot, "image/png",scenario.getName());
	        	            
	        }
	       driver.quit();
	    }

	@Given("launch browser")
	public void launch_browser() {
	    driver= new EdgeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}

	@Given("Open url {string}")
	public void open_url(String string) {
		driver.get(string);
	    driver.manage().window().maximize();
	}

	@When("Click on login button")
	public void click_on_login_button() {
		hm= new HomePageObject(driver);
		hm.LoginBtn();
	    
	}

	@When("Enter Email {string} password {string}")
	public void enter_email_password(String string, String string2) {
		lp= new LoginPageObject(driver);
		lp.Enteremail(string);
		lp.enterpassword(string2);
	    
	}

	@When("click on login")
	public void click_on_login() {
		lp.loginclick();
	    
	}

	@Then("validate welcome to our store text")
	public void validate_welcome_to_our_store_text() {
	    lp.confirmlogin();
	}

	@Then("click on logout button")
	public void click_on_logout_button() {
	    lp.logoutclick();
	}
}
