package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class U06_SeleniumMid {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
//U5

//isDisplayed		
		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");
		
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		WebElement showBtn = driver.findElement(By.id("show-textbox"));
		WebElement hideBtn = driver.findElement(By.id("hide-textbox"));
		
		System.out.println("text box is "+textBox.isDisplayed());
		
		hideBtn.click();
		System.out.println("text box is "+textBox.isDisplayed());
		
		showBtn.click();
		System.out.println("text box is "+textBox.isDisplayed());
		
//isEnabled
		WebElement textBox2 = driver.findElement(By.id("enabled-example-input"));
		WebElement disableBtn = driver.findElement(By.id("disabled-button"));
		WebElement enableBtn = driver.findElement(By.id("enabled-button"));
		
		System.out.println(textBox2.isEnabled());
		disableBtn.click();
		Thread.sleep(3000);
		System.out.println(textBox2.isEnabled());
		enableBtn.click();
		Thread.sleep(3000);
		System.out.println(textBox2.isEnabled());
		
//isSelected
		WebElement rd1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		System.out.println("Radio Btn");
		System.out.println(rd1.isSelected());
		rd1.click();
		System.out.println(rd1.isSelected());

		
	}
}
