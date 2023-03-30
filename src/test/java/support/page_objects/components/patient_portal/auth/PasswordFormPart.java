package support.page_objects.components.patient_portal.auth;

import com.ui.web.BaseComponent;
import com.ui.web.BaseElement;
import support.page_objects.webelements.TextInput;

public class PasswordFormPart extends BaseComponent {
    public final BaseElement passwordLabel = new BaseElement("//label", "passwordLabel", this);
    public final TextInput passwordInput = new TextInput("//input", "passwordInput", this);
    public final BaseElement passwordRequirementsText = new BaseElement("//span", "passwordRequirementsText", this);

    public PasswordFormPart(String byXpathLocator, String name, BaseElement parent) {
        super(byXpathLocator, name, parent);
    }

    public PasswordFormPart(String xPathLocator, String name) {
        super(xPathLocator, name);
    }
}
