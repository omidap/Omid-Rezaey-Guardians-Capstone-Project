package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowser implements Browser {
    @Override
    public WebDriver openBrowser(String url) {
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }
}
