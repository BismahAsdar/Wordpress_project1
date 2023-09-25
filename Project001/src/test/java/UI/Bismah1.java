package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.locators.RelativeLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Bismah1

{

	public static void main(String[] args)
	
	{
		 try
		    {
		    	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.get("https://hbgroupsites.inveloagency.nl/mystaging01/wp-admin/");
	driver.findElement(By.id("user_login")).sendKeys("moeez");
    driver.findElement(By.id("user_pass")).sendKeys("0m6TmSsdKZ6AEP$NtDbtuo)*");
    driver.findElement(By.cssSelector("#wp-submit")).click();
    
   
    boolean pluginStatus = driver.findElement(By.cssSelector("#toplevel_page_wp-dark-mode-settings > a > div.wp-menu-name")).isDisplayed(); //wp is dipalyed in installed plugins
    
    if (pluginStatus = "isDisplayed" != null) {
        
        driver.findElement(By.cssSelector("#toplevel_page_wp-dark-mode-settings > a > div.wp-menu-name")).click(); // 3. If Active, navigate to the WP Dark Mode & continue
        System.out.println(("wp dark mode is present"));
        
        driver.findElement(By.cssSelector("#wp_dark_mode_general > form > table > tbody > tr.enable_backend > td > fieldset > label > div > div")).click(); //enable bakend dark mode
        driver.findElement(By.cssSelector("#save_settings")).click(); //save settings
        driver.findElement(By.cssSelector("#wp-admin-bar-wp-dark-mode > a > div > label > div.modes.wp-dark-mode-ignore")).click();
        driver.navigate().to("https://hbgroupsites.inveloagency.nl/mystaging01/wp-admin/");
       
        
        String backgroundcolor = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[3]/h1")) //dashboard xpath
      	      .getCssValue("background-color");
        String Textcolor = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[3]/h1"))
        	      .getCssValue("color");
        	      //getting background color attribute with getCssValue()
        	      
        	      System.out.println(backgroundcolor);
        	      System.out.println(Textcolor);
        	      
       // Compare the CSS properties to validate Darkmode
        if (backgroundcolor == "rgba(0, 0, 0, 0)" && Textcolor == "rgb(209, 203, 193, 1)")
        {
        	System.out.println("Dark mode is working");
        	
        } 
        else 
        
        {
        	System.out.println("Dark mode is working");
        }
     
     /*   driver.findElement(By.cssSelector("#toplevel_page_wp-dark-mode-settings > a > div.wp-menu-name")).click(); // navigate to the WP Dark Mode
        driver.findElement(By.cssSelector("#wp_dark_mode_switch > form > table > tbody > tr.switch_style > td > fieldset > label:nth-child(3) > img")).click(); // switch floating style
        //driver.findElement(By.cssSelector("")).click(); // switch custom scale
        driver.findElement(By.cssSelector("#wp_dark_mode_switch > form > table > tbody > tr.switcher_position > th > label")).sendKeys("Left Bottom"); // Floating switch position
        
      //  driver.findElement(By.cssSelector("#save_settings")).click(); //save settings*/
        
      } 
    
    
    else {
    	
    	//System.out.println(("wp dark mode is not present"));
        // 3. Otherwise, Install the Plugin and Activate it
        driver.get("https://hbgroupsites.inveloagency.nl/mystaging01/wp-admin/plugin-install.php"); //add new plugin
        WebElement searchBox = driver.findElement(By.id("search-plugins"));
        	searchBox.sendKeys("WP Dark Mode");
        	searchBox.click(); 
        	driver.findElement(By.xpath("//*[@id=\"the-list\"]/div[1]/div[1]/div[1]/h3/a")); //find plugin
        	driver.findElement(By.xpath("//*[@id=\"the-list\"]/div[1]/div[1]/div[2]/ul/li[1]/a")).click(); //install plugin
        driver.findElement(By.cssSelector("#the-list > div.plugin-card.plugin-card-wp-dark-mode > div.plugin-card-top > div.action-links > ul > li:nth-child(1) > a")).click();
        
      }
   
    }
    finally {
    	
    	
    
    }
		 
	}
}
   