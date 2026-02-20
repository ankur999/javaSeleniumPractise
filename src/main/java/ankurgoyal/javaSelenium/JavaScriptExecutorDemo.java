package ankurgoyal.javaSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//to scroll through web page it use java script executor
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//to scroll a specific table
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//Handles tables grid
		
		List<WebElement> amounts=driver.findElements(By.xpath("//div[@class='tableFixHead']/table/thead/following-sibling::tbody/tr/td[4]"));
		int sum=0;
		
		for(int i=0;i<amounts.size();i++) {
			int values=Integer.parseInt(amounts.get(i).getText());//28
			sum=sum+values;
			
		}
		System.out.println(sum);
		
		String totalAmount=driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		
		int sumTotal=Integer.parseInt(totalAmount);
		
		Assert.assertEquals(sum, sumTotal);
		
		
	}
	
	// How to extract value from a field with help of Javascript Executor?
	
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//
//	String value = (String) js.executeScript(
//	        "return document.getElementById('username').value;"
//	);
//
//	System.out.println(value);


}
