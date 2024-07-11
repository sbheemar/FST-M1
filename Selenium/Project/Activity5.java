package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {
    WebDriver driver;
    //Include alwaysRun property on the @BeforeTest
    //to make sure the page opens
    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open the browser
        driver.get("https://alchemy.hguy.co/lms");
    }
    
    
    @Test 
   public void HeaderTest3() {
    	driver.findElement(By.xpath("//*[@id=\"menu-item-1507\"]")).click();
    	
    	WebElement page_title = driver.findElement(By.cssSelector("h1.uagb-ifb-title"));
        Assert.assertEquals(page_title.getText(), "My Account");
       System.out.println("Page Title is: " + page_title.getText());
    }

	@AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}