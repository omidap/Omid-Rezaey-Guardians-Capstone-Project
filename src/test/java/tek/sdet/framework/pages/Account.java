package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.sdet.framework.base.BaseSetup;

public class Account extends BaseSetup {

    public Account() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "a#accountLink")
    public WebElement account;
    @FindBy(css = "input#nameInput")
    public WebElement nameInput;
    @FindBy(css = "input#personalPhoneInput")
    public WebElement personalPhoneInput;
    @FindBy(css = "button#personalUpdateBtn")
    public WebElement personalUpdateBtn;

    @FindBy(xpath = "//p[contains(text(), 'Add a')]")
    public WebElement paymentMethodLink;

    @FindBy(css = "input#cardNumberInput")
    public WebElement cardNumber;

    @FindBy(css = "input#nameOnCardInput")
    public WebElement nameOnCard;

    @FindBy(css = "select#expirationMonthInput")
    public WebElement expirationMonth;

    @FindBy(css = "select#expirationYearInput")
    public WebElement expirationYear;

    @FindBy(css = "input#securityCodeInput")
    public WebElement ccvCode;

    @FindBy(css = "button#paymentSubmitBtn")
    public WebElement addBtn;

    @FindBy(css = "div.Toastify > div")
    public WebElement popUpMess;

    @FindBy(xpath = "//h1[text()='Wallet']")
    public WebElement accountTitle;

    @FindBy(xpath = "//button[text()='Edit']")
    public WebElement editLinkBtn;

    @FindBy(css = "button#paymentSubmitBtn")
    public WebElement updateYourCardBtn;


    //userRemoveInfo
    @FindBy(css = "div.account__payments-wrapper > div")
    public WebElement accountPayWrapper;
    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeBtn;
    @FindBy(xpath = "//div[@class='flex gap-2 py-2']//descendant::button[2]")
    public WebElement removeCardBtn;
    @FindBy(xpath = "//div[@class='account__payments-wrapper']//descendant::div[1]")
    public WebElement aWrapper;

    //UserAddressInfo

    @FindBy(xpath = "//h1[text()='Your Addresses']")
    public WebElement addressTitle;
    @FindBy(css = "div.account__address-new")
    public WebElement addAddress;

    @FindBy(css = "select#countryDropdown")
    public WebElement countryDropdown;

    @FindBy(css = "input#fullNameInput")
    public WebElement fullNameInput;

    @FindBy(css = "input#phoneNumberInput")
    public WebElement phoneNumberInput;

    @FindBy(css = "input#streetInput")
    public WebElement streetInput;

    @FindBy(css = "input#apartmentInput")
    public WebElement apartmentInput;
    @FindBy(css = "input#cityInput")
    public WebElement cityInput;

    @FindBy(xpath = "//select[@name='state']")
    public WebElement state;
    @FindBy(css = "input#zipCodeInput")
    public WebElement zipCodeInput;

    @FindBy(css = "button#addressBtn")
    public WebElement addressBtn;


}
