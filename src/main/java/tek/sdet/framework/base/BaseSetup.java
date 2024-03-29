package tek.sdet.framework.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import tek.sdet.framework.config.*;
import tek.sdet.framework.utilities.ReadYamlFiles;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class BaseSetup {
    private static WebDriver webDriver;
    private final ReadYamlFiles environmentVariables;
    public static Logger logger;

    public BaseSetup() {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
        String log4JPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
        try {
            environmentVariables = ReadYamlFiles.getInstance(filePath);
        } catch (FileNotFoundException e) {
            logger.info("Failed for Load environment context. check possible file path errors");
            throw new RuntimeException("Failed for Load environment context with message " + e.getMessage());
        }

        logger = logger.getLogger("logger_File");
        PropertyConfigurator.configure(log4JPath);

    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public void setupBrowser() {
        HashMap uiProperties = environmentVariables.getYamlProperty("ui");
        System.out.println(uiProperties);
        String url = uiProperties.get("url").toString();
        Browser browser;
        switch (uiProperties.get("browser").toString().toLowerCase()) {
            case "chrome":
                if ((boolean) uiProperties.get("headless")) {
                    browser = new ChromeHeadless();
                } else {
                    browser = new ChromeBrowser();
                }
                webDriver = browser.openBrowser(url);
                break;
            case "firefox":
                if ((boolean) uiProperties.get("headless")) {
                    browser = new FirefoxHeadless();
                } else {
                    browser = new FireFoxBrowser();
                }
                webDriver = browser.openBrowser(url);
                break;
            case "edge":
                browser = new EdgeBrowser();
                webDriver = browser.openBrowser(url);
                break;
            default:
                throw new RuntimeException("Unknown Browser check environment properties");
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        webDriver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));


    }

    public void quitBrowser() {
        if (webDriver != null)
            webDriver.quit();
    }
}
