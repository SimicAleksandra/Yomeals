package tests;

import java.io.IOException;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest {

	@Test
	public void addMealToCart() throws InterruptedException {

		this.driver.get(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopUpPage.closeLocationDialog();

		mealPage.addMealToCart("3");
		sa.assertTrue(notificationSystemPage.errorMsgCheck());
		notificationSystemPage.waitForMsgToDisappear();

		locationPopUpPage.openLocationDialog();
		locationPopUpPage.setLocation("City Center - Albany");
		Thread.sleep(2000);

		mealPage.addMealToCart("3");
		sa.assertTrue(notificationSystemPage.mealAddedMsgCheck());
		notificationSystemPage.waitForMsgToDisappear();

		sa.assertAll();
	}

	@Test
	public void bAddMealToFavorites() throws InterruptedException {

		this.driver.get(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopUpPage.closeLocationDialog();
		Thread.sleep(2000);

		mealPage.addMealToFavorites();
		sa.assertTrue(notificationSystemPage.pleaseLoginFirst());
		notificationSystemPage.waitForMsgToDisappear();

		this.driver.get(baseUrl + "/guest-user/login-form");
		loginPage.userLogin(this.baseEmail, this.basePassword);
		Thread.sleep(2000);

		this.driver.get(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.addMealToFavorites();
		sa.assertTrue(notificationSystemPage.productAddedToFavorites());
		notificationSystemPage.waitForMsgToDisappear();

		sa.assertAll();
	}

	@Test
	public void clearCart() throws InterruptedException, IOException {

		this.driver.get(this.baseUrl + "meals");
		locationPopUpPage.setLocation("City Center - Albany");
		Thread.sleep(2000);

		for (int i = 1; i <= sheetForm.getLastRowNum(); i++) {

			driver.get(sheetForm.getRow(i).getCell(0).getStringCellValue());
			mealPage.addMealToCart("1");
			sa.assertTrue(notificationSystemPage.mealAddedMsgCheck());
			Thread.sleep(2000);
			notificationSystemPage.waitForMsgToDisappear();
		}
		
		cartSummaryPage.clearCart();
		
		notificationSystemPage.waitForAllMealsRemovedMsgToAppear();
		
		sa.assertTrue(notificationSystemPage.allMealsRemoved());
		
		notificationSystemPage.waitForMsgToDisappear();

		sa.assertAll();
	}

}
