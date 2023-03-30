package support.page_objects.pages.auth;

import com.ui.managers.Page;
import support.page_objects.components.patient_portal.auth.LoginAuth;
import support.page_objects.components.patient_portal.footer.PatientPortalFooter;
import support.page_objects.components.patient_portal.header.PatientPortalHeader;
import support.page_objects.pages.BasePage;

@Page
public class LoginPage extends BasePage {
    private String url = buildUrl(getConfigs().getProperty("PATIENT_PORTAL_URL"), "/auth/login", "?id=2037318");
    public final PatientPortalHeader patientPortalHeader = new PatientPortalHeader();
    public final LoginAuth loginAuth = new LoginAuth("//div[contains(@class,'login-auth')]");
    public final PatientPortalFooter patientPortalFooter = new PatientPortalFooter();
    public LoginPage(String name) {
        super(name);
    }

    @Override
    public void navigate() {
        open(url);
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
