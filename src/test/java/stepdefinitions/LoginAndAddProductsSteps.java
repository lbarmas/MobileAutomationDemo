package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAndAddProductsSteps {

    @Given("the user opens the SwagLabs app")
    public void theUserIsOnTheLoginPage() {

    }

    @When("the user enters a valid username {string} and password {string}")
    public void enterValidUserNameAndPassword(String username, String password){

    }

    @And("the user clicks the login button")
    public void clickOnTheLoginButton(){

    }

    @And("the app navigates to the home screen")
    public void appNavigatesToTheHomeScreen(){

    }

    @And("the user adds products to the cart")
    public void theUserAddsProductToTheCart() {

    }

    @Then("the products are added to the cart successfully")
    public void theProductIsAddedToTheCartSuccessfully(){

    }
}
