import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;



public class Dropdown {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");

WebDriver driver =new ChromeDriver();

driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //URL in the browser

//  //a[@value='MAA']  - Xpath for chennai


//  //a[@value='BLR']


driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

driver.findElement(By.xpath("//a[@value='BLR']")).click();

Thread.sleep(2000);


//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();



//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

driver.findElement(By.id("autosuggest")).sendKeys("ind");
Thread.sleep(3000);
List <WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a "));
for(WebElement option: options) {
	if(option.getText().equalsIgnoreCase("India")) {
		option.click();
		break;
	}
	
}




}





}
