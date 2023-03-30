package support.page_objects.pages;

import com.ui.managers.Page;
import support.page_objects.components.patient_portal.header.PatientPortalHeaderLoggedIn;

@Page
public class PatientPortalPage extends BasePage {
    private final PatientPortalHeaderLoggedIn patientPortalHeader = new PatientPortalHeaderLoggedIn();

    public PatientPortalPage(String name) {
        super(name);
    }

    @Override
    public void navigate() {

    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public void waitPageReady(long timeoutInSeconds) {

    }

    @Override
    public void waitPageReady() {

    }
}
