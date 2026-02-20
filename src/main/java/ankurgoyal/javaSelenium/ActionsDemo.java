package ankurgoyal.javaSelenium;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);

		// driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button")).click();

		// driver.findElement(By.xpath("//*[@id=\"nav-flyout-iss-anchor\"]/div[2]/div/div[3]/span[1]/span/input")).click();

		WebElement ele = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));

		Actions action = new Actions(driver);

		// If you want to write something in capital letters and select hello.
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("hello").doubleClick().build().perform();

		// this will move your mouse to a specific element and perform right click.
		action.moveToElement(ele).contextClick().build().perform();

	}

}
