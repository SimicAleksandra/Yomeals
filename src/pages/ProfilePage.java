package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ProfilePage extends BasicPage {
	private JavascriptExecutor js;

	public ProfilePage(WebDriver driver) {
		super(driver);
		this.js = (JavascriptExecutor) driver;
	}

	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}

	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));
	}

	public WebElement getPhone() {
		return this.driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));
	}

	public Select getCountry() {
		Select selectCountry = new Select(this.driver.findElement(By.xpath("//*[@id = 'user_country_id']")));
		return selectCountry;
	}

	public Select getState() {
		Select selectState = new Select(this.driver.findElement(By.xpath("//*[@id = 'user_state_id']")));
		return selectState;
	}

	public Select getCity() {
		Select selectCity = new Select(this.driver.findElement(By.xpath("//*[@id = 'user_city']")));
		return selectCity;
	}

	public WebElement getSaveBtn() {
		return this.driver.findElement(
				By.xpath("//*[@class= 'col-lg-12 col-md-12 col-sm-12 col-lg-12 align--right']//*[@name= 'btn_submit']"));
	}

	public WebElement getUploadBtn() {
		return this.driver.findElement(By.xpath("//*[@class = 'hover-elemnts']/a[1]/i"));
	}

	public void uploadPhoto() throws IOException, AWTException {
		js.executeScript("arguments[0].click();", this.getUploadBtn());

//		File image = new File("img/Aleksandra Simic.jpg");
//		String photo = image.getCanonicalPath();
		String photo = new File("img/image.png").getCanonicalPath();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		this.driver.findElement(By.xpath("//*[@id = 'form-upload']/input")).sendKeys(photo);
	}

	public WebElement getRemovePhotoBtn() {
		return this.driver.findElement(By.xpath("//*[@class= 'hover-elemnts']/a[2]/i"));
	}

	public void removePhoto() {
		js.executeScript("arguments[0].click();", this.getRemovePhotoBtn());
	}

	public void inputPersonalInfo(String firstName, String lastName, String address, String phoneNum, String zipCode,
			String country, String state, String city) throws InterruptedException {

		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		Thread.sleep(500);

		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		Thread.sleep(500);

		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		Thread.sleep(500);

		this.getPhone().clear();
		this.getPhone().sendKeys(phoneNum);
		Thread.sleep(500);

		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		Thread.sleep(500);

		this.getCountry().selectByVisibleText(country);
		Thread.sleep(500);

		this.getState().selectByVisibleText(state);
		Thread.sleep(500);

		this.getCity().selectByVisibleText(city);
		Thread.sleep(500);

		js.executeScript("arguments[0].scrollIntoView()", this.getZipCode());
		Thread.sleep(500);
		this.getSaveBtn().click();
		Thread.sleep(500);
	}

}
