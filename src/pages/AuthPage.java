package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getProfileOptionBtn() {
		return this.driver.findElement(By.xpath("//*[@class= 'filled ']/a"));
	}

	public WebElement getLogoutBtn() {
		return this.driver.findElement(By.xpath("//*[@class= 'my-account-dropdown']/ul/li[2]/a"));
	}
	
	public void logout() throws InterruptedException {
		this.getProfileOptionBtn().click();
		Thread.sleep(1000);
		this.getLogoutBtn().click();
		Thread.sleep(1000);
		
	}

}
