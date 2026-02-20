package ankurgoyal.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();//Click on From DD 
		driver.findElement(By.xpath("//a[@value='BLR']")).click();//Select value from From DD
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();//Select value from To DD
		
		//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA'] 
		//This is Parent Child Relationship Method earlier which we used by / moving to child is parent child traverse method
		
		//Handling Calendar
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();//select depart/current date
		
		//Validating if UI elements are disabled or enabled with attributes
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();//select round trip checkbox
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			
			System.out.println("Its Enabled");
			Assert.assertTrue(true);
			
		}else {
			
			Assert.assertTrue(false);
		}
		
		//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		//now check return date is enabled or disabled
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

	}

}
