package org.carbon;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class CarbonTest extends base {



    @Test
    public void Successful_Login() throws MalformedURLException , InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities("carbon_ng.apk");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement loginBtn = null,el,allowTxt,phoneNo,pin,signIn,maskedText = null,closeAd,sidebarIcon;
        Thread thread = null; TouchAction t = new TouchAction(driver);
        el = driver.findElementByXPath("//android.widget.Button[@text='Skip']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(el))).perform();
        allowTxt = driver.findElementByXPath("//android.widget.Button[@text='Allow']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(allowTxt))).perform();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Wait for Sign In Button to Load, temporary solution till switch to page object
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lenddo.mobile.paylater.staging:id/user_type_existing")));

        // Tap Login
        loginBtn = driver.findElementById("com.lenddo.mobile.paylater.staging:id/user_type_existing");
        //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(loginBtn))).perform();

        // Enter Phone Number
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        phoneNo = driver.findElementByXPath("//android.widget.EditText[@text='Phone number']");
        phoneNo.sendKeys("089 9000 1100");

        // Enter PIN
        pin = driver.findElementByXPath("//android.widget.EditText[@text='Enter PIN']");
        pin.sendKeys("1234");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Tap Sign In
        signIn = driver.findElementById("com.lenddo.mobile.paylater.staging:id/sign_in_next");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(signIn))).perform();

        // Check to see if masked Text exists, tap on it if it does
        if(driver.findElementsById("com.lenddo.mobile.paylater.staging:id/otpMaskedText").size() !=0) {
            maskedText = driver.findElementById("com.lenddo.mobile.paylater.staging:id/otpMaskedText");
            t.tap(TapOptions.tapOptions().withElement(ElementOption.element(maskedText))).perform();
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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lenddo.mobile.paylater.staging.carboncards:id/btnNotRightNow")));
        closeAd = driver.findElementById("com.lenddo.mobile.paylater.staging.carboncards:id/btnNotRightNow");
        closeAd.click();
        //t.tap(TapOptions.tapOptions().withElement(ElementOption.element(closeAd))).perform();
        Boolean isElementPresent = driver.findElementsById("com.lenddo.mobile.paylater.staging:id/title_up").size() != 0;
        Assert.assertTrue(isElementPresent);


    }

    @Test
    public void Validate_AirtimeRecharge() throws MalformedURLException{

    }
}
