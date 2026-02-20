package ankurgoyal.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String Text=driver.findElement(By.xpath("//label[contains (@for,'ben')]")).getText();
		System.out.println(Text);
		
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		
		Select select=new Select(dropdown);
		select.selectByVisibleText(Text);
		
		driver.findElement(By.id("name")).sendKeys(Text);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String Expected=driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		
		System.out.println(Expected);
		
		Assert.assertEquals(Text, Expected);
		
		

	}

}
