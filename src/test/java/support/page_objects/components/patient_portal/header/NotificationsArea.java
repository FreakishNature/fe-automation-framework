package support.page_objects.components.patient_portal.header;

import com.ui.web.BaseComponent;
import com.ui.web.BaseElement;
import support.page_objects.webelements.Button;

public class NotificationsArea extends BaseComponent {
    private final BaseElement welcomeText = new BaseElement("/div", "welcomeText");
    private final BaseElement openMessagingButton = new Button("/a[contains(@title,'Messaging')", "openMessagingButton", this);
    private final BaseElement logoutButton = new Button("/a[contains(@id,'logout')", "logoutButton", this);

    public NotificationsArea(String byXpathLocator, String name, BaseElement parent) {
        super(byXpathLocator, name, parent);
    }

    public NotificationsArea(String byXpathLocator, String name) {
        super(byXpathLocator, name);
    }
}
