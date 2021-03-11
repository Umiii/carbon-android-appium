package org.carbon;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class CarbonTest extends Base {

    AndroidDriver<AndroidElement> driver = Capabilities("carbon_ng.apk");
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 60);
    TouchAction t = new TouchAction(driver);

    public CarbonTest() throws MalformedURLException {
    }


    @Test
    public void Successful_Login() throws MalformedURLException , InterruptedException {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(loginPage.skip))).perform();
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(loginPage.allowTxt))).perform();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Wait for Sign In Button to Load
        //wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginBtn));
        loginPage.loginBtn.click();

        // Tap Login
        //t.tap(TapOptions.tapOptions().withElement(ElementOption.element(loginPage.loginBtn))).perform();

        // Enter Phone Number
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        loginPage.phoneNo.sendKeys("089 9000 1100");

        // Enter PIN
        loginPage.pin.sendKeys("1234");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Tap Sign In
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(loginPage.signInBtn))).perform();

        // Check to see if masked Text exists, tap on it if it does
        if(loginPage.maskedTxtPresent.size() !=0) {
            t.tap(TapOptions.tapOptions().withElement(ElementOption.element(loginPage.maskedText))).perform();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }


        // Enter 6 digit verification code
        if (driver.isKeyboardShown())
        {
            System.out.println("keyboard shows");
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));

        }

        //Wait for CloseAd button & Click Close Ad button
        wait.until(ExpectedConditions.visibilityOf(homePage.closeAd));
        homePage.closeAd.click();

        //Check if Sidebar icon is present & tap on it
        Boolean isElementPresent = homePage.sidebarIconPresent.size() != 0;
        Assert.assertTrue(isElementPresent);


//        sidebarIcon = driver.findElementById("com.lenddo.mobile.paylater.staging:id/title_up");
//        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(sidebarIcon))).perform();

        //Scroll to Logout Element
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\" + Log Out + \").instance(0));"));


    }

    @Test
    public void Validate_AirtimeRecharge() throws MalformedURLException{
    // Tap buy airtimeIcon
    homePage.buyAirtimeIcon.click();



    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wait.until(ExpectedConditions.visibilityOf(homePage.airtimePhoneNo));
    homePage.airtimePhoneNo.click();
    homePage.airtimePhoneNo.sendKeys("08093843293");

    wait.until(ExpectedConditions.visibilityOf(homePage.airtimeAmt));

    homePage.airtimeAmt.click();
    homePage.airtimeAmt.sendKeys("500");

    driver.hideKeyboard();

    wait.until(ExpectedConditions.visibilityOf(homePage.network));
    homePage.network.click();


    wait.until(ExpectedConditions.visibilityOf(homePage.nextBtn));
    homePage.nextBtn.click();

    wait.until(ExpectedConditions.visibilityOf(homePage.walletRadioBtn));
    homePage.walletRadioBtn.click();

    wait.until(ExpectedConditions.visibilityOf(homePage.confirmPaymentBtn));
    homePage.confirmPaymentBtn.click();

    wait.until(ExpectedConditions.visibilityOf(homePage.securePayBtn));
    homePage.securePayBtn.click();

    }
}
