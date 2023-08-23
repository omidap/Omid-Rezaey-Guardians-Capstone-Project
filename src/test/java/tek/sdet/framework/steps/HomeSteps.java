package tek.sdet.framework.steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.sdet.framework.pages.PomFactory;
import tek.sdet.framework.utilities.CommonUtility;

import java.util.List;
import java.util.Map;

public class HomeSteps extends CommonUtility {
    private final PomFactory factory = new PomFactory();

    //verifySidebar
    @Given("User is on the retail home page")
    public void userIsOnTheRetailHomePage() {
        Assert.assertTrue(factory.getHomePage().tekschoolLogo.isDisplayed());
        logger.info("Tek school logo is displayed");
    }

    @And("User click on All section")
    public void userClickOnAllSection() {
        click(factory.getHomePage().allSectionBtn);
        logger.info("User was successfully clicked on all section");
    }

    @Then("below options are present in shop by Department sidebar")
    public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
        List<Map<String, String>> myList = dataTable.asMaps();
        for (Map<String, String> map : myList) {
            Assert.assertTrue(isElementDisplayed(getDriver().findElement(
                    By.xpath("//div[@class = 'sidebar__content'] //span[text() = '"
                            + map + "']"))));
            logger.info(map + " options are displayed");
        }
    }

    // sidebarOutline
    @When("User on {string}")
    public void userOn(String dep) {
        List<WebElement> department = factory.getHomePage().sidebarOption;
        for (WebElement departments : department) {
            if (departments.getText().equalsIgnoreCase(dep)) {
                departments.click();
                logger.info("User is on " + departments);
                break;
            }
        }
    }

    @Then("below options are present in department")
    public void belowOptionsArePresentInDepartment(DataTable dataTable) {
        List<List<String>> depOptions = dataTable.asLists(String.class);
        List<WebElement> department = factory.getHomePage().sidebarOption;
        for (List<String> s : depOptions) {
            for (WebElement elements : department) {
                if (elements.getText().equalsIgnoreCase(s.get(0))) {
                    Assert.assertTrue(elements.isDisplayed());
                }
                logger.info("The option " + elements.getText() + " is present");
            }
        }
    }
}