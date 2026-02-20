package ankurgoyal.javaSelenium;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ChromeOptions helps you to modify your browser behavior
		
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		//if you want to add your browser with Pre-loaded extensions do the following
		//options.addExtensions(new File("add extensionpath"));
		
		//to add special proxy to your browser where you want to modify your network behavior
		
		
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("address:4444");
		options.setCapability("proxy", proxy);
		
		//To block all pop ups windows
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//Set Download directory
		Map<String,Object> prefs=new HashMap<String,Object>();
		prefs.put("download-default-directory", "path");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
