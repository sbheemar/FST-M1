package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
	
	public static void main(String[] args) {
		
		// Open the page and print the title
		WebDriver driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net");
		driver.getTitle();
		System.out.println("Home page title: " + driver.getTitle());
		
		//Find "About Us" button on the page
		driver.findElement(By.id("about-link")).click();
		System.out.println("About page title: " + driver.getTitle());
		
		driver.close();
		
	}

}
