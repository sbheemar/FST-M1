package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
	
		WebDriver driver;
		
		//Setup Function
		@BeforeClass
		public void setup() {
			//Download and install Geckodriver 
			WebDriverManager.firefoxdriver().setup();
					
			//Initialize the driver
			driver = new FirefoxDriver();
				
			//Open the page
			driver.get("https://v1.training-support.net/");
		}
	
		
	//Test Function
	@Test (priority = 1)
	public void homepageTest() {
		//Assert page title 
		Assert.assertEquals(driver.getTitle(), "Training Support");
		
		//Find and Click About Us link
		driver.findElement(By.id("about-link")).click();
	}
	
	//Test Function
	@Test (priority = 2)
	public void aboutpageTest() {
		//Assert page title 
		Assert.assertEquals(driver.getTitle(), "About Training Support");
		
	}
		
	
	
	//Teardown Function
	public void teardown() {
		//Close the browser
		driver.close();
}
}
