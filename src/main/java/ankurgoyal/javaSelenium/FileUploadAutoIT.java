package ankurgoyal.javaSelenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadAutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String downloadPath=System.getProperty("user.dir");//this will get you the path for your current project
		
		
		
		WebDriverManager.chromedriver().setup();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);	
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		
		//then you need call .exe file to upload which is done by JAVA
		Runtime.getRuntime().exec("path/of/.exe/file ");
		
		//code to download the file 
		//click on covert btn after uploading the file
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#id.btn"))).click();
		
		//wait till download btn appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("dwnldbtn")));
		driver.findElement(By.cssSelector("dwnldbtn")).click();
		
		//task to verify the downloaded file is successfully downloaded by checking path is available is directory or not
		//once file is downloaded it will be in downloads folder
		
		//File f=new File("path of download folder\\converted.zip");
		//main challenge is to tell chrome browser to download the file in this project this we can do using ChromeOptions
		
		File f=new File(downloadPath+"/converted.zip");
		if(f.exists()) {
			System.out.println("file found successfully");
		}
		

	}

}
