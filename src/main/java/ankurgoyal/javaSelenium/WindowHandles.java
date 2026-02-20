package ankurgoyal.javaSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//driver.findElement(By.cssSelector("input#username")).clear();
		
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		//Switching from parent to child
		Set<String> windows = driver.getWindowHandles(); //[ParentId,childId] //will store all the id's of open windows
		
		Iterator<String> itr=windows.iterator();//will grab the id's present in the set array
		String parentId=itr.next();//this will move to 0th index and grab parent id
		
		String childId=itr.next();//this will grab the child id from the 1st index
		//to switch to child
		driver.switchTo().window(childId);
		
		String emailId=driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailId);
		
		driver.switchTo().window(parentId);//switching back to parent window
		driver.findElement(By.cssSelector("input#username")).sendKeys(emailId);
		
		//below commented can be achieved in one single step
		
//		String[] split1=text.split("at");//0th index Please email us 1st index mentor@rahulshettyacademy.com with below template to receive response
//		String splitNew=split1[1].trim();
//		
//		String[] finalSplit=splitNew.split("with");
//		String emailId=finalSplit[0].trim();
//		System.out.println(emailId);
		
		
		
		
		
		

	}

}
