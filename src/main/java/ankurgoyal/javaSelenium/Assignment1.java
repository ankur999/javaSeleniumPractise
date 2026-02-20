package ankurgoyal.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.cssSelector("input.form-control.ng-untouched.ng-pristine.ng-invalid")).sendKeys("Ankur");
		
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("ankur123@gmail.com");
		
		driver.findElement(By.cssSelector("input#exampleInputPassword1")).clear();
		driver.findElement(By.cssSelector("input#exampleInputPassword1")).sendKeys("Pass123");
		
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement dropdown=driver.findElement(By.id("exampleFormControlSelect1"));
		Select select=new Select(dropdown);
		
		select.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.name("bday")).sendKeys("02/09/1995");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.xpath("//div/div/a[@class='close']/following-sibling::strong")).getText());
		
		
		
		

	}

}
