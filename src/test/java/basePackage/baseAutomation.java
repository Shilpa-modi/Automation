package basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class baseAutomation {
public static WebDriver driver;

@BeforeTest
public void setup() {
	driver=new ChromeDriver();
	driver.get("http://automationpractice.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
}

}
