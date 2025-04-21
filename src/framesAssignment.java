
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class framesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		
		driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_top']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_middle']")));
		
		String text = driver.findElement(By.cssSelector("div[id='content']")).getText();
		System.out.println(text);
		
		driver.switchTo().defaultContent(); 
		
	}

}

