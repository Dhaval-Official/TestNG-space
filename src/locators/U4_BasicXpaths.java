package locators;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 

public class U4_BasicXpaths {
	
	public static void main(String[]  args) throws InterruptedException  {
			
		WebDriver driver = new ChromeDriver();
//		driver.get("https://codenboxautomationlab.com/practice/");
//		driver.get("https://codenbox.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());

		
//U4.28	Basic 6/8 Locators	
		
		//Using ID locator
		//driver.findElement(By.id("openwindow")).click();
		
		//Using Name
		//driver.findElement(By.name("enter-name")).sendKeys("Selenium");
		
		//Using className
		//driver.findElement(By.className("radioButton")).click();
		
		//Using linkText
		//driver.findElement(By.linkText("LinkedIn Profile")).click();
		
		//Using PartialLinkText
		//driver.findElement(By.partialLinkText("Set up a CI/CD ")).click();
		
		//Using Tag
		//int a = driver.findElements(By.tagName("a")).size();
		//System.out.println(a);
		

//U4.29 Xpaths & CSS Selectors

		//driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		//driver.findElement(By.xpath("//*[@id='alertbtn']")).click();
		
		//Using CSS Selector
		//driver.findElement(By.cssSelector("input[id='hide-textbox']")).click();
		//driver.findElement(By.cssSelector("input#hide-textbox")).click();
		//driver.findElement(By.cssSelector(".btn-style class2")).click();
		//driver.findElement(By.cssSelector(".btn-style.class2")).click();
		
//U4.30	Advance locators text()
		
		//driver.findElement(By.xpath("//a[text()='twitter.com']")).click();
		
		//Advance locators contains()
		//driver.findElement(By.xpath("//a[contains(@herf,'twitter.com')]")).click();
		
		//Advance locators Parent -> Child
		//driver.findElement(By.xpath("//*[@id=\"meta-4\"]//ul//li[1]//a[text()='Log in']")).click();
				

//U4.31 Custom Dynamic Xpaths Dynamic Parent -> Child
		
		//Problem Statement: Search facebook n google& then click on facebook login
/*		
		driver.get("https://google.com");
		
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("facebook");
		
		Thread.sleep(3000);
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@jsname='bw4e9b']//li//div[@class='wM6W7d']"));		
		 
		int count = list.size();
		System.out.println(count);
		
		for(int i=0;i<count;i++) {
			String text=list.get(i).getText();
			System.out.println(text);
			
			if(text.equals("facebook login")) {
				list.get(i).click();
				break;
			}
		}
*/	
//U4.32->34 Parents & Children	
		
		//Problem Statement: Match a total in a table
		
		driver.get("https://codenboxautomationlab.com/practice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement table = driver.findElement(By.xpath("//table[@id='product']"));
		//this will limit driver's scope
		table.findElements(By.cssSelector("tale tr"));
		int numRows = table.findElements(By.cssSelector("table tr")).size();
		System.out.println(numRows);
		int total = 0;
		
		
		//Parent -> Child 
		for(int i=0;i<numRows-2;i++) {
			//Parent -> Child 
			String pricetxt = table.findElements(By.cssSelector("tr td:nth-child(3)")).get(i).getText();	//"10"
			int price = Integer.parseInt(pricetxt);
			total = total + price;
		}
		System.out.println(total);
		total = 0;
		for(int i=0;i<numRows-2;i++) {
			//Parent -> Child 
			String pricetxt = table.findElements(By.xpath("//table[@id='product']//tr//td[3]")).get(i).getText();	
			int price = Integer.parseInt(pricetxt);
			total = total + price;
		}
		System.out.println("S14 Parent to child"+total);
		//String pricetxt = table.findElement(By.cssSelector("tbody tr:nth-child(12) td:nth-child(3)")).getText();	//this also works		
		
		
		//Sibling -> Sibling
		String pricetxt = table.findElement(By.xpath("//tbody//tr[12]//td/following-sibling::td[2]")).getText();	//this also works
		int total2 = Integer.parseInt(pricetxt)+1;
		//logic check
		if(total == total2) {
			System.out.println("Value Matches");
		} else {
			System.out.println("Value Does not Match");
		}
		
		
		//Child -> Parent
		WebElement table2 = driver.findElement(By.xpath("//tbody//tr[12]//td[1]/parent::tr/parent::tbody"));
		table2.findElements(By.cssSelector("tale tr"));
		int numRows2 = table2.findElements(By.cssSelector("table tr")).size();
		System.out.println("From table2 "+numRows2);
		
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("Done");
		
	}
}
