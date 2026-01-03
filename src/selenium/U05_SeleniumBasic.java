package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class U05_SeleniumBasic {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
//U5.36 Basic url Navigation 		
/*		
		driver.get("https://google.ca/");
			
		driver.manage().window().maximize();
		System.out.println("Google title for 1st visit is: "+driver.getTitle());
			
		Thread.sleep(2000);
		
		driver.navigate().to("https://codenbox.com/");
		System.out.println("Codenbox title for 1st visit is: "+driver.getTitle());
		
		Thread.sleep(2000);
			
		driver.navigate().back();			//goes back to ggogle.ca
		System.out.println("Google title for 2nd visit is: "+driver.getTitle());
		
		Thread.sleep(1000);
		
		driver.navigate().forward();		//goes back to codenbox.com
		System.out.println("Codenbox title for 2nd visit is: "+driver.getTitle());

		Thread.sleep(1000);
*/		

			
//U5.37	Static Drop downs
/*	
	 	driver.get("https://www.goindigo.in/"); //Site is Risky
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//div[@class='notsearchable booking-widget-field']//span[text()='Travellers + Special Fares']")).click();
		
		WebElement addPassenger = driver.findElement(By.xpath("//div[@aria-label=\"Senior Citizen (>60 years)\"]/parent::div/parent::div//i[2]"));
		addPassenger.click();
		addPassenger.click();
*/		


//U5.38	Dynamic Drop downs
/*
		driver.get("https://codenboxautomationlab.com/practice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("can");
		
		Thread.sleep(2000);
		
		//locate list of search results
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		int count = list.size();
		System.out.println(count);
		
		for(int i=0;i<count;i++) {
			String country =  list.get(i).getText();
			if(country.equalsIgnoreCase("canada")) {
				list.get(i).click();
				break;
			}
		}
		System.out.println("Nothing found");
*/		
		
		
//U5.39 Mouse & Keyboard keys

/* 		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");
		
		Actions a = new Actions(driver);		//Argument is the driver that will do the work
		
		//Hover Mouse
		WebElement courses =  driver.findElement(By.xpath("//li[@id='menu-item-63']"));
		a.moveToElement(courses).build().perform();
		Thread.sleep(2000);
		
		//Hold Shift & Search
		WebElement search = driver.findElement(By.xpath("(//input[@placeholder=\"Search...\"])[2]"));
		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("selenium").doubleClick().build().perform();
		Thread.sleep(2000);
		
		//Right click & open in new tab
		WebElement youtube = driver.findElement(By.linkText("Free courses on YouTube"));
		a.moveToElement(youtube).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
*/		

		
//U5.40 Radio button
/*
 		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");
		
		//select 2nd radio button
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		
		//select group of radio button * click on radio3
		List<WebElement> rdButtons = driver.findElements(By.cssSelector(".radioButton"));
		int count = rdButtons.size();
		
		for(int i=0;i<count;i++) {
			String radioName = rdButtons.get(i).getAttribute("value");
			if(radioName.equalsIgnoreCase("radio3")) {
				rdButtons.get(i).click();
				//	break;
				//isSelected Method: returns boolean
				System.out.println(rdButtons.get(i).isSelected());
				break;
			}
			
		}
*/		
		

//U5.41 CheckBox
/*
 		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");
		
		//selecting option 2 & 3
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		WebElement checkbox = driver.findElement(By.id("checkBoxOption3"));
		checkbox.click();
		System.out.println(checkbox.isSelected());
*/		
		

//U5.42 Alert
	
/* 		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");
		
		driver.findElement(By.id("name")).sendKeys("Hii");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
*/		
		
		
		
//U5.43 Cookies
/*		
 		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		//Get all cookies
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println(allCookies.size());
	
		for(Cookie cookie: allCookies) {
			System.out.println(cookie.getName() + "\t" +cookie.getValue() + "\t" + cookie.getPath() + "\t" + cookie.getDomain());	
		}
		driver.manage().deleteAllCookies();
		
		Set<Cookie> allCookiesAfterDelete = driver.manage().getCookies();
		System.out.println(allCookiesAfterDelete.size());
*/		
		

//U5.44 Broken Links
/*
 		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/");
		driver.manage().deleteAllCookies();
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		for(WebElement link :allLinks) {
			
			String url = link.getAttribute("href");
			
			//verify if URL is empty 
			if(url == null || url.isEmpty()) {
				System.out.println("url is empty");
				continue;
			}			
			//if it's not empty check url is broken or invalid
			try {
				
				HttpURLConnection urlRequest = (HttpURLConnection)(new URL(url).openConnection());
				urlRequest.connect();	//connects to server
				if(urlRequest.getResponseCode() >= 400) {
					System.out.println(url + " is Broken");
				} else {
					System.out.println(url + " is valid");
				}
				
			} catch(IOException e) {
				System.out.println(url + " is Invalid");
				e.printStackTrace();
			}
			
		}
*/
			

			
		System.out.println("Done Close the browser Manually");
	}
}
