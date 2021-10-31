package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	private JavascriptExecutor js;

	public LocationPopupPage(WebDriver driver) {
		super(driver);
		this.js = (JavascriptExecutor) driver;
	}

	public WebElement getSelectLocation() {
		return this.driver.findElement(By.xpath("//*[@class= 'location-selector']/a"));
	}

	public WebElement getCloseBtn() {
		return this.driver.findElement(By.xpath("//*[@class='model-box-mid location-search']/a"));
	}

	public WebElement getKeyword() {
		return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return this.driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void openLocationDialog() {
		this.driver.findElement(By.xpath("//*[@class='location-selector']/a")).click();
	}

	public void setLocation(String locationName) throws InterruptedException {
		this.getKeyword().click();
		Thread.sleep(2000);
		String dataValue = this.getLocationItem(locationName).getAttribute("data-value");
		Thread.sleep(2000);
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), dataValue);
		js.executeScript("arguments[0].click();", this.getSubmit());
	}

	public void closeLocationDialog() {
		this.getCloseBtn().click();
	}

}
