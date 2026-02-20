package ankurgoyal.javaSelenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eCommTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//// *[@id="root"]/div/div[1]/div/div[3]/div[3]/button

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		

		driver.manage().window().maximize();
		
		//Step First

		// Adding Cucumber into Cart when multiple products are there and there is no
		// unique xpath and position is also not fix
		// first scan all the products and get the all the products in a list with one
		// common element
		// then whenever the product matches at the index get that item and click it

		//Step 2
		// Question: what if we want to add one more product in the cart?
		// one thing is we can write a for loop again for the second item but its not
		// appropriate
		// the optimize way is to create an expected array which will contains items
		// that are expected and pick those and click on it.

		
		int j=0;
		
		// Define array of strings

		String[] itemsNeeded = { "Cucumber", "Brocolli" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);

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

			// upon getting names we need to format it as we need only vegetable name not that
			// -1KG with it
			// productNames.trim()
			
			//Step Three

			// check weather name you extract present in arrayList or not
			// convert given array into array list for easy search as contains method works
			// for arraylist

			List itemsNeedeList = Arrays.asList(itemsNeeded);
			
			//to handle the loop will not run for more than the items present in the list we 
			//will create one more variable j that will run exact times we want to make it run
			
			

			if (itemsNeedeList.contains(formattedName)) {
				
				j++;

				// click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				//DO NOT USE text method way to locate the element if the text is dynamic because it can change and can lead to fail.
				
				if(j==itemsNeeded.length) {
					break;

			}

		}

	}

	}
}
//The above code is asked in amazon asking each day new product added in the market
//and you need to make sure they get added to cart or not?

//First you need to find one common element which locate all the items and then 
//you need to iterate over each element to check its index
//if the list contain that element you need to extract that element and click on it

//Second what if you want to add multiple items in the cart to do so
//we need to create and expected array of String that you want to add
//Then we need to convert that array to string to Array list for easy search as it contain contains method
//Then using that Name list which you got earlier matches the item in the array list will click on it


//Third The Name list you got should exactly match the text which you are passing in the arrayslist
//for ex: in name list you got cucumber - 1KG but in array list you are passing cucumber only so it 
//should exactly match and to do so we need to use split and trim method to make it exact

//Fourth
//to handle the loop will not run for more than the items present in the list we 
//will create one more variable j that will run exact times we want to make it run
