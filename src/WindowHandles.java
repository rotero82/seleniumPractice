import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set <String> windows = driver.getWindowHandles(); //[parentId, childId, subchildId];
		Iterator <String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		//String subchildId = it.next(); //redundant, just to clarify iterator concept.
		driver.switchTo().window(childId);
		
		
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
					
		
	}

}
