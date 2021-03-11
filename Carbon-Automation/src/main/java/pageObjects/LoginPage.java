package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

        public LoginPage(AppiumDriver driver)
        {

                PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

        @AndroidFindBy(xpath = "//android.widget.Button[@text='Skip']")
        public WebElement skip;

        @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
        public WebElement allowTxt;

        @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/user_type_existing")
        public WebElement loginBtn;

        @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone number']")
        public WebElement phoneNo;

        @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter PIN']")
        public WebElement pin;

        @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/sign_in_next")
        public WebElement signInBtn;

        @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/otpMaskedText")
        public List<WebElement> maskedTxtPresent;

        @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/otpMaskedText")
        public WebElement maskedText;

        @AndroidFindBy(id = "com.lenddo.mobile.paylater.staging:id/edit_text_phone_number")
        public WebElement airtimePhoneNo;



}
