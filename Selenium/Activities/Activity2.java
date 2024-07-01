package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
	
	public static void main(String[]args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/login-form");
		driver.getTitle();
		System.out.println("Home page title: " + driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("admin");
		System.out.println("Username entered");
		
		driver.findElement(By.id("password")).sendKeys("password");
		System.out.println("Password entered");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();
		
		System.out.println("Logged in successfully");
		
		//driver.close();
		
	}

}
