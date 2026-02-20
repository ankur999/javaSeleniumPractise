package ankurgoyal.javaSelenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaStreamExample {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Click on column

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//table/thead/tr/th[@role='columnheader'][1]")).click();
		// Capture all web elements into list
		List<WebElement> elementlist = driver.findElements(By.xpath("//tr/td[1]"));
		// System.out.println(elementlist);

//		for(WebElement list:lists) {
//			System.out.println(list.getText());
//		}

		// capture text of all web element into original list
		List<String> originalList = elementlist.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(originalList);

		// sort the original list from step 3->sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);

		// compare original vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;

		// Scan the name column with getText and if you get BEANS-> print the price
		// using custom method
		// after that if the element you are trying to find is not on the first page
		// then how to do it
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(a -> System.out.println(a));
			// applying pagination

			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;

	}

}
