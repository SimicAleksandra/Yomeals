package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {
	private WebDriverWait waiter;

	public NotificationSystemPage(WebDriver driver) {
		super(driver);

		this.waiter = new WebDriverWait(driver, 15);
	}

	public WebElement getNotificationMsg() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}

	public WebElement getAllMealsRemovedNotificationMsg() {
		return this.driver.findElement(By.xpath("//*[@class = 'content']"));
	}
	
	public String notificationMsg() {
		String msg = this.getNotificationMsg().getText();
		return msg;
	}
	
	public String allMealsRemovedNotificationMsg() {
		String msg = this.getAllMealsRemovedNotificationMsg().getText();
		return msg;
	}

	public boolean loginMsgCheck() {
		if (this.notificationMsg().contains("Login Successfull")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean setupMsgCheck() {
		if (this.notificationMsg().contains("Setup Successful")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean logoutMsgCheck() {
		if (this.notificationMsg().contains("Logout Successfull!")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean errorMsgCheck() {
		if (this.notificationMsg().contains("The Following Errors Occurred")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean mealAddedMsgCheck() {
		if (this.notificationMsg().contains("Meal Added To Cart")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean pleaseLoginFirst() {
		if (this.notificationMsg().contains("Please login first!")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean productAddedToFavorites() {
		if (this.notificationMsg().contains("Product has been added to your favorites.")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean allMealsRemoved() {
		if (this.allMealsRemovedNotificationMsg().contains("All meals removed from Cart successfully")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean profileImgAddedMsgCheck() {
		if (this.notificationMsg().contains("Profile Image Uploaded Successfully")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean profileImgRemovedMsgCheck() {
		if (this.notificationMsg().contains("Profile Image Deleted Successfully")) {
			return true;
		} else {
			return false;
		}
	}
	
	public WebDriverWait waitForAllMealsRemovedMsgToAppear() {
		this.waiter.until(ExpectedConditions.textToBePresentInElement(getAllMealsRemovedNotificationMsg(), "All meals removed from Cart successfully"));
		return waiter;
	}
	

	public WebDriverWait waitForMsgToDisappear() {
		this.waiter.until(ExpectedConditions.attributeContains((By.xpath("//*[contains(@class, 'system_message')]")),
				"style", "display: none;"));
		return waiter;
	}
	
}

