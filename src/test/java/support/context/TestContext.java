package support.context;

import com.ui.managers.PageObjectManager;
import com.ui.managers.WebDriverFactory;
import lombok.Data;

@Data
public class TestContext {
    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;

    private final CredentialManager credentialManager;
    public TestContext(){
        WebDriverFactory.setUpDriver();
        pageObjectManager = new PageObjectManager("support.page_objects.pages");
        scenarioContext = new ScenarioContext();
        credentialManager = new CredentialManager();
    }

}