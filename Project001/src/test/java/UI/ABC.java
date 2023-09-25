package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ABC


{

	public static void main(String[] args)
	
	
	{
		 try
		    {
		    	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.get("xyz");
	driver.findElement(By.id("user_login")).sendKeys("xyz");
    driver.findElement(By.id("user_pass")).sendKeys("xyz");
    driver.findElement(By.cssSelector("#wp-submit")).click();
    
    try
    {
        
       driver.findElement(By.cssSelector("#toplevel_page_wp-dark-mode-settings > a > div.wp-menu-name")).click(); // 3. If Active, navigate to the WP Dark Mode & continue
        System.out.println(("wp dark mode is present"));
    
    }
    catch(NoSuchElementException e) 
    {
    	
    	System.out.println(("wp dark mode is not present"));
        // 3. Otherwise, Install the Plugin and Activate it

        driver.get("https://hbgroupsites.inveloagency.nl/mystaging01/wp-admin/plugin-install.php"); //add new plugin
        WebElement searchBox = driver.findElement(By.id("search-plugins"));
    	searchBox.sendKeys("WP Dark Mode");
    	searchBox.click();
    	driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[1]/div[4]/form/div[2]/div/div[1]/div[1]/div[1]/h3/a")).click(); //find plugin
    	driver.findElement(By.xpath("//*[@id=\"the-list\"]/div[1]/div[1]/div[2]/ul/li[1]/a")).click(); //install plugin
        driver.findElement(By.cssSelector("#the-list > div.plugin-card.plugin-card-wp-dark-mode > div.plugin-card-top > div.action-links > ul > li:nth-child(1) > a")).click(); //activate plugin
        
      }
        driver.findElement(By.cssSelector("#wp_dark_mode_general > form > table > tbody > tr.enable_backend > td > fieldset > label > div > div")).click(); //enable backend dark mode
        driver.findElement(By.cssSelector("#save_settings")).click(); //save settings
        driver.findElement(By.cssSelector("#wp-admin-bar-wp-dark-mode > a > div > label > div.modes.wp-dark-mode-ignore")).click();
        driver.navigate().to("https://hbgroupsites.inveloagency.nl/mystaging01/wp-admin/");    
        String backgroundcolor = driver.findElement(By.cssSelector("#wpbody-content > div.wrap > h1")).getCssValue("background-color");  //dashboard xpath
        String Textcolor = driver.findElement(By.cssSelector("#wpbody-content > div.wrap > h1")).getCssValue("color");//getting background color attribute with getCssValue()
        System.out.println(backgroundcolor);
        System.out.println(Textcolor);
        	      
       
        if (backgroundcolor == "rgba(0, 0, 0, 0)" && Textcolor == "rgb(209, 203, 193, 1)") // Compare the CSS properties to validate Darkmode
        {
        	System.out.println("Dark mode is working");
        	
        } 
        else 
        
        {
        	System.out.println("Dark mode is working");
        }
        
        driver.findElement(By.cssSelector("#toplevel_page_wp-dark-mode-settings > a > div.wp-menu-name")).click(); // navigate to the WP Dark Mode
        driver.findElement(By.cssSelector("#wp_dark_mode_switch-tab > span")).click(); //open switch settings
        driver.findElement(By.cssSelector("#wp_dark_mode_switch > form > table > tbody > tr.switch_style > td > fieldset > label:nth-child(3) > img")).click(); // select switch floating style
        WebElement show = driver.findElement(By.xpath("//*[@id=\"wp_dark_mode_switch\"]/form/table/tbody/tr[21]/th/label"));
        WebElement savesettings = driver.findElement(with(By.id("save_settings")).below(show));
        savesettings.click();
        driver.findElement(By.cssSelector("#wp_dark_mode_switch > form > table > tbody > tr.switcher_size > td > div > span:nth-child(7)")).click(); // switch custom scale
        WebElement slider = driver.findElement(By.cssSelector("#wp_dark_mode_switch > form > table > tbody > tr.switcher_scale > td > div > div.wppool-slider-handle.ui-slider-handle.ui-corner-all.ui-state-default")); 
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 150, 0).build().perform();
        Select Dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"wp_dark_mode_switch[switcher_position]\"]"))); // Floating switch position left bottom
        Dropdown.selectByVisibleText("Left Bottom");
        WebElement save1 = driver.findElement(By.xpath("//*[@id=\"wp_dark_mode_switch\"]/form/table/tbody/tr[21]/th/label"));
        WebElement savesettings1 = driver.findElement(with(By.id("save_settings")).below(save1));
        savesettings1.click();
        
        
        driver.findElement(By.cssSelector("#wp_dark_mode_accessibility-tab")).click(); //click accessibility settings 
        driver.findElement(By.cssSelector("#wp_dark_mode_accessibility > form > table > tbody > tr.keyboard_shortcut > td > fieldset > label > div > div")).click(); //disable accessibility settings	
        
        WebElement dynamiccontent = driver.findElement(By.xpath("#wp_dark_mode_accessibility > form > table > tbody > tr.dynamic_content_mode > th > label"));
        WebElement savesettings11 = driver.findElement(with(By.id("save_settings")).below(dynamiccontent));
        savesettings11.click(); 
     
        
        driver.findElement(By.cssSelector("#wp_dark_mode_animation-tab > span")).click(); //open animation
        driver.findElement(By.cssSelector("#wp_dark_mode_accessibility > form > table > tbody > tr.keyboard_shortcut > td > fieldset > label > div > div")).click(); //enable animation
        Select animation = new Select(driver.findElement(By.xpath("//*[@id=\"wp_dark_mode_animation[animation]\"]")));
        animation.selectByVisibleText("Roll");
        WebElement DarkModeTA = driver.findElement(By.xpath("//*[@id=\"wp_dark_mode_animation\"]/form/table/tbody/tr[1]/th/label"));
        WebElement savesetting2 = driver.findElement(with(By.id("save_settings")).below(DarkModeTA));
        savesetting2.click(); 
        
        driver.navigate().to("https://hbgroupsites.inveloagency.nl/mystaging01/");   
        driver.findElement(By.cssSelector("body > div.wp-dark-mode-switcher.wp-dark-mode-ignore.style-3.floating.left_bottom > label")).click();
        
        
        String backgroundcolor1 = driver.findElement(By.cssSelector("#masthead > div > section > div > div > div > div > div > div > a > div > div > img")).getCssValue("background-color");  //dashboard xpath
        String Textcolor1 = driver.findElement(By.cssSelector("#masthead > div > section > div > div > div > div > div > div > a > div > div > img")).getCssValue("color");//getting background color attribute with getCssValue()
        System.out.println(backgroundcolor1);
        System.out.println(Textcolor1);
        	      
       
        if (backgroundcolor == "rgba(0, 0, 0, 0)" && Textcolor == "rgba(197, 83, 117, 1)") // Compare the CSS properties to validate fronted Darkmode
        {
        	System.out.println("Dark mode is working");
        	
        } 
        else 
        
        {
        	System.out.println("Dark mode is not working");
        }
        
        
     
        
    }
    finally {
    	
    	
    	
    	
    }
		 
	}
}
   
