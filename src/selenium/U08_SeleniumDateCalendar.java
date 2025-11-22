package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class U08_SeleniumDateCalendar {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
//U8.55 Selecting Date 
		 	
		driver.get("https://codenboxautomationlab.com/about/booking/");
		driver.manage().window().maximize();

		Thread.sleep(3000);
		
		//Selecting a future month & Year
		String bookingMonth= driver.findElement(By.cssSelector("div[class='datepick-header'] span:nth-child(1)")).getText();
		String bookingYear= driver.findElement(By.cssSelector("div[class='datepick-header'] span:nth-child(2)")).getText();
		
		
		while(!(bookingMonth.equalsIgnoreCase("December") && bookingYear.equals("2025"))) {
			
			driver.findElement(By.xpath("//a[normalize-space()='»']")).click();
			bookingMonth = driver.findElement(By.cssSelector("div[class='datepick-header'] span:nth-child(1)")).getText();
			bookingYear = driver.findElement(By.cssSelector("div[class='datepick-header'] span:nth-child(2)")).getText();
		}
		
		driver.findElement(By.xpath("//a[normalize-space()='9']")).click();
		
		

//U8.56 Selecting Time & Details (Continued) 		

		
		WebElement timeSlot = driver.findElement(By.id("rangetime1"));
		timeSlot.click();
		Select s = new Select(timeSlot);
		s.selectByValue("17:00 - 18:00");
		Thread.sleep(3000);
		System.out.println(timeSlot.isDisplayed());
		
		driver.findElement(By.id("name1")).sendKeys("Dhaval");
		driver.findElement(By.id("secondname1")).sendKeys("Lakhani");
		driver.findElement(By.id("email1")).sendKeys("Testing@gmail.com");
		driver.findElement(By.id("details1")).sendKeys("Learning Selenium");
		driver.findElement(By.cssSelector("button[type='button']")).click();
		
		Thread.sleep(3000);
		//booking confirmation
		String confirm = driver.findElement(By.xpath("//div[@class='wpbc_ty__message ']")).getText();
		
		if(confirm.contains("Many Thanks")) {
			System.out.println("Booking Done");
		} else {
			System.out.println("Booking not received");
		}

	
	}
}
