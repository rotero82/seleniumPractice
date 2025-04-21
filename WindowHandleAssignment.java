import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class WindowHandleAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("[href='/windows']")).click();
		driver.findElement(By.cssSelector("[href='/windows/new']")).click();
		
		Set <String> windows = driver.getWindowHandles(); 
		Iterator <String> it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
		

		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
	}

}
