package ankurgoyal.javaSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentWindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> windows = driver.getWindowHandles();//will store the window ids of parent and child window in a set array
		Iterator<String> itr=windows.iterator();//will grab the ids
		String parentId=itr.next();//will grab parent window id
		String childId=itr.next();
		driver.switchTo().window(childId);//switching to child id
		
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
		driver.switchTo().window(parentId);//Switching back to parent
		
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
		
				
		
		
		

	}

}
