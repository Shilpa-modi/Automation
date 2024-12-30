package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.Website;

public class testWebsite extends BaseClass {
	
	@Test
	public void janasya() {
		Website obj=new Website(driver);
		obj.adClosePrg();
		obj.clickNewPrg();
		obj.clickItemPrg();
		obj.AddToWishListPrg();
		obj.CartPrg();
	}

}
