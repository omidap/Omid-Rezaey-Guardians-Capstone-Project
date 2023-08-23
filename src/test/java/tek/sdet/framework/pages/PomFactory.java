package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;

public class PomFactory extends BaseSetup {
    private HomePage homePage;
    private SignIn signInPage;
    private Account accountPage;
    private Order orderPage;

    public PomFactory() {
        this.homePage = new HomePage();
        this.signInPage = new SignIn();
        this.accountPage = new Account();
        this.orderPage = new Order();
    }

    public HomePage getHomePage() {
        return this.homePage;
    }

    public SignIn signIn() {
        return this.signInPage;
    }

    public Account getAccountPage() {
        return this.accountPage;
    }

    public Order getOrderPage() {
        return this.orderPage;
    }
}