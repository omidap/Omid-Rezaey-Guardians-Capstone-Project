package tek.sdet.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.sdet.framework.pages.PomFactory;
import tek.sdet.framework.utilities.CommonUtility;

import java.util.List;

public class SignInSteps extends CommonUtility {

    PomFactory factory = new PomFactory();

    @Given("User is on retail website")
    public void userIsOnRetailWebsites() {
        Assert.assertTrue(factory.getHomePage().tekschoolLogo.isDisplayed());
        logger.info("TekSchool logo is displayed");
    }

    @When("User click on sign in option")
    public void userClickOnSignInOption() {
        click(factory.signIn().signInLink);
        logger.info("User was Successfully signed in");
    }

    @And("User enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String email, String password) {
        sendText(factory.signIn().emailFeild, email);
        sendText(factory.signIn().passFeild, password);
        logger.info("Email and password were entered successfully");
    }

    @And("User click on login button")
    public void userClickOnLoginButton() {
        click(factory.signIn().loginButton);
        logger.info("User was successfully logged in");
    }

    @Then("User should be logged in into account")
    public void userShouldBeLoggedInIntoAccount() {
        Assert.assertTrue(factory.signIn().loginButton.isDisplayed());
        logger.info("Login button is displayed");
    }

    // registration

    @And("User click on Create New Account button")
    public void userClickOnCreateNewAccountButton() {
        click(factory.signIn().newAccountBtn);
        logger.info("User was successfully clicked on create new account");
    }

    @When("User fill the signUp information with below date")
    public void userFillTheSignUpInformationWithBelowDate(DataTable dataTable) {
        // the cells() method is iterated through the data table.
        List<List<String>> users = dataTable.asLists(String.class);
        for (List<String> user : users) {
            factory.getDriver().findElement(By.cssSelector("input#nameInput")).sendKeys(user.get(0));
            factory.getDriver().findElement(By.cssSelector("input#emailInput")).sendKeys(user.get(1));
            factory.getDriver().findElement(By.cssSelector("input#passwordInput")).sendKeys(user.get(2));
            factory.getDriver().findElement(By.cssSelector("input#confirmPasswordInput")).sendKeys(user.get(3));
            logger.info("User was successfully send keys to the fields.");
        }
    }


    @And("User click on SignUp button")
    public void userClickOnSignUpButton() {
        click(factory.signIn().signUpBtn);
        logger.info("User was successfully signed up");
    }

    @Then("User should be logged into account page")
    public void userShouldBeLoggedIntoAccountPage() {
        Assert.assertTrue(factory.signIn().yourPorfile.isDisplayed());
        logger.info("User was successfully on his/her profile");
    }
}
