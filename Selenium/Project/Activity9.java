package projects;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {
    WebDriver driver;
    //Include alwaysRun property on the @BeforeTest
    //to make sure the page opens
    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();   
        
        driver.manage().window().maximize();
        
        //Open the browser
        driver.get("https://alchemy.hguy.co/lms");
        

    }
    
    @Test (priority = 1)
   public void HeaderTest3() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.findElement(By.xpath("//*[@id=\"menu-item-1507\"]")).click();
    	
    	WebElement page_title = driver.findElement(By.cssSelector("h1.uagb-ifb-title"));
        Assert.assertEquals(page_title.getText(), "My Account");
        System.out.println("On Page: " + page_title.getText());
        
        driver.findElement(By.cssSelector("a.ld-login")).click();
        
        WebElement dynamicBox = driver.findElement(By.cssSelector("div.ld-login-modal-login"));
        wait.until(ExpectedConditions.visibilityOf(dynamicBox));
        System.out.println(dynamicBox.isDisplayed());
    }
    
    @Test (priority = 2)
    public void loginTest() {
        //Find the username and password fields
        WebElement username = driver.findElement(By.id("user_login"));
        WebElement password = driver.findElement(By.id("user_pass"));
        
        //Enter credentials
        username.sendKeys("root");
        password.sendKeys("pa$$w0rd");
        
        //Click login
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        
       driver.findElement(By.cssSelector("img.avatar-96"));
       System.out.println("Logged In Successful");
        
       }    

    @Test (priority = 3)
    public void CourseCompletion() {
        
    	//Click on All Courses link
    	driver.findElement(By.xpath("//*[@id=\"menu-item-1508\"]")).click();
        
    	driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
        
    	System.out.println("Mark Complete Button is not found on the page");
        
       } 
    
	@AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
       driver.close();
    }

}
