package ankurgoyal.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class SeleniumFourConcept1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Relative Locators

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameTextBox = driver.findElement(By.cssSelector("[name='name']"));

		System.out.println(driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText());

		// Checkbox element leftof
		WebElement check = driver.findElement(By.xpath("//div/input/following-sibling::label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(check)).click();

		// Checkbox element torightof
		WebElement check1 = driver.findElement(By.xpath("//div/label[@for='exampleFormControlRadio1']"));
		driver.findElement(with(By.tagName("input")).toRightOf(check1)).click();

		// DOB element
		WebElement dob = driver.findElement(By.xpath("//div/label[@for='dateofBirth']"));

		driver.findElement(with(By.tagName("input")).below(dob)).click();

	}

}
