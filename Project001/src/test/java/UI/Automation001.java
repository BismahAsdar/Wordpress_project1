package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.locators.RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
    
	
	driver.get("https://wordpress.com/log-in/");
	driver.findElement(By.id("usernameOrEmail")).sendKeys("");
	
}
