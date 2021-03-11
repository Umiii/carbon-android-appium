package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(AppiumDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging.carboncards:id/btnNotRightNow")
    public WebElement closeAd;

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/title_up")
    public List<WebElement> sidebarIconPresent;

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/title_up")
    public WebElement sidebarIcon;

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/biller_logo")
    public WebElement buyAirtimeIcon;

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/edit_text_phone_number")
    public WebElement airtimePhoneNo;

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/edit_text_airtime_price")
    public WebElement airtimeAmt;

    @AndroidFindBy(xpath = "(//android.widget.ImageView)[5]")
    public WebElement network;

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/button_next")
    public WebElement nextBtn;

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/walletRadioButton")
    public WebElement walletRadioBtn;

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/confirm_payment_button")
    public WebElement confirmPaymentBtn;

    @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/button_text_secure_pay")
    public WebElement securePayBtn;
}
