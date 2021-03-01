package org.carbon;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class AuthTest extends base {

    @Test
    public void Successful_Login() throws MalformedURLException , InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities("carbon_ng.apk");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement el,allowTxt, loginBtn, phoneNo, pin, signIn, maskedText,
        mask;
        Thread thread = null;
        el = driver.findElementByXPath("//android.widget.Button[@text='Skip']");
        TouchAction t = new TouchAction(driver);
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(el))).perform();
        allowTxt = driver.findElementByXPath("//android.widget.Button[@text='Allow']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(allowTxt))).perform();
        loginBtn = driver.findElementByXPath("//android.widget.Button[@text='Sign In']");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(loginBtn))).perform();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        phoneNo = driver.findElementByXPath("//android.widget.EditText[@text='Phone number']");
        phoneNo.sendKeys("089 9000 1100");
        pin = driver.findElementByXPath("//android.widget.EditText[@text='Enter PIN']");
        pin.sendKeys("1234");
        thread.sleep(5000);
        signIn = driver.findElementById("com.lenddo.mobile.paylater.staging:id/sign_in_next");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(signIn))).perform();
        maskedText = driver.findElementById("com.lenddo.mobile.paylater.staging:id/otpMaskedText");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(maskedText))).perform();
        mask = driver.findElementsByClassName()



    }
}
