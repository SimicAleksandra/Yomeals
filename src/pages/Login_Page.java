package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page extends BasicPage {

	public Login_Page(WebDriver driver) {
		super(driver);
	}

	public WebElement getLoginBtn() {
		return this.driver.findElement(By.xpath("//*[@class = 'filled']/a"));
	}

	public WebElement getUsername() {
		return this.driver.findElement(By.xpath("//*[@name = 'username']"));
	}

	public WebElement getPassword() {
		return this.driver.findElement(By.xpath("//*[@name = 'password']"));
	}

	public WebElement getSubmitBtn() {
		return this.driver.findElement(By.xpath("//*[@class = 'btn btn--primary btn--block']"));
	}

	public void userLogin(String email, String password) throws InterruptedException {
//		this.getLoginBtn().click();
//		Thread.sleep(500);
		this.getUsername().clear();
		Thread.sleep(500);
		
		this.getUsername().sendKeys(email);
		Thread.sleep(500);
		
		this.getPassword().clear();
		Thread.sleep(500);
		
		this.getPassword().sendKeys(password);
		Thread.sleep(500);
		
		this.getSubmitBtn().click();
		Thread.sleep(500);
	}

}
