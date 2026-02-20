package ankurgoyal.javaSelenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		int j = 0;
		String[] productsNedded = {"iphone", "Samsung"};

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("learning");
		driver.findElement(By.xpath("//label/input[@value='user']/following-sibling::span")).click();
		// Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-success"))).click();

		// driver.findElement(By.cssSelector("button.btn.btn-success")).click();

		WebElement dropdown = driver.findElement(By.xpath("//div/select"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Consultant");

		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		System.out.println(wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li/a")))
				.getText());

		// System.out.println(driver.getTitle());
		// driver.switchTo().alert().accept();

		List itemsNeededList = Arrays.asList(productsNedded);

		// productsNedded.asList

		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

		System.out.println(products.size());

		for (int i = 0; i <= itemsNeededList.size(); i++) {

			String[] formattedName = products.get(i).getText().split(" "); // Iphone X, in 0th index it contain Iphone
																			// and 1st Index it contain X

			if (itemsNeededList.contains(formattedName)) {

				j++;

				driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();
				// break;//removing as in list you cannot user break as if it finds the first
				// item it will break the loop.

				if (j == productsNedded.length) {
					break;
				}

			}
		}

	}

}
