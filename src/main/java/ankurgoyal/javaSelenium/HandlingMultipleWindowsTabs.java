package ankurgoyal.javaSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleWindowsTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Scenario: Navigate to one web site then open another web site then capture the first course name and enter it 
		//in the name field of first web-site.

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//open new window
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itr=windows.iterator();
		String parentWindow=itr.next();
		String childWindow=itr.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		
		String text=driver.findElement(By.xpath("//div/h3[contains(text(),'Selenium WebDriver')]")).getText();
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("/html/body/app-root/form-comp/div/form/div[1]/input")).sendKeys(text);
		driver.quit();
		
		
		

	}

}
