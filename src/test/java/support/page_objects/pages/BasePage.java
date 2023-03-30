package support.page_objects.pages;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import com.ui.config.ConfigReader;
import com.ui.managers.WebDriverFactory;

@Log4j
@Data
public abstract class BasePage {
    private ConfigReader configs = ConfigReader.getInstance();
    private WebDriver driver = WebDriverFactory.getWebDriver();
    public final long IMPLICIT_NO_TIMEOUT = 500;
    public final long DEFAULT_TIMEOUT = configs.getImplicitWait();
    public final long MAX_WAIT_TIME = configs.getMaxWaitTime();

    private String baseUrl = "";
    private String name;

    public BasePage(String name) {
        this.name = name;
        log.info("Constructing Page:: " + this.name);
    }

    public String buildUrl(String... urlPart) {

        return this.baseUrl + String.join("", urlPart);
    }


    public abstract void navigate();

    public abstract boolean isDisplayed();

    public abstract void waitPageReady(long timeoutInSeconds);

    public abstract void waitPageReady();

    public void open(String url) {
        log.info("Navigate to:: " + url);
        this.driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
