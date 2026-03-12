package ankurgoyal.javaSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelIntro1Lect {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		//WebDriver contains the all methods with the empty body so that the classes 
		//can implement it in their own way by providing their functionality and also 
		//user can easily switch b/w the browsers without changing the code
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
//		Alert alert = driver.switchTo().alert();
//		alert.dismiss();
		String url=driver.getCurrentUrl();
				System.out.println(url);
					System.out.println(driver.getTitle());
						driver.quit();
		
		
		
		//System.out.println("Hello");

	}

}
