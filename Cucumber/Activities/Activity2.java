package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions.Activity2"},
	    tags = "@activity2"
	)

public class Activity2 {
	


}
