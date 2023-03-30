package step_definitions.ui;

import actions.PatientPortalActions;
import com.ui.managers.PageObjectManager;
import io.cucumber.java8.En;
import support.context.TestContext;

public class PatientPortalSteps implements En {
    public PatientPortalSteps(TestContext context){
        PageObjectManager pageObjectManager = context.getPageObjectManager();
        PatientPortalActions patientPortalActions = new PatientPortalActions(context);

        When("User logs in with credentials {string}", (String credentials) -> {
            patientPortalActions.login(context.getCredentialManager().getCredentials(credentials));
        });
    }
}
