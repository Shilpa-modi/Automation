package testPackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.baseAutomation;
import pagePackage.PageAutomation;

public class testAutomation extends baseAutomation{
	@Test
	public void click() {
		driver.findElement(By.xpath("/html/body/center/center")).click();
		
		PageAutomation obj=new PageAutomation(driver);
		
	}

}
