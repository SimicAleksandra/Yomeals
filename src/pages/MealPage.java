package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getAddToCartBtn() {
		return this.driver.findElement(By.xpath("//*[@class= 'btn btn--primary btn--large js-proceedtoAddInCart ']"));
	}

	public WebElement getQty() {
		return this.driver.findElement(By.xpath("//*[@name= 'product_qty']"));
	}

	public WebElement getFavoriteBtn() {
		return this.driver.findElement(By.xpath("//*[contains(@d, 'M475.366,71.951c-24.175-23.606-57.575-35.404-100.215-35')]"));
	}

	public void addMealToCart(String quantity) throws InterruptedException {
		this.getQty().sendKeys(Keys.CONTROL + "a");
		this.getQty().sendKeys(quantity);
		this.getAddToCartBtn().click();
	}

	public void addMealToFavorites() {
		this.getFavoriteBtn().click();
	}
}
