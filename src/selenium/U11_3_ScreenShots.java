package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class U11_3_ScreenShots {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

//U11_68 Screenshot

		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");

		WebElement myName = driver.findElement(By.id("name"));
		myName.sendKeys("Dhaval");

		// taking a pic
		File srcFile = myName.getScreenshotAs(OutputType.FILE);

		String destn = System.getProperty("user.dir");
		System.out.println(destn);
		FileUtils.copyFile(srcFile, new File(destn + "/testOutput/" + "name.png"));

		driver.quit();
		System.out.println("Done");
		System.out.println("Dummy Changes for Git7");

	}
}
