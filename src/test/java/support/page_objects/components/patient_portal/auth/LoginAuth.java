package support.page_objects.components.patient_portal.auth;

import com.ui.managers.Page;
import com.ui.web.BaseComponent;
import com.ui.web.BaseElement;
import support.page_objects.webelements.Button;
import support.page_objects.webelements.TextInput;

@Page
public class LoginAuth extends AuthBase {

    public final EmailFormPart emailFormPart = new EmailFormPart("//input[contains(@id,'email')]/parent::div", "emailFormPart");
    public final PasswordFormPart passwordFormPart = new PasswordFormPart("//input[contains(@id,'password')]/parent::div", "passwordFormPart");

    public final Button loginButton = new Button("//*[@type='submit']", "loginButton", this);
    public final Button forgotButton = new Button("//div[@class='forgot_link']//a", "forgotButton", this);
    public final Button backButton = new Button("//*[text()[contains(.,'Back')]]", "backButton", this);

    public LoginAuth(String xPathLocator) {
        super(xPathLocator);
    }

    public LoginAuth(String xPathLocator, String name) {
        super(xPathLocator, name);
    }
}
