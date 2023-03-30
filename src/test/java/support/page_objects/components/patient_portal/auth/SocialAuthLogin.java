package support.page_objects.components.patient_portal.auth;

import com.ui.web.BaseComponent;
import com.ui.web.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.page_objects.webelements.Button;

public class SocialAuthLogin extends BaseComponent {
    public final BaseElement pageTitle = new BaseElement("//div[@class='page-title']", "pageTitle");
    public final BaseElement subTitle = new BaseElement("//div[@class='sub-title']", "subTitle");
    public final Button continueWithGoogleButton = new Button("//*[contains(text(),'google')]", "continueWithGoogle", this);
    public final Button continueWithFacebookButton = new Button("//*[contains(text(),'facebook')]", "continueWithGoogle", this);
    public final Button loginWithPasswordButton = new Button("//*[contains(text(),'password')]", "continueWithGoogle", this);
    public final Button registerButton = new Button("//*[contains(text(),'password')]", "continueWithGoogle", this);

//    private final BaseElement pageTitle = new BaseElement("/div[@class='page-title']", "pageTitle");
    public SocialAuthLogin(String byXpathLocator, String name, BaseElement parent) {
        super(byXpathLocator, name, parent);
    }

    public SocialAuthLogin(String xPathLocator, String name) {
        super(xPathLocator, name);
    }

}
