package support.page_objects.components.patient_portal.auth;

import com.ui.managers.Page;
import com.ui.web.BaseComponent;
import com.ui.web.BaseElement;
import support.page_objects.pages.BasePage;

public class AuthBase extends BaseComponent {
    public final BaseElement pageTitle = new BaseElement("//div[@class='page-title']", "pageTitle");
    public final BaseElement subTitle = new BaseElement("//div[@class='sub-title']", "subTitle");

    public AuthBase(String byXpathLocator, String name, BaseElement parent) {
        super(byXpathLocator, name, parent);
    }

    public AuthBase(String xPathLocator, String name) {
        super(xPathLocator, name);
    }

    public AuthBase(String xPathLocator) {
        super(xPathLocator);
    }
}
