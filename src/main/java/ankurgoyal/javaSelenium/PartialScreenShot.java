package ankurgoyal.javaSelenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PartialScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Scenario: Navigate to one web site then open another web site then capture
		// the first course name and enter it
		// in the name field of first web-site.

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// open new window

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");

		String text = driver.findElement(By.xpath("//div/h3[contains(text(),'Selenium WebDriver')]")).getText();
		driver.switchTo().window(parentWindow);
		
		WebElement name=driver.findElement(By.xpath("/html/body/app-root/form-comp/div/form/div[1]/input"));

		name.sendKeys(text);
		
		
		//capture Web element Screenshot
//		File file=name.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("logo.png"));
		
		//Capture Height and Width of Web Element
		
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		//driver.quit();

	}

}
