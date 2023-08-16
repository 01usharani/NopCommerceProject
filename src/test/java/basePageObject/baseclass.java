package basePageObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class baseclass {
	
	
	public static WebDriver driver;
	public Logger log;
	public ResourceBundle rb;
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		rb=ResourceBundle.getBundle("config");
		if(br.equals("Edge")) {
		EdgeOptions options=new EdgeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		driver=new EdgeDriver(options);
		}
		else if(br.equals("Chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
			driver=new ChromeDriver(options);
		}
        else  {
//        	FirefoxOptions options=new FirefoxOptions();
//    		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
    		driver=new FirefoxDriver();
		}
		log=LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("URL"));
		driver.manage().window().maximize();
	}
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
