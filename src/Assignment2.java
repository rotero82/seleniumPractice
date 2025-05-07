import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.Alert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://qaclickacademy.com/practice.php");
		Random random = new Random();
		int option = random.nextInt(2);
		System.out.println(option);
		
		String checkboxesXpath = "//*[contains(.,'Checkbox Example')]/parent::*";
		WebElement checkboxDriver = driver.findElement(By.xpath(checkboxesXpath));
		
		List <WebElement> checkBoxes = checkboxDriver.findElements(By.xpath("//div[@id ='checkbox-example']//label"));
												
		String checkboxText = checkBoxes.get(option).getText().trim();

		WebElement dropdownDriver = driver.findElement(By.id("dropdown-class-example"));
		dropdownDriver.click();
		dropdownDriver.findElement(By.xpath("//option[text()='"+checkboxText+"']")).click();
		System.out.println(checkboxText);
		
		WebElement dropdownOption = dropdownDriver.findElement(By.xpath("//*[contains(.,'"+checkboxText+"')]"));
		dropdownOption.click();
		Assert.assertEquals(dropdownOption.isDisplayed(), true);
		
		driver.findElement(By.id("name")).sendKeys(checkboxText);
		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();
	    Assert.assertTrue(alert.getText().contains(checkboxText));
	    alert.dismiss();		
		
		
		System.out.println("bye bye!");
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
