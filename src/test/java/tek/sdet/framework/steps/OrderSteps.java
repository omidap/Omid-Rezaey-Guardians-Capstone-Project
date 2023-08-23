package tek.sdet.framework.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.sdet.framework.pages.PomFactory;
import tek.sdet.framework.utilities.CommonUtility;

import java.util.List;

public class OrderSteps extends CommonUtility {

    PomFactory factory = new PomFactory();


    @When("User change the category to {string}")
    public void userChangeTheCategoryTo(String category) {
        selectByVisibleText(factory.getOrderPage().allDepartment, category);
        logger.info("Category was changed successfully");
    }

    @When("User search for an item {string}")
    public void userSearchForAnItem(String string) {
        sendText(factory.getOrderPage().searchInput, string);
        logger.info("User was selected successfully");
    }

    @When("User click on Search icon")
    public void userClickOnSearchIcon() {
        click(factory.getOrderPage().searchBtn);
        logger.info("User was clicked on search icon successfully");
    }

    @When("User click on item")
    public void userClickOnItem() {
        click(factory.getOrderPage().plugsAndOutlets);
        logger.info("User was clicked on item successfully");
    }

    @And("User select quantity {string}")
    public void userSelectQuantity(String str) {
        selectByVisibleText(factory.getOrderPage().itemQt, str);
        logger.info("User was selected quantity successfully");
    }

    @When("User click add to Cart button")
    public void userClickAddToCartButton() {
        click(factory.getOrderPage().addToCartBtn);
        logger.info("user was clicked on add to cart successfully");
    }

    @Then("the cart icon quantity should change to {string}")
    public void theCartIconQuantityShouldChangeTo(String str) {
        Assert.assertEquals(str, factory.getOrderPage().cartQuantity.getText());
        logger.info("Item qty in the cart was validated successfully.");
    }

    //UserPlaceOrder
    @And("User click on Cart option")
    public void userClickOnCartOption() {
        click(factory.getOrderPage().selectCart);
        logger.info("user was clicked on cart option successfully.");
    }

    @And("User click on Proceed to Checkout button")
    public void userClickOnProceedToCheckoutBtn() {
        click(factory.getOrderPage().proceedBtn);
        logger.info("User was clicked on Proceed button successfully.");
    }

    @And("User click on Place Your Order")
    public void userClickOnPlaceOrder() {
        click(factory.getOrderPage().placeOrderBtn);
        logger.info("User was clicked on Place Order button successfully.");
    }

    @Then("a message should be displayed ‘Order Placed, Thanks’")
    public void showMessage() {
        Assert.assertTrue(factory.getAccountPage().popUpMess.isDisplayed());
        logger.info("User was successfully placed order.");
    }

    @And("User click on Orders section")
    public void clickOnOrder() {
        click(factory.getOrderPage().orderLink);
        logger.info("User was successfully clicked on Order option");
    }

    @And("User click on first order in list")
    public void clickOnFirstOrder() {
        List<WebElement> elements = factory.getOrderPage().N0listOfItems;
        for (WebElement element : elements) {
            if (!element.getText().equalsIgnoreCase("Hide Details")) {
                click(element);
            }
        }
    }

    //UserCancelOrder
    @And("User click on Cancel The Order button")
    public void cancelOrder() {
        List<WebElement> elements = factory.getOrderPage().cancelBtn;
        click(elements.get(0));
        //cancel all orders
//		for(int i = 0; i < cancelBtns.size(); i++) {
//			click(cancelBtns.get(i));
//		}
        logger.info("User clicked on cancel order button");
    }

    @And("User select the cancellation Reason {string}")
    public void cancellationReason(String reason) {
        selectByVisibleText(factory.getOrderPage().reason, reason);
        logger.info("Cancellation reason was selected");
    }

    @And("User click on Cancel Order button")
    public void cancelOrderBtn() {
        click(factory.getOrderPage().orderSubmitBtn);
        logger.info("User clicked on cancel order button");
    }

    @Then("a cancellation message should be displayed {string}")
    public void cancellationMessage(String message) {
        if (message.equalsIgnoreCase(factory.getOrderPage().message.getText())) {
            logger.info("Your Order has been cancelled");
        } else {
            logger.info("Your Order has been not cancelled");
        }
    }

    //UserReturnOrder
    @And("User click on Return Items button")
    public void returnItems() {
        List<WebElement> returnItems = factory.getOrderPage().returnOrder;
        click(returnItems.get(0));
        logger.info("User clicked on return order button");
    }

    @And("User select the Return Reason {string}")
    public void returnReason(String reason) {
        selectByVisibleText(factory.getOrderPage().reasonInput, reason);
        logger.info("Return Reason: " + reason);
    }

    @And("User select the drop off service {string}")
    public void dropOffService(String service) {
        selectByVisibleText(factory.getOrderPage().dropOffInput, service);
        logger.info("Your drop off service: " + service);
    }

    @And("User click on Return Order button")
    public void clickOnReturnOrder() {
        click(factory.getOrderPage().submitOrderReturn);
        logger.info("User was submitted return order successfully");
    }

    //UserUpdateOrder
    @And("User click on Review button")
    public void clickOnReview() {
        click(factory.getOrderPage().reviewBtn);
        logger.info("User was clicked on review button.");
    }

    @And("User write Review headline {string} and {string}")
    public void writeReview(String headline, String text) {
        sendText(factory.getOrderPage().value, headline);
        sendText(factory.getOrderPage().text, text);
        logger.info("User was written review information");

    }

    @And("User click Add your Review button")
    public void clickAddReview() {
        click(factory.getOrderPage().reviewSubmitBtn);
        logger.info("User was clicked add your review button");
    }

    @Then("a review message should be displayed ‘Your review was added successfully’")
    public void reviewMessage() {
        Assert.assertTrue(factory.getAccountPage().popUpMess.isDisplayed());
        logger.info("Your review was added successfully.");
    }
}
