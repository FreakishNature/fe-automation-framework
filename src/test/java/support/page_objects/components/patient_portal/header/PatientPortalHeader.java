package support.page_objects.components.patient_portal.header;

import com.ui.web.BaseComponent;
import com.ui.web.BaseElement;
import support.page_objects.webelements.Button;

public class PatientPortalHeader extends BaseComponent {
    private final Button logoButton = new Button("//div[@class='header__logo']/a", "logoButton", this);

    public PatientPortalHeader(BaseElement parent) {
        super("//div['header__top']", "patientPortalHeader", parent);
    }

    public PatientPortalHeader() {
        super("//div['header__top']", "patientPortalHeader");
    }
}
