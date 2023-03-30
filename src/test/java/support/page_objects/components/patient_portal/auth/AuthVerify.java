package support.page_objects.components.patient_portal.auth;

import com.ui.web.BaseElement;
import support.page_objects.webelements.Button;
import support.page_objects.webelements.PlainRadioElement;

public class AuthVerify extends AuthBase{
    public final PlainRadioElement emailCheckRadio = new PlainRadioElement("//div[@id='emailCheck'", "emailCheckRadio", this);

    public final Button sendCodeButton = new Button("//button[@type='btn btn-verify']", "sendCodeButton", this);

    public AuthVerify(String byXpathLocator, String name, BaseElement parent) {
        super(byXpathLocator, name, parent);
    }

    public AuthVerify(String xPathLocator, String name) {
        super(xPathLocator, name);
    }

    public AuthVerify(String xPathLocator) {
        super(xPathLocator);
    }
}
