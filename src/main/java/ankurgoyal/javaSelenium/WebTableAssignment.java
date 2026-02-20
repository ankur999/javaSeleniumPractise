package ankurgoyal.javaSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[1]/th"));
		
		System.out.println("Total No of Rows are : " +rows.size());
		System.out.println("Total No of Coloumns are : "+cols.size());
		
		System.out.println(driver.findElement(By.xpath("//table[@class='table-display']/tbody/tr[3]")).getText());

	}

}
