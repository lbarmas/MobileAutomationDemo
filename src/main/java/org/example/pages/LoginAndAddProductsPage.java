package org.example.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class LoginAndAddProductsPage {
    private final AndroidDriver<MobileElement> driver;
    public static final String USERNAME_XPATH = "//android.widget.EditText[@content-desc=\"test-Username\"]";
    public static final String PASSWORD_XPATH = "//android.widget.EditText[@content-desc=\"test-Password\"]";
    public static final String LOGIN_BUTTON_XPATH = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]";
    private static final String HOME_ICON_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]";
    private static final String PRODUCT_MENU_XPATH = "//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView";
    private static final String CART_BADGE_XPATH = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView";
    private static final String CART_BUTTON_XPATH = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView";
    private static final String PRODUCT_1 = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView";
    private static final String PRODUCT_3 = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[3]/android.widget.TextView";
    private static final String PRODUCT_4 = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]/android.widget.TextView";
    @FindBy(xpath = USERNAME_XPATH)
    private MobileElement usernameField;
    @FindBy(xpath = PASSWORD_XPATH)
    private MobileElement passwordField;
    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private MobileElement loginButton;
    @FindBy(xpath = HOME_ICON_XPATH)
    private MobileElement homeTitle;


    public LoginAndAddProductsPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() throws Exception {
        ConfigLoader configLoader = new ConfigLoader();
        usernameField.sendKeys(configLoader.get("username"));
        passwordField.sendKeys(configLoader.get("password"));
        loginButton.click();
    }

    public boolean isHomeTitleDisplayed() {
        return homeTitle.isDisplayed();
    }

    public void selectProducts() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        List<String> productXpaths = Arrays.asList(PRODUCT_1, PRODUCT_3, PRODUCT_4);

        clickElement(wait, PRODUCT_MENU_XPATH);

        for (String productXpath : productXpaths) {
            clickElement(wait, productXpath);
        }
    }

    public boolean isProductsAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CART_BADGE_XPATH)));

        MobileElement cartBadge = driver.findElement(By.xpath(CART_BADGE_XPATH));

        if (!cartBadge.getText().isEmpty()) {
            MobileElement cartButton = driver.findElement(By.xpath(CART_BUTTON_XPATH));
            cartButton.click();

            return true;
        }
        return false;
    }

    private void clickElement(WebDriverWait wait, String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        MobileElement product = driver.findElement(By.xpath(xpath));
        product.click();
    }
}
