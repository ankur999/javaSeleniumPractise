package ankurgoyal.javaSelenium;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.findElements(By.tagName("iframe")).size();//to get how many frames are there on the web page.
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));//1st method using webElement
		//driver.switchTo().frame(0);//2nd way to switch
		
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop= driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
		
		//to get out of the frame
		driver.switchTo().defaultContent();
		

	}

}
