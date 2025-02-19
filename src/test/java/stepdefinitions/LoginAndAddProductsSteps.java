package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginAndAddProductsPage;
import org.example.utils.DriverSetup;
import org.junit.Assert;

public class LoginAndAddProductsSteps extends DriverSetup {

    private LoginAndAddProductsPage loginAndAddProductsPage;

    @Given("the user opens the SwagLabs app")
    public void theUserIsOnTheLoginPage() {
        setup();
        loginAndAddProductsPage = new LoginAndAddProductsPage(driver);
    }

    @When("the user enters a valid username {string} and password {string}")
    public void enterValidUserNameAndPassword(String username, String password){
        loginAndAddProductsPage.enterUsername(username);
        loginAndAddProductsPage.enterPassword(password);
    }

    @And("the user clicks the login button")
    public void clickOnTheLoginButton(){
        loginAndAddProductsPage.clickLoginButton();
        loginAndAddProductsPage = new LoginAndAddProductsPage(driver);
    }

    @And("the app navigates to the home screen")
    public void appNavigatesToTheHomeScreen(){
        Assert.assertTrue(loginAndAddProductsPage.isHomeTitleDisplayed());
    }

    @And("the user adds products to the cart")
    public void theUserAddsProductToTheCart() {
        loginAndAddProductsPage.selectProduct();
    }

    @Then("the products are added to the cart successfully")
    public void theProductIsAddedToTheCartSuccessfully(){
       Assert.assertTrue(loginAndAddProductsPage.isProductsAddedToCart());
    }
}
