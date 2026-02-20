package ankurgoyal.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// Drop down with select tag
		WebElement staticDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select select=new Select(staticDropdown);
		select.selectByIndex(1);//By Value & By Visible Text
		System.out.println(select.getFirstSelectedOption().getText());//will get text of the first selected element
		
		//Passenger Drop Down
		driver.findElement(By.className("paxinfo")).click();
		Thread.sleep(2000);
		
		int i=1;
		while(i<4) {
		driver.findElement(By.id("hrefIncAdt")).click();
		i++;
		}
		
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.className("paxinfo")).getText());

	}

}
