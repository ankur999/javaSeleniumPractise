package ankurgoyal.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E {

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
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();//select depart/current date
		
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			
			System.out.println("Its Disabled");
			Assert.assertFalse(false);
			
			}else {
			
			Assert.assertTrue(true);
		}
		
				//Passenger Drop Down
				driver.findElement(By.className("paxinfo")).click();
				Thread.sleep(2000);
				
				int i=1;
				while(i<4) {
				driver.findElement(By.id("hrefIncAdt")).click();
				i++;
				}
		
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		
		driver.findElement(By.xpath("//input[@type='submit'][@name='ctl00$mainContent$btn_FindFlights']")).click();
		
		driver.quit();

	}

}
