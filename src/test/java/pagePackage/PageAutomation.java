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
	@Test
public void login() throws IOException {
	driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/div[3]/a")).click();
	FileInputStream fi=new FileInputStream("C:\\Users\\user\\Downloads\\Pass1.xlsx");
	XSSFWorkbook wk=new XSSFWorkbook(fi);
	XSSFSheet sh=wk.getSheet("Sheet1");
	int rowCount=sh.getLastRowNum();
	
	for(int i=1;i<=rowCount;i++) {
		String username=sh.getRow(i).getCell(0).getStringCellValue();
		String pass=sh.getRow(i).getCell(1).getStringCellValue();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-submit")).click();
		
		//driver.navigate().to("https://www.inmotionhosting.com/");
	}
	driver.switchTo().defaultContent();

}
@Test
public void verify() {
	String s=driver.getCurrentUrl();
	String exp="abc";
	if(s.equals(exp))
	{
		System.out.println("Pass");
	}
	else {
		System.out.println("Fail");
	
}
}

@Test
public void title() {
	String a=driver.getTitle();
	System.out.println("Title is "+a);
}
}





