package pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage {
        @AndroidFindBy(xpath = "//android.widget.Button[@text='Skip']")
        public WebElement skip;

        @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
        public WebElement allowTxt;
}
