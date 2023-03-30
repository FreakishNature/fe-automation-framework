package support.page_objects.components.patient_portal.footer;

import com.ui.web.BaseComponent;
import com.ui.web.BaseElement;

public class PatientPortalFooter extends BaseComponent {
    public PatientPortalFooter(BaseElement parent) {
        super("//div[@class='footer'", "patientPortalFooter", parent);
    }

    public PatientPortalFooter() {
        super("//div[@class='footer'", "patientPortalFooter");
    }
}
