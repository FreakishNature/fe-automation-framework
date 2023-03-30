package support.page_objects.components.patient_portal.auth;

import com.ui.web.BaseComponent;
import com.ui.web.BaseElement;
import support.page_objects.webelements.TextInput;

public class EmailFormPart extends BaseComponent {
    public final BaseElement emailLabel = new BaseElement("//label", "emailLabel", this);
    public final TextInput emailInput = new TextInput("//input", "emailInput", this);


    public EmailFormPart(String byXpathLocator, String name, BaseElement parent) {
        super(byXpathLocator, name, parent);
    }

    public EmailFormPart(String xPathLocator, String name) {
        super(xPathLocator, name);
    }
}
