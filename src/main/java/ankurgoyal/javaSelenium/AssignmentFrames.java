package ankurgoyal.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));//first locating the frame in which inner frame is present
		
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));//then locating the child frame
		System.out.println(driver.findElement(By.cssSelector("div#content")).getText());//getting text from the child frame

	}

}
