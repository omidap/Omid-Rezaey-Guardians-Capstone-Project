package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.sdet.framework.base.BaseSetup;

public class SignIn extends BaseSetup {

    public SignIn() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(linkText = "Sign in")
    public WebElement signInLink;

    @FindBy(id = "email")
    public WebElement emailFeild;

    @FindBy(id = "password")
    public WebElement passFeild;

    @FindBy(css = "button")
    public WebElement loginButton;

    // registration
    @FindBy(id = "newAccountBtn")
    public WebElement newAccountBtn;

    @FindBy(id = "signupBtn")
    public WebElement signUpBtn;

    @FindBy(xpath = "//h1[text()='Your Profile']")
    public WebElement yourPorfile;

}
