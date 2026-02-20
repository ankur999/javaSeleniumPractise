package ankurgoyal.javaSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Fetch all the URL's
		//And Check if they are returning 200 or not
		//For this we use java methods which will call URL's and gets the status code.
		
		//Step 1. Get all Url's tied to the links using Selenium
		//Use java methods which will call URL's and gets the status code.
		//if status code > 400 then URL/link is broken
		
		//to check for one single link
		
//		String url=driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul/li[3]/a")).getAttribute("href");
//		HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
//		conn.setRequestMethod("HEAD");
//		conn.connect();
//		int response=conn.getResponseCode();
//		System.out.println(response);
		
		
		WebElement block=driver.findElement(By.id("gf-BIG"));
		
		List<WebElement> links=block.findElements(By.tagName("a"));
		
		SoftAssert a = new SoftAssert();//used for soft assertion used in case any failure reported will continue the script
		
		for(WebElement link:links) {
			String urls=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection) new URL(urls).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int response=conn.getResponseCode();
			System.out.println(response);
			
			a.assertTrue(response<400, "the link with text "+link.getText()+"is broken with "+response);
			
			
//			if(response>400)
//			{
//				System.out.println("The link with text "+link.getText()+"is broken with "+response);
//				Assert.assertTrue(false);
//			}
			
		}
		a.assertAll();//if any failure is reported then this line fail the script if not reported any failure will pass the script.(report all failures)
		
		
		
		

	}

}
