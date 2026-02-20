package ankurgoyal.javaSelenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcerciseScope {
	
	//This can be explained to an interviewer what impact you have made in your automation

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//1.count no of links on the web page
		//2.Get count of links from a specific block.
		//3.Get count of links from a specific block of a specific section
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Thread.sleep(5000);
		
		List<WebElement> links=driver.findElements(By.tagName("a"));//finding the common tag.
		System.out.println(links.size());//getting the total links count.
		
		//Getting the count of links for a specific block
		
		WebElement block=driver.findElement(By.id("gf-BIG"));//first find that block
		System.out.println("Getting count of links from a specific block");
		System.out.println(block.findElements(By.tagName("a")).size());//then use block to find element instead of driver
		
		WebElement specificBlockColumn=block.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));//reach to specific column of a specific block
		System.out.println("Printing Coloumn One links from a specifc block");
		System.out.println(specificBlockColumn.findElements(By.tagName("a")).size());//then find common tag and print count
		
		//4. Click on each link and check pages are opening or not
		//5.And Then Navigate to each tab and grab the titles of each opened tab
		
		for(int i=1;i<specificBlockColumn.findElements(By.tagName("a")).size();i++) {
			
			String clickOnLink=Keys.chord(Keys.COMMAND,Keys.ENTER);//will open a link in a new tab
			
			specificBlockColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);//any keyboard events is passed as send keys method
			Thread.sleep(5000L);
			
		}
		
		//String parentWindow=driver.getWindowHandle();
		
		Set<String> windows=driver.getWindowHandles();//will get the window id's of all the opened tab 
		Iterator<String> itr= windows.iterator();//will grab the the id's
		
		while(itr.hasNext()){//hasNext check new window is present or not
			
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
			
		}
		
//		String parentId=itr.next();//parent
//		String ChildOneId=itr.next();
//		System.out.println(driver.switchTo().window(ChildOneId).getTitle());
//		
//		String ChildTwoId=itr.next();
//		System.out.println(driver.switchTo().window(ChildTwoId).getTitle());
//		
//		String ChildThreeId=itr.next();
//		System.out.println(driver.switchTo().window(ChildThreeId).getTitle());
//		
//		String ChildFourId=itr.next();
//		System.out.println(driver.switchTo().window(ChildFourId).getTitle());
		
		
		
		
		
		
		
//		for(WebElement link:links) {
//			System.out.println(link.getText());
//		}
		
		

	}

}
