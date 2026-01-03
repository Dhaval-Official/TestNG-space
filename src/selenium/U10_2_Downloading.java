package selenium;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class U10_2_Downloading {
	public static void main(String[] args) throws InterruptedException {

//U10.62 Downloads

		// setting chrome options to enable download prompts & specify locations
		// initializing chrome options
		ChromeOptions option = new ChromeOptions();

		HashMap<String, Object> hm = new HashMap<>();

		// getting user directory
		String dfilePath = System.getProperty("user.dir");
		System.out.println(dfilePath);

		hm.put("profile.default_content_settings.popups", 0);
		hm.put("download.default_directory", dfilePath);

		option.setExperimentalOption("prefs", hm);

		// checking if file already exists
		File downloadDir = new File(dfilePath);
		File[] downloadedFiles = downloadDir.listFiles();
		if (downloadedFiles != null) {
			for (File file : downloadedFiles) {
				if (file.getName().startsWith("APKFiles")) {
					file.delete();
					System.out.println("Deleted old Files " + file.getName());
				}
			}
		}

		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://codenboxautomationlab.com/practice/");

		driver.findElement(By.linkText("Download Apk files")).click();
		Thread.sleep(40000);

		File downloadedFile = new File(dfilePath + "/APKFiles-1.zip");
		if (downloadedFile.exists()) {
			System.out.println("Downloaded Successfully");
		} else {
			System.out.println("Didn't Downloaded Successfully");
		}

	}
}
