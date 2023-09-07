package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.stylesheets.LinkStyle;
import tek.sdet.framework.base.BaseSetup;

import java.util.List;

public class Order extends BaseSetup {

    public Order() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "select#search")
    public WebElement allDepartment;
    @FindBy(css = "div.products__layout > img")
    public WebElement plugsAndOutlets;

    @FindBy(css = "button#searchBtn")
    public WebElement searchBtn;

    @FindBy(css = "input#searchInput")
    public WebElement searchInput;

    @FindBy(css = "select.product__select")
    public WebElement itemQt;

    @FindBy(css = "button#addToCartBtn span")
    public WebElement addToCartBtn;

    @FindBy(css = "span#cartQuantity")
    public WebElement cartQuantity;

    @FindBy(xpath = "//p[text()='Cart ']")
    public WebElement selectCart;

    @FindBy(css = "button#proceedBtn")
    public WebElement proceedBtn;

    @FindBy(css = "button#placeOrderBtn")
    public WebElement placeOrderBtn;

    @FindBy(css = "a#orderLink")
    public WebElement orderLink;

    @FindBy(xpath = "//div[@class='order'] //descendant::p[7]")
    public List<WebElement> N0listOfItems;

    @FindBy(xpath = "//p[text()='Cancelled']")
    public WebElement cancelledLbl;

    @FindBy(css = "button#cancelBtn")
    public WebElement cancelBtn;

    @FindBy(css = "select#reasonInput")
    public WebElement reason;
    @FindBy(css = "button#orderSubmitBtn")
    public WebElement orderSubmitBtn;
    @FindBy(css = "div.bg-gray-100")
    public WebElement message;

    //UserReturnOrder
    @FindBy(css = "button#returnBtn")
    public WebElement returnOrder;
    @FindBy(css = "select#reasonInput")
    public WebElement reasonInput;
    @FindBy(css = "select#dropOffInput")
    public WebElement dropOffInput;
    @FindBy(css = "button#orderSubmitBtn")
    public WebElement submitOrderReturn;
    @FindBy(css = "button#reviewBtn")
    public WebElement reviewBtn;
    @FindBy(css = "input#headlineInput")
    public WebElement value;
    @FindBy(css = "#descriptionInput")
    public WebElement text;
    @FindBy(css = "button#reviewSubmitBtn")
    public WebElement reviewSubmitBtn;

}
