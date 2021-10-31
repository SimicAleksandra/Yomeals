package tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test
	public void aEditProfile() throws InterruptedException {

		this.driver.get(baseUrl + "/guest-user/login-form");
		locationPopUpPage.closeLocationDialog();
		loginPage.userLogin(this.baseEmail, this.basePassword);

		sa.assertTrue(notificationSystemPage.loginMsgCheck());
		notificationSystemPage.waitForMsgToDisappear();

		this.driver.get(baseUrl + "/member/profile");
		Thread.sleep(2000);

		profilePage.inputPersonalInfo("Donald", "Trump", "TrumpTower", "666", "999", "United States", "Arizona",
				"Parker");
		Thread.sleep(2000);

		sa.assertTrue(notificationSystemPage.setupMsgCheck());
		notificationSystemPage.waitForMsgToDisappear();

		authPage.logout();
		sa.assertTrue(notificationSystemPage.loginMsgCheck());
		notificationSystemPage.waitForMsgToDisappear();

		sa.assertAll();
	}
//
//	@Test
//	public void bChangeProfileImage() throws InterruptedException, IOException, AWTException {
//		
//		this.driver.get(baseUrl + "/guest-user/login-form");
//		locationPopUpPage.closeLocationDialog();
//		loginPage.userLogin(this.baseEmail, this.basePassword);
//
//		sa.assertTrue(notificationSystemPage.loginMsgCheck());
//		notificationSystemPage.waitForMsgToDisappear();
//
//		this.driver.get(baseUrl + "/member/profile");
//		Thread.sleep(2000);
//		
//		profilePage.uploadPhoto();
//		Thread.sleep(500);
//		sa.assertTrue(notificationSystemPage.profileImgAddedMsgCheck());
//		notificationSystemPage.waitForMsgToDisappear();
//		
//		profilePage.removePhoto();
//		sa.assertTrue(notificationSystemPage.profileImgRemovedMsgCheck());
//		notificationSystemPage.waitForMsgToDisappear();
//		
//		authPage.logout();
//		notificationSystemPage.loginMsgCheck();
//		notificationSystemPage.waitForMsgToDisappear();
//	}

}
