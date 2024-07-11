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

public class Activity8 {
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
        
        driver.findElement(By.xpath("//*[@id=\"menu-item-1506\"]")).click();
        
    	WebElement page_title = driver.findElement(By.cssSelector("h1.uagb-ifb-title"));
        Assert.assertEquals(page_title.getText(), "Need Help?");
        System.out.println("On Page: " + page_title.getText());
        System.out.println("Filling Contact Form fields ");
    }
    
    
    @Test 
   public void ContactAdmin() {
    	
    	WebElement Name = driver.findElement(By.id("wpforms-8-field_0"));
    	Name.sendKeys("JavaProject");
    	
    	WebElement Email = driver.findElement(By.id("wpforms-8-field_1"));
    	Email.sendKeys("activity8@project.com");
    	
    	WebElement Subject = driver.findElement(By.id("wpforms-8-field_3"));
    	Subject.sendKeys("This is a project activity for Java");
    	
    	WebElement Message = driver.findElement(By.id("wpforms-8-field_2"));
    	Message.sendKeys("Entering a message into Comment box");
    	
    	
    	driver.findElement(By.xpath("//*[@id=\"wpforms-submit-8\"]")).click();
    	
    	WebElement page_title = driver.findElement(By.xpath("//*[@id=\"wpforms-confirmation-8\"]"));
        Assert.assertEquals(page_title.getText(), "Thanks for contacting us! We will be in touch with you shortly.");
        System.out.println("Message Confirmation: " + page_title.getText());
}
    
	@AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
       driver.close();
    }  
	
}