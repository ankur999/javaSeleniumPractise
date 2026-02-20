package ankurgoyal.javaSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Ankur");
		driver.findElement(By.name("inputPassword")).sendKeys("ankur123");
		driver.findElement(By.className("submit")).click();
		
		String errorMsg=driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorMsg);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ankur");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("ankur123@gmail.com");
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9999999999");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("inputUsername")).sendKeys("Ankur");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.className("submit")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/p")).getText());
		
		
		
		
		
		driver.close();
		

	}

}
