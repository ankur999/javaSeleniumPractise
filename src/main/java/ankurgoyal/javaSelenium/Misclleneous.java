package ankurgoyal.javaSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Misclleneous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("nameOfCookie");
		
		driver.get("https://www.google.com/");
		
		//click on any link 
		//verify the login url
		
		//to take a screenshots in selenium
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/ankurgoyal/Downloads/screenshot.png"));

	}

}
