package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {".//Features/Customers.feature"},
        //features = ".//Features/",
        glue="StepDefinition1",
        dryRun= false,
        tags = "@Sanity", // Only Scenarios under Sanity tag will run
        monochrome=true,
        plugin= {"pretty", "html:target/cucumber-reports/reports1.html"}
)	
//plugin= {"pretty", "html:target/cucumber-reports/reports1.html"}
//plugin= {"pretty", "json:target/cucumber-reports/report_json.json"}
//plugin= {"pretty", "junit:target/cucumber-reports/report_xml.xml"}


public class Runner {

}
