import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	//	String[] itemsNeeded = {"iphone X","Samsung Note 8","Nokia Edge", "Blackberry"};
		String[] itemsNeeded = {"Samsung Note 8", "iphone X"};
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='okayBtn']")));
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		driver.findElement(By.cssSelector("input[id='signInBtn'")).click();
		//Explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='my-4']")));
		addItems(driver,itemsNeeded);
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		driver.quit();
	}

	public static  void addItems(WebDriver driver,String[] itemsNeeded)
	{
		int j=0;
		List itemsNeededList = Arrays.asList(itemsNeeded);
		String firstString = "//*[contains(text(), '";
		String secondString ="')]/parent::h4/parent::div/parent::div/div[@class ='card-footer']/button";
		List <WebElement> products = driver.findElements(By.xpath("//h4[@class = 'card-title']/a"));
		String[] productNames = new String[products.size()];
		
		for(int i=0;i<products.size();i++)
		{	
			productNames[i] = products.get(i).getText();
			if(itemsNeededList.contains(productNames[i]))
			{
				//click on Add to cart
				driver.findElement(By.xpath(firstString + itemsNeeded[j] + secondString)).click();
				j++;
				if(j==itemsNeeded.length)
				{
					break;
				}
			}
		}
		
	}
}