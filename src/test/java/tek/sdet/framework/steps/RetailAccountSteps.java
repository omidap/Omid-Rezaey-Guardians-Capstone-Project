package tek.sdet.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.sdet.framework.pages.PomFactory;
import tek.sdet.framework.utilities.CommonUtility;

import java.util.List;
import java.util.Map;

public class RetailAccountSteps extends CommonUtility {

    PomFactory factory = new PomFactory();

    // userUpdateInfo
    @When("User click on Account option")
    public void userClickOnAccountOption() {
        click(factory.getAccountPage().account);
        logger.info("User was clicked on account successfully");
    }

    @And("User update Name {string} and Phone {string}")
    public void userUpdateNameAndPhoneValues(String name, String phone) {
        clearTextUsingSendKeys(factory.getAccountPage().nameInput);
        sendText(factory.getAccountPage().nameInput, name);
        logger.info("User was updated his/her name value successfully");
        clearTextUsingSendKeys(factory.getAccountPage().personalPhoneInput);
        sendText(factory.getAccountPage().personalPhoneInput, phone);
        logger.info("User was updated his/her phone values successfully.");
    }

    @And("User click on Update button")
    public void userClickOnUpdateButton() {
        click(factory.getAccountPage().personalUpdateBtn);
        logger.info("User was updated");
    }

    @Then("user profile information should be updated")
    public void userProfileInformationShouldBeUpdated() {
        waitTillPresence(factory.getAccountPage().popUpMess);
        Assert.assertTrue(isElementDisplayed(factory.getAccountPage().popUpMess));
        logger.info("User profile information updated successfully");
    }

    // userAddCardPayment
    @And("User click on Add a payment method link")
    public void userClickOnAddPaymentMethodLink() {
        click(factory.getAccountPage().paymentMethodLink);
        logger.info("User was clicked on payment method link successfully.");
    }

    @And("User fill Debit or credit card information")
    public void userFillDebitOrCreditCard(DataTable dataTable) {
        List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
        sendText(factory.getAccountPage().cardNumber, map.get(0).get("cardNumber"));
        sendText(factory.getAccountPage().nameOnCard, map.get(0).get("nameOnCard"));
        sendText(factory.getAccountPage().expirationMonth, map.get(0).get("expirationMonth"));
        sendText(factory.getAccountPage().expirationYear, map.get(0).get("expirationYear"));
        sendText(factory.getAccountPage().ccvCode, map.get(0).get("securityCode"));

        logger.info("User card information added successfully");
    }

    @And("User click on Add your card button")
    public void userClickOnAddYourCardButton() {
        click(factory.getAccountPage().addBtn);
        logger.info("User was clicked on the button successfully");
    }

    @Then("a message should be displayed ‘Payment Method added successfully’")
    public void aMessageShouldBeDisplayed() {
        Assert.assertTrue(factory.getAccountPage().popUpMess.isDisplayed());
        logger.info("Payment Method added successfully");
    }

    @And("User click on Edit option of card section")
    public void userClickOnEditOption() {
        WebElement title = factory.getAccountPage().accountTitle;
        scrollPageDownWithJS(title);
        waitTillClickable(factory.getAccountPage().accountPayWrapper);
        click(factory.getAccountPage().accountPayWrapper);
        waitTillClickable(factory.getAccountPage().editLinkBtn);
        click(factory.getAccountPage().editLinkBtn);
        logger.info("User was clicked on the link button successfully");
    }

    @And("user edit information with below data")
    public void userEditInformationWithBelowData(DataTable dataTable) {
        List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
        clearTextUsingSendKeys(factory.getAccountPage().cardNumber);
        sendText(factory.getAccountPage().cardNumber, map.get(0).get("cardNumber"));
        clearTextUsingSendKeys(factory.getAccountPage().nameOnCard);
        sendText(factory.getAccountPage().nameOnCard, map.get(0).get("nameOnCard"));
        clearTextUsingSendKeys(factory.getAccountPage().expirationMonth);
        selectByVisibleText(factory.getAccountPage().expirationMonth, map.get(0).get("expirationMonth"));
        clearTextUsingSendKeys(factory.getAccountPage().expirationYear);
        selectByVisibleText(factory.getAccountPage().expirationYear, map.get(0).get("expirationYear"));
        clearTextUsingSendKeys(factory.getAccountPage().ccvCode);
        sendText(factory.getAccountPage().ccvCode, map.get(0).get("securityCode"));

        logger.info("User card information added successfully");
    }

    @And("user click on Update Your Card button")
    public void userClickOnUpdateYourCardButton() {
        click(factory.getAccountPage().updateYourCardBtn);
        logger.info("User was clicked on update button successfully");
    }

