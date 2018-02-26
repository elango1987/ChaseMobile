package com.chase.stepdefinitions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ChaseLogon {

	File appPath = new File("resources/ChaseMobile.apk");
	DesiredCapabilities cap;
	AppiumDriver<?> driver;

	public void setupAndroidDriver() throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
		cap.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	public void initializeApp() {
		driver.findElement(By.id("android:id/button1")).click();
		WebElement allowLocationPermission = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.presenceOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
		allowLocationPermission.click();
		WebElement allowMediaPermission = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.presenceOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
		allowMediaPermission.click();
		WebElement alternateLoginScreen = (new WebDriverWait(driver, 10).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='Log On']"))));
		alternateLoginScreen.isDisplayed();
		
	}

	public void validateAlternateLogOnScreen() {
		
		if ((driver.findElement(By.xpath("//android.widget.Button[@text='Log On']")).isDisplayed())
				&& driver.findElement(By.xpath("//android.widget.Button[@text='Enroll']")).isDisplayed())
			System.out.println("Alternate Log on is displayed");
		else {
			System.out.println("Alternate Log on is not displayed");
		}
	}

	public void resetApp() {
		driver.resetApp();
		driver.quit();
	}

	////////////////////////////////////////////////////////////////////////////////////
	// Scenario: User Installs and Launches the app for the first time
	////////////////////////////////////////////////////////////////////////////////////

	@Given("^The user installs the app$")
	public void the_user_installs_the_app() throws Throwable {
		setupAndroidDriver();
	}

	@When("^the user launches the app$")
	public void the_user_launches_the_app() throws Throwable {
		initializeApp();
	}

	@Then("^the Alternate log on screen is displayed\\.$")
	public void the_Alternate_log_on_screen_is_displayed() throws Throwable {

		validateAlternateLogOnScreen();
		resetApp();
	}

	////////////////////////////////////////////////////////////////////////////////////
	// Scenario: User taps on Enroll button in the alternate log on screen
	////////////////////////////////////////////////////////////////////////////////////
	@Given("^the user is on the Alternate log on screen$")
	public void the_user_is_on_the_Alternate_log_on_screen() throws Throwable {

		setupAndroidDriver();
		initializeApp();

	}

	@When("^the user taps on Enroll button$")
	public void the_user_taps_on_Enroll_button() throws Throwable {
		driver.findElement(By.xpath("//android.widget.Button[@text='Enroll']")).click();
	}

	@Then("^the Basic Info screen is displayed$")
	public void the_Basic_Info_screen_is_displayed() throws Throwable {
		if (driver.findElement(By.xpath("//android.widget.TextView[@text='BASIC INFO']")).isDisplayed())
			System.out.println("Basic Info Screen is displayed");
		else {
			System.out.println("Basic Info screen is not displayed");

		}
		resetApp();
	}

	////////////////////////////////////////////////////////////////////////////////////
	// Scenario: User taps on Enroll button in the alternate log on screen
	////////////////////////////////////////////////////////////////////////////////////

	@Given("^the user is on Alternate log on screen$")
	public void the_user_is_on_Alternate_log_on_screen() throws Throwable {
		setupAndroidDriver();
		initializeApp();
	}

	@When("^the user taps on Log on$")
	public void the_user_taps_on_Log_on() throws Throwable {
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Log On']")).click();

	}

	@Then("^the BAU log on screen is displayed$")
	public void the_BAU_log_on_screen_is_displayed() throws Throwable {
		if (driver.findElement(By.xpath("//android.widget.EditText[@text='User ID']")).isDisplayed())
			System.out.println("BAU log on screen is displayed");

		resetApp();
	}

}
