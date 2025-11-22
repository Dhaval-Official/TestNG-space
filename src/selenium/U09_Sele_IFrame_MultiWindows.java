package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class U09_Sele_IFrame_MultiWindows {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
//U9.58 IFrame
/*		
		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");
		
		int framesNums = driver.findElements(By.tagName("iframe")).size();
		System.out.println(framesNums);
		
		//switching into the Frame
		driver.switchTo().frame(0);
		String features = driver.findElement(By.xpath("//span[normalize-space()='Awesome features']")).getText();
		//other xpath span[contains(text(),'Awesome features')]
		System.out.println(features);
		
		//getting out of the frame
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("LinkedIn Profile")).click();
*/		
	
		
//U9.59 MultiWindow
/*		
		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");
		
		String parentWindowId = driver.getWindowHandle();
		
		driver.findElement(By.id("openwindow")).click();		//new Window
		driver.findElement(By.linkText("Open Tab")).click();	//new Tab
		
		Thread.sleep(3000);
		
		Set<String> multiWindowIds = driver.getWindowHandles();
		
		for(String ids: multiWindowIds) {
			driver.switchTo().window(ids);
			System.out.println(driver.getTitle());
		}
		
		//getting back to parent Window
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.cssSelector("input[value='radio1']")).click();
*/		

		System.out.println("Done");
		
		
	}
}
