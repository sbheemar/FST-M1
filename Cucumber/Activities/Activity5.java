package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions.Activity5"},
	    tags = "@Activity5"
	)

public class Activity5 {

}
