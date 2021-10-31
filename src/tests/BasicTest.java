package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.Login_Page;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected String baseUrl;
	protected String baseEmail;
	protected String basePassword;
	protected LocationPopupPage locationPopUpPage;
	protected Login_Page loginPage;
	protected NotificationSystemPage notificationSystemPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;
	protected SoftAssert sa;
	protected File file;
	protected FileInputStream fis;
	protected XSSFWorkbook wb;

	protected XSSFSheet sheetForm;

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "driver_lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 10);
		this.baseUrl = "http://demo.yo-meals.com/";
		this.baseEmail = "customer@dummyid.com";
		this.basePassword = "12345678a";
		this.locationPopUpPage = new LocationPopupPage(driver);
		this.loginPage = new Login_Page(driver);
		this.notificationSystemPage = new NotificationSystemPage(driver);
		this.profilePage = new ProfilePage(driver);
		this.authPage = new AuthPage(driver);
		this.mealPage = new MealPage(driver);
		this.cartSummaryPage = new CartSummaryPage(driver);

		this.file = new File("data/Data (1).xlsx");
		this.fis = new FileInputStream(file);
		this.wb = new XSSFWorkbook(fis);
		this.sheetForm = wb.getSheet("Meals");

		this.sa = new SoftAssert();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public static void screenshot(WebDriver driver) throws IOException, InterruptedException {

		String timestamp = new SimpleDateFormat("yyyy-MMM-dd HH-mm-ss").format(new Date());

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("screenshots\\" + timestamp + ".jpeg"));

	}

	@AfterMethod
	public void afterClass() throws InterruptedException {

		Thread.sleep(2000);
		driver.quit();
	}

}
