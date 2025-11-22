package selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class U07_SeleniumWaits {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
	
//U7 Waits

		driver.manage().window().maximize();
		
//Implicit wait 
		//this applies to all findElement Methods 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		//this applies to loading page
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		//this apples to script internal waits
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		
		driver.get("https://google.com/");
		
		driver.findElement(By.name("q")).sendKeys("codenbox"+Keys.ENTER);	
			
//Explicit Waits 
		//~ VerifyObjectPresent in SAFAL
		WebDriverWait waitExpli = new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement link = waitExpli.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Codenbox – IT Solution & Services']")));
		link.click();
			
//Fluent Wait 
		//~ VerifyObjectPresent in SAFAL with internal loops so that no need to check every milisecond
		//Max time for web driver to wait for a condition ~ checks Element in intervals for time till it is present
		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))							//total max wait time
				.pollingEvery(Duration.ofSeconds(5))							//gap of wait time to check for i.e. here total 2 times will be checked at gaps of t seconds
				.ignoring(NoSuchElementException.class);
		
		fluent.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Codenbox – IT Solution & Services']")));

		
	}

}
