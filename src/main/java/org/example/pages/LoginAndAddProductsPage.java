package org.example.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAndAddProductsPage {
    private final AndroidDriver driver;
    public static final String USERNAME_XPATH = "//android.widget.EditText[@content-desc=\"test-Username\"]";
    public static final String PASSWORD_XPATH = "//android.widget.EditText[@content-desc=\"test-Password\"]";
    public static final String LOGIN_BUTTON_XPATH = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]";
    private static final String HOME_ICON_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]";
    private static final String PRODUCT_MENU_XPATH = "//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView";
    private static final String CART_BADGE_XPATH = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView";
    private static final String CART_TITLE_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView";
    private static final String CART_BUTTON_XPATH = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView";
    @FindBy(xpath = USERNAME_XPATH)
    private MobileElement usernameField;
    @FindBy(xpath = PASSWORD_XPATH)
    private MobileElement passwordField;
    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private MobileElement loginButton;

    public LoginAndAddProductsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
}
