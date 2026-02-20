package ankurgoyal.javaSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Ankur";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		LocatorsDemo2 ld=new LocatorsDemo2();
		String finalPass=ld.getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(finalPass);
		
		driver.findElement(By.className("submit")).click();
		Thread.sleep(1000);
		
		String finalmsg=driver.findElement(By.tagName("p")).getText();
		System.out.println(finalmsg);
		
		Assert.assertEquals(finalmsg, "You are successfully logged in.");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.close();
		
		

	}
	
	//Method to extract password
	
	public String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		//Please use temporary password 'rahulshettyacademy' to Login.
		String passwordText=driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] passwordArray=passwordText.split("'");
		
		
		//will split the string based on character/two pieces which we have provided and returns array
		//0th index- Please use temporary password 
		//1st index- rahulshettyacademy' to Login.
		//now in 1st index we got - rahulshettyacademy' to Login. but we need password only i.e rahulshettyacademy we split it again based on '
		//passwordArray[1].split("'")[0];//splitting again based on 0te index
		
		String[] passArray1=passwordArray[1].split("'");//splitting again
		String passText=passArray1[0];
		return passText;
		
		//0th Index- rahulshettyacademy
		//1st index-  to Login.
		
	}

}
