package selenium;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class U11_1_Relative_Locators {
	
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

//U11.65 & .66

		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");
		System.out.println("Done2");

		// above() - Find Element above of Open Tab btn
		WebElement openTab = driver.findElement(By.id("opentab"));
		String ele = driver.findElement(with(By.tagName("legend")).above(openTab)).getText();

		System.out.println(ele);

		// below() - Find Element below of Enable btn
		WebElement enable = driver.findElement(By.id("enabled-button"));
		driver.findElement(with(By.tagName("input")).below(enable)).sendKeys("Best Selenium Course");

		// S35: relative Locators 2

		// near() - click on 1st check box
		WebElement checkBox = driver.findElement(By.xpath("//legend[text()='Checkbox Example']"));
		driver.findElement(with(By.tagName("input")).near(checkBox)).click();

		// toLeftOf click on Hide btn which is on left of Show Btn
		WebElement show = driver.findElement(By.id("show-textbox"));
		driver.findElement(with(By.tagName("input")).toLeftOf(show)).click();

		// toRightOf click on Alert btn which is on Right of text Field
		WebElement textField = driver.findElement(By.id("name"));
		driver.findElement(with(By.tagName("input")).toRightOf(textField)).click();
	}
}
