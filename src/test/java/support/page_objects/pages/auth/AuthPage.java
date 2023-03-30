package support.page_objects.pages.auth;

import com.ui.managers.Page;
import support.page_objects.components.patient_portal.auth.SocialAuthLogin;
import support.page_objects.components.patient_portal.footer.PatientPortalFooter;
import support.page_objects.components.patient_portal.header.PatientPortalHeader;
import support.page_objects.pages.BasePage;

@Page
public class AuthPage extends BasePage {
    String url = this.buildUrl(getConfigs().getProperty("PATIENT_PORTAL_URL"),"/login?id=2037318");

    public final PatientPortalHeader patientPortalHeader = new PatientPortalHeader();
    public final SocialAuthLogin socialAuthLogin = new SocialAuthLogin("//div[contains(@class,'social-auth-login')]", "socialAuthLogin");

    public final PatientPortalFooter patientPortalFooter = new PatientPortalFooter();

    public AuthPage(String name) {
        super(name);
    }

    @Override
    public void navigate() {
        this.open(url);
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
