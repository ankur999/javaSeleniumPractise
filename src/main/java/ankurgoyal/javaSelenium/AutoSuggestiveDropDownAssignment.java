package ankurgoyal.javaSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveDropDownAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("unit");
		Thread.sleep(3000);
		
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		
		for(WebElement option:options) {
			
			if(option.getText().equalsIgnoreCase("United Kingdom (UK)")) {
				option.click();
				break;
			}
		}

	}

}
