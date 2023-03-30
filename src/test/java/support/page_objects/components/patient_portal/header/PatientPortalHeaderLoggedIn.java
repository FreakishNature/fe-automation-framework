package support.page_objects.components.patient_portal.header;

import com.ui.web.BaseElement;

public class PatientPortalHeaderLoggedIn extends PatientPortalHeader {
    private final NotificationsArea notificationsAreaComponent = new NotificationsArea("//div", "notificationsArea", this);

}
