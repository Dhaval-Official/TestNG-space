package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class U10_1_HTTPS_Certification {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
//U10.61 Certification Issues
		//Normal Scenario
		driver.manage().window().maximize();
		driver.get("https://self-signed.badssl.com");
		System.out.println(driver.getTitle());
				
		
		ChromeOptions option = new  ChromeOptions();
		option.setAcceptInsecureCerts(true);
		WebDriver driver2 = new ChromeDriver(option);
		driver2.manage().window().maximize();
		driver2.get("https://self-signed.badssl.com");
		Thread.sleep(5000);
		System.out.println(driver2.getTitle());
				
		
		
		System.out.println("Done Close browsers manually");
		
	}
}
