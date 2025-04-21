import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class amazonQuestion {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		//expected array
		String[] itemsNeeded = {"Cucumber", "Brocolli"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
		
		
		
		driver.quit(); 
		
	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i = 0; i < products.size(); i++) {
			//
			
			
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			
			//Convert array into array list for easy search.
			//Check whether name you extracted is present in arrayList or not.
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			
			if(itemsNeededList.contains(formattedName)) {
				j++;
				//click on Add to cart
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)
					break;
				
			}
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		
	}

}