package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

        features= {".//Feature//Login.feature"},
        glue="StepDefinitions",
        plugin= {
        		"pretty", "html:reports/myreport.html", 
        		"json:reports/myreport.json"
        		},    //Mandatory to capture failures
        dryRun=false,
        monochrome=true,
        tags = "@sanity"	//Scenarios tagged with @sanity,
      )
public class fisttest {
	

}
