import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;


public class PracticeCheckboxes {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // URL in the browser
		
		driver.findElement(By.cssSelector("div [id='checkBoxOption1']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div [id='checkBoxOption1']")).isSelected(), true);
		driver.findElement(By.cssSelector("div [id='checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("[id='checkBoxOption1']")).isSelected());
		Assert.assertEquals(driver.findElements(By.cssSelector("div [id*='checkBoxOption']")).size(), 3);
		driver.close();

	}

}
