package pagePackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAutomation {
WebDriver driver;

public PageAutomation(WebDriver driver) {
	this.driver=driver;

	
	List<WebElement> el=driver.findElements(By.tagName("a"));
	int i=el.size(); 
	  System.out.println("Count of Links:"+i);
	  

	  for(int j=0;j<i;j++) {
		  WebElement link=driver.findElements(By.tagName("a")).get(j);
		  String url=link.getAttribute("href");
		  if(url==null||url.isEmpty()) {
			  System.out.println("Empty or missing url");
			  continue;
		  }
		  String txt=link.getText();
		 
		  find(url,txt);
	  }

}
private void find(String url,String txt) {

	try {
		  URL u=new URL(url);
		  HttpURLConnection h=(HttpURLConnection)u.openConnection();

		  int code=h.getResponseCode();
		
		  
		  if(code==200) {
			  WebElement display=driver.findElement(By.linkText(txt));
			  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(90));
			  wait.until(ExpectedConditions.visibilityOfAllElements(display));
			  
			  System.out.println(" Success Link:"+txt+"\n \t"+url+"\n");
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		  }
		  
		  else {
			  System.out.println("Failed link."+url+"\t"+"Response code:"+code);
		  }
		  
		
	}
	 
	catch(Exception e) {
		System.out.println("Exception Field");		}
	

}
}





