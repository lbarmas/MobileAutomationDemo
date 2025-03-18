package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.drivers.DriverSetup;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.junit.Assert;

public class LoginAddProductsToCartSteps extends DriverSetup {

    private LoginPage loginPage;
    private HomePage homePage;
    private ProductsPage productsPage;

    @Given("the user opens the SwagLabs app")
    public void theUserIsOnTheLoginPage() {
        setup();
        loginPage = new LoginPage(driver);
    }

    @When("the user enters a valid username {string} and password {string}")
    public void enterValidUserNameAndPassword(String username, String password) throws Exception {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user clicks the login button")
    public void clickOnTheLoginButton() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @And("the app navigates to the home screen")
    public void appNavigatesToTheHomeScreen() throws Exception {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomeTitleDisplayed());
    }

    @And("the user adds products to the cart")
    public void theUserAddsProductToTheCart() throws Exception {
        productsPage = new ProductsPage(driver);
        productsPage.selectProducts();
    }

    @Then("the products are added to the cart successfully")
    public void theProductIsAddedToTheCartSuccessfully() throws Exception  {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductsAddedToCart());
    }
}
