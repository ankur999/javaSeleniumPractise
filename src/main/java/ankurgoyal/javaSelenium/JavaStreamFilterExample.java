package ankurgoyal.javaSelenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaStreamFilterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Click on column

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
			
		List<String> total=veggies.stream().map(s->s.getText()).collect(Collectors.toList());
		Assert.assertEquals(veggies.size(), total.size());
		
//		long l=element.stream().filter(s->s.getText().contains("Rice")).count();
//		System.out.println(l);
		
		
		
	
		
		//System.out.println(total);

	}

}
