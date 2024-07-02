package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
	
public static void main(String[]args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/target-practice");
		driver.getTitle();
		System.out.println("Home page title: " + driver.getTitle());
		
		String thirdheaderText = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
		System.out.println(thirdheaderText);
		
		String fifthHeaderColor = driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
        System.out.println(fifthHeaderColor);
        
        String violetButtonClass = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println(violetButtonClass);
		
        String greyButtonText = driver.findElement(By.xpath("//button[text()='Grey']")).getText();
        System.out.println(greyButtonText);
		
		driver.close();
		
	}

}
