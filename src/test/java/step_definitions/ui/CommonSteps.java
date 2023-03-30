package step_definitions.ui;

import actions.PatientPortalActions;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import com.ui.config.ConfigReader;
import support.context.TestContext;
import com.ui.managers.WebDriverFactory;
import support.page_objects.pages.BasePage;
import support.page_objects.examples.pages.GooglePage;
import support.page_objects.examples.pages.WebStorePage;
import com.ui.web.BaseElement;
import utils.ElementResolver;

public class CommonSteps implements En {

    public CommonSteps(TestContext context) {
        PatientPortalActions patientPortalActions = new PatientPortalActions(context);

        ConfigReader configs = ConfigReader.getInstance();

        GooglePage googlePage = context.getPageObjectManager().get(GooglePage.class);
        WebStorePage webStorePage = context.getPageObjectManager().get(WebStorePage.class);
        WebDriver driverRef = WebDriverFactory.getWebDriver();

        When("User logs in google with credentials {string}", (String credentials) -> {
           patientPortalActions.googleAuth(context.getCredentialManager().getCredentials(credentials));
        });

        Then("^I see \"([^\"]*)\" (component|element) (is|are) displayed correctly$", (String elem, String par1, String par2) -> {
            BaseElement el = ElementResolver.resolve(elem, context);
            assert el != null;
            el.waitTillIsVisible(configs.getMaxWaitTime());
            el.expectToBeDisplayed();
        });

        When("Sleep for {int}", (Integer seconds)->{
            Thread.sleep(seconds * 1000);
        });
    }
}