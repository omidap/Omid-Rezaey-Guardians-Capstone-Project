package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser implements Browser {
    @Override
    public WebDriver openBrowser(String url) {
        WebDriver driver = new EdgeDriver();
        driver.get(url);
        return driver;
    }
}
