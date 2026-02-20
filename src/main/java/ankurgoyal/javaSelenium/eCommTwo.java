package ankurgoyal.javaSelenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eCommTwo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		// Adding Cucumber into Cart when multiple products are there and there is no
		// unique xpath and position is also not fix
		// first scan all the products and get the all the products in a list with one
		// common element
		// then whenever the product matches at the index get that item and click it

		// Question: what if we want to add one more product in the cart?
		// one thing is we can write a for loop again for the second item but its not
		// appropriate
		// the optimize way is to create an expected array which will contains items
		// that are expected and pick those and click on it.

		

		// Define array of strings

		String[] itemsNeeded = { "Cucumber", "Brocolli" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);
		
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");//won't locate due to wait issue
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		String ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))).getText();
		System.out.println(ele);
		
		
		
		//System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		
	}
	
	public static void addItems(WebDriver driver,String[] itemsNeeded ) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			// Broccoli - 1 Kg
			// using split on the basis of - it will break Sting into two parts 1st is
			// Broccoli space and second is 1 KG
			// and will return an array

			String[] productNames = products.get(i).getText().split("-");
			// now in productName[0]=Broccoli space now you need t remove space as well for
			// that we use trim function to trim white spaces

			String formattedName = productNames[0].trim();// will give broccoli

			// upon getting names we need to format it as we need only vegetable name not
			// that
			// -1KG with it
			// productNames.trim()

			// check weather name you extract present in arrayList or not
			// convert given array into array list for easy search as contains method works
			// for arraylist

			List itemsNeedeList = Arrays.asList(itemsNeeded);

			// to handle the loop will not run for more than the items present in the list
			// we
			// will create one more variable j that will run exact times we want to make it
			// run

			if (itemsNeedeList.contains(formattedName)) {

				j++;

				// click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				// DO NOT USE text method way to locate the element if the text is dynamic
				// because it can change and can lead to fail.

				if (j == itemsNeeded.length) {
					break;

				}

			}

		}

	}
	

}
