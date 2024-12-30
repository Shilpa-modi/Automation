package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Website {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"shopify-section-sections--16443441807530__header\"]/height-observer/x-header/nav[1]/ul/li[1]/details/summary")
	WebElement ClickNew;
	@FindBy(xpath="//*[@id=\"product-list-template--16443445608618__main\"]/product-card[1]/div[1]/a")
	WebElement ClickItem;
	@FindBy(xpath = "//*[@id=\"shopify-block-wishlist_engine_product_page_bgTNAV\"]/div/div/span[2]")
	WebElement AddToWishlist;
	@FindBy(xpath = "//*[@id=\"gokwik-buy-now\"]")
	WebElement AddToCart;
	@FindBy(xpath="//*[@id=\"close_button\"]/img")
	WebElement AdClose;
	
	public Website(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void adClosePrg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login-wrapper\"]")));
		AdClose.click();
	}
	public void clickNewPrg() {
		ClickNew.click();
	}
	public void clickItemPrg() {
		ClickItem.click();
	}
	public void AddToWishListPrg() {
		AddToWishlist.click();
	}
	public void CartPrg() {
		AddToCart.click();
	}

}
