package selenium;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;			//IMP 

public class U11_2_MultiWindows {
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		
//U11.67 Invoke Multi Window
		
		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");
		
		//Getting IDs of windows
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> itr = handles.iterator();
		
		String parentWindowHandle = itr.next();
		String childWindowHandle = itr.next();
		
		driver.switchTo().window(childWindowHandle);
		
		//open codenbox on new window
		driver.get("https://codenbox.com");
//		String title = driver.getTitle();
		driver.switchTo().window(parentWindowHandle);
		
		WebElement show = driver.findElement(By.id("show-textbox"));
		driver.findElement(with(By.tagName("input")).toLeftOf(show)).click();
	
		
	}
}
