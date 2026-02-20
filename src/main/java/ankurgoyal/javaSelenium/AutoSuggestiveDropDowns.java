package ankurgoyal.javaSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveDropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Handling Check boxes
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());// this will
																											// expect
																											// true if
																											// false
																											// test will
																											// fail.

		// System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());//to
		// check check box selected or not

		// Count the Number of check boxes
		// first find common locator and then store in them list and use getSize method
		// to get the count
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int total = checkboxes.size();
		System.out.println(total);

		// Handling Auto Suggestive DD
		driver.findElement(By.cssSelector("input#autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

	}

}
