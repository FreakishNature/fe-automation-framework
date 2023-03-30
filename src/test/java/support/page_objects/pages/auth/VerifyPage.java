package support.page_objects.pages.auth;

import com.ui.managers.Page;
import support.page_objects.components.patient_portal.auth.AuthVerify;
import support.page_objects.pages.BasePage;

@Page
public class VerifyPage extends BasePage {
    public AuthVerify authVerify = new AuthVerify("//div['auth social-auth']");

    public VerifyPage(String name) {
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