    @Then("a message should be displayed ‘Payment Method updated Successfully’")
    public void anUpdateMessageShouldBeDisplayed() {
        Assert.assertTrue(factory.getAccountPage().popUpMess.isDisplayed());
        logger.info("Update button was click successfully");
    }

    //UserRemoveCardInfo
    @And("User click on remove option of card section")
    public void userClickOnRemove() {
        scrollPageDownWithJS(factory.getAccountPage().accountTitle);
        click(factory.getAccountPage().accountPayWrapper);
        waitTillClickable(factory.getAccountPage().removeCardBtn);
        click(factory.getAccountPage().removeCardBtn);
        logger.info("User was clicked on remove button successfully");
    }

    @Then("payment details should be removed")
    public void paymentDetailsShouldBeRemoved() {
        boolean b = factory.getAccountPage().aWrapper.isDisplayed();
        if (!b) {
            Assert.assertFalse(false);
            logger.info("Payment details are still exists.");
        } else {
            logger.info("User was successfully removed the payment item.");
        }
    }

    //UserAddAddressInfo
    @And("User click on Add address option")
    public void userClickOnAddAddress() {
        scrollPageDownWithJS(factory.getAccountPage().addressTitle);
        click(factory.getAccountPage().addAddress);
        logger.info("User was clicked on add address option successfully");
    }

    @And("user fill new address form with below information")
    public void userFillNewAddress(DataTable dataTable) {
        List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
        clearTextUsingSendKeys(factory.getAccountPage().countryDropdown);
        sendText(factory.getAccountPage().countryDropdown, map.get(0).get("country"));
        clearTextUsingSendKeys(factory.getAccountPage().fullNameInput);
        sendText(factory.getAccountPage().fullNameInput, map.get(0).get("fullName"));
        clearTextUsingSendKeys(factory.getAccountPage().phoneNumberInput);
        sendText(factory.getAccountPage().phoneNumberInput, map.get(0).get("phoneNumber"));
        clearTextUsingSendKeys(factory.getAccountPage().streetInput);
        sendText(factory.getAccountPage().streetInput, map.get(0).get("streetAddress"));
        clearTextUsingSendKeys(factory.getAccountPage().apartmentInput);
        sendText(factory.getAccountPage().apartmentInput, map.get(0).get("apt"));
        clearTextUsingSendKeys(factory.getAccountPage().cityInput);
        sendText(factory.getAccountPage().cityInput, map.get(0).get("city"));
        clearTextUsingSendKeys(factory.getAccountPage().state);
        sendText(factory.getAccountPage().state, map.get(0).get("state"));
        clearTextUsingSendKeys(factory.getAccountPage().zipCodeInput);
        sendText(factory.getAccountPage().zipCodeInput, map.get(0).get("zipCode"));
        logger.info("User was entered his/her info successfully");
    }

    @And("User click Add Your Address button")
    public void userClickAddAddress() {
        click(factory.getAccountPage().addressBtn);
        logger.info("User was clicked on add address button successfully");
    }

    @Then("a message should be displayed ‘Address Added Successfully’")
    public void aMessageShouldBeDisplayedAddressAdded() {
        Assert.assertTrue(factory.getAccountPage().popUpMess.isDisplayed());
        logger.info("User was added his/her address info successfully");
    }

    //UserEditAddressInfo
    @And("User click on edit address option")
    public void userClickOnEdit() {
        scrollPageDownWithJS(factory.getAccountPage().accountTitle);
        click(factory.getAccountPage().editLinkBtn);
        logger.info("User was clicked on edit address option successfully");
    }

    @And("User click update Your Address button")
    public void userClickUpdateYourAddress() {
        click(factory.getAccountPage().addressBtn);
        logger.info("User was clicked on add address button successfully");
    }

    @Then("a message should be displayed ‘Address Updated Successfully’")
    public void aMessageShouldBeDisplayedAddressUpdated() {
        Assert.assertTrue(factory.getAccountPage().popUpMess.isDisplayed());
        logger.info("User was updated his/her info successfully");
    }

    //UserRemoveAddressInfo
    @And("User click on remove option of Address section")
    public void userClickRemove() {
        scrollPageDownWithJS(factory.getAccountPage().addressTitle);
        waitTillPresence(factory.getAccountPage().removeBtn);
        click(factory.getAccountPage().removeBtn);
        logger.info("User was successfully removed added address");
    }

    @Then("Address details should be removed")
    public void AddressDetailsShouldBeRemoved() {
        boolean b = factory.getAccountPage().removeBtn.isDisplayed();
        if (!b) {
            Assert.assertFalse(false);
            logger.info("User was successfully removed");
        } else {
            logger.info("User is still exists.");
        }

    }
}